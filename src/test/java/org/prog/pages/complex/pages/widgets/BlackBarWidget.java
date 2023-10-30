package org.prog.pages.complex.pages.widgets;

import org.openqa.selenium.WebDriver;

public class BlackBarWidget {
    private final WebDriver driver;

    public final SideBarWidget sideBarWidget;
    public final ShoppingCartWidget shoppingCartWidget;
    public final CatalogWidget catalogWidget;

    public BlackBarWidget(WebDriver driver) {
        this.driver = driver;
        sideBarWidget = new SideBarWidget();
        shoppingCartWidget = new ShoppingCartWidget();
        catalogWidget = new CatalogWidget();
    }

    public void sideMenu() {

    }

    public void setSearchValue() {

    }

    public void performSearch() {

    }

    public void openCatalog() {

    }

    public void openCart() {

    }
}
