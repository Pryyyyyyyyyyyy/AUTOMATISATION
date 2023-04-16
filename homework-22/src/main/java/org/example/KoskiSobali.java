package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KoskiSobali {
    public static void main(String[] args) throws InterruptedException {
        // Установка пути к драйверу Chrome
        System.setProperty(import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

        public class AutomateTest {
            public static void main(String[] args) {

                // Устанавливаем путь к драйверу Chrome
                System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");

                // Создаем экземпляр веб-драйвера
                WebDriver driver = new ChromeDriver();

                // Открываем страницу с таблицами
                driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");

                // Получаем список автомобилей
                WebElement carList = driver.findElement(By.xpath("//div[@id='cars']/ul"));

                // Выводим список автомобилей
                System.out.println("Автомобили доступные для выбора:");
                for (WebElement car : carList.findElements(By.tagName("li"))) {
                    System.out.println(car.getText());
                }

                // Получаем список стран из первой таблицы
                WebElement countryList1 = driver.findElement(By.xpath("//table[@id='Table1']/tbody"));

                // Выводим список стран из первой таблицы
                System.out.println("Страны из первой таблицы:");
                for (WebElement country : countryList1.findElements(By.tagName("tr"))) {
                    System.out.println(country.findElement(By.tagName("td")).getText());
                }

                // Получаем список стран из второй таблицы
                WebElement countryList2 = driver.findElement(By.xpath("//table[@id='Table2']/tbody"));

                // Выводим список стран из второй таблицы
                System.out.println("Страны из второй таблицы:");
                for (WebElement country : countryList2.findElements(By.tagName("tr"))) {
                    System.out.println(country.findElement(By.tagName("td")).getText());
                }

                // Закрываем браузер
                driver.quit();
            }
        }
);

        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();

        // Открытие сайта
        driver.get("https://uhomki.com.ua/ru/koshki/1074/");

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Клик на элемент "Каталог"
        WebElement catalogElement = driver.findElement(By.xpath("/html/body/div[2]/footer/div/div/div/div[2]/div/div/div"));
        catalogElement.click();

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Клик на элемент "Собаки/кошки общее"
        WebElement commonElement = driver.findElement(By.xpath("/html/body/div[2]/footer/div/div/div/div[2]/div/div/ul/li[3]/a"));
        commonElement.click();

        // Задержка 2 секунды
        Thread.sleep(2000);

        // Закрытие браузера
        driver.quit();
    }
}
