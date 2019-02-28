package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import bsh.commands.dir;



public class ConfigFileReader {

	private Properties properties;
	final private  String propertyFilePath= getDriverPropertyFilePath();
	final private String commonConfigFilePath = System.getProperty("user.dir") + "/Config/Common.properties";

	public String getDriverPropertyFilePath() {
		if (System.getProperty("platform").equalsIgnoreCase("android")){
			return "Config//Android/Android";
		}
		else if (System.getProperty("platform").equalsIgnoreCase("ios") ){
			return "Config//iOS/ios" ;
		}
		else {
			System.out.println("Platform is not specified");
			return null;
			
		}
	}
	

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
		//System.out.println("Platform Name:" + platformName);
		if(platformName!= null) return platformName;
		else throw new RuntimeException("platformName not specified."); 
	}


	public String getAppiumUrl() {
		String url = properties.getProperty("appiumURL");
		//System.out.println("Appium server URL:" +url);
		if (url!= null) {
			return "http://0.0.0.0:4723/wd/hub";
			//return url;
		}
		else {
		
			return "http://0.0.0.0:4723/wd/hub";
			
		}
	}

	public String getDeviceName(){
		if (System.getProperty("deviceName") != null)
		{return (System.getProperty("deviceName"));}
		else if (properties.getProperty("deviceName") != null){
		return (properties.getProperty("deviceName"));}
		else throw new RuntimeException("DeviceName not specified."); 
	}


	public String getPlatformVersion(){
		if (System.getProperty("platformVersion") != null)
		{return (System.getProperty("platformVersion"));}
		else if (properties.getProperty("platformVersion") != null){
		return (properties.getProperty("platformVersion"));}
		else throw new RuntimeException("platformVersion not specified."); 
	}


	public String getDeviceId(){
		if (System.getProperty("UDID") != null)
		{return (System.getProperty("UDID"));}
		else if (properties.getProperty("UDID") != null){
		return (properties.getProperty("UDID"));}
		else throw new RuntimeException("UDID not specified."); 
	}

	public String getAutomationName(){
		if (System.getProperty("automationName") != null)
		{return (System.getProperty("automationName"));}
		else if (properties.getProperty("automationName") != null){
		return (properties.getProperty("automationName"));}
		else throw new RuntimeException("automationName not specified."); 
	}


	public String getAppPath(){
		if (System.getProperty("appPath") != null)
		{return (System.getProperty("appPath"));}
		else if (properties.getProperty("appPath") != null){
		return (properties.getProperty("appPath"));}
		else throw new RuntimeException("Either App path is incorrect or App is not available on given path"); 
		
	}

	public String getReportConfigPath(){
		String reportConfigPath = getValueFromPropertyFile(commonConfigFilePath, "reportConfigPath");
		System.out.println ("Extent Report Path :" + reportConfigPath);
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}

	public String getFullReset() {
		if (System.getProperty("fullReset") != null)
		{return (System.getProperty("fullReset"));}
		else if (properties.getProperty("fullReset") != null){
		return (properties.getProperty("fullReset"));}
		else return "FALSE";
	}
	
	public String getNoReset() {
		if (System.getProperty("noReset") != null)
		{return (System.getProperty("noReset"));}
		else if (properties.getProperty("noReset") != null){
		return (properties.getProperty("noReset"));}
		else return "TRUE";
	}
	
	public String getImplicitlyWait() { 
		String implicitlyWait = getValueFromPropertyFile(commonConfigFilePath, "implicitlyWait");
		System.out.println ("implicit Wait :" + implicitlyWait);
		if(implicitlyWait!= null) return implicitlyWait;
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file."); 
	}

	
	public String getValueFromPropertyFile(String filePath, String key) {
		BufferedReader reader;
		try { 
			reader = new BufferedReader(new FileReader(filePath));
			properties = new Properties();
			try {
				properties.load(reader);
				String value =  properties.getProperty(key);
				reader.close();
				return value;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("File not found at " + propertyFilePath);
		} 
	}
}
