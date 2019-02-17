package com.williamhill.tests;

import com.williamhill.pageobjects.MainPage;
import com.williamhill.pageobjects.SideNavBarPage;
import com.williamhill.pageobjects.betting.BetSlipPage;
import com.williamhill.pageobjects.football.CompetitionsPage;
import com.williamhill.pageobjects.football.EnglishPremierLeaguePage;
import com.williamhill.pageobjects.football.FootballMatchEventPage;
import com.williamhill.testbase.EndToEndBase;
import org.testng.annotations.Test;

public class BettingTest extends EndToEndBase {

    @Test(enabled = true,priority = 0)
    public void userAbleToBetOnHomeTeamInPremiership(){
        // Region TestData
        String stake = "0.05";
        String homeTeamWinOdd = "";
        // End region

        MainPage mainPageOpen = openMainPage();
        SideNavBarPage sideBarNav = new SideNavBarPage(driver);
        CompetitionsPage competitions = sideBarNav.navigateToCompetitions();
        EnglishPremierLeaguePage englishPremierLeague = competitions.navigateToEnglishPremierLeague();
        FootballMatchEventPage footballMatchEvent = englishPremierLeague.selectFirstFootballEvent();
        homeTeamWinOdd = footballMatchEvent.homeTeamWinOdd();
        footballMatchEvent
            .addHomeTeamWinToBet();
        BetSlipPage betSlip = new BetSlipPage(driver);
        betSlip
                .addStakeForBet(stake)
                //.placeBet()
                .verifyOddsAndReturns(stake,homeTeamWinOdd);



    }

}
