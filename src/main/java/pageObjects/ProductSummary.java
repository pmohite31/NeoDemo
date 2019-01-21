package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import utility.SeleniumUtility;

public class ProductSummary extends SeleniumUtility{
	
	public AppiumDriver<MobileElement> driver;
	public ProductSummary(AppiumDriver<MobileElement> driver) {
		 super(driver); 
	    
	 }
	
	@iOSFindBy(xpath =  "//XCUIElementTypeNavigationBar[@name=\"ProductSummary\"]")
	@AndroidFindBy(xpath = "/com.android.internal.policy.DecorView/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.FitWindowsLinearLayout/android.support.v7.widget.ContentFrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.support.v7.widget.Toolbar/android.support.v7.widget.AppCompatTextView")
	public MobileElement navigationBarName;
	
	public MobileElement getNavigationBarName(){
		return navigationBarName;
	}
	
	public boolean verifyScreenName() {
   		
	if (waitForElementToBePresent(5, navigationBarName)) {
		return true;
	}
	else {
		return false;
	}	
	}
	
	
	

}
