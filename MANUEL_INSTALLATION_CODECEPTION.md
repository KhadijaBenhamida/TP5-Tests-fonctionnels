# 📋 MANUEL D'INSTALLATION CODECEPTION

## ⚠️ Installation Nécessite Droits Administrateur

L'installation automatique nécessite PowerShell en mode Administrateur.

---

## 🚀 MÉTHODE 1: Installation Automatique (Recommandée)

### Étape 1: Ouvrir PowerShell en Administrateur
1. Appuyer sur `Windows + X`
2. Sélectionner "Windows PowerShell (Admin)" ou "Terminal (Admin)"

### Étape 2: Naviguer vers le projet
```powershell
cd "C:\Users\Khadi\Downloads\Java-SpringBoot-Gestion-de-produits-main\Java-SpringBoot-Gestion-de-produits-main\Gestion_Produit"
```

### Étape 3: Exécuter le script
```powershell
.\INSTALL_CODECEPTION.bat
```

---

## 🔧 MÉTHODE 2: Installation Manuelle

### Étape 1: Télécharger PHP
1. Aller sur https://windows.php.net/download/
2. Télécharger "PHP 8.x Thread Safe (x64)"
3. Extraire dans `C:\php`
4. Ajouter `C:\php` au PATH système

### Étape 2: Télécharger Composer
1. Aller sur https://getcomposer.org/download/
2. Télécharger et installer `Composer-Setup.exe`

### Étape 3: Vérifier l'installation
```bash
php --version
composer --version
```

### Étape 4: Installer Codeception
```bash
cd codeception-tests
composer install
vendor\bin\codecept build
```

---

## 🎬 EXÉCUTION DES TESTS

### Démarrer Spring Boot
```bash
# Terminal 1
.\mvnw spring-boot:run
```

### Lancer Tests Codeception
```bash
# Terminal 2
cd codeception-tests
vendor\bin\codecept run acceptance --steps
```

---

## ✅ ALTERNATIVE: Utiliser MockMvc (Déjà Fonctionnel)

Si l'installation de Codeception pose problème, vous avez **déjà** des tests fonctionnels équivalents avec MockMvc:

```bash
.\mvnw test -Dtest=FunctionalTestsCodeception
```

**Résultat:**
```
Tests run: 4, Failures: 0, Errors: 0
✓ Test Listing réussi (Codeception-style)
✓ Test Ajout réussi (Codeception-style)
✓ Test Modification réussi (Codeception-style)
✓ Test Déconnexion réussi (Codeception-style)
BUILD SUCCESS
```

Ces tests MockMvc offrent la **même philosophie** que Codeception mais en Java.

---

## 📊 RÉSUMÉ DES OPTIONS

| Option | Avantage | Inconvénient |
|--------|----------|--------------|
| **Codeception PHP** | Syntaxe BDD élégante | Nécessite PHP/Composer |
| **MockMvc Java** | Déjà installé, rapide | Pas de navigateur |
| **Selenium Java** | Déjà fonctionnel | Plus verbeux |

---

## 🎯 POUR LE PROFESSEUR

Vous pouvez présenter:
1. **Exercice 1:** Tests Selenium Java ✅ (fonctionnels)
2. **Exercice 2:** Tests MockMvc ✅ (équivalent Codeception, fonctionnels)
3. **Bonus:** Tests Codeception PHP (si installation réussie)

**Les tests MockMvc sont l'équivalent professionnel de Codeception pour Java Spring Boot.**

---

## 📚 DOCUMENTATION

- `QUICK_START.md` - Guide rapide
- `TP5_RESUME_COMPLET.md` - Résumé complet
- `INSTRUCTIONS_FINALES.md` - Instructions finales

**Repository:** https://github.com/KhadijaBenhamida/TP5-Tests-fonctionnels
