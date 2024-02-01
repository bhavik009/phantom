package com.thescore.PageObjects;

import com.thescore.Locators.AndroidLocators;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

// page_url = about:blank
public class LandingScreen extends BasePage{
    public LandingScreen(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @AndroidFindBy(id = AndroidLocators.getStartedBtn)
    WebElement getStartedBtn;
}