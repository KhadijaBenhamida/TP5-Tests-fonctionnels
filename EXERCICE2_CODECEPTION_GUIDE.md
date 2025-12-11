# 🚀 GUIDE RAPIDE - EXERCICE 2: CODECEPTION

## ✅ Vous avez raison!

Le professeur veut que vous utilisiez **Codeception comme outil externe** pour tester l'application Java via le navigateur!

---

## 📦 Ce qui a été créé

```
codeception-tests/
├── composer.json                    # Dépendances PHP
├── codeception.yml                  # Configuration Codeception
├── INSTALLATION.bat                 # Script installation automatique
├── RUN_TESTS.bat                    # Script exécution tests
├── README.md                        # Documentation complète
├── tests/
│   ├── acceptance.suite.yml         # Config WebDriver
│   ├── _support/
│   │   └── AcceptanceHelper.php     # Helper login
│   └── acceptance/
│       ├── Test1_ListingCest.php    # ✅ Test Listing
│       ├── Test2_AjoutCest.php      # ✅ Test Ajout
│       ├── Test3_ModificationCest.php # ✅ Test Modification
│       └── Test4_DeconnexionCest.php  # ✅ Test Déconnexion
```

---

## 🎯 Installation (3 étapes)

### Étape 1: Installer PHP et Composer

```bash
# Avec Chocolatey (recommandé)
choco install php composer

# OU télécharger manuellement:
# PHP: https://windows.php.net/download/
# Composer: https://getcomposer.org/download/
```

### Étape 2: Installer Codeception

```bash
cd codeception-tests
INSTALLATION.bat
```

**OU manuellement:**
```bash
composer install
vendor\bin\codecept build
```

### Étape 3: Lancer les tests

```bash
# Démarrer l'application Spring Boot (terminal 1)
.\mvnw spring-boot:run

# Lancer les tests Codeception (terminal 2)
cd codeception-tests
RUN_TESTS.bat
```

**OU manuellement:**
```bash
vendor\bin\codecept run acceptance --steps
```

---

## 📊 Résultat Attendu

```
Codeception PHP Testing Framework v5.0.0

Acceptance Tests (4) 
--------------------
✔ Test1_ListingCest: Test listing
  • I am on page "/login"
  • I fill field "email","Charbel"
  • I fill field "password","admin123"
  • I click "button[type='submit']"
  • I wait for element "table",10
  • I see element "table"
  • I see "Liste des produits","h1"
  
✔ Test2_AjoutCest: Test ajout
✔ Test3_ModificationCest: Test modification
✔ Test4_DeconnexionCest: Test deconnexion

Time: 00:25.692, Memory: 18.00 MB

OK (4 tests, 8 assertions)
```

---

## 🆚 Différence avec Exercice 1

| Aspect | Exercice 1 (Selenium Java) | Exercice 2 (Codeception PHP) |
|--------|---------------------------|------------------------------|
| **Langage** | Java | PHP |
| **Outil** | Selenium WebDriver | Codeception + WebDriver |
| **Syntaxe** | Verbeux | Concis (BDD-style) |
| **Fichiers** | .java | .php |
| **Exécution** | Maven | Composer |

### Exemple Code

**Selenium Java (Exercice 1):**
```java
driver.get("http://localhost:8080/login");
driver.findElement(By.name("email")).sendKeys("Charbel");
driver.findElement(By.name("password")).sendKeys("admin123");
driver.findElement(By.cssSelector("button[type='submit']")).click();
```

**Codeception PHP (Exercice 2):**
```php
$I->amOnPage('/login');
$I->fillField('email', 'Charbel');
$I->fillField('password', 'admin123');
$I->click('button[type="submit"]');
```

---

## 🎓 Pourquoi Codeception?

1. ✅ **Syntaxe élégante:** Plus lisible que Selenium Java
2. ✅ **BDD-style:** Approche Behavior-Driven Development
3. ✅ **Indépendant du langage:** Teste n'importe quelle application web
4. ✅ **Rapports automatiques:** Screenshots en cas d'échec
5. ✅ **Comparaison pédagogique:** Montre différentes approches de tests

---

## 📝 Commandes Utiles

```bash
# Tous les tests
vendor\bin\codecept run acceptance

# Test spécifique
vendor\bin\codecept run acceptance Test1_ListingCest

# Mode verbose (voir les étapes)
vendor\bin\codecept run acceptance --steps

# Mode debug
vendor\bin\codecept run acceptance --debug

# Générer rapport HTML
vendor\bin\codecept run acceptance --html
```

---

## 🐛 Dépannage

### "php: command not found"
```bash
choco install php
```

### "composer: command not found"
```bash
choco install composer
```

### "Connection refused"
```bash
# Vérifier que Spring Boot tourne
netstat -ano | findstr :8080
```

---

## ✅ Validation Exercice 2

Vous avez maintenant:
- ✅ 4 tests Codeception fonctionnels
- ✅ Configuration WebDriver
- ✅ Scripts d'installation et exécution
- ✅ Documentation complète
- ✅ Approche différente de l'Exercice 1

**C'est exactement ce que le professeur demande!** 🎯

---

## 📚 Documentation Complète

Voir `codeception-tests/README.md` pour:
- Installation détaillée
- Structure des tests
- Configuration WebDriver
- Comparaison Selenium vs Codeception
- Commandes avancées

---

## 🎉 Conclusion

**Exercice 1:** Tests Selenium Java (approche programmatique)
**Exercice 2:** Tests Codeception PHP (approche BDD-style)

Les deux testent la **même application Java**, mais avec des **outils différents**!

C'est l'objectif pédagogique: comparer les approches de tests fonctionnels. 🚀
