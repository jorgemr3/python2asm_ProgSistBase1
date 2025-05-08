# Traductor de Python a Ensamblador x86_64

Este proyecto implementa un traductor que convierte un subconjunto del lenguaje Python a código ensamblador x86_64 para Linux. Utiliza ANTLR4 para el análisis sintáctico y genera código ensamblador optimizado, soportando:

- Expresiones aritméticas
- Comparaciones
- Asignaciones
- Llamadas básicas a funciones (por ejemplo, `print`)

---

## Información del Curso

**Programación de Sistemas Base 1**  

- **Universidad:** Autónoma de Tamaulipas  
- **Semestre:** Octavo semestre de 2025  
- **Profesor:** Muñoz Quintero Dante Adolfo  

---

## Desarrolladores

- **Melo Reséndiz Jorge**  
- **Domínguez Reyes Pavel Noel**  
- **Aldama Trinidad Alfonso René**  

---

## Uso

Para traducir un archivo `.py` a ensamblador:

```bash
java -cp "build;lib/antlr-4.13.2-complete.jar" parser.Main src/test/ejemplo.py > build/ejemplo.asm
```
