package org.example;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

public class Ex2 {
    public void compareElements(WebElement element1, WebElement element2) {
        Point location1 = element1.getLocation();
        Point location2 = element2.getLocation();

        if (location1.getY() < location2.getY()) {
            System.out.println("Element 1 is above Element 2");
        } else {
            System.out.println("Element 2 is above Element 1");
        }

        if (location1.getX() < location2.getX()) {
            System.out.println("Element 1 is to the left of Element 2");
        } else {
            System.out.println("Element 2 is to the left of Element 1");
        }

        int area1 = element1.getSize().getHeight() * element1.getSize().getWidth();
        int area2 = element2.getSize().getHeight() * element2.getSize().getWidth();

        if (area1 > area2) {
            System.out.println("Element 1 has a larger area than Element 2");
        } else {
            System.out.println("Element 2 has a larger area than Element 1");
        }
    }

}
