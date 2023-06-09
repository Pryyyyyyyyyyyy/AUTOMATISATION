package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestGuinnessWorldRecords {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRememberMeCheckbox() {

        driver.get("https://www.guinnessworldrecords.com/Account/Login");

        WebElement rememberMeCheckbox = driver.findElement(By.id("RememberMe"));
        Assert.assertFalse(rememberMeCheckbox.isSelected(), "Remember Me checkbox should be unchecked by default");

        rememberMeCheckbox.click();
        Assert.assertTrue(rememberMeCheckbox.isSelected(), "Remember Me checkbox should be selected");

        rememberMeCheckbox.click();
        Assert.assertFalse(rememberMeCheckbox.isSelected(), "Remember Me checkbox should be unchecked");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}