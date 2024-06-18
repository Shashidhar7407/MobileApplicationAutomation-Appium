package com.qa.PageObjectModel;

import com.qa.AppiumConfig.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BervistayPOM extends BaseConfigurationServer {
    AndroidDriver driver;

    public BervistayPOM(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.brevistay.customer:id/onBoard_arrow")

    WebElement getStartedArrow;

    public void ClickgetStartedArrow() {
        getStartedArrow.click();
    }

    @AndroidFindBy(id = "com.brevistay.customer:id/onBoard_arrowNext")
    WebElement getStartedArrowNext;

    public void ClickgetStartedArrowNext1() {
        getStartedArrowNext.click();
    }

    @AndroidFindBy(id = "com.brevistay.customer:id/numEditText")
    WebElement getMobileNumber;

    public WebElement EnterMobileNumber() {
        return getMobileNumber;
    }

    @AndroidFindBy(id = "com.brevistay.customer:id/option2Btn")
    WebElement UsePasswordInsteadButton;

    public WebElement ClickUsePasswordInsteadButton() {
        return UsePasswordInsteadButton;
    }

    @AndroidFindBy(id = "com.brevistay.customer:id/passEditText")
    WebElement getPassword;

    public WebElement EnterPassword() {
        return getPassword;
    }

    @AndroidFindBy(id = "com.brevistay.customer:id/progressBtnYellow_txt")
    WebElement getProceed;

    public WebElement clickProceedButton() {
        return getProceed;
    }

    public static void Sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }

}
