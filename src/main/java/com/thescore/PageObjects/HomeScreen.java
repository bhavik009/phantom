package com.thescore.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BasePage {

    public WebElement getPromotionBannerTitle() {
        return getElement("homeScreen", "promotionBannerTitle");
    }

    public WebElement getDismissBtn() {
        return getElement("homeScreen", "dismissBtn");
    }

    public WebElement getFavLeague(){
        return getElement("homeScreen", "favLeague");
    }
    public WebElement getSearchBar(){
        return getElement("homeScreen", "searchBar");
    }
    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }
}
