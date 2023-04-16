package org.example;


// help meeeeee its terrible

>>>>>>> github/master
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ex2 {
    private static class Url {
        private static final String ashortjourney = "http://www.ashortjourney.com/";
    }

    private static class Locators {
        private static final By r40 = By.cssSelector("[r = '40']");
        private static final By r8 = By.cssSelector("[r = '8']");
        private static final By textArea = By.cssSelector("textarea");
    }

import java.time.Duration;

public class Ex2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(Url.ashortjourney);
        Thread.sleep(10000);

        WebElement r40v1 = driver.findElement(Locators.r40);
        WebElement r8v1 = driver.findElement(Locators.r8);
        int x = r8v1.getLocation().x + r8v1.getSize().width / 2;
        int y = r8v1.getLocation().y + r8v1.getSize().height / 2;
        actions.moveToElement(r40v1).clickAndHold().moveByOffset(x, y).release().build().perform();
        Thread.sleep(5000);

        WebElement r40v2 = driver.findElement(Locators.r40);
        WebElement r8v2 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v2, r8v2).perform();
        Thread.sleep(5000);

        WebElement r40v3 = driver.findElement(Locators.r40);
        WebElement r8v3 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v3, r8v3).perform();
        Thread.sleep(5000);

        WebElement r40v4 = driver.findElement(Locators.r40);
        WebElement r8v4 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v4, r8v4).perform();
        Thread.sleep(5000);

        WebElement r40v5 = driver.findElement(Locators.r40);
        WebElement r8v5 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v5, r8v5).perform();
        Thread.sleep(5000);

        WebElement r40v6 = driver.findElement(Locators.r40);
        WebElement r8v6 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v6, r8v6).perform();
        Thread.sleep(5000);

        WebElement r40v7 = driver.findElement(Locators.r40);
        WebElement r8v7 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v7, r8v7).perform();
        Thread.sleep(5000);

        WebElement textArea = driver.findElement(Locators.textArea);
        textArea.sendKeys("Mission accomplished!");
        Thread.sleep(5000);

    }
}
