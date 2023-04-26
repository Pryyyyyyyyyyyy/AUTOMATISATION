package foxtrot;

import org.example.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
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
        Waiters waiters = new Waiters(driver);
       /* WebElement searchField = driver.findElement(By.cssSelector("input.evinent-search-input"));*/
        WebElement searchField = waiters.waitForVisabilityOfElementReturn(By.xpath("//input[@placeholder='Я шукаю ...']"));
        searchField.click();
        searchField.sendKeys(searchWord);
        WebElement button = waiters.waitForVisabilityOfElementReturn(By.xpath(" //input[@value='Знайти']"));
        button.click();



        waiters.waitForTitleContains("Знайдено по запиту");
        if((driver.findElement(By.tagName("h1")).getText()).contains("Результати пошуку")){
            waiters.waitForVisabilityOfElement(By.xpath("//div[@class='search-page__box-title']/label"));
            assertEquals((driver.findElement(By.xpath("//div[@class='search-page__box-title']/label")).getText()),"«"+searchWord+"»",
                    "Actual result = "+ (driver.findElement(By.xpath("//div[@class='search-page__box-title']/label")).getText())+
                            " Expected "+ searchWord);
        }else {
            waiters.waitForVisabilityOfElement(By.tagName("h1"));
            String result = driver.findElement(By.tagName("h1")).getText().replace("Знайдено по запиту ","");
            assertEquals(result,"«"+searchWord+"»",
                    "Actual result = "+ (driver.findElement(By.tagName("h1")).getText())+
                            " Expected "+searchWord);
                            }


    }

    @DataProvider(name = "searchWords")
    public Object[][] searchData() {
        return new Object[][]{
                {"машина"},
                {"input"},
                {"смысл"}
        };
    }
}

 /*     WebElement input = (new Waiters(driver))
                .waitForPresenceOfElementLocated(By.xpath("//input[@placeholder='Я шукаю ...']"));
        input.sendKeys(searchWord);
        input.submit();

        (new Waiters(driver)).waitForTitleContains("Я шукаю ..." + searchWord);
        assertTrue(driver.findElement(By.cssSelector("div.page__title")).getText()
                .replace("Знайдено по запиту ", "").equalsIgnoreCase(newWord));
        driver.quit();
*/