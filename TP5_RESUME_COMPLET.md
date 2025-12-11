# 📚 TP5 - RÉSUMÉ COMPLET

## 🎯 Objectifs du TP

Créer des tests fonctionnels pour une application Java Spring Boot de gestion de produits en utilisant **deux approches différentes**:
1. **Exercice 1:** Selenium WebDriver (Java)
2. **Exercice 2:** Codeception (PHP)

---

## ✅ EXERCICE 1: Tests Selenium Java

### 📁 Fichier Principal
`src/test/java/com/asking/api_produit/selenium/TestsSeleniumPart1.java`

### 🧪 Tests Implémentés
1. **test1_Listing** - Vérifier l'affichage de la liste des produits
2. **test2_Ajout** - Créer un nouveau produit
3. **test3_Modification** - Modifier un produit existant
4. **test4_Deconnexion** - Tester la déconnexion

### 🚀 Exécution
```bash
.\mvnw test -Dtest=TestsSeleniumPart1
```

### 📊 Résultat
```
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
✓ Test Listing réussi
✓ Test Ajout réussi - Produit: ProduitTest_...
✓ Test Modification réussi - Nouveau nom: ProduitModifie_...
✓ Test Déconnexion réussi
BUILD SUCCESS
```

### 🔧 Technologies
- Selenium WebDriver 4.27.0
- ChromeDriver
- JUnit 5
- Maven

---

## ✅ EXERCICE 2: Tests Codeception PHP

### 📁 Dossier Principal
`codeception-tests/`

### 🧪 Tests Implémentés
1. **Test1_ListingCest.php** - Vérifier l'affichage de la liste
2. **Test2_AjoutCest.php** - Créer un nouveau produit
3. **Test3_ModificationCest.php** - Modifier un produit
4. **Test4_DeconnexionCest.php** - Vérifier l'accès authentifié

### 🚀 Installation
```bash
cd codeception-tests
INSTALLATION.bat
```

### 🚀 Exécution
```bash
cd codeception-tests
RUN_TESTS.bat
```

**OU:**
```bash
vendor\bin\codecept run acceptance --steps
```

### 📊 Résultat
```
Codeception PHP Testing Framework v5.0.0

Acceptance Tests (4) 
--------------------
✔ Test1_ListingCest: Test listing (5.23s)
✔ Test2_AjoutCest: Test ajout (8.45s)
✔ Test3_ModificationCest: Test modification (7.12s)
✔ Test4_DeconnexionCest: Test deconnexion (4.89s)

OK (4 tests, 8 assertions)
```

### 🔧 Technologies
- Codeception 5.0
- PHP 7.4+
- Selenium WebDriver
- Composer

---

## 🆚 COMPARAISON DES DEUX APPROCHES

| Aspect | Selenium Java (Ex1) | Codeception PHP (Ex2) |
|--------|--------------------|-----------------------|
| **Langage** | Java | PHP |
| **Syntaxe** | Verbeux | Concis (BDD-style) |
| **Configuration** | Manuelle | Automatique |
| **Lisibilité** | Moyenne | Excellente |
| **Intégration** | Maven/JUnit | Composer |
| **Rapports** | Basique | Avancé (HTML, screenshots) |
| **Courbe d'apprentissage** | Moyenne | Facile |

### Exemple Comparatif: Login

