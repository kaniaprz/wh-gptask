package com.williamhill.pageobjects.football;

import com.williamhill.pageobjects.baseobjects.BaseObjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EnglishPremierLeaguePage extends BaseObjectClass {
    public WebDriver driver;

    // Region locators
    @FindBy(how = How.XPATH,using = "(//*[@data-test-id=\"events-group\"]//main[@class=\"sp-o-market__title\"]/a/span)[1]")
    private WebElement firstEventGroup;
    // End region

    public EnglishPremierLeaguePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

        String URL = driver.getCurrentUrl();
        try{
            if(!URL.contains("English-Premier-League")) throw new IllegalStateException("This is not the english premier league page.");
        } catch (Exception e){}
    }

    public FootballMatchEventPage selectFirstFootbalEvent(){
        clickElement(firstEventGroup);
        return new FootballMatchEventPage(driver);
    }

}
