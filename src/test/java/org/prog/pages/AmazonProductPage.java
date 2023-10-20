package org.prog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonProductPage {
        private WebDriver driver;
        private WebDriverWait wait;

        public AmazonProductPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public String getPrice() {
            List<WebElement> priceElements = wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy( By.xpath("//td[contains(@class, 'a-span12')]")));
            if (priceElements.size() > 0) {
                WebElement priceElement = priceElements.get(1); // Первый элемент с найденными ценами
                return priceElement.getText();
            }
            return "";
        }
    }
