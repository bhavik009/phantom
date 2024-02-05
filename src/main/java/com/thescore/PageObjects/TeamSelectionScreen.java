package com.thescore.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class TeamSelectionScreen extends BasePage {

    public WebElement getTeamSelectionTitle() {
        return getElement("teamSelectionScreen", "teamSelectionTitle");
    }

    public WebElement getContinueBtn() {
        return getElement("teamSelectionScreen", "continueBtn");
    }

    public void selectTeam(String teamName) {
        getElement("teamSelectionScreen", teamName).click();
    }

    public TeamSelectionScreen(AppiumDriver driver) {
        super(driver);
    }
}
