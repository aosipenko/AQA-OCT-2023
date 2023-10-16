package org.prog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikiPage {

    private final WebDriver driver;

    public WikiPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPageLoaded() {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.urlContains("wikipedia.org"));
    }
}
