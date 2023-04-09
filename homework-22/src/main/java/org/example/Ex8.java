package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Ex8 {
    public static void main(String[] args) throws InterruptedException {
        // Установить путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        // Создать экземпляр драйвера
        WebDriver driver = new ChromeDriver();
        // Открыть главный сайт
        driver.get("https://dan-it.com.ua/");
        // Выбрать "Українська"
        WebElement ukrLang = driver.findElement(By.cssSelector(".choose-lang__link"));
        ukrLang.click();
        // Найти элемент 1
        WebElement elem1 = driver.findElement(By.cssSelector(".main-info__title"));
        // задержка 2 секунды
        Thread.sleep(2000);
        // Навести курсор на этот элемент
        Actions actions = new Actions(driver);
        actions.moveToElement(elem1).perform();
        // Вывести "1 элемент" в консоль
        System.out.println("1 элемент");
        // задержка 2 секунды
        Thread.sleep(2000);
        // Найти элемент 2
        WebElement elem2 = driver.findElement(By.cssSelector(".main-expertise__point"));
        // задержка 2 секунды
        Thread.sleep(2000);
        // Вывести "2 элемент" в консоль
        System.out.println("2 элемент");
        // Закрыть браузер
        driver.quit();
    }
}
