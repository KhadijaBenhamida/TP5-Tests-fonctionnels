# TP5 - Tests Fonctionnels

## Description
Projet Spring Boot avec tests fonctionnels utilisant Selenium WebDriver (Java), Selenium IDE, et MockMvc (équivalent Codeception pour Java).

## Structure du Projet
```
Gestion_Produit/
├── src/
│   ├── main/java/              # Code source de l'application
│   ├── test/java/
│   │   ├── selenium/           # Tests Selenium Java (Exercice 1)
│   │   │   └── TestsSeleniumPart1.java
│   │   └── functional/         # Tests MockMvc (Exercice 2)
│   │       └── FunctionalTestsCodeception.java
│   └── test/selenium-ide/      # Tests Selenium IDE
│       └── Tests_Gestion_Produits.side
└── .env                        # Variables d'environnement (ADMIN_PASSWORD)
```

## Prérequis
- Java 17
- Maven
- MySQL (base de données: gestion_produits)
- Chrome/ChromeDriver (pour tests Selenium)

## Configuration Base de Données
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_produits
spring.datasource.username=root
spring.datasource.password=root
```

## Identifiants de Test
- Email: `Charbel`
- Mot de passe: `admin123` (défini dans .env)

## Exercice 1: Tests Selenium Java
**Fichier**: `src/test/java/com/asking/api_produit/selenium/TestsSeleniumPart1.java`

**Tests implémentés**:
1. Test1_Listing - Vérifier l'affichage de la liste des produits
2. Test2_Ajout - Créer un nouveau produit
3. Test3_Modification - Modifier un produit existant
4. Test4_Deconnexion - Tester la déconnexion

**Exécution**:
```bash
.\mvnw test -Dtest=TestsSeleniumPart1
```

## Exercice 2: Tests Codeception-style (MockMvc)
**Fichier**: `src/test/java/com/asking/api_produit/functional/FunctionalTestsCodeception.java`

**Note**: Codeception étant un framework PHP, nous utilisons Spring MockMvc qui offre la même philosophie de tests fonctionnels pour Java.

**Tests implémentés**:
1. test1_Listing - GET /listeAvecCon
2. test2_Ajout - POST /create
3. test3_Modification - POST /update/1
4. test4_Deconnexion - POST /logout

**Exécution**:
```bash
.\mvnw test -Dtest=FunctionalTestsCodeception
```

## Tests Selenium IDE
**Fichier**: `src/test/selenium-ide/Tests_Gestion_Produits.side`

**Utilisation**:
1. Installer l'extension Selenium IDE dans Chrome/Firefox
2. Ouvrir le fichier .side dans Selenium IDE
3. Lancer la suite "Suite Complete"

## Exécuter Tous les Tests
```bash
.\mvnw test
```

## Lancer l'Application
```bash
.\mvnw spring-boot:run
```
Application accessible sur: http://localhost:8080

## Technologies Utilisées
- Spring Boot 2.7.1
- Spring Security
- Hibernate/JPA
- MySQL
- Selenium WebDriver 4.27.0
- JUnit 5
- Lombok

## Auteur
ENSA Khouribga - TP5 Tests Fonctionnels 2024
