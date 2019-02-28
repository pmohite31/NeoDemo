package stepFiles;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;
import pageObjects.EmailAddressScreen;
import pageObjects.LaunchScreen;

public class emailScreenSteps {
	
	TestContext testContext;
	EmailAddressScreen emailAddressScreen;
	
	
	public emailScreenSteps(TestContext context) {
		testContext = context;
		emailAddressScreen = testContext.getPageObjectManger().getEmailAddressScreen();
	}
	
	
	@Given("^User should be on EmailAddress screen$")
	public void userIsOnEmailAddressScreen() throws Throwable {
		Assert.assertTrue(emailAddressScreen.IsEmailAddressScreen());
	}
	
	@When("^User enters valid email address \"(.*)\"$")
	public void userEntersEmail(String email) throws Throwable {
		emailAddressScreen.enterEmailAddress(email);
	}
	
	@Then("^User email should get saved$")
	public void userEmailShouldGetSavedl() throws Throwable {
		
	}
	
	@When("^User taps Next Button$")
	public void userTapsNextButtonl() throws Throwable {
		emailAddressScreen.tapNextButton();
		
	}
	
	@When("^User enters invalid email address \"(.*)\"$")
	public void userEntersInvalidEmail(String email) throws Throwable {
		emailAddressScreen.enterEmailAddress(email);
	}
	
	@Then("^User should get error message \"(.*)\"$")
	public void userGetsInvalidEmailError(String errorMessage) throws Throwable {
		emailAddressScreen.IsInValidEmailErrorMessagePresent(errorMessage);
		
	}
}
