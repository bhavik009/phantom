package com.thescore.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class LandingScreen extends BasePage {

    public WebElement getStartedBtn() {
        return getElement("landingScreen", "getStartedBtn");
    }

    public LandingScreen(AppiumDriver driver) {
        super(driver);
    }
}