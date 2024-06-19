package com.qa.TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class SelectCity extends LoginApp {
    @Test
    public void selectCityHotel() throws InterruptedException, IOException {
        LoginApplication();
        Thread.sleep(5000);
        driver.findElement(
                AppiumBy.xpath("//android.widget.ImageView[@resource-id='com.brevistay.customer:id/nearByCity_img']"))
                .click();
        Thread.sleep(10000);
        driver.findElement(AppiumBy.id("com.brevistay.customer:id/searchRes_changeCity")).click();
        Thread.sleep(5000);
        WebElement searchBox = driver.findElement(AppiumBy.id("com.brevistay.customer:id/city_editText"));
        searchBox.click();
        searchBox.sendKeys("Hyderabad");
        Thread.sleep(5000);
        driver.findElement(AppiumBy.id("com.brevistay.customer:id/Search_listItem_city")).click();
        Thread.sleep(5000);
        // driver.findElement(AppiumBy.className("com.brevistay.customer:android.widget.ImageView")).click();
        driver.findElement(By.xpath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView"))
                .click();
        Thread.sleep(5000);
        takeScreenshot(driver, "src\\test\\java\\com\\Screenshots\\HyderabadHotels.png");
        Thread.sleep(5000);

    }

}
