package org;
import org.example.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FoxtrotDataProvider {
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
    public void searchTest(String searchWord) {
        WebElement searchField = driver.findElement(By.cssSelector("input.evinent-search-input"));
        String inputWord = searchWord;
        searchField.sendKeys(searchWord);
        searchField.submit();

        (new Waiters(driver)).waitForTitleContains("Ви шукали " + searchWord);
        assertTrue(driver.findElement(By.tagName("h1")).getText()
                .replace("Знайдено по запиту", "").equalsIgnoreCase(inputWord));
        driver.quit();

    }

    @DataProvider(name = "searchWords")
    public Object[][] searchData() {
        return (Object[][]) new Object[]{"машина", "input"};
    }

}