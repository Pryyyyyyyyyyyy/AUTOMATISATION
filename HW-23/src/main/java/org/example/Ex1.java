package org.example;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Ex1 {
    public static void main(String[] args) throws InterruptedException {
        // Указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создаем экземпляр драйвера
        WebDriver driver = new ChromeDriver();

        // Открываем первую страницу
        driver.get("https://uhomki.com.ua/ru/koshki/1074/");

        // Ожидаем 2 секунды
        Thread.sleep(2000);

        // Выводим в консоль сообщение
        System.out.println("Ссылка открыта");

        // Открываем новое окно
        ((JavascriptExecutor) driver).executeScript("window.open('https://uhomki.com.ua/ru/koshki/1074/', '_blank');");

        // Получаем список открытых окон
        Set<String> windows = driver.getWindowHandles();

        // Итерируемся по списку окон
        Iterator<String> it = windows.iterator();

        // Переключаемся на новое окно
        String originalWindow = it.next();
        String newWindow = it.next();
        driver.switchTo().window(newWindow);

        // Открываем вторую страницу
        driver.get("https://zoo.kiev.ua/");

        // Ожидаем 2 секунды
        Thread.sleep(2000);

        // Выводим в консоль сообщение
        System.out.println("Ссылка открыта");

        // Открываем новое окно
        ((JavascriptExecutor) driver).executeScript("window.open('https://zoo.kiev.ua/', '_blank');");

        // Получаем список открытых окон
        windows = driver.getWindowHandles();

        // Итерируемся по списку окон
        it = windows.iterator();

        // Переключаемся на новое окно
        originalWindow = it.next();
        newWindow = it.next();
        driver.switchTo().window(newWindow);

        // Открываем третью страницу
        driver.get("https://www.w3schools.com/");

        // Ожидаем 2 секунды
        Thread.sleep(2000);

        // Выводим в консоль сообщение
        System.out.println("Ссылка открыта");

        // Открываем новое окно
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.w3schools.com/', '_blank');");

        // Получаем список открытых окон
        windows = driver.getWindowHandles();

        // Итерируемся по списку окон
        it = windows.iterator();

        // Переключаемся на новое окно
        originalWindow = it.next();
        newWindow = it.next();
        driver.switchTo().window(newWindow);

        // Открываем четвертую страницу
        driver.get("https://taxi838.ua/ru/dnepr/");
        // Ожидаем 2 секунды
        Thread.sleep(2000);

        // Выводим в консоль сообщение
        System.out.println("Ссылка открыта");

        // Открываем новое окно
        ((JavascriptExecutor) driver).executeScript("window.open('https://taxi838.ua/ru/dnepr/', '_blank');");

        // Получаем список открытых окон
        windows = driver.getWindowHandles();

        // Итерируемся по списку окон
        it = windows.iterator();

        // Переключаемся на новое окно
        originalWindow = it.next();
        newWindow = it.next();
        driver.switchTo().window(newWindow);
        // Открываем пятую страницу
        driver.get("https://klopotenko.com/");
        // Ожидаем 2 секунды
        Thread.sleep(2000);

        // Выводим в консоль сообщение
        System.out.println("Ссылка открыта");

        // Открываем новое окно
        ((JavascriptExecutor) driver).executeScript("window.open('https://klopotenko.com/', '_blank');");

        // Получаем список открытых окон
        windows = driver.getWindowHandles();

        // Итерируемся по списку окон
        it = windows.iterator();

        // Переключаемся на новое окно
        originalWindow = it.next();
        newWindow = it.next();
        driver.switchTo().window(newWindow);

        // Получаем список открытых окон
        windows = driver.getWindowHandles();

// Итерируемся по списку окон
        it = windows.iterator();

// Переключаемся на первое окно
        driver.switchTo().window(originalWindow);

// Цикл для переключения между страницами
        while (it.hasNext()) {
            String currentWindow = it.next();
            driver.switchTo().window(currentWindow);

            // Выводим название и ссылку на страницу
            System.out.println("Название страницы: " + driver.getTitle());
            System.out.println("Ссылка на страницу: " + driver.getCurrentUrl());

            // Если в названии страницы есть слово "зоопарк", закрываем эту страницу
            if (driver.getTitle().toLowerCase().contains("зоопарк")) {
                driver.close();
            }
        }



    }
}