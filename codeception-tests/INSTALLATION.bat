@echo off
echo ========================================
echo Installation Codeception
echo ========================================
echo.

echo Etape 1: Verification PHP...
php --version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERREUR] PHP n'est pas installe!
    echo Installez PHP avec: choco install php
    pause
    exit /b 1
)
echo [OK] PHP installe

echo.
echo Etape 2: Verification Composer...
composer --version >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERREUR] Composer n'est pas installe!
    echo Installez Composer avec: choco install composer
    pause
    exit /b 1
)
echo [OK] Composer installe

echo.
echo Etape 3: Installation des dependances...
composer install
if %errorlevel% neq 0 (
    echo [ERREUR] Installation echouee!
    pause
    exit /b 1
)
echo [OK] Dependances installees

echo.
echo Etape 4: Generation des classes de support...
vendor\bin\codecept build
if %errorlevel% neq 0 (
    echo [ERREUR] Generation echouee!
    pause
    exit /b 1
)
echo [OK] Classes generees

echo.
echo ========================================
echo Installation terminee avec succes!
echo ========================================
echo.
echo Pour executer les tests:
echo   vendor\bin\codecept run acceptance
echo.
echo Pour voir les details:
echo   vendor\bin\codecept run acceptance --steps
echo.
pause
