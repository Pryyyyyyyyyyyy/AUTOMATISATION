package org.example;


// help meeeeee its terrible

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Ex2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.ashortjourney.com/");

        // Установка неявного ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Инициализация объекта Actions
        Actions actions = new Actions(driver);

        // Получение координат первого и третьего круга
        int x1 = driver.findElement(By.cssSelector("circle:nth-of-type(1)"))
                .getLocation().getX();
        int y1 = driver.findElement(By.cssSelector("circle:nth-of-type(1)"))
                .getLocation().getY();
        int x3 = driver.findElement(By.cssSelector("circle:nth-of-type(3)"))
                .getLocation().getX();
        int y3 = driver.findElement(By.cssSelector("circle:nth-of-type(3)"))
                .getLocation().getY();



        // Перемещение курсора к первому кругу и клик
        actions.moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).click().build().perform();

        // Задержка
        Thread.sleep(2000);


        WebElement firstCircle = driver.findElement(By.cssSelector("circle:nth-of-type(1)"));
        WebElement secondCircle = driver.findElement(By.cssSelector("circle:nth-of-type(3)"));

/*
        actions.moveToElement(secondCircle).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).release().build().perform();*/

        actions.dragAndDrop(secondCircle, firstCircle)
                .moveByOffset(x1 - x3, y1 - y3)
                .pause(Duration.ofMillis(500))
                .release()
                .build()
                .perform();



        // Задержка на 5секунд
        Thread.sleep(5000);

    }
}
