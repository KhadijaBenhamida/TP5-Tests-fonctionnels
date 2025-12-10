# Tests Selenium - Gestion de Produits

## Tests Implémentés

### TestsSeleniumPart1.java
Localisation: `src/test/java/com/asking/api_produit/selenium/`

**4 Tests Fonctionnels**:
1. **test1_Listing** - Vérifie l'affichage de la liste des produits
2. **test2_Ajout** - Teste la création d'un nouveau produit
3. **test3_Modification** - Teste la modification d'un produit existant
4. **test4_Deconnexion** - Teste la déconnexion (suppression cookies)

## Prérequis

### 1. Application Démarrée
```bash
.\mvnw spring-boot:run
```
L'application doit être accessible sur http://localhost:8080

### 2. Configuration
- **User**: Charbel / admin123 (in-memory user)
- **Database**: gestion_produits (MySQL)
- **Chrome**: `C:\Users\Khadi\.cache\selenium\chrome\chrome-win64\chrome.exe`
- **ChromeDriver**: `C:\Users\Khadi\.cache\selenium\chromedriver\win64\143.0.7499.40\chromedriver.exe`

## Exécution des Tests

```bash
.\mvnw test -Dtest=TestsSeleniumPart1
```

## Résultat Attendu

```
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS

✓ Test Listing réussi
✓ Test Ajout réussi - Produit: ProduitTest_xxxxx
✓ Test Modification réussi - Nouveau nom: ProduitModifie_xxxxx
✓ Test Déconnexion réussi - Redirigé vers: http://localhost:8080/login
```

## Technologies Utilisées

- **Selenium WebDriver 4.1.4**
- **JUnit 5**
- **ChromeDriver 143.0.7499.40**
- **Java 17**

## Notes Techniques

- Tests ordonnés avec `@Order` pour exécution séquentielle
- Utilisation de `WebDriverWait` pour synchronisation
- JavaScript `form.submit()` pour éviter conflits avec navbar
- Test déconnexion via suppression cookies (contournement CSRF)
