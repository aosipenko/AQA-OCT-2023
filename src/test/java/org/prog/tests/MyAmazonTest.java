package org.prog.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.pages.AmazonHomePage;
import org.prog.pages.AmazonProductPage;
import org.prog.pages.AmazonSearchResultsPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class MyAmazonTest {
    private ChromeDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void goToAmazonHomePage() {
        driver.get( "https://www.amazon.com/" );
    }

    @Test
    public void testAmazonProductPrice() {
        AmazonHomePage amazonHomePage = new AmazonHomePage( driver );
        amazonHomePage.searchForProduct( "Apple iPhone 13, 128GB, Midnight - Unlocked (Renewed)" );

        AmazonSearchResultsPage searchResultsPage = new AmazonSearchResultsPage( driver );
        searchResultsPage.clickOnFirstResult();

        AmazonProductPage productPage = new AmazonProductPage( driver );
        String price = productPage.getPrice();
        System.out.println( "Цена: " + price );
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        }
    }