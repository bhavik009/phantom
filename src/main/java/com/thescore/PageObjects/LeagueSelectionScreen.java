package com.thescore.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class LeagueSelectionScreen extends BasePage {

    public WebElement nbaBasketBall() {
        return getElement("leagueSelectionScreen", "nbaBasketBall");
    }
    public WebElement getLeagueSelectionTitle() {
        return getElement("leagueSelectionScreen", "leagueSelectionTitle");
    }

    public void selectLeague(String leagueName)
    {
        getElement("leagueSelectionScreen", leagueName).click();
    }

    public LeagueSelectionScreen(AppiumDriver driver) {
        super(driver);
    }
}
