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
  /*  Ex1selectors selectors = new Ex1selectors(driver);*/

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


        WebElement resultTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder='поиск товаров'][value='смесь']")));
        assertTrue(resultTitle.getAttribute("value").contains("смесь"), "Результат поиска не содержит слово 'смесь'");


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchInput2 = driver.findElement(By.cssSelector("input[placeholder='поиск товаров'][value='смесь']"));
        searchInput2.clear();
        searchInput2.sendKeys("спесь");
        searchInput2.submit();

        WebElement resultTitle1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder='поиск товаров'][value='спесь']")));
        assertTrue(resultTitle1.getAttribute("value").contains("спесь"), "Результат поиска не содержит слово 'спесь'");


        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchInput3 = driver.findElement(By.cssSelector("input[placeholder='поиск товаров'][value='спесь']"));
        searchInput3.clear();
        searchInput3.sendKeys("ересь");
        searchInput3.submit();

        WebElement resultTitle2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[placeholder='поиск товаров'][value='ересь']")));
        assertTrue(resultTitle2.getAttribute("value").contains("ересь"), "Заголовок страницы не содержит слово 'ересь'");


    }
        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

