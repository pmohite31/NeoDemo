package manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageObjects.EmailAddressScreen;
import pageObjects.LaunchScreen;
import pageObjects.LoginScreen;


public class PageObjectManger {

	public AppiumDriver<MobileElement> driver;
	public LaunchScreen launchScreen;
	public EmailAddressScreen emailAddressScreen;
	
	
	
	public PageObjectManger(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	
	public LaunchScreen getLaunchScreen() {
		return (launchScreen == null) ? launchScreen = new LaunchScreen(driver) : launchScreen;
	}
	
	public EmailAddressScreen getEmailAddressScreen() {
		return (emailAddressScreen == null) ? emailAddressScreen = new EmailAddressScreen(driver) : emailAddressScreen;
	}
	
	

	
}
