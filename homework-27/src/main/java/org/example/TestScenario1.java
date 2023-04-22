package org.example;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
    public void testScenario1() throws InterruptedException {
        driver.get("https://dan-it.com.ua/uk/");
        WebElement adultsLink = driver.findElement(By.xpath("//a[contains(text(),'Для дорослих')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(adultsLink).build().perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String parentWindowHandle = driver.getWindowHandle();

        WebElement frontEndLink = driver.findElement(By.xpath("//a[contains(@href, '/front-end/') and contains(text(),'FrontEnd')]"));
        Actions actions1 = new Actions(driver);
        actions.moveToElement(frontEndLink).build().perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

// Открываем найденный элемент в новом окне браузера в фоне
        String link = frontEndLink.getAttribute("href");
        String script = "window.open('" + link + "', '_blank');";
        ((JavascriptExecutor) driver).executeScript(script);


        WebElement javaLink = driver.findElement(By.xpath("//a[contains(text(),'Java')]"));
        javaLink.click();

        WebElement qaLink = driver.findElement(By.xpath("//a[contains(text(),'Quality Assurance (QA)')]"));
        qaLink.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Set<String> windowHandles = driver.getWindowHandles();
        int numberOfWindows = windowHandles.size();
        Assert.assertEquals(numberOfWindows, 4, "Number of windows opened is not 4");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
