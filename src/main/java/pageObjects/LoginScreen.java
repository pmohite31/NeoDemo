package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import utility.SeleniumUtility;

public class LoginScreen extends SeleniumUtility{
	
	public AppiumDriver<MobileElement> driver;
	
	 
	public LoginScreen(AppiumDriver<MobileElement> driver) {
		 super(driver);    
	 }
	
	@iOSFindBy(xpath =  "//XCUIElementTypeTextField")
	@AndroidFindBy(id = "editUsername")
	public MobileElement userNameField;
	
	@iOSFindBy(xpath =  "//XCUIElementTypeSecureTextField")
	@AndroidFindBy(id = "editPassword")
	public MobileElement passwordField;
	
	@iOSFindBy(xpath =  "//XCUIElementTypeButton[@name=\"Login\"]")
	@AndroidFindBy(id = "buttonLogin")
	public MobileElement loginButton;
	
	
	public void login (String username, String password) throws InterruptedException {
		enterTextInTextField(userNameField, username);
		enterTextInTextField(passwordField, password);
		hideKeyBoard();
		if (System.getProperty("platform").equalsIgnoreCase("android")) {
			tapOnElement(loginButton);
		}
	}
	
}
