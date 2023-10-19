package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ToDoSeleniumRozetka {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://rozetka.com.ua/");
            WebElement searchInput = driver.findElement(By.name("search"));
            searchInput.sendKeys("iPhone 15 Pro");
            WebElement searchFind = driver.findElement(By.cssSelector("body > app-root > div > div > rz-header > rz-main-header > header > div > div > div > form > button"));
            searchFind.click();
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("goods-tile__content")));

            List<WebElement> iPhone15Pro = driver.findElements(By.className("goods-tile__content"));

            // Для первого Iphone 15 Pro на странице

            WebElement firstProductElement = driver.findElement(By.className("goods-tile__content"));

            WebElement priceIphone = firstProductElement.findElement(By.className("goods-tile__price-value"));
            WebElement descriptionIphone = firstProductElement.findElement(By.className("goods-tile__title"));

            String price = priceIphone.getText();
            String description = descriptionIphone.getText();
            System.out.println("Цена и описание первого iPhone 15 Pro");
            System.out.println("====================");
            System.out.println("Цена: " + price);
            System.out.println("Описание: " + description);
            System.out.println("====================");

            //Для всех найденных iPhone 150 Pro на странице
            System.out.println("--------------------");
            System.out.println("Цена и описание каждого iPhone 150 Pro на странице");
            System.out.println("--------------------");
            for (WebElement productElement : iPhone15Pro) {
                WebElement priceEveryIphone = productElement.findElement(By.className("goods-tile__price-value"));
                WebElement descriptionEveryIphone = productElement.findElement(By.className("goods-tile__title"));

                String everyPrice = priceEveryIphone.getText();
                String everyDescription = descriptionEveryIphone.getText();

                System.out.println("Цена: " + everyPrice);
                System.out.println("Описание: " + everyDescription);
                System.out.println("--------------------");
            }


    } finally {
            System.out.println("SUCCESS!");
        driver.quit();


        }
    }
}