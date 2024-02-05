package com.thescore.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class LeagueScreen extends BasePage {

    public WebElement getLeagueTitle() {
        return getElement("leagueScreen", "leagueTitle");
    }

    public WebElement getStandingsTab() {
        return getElement("leagueScreen", "standingsTab");
    }

    public WebElement getRaptorsStanding() {
        return getElement("leagueScreen", "standingsTorRaptors");
    }

    public WebElement getBackBtn(){
        return getElement("leagueScreen", "backBtn");
    }

    public LeagueScreen(AppiumDriver driver) {
        super(driver);
    }
}
