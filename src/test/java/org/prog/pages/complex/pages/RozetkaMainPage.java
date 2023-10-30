package org.prog.pages.complex.pages;

import org.openqa.selenium.WebDriver;
import org.prog.pages.complex.pages.widgets.AdsWidget;
import org.prog.pages.complex.pages.widgets.BlackBarWidget;

public class RozetkaMainPage {

    private final WebDriver driver;

    public final AdsWidget adsWidget;
    public final BlackBarWidget blackBarWidget;

    public RozetkaMainPage(WebDriver driver) {
        this.driver = driver;
        this.adsWidget = new AdsWidget(driver);
        this.blackBarWidget = new BlackBarWidget(driver);
    }

    public AdsWidget adsWidget() {
        return adsWidget;
    }
}
