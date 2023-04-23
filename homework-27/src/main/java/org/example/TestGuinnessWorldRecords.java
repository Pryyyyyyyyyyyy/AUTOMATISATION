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
        // Set up Chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRememberMeCheckbox() {
        // Navigate to login page
        driver.get("https://www.guinnessworldrecords.com/Account/Login");

        // Find Remember Me checkbox and check if it is unchecked by default
        WebElement rememberMeCheckbox = driver.findElement(By.id("RememberMe"));
        Assert.assertFalse(rememberMeCheckbox.isSelected(), "Remember Me checkbox should be unchecked by default");

        // Click Remember Me checkbox and check if it is selected
        rememberMeCheckbox.click();
        Assert.assertTrue(rememberMeCheckbox.isSelected(), "Remember Me checkbox should be selected");

        // Click Remember Me checkbox again and check if it is unchecked
        rememberMeCheckbox.click();
        Assert.assertFalse(rememberMeCheckbox.isSelected(), "Remember Me checkbox should be unchecked");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

}