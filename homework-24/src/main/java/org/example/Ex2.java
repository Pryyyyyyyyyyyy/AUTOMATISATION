package org.example;

<<<<<<< HEAD
=======

// help meeeeee its terrible

>>>>>>> github/master
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

<<<<<<< HEAD
public class Ex2 {
    private static class Url {
        private static final String ashortjourney = "http://www.ashortjourney.com/";
    }

    private static class Locators {
        private static final By r40 = By.cssSelector("[r = '40']");
        private static final By r8 = By.cssSelector("[r = '8']");
        private static final By textArea = By.cssSelector("textarea");
    }
=======
import java.time.Duration;

public class Ex2 {
>>>>>>> github/master

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
<<<<<<< HEAD
        Actions actions = new Actions(driver);
        driver.manage().window().maximize();
        driver.get(Url.ashortjourney);
        Thread.sleep(10000);

        WebElement r40v1 = driver.findElement(Locators.r40);
        WebElement r8v1 = driver.findElement(Locators.r8);
        int x = r8v1.getLocation().x + r8v1.getSize().width / 2;
        int y = r8v1.getLocation().y + r8v1.getSize().height / 2;
        actions.moveToElement(r40v1).clickAndHold().moveByOffset(x, y).release().build().perform();
        Thread.sleep(5000);

        WebElement r40v2 = driver.findElement(Locators.r40);
        WebElement r8v2 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v2, r8v2).perform();
        Thread.sleep(5000);

        WebElement r40v3 = driver.findElement(Locators.r40);
        WebElement r8v3 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v3, r8v3).perform();
        Thread.sleep(5000);

        WebElement r40v4 = driver.findElement(Locators.r40);
        WebElement r8v4 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v4, r8v4).perform();
        Thread.sleep(5000);

        WebElement r40v5 = driver.findElement(Locators.r40);
        WebElement r8v5 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v5, r8v5).perform();
        Thread.sleep(5000);

        WebElement r40v6 = driver.findElement(Locators.r40);
        WebElement r8v6 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v6, r8v6).perform();
        Thread.sleep(5000);

        WebElement r40v7 = driver.findElement(Locators.r40);
        WebElement r8v7 = driver.findElement(Locators.r8);
        actions.dragAndDrop(r40v7, r8v7).perform();
        Thread.sleep(5000);

        WebElement textArea = driver.findElement(Locators.textArea);
        textArea.sendKeys("Mission accomplished!");
        Thread.sleep(5000);


/*

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.ashortjourney.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
=======
        driver.get("http://www.ashortjourney.com/");

        // Установка неявного ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Инициализация объекта Actions
        Actions actions = new Actions(driver);

        // Получение координат первого и третьего круга
>>>>>>> github/master
        int x1 = driver.findElement(By.cssSelector("circle:nth-of-type(1)"))
                .getLocation().getX();
        int y1 = driver.findElement(By.cssSelector("circle:nth-of-type(1)"))
                .getLocation().getY();
        int x3 = driver.findElement(By.cssSelector("circle:nth-of-type(3)"))
                .getLocation().getX();
        int y3 = driver.findElement(By.cssSelector("circle:nth-of-type(3)"))
                .getLocation().getY();


<<<<<<< HEAD
        actions.moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).click().build().perform();
        Thread.sleep(2000);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait;
        wait = new WebDriverWait(driver,duration);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("circle:nth-of-type(3)")));

        if(element.isDisplayed()) {

            actions.moveToElement(element).build().perform();

            Thread.sleep(2000);
        }

=======

        // Перемещение курсора к первому кругу и клик
        actions.moveToElement(driver.findElement(By.cssSelector("circle:nth-of-type(1)"))).click().build().perform();

        // Задержка
        Thread.sleep(2000);

>>>>>>> github/master

        WebElement firstCircle = driver.findElement(By.cssSelector("circle:nth-of-type(1)"));
        WebElement secondCircle = driver.findElement(By.cssSelector("circle:nth-of-type(3)"));

<<<<<<< HEAD
*/
/*
        actions.moveToElement(secondCircle).pause(Duration.ofSeconds(2)).click().pause(Duration.ofSeconds(2)).release().build().perform();*//*

        Thread.sleep(2000);
        actions.dragAndDrop(secondCircle, firstCircle)
                .moveByOffset(x1 - x3, y1 - y3)
                .pause(Duration.ofMillis(500))
             */
/*   .release()
                .build()*//*

                .perform();
        actions.release().build().perform();

        Thread.sleep(5000);
        }
        }
*/
=======
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
>>>>>>> github/master

    }
}
