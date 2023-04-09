package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex3 {
    public static void main(String[] args) {
        // Устанавливаем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создаем экземпляр веб-драйвера Chrome
        WebDriver driver = new ChromeDriver();

        // Открываем веб-страницу
        driver.get("https://dan-it.com.ua/");

        try {
            // Выполняем клик по элементу
            WebElement element1 = driver.findElement(By.xpath("/html/body/main/div[1]/div/a[1]"));
            element1.click();

            // Ждем 2 секунды
            Thread.sleep(2000);

            // Клик по элементу с текстом IT-освіта
            WebElement element = driver.findElement(By.xpath("//*[contains(text(),'IT-освіта')]"));
            element.click();

            // Ждем 2 секунды
            Thread.sleep(2000);

            // Выполняем клик по элементу
            WebElement element2 = driver.findElement(By.cssSelector(".main-banner-btn"));
            element2.click();

            // Ждем 2 секунды
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Закрываем веб-драйвер
            driver.quit();
        }
    }
}
