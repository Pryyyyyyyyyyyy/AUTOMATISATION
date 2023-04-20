package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class Public {
    public void waitForPresenceOfElementLocated(By by) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by), EXPLICIT_WAIT);
    }

    public void waitForPresenceOfElementLocated(WebElement element) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(getByFromWebElement(element)), EXPLICIT_WAIT);
    }

    public WebElement waitForPresenceOfElementLocatedReturn(By by) {
        return fluentWait(EXPLICIT_WAIT).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForPresenceOfElementLocatedReturn(WebElement element) {
        return fluentWait(EXPLICIT_WAIT).until(ExpectedConditions.presenceOfElementLocated(getByFromWebElement(element)));
    }
}
