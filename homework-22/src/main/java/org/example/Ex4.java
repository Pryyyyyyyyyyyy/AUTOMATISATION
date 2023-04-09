package org.example;


import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Ex4 {
    public static void main(String[] args) {
        // Установка пути к драйверу браузера
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создание экземпляра веб-драйвера
        WebDriver driver = new ChromeDriver();

        // Ожидание неявного ожидания
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Переход на страницу
        driver.get("https://uhomki.com.ua/koshki/1074/");

        // Задержка 2 секунды
        sleep(2000);

        // Наведение курсора на элемент
        WebElement aquariumistikaElement = driver.findElement(By.linkText("Аквариумистика"));
        Actions actions = new Actions(driver);
        actions.moveToElement(aquariumistikaElement).build().perform();


        // Задержка 2 секунды
        sleep(2000);

        // Поиск элемента по имени и клик на элемент
        WebElement akvariumyElement = driver.findElement(By.linkText("Аквариумы"));
        akvariumyElement.click();

        // Задержка 2 секунды
        sleep(2000);

        // Закрытие браузера
        driver.quit();
    }

    // Метод для ожидания
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
