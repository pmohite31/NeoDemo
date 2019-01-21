package manager;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverFactory {

	private AppiumDriver<MobileElement> driver;
    private String os;

	public DriverFactory()
	{
		os = FileReaderManager.getInstance().getConfigReader().getPlatformName();
		
	}
	
	
	public AppiumDriver<MobileElement> getDriver() {
		 if(driver == null)
			try {
				driver = startDriver();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 return driver;
		 }
	
	
	private AppiumDriver<MobileElement> startDriver() throws MalformedURLException {
		 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (os) {
		
		case "Android" :
			
			capabilities.setCapability("platformName", FileReaderManager.getInstance().getConfigReader().getPlatformName());
	        capabilities.setCapability("deviceName",FileReaderManager.getInstance().getConfigReader().getDeviceName());
	        capabilities.setCapability("app",FileReaderManager.getInstance().getConfigReader().getAppPath());
	        capabilities.setCapability("platformVersion", FileReaderManager.getInstance().getConfigReader().getPlatformVersion());
	        capabilities.setCapability("automationName", FileReaderManager.getInstance().getConfigReader().getAutomationName());
	        //capabilities.setCapability("UDID", FileReaderManager.getInstance().getConfigReader().getDeviceId());
	        driver = new AndroidDriver<MobileElement>(new URL(FileReaderManager.getInstance().getConfigReader().getAppiumUrl()), capabilities);
	        FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
	        break;
	          
		case "IOS" :
			
			capabilities.setCapability("platformName", FileReaderManager.getInstance().getConfigReader().getPlatformName());
	        capabilities.setCapability("deviceName",FileReaderManager.getInstance().getConfigReader().getDeviceName());
	        capabilities.setCapability("app",FileReaderManager.getInstance().getConfigReader().getAppPath());
	        capabilities.setCapability("platformVersion", FileReaderManager.getInstance().getConfigReader().getPlatformVersion());
	        capabilities.setCapability("automationName", FileReaderManager.getInstance().getConfigReader().getAutomationName());
	        capabilities.setCapability("UDID", FileReaderManager.getInstance().getConfigReader().getDeviceId());
	        driver = new IOSDriver<MobileElement>(new URL(FileReaderManager.getInstance().getConfigReader().getAppiumUrl()), capabilities);
	        FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
	        break;
	           
		
		}
		
		return driver;
		
 } 
	
	
	public void closeDriver() {
		
		 driver.quit();
		 }
	
}
