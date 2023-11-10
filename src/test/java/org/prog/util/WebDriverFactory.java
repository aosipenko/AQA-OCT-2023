package org.prog.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

@Component
public class WebDriverFactory {

    public final static String LOCAL = "local";
    public final static String REMOTE = "remote";
    public final static String JENKINS = "jenkins";

    private WebDriver driver;

    public WebDriver getDriver() throws MalformedURLException {
        if (driver != null) {
            return driver;
        }
        String type = System.getProperty("driver.type");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVideo", true);
            put("enableVNC", true);
        }});

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(options);

        options.setAcceptInsecureCerts(true);
        switch (type) {
            case LOCAL:
                driver = new ChromeDriver();
                break;
            case REMOTE:
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
                break;
            case JENKINS:
                driver = new RemoteWebDriver(new URL("http://selenoid-selenoid-1:4444/wd/hub"), desiredCapabilities);
            default:
                throw new RuntimeException("Unknown driver type");
        }
        return driver;
    }

    @PreDestroy
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
