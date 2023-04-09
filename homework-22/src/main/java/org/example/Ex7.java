package org.example;

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// ELEMENTS WHICH COMMENTED IS NOT INTERACTABLE BUT THEY`RE CAN BE FIND BY ID

import java.util.concurrent.TimeUnit;

public class Ex7 {
    public static void main(String[] args) throws InterruptedException {
        // Устанавливаем путь к драйверу браузера Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создаем экземпляр веб-драйвера Chrome
        WebDriver driver = new ChromeDriver();

        // Ожидание неявного ожидания элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Открываем страницу https://www.w3schools.com/
        driver.get("https://www.w3schools.com/");

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Находим элемент с id "search2" и кликаем на него
        WebElement searchInput = driver.findElement(By.id("search2"));
        searchInput.click();

        // Выводим сообщение "Элемент найден"
        System.out.println("Элемент 1 найден");

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Возвращаемся на главную страницу
        driver.get("https://www.w3schools.com/");

        // Находим элемент с id "signupbtn_topnav" и кликаем на него
        WebElement signUpBtn = driver.findElement(By.id("signupbtn_topnav"));
        signUpBtn.click();

        // Выводим сообщение "Элемент найден"
        System.out.println("Элемент 2 найден");

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Возвращаемся на главную страницу
        driver.get("https://www.w3schools.com/");

      /*  // Находим элемент с id "navbtn_menu" и кликаем на него
        WebElement menuBtn = driver.findElement(By.id("navbtn_menu"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menuBtn).build().perform();
        *//*menuBtn.click()*/
/*
        // Выводим сообщение "Элемент найден"
        System.out.println("Элемент 3 найден");*/

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Возвращаемся на главную страницу
        driver.get("https://www.w3schools.com/");

        // Находим элемент с id "learntocode_searchbtn" и кликаем на него
        WebElement searchBtn = driver.findElement(By.id("learntocode_searchbtn"));
        searchBtn.click();

        // Выводим сообщение "Элемент найден"
        System.out.println("Элемент 4 найден");

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Возвращаемся на главную страницу
        driver.get("https://www.w3schools.com/");

        /*// Находим элемент с id "learntocode_searchicon" и кликаем на него
        WebElement searchIcon = driver.findElement(By.id("learntocode_searchicon"));
        searchIcon.click();

        // Выводим сообщение "Элемент найден"
        System.out.println("Элемент 5 найден");*/

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Возвращаемся на главную страницу
        driver.get("https://www.w3schools.com/");

        /*// Находим элемент с id "listofsearchresults" и кликаем на него
        WebElement searchResults = driver.findElement(By.id("listofsearchresults"));
        searchResults.click();

        // Выводим сообщение "Элемент найден"
        System.out.println("Элемент 6 найден");*/

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Возвращаемся на главную страницу
        driver.get("https://www.w3schools.com/");

// Находим  элемент  и перемещаем на него курсор
        WebElement element7 = driver.findElement(By.id("wavepath"));
        element7.click();

        // Выводим сообщение, что элемент найден
        System.out.println("Элемент 7 найден");

        // Делаем задержку 2 секунды
        Thread.sleep(2000);

        // Возвращаемся на главную страницу
        driver.get("https://www.w3schools.com/");

        // Находим  элемент и перемещаем на него курсор
        WebElement element8 = driver.findElement(By.id("wavepath"));
        element8.click();

        // Выводим сообщение, что элемент найден
        System.out.println("Элемент 8 найден");

        // Делаем задержку 2 секунды
        Thread.sleep(2000);

        // Возвращаемся на главную страницу
        driver.get("https://www.w3schools.com/");

        /*// Находим девятый и кликаем на него
        WebElement element9 = driver.findElement(By.id("spacesbtn_topnav"));
        element9.click();

        // Выводим сообщение, что элемент найден
        System.out.println("Элемент 9 найден");
*/
        // Делаем задержку 2 секунды
        Thread.sleep(2000);

        // Возвращаемся на главную страницу
        driver.get("https://www.w3schools.com/");

        // Находим десятый и кликаем на него
        WebElement element10 = driver.findElement(By.id("w3loginbtn"));
        element10.click();

        // Выводим сообщение, что элемент найден
        System.out.println("Элемент 10 найден");

        // Закрываем веб-драйвер
        driver.quit();
    }

    // Метод для задержки выполнения кода
    public static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

/*    // Метод для перемещения курсора на элемент
    public static void moveToElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }*/
}