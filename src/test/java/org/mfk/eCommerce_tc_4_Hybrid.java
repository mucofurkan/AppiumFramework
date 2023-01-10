package org.mfk;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.mfk.PageObjectAndroid.CartPage;
import org.mfk.PageObjectAndroid.ProductCatalogue;
import org.mfk.utils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class eCommerce_tc_4_Hybrid extends AndroidBaseTest {
	
	@Test(dataProvider = "getData", groups = {"Smoke"})
	public void Hybrid(HashMap<String, String> input) throws InterruptedException{
		//tagName[@attribute='value']
		formPage.setNameField(input.get("name"));
		formPage.setCountrySelection(input.get("country"));
		formPage.setGender(input.get("gender"));
		ProductCatalogue productCatalogue = formPage.submitForm();
		
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.scroolToItem("Jordan 6 Rings");
		CartPage cartPage = productCatalogue.goToCart();
		
		double totalSum = cartPage.getProductSum();
		double displayedAmount = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayedAmount);
		cartPage.takeEmail();
		cartPage.acceptTerms();
		cartPage.payment();
		
	
		
		
		
		//WEBVIEW_com.androidsample.generalstore -- NATIVE_APP
//		driver.context("WEBVIEW_com.androidsample.generalstore");
//		Thread.sleep(2000);
//		driver.findElement(By.name("q")).sendKeys("mfk");
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//		driver.context("NATIVE_APP");
		
	}

	@BeforeMethod(alwaysRun = true)
	public void preSetup() {
		formPage.setActivity();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\eCommerce.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};

	}

}
