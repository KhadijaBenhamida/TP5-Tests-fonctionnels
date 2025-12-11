@echo off
echo ========================================
echo CORRECTION ET INSTALLATION CODECEPTION
echo ========================================
echo.

echo Etape 1: Suppression fichier verrouillage...
del /F /Q "C:\ProgramData\chocolatey\lib\f0d6f1557051ce6611446a465cdf274be78e7548" 2>nul
echo [OK] Fichier verrouillage supprime

echo.
echo Etape 2: Installation PHP...
choco install php -y --force
if %errorlevel% neq 0 (
    echo [ERREUR] Installation PHP echouee
    pause
    exit /b 1
)

echo.
echo Etape 3: Installation Composer...
choco install composer -y --force
if %errorlevel% neq 0 (
    echo [ERREUR] Installation Composer echouee
    pause
    exit /b 1
)

echo.
echo Etape 4: Rafraichir variables environnement...
call refreshenv

echo.
echo Etape 5: Installation dependances Codeception...
cd codeception-tests
call composer install
if %errorlevel% neq 0 (
    echo [ERREUR] Installation dependances echouee
    pause
    exit /b 1
)

echo.
echo Etape 6: Generation classes support...
call vendor\bin\codecept build

echo.
echo ========================================
echo INSTALLATION TERMINEE AVEC SUCCES!
echo ========================================
echo.
echo Pour lancer les tests:
echo   1. Terminal 1: .\mvnw spring-boot:run
echo   2. Terminal 2: cd codeception-tests ^&^& RUN_TESTS.bat
echo.
pause
