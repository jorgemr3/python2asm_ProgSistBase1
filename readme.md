# Traductor de Python a Ensamblador x86_64

Este proyecto implementa un traductor que convierte un subconjunto del lenguaje Python a código ensamblador x86_64 para Linux. Utiliza ANTLR4 para el análisis sintáctico y genera código ensamblador optimizado, soportando:

- Expresiones aritméticas basicas (suma, resta, multiplicación, división)
- Expresiones unarias y potencias (por ejemplo, `-x`, `x**y`)
- Comparaciones (por ejemplo, `==`, `!=`, `<`, `>`, `<=`, `>=`)
- Asignaciones a variables
- Indentacion y dedentacion para bloques de código manejado por stacks
- Llamadas básicas a funciones (por ejemplo, `print`)
- Operadores logicos (`and`, `or`, `not`)
- Ciclos `for` iterando sobre rangos definidos con `range()`
- Ciclos `while` con condiciones
- Estructuras condicionales `if`, `elif`, `else`

---

## Información del Curso

**Programación de Sistemas Base 1**  

- **Universidad Autónoma de Tamaulipas**
- **Semestre:** Octavo semestre de 2025  
- **Profesor:** Muñoz Quintero Dante Adolfo  

---

## Desarrolladores

- **Melo Reséndiz Jorge**  
- **Guerrero Serrano Jafeth Oswaldo**
- **Paniagua Rico Juan Julián**

---

## Comandos relevantes

Si se llega a modificar el archivo de gramatica en `grammar\PythonSubset.g4`, ejecuta el siguiente comando para generar los archivos de parser y lexer con la nueva gramatica:

```bash
java -jar lib/antlr-4.13.2-complete.jar -Dlanguage=Java -visitor -package parser -o src/main/antlr4/parser grammar/PythonSubset.g4
```

Despues, se necesita compilar todo el proyecto:

```bash
javac -cp lib/antlr-4.13.2-complete.jar -d build `
  src\main\antlr4\parser\*.java `
  src\main\java\parser\*.java `
  src\main\java\codegen\*.java `
  src\main\java\parser\ast\*.java `
  src\main\java\util\*.java `
 ```

Para traducir un archivo `.py` a ensamblador:

```bash
java -cp "build;lib/antlr-4.13.2-complete.jar" parser.Main src/test/ejemplo.py > build/ejemplo.asm
```

Para ejecutar el TreeView para visualizar el árbol de parseo y arbol de sintaxis abstracta en GUI:
NOTA: Se necesita el proyecto totalmente recompilado con salida generada en la carpeta `build`.

Arbol de parseo:

```bash
java -cp "lib/*;build" util.TreeViewer src/test/ejemplo.py
```

Arbol de sintaxis abstracta:

```bash
java -cp "build;lib/*" util.ASTViewer src/test/ejemplo.py
```

## Documentacion: <https://deepwiki.com/jorgemr3/python2asm_ProgSistBase1>
