package runner;

import java.io.File;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import manager.FileReaderManager;


@RunWith(Cucumber.class)
@CucumberOptions(
 features = "Feature"
 ,glue={"stepFiles"}
 ,plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
 )

public class TestRunner {
	
	@AfterClass
	 public static void writeExtentReport() {
	 Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	
    
	 }	
	
}
