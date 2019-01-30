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

	public DriverFactory() {
		os = FileReaderManager.getInstance().getConfigReader().getPlatformName();
	}

	public AppiumDriver<MobileElement> getDriver() {
		if (driver == null)
			try {
				driver = startDriver();
			} catch (MalformedURLException e) {
					e.printStackTrace();
			}
		return driver;
	}

	private AppiumDriver<MobileElement> startDriver() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (os) {

		case "Android":

			capabilities.setCapability("platformName",
					FileReaderManager.getInstance().getConfigReader().getPlatformName());
			capabilities.setCapability("deviceName", FileReaderManager.getInstance().getConfigReader().getDeviceName());
			capabilities.setCapability("app", FileReaderManager.getInstance().getConfigReader().getAppPath());
			capabilities.setCapability("platformVersion",
					FileReaderManager.getInstance().getConfigReader().getPlatformVersion());
			capabilities.setCapability("automationName",
					FileReaderManager.getInstance().getConfigReader().getAutomationName());
			capabilities.setCapability("fullReset", FileReaderManager.getInstance().getConfigReader().getFullReset());
			capabilities.setCapability("noReset", FileReaderManager.getInstance().getConfigReader().getNoReset());
			driver = new AndroidDriver<MobileElement>(
					new URL(FileReaderManager.getInstance().getConfigReader().getAppiumUrl()), capabilities);
			FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
			
			
			System.out.println ("platformName : "+
					FileReaderManager.getInstance().getConfigReader().getPlatformName());
			System.out.println("deviceName : " + FileReaderManager.getInstance().getConfigReader().getDeviceName());
			System.out.println("appPath : " + FileReaderManager.getInstance().getConfigReader().getAppPath());
			System.out.println("platformVersion : " +
					FileReaderManager.getInstance().getConfigReader().getPlatformVersion());
			System.out.println("automationName : " +
					FileReaderManager.getInstance().getConfigReader().getAutomationName());
			System.out.println("fullReset : " + FileReaderManager.getInstance().getConfigReader().getFullReset());
			System.out.println("noReset : " + FileReaderManager.getInstance().getConfigReader().getNoReset());
			
			break;
			
			

		case "IOS":

			capabilities.setCapability("platformName",
					FileReaderManager.getInstance().getConfigReader().getPlatformName());
			capabilities.setCapability("deviceName", FileReaderManager.getInstance().getConfigReader().getDeviceName());
			capabilities.setCapability("app", FileReaderManager.getInstance().getConfigReader().getAppPath());
			capabilities.setCapability("platformVersion",
					FileReaderManager.getInstance().getConfigReader().getPlatformVersion());
			capabilities.setCapability("automationName",
					FileReaderManager.getInstance().getConfigReader().getAutomationName());
			capabilities.setCapability("UDID", FileReaderManager.getInstance().getConfigReader().getDeviceId());
			capabilities.setCapability("fullReset", FileReaderManager.getInstance().getConfigReader().getFullReset());
			capabilities.setCapability("noReset", FileReaderManager.getInstance().getConfigReader().getNoReset());
			driver = new IOSDriver<MobileElement>(
					new URL(FileReaderManager.getInstance().getConfigReader().getAppiumUrl()), capabilities);
			FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
			
			System.out.println ("platformName : "+
					FileReaderManager.getInstance().getConfigReader().getPlatformName());
			System.out.println("deviceName : " + FileReaderManager.getInstance().getConfigReader().getDeviceName());
			System.out.println("appPath : " + FileReaderManager.getInstance().getConfigReader().getAppPath());
			System.out.println("platformVersion : " +
					FileReaderManager.getInstance().getConfigReader().getPlatformVersion());
			System.out.println("automationName : " +
					FileReaderManager.getInstance().getConfigReader().getAutomationName());
			System.out.println("UDID: " +
					FileReaderManager.getInstance().getConfigReader().getDeviceId());
			System.out.println("fullReset : " + FileReaderManager.getInstance().getConfigReader().getFullReset());
			System.out.println("noReset : " + FileReaderManager.getInstance().getConfigReader().getNoReset());
			
			break;

		}

		return driver;

	}

	public void closeDriver() {
		driver.quit();
	}

}
