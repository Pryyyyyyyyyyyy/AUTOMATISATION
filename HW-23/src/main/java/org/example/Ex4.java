package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex4 {

    public static void main(String[] args) {

        // Указываем путь к chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создаем экземпляр ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Открываем страницу
        driver.get("https://uhomki.com.ua/ru/gryzuny/1098/");

        // Получаем список всех элементов
        java.util.List<WebElement> elements = driver.findElements(By.cssSelector("div.header__layout"));

        // Выводим тексты всех найденных элементов
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        // Открываем страницу
        driver.get("https://uhomki.com.ua/ru/gryzuny/1098/");

        // Получаем список всех элементов
        elements = driver.findElements(By.cssSelector("div.products-menu"));

        // Выводим тексты всех найденных элементов
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        // Закрываем браузер
        driver.quit();
    }
}
