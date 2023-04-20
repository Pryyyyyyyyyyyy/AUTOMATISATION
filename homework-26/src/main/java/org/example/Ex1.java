package org.example;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ex1 {
    private WebDriver driver;
    private Wait<WebDriver> wait;

    public void Ex1(WebDriver driver, Duration duration) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver)
                .withTimeout(duration)
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(TimeoutException.class);
    }
//this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public void waitForPresenceOfElementLocated(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

/*    public void waitForTextToBePresentInElementValue(By by, String text) {
        wait.until(ExpectedConditions.textToBePresentInElementValue(by, text));
    }*/

    public void waitForInvisibilityOfElementLocated(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForTitleContains(String title) {
        wait.until(ExpectedConditions.titleContains(title));
    }

    public void waitForTitleIs(String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    public void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeSelected(By by) {
        wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public void waitForElementSelectionStateToBe(By by, boolean isSelected) {
        wait.until(ExpectedConditions.elementSelectionStateToBe(by, isSelected));
    }

    public void waitForVisibilityOfElementLocated(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForFrameToBeAvailableAndSwitchToIt(By by) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public void waitForAlertIsPresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public WebElement waitForPresenceOfElementLocatedReturn(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementToBeClickableReturn(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public Boolean waitForElementToBeSelectedReturn(By by) {
        return wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public WebElement waitForVisibilityOfElementLocatedReturn(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebDriver waitForFrameToBeAvailableAndSwitchToItReturn(By by) {
        return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public WebElement waitForElement(By by) {
        return wait.until(driver -> driver.findElement(by));
    }
    @Test
    public void testWaitForElementToBeClickable() {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.get("https://dan-it.com.ua/uk/");

        // найдем элемент по css-селектору и сделаем его неактивным
        WebElement element = driver.findElement(By.cssSelector("//div[@class='banner__meta-data banner-meta']"));
        element.click();

    }
}
