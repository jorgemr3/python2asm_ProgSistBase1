# Manual de Usuario - Compilador Python to x86_64

## Guía de Instalación

### Requisitos del Sistema

- **Java**: JDK 8 o superior
- **ANTLR 4.13.2**: Para regeneración de parsers (opcional)
- **Sistema Operativo**: Windows/Linux/macOS para compilar; ejecución del ASM requiere Linux o WSL
- **Ensamblador**: NASM (para ensamblar el código generado)
- **Enlazador**: GCC o similar (para crear ejecutables)

### Instalación Paso a Paso

1. **Clonar o descargar el proyecto**

   ```bash
   git clone <repository-url>
   cd python2asm_ProgSistBase1
   ```

2. **Compilar el proyecto**

   ```bash
   # En directorio raíz
   javac -cp "lib/*" src/main/java/**/*.java -d build/
   ```

3. **Verificar instalación**

    ```bash
    java -cp "build:lib/*" parser.Main tests/valid/test_for_sum.py
    ```

## Uso del Compilador

### Sintaxis del Comando

```bash
java -cp "build:lib/*" parser.Main <archivo_python>
```

**Windows PowerShell (guardar salida en UTF-8):**

```bash
java -cp "build;lib/antlr-4.13.2-complete.jar" parser.Main <archivo_python> | Set-Content build/ejemplo.asm -Encoding utf8
```

Nota: en PowerShell, `>` genera salida UTF-16 y puede romper NASM. Usa `Set-Content -Encoding utf8`.

### Ejemplos de Uso

#### Ejemplo 1: Programa Simple

```python
# archivo: test_simple.py
x = 10
y = 20
print(x + y)
```

**Compilación:**

```bash
java -cp "build:lib/*" parser.Main test_simple.py
```

**Resultado:** Genera `ejemplo.asm` en el directorio `build/`

#### Ejemplo 2: Ciclo For

```python
# archivo: test_for.py
for i in range(3):
    print(i)
print("Fin del ciclo for")
```

**Código generado:**

```asm
section .data
    ; ... strings literales ...

section .text
    ; ... código del ciclo ...
```

#### Ejemplo 3: Ciclo While

```python
# archivo: test_while.py
contador = 0
while contador < 5:
    print(contador)
    contador = contador + 1
```

### Ejecución del Código Generado

1. **Ensamblar**

   ```bash
   nasm -f elf64 build/ejemplo.asm -o build/ejemplo.o
   ```

2. **Enlazar**

   ```bash
   gcc build/ejemplo.o -o build/programa -lc
   ```

3. **Ejecutar**

   ```bash
   ./build/programa
   ```

## Sintaxis Soportada

### Variables y Asignaciones

```python
# Tipos soportados
x = 42          # Enteros
mensaje = "Hola" # Strings
activo = True   # Booleanos
inactivo = False

# Asignaciones
variable = expresion
```

### Expresiones Aritméticas

```python
# Operadores soportados
suma = a + b
resta = a - b
multiplicacion = a * b
division = a / b
modulo = a % b

# Precedencia respetada
resultado = 2 + 3 * 4  # = 14

# La división es entera (idiv)
```

### Expresiones Lógicas

```python
# Operadores de comparación
mayor = a > b
menor = a < b
mayor_igual = a >= b
menor_igual = a <= b
igual = a == b
diferente = a != b

# Operadores lógicos (completamente implementados)
y_logico = True and False  # False
o_logico = True or False   # True
negacion = not True        # False

# Expresiones complejas
resultado = (x > 5) and (y < 10) or (z == 0)
complejo = not (a == b) and (c != d)
```

### Estructuras de Control

#### Ciclo For

```python
# Sintaxis básica
for variable in range(numero):
    # cuerpo del ciclo
    instrucciones...

# Ejemplo
for i in range(10):
    print(i)
    x = i * 2

# También se permite range(start, stop, step) con enteros literales
for i in range(1, 10, 2):
    print(i)
```

#### Ciclo While

```python
# Sintaxis básica
while condicion:
    # cuerpo del ciclo
    instrucciones...

# Ejemplo
contador = 0
while contador < 5:
    print(contador)
    contador = contador + 1
```

#### Condicionales If/Elif/Else

