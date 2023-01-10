package org.mfk.PageObjectIOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.mfk.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends IOSActions {
    IOSDriver driver;


    public HomePage(IOSDriver driver)
    {
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver, this); //

    }

    //driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
    @iOSXCUITFindBy(accessibility="Alert Views")
    private WebElement alertViews;

    public AlertViews selectAlertViews()
    {
        alertViews.click();
        return new AlertViews(driver);
    }
}
