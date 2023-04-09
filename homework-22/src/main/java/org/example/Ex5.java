package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ex5 {
    public static void main(String[] args) throws InterruptedException {
        // Устанавливаем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создаем экземпляр WebDriver
        WebDriver driver = new ChromeDriver();

        // Переходим на главную страницу сайта
        driver.get("https://dan-it.com.ua/");

        // Выполняем клик по элементу
        WebElement element1 = driver.findElement(By.xpath("/html/body/main/div[1]/div/a[1]"));
        element1.click();

        // Ждем 2 секунды
        Thread.sleep(2000);


        // Ищем элемент
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // Поиск элемента с текстом
        driver.findElement(By.xpath("//a[@class='page-header__phone']")).click();

        // 2 секунды
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрываем браузер
        System.out.println(11111);
        driver.quit();
    }
}