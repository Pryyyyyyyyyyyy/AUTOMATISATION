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

        By searchInput1 = By.xpath("//input[@placeholder='поиск товаров']");
        WebElement searchElement = wait.until(ExpectedConditions.presenceOfElementLocated(searchInput1));
        searchElement.sendKeys("смесь");
        searchElement.sendKeys(Keys.ENTER);


        WebElement resultTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("j-catalog-header")));
        assertTrue(resultTitle.getText().contains("смесь"), "Результат поиска содержит слово 'смесь'");


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchElement2 = wait.until(ExpectedConditions.presenceOfElementLocated(searchInput1));
        searchElement2.clear();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        searchElement2.sendKeys("спесь");
      /*  wait.until(ExpectedConditions.elementToBeClickable(searchElement2)).*/ searchElement2.sendKeys(Keys.ENTER);
        WebElement resultTitle2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(), 'спесь')]")));


      /*  WebElement resultTitle2 = (new Ex1selectors (driver)
        .waitForPresenceOfElementLocated(By.xpath("//[contains(text(), 'Результаты поиска «спесь»')]")));*/

     /*   try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/



        assertTrue(resultTitle2.getText().contains("спесь"), "Результат поиска содержит слово 'спесь'");
        /*Результаты поиска */

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchElement3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='спесь']")));
        searchElement3.clear();
        searchElement3.sendKeys("ересь");
        searchElement3.sendKeys(Keys.ENTER);

      WebElement resultTitle3 = wait.until(ExpectedConditions.presenceOfElementLocated((By) searchElement3));
        assertTrue(searchElement3.getText().contains("ересь"), "Результат поиска содержит слово 'ересь'");

    }
        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

