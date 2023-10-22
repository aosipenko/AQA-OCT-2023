package org.prog.RozetkaPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private WebElement productElement;

    public SearchPage(WebElement productElement) {
        this.productElement = productElement;
    }

    public String getProductPrice() {
        WebElement priceIphone = productElement.findElement(By.className("goods-tile__price-value"));
        return priceIphone.getText();
    }

    public String getProductDescription() {
        WebElement descriptionIphone = productElement.findElement(By.className("goods-tile__title"));
        return descriptionIphone.getText();
    }
}
