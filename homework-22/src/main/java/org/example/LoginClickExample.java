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

        // Используем 4 различных локатора для поиска кнопки вход

        // XPath contains
        WebElement loginBtn1 = driver.findElement(By.xpath("//span[contains(text(), 'Вход')]"));
        loginBtn1.click();
        Thread.sleep(1000); // Пауза

        // Имитируем клик вне окна логина, чтобы закрыть окно
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 100).click().build().perform();
        Thread.sleep(1000); // Пауза

        // CSS Selector
        WebElement loginBtn2 = driver.findElement(By.cssSelector("span.userbar__button-text"));
        loginBtn2.click();
        Thread.sleep(1000); // Пауза

        // Имитируем клик вне окна логина, чтобы закрыть окно
        Actions actions1 = new Actions(driver);
        actions1.moveByOffset(0, 100).click().build().perform();
        Thread.sleep(1000); // Пауза

        // XPath с использованием локатора linkText
        WebElement loginBtn = driver.findElement(By.linkText("Вход"));
        loginBtn.click();

        Thread.sleep(1000); // Пауза
        // Имитируем клик вне окна логина, чтобы закрыть окно
        Actions actions3 = new Actions(driver);
        actions3.moveByOffset(0, 100).click().build().perform();
        Thread.sleep(1000); // Пауза

        // Использование xpath text для элемента вход
        WebElement loginBtn4 = driver.findElement(By.xpath("//span[text()='Вход']"));
        loginBtn4.click();
        Thread.sleep(1000); // Пауза

            // Имитируем клик вне окна логина, чтобы закрыть окно
            Actions actions4 = new Actions(driver);
            actions4.moveByOffset(0, 100).click().build().perform();
            Thread.sleep(1000); // Пауза

        // Закрываем браузер
        driver.quit();
    }
}
