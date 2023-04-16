package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Rrr {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.ashortjourney.com/");

/*
        // Ожидание 25 секунд
        Thread.sleep(25000);*/


        // Set the implicit wait timeout

        Duration timeout = Duration.ofSeconds(10);


        // Установка неявного ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Инициализация объекта Actions
        Actions builder = new Actions(driver);

        // Получение координат первого и третьего круга
        WebElement element1 = driver.findElement(By.cssSelector("circle:nth-of-type(1)"));
        Point location1 = element1.getLocation();
        int x1 = location1.getX();
        int y1 = location1.getY();
        WebElement element2 = driver.findElement(By.cssSelector("circle:nth-of-type(3)"));

        // Перемещение курсора к первому кругу и клик с удержанием
        builder.moveToElement(element1).clickAndHold().perform();

        // Задержка на 2 секунды
        Thread.sleep(2000);

        int x2 = driver.findElement(By.cssSelector("circle:nth-of-type(2)"))
                .getLocation().getX();
        int y2 = driver.findElement(By.cssSelector("circle:nth-of-type(2)"))
                .getLocation().getY();


       /* // Перемещение курсора к третьему кругу и клик с удержанием
        Point location2 = element2.getLocation();
        int x3 = location2.getX();
        int y3 = location2.getY();
        builder.moveByOffset(x3 - x1, y3 - y1).release().perform();
*/
    }
}

/*

// Инициализируем объект Actions
        Actions actions = new Actions(driver);

        //moveByOffset() позволяет наводить курсор на элемент по координатам.
*/

        /*System.out.println(driver.findElement(By.cssSelector("circle:nth-of-type(1)")).getLocation());
        System.out.println(driver.findElement(By.cssSelector("circle:nth-of-type(3)")).getSize());
        int x = driver.findElement(By.cssSelector("circle:nth-of-type(1)"))
                        .getLocation().x+
                (driver.findElement(By.cssSelector("circle:nth-of-type(1)"))
                        .getSize().width);
        int y = driver.findElement(By.cssSelector("circle:nth-of-type(3)"))
                .getLocation().y+
                (driver.findElement(By.cssSelector("circle:nth-of-type(3)"))
                        .getSize().height);
        System.out.println(x);
        System.out.println(y);
        Thread.sleep(2000);
        actions.moveByOffset(x,y).build().perform();

        WebElement firstCircle = driver.findElement(By.cssSelector("circle:nth-of-type(1)"));
        Thread.sleep(2000);
        firstCircle.click();
        Thread.sleep(2000);
        WebElement secondCircle = driver.findElement(By.cssSelector("circle:nth-of-type(3)"));
        actions.clickAndHold().moveToElement(secondCircle).release().build().perform();
        actions.dragAndDrop(firstCircle,secondCircle).perform();*/

