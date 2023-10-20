package org.prog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonSearchResultsPage {
        private WebDriver driver;
        private WebDriverWait wait;

        public AmazonSearchResultsPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void clickOnFirstResult() {
            List<WebElement> results = wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy( By.xpath("//div[contains(@class, 'a-section aok-relative s-image-fixed-height')]")));
            if (results.size() > 0) {
                WebElement firstResult = results.get(0);
                firstResult.click();
            }
        }
    }
