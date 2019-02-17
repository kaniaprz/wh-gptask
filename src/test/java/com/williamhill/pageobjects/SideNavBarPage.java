package com.williamhill.pageobjects;

import com.williamhill.pageobjects.baseobjects.BaseObjectClass;
import com.williamhill.pageobjects.football.CompetitionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SideNavBarPage extends BaseObjectClass {
    public WebDriver driver;
    /**
     * Locators and methods for Main Page
     */
    // Region locators
    @FindBy(how = How.XPATH,using = "//*[@id=\"nav-football\"]/a")
    private WebElement footballBtn;
    @FindBy(how = How.XPATH,using = "//*[@id=\"nav-football-competitions\"]/a")
    private WebElement competitionsBtn;
    // End region

    public SideNavBarPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * Navigate to Competitions site
     */
    public CompetitionsPage navigateToCompetitions(){
        clickElement(footballBtn);
        clickElement(competitionsBtn);
        return new CompetitionsPage(driver);
    }





}
