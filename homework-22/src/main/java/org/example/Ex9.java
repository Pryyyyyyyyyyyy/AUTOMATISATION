package org.example;


import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.util.concurrent.TimeUnit;

public class Ex9 {

    public static void main(String[] args) throws InterruptedException {

        // Установка пути к драйверу
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();

        // Перейти на главную страницу
        driver.get("https://www.jetbrains.com/idea/");

        // Найти элемент по имени класса и сделать клик
        WebElement downloadButton = driver.findElement(By.className("menu-second__download-button"));
        downloadButton.click();

        // Задержка на 2 секунды
        TimeUnit.SECONDS.sleep(2);

        // Закрыть браузер
        driver.quit();
    }
}
