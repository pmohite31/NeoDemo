package stepFiles;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
	 
	 @Given("^I launch app$")
		public void i_launch_iOS_app() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
	 Assert.assertTrue(loginscreen.getUserNameField().isDisplayed());
 
		}
	

	@When("^I enter correct credentials$")
	public void i_enter_correct_credentials() throws Throwable {

		loginscreen.login("sara","password");
	
	}

	
	
}
