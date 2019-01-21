package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import manager.PageObjectManger;
import stepFiles.commonMobileSteps;
import utility.SeleniumUtility;

public class LoginScreen extends SeleniumUtility{
	
	public AppiumDriver<MobileElement> driver;
	
	
	 
	public LoginScreen(AppiumDriver<MobileElement> driver) {
		 super(driver); 
	     //PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	     
	 }
	
	//XCUIElementTypeButton[@name="Login"]

	@iOSFindBy(xpath =  "//XCUIElementTypeTextField")
	@AndroidFindBy(id = "editUsername")
	public MobileElement userNameField;
	
	public MobileElement getUserNameField(){
		return userNameField;
	}
	
	
	@iOSFindBy(xpath =  "//XCUIElementTypeSecureTextField")
	@AndroidFindBy(id = "editPassword")
	public MobileElement passwordField;
	
	public MobileElement getPasswordField(){
		return passwordField;
	}
	
	
	@iOSFindBy(xpath =  "//XCUIElementTypeButton[@name=\"Login\"]")
	@AndroidFindBy(id = "buttonLogin")
	public MobileElement loginButton;
	
	public MobileElement getLoginButton(){
		return loginButton;
	}

	
	public void login (String username, String password) throws InterruptedException {
		enterTextInTextField(getUserNameField(), username);
		enterTextInTextField(getPasswordField(), password);
		hideKeyBoard();
		if (System.getProperty("platform").equalsIgnoreCase("android")) {
			tapOnElement(getLoginButton());
		}
	}
	
}
