package org.mfk.PageObjectAndroid;

import org.mfk.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
	
	AndroidDriver driver;

	public FormPage(AndroidDriver driver)
	{
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@FindBy(id="android:id/text1")
	private WebElement countryDroplist;
	
	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	
	@FindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	public void setNameField(String name){
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void setCountrySelection(String countryName){
		countryDroplist.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
	}
	
	public void setGender(String gender) {
		if(gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}
	
	public ProductCatalogue submitForm() {
		shopButton.click();
		return new ProductCatalogue(driver);
	}
	
	public void setActivity() {
		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
				driver.startActivity(activity);
	}
	
}
