package com.williamhill.pageobjects.football;

import com.williamhill.pageobjects.baseobjects.BaseObjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EnglishPremierLeaguePage extends BaseObjectClass {
    public WebDriver driver;

    public EnglishPremierLeaguePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

        String URL = driver.getCurrentUrl();
        try{
            if(!URL.contains("English-Premier-League")) throw new IllegalStateException("This is not the english premier league page.");
        } catch (Exception e){}
    }

}
