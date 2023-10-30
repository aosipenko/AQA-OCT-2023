package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            WebElement element = driver.findElement(By.className("cart-product__price cart-product__price--red"));
            String value = element.getText(); //8&nbsp999
            String updatedValue = value.replace("&nbsp;", ""); //8999
            Integer.valueOf(updatedValue);
            JavascriptExecutor executor = (JavascriptExecutor) driver;

        } finally {
            driver.quit();
        }
    }
}
