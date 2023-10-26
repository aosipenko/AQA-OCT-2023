package org.prog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonHomePage {
        private WebDriver driver;
        private WebDriverWait wait;

        public AmazonHomePage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        public void searchForProduct(String product) {
            WebElement searchInput = wait.until( ExpectedConditions.presenceOfElementLocated( By.id("twotabsearchtextbox")));
            searchInput.sendKeys(product);

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
            searchButton.click();
        }
    }
