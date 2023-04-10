package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex2a {
    public static void main(String[] args) {
        // Указываем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создаем экземпляр WebDriver
        WebDriver driver = new ChromeDriver();

        // Открываем страницу
        driver.get("https://klopotenko.com/");

        // Получаем два элемента на странице
        WebElement element1 = driver.findElement(By.id("ranna-style-inline-css"));
        WebElement element2 = driver.findElement(By.id("header-2"));

        // Вызываем метод compareElements и передаем в него два элемента
        Ex2 ex2 = new Ex2();
        ex2.compareElements(element1, element2);

    }
}
