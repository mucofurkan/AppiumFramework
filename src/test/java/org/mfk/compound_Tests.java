package org.mfk;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.mfk.utils.AndroidBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class compound_Tests extends AndroidBaseTest {

        @Test
        public void FillForm_PositiverFlow() throws InterruptedException {
            //tagName[@attribute='value']
            driver.findElement(By.id("android:id/text1")).click();
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
            driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
            driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("mfk");
            driver.hideKeyboard();
            driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
            driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElements(By.xpath("/hierarchy/android.widget.Toast[1]")).size() < 1);
        }

        @Test
        public void FillForm_ErrorValidation() throws InterruptedException {
            //tagName[@attribute='value']
            driver.findElement(By.id("android:id/text1")).click();
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
            driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
            driver.hideKeyboard();
            driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
            driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
            String toast = driver.findElement(By.xpath("/hierarchy/android.widget.Toast[1]")).getText();
            Assert.assertEquals(toast, "Please ener your name");
            Thread.sleep(2000);
        }

        @BeforeMethod
        public void preSetup() {
            Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
            driver.startActivity(activity);
        }

    }
