package org.example;

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.interactions.Actions;

        import java.util.concurrent.TimeUnit;

public class Ex6 {

    public static void main(String[] args) {
        // Устанавливаем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создаем экземпляр WebDriver
        WebDriver driver = new ChromeDriver();

        // Ожидание неявного ожидания
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Перейти на сайт
        driver.get("https://dan-it.com.ua/");

        // Задержка 2 секунды
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Клик по элементу "Українська"
        WebElement langLink = driver.findElement(By.cssSelector(".choose-lang__link"));
        langLink.click();

        // Задержка 2 секунды
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Найти элемент и переместить курсор на него
        WebElement bannerMetaName = driver.findElement(By.cssSelector(".banner-meta__name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bannerMetaName).perform();
        System.out.println("Найден элемент");

        // Задержка 2 секунды
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Клик на элемент
        bannerMetaName.click();

        // Задержка 2 секунды
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрыть браузер
        driver.quit();
    }
}
