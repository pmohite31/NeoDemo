package stepFiles;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumberHelper.TestContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import pageObjects.LaunchScreen;

public class commonMobileSteps {
	
	TestContext testContext;
	LaunchScreen launchScreen;
	
	
	public commonMobileSteps(TestContext context) {
		testContext = context;
		launchScreen = testContext.getPageObjectManger().getLaunchScreen();
	}
	
	
	@Given("^User is on launch screen$")
	public void userIsOnLaunchScreen() throws Throwable {
		launchScreen.signUpButtonPresent();
	}
	
	
	@Given("^User taps Sign Up button$")
	public void userTapSignUpButton() throws Throwable {
		launchScreen.tapSignUptButton();
	}
}
