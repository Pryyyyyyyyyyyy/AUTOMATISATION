package org.example;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScenario1 {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testScenario1() {
        driver.get("https://dan-it.com.ua/uk/");

        // Открываем первое окно в фоновом режиме
        String parentWindowHandle1 = driver.getWindowHandle();
        String link = driver.findElement(By.xpath("//a[contains(@href, '/front-end/') and contains(text(),'FrontEnd')]")).getAttribute("href");
        ((JavascriptExecutor) driver).executeScript("window.open('" + link + "', '_blank');");

        // Переключаемся на главное окно и открываем второе окно в фоновом режиме
        driver.switchTo().window(parentWindowHandle1);
        String parentWindowHandle2 = driver.getWindowHandle();
        String link2 = driver.findElement(By.xpath("//a[contains(@href, '/java/') and contains(text(),'Java')]")).getAttribute("href");
        ((JavascriptExecutor) driver).executeScript("window.open('" + link2 + "', '_blank');");

        // Переключаемся на главное окно и открываем третье окно в фоновом режиме из второго окна
        driver.switchTo().window(parentWindowHandle2);
        String link3 = driver.findElement(By.xpath("//a[contains(@href, '/qa/') and contains(text(),'Quality Assurance (QA)')]")).getAttribute("href");
        ((JavascriptExecutor) driver).executeScript("window.open('" + link3 + "', '_blank');");

        // Переключаемся на главное окно и проверяем, что количество окон равно 3
        driver.switchTo().window(parentWindowHandle1);
        Set<String> windowHandles = driver.getWindowHandles();
        int numberOfWindows = windowHandles.size();
        Assert.assertEquals(numberOfWindows, 4, "Number of windows opened is not 4");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
