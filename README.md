# Phantom: Test Harness for Mobile Applications

## Tool Stack

This test harness uses following tools, framework and technologies

- Java
- Selenium
- Appium
- TestNG
- Maven

## Prerequisites

- Java 11
- Appium 2.0 or later
- Maven

## Get Started

1. Install all maven dependencies
    ```
    mvn install
    ```
2. Make sure appium is running
    ```
    appium
    ```
3. Adjust the environment variables in `.env` file located at root
4. Run the test
    ```
    mvn test
    ```

### Folder Structure

- All tests are located under the `src/test`
- However, locators, page objects and TestBase located under the `src/main`

### Locators

- All the locators should be written in the [locators.json](./src/main/java/com/thescore/Locators/locators.json) file
- Locators need to be written with `key:value` pair format where key will be a element name and value will be the
  locator string (xpath, accessibility id, id, etc.)
- Locators should also follow the tree format for respective screens.
- For example: Locator for the top header in the top news screen will be written in following format.

```json
{
  "android": {
    "landingScreen": {
      "id": {
        "getStartedBtn": "com.fivemobile.thescore:id/btn_primary"
      }
    }
  }
}
```

- To use the locators in the page objects, pass the screen name and element name in `getElement()` method:

```java
public WebElement getStartedBtn(){
        return getElement("landingScreen","getStartedBtn");
        }
```

### Page Objects

- Page Object Model is used to enhance the re-usability of some commonly used functions/code blocks.
- [BasePage.java](./src/main/java/com/thescore/PageObjects/BasePage.java) is being used to store some common helper
  functions as well as to be inherited in the other page object files.

### Test Base

- [TestBase.java](./src/main/java/com/thescore/TestBase.java) is used to initiate `setup()` and `teardown()` methods as
  well as to use some of the very common functions like wait.
- TestBase is to be inherited in all test classes.

## Test Specification

- Find the documentation around test specification, test approach and other future consideration here.
- [Phantom Test Harness](https://qaclub.notion.site/the-Score-Phantom-Test-Harness-7f51565374384098a24f7447b04d06ee)