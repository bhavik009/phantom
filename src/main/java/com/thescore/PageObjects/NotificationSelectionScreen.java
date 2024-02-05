package com.thescore.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class NotificationSelectionScreen extends BasePage {

    public WebElement getNotificationSelectionTitle() {
        return getElement("notificationSelectionScreen", "notificationSelectionTitle");
    }

    public WebElement getDoneBtn() {
        return getElement("notificationSelectionScreen", "doneBtn");
    }

    public NotificationSelectionScreen(AppiumDriver driver) {
        super(driver);
    }
}
