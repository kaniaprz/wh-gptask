package com.williamhill.pageobjects;

import com.williamhill.pageobjects.baseobjects.BaseObjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseObjectClass {
    public WebDriver driver;
    /**
     * Locators and methods for Main Page
     */

    // Region locators
    // End region

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

        String URL = driver.getCurrentUrl();
        try{
            if(!URL.contains("/betting/en-gb")) throw new IllegalStateException("This is not the betting main page.");
        } catch (Exception e){}
    }


}
