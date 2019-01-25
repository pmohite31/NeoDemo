package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath= "Config//ConfigProperty.properties";


	public ConfigFileReader(){
		BufferedReader reader;
		try { 
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		} 
	}

	public String getPlatformName(){
		//String platformName = properties.getProperty("platform");
		String platformName = System.getProperty("platform");
		System.out.println(platformName);
		if(platformName!= null) return platformName;
		else throw new RuntimeException("platformName not specified."); 
	}


	public String getAppiumUrl() {
		String url = properties.getProperty("appiumURL");
		System.out.println(url);
		if (url!= null) {
			return url;
		}
		else {
			return "http://127.0.0.1:4723/wd/hub";
		}
	}

	public String getDeviceName(){
		// String devicename = properties.getProperty("deviceName");
		String devicename = System.getProperty("deviceName");
		System.out.println(devicename);
		if(devicename!= null) return devicename;
		else throw new RuntimeException("platformVersion not specified."); 
	}


	public String getPlatformVersion(){
		//String platformVrsn = properties.getProperty("platformVersion");
		String platformVrsn = System.getProperty("platformVersion");
		System.out.println(platformVrsn);
		if(platformVrsn!= null) return platformVrsn;
		else throw new RuntimeException("platformVersion not specified."); 
	}


	public String getDeviceId(){
		// String deviceID = properties.getProperty("UDID");
		String deviceID = System.getProperty("UDID");
		System.out.println(deviceID);
		if(deviceID!= null) return deviceID;
		else throw new RuntimeException("deviceID/UDID not specified."); 
	}

	public String getAutomationName(){
		// String automationType = properties.getProperty("automationName");
		String automationType = System.getProperty("automationName");
		System.out.println(automationType);
		if(automationType!= null) return automationType;
		else throw new RuntimeException("automationName not specified."); 
	}


	public String getAppPath(){
		//String app = properties.getProperty("appPath");
		String app = System.getProperty("appPath");
		System.out.println(app);
		if(app!= null) return app;
		else throw new RuntimeException("Either App path is incorrect or App is not available on given path :" + app); 
	}

	public String getReportConfigPath(){
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

	public String getFullReset() {
		if(System.getProperty("fullReset") == null) {
			return "false";
		}
		else return System.getProperty("fullReset");
	}
	
	public String getNoReset() {
		if(System.getProperty("noReset") == null) {
			return "false";
		}
		else return System.getProperty("noReset");
	}
	
	public long getImplicitlyWait() { 
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file."); 
	}

}
