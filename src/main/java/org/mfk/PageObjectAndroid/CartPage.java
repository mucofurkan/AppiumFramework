package org.mfk.PageObjectAndroid;

import java.util.List;

import org.mfk.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	AndroidDriver driver;
	
	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@FindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement terms;
	
	@FindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	//tagName[@attribute='value']
	@FindBy(className="android.widget.CheckBox")
	private WebElement receiveEmail;
	
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	public CartPage(AndroidDriver driver){
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public double getProductSum(){
		int count = productList.size();
		double totalSum=0;
		for (int i=0; i<count; i++){
			String amountString = productList.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
		}
		return totalSum;
	}
	
	public Double getTotalAmountDisplayed(){
		return getFormattedAmount(totalAmount.getText());
	}
	
	public void acceptTerms(){
		longPressAction(terms);
		acceptButton.click();
	}
	
	public void takeEmail() {
		receiveEmail.click();
	}
	
	public void payment(){
		proceed.click();
	}
}
