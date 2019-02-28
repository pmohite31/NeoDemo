package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import utility.SeleniumUtility;

public class EmailAddressScreen extends SeleniumUtility{
	
	public AppiumDriver<MobileElement> driver;
	
	 
	public EmailAddressScreen(AppiumDriver<MobileElement> driver) {
		 super(driver);    
	 }
	
	@iOSFindBy(id =  "")
	@AndroidFindBy(id = "email_textbox")
	public MobileElement emailTextField;
	
	@iOSFindBy(xpath =  "")
	@AndroidFindBy(id = "buttonText")
	public MobileElement nextButton;
	
	@iOSFindBy(xpath =  "")
	@AndroidFindBy(id = "textTitle")
	public MobileElement emailScreenTitle;
	
	@iOSFindBy(xpath =  "")
	@AndroidFindBy(id = "errorMsg")
	public MobileElement invalidEmailError;
	
	
	public void enterEmailAddress(String email) {
		enterTextInTextField(emailTextField, email);
		hideKeyBoard();
	}
	
	 public void tapNextButton() {
		tapOnElement(nextButton);
	}
	

     public void submitEmailAddress(String emailAddress) {
    	 enterEmailAddress(emailAddress);
    	 tapNextButton();
	}
     
     public String getEmailScreenTitle() {
    	 	 return emailScreenTitle.getText();
     }
     
     public boolean IsEmailAddressScreen() {
    	 
    	 String emailScreenTitle = getEmailScreenTitle();
    	 String emailExpectedtitle = "Email address";
		 
		 if(emailScreenTitle.equals(emailExpectedtitle))
			 
		 {
			 return true;
		 }
		 else return false;
	 }

     
 public boolean IsInValidEmailErrorMessagePresent(String expectedMessage) {
    	 
    	 String emailScreenTitle =  invalidEmailError.getText();
		 
		 if(emailScreenTitle.equals(expectedMessage))
			 
		 {
			 return true;
		 }
		 else return false;
	 }
}
