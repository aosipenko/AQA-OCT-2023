package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ToDoSeleniumRozetka {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://rozetka.com.ua/");
            WebElement searchInput = driver.findElement(By.name("search"));
            searchInput.sendKeys("iPhone 15 Pro");
            WebElement searchFind = driver.findElement(By.cssSelector("body > app-root > div > div > rz-header > rz-main-header > header > div > div > div > form > button"));
            searchFind.click();
        System.out.println("SUCCESS!");
    } finally {
        driver.quit();


        }
    }
}