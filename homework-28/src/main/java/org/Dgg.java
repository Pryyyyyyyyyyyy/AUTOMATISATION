package org;

/*
// priklad rishennya

import org.example.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Dgg {
    @Test(dataProvider = "searchParameters")
    public void search(String inputMessage, String expretedValue) {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://klopotenko.com/");
        WebElement element = (new Waiters(driver)
                .waitForPresenceOfElementLocated(By.xpath("//a[@aria-label='dismiss cookie message']")));
        element.click();
        driver.get("https://klopotenko.com/");
        WebElement search = (new Waiters(driver)).waitForPresenceOfElementLocated(By.id("open-search"));
        search.click();
        WebElement input = (new Waiters(driver))
                .waitForPresenceOfElementLocated(By.xpath("//input[@placeholder='Пошук...']"));
        input.sendKeys(inputMessage);
        input.submit();
        (new Waiters(driver)).waitForTitleContains("Ви шукали " + inputMessage);
        assertTrue(driver.findElement(By.tagName("h2")).getText()
                .replace("ЗНАЙДЕНО ЗА ЗАПИТОМ: ", "").equals(expretedValue));
        driver.quit();
    }
    @DataProvider(name = "searchParameters")
    public Object[][] createData(){
        return new Object[][]{
                {"Carrot","CARROT"},
        };
    }
}*/
