package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import utility.SeleniumUtility;

public class LaunchScreen extends SeleniumUtility{

	public AppiumDriver<MobileElement> driver;
	
	 
	public LaunchScreen(AppiumDriver<MobileElement> driver) {
		 super(driver);    
	 }
	
	@iOSFindBy(id =  "")
	@AndroidFindBy(id = "abc_btn_title")
	public MobileElement signUpButton;
	
	 public void tapSignUptButton() {
			tapOnElement(signUpButton);
		}
	
	 public void signUpButtonPresent() {
		 
		 waitForElementToBePresent(30, signUpButton);
		
	 }

}
