package foxtrot;

import org.example.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FoxtrotParameter {
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

    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][]{
                {"машина", "машина"},
                {"input", "input"}
        };
    }

    @Parameters({"searchWord", "newWord"})
    @Test(dataProvider = "searchData")
    public void searchTest(String searchWord, String newWord) {
        WebElement searchField = driver.findElement(By.cssSelector("input.evinent-search-input"));
        searchField.click();

        WebElement input = (new Waiters(driver))
                .waitForPresenceOfElementLocated(By.xpath("//input[@placeholder='Я шукаю ...']"));
        input.sendKeys(searchWord);
        input.submit();

        if (driver.findElement(By.cssSelector("div.page__title")).getText().contains("ничего не найдено")) {
            assertTrue(driver.findElement(By.cssSelector("div.page__title")).getText()
                    .replace("По запиту", "").equalsIgnoreCase(searchWord));
        } else {
            assertTrue(driver.findElement(By.cssSelector("div.page__title")).getText()
                    .replace("Знайдено по запиту", "").equalsIgnoreCase(newWord));
            assertTrue(driver.findElement(By.cssSelector("div.search-results__content"))
                    .getText().toLowerCase().contains(searchWord.toLowerCase()));
        }

        driver.quit();
    }
}


