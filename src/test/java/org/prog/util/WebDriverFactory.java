package org.prog.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class WebDriverFactory {

    private final static String LOCAL = "local";
    private final static String REMOTE = "remote";
    private final static String JENKINS = "jenkins";

    public static WebDriver getDriver() throws MalformedURLException {
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
                return new ChromeDriver();
            case REMOTE:
                return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
            case JENKINS:
                return new RemoteWebDriver(new URL("http://selenoid-selenoid-1:4444/wd/hub"), desiredCapabilities);
            default:
                throw new RuntimeException("Unknown driver type");
        }
    }
}