```python
# Sintaxis básica
if condicion:
    # cuerpo del if
    instrucciones...
elif otra_condicion:
    # cuerpo del elif
    instrucciones...
else:
    # cuerpo del else
    instrucciones...

# Ejemplo simple
x = 10
if x > 15:
    print("Mayor que 15")
elif x > 5:
    print("Mayor que 5")
else:
    print("5 o menor")

# Condicionales anidados
if x > 0:
    if x < 10:
        print("Entre 0 y 10")
    else:
        print("Mayor o igual a 10")
else:
    print("Menor o igual a 0")
```

### Llamadas a Funciones

```python
# Función print soportada
print(variable)
print("string literal")
print(expresion_aritmetica)

# Otras funciones no están soportadas y generan error semántico

# Función range solo se usa como iterable en for
for i in range(5):
    print(i)
```

## Limitaciones Actuales

### Características No Soportadas

- **Funciones definidas por usuario**: Solo `print()` está soportada
- **Listas y estructuras de datos**: Solo variables escalares (int, string, bool)
- **Import statements**: Sin soporte para módulos
- **Range con argumentos**: Solo se acepta en ciclos `for` y con enteros literales
- **Tipos float/decimal**: Solo enteros, strings y booleanos
- **Operaciones sobre strings**: No se pueden concatenar o manipular strings
- **Asignación compuesta**: No soporta `+=`, `-=`, `*=`, etc.
- **Slicing**: No se pueden hacer operaciones de slicing
- **Potencia `**`**: Está parseada, pero la generación de ASM no la implementa
- **Lógicos**: `and`/`or` evalúan ambos operandos (sin short-circuit)

### Restricciones de Sintaxis

- **Indentación**: Debe ser consistente (4 espacios o tabs, no mezclar)
- **Nombres de variables**: Solo letras, números y underscore (no pueden empezar con número)
- **Strings**: Comillas dobles o simples (`"texto"` o `'texto'`)
- **Comentarios**: Soportados con `#` pero son ignorados por el compilador
- **Print**: Solo acepta un argumento a la vez
- **Range**: Solo acepta 1, 2 o 3 enteros literales en ciclos `for`

## Solución de Problemas

### Errores Comunes

#### Error de Indentación

```
Error: Token recognition error at: '    '
```

**Solución**: Verificar que la indentación sea consistente

#### Error de Sintaxis

```
Error: mismatched input 'palabra' expecting {...}
```

**Solución**: Revisar que la sintaxis coincida con la gramática soportada

#### Error de Compilación Java

```
Exception in thread "main" java.lang.ClassNotFoundException
```

**Solución**: Verificar el classpath incluya `lib/*` y `build/`

#### Error Semántico

```
[SEMANTIC] Variable no definida: y
```

**Solución**: Revisar variables no declaradas o tipos incompatibles

### Archivos de Prueba Incluidos

| Archivo | Propósito | Descripción |
|---------|-----------|-------------|
| `tests/valid/test_for_sum.py` | Prueba básica | Suma en for con range |
| `tests/valid/test_if.py` | Condicionales | If simple |
| `tests/valid/test_if_elif.py` | Condicionales | If/elif/else |
| `tests/valid/test_logical.py` | Operadores lógicos | and, or, not |
| `tests/valid/test_while_indent.py` | Ciclo while | While con indentación |
| `tests/invalid/semantic_undefined_var.py` | Error semántico | Variable no definida |

Para ejecutar todos los tests:

```bash
python tests/test_runner.py
```

### Depuración

#### Habilitar Modo Verbose

Modifica `Main.java` para agregar:

```java
System.out.println("AST: " + program.toString());
System.out.println("Generated ASM saved to: " + outputPath);
```

#### Inspeccionar AST Generado

Usa `ASTPrinter` para visualizar el árbol:

```java
ASTPrinter printer = new ASTPrinter();
program.accept(printer);
```

## Ejemplos Completos

### Programa de Suma Acumulativa

```python
# suma_acumulativa.py
total = 0
for i in range(10):
    total = total + i
print(total)
```

### Contador con While

```python
# contador.py
numero = 1
while numero <= 5:
    print("Contador:")
    print(numero)
    numero = numero + 1
print("Terminado")
```

### Operaciones Lógicas

```python
# logica.py
a = True
b = False
resultado1 = a and b
resultado2 = a or b
print(resultado1)  # False
print(resultado2)  # True
```

## Próximos Pasos

Después de usar exitosamente el compilador:

1. **Examinar código ASM**: Revisar `build/ejemplo.asm` generado
2. **Ejecutar programa**: Seguir pasos de ensamblado y enlazado
3. **Experimentar**: Probar diferentes construcciones sintácticas
4. **Contribuir**: Ver `development.md` para extender funcionalidad
