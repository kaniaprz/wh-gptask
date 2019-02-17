package com.williamhill.pageobjects.baseobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseObjectClass {
    private WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait longWait;
    protected Wait fluentWait;

    /**
     * Wrappers for basic user actions.
     */

    public BaseObjectClass(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,30);

        //Longer wait to use in particular situations:
        longWait = new WebDriverWait(driver,90);
    }

    /**
     * Wait configuration
     */

    protected void waitForElementVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Get text from Webelement and convert it in to String.
     */

    protected String getText(WebElement element){
        waitForElementVisibility(element);
        return element.getText();
    }

    /**
     * Click on webelement using basic click or using javascript executor.
     * From my experience, on each website there is problem with that, so added it.
     */
    protected void clickElement(WebElement element){
        try {
            waitForElementClickable(element);
            element.click();
        } catch (Exception e){
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", element);
        }
    }

    /**
     * Type text to specific fields using Webelement
     */

    protected void typeTextInField(WebElement element, String text){
        waitForElementClickable(element);
        element.clear();
        element.sendKeys(text);
    }

}
