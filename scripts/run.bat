@echo off
setlocal

set INPUT=src\test\ejemplo.py
set OUTPUT=build\ejemplo.asm
set ANTLR_JAR=lib\antlr-4.13.2-complete.jar

echo 🛠  Regenerando parser con ANTLR...
java -jar %ANTLR_JAR% -Dlanguage=Java -visitor -package parser -o src\main\antlr4\parser grammar\PythonSubset.g4

if %errorlevel% neq 0 (
    echo ❌ Error al generar el parser.
    exit /b 1
)

echo 📦 Compilando el proyecto...
javac -cp %ANTLR_JAR% -d build ^
    src\main\antlr4\parser\*.java ^
    src\main\java\parser\*.java ^
    src\main\java\codegen\*.java ^
    src\main\java\parser\ast\*.java

if %errorlevel% neq 0 (
    echo ❌ Error de compilación.
    exit /b 1
)

echo 🚀 Ejecutando traductor sobre: %INPUT%
java -cp "build;%ANTLR_JAR%" parser.Main %INPUT% > %OUTPUT%

if %errorlevel% neq 0 (
    echo ❌ Error en la ejecución.
    exit /b 1
)

echo ✅ Ensamblador generado en: %OUTPUT%
echo.
type %OUTPUT%

endlocal
pause
