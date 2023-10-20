package org.prog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikiPage extends AbstractPage {

    private final static String URL = "https://wikipedia.org/";

    public WikiPage(WebDriver driver) {
        super(driver, URL);
    }

    public boolean isPageLoaded() {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.urlContains("wikipedia.org"));
    }
}
