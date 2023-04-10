package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex3a {

    public static class AttributeNotFoundException extends Exception {
        public AttributeNotFoundException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // запуск браузера в фоновом режиме, чтобы не отображать окно браузера

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://klopotenko.com/");

        WebElement element = driver.findElement(By.id("media_image-10"));

        String id = element.getAttribute("id");
        String tag = element.getTagName();
        String className = element.getAttribute("class");
        String name = element.getAttribute("name");
        String text = element.getText();
        Point center = getCenter(element);

        System.out.println("Element ID: " + id);
        System.out.println("Element Tag: " + tag);
        System.out.println("Element Class: " + className);
        System.out.println("Element Name: " + name);
        System.out.println("Element Text: " + text);
        System.out.println("Element Center Coordinates: (" + center.getX() + ", " + center.getY() + ")");

        try {
            String customAttribute = element.getAttribute("name");
            if (customAttribute == null) {
                throw new AttributeNotFoundException("Attribute 'name' not found for element.");
            }
            System.out.println("Element Name: " + customAttribute);
        } catch (AttributeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        driver.quit();
    }

    private static Point getCenter(WebElement element) {
        int centerX = element.getLocation().getX() + element.getSize().getWidth() / 2;
        int centerY = element.getLocation().getY() + element.getSize().getHeight() / 2;
        return new Point(centerX, centerY);
    }

}
