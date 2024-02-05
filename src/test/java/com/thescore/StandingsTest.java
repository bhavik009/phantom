package com.thescore;

import com.thescore.PageObjects.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StandingsTest extends TestBase {

    @Test(priority = 0)
    public void landingTest() {
        LandingScreen landingScreen = new LandingScreen(driver);
        LeagueSelectionScreen leagueSelectionScreen = new LeagueSelectionScreen(driver);
        landingScreen.getStartedBtn().click();
        implicitWait();
        Assert.assertEquals(leagueSelectionScreen.getLeagueSelectionTitle().getText(), "Choose your favorite leagues");
    }

    @Test(priority = 1, dependsOnMethods = "landingTest")
    public void leagueSelectionTest() {
        LeagueSelectionScreen leagueSelectionScreen = new LeagueSelectionScreen(driver);
        leagueSelectionScreen.selectLeague("nbaBasketBall");
        leagueSelectionScreen.getContinueBtn().click();
        implicitWait();
        TeamSelectionScreen teamSelectionScreen = new TeamSelectionScreen(driver);
        Assert.assertEquals(teamSelectionScreen.getTeamSelectionTitle().getText(), "Choose your favorite teams");
    }

    @Test(priority = 2, dependsOnMethods = "leagueSelectionTest")
    public void teamSelectionTest() {
        TeamSelectionScreen teamSelectionScreen = new TeamSelectionScreen(driver);
        teamSelectionScreen.selectTeam("torontoRaptors");
        teamSelectionScreen.getContinueBtn().click();
        implicitWait();
        NotificationSelectionScreen notificationSelectionScreen = new NotificationSelectionScreen(driver);
        Assert.assertEquals(notificationSelectionScreen.getNotificationSelectionTitle().getText(), "Never miss a game");
    }

    @Test(priority = 3, dependsOnMethods = "teamSelectionTest")
    public void notificationSelectionTest() {
        NotificationSelectionScreen notificationSelectionScreen = new NotificationSelectionScreen(driver);
        notificationSelectionScreen.getDoneBtn().click();
        implicitWait();
        HomeScreen homeScreen = new HomeScreen(driver);
        Assert.assertEquals(homeScreen.getPromotionBannerTitle().getText(), "");
    }

    @Test(priority = 4, dependsOnMethods = "notificationSelectionTest")
    public void verifyLeague() {
        HomeScreen homeScreen = new HomeScreen(driver);
        homeScreen.getDismissBtn().click();
        implicitWait();
        homeScreen.getFavLeague().click();
        LeagueScreen leagueScreen = new LeagueScreen(driver);
        Assert.assertEquals(leagueScreen.getLeagueTitle().getText(), "NBA");
    }

    @Test(priority = 5)
    public void verifyStandings() {
        LeagueScreen leagueScreen = new LeagueScreen(driver);
        leagueScreen.getStandingsTab().click();
        Assert.assertEquals(leagueScreen.getRaptorsStanding().getText(), "TOR Raptors");
    }

    @Test(priority = 6)
    public void navigateBack() {
        LeagueScreen leagueScreen = new LeagueScreen(driver);
        leagueScreen.getBackBtn().click();
        HomeScreen homeScreen = new HomeScreen(driver);
        Assert.assertTrue(homeScreen.getSearchBar().isDisplayed(), "Search Bar is not visible on the Home Screen");
    }

}
