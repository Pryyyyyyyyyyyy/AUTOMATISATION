package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Ex1 {
    public static void main(String[] args) {
        // Установка пути к драйверу для Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

        // Создание экземпляра WebDriver для Chrome
        WebDriver driver = new ChromeDriver();

        // Установка неявного ожидания
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Открытие страницы поиска Google
        driver.get("https://www.google.com/search");

        // Находим элемент поисковой строки и вводим ссылку на регистрацию Guinness World Records
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("https://www.guinnessworldrecords.com/account/register?");
        searchInput.submit();

        // Находим элемент результата поиска и выполняем действие MoveTo
        WebElement searchResult = driver.findElement(By.cssSelector("a[href='https://www.guinnessworldrecords.com/account/register']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(searchResult).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Открываем найденный элемент в новом окне браузера в фоне
        String link = searchResult.getAttribute("href");
        String script = "window.open('" + link + "', '_blank');";
        ((JavascriptExecutor) driver).executeScript(script);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

// получаем список всех открытых окон
        Set<String> handles = driver.getWindowHandles();
// переключаемся на нужное окно
        for (String handle : handles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("https://www.guinnessworldrecords.com/account/register? - Пошук Google")) {
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        WebElement searchButton = driver.findElement(By.id("APjFqb"));
        searchButton.click();


        // Находим элемент поисковой строки и вводим ссылку на страницу AlertsDemo
        WebElement searchInput1 = driver.findElement(By.id("APjFqb"));
        searchInput1.clear();
        searchInput1.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        searchInput1.submit();

        // Находим элемент результата поиска и выполняем действие MoveTo
        searchResult = driver.findElement(By.cssSelector("a[href='https://www.hyrtutorials.com/p/alertsdemo.html']"));
        actions = new Actions(driver);
        actions.moveToElement(searchResult).perform();

        // Открываем найденный элемент в новом окне браузера в фоне
        link = searchResult.getAttribute("href");
        script = "window.open('" + link + "', '_blank');";
        ((JavascriptExecutor) driver).executeScript(script);

        // Максимальное ожидание загрузки страницы в 10 секунд
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        // Переход на страницу https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");

        // Ожидаем загрузки страницы
        Duration timeoutDuration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
        wait.until(ExpectedConditions.titleContains("W3Schools Tryit Editor"));
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        String expectedTitle = "W3Schools Tryit Editor";
        Set<String> handles1 = driver.getWindowHandles();

        for (String handle : handles1) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();
            if (title.equals(expectedTitle)) {
                break;
            }
        }
// Находим фрейм по его индексу
        WebElement frame = driver.findElement(By.cssSelector("iframe[id='iframeResult']"));

        driver.switchTo().frame(frame);

// Теперь находим элемент внутри фрейма и взаимодействуем с ним
        WebElement textarea = driver.findElement(By.id("fname"));
        textarea.clear();
        textarea.sendKeys("Аніцька");

        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);

        WebElement textarea2 = driver.findElement(By.id("lname"));
        textarea2.clear();
        textarea2.sendKeys("Прус");

        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);

        WebElement submitButton = driver.findElement(By.cssSelector("input[value='Submit']"));
        submitButton.click();


        System.out.println("Note: This tutorial will not teach you how servers are processing input. Processing input is explained in our PHP tutorial.");



        // Неявное ожидание в 2 секунды
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



// переключаемся на нужное окно
        String expectedTitle2 = "Create account | Guinness World Records";
        Set<String> handles2 = driver.getWindowHandles();

        for (String handle : handles2) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();
            if (driver.getTitle().equals("Create account | Guinness World Records")) {
                break;
            }
        }

        // Неявное ожидание в 2 секунды
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        // Заполнение полей формы
        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.click();
        lastNameInput.sendKeys("Prus");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement lastNameInput2 = driver.findElement(By.id("FirstName"));
        lastNameInput2.click();
        lastNameInput2.sendKeys("Hanna");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement lastNameInput3 = driver.findElement(By.id("DateOfBirthDay"));
        lastNameInput3.click();
        lastNameInput3.sendKeys("27");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement lastNameInput4 = driver.findElement(By.id("DateOfBirthMonth"));
        lastNameInput4.click();
        lastNameInput4.sendKeys("08");


        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement lastNameInput5 = driver.findElement(By.id("DateOfBirthYear"));
        lastNameInput5.click();
        lastNameInput5.sendKeys("1993");


        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement lastNameInput6 = driver.findElement(By.id("EmailAddress"));
        lastNameInput6.click();
        lastNameInput6.sendKeys("meowmeow@mail.com");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement lastNameInput7 = driver.findElement(By.id("ConfirmEmailAddress"));
        lastNameInput7.click();
        lastNameInput7.sendKeys("meowmeow@mail.com");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement lastNameInput8 = driver.findElement(By.id("Password"));
        lastNameInput8.click();
        lastNameInput8.sendKeys("meowmeow01");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement lastNameInput9 = driver.findElement(By.id("ConfirmPassword"));
        lastNameInput9.click();
        lastNameInput9.sendKeys("meowmeow02");


        // Находим элемент "Create a Password" и кликаем на него
        WebElement createPassword = driver.findElement(By.xpath("//h2[contains(text(), 'Create a Password')]"));
        createPassword.click();

        // Выводим сообщение об ошибке в консоль
         System.out.println("'Confirm password' and 'Password' do not match.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // переключаемся на нужное окно
        String expectedTitle5 = "AlertsDemo - H Y R Tutorials";
        Set<String> handles5 = driver.getWindowHandles();

        for (String handle : handles5) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();
            if (driver.getTitle().equals("AlertsDemo - H Y R Tutorials")) {
                break;
            }
        }
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Нажатие на кнопку alertBox
        WebElement alertBoxBtn = driver.findElement(By.id("alertBox"));
        alertBoxBtn.click();

        // Ожидание появления модального окна и нажатие кнопки "Ok"
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
        Alert alert = wait1.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Вывод сообщения в консоль
        System.out.println("I am an alert box!");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // инициализируем объект Actions и используем его для выполнения клика на другом элементе
        Actions actions7 = new Actions(driver);
        WebElement otherElement = driver.findElement(By.xpath("//div[@class='grippy-host']"));
        actions.moveToElement(otherElement).click().build().perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

// теперь, когда фокус снят с элемента, который перекрывает кнопку, мы можем кликнуть по кнопке
        WebElement confirmButton = driver.findElement(By.xpath("//button[@id='confirmBox']"));
        confirmButton.click();

*/
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert aler2 = wait2.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();

        System.out.println("Press a button!");


        // Вывод сообщения в консоль

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);


        // Нажатие на кнопку promptBox
        WebElement promptBoxBtn = driver.findElement(By.id("promptBox"));
        promptBoxBtn.click();

        // Ожидание появления модального окна, ввод текста и нажатие кнопки "Ok"
        alert = wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        alert.sendKeys("Final step of this task");
        alert.accept();

        // Вывод сообщения в консоль
        System.out.println("You entered text Final step of this task in prompt popup");
        // Закрытие браузера
        driver.quit();
    }
}
