package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.cucumber.steps.WebSteps;
import org.prog.pages.GooglePage;
import org.prog.pages.WikiPage;
import org.prog.util.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

@CucumberOptions(features = "src/test/resources/features",
        glue = "org.prog.cucumber",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
        })
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

    private WebDriver driver;
//
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        driver = WebDriverFactory.getDriver();
        WebSteps.googlePage = new GooglePage(driver);
        WebSteps.wikiPage = new WikiPage(driver);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
