package cucumberHelper;

import manager.DriverFactory;
import manager.PageObjectManger;

public class TestContext {

	private PageObjectManger pageObjectManger; 
	private DriverFactory driverFactory;

	public TestContext(){
		driverFactory = new DriverFactory();
		pageObjectManger = new PageObjectManger(driverFactory.getDriver());	  	  	  
	}		 	

	public DriverFactory getDriverFactory() {
		return driverFactory;
	}

	public PageObjectManger getPageObjectManger() {
		return pageObjectManger;
	}

}
