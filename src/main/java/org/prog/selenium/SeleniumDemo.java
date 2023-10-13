package org.prog.selenium;

import org.openqa.selenium.By;
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
            new WebDriverWait(driver, Duration.ofSeconds(30L))
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//ul[@role='listbox']/li"), 2));
            WebElement searchBtn = driver.findElements(By.xpath("//input[@name='btnK']")).get(0);
            searchBtn.click();
            List<WebElement> searchResults = new WebDriverWait(driver, Duration.ofSeconds(30L))
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a/h3"), 5));

            boolean searchSuccesss = searchResults.stream().anyMatch(webElement -> webElement.getText().contains("Bill Gates"));
            if (!searchSuccesss) {
                throw new RuntimeException("Bill Gates not found!");
            }
            System.out.println("SUCCESS!");
        } finally {
            driver.quit();
        }
    }
}
