package com.qa.TestScripts;

// import com.qa.PageObjectModel.*;
import com.qa.AppiumConfig.*;

import io.appium.java_client.AppiumBy;
// import io.appium.java_client.android.AndroidDriver;
// import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginApp extends BaseConfigurationServer {
    @Test
    public void LoginApplication() throws InterruptedException {
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
        object1.clickProceedButton().click();
        Thread.sleep(15000);
        System.out.println("Entered to homescreen");
        Thread.sleep(10000);
        WebElement titleHomepageString = driver.findElement(AppiumBy.id("com.brevistay.customer:id/textView25"));
        String nameTitle = titleHomepageString.getText();
        System.out.println(nameTitle);
        Thread.sleep(5000);
        WebElement benefitCard = driver.findElement(AppiumBy.id("com.brevistay.customer:id/textView_Offer"));
        String benefitCardString = benefitCard.getText();
        System.out.println(benefitCardString);
        Thread.sleep(5000);
        // String scrollTitle =
        // driver.findElement(AppiumBy.id("com.brevistay.customer:id/benefit3_Txt")).getText();
        // // SwipeElementtoDirection(benefitCard, "up");
        // Thread.sleep(5000);
        // ScrollTOTextElement(scrollTitle);
        Thread.sleep(5000);
    }
}