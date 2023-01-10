package org.mfk.PageObjectAndroid;

import java.util.List;

import org.mfk.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions{
	AndroidDriver driver;
	
	public ProductCatalogue(AndroidDriver driver){
		super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@FindBy(id="com.androidsample.generalstore:id/productName")
	private List<WebElement> productNames;
	
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	public void addItemToCartByIndex(int index) {
		addToCart.get(index).click();
	}
	
	public void scroolToItem(String itemname) {
		scrollToText("Jordan 6 Rings");
		int productCount = productNames.size();
		for (int i = 0; i<productCount;i++)	
		{
			String productName = productNames.get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings"))
			{
				addToCart.get(i).click();
			}
		}
	}
	
	public CartPage goToCart() throws InterruptedException {
		cart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}
}
