package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginClickExample {
    public static void main(String[] args) throws InterruptedException {
        // Устанавливаем путь к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создаем экземпляр драйвера Chrome
        WebDriver driver = new ChromeDriver();

        // Открываем страницу с окном логина
        driver.get("https://uhomki.com.ua/koshki/1074/");

        // Используем 4 различных локатора для поиска кнопки "Вход" и выполнения клика
        // И после каждого клика на кнопку "Вход" кликаем на элемент, закрывающий окно

        // 1. XPath contains
        WebElement loginBtn1 = driver.findElement(By.xpath("//span[contains(text(), 'Вход')]"));
        loginBtn1.click();
        Thread.sleep(1000); // Пауза для демонстрации
        // Имитируем клик вне окна логина, чтобы закрыть окно
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 100).click().build().perform();
        Thread.sleep(1000); // Пауза для демонстрации

        // 2. CSS Selector
        WebElement loginBtn2 = driver.findElement(By.cssSelector("span.userbar__button-text"));
        loginBtn2.click();
        Thread.sleep(1000); // Пауза для демонстрации
        // Имитируем клик вне окна логина, чтобы закрыть окно
        Actions actions1 = new Actions(driver);
        actions1.moveByOffset(0, 100).click().build().perform();
        Thread.sleep(1000); // Пауза для демонстрации

        // 3. XPath с использованием локатора linkText
        WebElement loginBtn = driver.findElement(By.linkText("Вход"));
        loginBtn.click();

        Thread.sleep(1000); // Пауза для демонстрации
        // Имитируем клик вне окна логина, чтобы закрыть окно
        Actions actions3 = new Actions(driver);
        actions3.moveByOffset(0, 100).click().build().perform();
        Thread.sleep(1000); // Пауза для демонстрации

        // 4. Использование xpath text для элемента "Вход"
        WebElement loginBtn4 = driver.findElement(By.xpath("//span[text()='Вход']"));
        loginBtn4.click();
        Thread.sleep(1000); // Пауза для демонстрации
            // Имитируем клик вне окна логина, чтобы закрыть окно
            Actions actions4 = new Actions(driver);
            actions4.moveByOffset(0, 100).click().build().perform();
            Thread.sleep(1000); // Пауза для демонстрации

        // Закрываем браузер
        driver.quit();
    }
}
