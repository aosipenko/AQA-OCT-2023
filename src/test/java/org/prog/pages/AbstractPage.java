package org.prog.pages;

import org.openqa.selenium.WebDriver;
import org.prog.util.WebDriverFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.MalformedURLException;

public abstract class AbstractPage {

    protected WebDriverFactory webDriverFactory;

    protected final WebDriver driver;
    private final String url;

    public AbstractPage(WebDriverFactory factory, String url) throws MalformedURLException {
        this.webDriverFactory = factory;
        this.driver = webDriverFactory.getDriver();
        this.url = url;
    }

    public void loadPage() {
        driver.get(url);
    }
}
