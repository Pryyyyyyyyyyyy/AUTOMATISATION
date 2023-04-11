package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex5 {
    public static void main(String[] args) throws InterruptedException {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создание экземпляра ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Переход на сайт
        driver.get("https://uhomki.com.ua/ru");

        // Ожидание 3 секунды
        Thread.sleep(3000);

        // Поиск элемента поиска
        WebElement searchInput = driver.findElement(By.className("search__input")); searchInput.click();
        
        // Ввод слова "Хорек" в поиск
        searchInput.sendKeys("Хорек");
        // Ожидание 3 секунды
        Thread.sleep(3000);

        WebElement searchResultLink = driver.findElement(By.xpath("//div[contains(text(),'Витамины Беафар ПАСТА Мальт с двойным действием для хорьков 100г')]/ancestor::a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchResultLink).perform();
        Thread.sleep(3000);
        searchResultLink.click();


        // Ожидание 2 секунды
        Thread.sleep(2000);

        // Клик на "К сравнению"
        WebElement compareButton = driver.findElement(By.cssSelector("span.comparison-button__text"));
        compareButton.click();

        // Ожидание 2 секунды
        Thread.sleep(2000);

        // Поиск элемента поиска
        WebElement searchInput1 = driver.findElement(By.className("search__input")); searchInput1.click();

        // Ввод в поиск
        searchInput1.sendKeys("Медведь");

        // Ожидание 3 секунды
        Thread.sleep(3000);
        WebElement searchResultLink1 = driver.findElement(By.xpath("//div[contains(text(),'Белый медведь 6х5х6см')]/ancestor::a"));
        Actions actions1 = new Actions(driver);
        actions.moveToElement(searchResultLink1).perform();
        Thread.sleep(3000);
        searchResultLink1.click();

        // Ожидание 3 секунды
        Thread.sleep(3000);



        // Клик на "К сравнению"
        compareButton = driver.findElement(By.cssSelector("span.comparison-button__text"));
        compareButton.click();

        // Ожидание 2 секунды
        Thread.sleep(2000);

        // Клик на "Сравнение"
        WebElement comparisonViewButton = driver.findElement(By.cssSelector("span.comparison-view__button-text"));
        comparisonViewButton.click();

        // Ожидание 2 секунды
        Thread.sleep(2000);

        // Закрытие браузера
        driver.quit();
    }
}
