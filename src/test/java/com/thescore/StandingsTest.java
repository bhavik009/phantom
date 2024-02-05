package com.thescore;

import com.thescore.PageObjects.LandingScreen;
import com.thescore.PageObjects.LeagueSelectionScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StandingsTest extends TestBase {

    @Test
    public void landingTest() {
        LandingScreen landingScreen = new LandingScreen(driver);
        LeagueSelectionScreen leagueSelectionScreen = new LeagueSelectionScreen(driver);
        landingScreen.getStartedBtn().click();
        implicitWait();
        Assert.assertEquals(leagueSelectionScreen.getLeagueSelectionTitle().getText(), "Choose your favorite leagues");
    }

    @Test
    public void leagueSelectionTest() {
        LeagueSelectionScreen leagueSelectionScreen = new LeagueSelectionScreen(driver);
        leagueSelectionScreen.selectLeague("nbaBasketBall");
    }

}
