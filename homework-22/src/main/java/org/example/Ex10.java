package org.example;

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Ex10 {
    public static void main(String[] args) {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создание экземпляра драйвера Chrome
        WebDriver driver = new ChromeDriver();

        // Открытие главной страницы
        driver.get("https://www.jetbrains.com/idea/download/#section=windows");

        // Нахождение первого элемента и вывод сообщения в консоль
        WebElement firstButton = driver.findElement(By.cssSelector("a[data-test='dropdown-button-link']"));
        System.out.println("1 элемент");

        // Задержка 2 секунды
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Наведение курсора на первый элемент
        Actions actions = new Actions(driver);
        actions.moveToElement(firstButton).build().perform();

        // Задержка 2 секунды
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Нахождение второго элемента и вывод сообщения в консоль
        WebElement secondButton = driver.findElement(By.cssSelector("a[data-test='dropdown-button-link'][href*='code=IIC']"));
        System.out.println("2 элемент");

        // Задержка 2 секунды
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Закрытие браузера
        driver.quit();
    }
}
