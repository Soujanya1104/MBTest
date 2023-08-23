package com.mb.uk.web.pages;

import com.mb.uk.web.utils.DriverManager;
import com.mb.uk.web.utils.ExtentReport;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


/**
 * @implNote BasePage consists of driver functions
 */
public class BasePage {

    /**
     * @implNote Extracts shadow root from source element and finds target element
     * @param sourceElement of type By
     * @param targetElement of type by
     * @return
     */
    protected WebElement buildElementFromShadowDOM(By sourceElement, By targetElement) {
        return findElementWithinElement(getShadowRoot(sourceElement), targetElement);
    }

    /**
     * @implNote Extracts shadow root from source element and finds target element
     * @param sourceElement of type WebElement
     * @param targetElement of type By
     * @return
     */
    protected WebElement buildElementFromShadowDOM(WebElement sourceElement, By targetElement) {
        return findElementWithinElement(sourceElement.getShadowRoot(), targetElement);
    }

    /**
     * @implNote Finds child element
     * @param sourceElement of type By
     * @param targetElement of type By
     * @return
     */
    protected WebElement buildElementWithinElement(By sourceElement, By targetElement){
        return DriverManager.driver.findElement(sourceElement).findElement(targetElement);
    }

    /**
     * @implNote Finds child element
     * @param sourceElement of type WebElement
     * @param targetElement of type By
     * @return
     */
    protected WebElement buildElementWithinElement(WebElement sourceElement, By targetElement){
        return sourceElement.findElement(targetElement);
    }

    /**
     * @implNote Finds child element
     * @param parentElement of type SearchContext
     * @param childElement of type By
     * @return
     */
    protected WebElement findElementWithinElement(SearchContext parentElement, By childElement) {
        return parentElement.findElement(childElement);
    }

    /**
     * @implNote Performs Click action
     * @param element
     * @param elementName
     */
    protected void click(WebElement element, String elementName) {
        element.click();
        ExtentReport.getExtentTest().pass(elementName +" is clicked");
    }

    /**
     * @implNote Performs Click action using JS Executor
     * @param element
     * @param elementName
     */
    protected void clickByJS(WebElement element, String elementName){
        JavascriptExecutor js=(JavascriptExecutor) DriverManager.driver;
        js.executeScript("arguments[0].click();",element);
        ExtentReport.getExtentTest().pass(elementName +" is clicked");
    }

    /**
     * @implNote Performs GetText action
     * @param element
     * @param elementName
     * @return
     */
    protected String getText(WebElement element, String elementName){
        String value=element.getText();
        ExtentReport.getExtentTest().pass(elementName +" value is: "+value);
        return value;
    }

    /**
     * @implNote Extracts Shadow Root
     * @param element
     * @return
     */
    protected SearchContext getShadowRoot(By element) {
        return DriverManager.driver.findElement(element).getShadowRoot();
    }

    /**
     * @implNote Scroll to the element
     * @param element
     */
    protected void scrollToElement(WebElement element){
        new Actions(DriverManager.driver).scrollToElement(element).perform();
    }

    /**
     * @implNote Scroll page
     */
    protected void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.driver;
        js.executeScript("window.scrollBy(0,300)", "");
    }

    /**
     * @implNote Select (dropdown) element using visible text
     * @param element
     * @param text
     */
    protected void selectFromListByVisibleText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
        ExtentReport.getExtentTest().pass("Select the option" + text);
    }

    /**
     * @implNote Get Page Title
     * @return
     */
    protected String getTitle(){
        return DriverManager.driver.getTitle();
    }
}
