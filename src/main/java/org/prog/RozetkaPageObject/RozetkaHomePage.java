package org.prog.RozetkaPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RozetkaHomePage {
    private WebDriver driver;

    public RozetkaHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://rozetka.com.ua/");
    }

    public void searchForProduct(String productName) {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys(productName);
        WebElement searchButton = driver.findElement(By.cssSelector("body > app-root > div > div > rz-header > rz-main-header > header > div > div > div > form > button"));
        searchButton.click();
    }

    public void waitForSearchResults() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("goods-tile__content")));
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(By.className("goods-tile__content"));
    }

    public void addToCart(WebElement productElement) {
        WebElement addToCartButton = productElement.findElement(By.className("buy-button"));
        addToCartButton.click();
    }
}