package com.mb.uk.web.pages;

import com.mb.uk.web.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VehiclesPage extends BasePage {

    private By configuratorShadowRoot = By.tagName("owcc-car-configurator");

    private By filterFuelTypeMultiSelectElement = By.cssSelector("ccwb-multi-select");

    private By filterFuelTypeOption = By.cssSelector("ccwb-checkbox");

    private By filterFuelTypeDieselValue = By.cssSelector("input[name='Diesel']");

    private By sortingVehiclesSelectElement = By.cssSelector("ccwb-select");
    private By sortingVehicles = By.cssSelector("select#motorization-filters-sorting-options");

    private By vehicleFirstRecord = By.cssSelector("ccwb-card:nth-child(1)");

    private By vehiclePriceValue = By.cssSelector("ccwb-text > span");


    /**
     * @implNote Extract Vehicle Page Shadow Root
     * @param element
     * @return
     */
    public WebElement getVehicleShadowElement(By element) {
        return buildElementFromShadowDOM(configuratorShadowRoot, element);
    }

    /**
     * @implNote Applies filter on fuel type - Diesel
     */
    public void filterByFuelTypeDiesel() {
        WebElement fuelTypeShadowElement = getVehicleShadowElement(filterFuelTypeMultiSelectElement);
        scrollPage();
        WebElement fuelValueDieselShadowElement = buildElementWithinElement(fuelTypeShadowElement, filterFuelTypeOption);
        clickByJS(buildElementFromShadowDOM(fuelValueDieselShadowElement, filterFuelTypeDieselValue), "Select fuel type filter as Diesel");
    }

    /**
     * @implNote Select sort option - Price Low to High
     */
    public void sortPriceLowestToHighest() {
        WebElement fuelTypeShadowElement = getVehicleShadowElement(sortingVehiclesSelectElement);
        selectFromListByVisibleText(buildElementWithinElement(fuelTypeShadowElement, sortingVehicles), "Price (lowest first)");
    }

    /**
     * @implNote Select sort option - Price High to Low
     */
    public void sortPriceHighestToLowest() {
        WebElement fuelTypeShadowElement = getVehicleShadowElement(sortingVehiclesSelectElement);
        selectFromListByVisibleText(buildElementWithinElement(fuelTypeShadowElement, sortingVehicles), "Price (highest first)");
    }

    /**
     * @implNote Get Vehicle Price value
     * @return
     */
    public String getVehiclePrice() {
        WebElement sortTypeElement = getVehicleShadowElement(vehicleFirstRecord);
        return getText(buildElementWithinElement(sortTypeElement, vehiclePriceValue), "Vehicle Price Value");
    }

    /**
     * @implNote Get Configurator Page Title
     */
    public String getConfiguratorPageTitle(){
        WebDriverWait wait=new WebDriverWait(DriverManager.driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("owcc-car-configurator")));
        return getTitle();
    }
}
