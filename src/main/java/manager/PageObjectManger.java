package manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageObjects.LoginScreen;
import pageObjects.ProductSummary;

public class PageObjectManger {

	public AppiumDriver<MobileElement> driver;
	public LoginScreen loginScreen;
	public ProductSummary productSummaryScreen;
	
	public  PageObjectManger(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	
	public LoginScreen getLoginScreen() {
		return (loginScreen == null) ? loginScreen = new LoginScreen(driver) : loginScreen;
	}
	
	public ProductSummary getProductSummaryScreen() {
		return (productSummaryScreen == null) ? productSummaryScreen = new ProductSummary(driver) : productSummaryScreen;
	}
}
