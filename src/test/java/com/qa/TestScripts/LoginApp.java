package com.qa.TestScripts;

import com.qa.AppiumConfig.BaseConfigurationServer;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginApp extends BaseConfigurationServer {
    @Test
    public void LoginApplication() throws InterruptedException, IOException {
        System.out.println("Performing Login action");
        object1.ClickgetStartedArrow();
        object1.ClickgetStartedArrow();
        object1.ClickgetStartedArrowNext1();
        Thread.sleep(5000);
        String titleString = driver.findElement(AppiumBy.id("com.brevistay.customer:id/textView36")).getText();
        System.out.println(titleString);
        object1.EnterMobileNumber().click();
        object1.EnterMobileNumber().sendKeys("9676218302");
        object1.ClickUsePasswordInsteadButton().click();
        Thread.sleep(5000);
        object1.EnterPassword().click();
        object1.EnterPassword().sendKeys("Shashi@8131#");
        Thread.sleep(7000);
        driver.hideKeyboard();
        object1.clickProceedButton().click();
        takeScreenshot(driver, "Screenshots\\LoginPage.png");
        Thread.sleep(15000);
        System.out.println("Entered to homescreen");
        Thread.sleep(10000);
        takeScreenshot(driver, "Screenshots\\HomeScreen.png");
        WebElement titleHomepageString = driver.findElement(AppiumBy.id("com.brevistay.customer:id/textView25"));
        String nameTitle = titleHomepageString.getText();
        System.out.println(nameTitle);
        Thread.sleep(5000);
        WebElement benefitCard = driver.findElement(AppiumBy.id("com.brevistay.customer:id/textView_Offer"));
        String benefitCardString = benefitCard.getText();
        System.out.println(benefitCardString);
        driver.findElement(By.name("shashidhar")).click();
        Thread.sleep(5000);
        Thread.sleep(5000);
    }
}
