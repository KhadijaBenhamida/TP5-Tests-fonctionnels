@echo off
echo ========================================
echo INSTALLATION AUTOMATIQUE CODECEPTION
echo ========================================
echo.

echo Etape 1: Installation PHP...
choco install php -y
if %errorlevel% neq 0 (
    echo [ERREUR] Installation PHP echouee
    echo Installez manuellement: https://windows.php.net/download/
    pause
    exit /b 1
)

echo.
echo Etape 2: Installation Composer...
choco install composer -y
if %errorlevel% neq 0 (
    echo [ERREUR] Installation Composer echouee
    pause
    exit /b 1
)

echo.
echo Etape 3: Rafraichir PATH...
refreshenv

echo.
echo Etape 4: Installation dependances Codeception...
cd codeception-tests
composer install
if %errorlevel% neq 0 (
    echo [ERREUR] Installation dependances echouee
    pause
    exit /b 1
)

echo.
echo Etape 5: Generation classes support...
vendor\bin\codecept build

echo.
echo ========================================
echo INSTALLATION TERMINEE!
echo ========================================
echo.
echo Pour lancer les tests:
echo   1. Demarrer Spring Boot: .\mvnw spring-boot:run
echo   2. Lancer tests: cd codeception-tests ^&^& RUN_TESTS.bat
echo.
pause
