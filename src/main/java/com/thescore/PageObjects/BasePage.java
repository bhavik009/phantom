package com.thescore.PageObjects;

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.io.FileReader;
import java.time.Duration;

public class BasePage {
    protected static AppiumDriver driver;
    private static JsonObject locators;

    public BasePage(AppiumDriver driver) {
        BasePage.driver = driver;
        loadLocators();
    }

    public static WebElement getElement(String screenName, String elementName) {
        return driver.findElement(getSelector(screenName, elementName));
    }

    public static By getSelector(String screenName, String elementName) {
        System.out.println("Screen Name: " + screenName);
        System.out.println("Element Name: " + elementName);

        String locatorValue = getLocatorValue(screenName, elementName, "accessibilityID");
        if (locatorValue != null)
            return (By) new AppiumBy.ByAccessibilityId(locatorValue);
        else if ((locatorValue = getLocatorValue(screenName, elementName, "id")) != null)
            return By.id(locatorValue);
        else
            return By.xpath(getLocatorValue(screenName, elementName, "xpath"));
    }

    private static String getLocatorValue(String screenName, String elementName, String locatorType) {
        String locatorValue = null;
        try {
            locatorValue = locators
                    .getAsJsonObject("android")
                    .getAsJsonObject(screenName)
                    .getAsJsonObject(locatorType)
                    .get(elementName)
                    .getAsString();
            System.out.println("locatorValue: " + locatorValue);
        } catch (NullPointerException ignored) {
            System.out.println(elementName + " element not found by locator type - " + locatorType);
        }
        return locatorValue;
    }

    private static void loadLocators() {

        try (JsonReader jsonReader = new JsonReader(new FileReader("src/main/java/com/thescore/Locators/locators.json"))) {
            locators = new Gson().fromJson(jsonReader, JsonObject.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Locators JSON: " + locators);
    }

    protected static void swipe(Point start, Point end) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(input, 0);
        sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(input.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), end.x, end.y));
        sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(sequence));
    }

    public static void navigateBack(){
        driver.navigate().back();
    }
}
