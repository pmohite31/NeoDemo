package stepFiles;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberHelper.TestContext;
import pageObjects.LoginScreen;

public class LoginSteps {

	TestContext testContext;
	LoginScreen loginscreen;

	public LoginSteps(TestContext context) {
		testContext = context;
		loginscreen = testContext.getPageObjectManger().getLoginScreen();
	}

	@Given("^User is on login screen$")
	public void i_launch_iOS_app() throws Throwable {
		Assert.assertTrue(loginscreen.userNameField.isDisplayed());
	}

	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void i_enter_correct_credentials(String username, String passwordd) throws Throwable {
		loginscreen.login(username, passwordd);
	}

}
