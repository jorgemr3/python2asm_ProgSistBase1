# Traductor de Python a Ensamblador x86_64

Este proyecto implementa un traductor que convierte un subconjunto del lenguaje Python a código ensamblador x86_64 para Linux. Utiliza ANTLR4 para el análisis sintáctico y genera código ensamblador optimizado, soportando:

- Expresiones aritméticas
- Comparaciones
- Asignaciones
- Llamadas básicas a funciones (por ejemplo, `print`)

---

## Información del Curso

**Programación de Sistemas Base 1**  

- **Universidad Autónoma de Tamaulipas**
- **Semestre:** Octavo semestre de 2025  
- **Profesor:** Muñoz Quintero Dante Adolfo  

---

## Desarrolladores

- **Melo Reséndiz Jorge**  
<!-- - **Domínguez Reyes Pavel Noel**  
- **Aldama Trinidad Alfonso René**   -->

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
  src\main\java\parser\ast\*.java
 ```

Para traducir un archivo `.py` a ensamblador:

```bash
java -cp "build;lib/antlr-4.13.2-complete.jar" parser.Main src/test/ejemplo.py > build/ejemplo.asm
```

## Documentacion 
Documentacion: https://deepwiki.com/jorgemr3/python2asm_ProgSistBase1
