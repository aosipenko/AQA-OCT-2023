package org.prog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.util.WebDriverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GooglePage extends AbstractPage {

    private final static String URL = "https://google.com/";

    public GooglePage(WebDriverFactory factory) throws MalformedURLException {
        super(factory, URL);
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
