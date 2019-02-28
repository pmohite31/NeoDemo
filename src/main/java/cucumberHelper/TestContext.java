package cucumberHelper;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import manager.DriverFactory;
import manager.PageObjectManger;
import utility.ExcelUtility;

public class TestContext {

	private PageObjectManger pageObjectManger; 
	private DriverFactory driverFactory;

	public TestContext() throws InvalidFormatException, IOException{
		ExcelUtility util = new ExcelUtility();
		util.readExcelFile("/Resources/DataProvider.xlsx");
		util.writeToPropertiesFile();
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
