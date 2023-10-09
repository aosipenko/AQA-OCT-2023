package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/");
        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        if (buttons.size() == 5) {
            //we see cookies!
            WebElement element = buttons.get(3);
            element.click();
        }
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Bill Gates");
        searchInput.click();
        Thread.sleep(1500);
        WebElement searchBtn = driver.findElements(By.xpath("//input[@name='btnK']")).get(0);
        searchBtn.click();
        driver.quit();
    }

}
