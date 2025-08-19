@echo off
echo Compilando proyecto Java...

if not exist "target\classes" mkdir "target\classes"

javac -cp "lib\gson-2.10.1.jar" -d "target\classes" src\main\java\com\alura\moneyexchange\*.java

copy "src\main\resources\config.properties" "target\classes\" >nul 2>&1

if %errorlevel% == 0 (
    echo Compilacion finalizada con exito.
    pause
) else (
    echo Compilacion fallida!
    pause
)