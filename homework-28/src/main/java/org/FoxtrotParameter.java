package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FoxtrotParameter {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.foxtrot.com.ua/");

        WebElement element = driver.findElement(By.xpath("//li[@class='popup__cities_item']//a[contains(text(),'Ужгород')]"));
        element.click();

    }

    @Test(dataProvider = "searchWords")
    public void searchTest(String word, String newword) {
        // Находим поле поиска и вводим туда слово из списка
        WebElement searchField = driver.findElement(By.cssSelector("input.evinent-search-input"));
        searchField.sendKeys(word);
        searchField.submit();
        // Проверяем, есть ли на странице элемент, содержащий искомое слово
        try {
            WebElement result = driver.findElement(By.xpath("//*[contains(text(), '" + word + "')]"));
            Assert.assertTrue(result.isDisplayed());
        } catch (Exception e) {
            // Если элемент не найден, значит, ничего не было найдено по запросу
            WebElement noResults = driver.findElement(By.cssSelector("div.search-page__box-title"));
            Assert.assertTrue(noResults.getText().contains(word));
        }
    }
    /*(new Waiters(driver)).waitForTitleContains("Ви шукали " + searchField);
    assertTrue(driver.findElement(By.tagName("h1")).getText()
                .replace("Знайдено по запиту ", "").equals(name));*/
    @DataProvider(name = "searchWords")
    public Object[][] searchData() {
        return new Object[][]{{"машина"}, {"input"},
                {"смысл"}};
    }
    @AfterClass
    public void tearDown() {
        // Закрываем браузер после выполнения тестов
        driver.quit();
    }
}
