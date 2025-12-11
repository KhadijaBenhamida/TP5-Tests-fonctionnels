# 🚀 DÉMARRAGE RAPIDE - TP5

## ⚡ Installation Automatique Codeception

### Option 1: Script Automatique (Recommandé)
```bash
INSTALL_CODECEPTION.bat
```

Ce script installe automatiquement:
- ✅ PHP 7.4+
- ✅ Composer
- ✅ Codeception + dépendances
- ✅ Classes de support

### Option 2: Installation Manuelle

**Étape 1: Installer Chocolatey (si pas installé)**
```powershell
# Ouvrir PowerShell en Admin
Set-ExecutionPolicy Bypass -Scope Process -Force
[System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072
iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
```

**Étape 2: Installer PHP et Composer**
```bash
choco install php composer -y
```

**Étape 3: Installer Codeception**
```bash
cd codeception-tests
composer install
vendor\bin\codecept build
```

---

## 🎬 Exécution des Tests

### Tests Selenium Java (Exercice 1)
```bash
# Terminal 1: Démarrer Spring Boot
.\mvnw spring-boot:run

# Terminal 2: Lancer tests
.\mvnw test -Dtest=TestsSeleniumPart1
```

### Tests Codeception PHP (Exercice 2)
```bash
# Terminal 1: Démarrer Spring Boot
.\mvnw spring-boot:run

# Terminal 2: Lancer tests
cd codeception-tests
RUN_TESTS.bat
```

---

## 📊 Résultats Attendus

### Selenium Java
```
Tests run: 4, Failures: 0, Errors: 0
✓ Test Listing réussi
✓ Test Ajout réussi
✓ Test Modification réussi
✓ Test Déconnexion réussi
BUILD SUCCESS
```

### Codeception PHP
```
Codeception PHP Testing Framework v5.0.0
✔ Test1_ListingCest: Test listing
✔ Test2_AjoutCest: Test ajout
✔ Test3_ModificationCest: Test modification
✔ Test4_DeconnexionCest: Test deconnexion
OK (4 tests, 8 assertions)
```

---

## 🐛 Dépannage Rapide

### Problème: Login échoue
```bash
.\restart-app.bat
```

### Problème: Port 8080 occupé
```bash
netstat -ano | findstr :8080
taskkill /F /PID <PID>
```

### Problème: PHP not found
```bash
choco install php -y
refreshenv
```

---

## 📚 Documentation Complète

- `README.md` - Documentation principale
- `EXERCICE2_CODECEPTION_GUIDE.md` - Guide Codeception
- `TP5_RESUME_COMPLET.md` - Résumé complet
- `codeception-tests/README.md` - Doc Codeception détaillée

---

**Repository:** https://github.com/KhadijaBenhamida/TP5-Tests-fonctionnels
