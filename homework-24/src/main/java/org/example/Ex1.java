package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ex1 {
    public static void main(String[] args) throws InterruptedException {
        // Установка пути к драйверу
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        // Создание экземпляра веб-драйвера
        WebDriver driver = new ChromeDriver();
        // Перейти на страницу
        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html");
        // Задержка на 2 секунды
        Thread.sleep(2000);

        // Находим элемент с помощью его id
        WebElement checkbox = driver.findElement(By.id("check1"));

        // Кликаем на элемент

        checkbox.click();
        // Находим элемент с помощью его id
        WebElement checkbox1 = driver.findElement(By.id("check2"));

        // Кликаем на элемент
        checkbox1.click();

        // Задержка на 2 секунды
        Thread.sleep(2000);
        // Найти элемент select с id = "Carlist" и кликнуть на него
        WebElement carList = driver.findElement(By.id("Carlist"));
        carList.click();
        // Задержка на 2 секунды
        Thread.sleep(2000);
        // Выбрать из списка элемент с id = "car6" и значением "Renault Car"
        WebElement renault = driver.findElement(By.cssSelector("option[id='car6'][value='Renault Car']"));
        renault.click();
        // Задержка на 2 секунды
        Thread.sleep(2000);
        // Перейти к элементу select с name = "FromLB"
        WebElement fromList = driver.findElement(By.name("FromLB"));
        Select fromSelect = new Select(fromList);
        // Выбрать элемент с текстом "France"
        fromSelect.selectByVisibleText("France");
        // Выбрать элемент с id = "country6" и значением "Germany"
        WebElement germany = driver.findElement(By.cssSelector("option[id='country6'][value='Germany']"));
        fromSelect.selectByVisibleText("Germany");
        // Выбрать элемент с id = "country7" и значением "Italy"
        WebElement italy = driver.findElement(By.cssSelector("option[id='country7'][value='Italy']"));
        fromSelect.selectByVisibleText("Italy");
        // Выбрать элемент с id = "country9" и значением "Malaysia"
        WebElement malaysia = driver.findElement(By.cssSelector("option[id='country9'][value='Malaysia']"));
        fromSelect.selectByVisibleText("Malaysia");
        // Снять выбор с элемента с id = "country9" и значением "Malaysia"
        fromSelect.deselectByValue("Malaysia");
        // Выбрать элемент с id = "country8" и значением "Spain"
        WebElement spain = driver.findElement(By.cssSelector("option[id='country8'][value='Spain']"));
        fromSelect.selectByVisibleText("Spain");
        // Задержка на 2 секунды
        Thread.sleep(2000);
        // Кликнуть на кнопку ">"
        WebElement moveButton = driver.findElement(By.xpath("//input[@onclick='move(this.form.FromLB,this.form.ToLB)']"));
        moveButton.click();
        // Задержка на 2 секунды
        Thread.sleep(2000);
        // Закрываем веб-драйвер
        driver.quit();
    }

}