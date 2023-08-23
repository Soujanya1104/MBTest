package com.mb.uk.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private By cookieBanner = By.tagName("cmm-cookie-banner");
    private By agreeAllButton = By.cssSelector("wb7-button[data-test='handle-accept-all-button']");
    private By headerMenu = By.tagName("owc-header");
    private By menuOptionBuildCars = By.cssSelector("li:nth-child(1) > button");
    private By flyOutMenu = By.tagName("vmos-flyout");
    private By menuOptionHatchBacks = By.cssSelector("li[role='menuitem']:nth-child(4)");
    private By menuOptionAClassHatchBacks = By.cssSelector("owc-header-flyout > ul > li > ul > li:nth-child(1)");

    /**
     * @implNote Accepts cookies
     */
    public void acceptCookies() {
        click(buildElementFromShadowDOM(cookieBanner, agreeAllButton), "Agree cookies");
    }

    /**
     * @implNote Selects menu option - Our Models
     */
    public void selectMenuOptionOurModels() {
        click(buildElementFromShadowDOM(headerMenu, menuOptionBuildCars), "Select the menu option - Our Models");
    }

    /**
     * @implNote Selects the model type - Hatch Backs
     */
    public void selectModelTypeHatchBacks() {
        WebElement hatchBacks = buildElementFromShadowDOM(flyOutMenu, menuOptionHatchBacks);
        scrollToElement(hatchBacks);
        click(hatchBacks, "Select the model type - Hatch Backs");
    }

    /**
     * @implNote Selects the HatchBack Type - A Class
     */
    public void selectHatchBacksTypeAClass() {
        click(buildElementFromShadowDOM(flyOutMenu, menuOptionAClassHatchBacks), "Select the hatchbacks type - A Class");
    }

}
