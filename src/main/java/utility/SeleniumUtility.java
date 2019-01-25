package utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumUtility {

	protected AppiumDriver<MobileElement> driver;

	public SeleniumUtility(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public void tapOnElement(MobileElement ele) {
		if (waitForElementToBeClickable(5, ele)) {
			ele.click();
		} else {
			Assert.fail(ele + "is not clickable");

		}

	}

	public void enterTextInTextField(MobileElement ele, String text) {
		tapOnElement(ele);
		ele.sendKeys(text);
	}

	public void clearAndEnterTextInTextField(MobileElement ele, String text) {
		tapOnElement(ele);
		ele.clear();
		ele.sendKeys(text);

	}

	public boolean waitForElementToBeClickable(int seconds, MobileElement ele) {
		try {
			new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(ele));
			return true;
		} catch (TimeoutException e) {
			e.printStackTrace();

			return false;
		}

	}

	public boolean waitForElementToBePresent(int seconds, MobileElement ele) {
		try {
			new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(ele));
			return true;
		} catch (TimeoutException e) {
			e.printStackTrace();

			return false;
		}
	}

	public void hideKeyBoard() {
		driver.hideKeyboard();
	}
}
