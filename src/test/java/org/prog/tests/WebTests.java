package org.prog.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.pages.GooglePage;
import org.prog.pages.WikiPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class WebTests {

    private WebDriver driver;

    private GooglePage googlePage;
    private WikiPage wikiPage;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
        wikiPage = new WikiPage(driver);
    }

    @BeforeMethod
    public void loadPage() {
        googlePage.loadPage();
        googlePage.acceptCookiesIfPresent();
    }

    @Test(dataProvider = "celebrityNames")
    public void simpleGoogleSearchTest(String celebrityName) {
        googlePage.setSearchValue(celebrityName);
        googlePage.performSearch();
        boolean searchSuccesss = googlePage.getSearchResultHeaders()
                .stream()
                .anyMatch(header -> header.contains(celebrityName));

        Assert.assertTrue(searchSuccesss, "Celebrity not found!");
    }

    @Test(dataProvider = "celebrityNames")
    public void feelingLuckySerachTest(String celebrityName) {
        googlePage.setSearchValue(celebrityName);
        googlePage.feelingLuckySearch();

        Assert.assertTrue(wikiPage.isPageLoaded(), "Feeling lucky didnt go to wikipedia!");
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "celebrityNames")
    public static Object[][] celebrityNames() {
        return new Object[][]{
                {"Bill Gates"},
                {"Bill Murray"},
                {"Steve Jobs"},
                {"Elon Musk"}
        };
    }
}
