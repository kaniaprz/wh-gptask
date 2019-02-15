package com.williamhill.pageobjects.baseobjects;

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

    public BaseObjectClass(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,30);

        //Longer wait to use in particular situations:
        longWait = new WebDriverWait(driver,90);
    }

    protected void waitForElementVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected String getText(WebElement element){
        waitForElementVisibility(element);
        return element.getText();
    }

    protected void clickElement(WebElement element){
        try {
            waitForElementClickable(element);
            element.click();
        } catch (Exception e){
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", element);
        }
    }

    protected void typeTextInField(WebElement element, String text){
        waitForElementClickable(element);
        element.clear();
        element.sendKeys(text);
    }

}
