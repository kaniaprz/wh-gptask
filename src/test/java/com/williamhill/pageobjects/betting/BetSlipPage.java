package com.williamhill.pageobjects.betting;

import com.williamhill.pageobjects.baseobjects.BaseObjectClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BetSlipPage extends BaseObjectClass {
    public WebDriver driver;

    // Region locators
    @FindBy(how = How.XPATH,using = "(//*[@class=\"betslip-selection__content betslip-selection__content--single\"]//input[@type=\"text\"])[1]")
    private WebElement firstEventStakeField;
    @FindBy(how = How.XPATH,using = "//input[@value=\"Place Bet\"]")
    private WebElement placeBetBtn;
    @FindBy(how = How.ID,using = "total-to-return-price")
    private WebElement toReturnCost;
    @FindBy(how = How.ID,using = "total-stake-price")
    private WebElement totalStakeCost;
    // End locators

    public BetSlipPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**
     * Add stake to BetlSlip for first bet on the list
     */

    public BetSlipPage addStakeForBet(String stake){
        typeTextInField(firstEventStakeField,stake);
        return new BetSlipPage(driver);
    }

    /**
     * Place Bet
     */

    public BetSlipPage placeBet(){
        clickElement(placeBetBtn);
        return new BetSlipPage(driver);
    }

    /**
     * Verify To Return and Total Stake values.
     */

    public void verifyOddsAndReturns(String stake, String odd){
        double stakeCalculated = Double.parseDouble(stake);
        double oddCalculated = parseFractionalToDecimal(odd);
        double toReturnCalculated = stakeCalculated * (1+oddCalculated);
        double toReturnRounded = roundToDown(toReturnCalculated);

        double returnDisplayed = Double.parseDouble(getText(toReturnCost));
        double totalStakeDisplayed = Double.parseDouble(getText(totalStakeCost));

        Assert.assertEquals(returnDisplayed,toReturnRounded);
        Assert.assertEquals(totalStakeDisplayed,stakeCalculated);

    }

    /**
     * Parse fractional taken from button
     */

    private double parseFractionalToDecimal(String ratio) {
        if (ratio.contains("/")) {
            String[] rat = ratio.split("/");
            return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
        } else {
            return Double.parseDouble(ratio);
        }
    }

    /**
     * Rounding to down
     */

    private double roundToDown(double value){
        BigDecimal result = BigDecimal.valueOf(value);
        result = result.setScale(2, RoundingMode.DOWN);
        double roundedDouble = result.doubleValue();
        return roundedDouble;
    }


}
