package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumAmazon {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://www.amazon.com/");
            // Инициализация WebDriverWait с использованием Duration
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 секунд - максимальное время ожидания

            // Ожидание появления элемента для ввода текста по ID
            WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));
            searchInput.sendKeys("Apple iPhone 12 Mini, 64GB, Blue - Unlocked (Renewed)");

            // Ожидание появления кнопки для выполнения поиска по ID
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
            searchButton.click();

            // Ожидание появления результатов поиска

            List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'a-section aok-relative s-image-fixed-height')]")));

            if (results.size() == 16) {
                WebElement firstResult = results.get(0);
                firstResult.click();

                // Ожидание появления элементов с ценой
                List<WebElement> priceElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//td[contains(@class, 'a-span12')]")));

                if (priceElements.size() > 0) {
                    WebElement priceElement = priceElements.get(1); // Первый элемент с найденными ценами
                    String price = priceElement.getText();
                    System.out.println("Цена: " + price);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}

