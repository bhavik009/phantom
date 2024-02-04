package com.thescore.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LandingScreen extends BasePage {

    public WebElement getStartedBtn = getElement("landingScreen", "getStartedBtn");

    public LandingScreen(AppiumDriver driver) throws IOException {
        super(driver);
    }
}