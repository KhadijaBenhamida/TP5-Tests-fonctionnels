@echo off
echo ========================================
echo   Gestion de Produits - Spring Boot
echo ========================================
echo.

REM Check if MySQL is running
echo [1/4] Verification de MySQL...
netstat -an | find "3306" >nul
if %errorlevel% neq 0 (
    echo [ERREUR] MySQL n'est pas demarre sur le port 3306
    echo Veuillez demarrer MySQL via XAMPP/WAMP ou le service MySQL
    pause
    exit /b 1
)
echo [OK] MySQL est en cours d'execution

echo.
echo [2/4] Verification du fichier .env...
if not exist ".env" (
    echo [AVERTISSEMENT] Fichier .env manquant, creation...
    echo ADMIN_PASSWORD=admin123 > .env
    echo [OK] Fichier .env cree avec mot de passe par defaut: admin123
) else (
    echo [OK] Fichier .env existe
)

echo.
echo [3/4] Compilation du projet...
call mvnw.cmd clean package -DskipTests
if %errorlevel% neq 0 (
    echo [ERREUR] La compilation a echoue
    pause
    exit /b 1
)
echo [OK] Compilation reussie

echo.
echo [4/4] Demarrage de l'application...
echo.
echo ========================================
echo   Application demarree!
echo   URL: http://localhost:8080
echo   Admin: Charbel / admin123
echo ========================================
echo.

call mvnw.cmd spring-boot:run
