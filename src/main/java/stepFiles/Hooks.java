package stepFiles;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumberHelper.TestContext;

public class Hooks {

	TestContext testContext;
	
	public Hooks(TestContext context) {
		 testContext = context;
		 }
	
	@Before
    public void beforeScenario(){
		System.out.println("-----------------Start of Scenario-----------------");
		
    } 
 
    @After(order = 0)
    public void afterScenario(){
     System.out.println("-----------------End of Scenario-----------------");
	 testContext.getDriverFactory().closeDriver();
    }
    
    
    @After(order = 1)
    public void afterScenario(Scenario scenario) {
    if (scenario.isFailed()) {
    String screenshotName = scenario.getName().replaceAll(" ", "_");
    try {
   
    File sourcePath = ((TakesScreenshot) testContext.getDriverFactory().getDriver()).getScreenshotAs(OutputType.FILE);
    
    File destinationPath = new File(System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png");
    
    Files.copy(sourcePath, destinationPath);   
    
    Reporter.addScreenCaptureFromPath(destinationPath.toString());
 
    } catch (IOException e) {
    } 
    }
    
    }
}
	