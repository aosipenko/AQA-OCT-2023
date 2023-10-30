package org.prog.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.pages.complex.pages.RozetkaMainPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RozetkaWidgetsTest {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testRozetka() {
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);

        rozetkaMainPage.adsWidget.scrollAdsLeft();
        rozetkaMainPage.adsWidget.scrollAdsRight();

        rozetkaMainPage.blackBarWidget.openCart();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
