package com.qa.TestScripts;

import com.qa.AppiumConfig.BaseConfigurationServer;
import org.testng.annotations.Test;

import java.io.IOException;

public class SelectCity extends BaseConfigurationServer {
    @Test
    public void selectCityHotel() throws InterruptedException, IOException {
//        LoginApplication();
        Thread.sleep(5000);
       Thread.sleep(5000);
       object1.selectnearByCityImage().click();
       Thread.sleep(5000);
       object1.selectchangeCityButton().click();
       Thread.sleep(5000);
       object1.selectcitySearchBox().sendKeys("Hyderabad");
       Thread.sleep(5000);
       object1.getCitySearchResult().click();
       Thread.sleep(5000);
       object1.clickClosePopupButton().click();
       Thread.sleep(5000);
       takeScreenshot(driver,"Screenshots\\HyderabadHotels.png");
       Thread.sleep(5000);

    }

}
