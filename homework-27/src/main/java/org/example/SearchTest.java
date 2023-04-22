package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class SearchTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uhomki.com.ua/ru/");
    }

    @Test
    public void testSearch() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchInput = driver.findElement(By.cssSelector("input[placeholder='поиск товаров']"));

        // Поиск по слову "смесь"
        searchInput.sendKeys("смесь");
        searchInput.submit();

        By searchInput1 = By.xpath("//input[@placeholder='поиск товаров']");
        WebElement searchElement = wait.until(ExpectedConditions.presenceOfElementLocated(searchInput1));
        searchElement.sendKeys("смесь");
        searchElement.sendKeys(Keys.ENTER);


        WebElement resultTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("j-catalog-header")));
        assertTrue(resultTitle.getText().contains("смесь"), "Результат поиска содержит слово 'смесь'");


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchElement2 = wait.until(ExpectedConditions.presenceOfElementLocated(searchInput1));
        searchElement2.clear(); // очистить поле ввода
        searchElement2.sendKeys("спесь");
        searchElement2.sendKeys(Keys.ENTER);

        /*WebElement searchElement3 = driver.findElement(By.cssSelector("input[placeholder='смесь']"));
        WebElement searchElement2 = wait.until(ExpectedConditions.presenceOfElementLocated(searchElement3));
        searchElement2.click();
        searchElement2.clear();
        searchElement2.sendKeys("спесь");
        searchElement2.sendKeys(Keys.ENTER);*/
       /* // Поиск
        searchInput2.sendKeys("спесь");
        searchInput2.submit();*/
/*
        By searchInput2 = By.xpath("//input[@placeholder='смесь']");
        searchElement2.sendKeys("спесь");
        searchElement2.sendKeys(Keys.ENTER);*/


        WebElement resultTitle2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("j-catalog-header")));
        assertTrue(resultTitle2.getText().contains("спесь"), "Результат поиска не содержит слово 'смесь'");

        /*// Поиск по слову "спесь"
        searchInput = driver.findElement(By.id("search_uid3d6e063a67bfdef44698aea0fe92c272"));
        searchInput.sendKeys("спесь");
        searchInput.submit();
        resultTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("j-catalog-header")));
        assertTrue(resultTitle.getText().contains("спесь"), "Результат поиска не содержит слово 'спесь'");

        // Поиск по слову "ересь"
        searchInput = driver.findElement(By.id("search_uid3d6e063a67bfdef44698aea0fe92c272"));
        searchInput.sendKeys("ересь");
        searchInput.submit();
        resultTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("j-catalog-header")));
        assertTrue(resultTitle.getText().contains("ересь"), "Результат поиска не содержит слово 'ересь'");
    }
*/
    }
        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

