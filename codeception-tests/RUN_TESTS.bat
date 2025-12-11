@echo off
echo ========================================
echo Execution Tests Codeception
echo ========================================
echo.

echo Verification application Spring Boot...
netstat -ano | findstr :8080 >nul 2>&1
if %errorlevel% neq 0 (
    echo [ERREUR] Application Spring Boot n'est pas demarree!
    echo Demarrez l'application avec: .\mvnw spring-boot:run
    pause
    exit /b 1
)
echo [OK] Application Spring Boot en cours d'execution

echo.
echo Execution des tests...
echo.
vendor\bin\codecept run acceptance --steps

echo.
echo ========================================
echo Tests termines!
echo ========================================
pause
