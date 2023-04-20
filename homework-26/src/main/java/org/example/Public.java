package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Public {
    public void waitForPresenceOfElementLocated(ExpectedCondition<WebElement> webElementExpectedCondition, By by) {
        waitForPresenceOfElementLocated(ExpectedConditions.presenceOfElementLocated(by), by);
    }

    public void waitForPresenceOfElementLocated(WebElement element) {
        waitForPresenceOfElementLocated(ExpectedConditions.presenceOfElementLocated(getClass(element)), (By) element);
    }

    private By getClass(WebElement element) {
        return null;
    }

    public WebElement waitForPresenceOfElementLocatedReturn(By by) {
        long EXPLICIT_WAIT = 5;
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


}
