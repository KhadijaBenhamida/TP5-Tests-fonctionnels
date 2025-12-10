package com.asking.api_produit.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestsSeleniumPart1 {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final String BASE_URL = "http://localhost:8080";
    private static final String EMAIL = "Charbel";
    private static final String PASSWORD = "admin123";

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", 
            "C:\\Users\\Khadi\\.cache\\selenium\\chromedriver\\win64\\143.0.7499.40\\chromedriver.exe");
        
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Khadi\\.cache\\selenium\\chrome\\chrome-win64\\chrome.exe");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void login() {
        driver.get(BASE_URL + "/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
        
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        wait.until(ExpectedConditions.urlContains("/liste"));
    }

    @Test
    @Order(1)
    public void test1_Listing() {
        login();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
        WebElement table = driver.findElement(By.tagName("table"));
        Assertions.assertNotNull(table, "La table des produits doit être présente");
        
        WebElement header = driver.findElement(By.tagName("h1"));
        Assertions.assertTrue(header.getText().contains("Liste des produits"), 
            "Le titre doit contenir 'Liste des produits'");
        
        System.out.println("✓ Test Listing réussi");
    }

    @Test
    @Order(2)
    public void test2_Ajout() {
        login();
        driver.get(BASE_URL + "/creation/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nom")));
        
        String nomProduit = "ProduitTest_" + System.currentTimeMillis();
        driver.findElement(By.id("nom")).sendKeys(nomProduit);
        driver.findElement(By.id("prix")).sendKeys("100");
        driver.findElement(By.id("devise")).sendKeys("EUR");
        driver.findElement(By.id("taxe")).sendKeys("20");
        driver.findElement(By.id("dateExpiration")).sendKeys("31122025");
        driver.findElement(By.id("fournisseur")).sendKeys("FournisseurTest");
        
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.querySelector('form[action=\"/create\"]').submit();"
        );
        
        wait.until(ExpectedConditions.urlContains("/liste"));
        
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("créé") || pageSource.contains(nomProduit), 
            "Le produit doit être créé avec succès");
        
        System.out.println("✓ Test Ajout réussi - Produit: " + nomProduit);
    }

    @Test
    @Order(3)
    public void test3_Modification() {
        driver.get(BASE_URL + "/listeAvecCon");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
        
        WebElement updateLink = wait.until(
            ExpectedConditions.elementToBeClickable(By.linkText("Mettre à jour"))
        );
        updateLink.click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nom")));
        
        WebElement nomField = driver.findElement(By.id("nom"));
        nomField.clear();
        String nouveauNom = "ProduitModifie_" + System.currentTimeMillis();
        nomField.sendKeys(nouveauNom);
        
        String produitId = driver.getCurrentUrl().split("/maj/")[1];
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "document.querySelector('form[action=\"/update/" + produitId + "\"]').submit();"
        );
        
        wait.until(ExpectedConditions.urlContains("/liste"));
        
        String pageSource = driver.getPageSource();
        Assertions.assertTrue(pageSource.contains("mis à jour") || pageSource.contains(nouveauNom), 
            "Le produit doit être modifié avec succès");
        
        System.out.println("✓ Test Modification réussi - Nouveau nom: " + nouveauNom);
    }

    @Test
    @Order(4)
    public void test4_Deconnexion() {
        driver.get(BASE_URL + "/listeAvecCon");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
        
        driver.manage().deleteAllCookies();
        
        driver.get(BASE_URL + "/listeAvecCon");
        
        wait.until(ExpectedConditions.or(
            ExpectedConditions.urlContains("/login"),
            ExpectedConditions.presenceOfElementLocated(By.name("email"))
        ));
        
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("/login"), 
            "Après suppression cookies, redirection vers login");
        
        System.out.println("✓ Test Déconnexion réussi - Redirigé vers: " + currentUrl);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
