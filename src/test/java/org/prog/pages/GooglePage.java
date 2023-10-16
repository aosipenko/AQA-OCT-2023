package org.prog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class GooglePage {

    private final WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://google.com/");
    }

    public void setSearchValue(String value) {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.clear();
        searchInput.sendKeys(value);
    }

    public void performSearch() {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.click();
        new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.xpath("//ul[@role='listbox']/li"), 2));
        WebElement searchBtn = driver.findElements(By.xpath("//input[@name='btnK']")).get(0);
        searchBtn.click();
    }

    public void feelingLuckySearch() {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.click();
        new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.xpath("//ul[@role='listbox']/li"), 2));
        WebElement searchBtn = driver.findElements(By.xpath("//input[@name='btnI']")).get(0);
        searchBtn.click();
    }

    public List<String> getSearchResultHeaders() {
        List<WebElement> searchResults = new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//a/h3"), 5));

        return searchResults.stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
    }

    public void acceptCookiesIfPresent() {
        List<WebElement> buttons = driver.findElements(By.xpath("//button"));
        if (buttons.size() == 5) {
            //we see cookies!
            WebElement element = buttons.get(3);
            element.click();
        }
    }
}
