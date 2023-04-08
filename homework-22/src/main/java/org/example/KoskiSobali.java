package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KoskiSobali {
    public static void main(String[] args) throws InterruptedException {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();

        // Открытие сайта
        driver.get("https://uhomki.com.ua/ru/koshki/1074/");

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Клик на элемент "Каталог"
        WebElement catalogElement = driver.findElement(By.xpath("/html/body/div[2]/footer/div/div/div/div[2]/div/div/div"));
        catalogElement.click();

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Клик на элемент "Собаки/кошки общее"
        WebElement commonElement = driver.findElement(By.xpath("/html/body/div[2]/footer/div/div/div/div[2]/div/div/ul/li[3]/a"));
        commonElement.click();

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Закрытие браузера
        driver.quit();
    }
}
