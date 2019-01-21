package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(
 features = "Feature"
 ,glue={"stepFiles"}
 ,plugin = {"pretty", "html:/Users/prashantmohite/Prashant/Report"}
 )

public class TestRunner {
	
	

}
