package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PaymentAndDeliveryTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        // Устанавливаем путь к драйверу и создаем объект драйвера
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        // Создаем объект ожидания и задаем время ожидания в 10 секунд
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testPaymentAndDeliveryLink() {
        // Открываем сайт
        driver.get("https://uhomki.com.ua/ru/");

        // Находим и нажимаем на кнопку "Оплата и доставка"
        WebElement paymentAndDeliveryLink = driver.findElement(By.xpath("//a[@href='/ru/oplata-i-dostavka/']"));
        paymentAndDeliveryLink.click();

        // Дожидаемся загрузки страницы с нужным заголовком
        wait.until(ExpectedConditions.titleContains("зоомагазин"));

        Assert.assertTrue(driver.getCurrentUrl().equals("https://uhomki.com.ua/ru/oplata-i-dostavka/"));
    }

    private void waitForTitleIs(String title) {
        wait.until(ExpectedConditions.titleIs(title));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
