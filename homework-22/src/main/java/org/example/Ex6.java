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

        // Ожидание неявного ожидания 10 секунд
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Шаг 1: Перейти на сайт
        driver.get("https://dan-it.com.ua/");

        // Шаг 2: Задержка 2 секунды
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Шаг 3: Клик по элементу "Українська"
        WebElement langLink = driver.findElement(By.cssSelector(".choose-lang__link"));
        langLink.click();

        // Шаг 4: Задержка 2 секунды
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Шаг 5: Найти элемент и переместить курсор на него
        WebElement bannerMetaName = driver.findElement(By.cssSelector(".banner-meta__name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bannerMetaName).perform();
        System.out.println("Найден элемент");

        // Шаг 6: Задержка 2 секунды
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Шаг 7: Клик на элемент
        bannerMetaName.click();

        // Шаг 8: Задержка 2 секунды
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Шаг 9: Закрыть браузер
        driver.quit();
    }
}
