package org.prog.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IFrameDemo {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
            new WebDriverWait(driver, Duration.ofSeconds(30L))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-choices")))
                    .click();
            WebElement resultIframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
            driver.switchTo().frame(resultIframe);

            WebElement iframeInner = driver.findElement(By.tagName("iframe"));
            driver.switchTo().frame(iframeInner);

            driver.switchTo().parentFrame(); // -> resultIframe

            WebElement logoWithLink = driver.findElement(By.id("w3-logo"));
            System.out.println(logoWithLink.isDisplayed());

            driver.switchTo().defaultContent(); // -> default context

            WebElement shadowRoot = driver.findElement(By.name("shadowDom"));
            SearchContext shadowContext = shadowRoot.getShadowRoot();

        } finally {
            driver.quit();
        }
    }
}
