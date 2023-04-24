package org;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Foxtrotn {
    private WebDriver driver;
    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");
        WebElement cityElement = driver.findElement(By.xpath("//li[@class='popup__cities_item']//a[contains(text(),'Ужгород')]"));
        cityElement.click();
    }

    @Test(dataProvider = "searchWords")
    public void searchTest(String searchWord, String expectedWord) {
        WebElement searchField = driver.findElement(By.cssSelector("input.evinent-search-input"));
        searchField.sendKeys(searchWord);
        searchField.submit();
        WebElement pageTitle = driver.findElement(By.cssSelector("div.page__title h1"));
        String pageTitleText = pageTitle.getText();
        if (pageTitleText.contains("Знайдено по запиту")) {
            assertTrue(pageTitleText.contains(expectedWord.toUpperCase()));
        } else {
            assertTrue(pageTitleText.contains(expectedWord));
        }
    }

    @DataProvider(name = "searchWords")
    public Object[][] searchData() {
        return new Object[][]{{"машина", "машина" }, {"input", "input"}, {"смысл", "смысл"}};
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
