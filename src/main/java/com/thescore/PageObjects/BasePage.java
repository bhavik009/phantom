package com.thescore.PageObjects;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.io.IOException;

public class BasePage {
    protected static AppiumDriver driver;
    private static JsonObject locators;

    public BasePage(AppiumDriver driver) throws IOException {
        BasePage.driver = driver;
        loadLocators();
    }

    public static WebElement getElement(String screenName, String elementName) {
        return driver.findElement(getSelector(screenName, elementName));
    }

    public static By getSelector(String screenName, String elementName) {
        System.out.println("Screen Name: " + screenName);
        System.out.println("Element Name: " + elementName);

        String locatorValue = locators
                .getAsJsonObject("android")
                .getAsJsonObject(screenName)
                .getAsJsonObject("accessibilityID")
                .get(elementName)
                .getAsString();

        System.out.println("Value of 'getStartedBtn': " + locatorValue);


        return By.id(locatorValue); // Assuming the locator type is "id"
    }

    private static void loadLocators() throws IOException {
        JsonParser jsonParser = new JsonParser();
        locators = jsonParser.parse(new FileReader("src/main/java/com/thescore/Locators/locators.json")).getAsJsonObject();
        System.out.println("Locators JSON: " + locators);
    }

/*
    public By getSelector(String screenName, String elementName)
    {
        By locator =

        locator = locators.get(PLATFORM, {}).get('accessibilityID', {}).get(element_name)
    if locator:
        return set_webdriver.find_element(AppiumBy.ACCESSIBILITY_ID,
                                          locators[PLATFORM]['accessibilityID'][element_name])
    elif locators.get(PLATFORM, {}).get('id', {}).get(element_name):
        return set_webdriver.find_element(AppiumBy.ID, locators[PLATFORM]['id'][element_name])
    else:
        locator = locators.get(PLATFORM, {}).get('xpath', {}).get(element_name)
        return set_webdriver.find_element(AppiumBy.XPATH, locators[PLATFORM]['xpath'][element_name])


}*/

}
