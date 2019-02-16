package com.williamhill.pageobjects.football;

import com.williamhill.pageobjects.baseobjects.BaseObjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CompetitionsPage extends BaseObjectClass {
    public WebDriver driver;

    // Region locators
    @FindBy(how = How.LINK_TEXT,using = "English Premier League")
    private WebElement engPremierLeagueBtn;
    // End region

    public CompetitionsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

        String URL = driver.getCurrentUrl();
        try{
            if(!URL.contains("competitions")) throw new IllegalStateException("This is not the competition page.");
        } catch (Exception e){}
    }

    public EnglishPremierLeaguePage navigateToEnglishPremierLeague(){
        clickElement(engPremierLeagueBtn);
        return new EnglishPremierLeaguePage(driver);
    }




}
