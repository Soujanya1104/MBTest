package com.mb.uk.web.pages;

import org.openqa.selenium.By;

public class OverviewPage extends BasePage {

    private By overviewPageShadowRoot = By.tagName("owc-stage");
    private By buildYourCarButton = By.cssSelector("div.owc-stage-cta-buttons>a");

    /**
     * @implNote Performs click action on button - Build your car
     */
    public void buildYourCar() {
        click(buildElementFromShadowDOM(overviewPageShadowRoot, buildYourCarButton), "Select Build Your Car button");
    }

    /**
     * @implNote Get Overview Page Title
     */
    public String getOverviewPageTitle(){
        return getTitle();
    }
}
