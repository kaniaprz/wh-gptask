package com.williamhill.pageobjects.football;

import com.williamhill.pageobjects.baseobjects.BaseObjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class FootballMatchEventPage extends BaseObjectClass {
    public WebDriver driver;

    // Region locators
    @FindBy(how = How.XPATH,using = "(//*[@id=\"markets-container\"]//span[@class=\"betbutton__odds\"])[1]")
    private WebElement homeTeamWinBtn;
    // End region

    public FootballMatchEventPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * Navigate to Competitions site
     */

    public FootballMatchEventPage addHomeTeamWinToBet(){
        clickElement(homeTeamWinBtn);
        return new FootballMatchEventPage(driver);
    }

    /**
     * Get odd for home team win in 90 minutes.
     */

    public String homeTeamWinOdd(){
        return getText(homeTeamWinBtn);
    }



}
