package stepFiles;

import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumberHelper.TestContext;
import pageObjects.ProductSummary;

public class ProductSummarySteps {
	
	 TestContext testContext;
	 ProductSummary productSummaryScreen;

	 public ProductSummarySteps(TestContext context) {
		 testContext = context;
		 productSummaryScreen = testContext.getPageObjectManger().getProductSummaryScreen();
		 }

	 @Then("^User should be on ProductSummary Screen$")
		public void homeScreenVerify() throws Throwable {
		 Assert.assertTrue(productSummaryScreen.verifyScreenName());
		}
		
	 
	 @Then("^User closes the app$")
		public void closeApp() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 testContext.getDriverFactory().closeDriver();
		}
		

}
