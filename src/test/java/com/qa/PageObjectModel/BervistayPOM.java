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

    @AndroidFindBy(id = "com.brevistay.customer:id/nearByCity_img")
     WebElement nearByCityImage;

    public WebElement selectnearByCityImage(){
        return nearByCityImage;
    }

    @AndroidFindBy(id = "com.brevistay.customer:id/searchRes_changeCity")
    WebElement changeCityButton;
      public WebElement selectchangeCityButton(){
        return changeCityButton;
    }

    @AndroidFindBy(id = "com.brevistay.customer:id/city_editText")
    WebElement citySearchBox;
        public WebElement selectcitySearchBox(){
        return citySearchBox;
    }

    @AndroidFindBy(id = "com.brevistay.customer:id/Search_listItem_city")
    WebElement citySearchResult;
          public WebElement getCitySearchResult(){
        return citySearchResult;
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView")
    WebElement closePopupButton;
            public WebElement clickClosePopupButton(){
        return closePopupButton;
    }

    public static void Sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }

}
