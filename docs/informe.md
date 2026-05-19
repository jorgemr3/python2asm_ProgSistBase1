# Informe del proyecto

## 1. Introduccion

Este proyecto implementa un traductor educativo que convierte un subconjunto de Python a ensamblador x86_64 para Linux. El flujo sigue el esquema clasico de compiladores: preprocesamiento de indentacion, analisis lexico y sintactico con ANTLR4, construccion de un AST y generacion de codigo ASM. El objetivo principal es demostrar conceptos de compiladores (lexer, parser, AST, visitor y codegen) con un alcance controlado.

## 2. Objetivos

### 2.1 General

Construir un compilador/traductor que procese un subconjunto de Python y genere codigo ensamblador x86_64 ejecutable en Linux, con una arquitectura clara y modular.

### 2.2 Especificos

- Definir una gramatica ANTLR para un subconjunto de Python con expresiones y control de flujo.
- Implementar preprocesamiento de indentacion para tokens `INDENT`/`DEDENT`.
- Construir un AST con patron Visitor y nodos tipados.
- Generar codigo ASM usando una estrategia basada en pila.
- Proveer ejemplos y pruebas para validar el comportamiento.

## 3. Especificacion del Lenguaje

### 3.1 Categorias de Token

- Palabras clave: `for`, `while`, `if`, `elif`, `else`, `in`, `and`, `or`, `not`, `True`, `False`.
- Identificadores: `IDENTIFIER` con letras, numeros y guion bajo.
- Literales: `INT` (enteros), `STRING` (comillas simples o dobles), booleanos.
- Operadores: `+`, `-`, `*`, `/`, `%`, `**`, `==`, `!=`, `<`, `>`, `<=`, `>=`.
- Delimitadores: `(`, `)`, `,`, `:`.
- Tokens de indentacion: `INDENT` y `DEDENT` insertados por el preprocesador.
- Separacion y comentarios: `NEWLINE`, `WS` y comentarios `#` (ignorados por el lexer).

### 3.2 Construcciones del Lenguaje

- Programa: una o mas sentencias.
- Sentencias simples: asignacion y expresiones como sentencia.
- Sentencias compuestas: `if/elif/else`, `while`, `for`.
- Expresiones: aritmeticas, comparaciones, logicas, unarias y potencia (con limitaciones en codegen).
- Llamadas a funciones: `identificador(expr, ...)` (solo `print` esta soportada en el analisis semantico).
- Iteracion: `for` con `range()`.

Limitaciones actuales relevantes:

- `range()` se parsea con 1, 2 o 3 argumentos, pero la generacion de codigo asume argumentos enteros literales.
- No hay definicion de funciones de usuario ni estructuras complejas (listas, diccionarios, etc.).
- Sin tipos flotantes ni asignacion compuesta.
- `**` esta en la gramatica, pero la generacion de ASM aun no lo implementa.

## 4. Arquitectura del Compilador

La arquitectura se organiza en fases:

1. **Preprocesamiento**: convierte indentacion en `INDENT`/`DEDENT`.
2. **Lexer/Parser (ANTLR4)**: tokeniza y produce el parse tree.
3. **AST**: `ASTBuilder` transforma el parse tree en un AST con nodos como `ProgNode`, `AssignNode`, `ExprStmtNode`, `IfNode`, `ForNode`, `WhileNode` y `BinaryOpNode`.
4. **Analisis Semantico**: `SemanticAnalyzer` valida tipos y reglas basicas.
5. **Codegen**: `CodeGenerator` recorre el AST con Visitor y genera ASM x86_64.

El backend usa una evaluacion basada en pila, almacena variables en offsets relativos a `rbp` y emite etiquetas para control de flujo.

## 5. Implementacion

### 5.1 Parser y Construccion del AST

- El lexer y parser son generados por ANTLR4 desde `PythonSubset.g4`.
- `ASTBuilder` implementa el visitor de ANTLR y crea un AST limpio.
- `ASTPrinter` permite inspeccionar el AST en modo debug.

### 5.2 Analisis Semantico y Tabla de Simbolos

Se incluye una fase de analisis semantico previa al codegen (`SemanticAnalyzer`):

- Registra variables definidas y tipos inferidos.
- Valida operaciones aritmeticas con INT, logicas con BOOL y comparaciones compatibles.
- Acepta condiciones BOOL o INT en `if`/`while`.
- Restringe `range()` a enteros literales (1 a 3 argumentos).
- Solo permite `print()` con un argumento y rechaza otras funciones.

El `CodeGenerator` mantiene `varOffsets` para ubicar variables en el stack durante la generacion de ASM.

### 5.3 Interprete / Generacion de Codigo

- No hay interprete; la salida es ASM x86_64.
- La generacion es de dos pasadas: recoleccion de strings y generacion de secciones `.data` y `.text`.
- Se generan etiquetas para `if/elif/else`, `while` y `for`.
- Las expresiones se evalua con `push`/`pop` y registros temporales (`rax`, `rbx`).

### 5.4 Manejo Unificado de Errores

El manejo de errores es basico y no unificado:

- ANTLR reporta errores lexicos/sintacticos con mensajes estandar.
- `PythonIndentPreprocessor` detecta errores de indentacion.
- `SemanticAnalyzer` reporta errores de tipos/uso con prefijo `[SEMANTIC]`.
- `CodeGenerator` lanza excepciones en casos como variable no definida o iterable no soportado.

## 6. Demostracion Funcional

### 6.1 Ejecucion con programa valido completo

Ejemplo (archivo `tests/valid/test_if_elif.py`):

```python
x = 10
if x > 5:
    print("x es mayor que 5")
    y = 20
elif x > 3:
    print("x es mayor que 3")
else:
    print("x es menor o igual a 3")

z = 15
if z == 15:
    print("z es 15")
```

Compilacion (Windows):

```bash
java -cp "build;lib/antlr-4.13.2-complete.jar" parser.Main tests/valid/test_if_elif.py > build/ejemplo.asm
```

### 6.2 Errores sintacticos detectados

Ejemplo de error:

```python
if x > 5
    print(x)
```

ANTLR reporta errores de sintaxis del tipo `mismatched input ... expecting ...` cuando faltan tokens obligatorios como `:` o cuando la estructura no coincide con la gramatica.

### 6.3 Errores semanticos y de tipo

Ejemplo de variable no definida:

```python
print(y)
```

Durante el analisis semantico se reporta un error del tipo `[SEMANTIC] Variable no definida: y`. Tambien se detectan incompatibilidades de tipos (por ejemplo, sumar BOOL con INT o usar `range` con variables).

### 6.4 Salida generada

La salida es ASM x86_64 con seccion de datos y texto. Un fragmento tipico es:

```asm
section .data
str12345: db "x es mayor que 5", 0x0A, 0

section .text
global _start

_start:
    mov rbp, rsp
    ; ... codigo del if/elif/else ...

_start_end:
    mov rax, 60
    mov rdi, 0
    syscall
```

El archivo completo se escribe en `build/ejemplo.asm` cuando se redirige la salida estandar.

## 7. Conclusiones

El proyecto cumple el objetivo de traducir un subconjunto de Python a ASM x86_64 con una arquitectura didactica y clara. Se implementan estructuras de control, expresiones y manejo de indentacion, demostrando el flujo completo de un compilador. Como mejoras futuras, se recomienda ampliar el analisis semantico (scoping y mejores mensajes), completar la implementacion de `**`, permitir `range()` con expresiones, agregar short-circuit en logicos y ampliar el lenguaje (funciones de usuario, listas, tipos adicionales y optimizaciones).
