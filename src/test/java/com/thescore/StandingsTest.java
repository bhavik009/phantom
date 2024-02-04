package com.thescore;

import com.thescore.PageObjects.LandingScreen;
import org.testng.annotations.Test;

import java.io.IOException;

public class StandingsTest extends TestBase {

    @Test
    public void sampleTest() throws InterruptedException, IOException {

        LandingScreen landingScreen = new LandingScreen(driver);

//        driver.findElement(By.id("com.fivemobile.thescore:id/btn_primary")).click();
        landingScreen.getStartedBtn.click();

        Thread.sleep(3000);
    }

}
