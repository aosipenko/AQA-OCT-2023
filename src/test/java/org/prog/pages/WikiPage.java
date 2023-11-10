package org.prog.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.util.WebDriverFactory;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.time.Duration;

@Component
public class WikiPage extends AbstractPage {

    private final static String URL = "https://wikipedia.org/";

    public WikiPage(WebDriverFactory factory) throws MalformedURLException {
        super(factory, URL);
    }

    public boolean isPageLoaded() {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.urlContains("wikipedia.org"));
    }
}