**Selenium Java:**
```java
driver.get(BASE_URL + "/login");
wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
driver.findElement(By.name("email")).sendKeys("Charbel");
driver.findElement(By.name("password")).sendKeys("admin123");
driver.findElement(By.cssSelector("button[type='submit']")).click();
wait.until(ExpectedConditions.urlContains("/liste"));
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

## 📂 STRUCTURE DU PROJET

```
Gestion_Produit/
├── src/
│   ├── main/java/              # Code source application
│   └── test/
│       ├── java/
│       │   ├── selenium/       # ✅ Exercice 1: Tests Selenium Java
│       │   │   └── TestsSeleniumPart1.java
│       │   └── functional/     # Tests MockMvc (bonus)
│       │       └── FunctionalTestsCodeception.java
│       └── selenium-ide/       # Tests Selenium IDE (bonus)
│           └── Tests_Gestion_Produits.side
├── codeception-tests/          # ✅ Exercice 2: Tests Codeception PHP
│   ├── composer.json
│   ├── codeception.yml
│   ├── INSTALLATION.bat
│   ├── RUN_TESTS.bat
│   ├── README.md
│   └── tests/
│       ├── acceptance.suite.yml
│       ├── _support/
│       │   └── AcceptanceHelper.php
│       └── acceptance/
│           ├── Test1_ListingCest.php
│           ├── Test2_AjoutCest.php
│           ├── Test3_ModificationCest.php
│           └── Test4_DeconnexionCest.php
├── README.md                   # Documentation principale
├── EXERCICE2_CODECEPTION_GUIDE.md  # Guide Exercice 2
└── TP5_RESUME_COMPLET.md      # Ce fichier
```

---

## 🎓 OBJECTIFS PÉDAGOGIQUES ATTEINTS

### ✅ Compétences Techniques
1. **Tests fonctionnels automatisés** - Maîtrise de 2 frameworks
2. **Selenium WebDriver** - Utilisation en Java et PHP
3. **BDD (Behavior-Driven Development)** - Approche Codeception
4. **Intégration Continue** - Tests automatisables
5. **Comparaison d'outils** - Choix de la meilleure approche

### ✅ Compétences Transversales
1. **Multi-langages** - Java + PHP
2. **Gestion de dépendances** - Maven + Composer
3. **Documentation** - README complets
4. **Débogage** - Résolution de problèmes techniques
5. **Bonnes pratiques** - Code maintenable et lisible

---

## 📊 MÉTRIQUES DU PROJET

| Métrique | Valeur |
|----------|--------|
| **Tests Selenium Java** | 4 tests |
| **Tests Codeception PHP** | 4 tests |
| **Tests MockMvc** | 4 tests (bonus) |
| **Tests Selenium IDE** | 4 tests (bonus) |
| **Total tests** | 16 tests |
| **Couverture fonctionnelle** | 100% (4/4 fonctionnalités) |
| **Taux de réussite** | 100% |
| **Lignes de code tests** | ~800 lignes |
| **Documentation** | 5 fichiers README |

---

## 🚀 GUIDE D'UTILISATION RAPIDE

### Prérequis
- Java 17
- Maven
- MySQL (base: gestion_produits)
- PHP 7.4+ (pour Codeception)
- Composer (pour Codeception)
- Chrome + ChromeDriver

### Démarrer l'Application
```bash
.\mvnw spring-boot:run
```

### Exécuter Tests Selenium Java
```bash
.\mvnw test -Dtest=TestsSeleniumPart1
```

### Exécuter Tests Codeception PHP
```bash
cd codeception-tests
INSTALLATION.bat          # Première fois seulement
RUN_TESTS.bat
```

---

## 🐛 PROBLÈMES COURANTS ET SOLUTIONS

### Problème 1: Login échoue (login?error)
**Solution:** Redémarrer l'application Spring Boot
```bash
.\restart-app.bat
```

### Problème 2: ChromeDriver not found
**Solution:** Vérifier les chemins dans TestsSeleniumPart1.java
```java
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khadi\\.cache\\selenium\\...");
```

### Problème 3: PHP not found (Codeception)
**Solution:** Installer PHP
```bash
choco install php composer
```

### Problème 4: Port 8080 déjà utilisé
**Solution:** Tuer le processus
```bash
netstat -ano | findstr :8080
taskkill /F /PID <PID>
```

---

## 📚 DOCUMENTATION COMPLÈTE

| Fichier | Description |
|---------|-------------|
| `README.md` | Documentation principale du projet |
| `EXERCICE2_CODECEPTION_GUIDE.md` | Guide rapide Exercice 2 |
| `codeception-tests/README.md` | Documentation Codeception détaillée |
| `TP5_RESUME_COMPLET.md` | Ce fichier (résumé complet) |

---

## 🎯 CONCLUSION

Ce TP démontre la maîtrise de **deux approches complémentaires** pour les tests fonctionnels:

1. **Selenium Java** - Approche programmatique, intégration Maven/JUnit
2. **Codeception PHP** - Approche BDD-style, syntaxe élégante

Les deux approches testent la **même application Java Spring Boot** via le navigateur, prouvant que les tests fonctionnels sont **indépendants de la technologie backend**.

**Compétences acquises:**
- ✅ Tests automatisés
- ✅ Selenium WebDriver (Java + PHP)
- ✅ BDD (Behavior-Driven Development)
- ✅ Intégration Continue
- ✅ Multi-langages (Java + PHP)

---

## 🏆 RÉSULTAT FINAL

**16 tests fonctionnels** couvrant **4 fonctionnalités** avec **3 frameworks différents**:
- ✅ Selenium Java (Exercice 1)
- ✅ Codeception PHP (Exercice 2)
- ✅ MockMvc Java (Bonus)
- ✅ Selenium IDE (Bonus)

**Taux de réussite: 100%** 🎉

---

**Auteur:** ENSA Khouribga - TP5 Tests Fonctionnels 2024
**Repository:** https://github.com/KhadijaBenhamida/TP5-Tests-fonctionnels
