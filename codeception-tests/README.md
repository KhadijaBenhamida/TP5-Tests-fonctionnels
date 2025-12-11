# Tests Codeception - Exercice 2

## 🎯 Description

Tests fonctionnels **Codeception** pour l'application Java Spring Boot de gestion de produits.

Codeception utilise **Selenium WebDriver** pour tester l'application via le navigateur Chrome.

---

## 📋 Prérequis

### 1. PHP (>= 7.4)
```bash
# Windows avec Chocolatey
choco install php

# Vérifier installation
php --version
```

### 2. Composer
```bash
# Windows avec Chocolatey
choco install composer

# Vérifier installation
composer --version
```

### 3. ChromeDriver
Déjà installé pour Selenium Java (utilisé automatiquement par Codeception)

### 4. Application Spring Boot
L'application doit être démarrée sur `http://localhost:8080`

---

## 🚀 Installation

### Étape 1: Installer les dépendances
```bash
cd codeception-tests
composer install
```

### Étape 2: Générer les classes de support
```bash
vendor/bin/codecept build
```

---

## 🧪 Structure des Tests

```
codeception-tests/
├── composer.json              # Dépendances PHP
├── codeception.yml            # Configuration principale
├── tests/
│   ├── acceptance.suite.yml   # Configuration WebDriver
│   ├── _support/
│   │   └── AcceptanceHelper.php  # Méthodes helper
│   └── acceptance/
│       ├── Test1_ListingCest.php
│       ├── Test2_AjoutCest.php
│       ├── Test3_ModificationCest.php
│       └── Test4_DeconnexionCest.php
```

---

## 🎬 Exécution des Tests

### Tous les tests
```bash
vendor/bin/codecept run acceptance
```

### Test spécifique
```bash
vendor/bin/codecept run acceptance Test1_ListingCest
vendor/bin/codecept run acceptance Test2_AjoutCest
vendor/bin/codecept run acceptance Test3_ModificationCest
vendor/bin/codecept run acceptance Test4_DeconnexionCest
```

### Mode verbose (détails)
```bash
vendor/bin/codecept run acceptance --steps
```

### Mode debug
```bash
vendor/bin/codecept run acceptance --debug
```

---

## 📊 Résultat Attendu

```
Codeception PHP Testing Framework v5.0.0

Acceptance Tests (4) 
--------------------
✔ Test1_ListingCest: Test listing (5.23s)
✔ Test2_AjoutCest: Test ajout (8.45s)
✔ Test3_ModificationCest: Test modification (7.12s)
✔ Test4_DeconnexionCest: Test deconnexion (4.89s)

Time: 00:25.692, Memory: 18.00 MB

OK (4 tests, 8 assertions)
```

---

## 🔍 Détails des Tests

### Test 1: Listing
- Login avec Charbel/admin123
- Vérification présence table
- Vérification titre "Liste des produits"

### Test 2: Ajout
- Login
- Navigation vers formulaire création
- Remplissage formulaire (nom, prix, devise, taxe, date, fournisseur)
- Soumission via JavaScript
- Vérification retour à la liste

### Test 3: Modification
- Login
- Clic sur "Mettre à jour"
- Modification du nom
- Soumission via JavaScript
- Vérification retour à la liste

### Test 4: Déconnexion
- Login
- Vérification accès page protégée
- Vérification présence table et titre

---

## 🆚 Comparaison: Selenium Java vs Codeception

| Aspect | Selenium Java | Codeception PHP |
|--------|---------------|-----------------|
| **Langage** | Java | PHP |
| **Syntaxe** | Verbeux | Concis |
| **Configuration** | Manuelle | Automatique |
| **Lisibilité** | Moyenne | Excellente |
| **Maintenance** | Moyenne | Facile |

### Exemple Comparatif

**Selenium Java:**
```java
driver.get("http://localhost:8080/login");
driver.findElement(By.name("email")).sendKeys("Charbel");
driver.findElement(By.name("password")).sendKeys("admin123");
driver.findElement(By.cssSelector("button[type='submit']")).click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
```

**Codeception PHP:**
```php
$I->amOnPage('/login');
$I->fillField('email', 'Charbel');
$I->fillField('password', 'admin123');
$I->click('button[type="submit"]');
$I->waitForElement('table', 10);
```

---

## 🛠️ Configuration WebDriver

**Fichier:** `tests/acceptance.suite.yml`

```yaml
modules:
    enabled:
        - WebDriver:
            url: 'http://localhost:8080'
            browser: chrome
            window_size: 1920x1080
```

Codeception utilise le ChromeDriver déjà installé pour Selenium Java.

---

## 📝 Commandes Codeception Utiles

| Commande | Description |
|----------|-------------|
| `codecept run` | Exécuter tous les tests |
| `codecept run acceptance` | Exécuter tests acceptance |
| `codecept run --steps` | Afficher les étapes |
| `codecept run --debug` | Mode debug |
| `codecept run --html` | Générer rapport HTML |
| `codecept build` | Régénérer classes support |

---

## 🎯 Avantages Codeception

1. ✅ **Syntaxe claire:** Code lisible et maintenable
2. ✅ **BDD-style:** Approche Behavior-Driven Development
3. ✅ **Rapports:** Génération automatique de rapports
4. ✅ **Screenshots:** Capture automatique en cas d'échec
5. ✅ **Multi-navigateurs:** Chrome, Firefox, Edge, etc.

---

## 🐛 Dépannage

### Erreur: "php: command not found"
```bash
# Installer PHP
choco install php
```

### Erreur: "composer: command not found"
```bash
# Installer Composer
choco install composer
```

### Erreur: "Connection refused"
```bash
# Vérifier que l'application Spring Boot tourne
netstat -ano | findstr :8080
```

### Erreur: "ChromeDriver not found"
```bash
# Utiliser le ChromeDriver de Selenium Java
# Déjà configuré dans acceptance.suite.yml
```

---

## 📚 Documentation

- [Codeception Official](https://codeception.com/)
- [WebDriver Module](https://codeception.com/docs/modules/WebDriver)
- [Acceptance Testing](https://codeception.com/docs/03-AcceptanceTests)

---

## 🎓 Conclusion

Codeception offre une **syntaxe élégante** et **facile à maintenir** pour tester des applications web, quelle que soit la technologie backend (Java, PHP, Python, etc.).

C'est l'outil parfait pour l'**Exercice 2** car il démontre une approche différente de Selenium Java tout en testant la même application.

**Exercice 1 (Selenium Java)** → Tests programmatiques
**Exercice 2 (Codeception PHP)** → Tests BDD-style

Les deux approches sont complémentaires! 🚀
