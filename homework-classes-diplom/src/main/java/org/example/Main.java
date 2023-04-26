package org.example;

//Класс Actions для выполнения действий

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ActionsClass {
    private final WebDriver driver;
    private final Actions actions;

    public ActionsClass(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void dragAndDrop(By source, By target) {
        WebElement sourceElement = driver.findElement(source);
        WebElement targetElement = driver.findElement(target);
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }

    public void click(By by) {
        WebElement element = driver.findElement(by);
        actions.click(element).perform();
    }

    public void submit(By by) {
        WebElement element = driver.findElement(by);
        actions.sendKeys(element, "\n").perform();
    }
}

   // Класс Assertions для проверки утверждений


public class Assertions {
    private final WebDriver driver;

    public Assertions(WebDriver driver) {
        this.driver = driver;
    }

    public void elementIsDisplayed(By by) {
        Assert.assertTrue(driver.findElement(by).isDisplayed(),
                "Элемент не отображается, а должен был");
    }

    public void equalsOfText(By by, String expectedText) {
        String actualText = driver.findElement(by).getText();
        Assert.assertEquals(actualText, expectedText,
                "Я ожидал получить текст \"" + expectedText + "\". А получил \"" + actualText + "\".");
    }
}

//Приклад тесту / заглушка
public class ExampleTest {
    private WebDriver driver;
    private Waiters wait;
    private ActionsClass actions;
    private Assertions assertions;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new Waiters(driver);
        actions = new ActionsClass(driver);
        assertions = new Assertions(driver);
    }

    @Test
    public void exampleTest() {
        driver.get("https://example.com");
        wait.waitForVisibilityOfElementLocated(By.tagName("h1"));
        assertions.equalsOfText(By.tagName("h1"), "Example Domain");
        actions.click(By.linkText("More information..."));
        wait.waitForVisibilityOfElementLocated(By.tagName("h2"));
        assertions.equalsOfText(By.tagName("h2"), "Navigation menu");
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}