package org.prog.RozetkaPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class iPhone15ProPriceDescriptionTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            RozetkaHomePage homePage = new RozetkaHomePage(driver);
            homePage.open();
            homePage.searchForProduct("iPhone 15 Pro");
            homePage.waitForSearchResults();

            List<WebElement> searchResults = homePage.getSearchResults();

            System.out.println("Цена и описание первого iPhone 15 Pro");
            System.out.println("====================");
            WebElement firstProductElement = searchResults.get(0);
            SearchPage firstProductPage = new SearchPage(firstProductElement);
            String price = firstProductPage.getProductPrice();
            String description = firstProductPage.getProductDescription();
            System.out.println("Цена: " + price);
            System.out.println("Описание: " + description);
            System.out.println("====================");


        } finally {
            System.out.println("SUCCESS!");
            driver.quit();
        }
    }
}