package org.prog.pages.complex.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdsWidget {

    private final WebDriver driver;

    public AdsWidget(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollAdsLeft() {
        WebElement scrollAdLeftBtn =
                driver.findElement(By.className("simple-slider__control simple-slider__control--prev"));
        scrollAdLeftBtn.click();
    }

    public void scrollAdsRight() {
        WebElement scrollAdRightBtn =
                driver.findElement(By.className("simple-slider__control simple-slider__control--next"));
        scrollAdRightBtn.click();
    }

    public String getAdLink() {
        return "some_link";
    }
}
