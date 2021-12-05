package pageObjects.swagLabs;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.swagLabs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTextboxByID(String value, String...params) {
		waitForElementClickable(driver, LoginPageUI.TEXTBOX_BY_ID, params);
		sendkeyToElement(driver, LoginPageUI.TEXTBOX_BY_ID, value, params);
	}

	public void clickToButtonByValue(String buttonValue) {
		waitForElementClickable(driver, LoginPageUI.BUTTON_BY_VALUE, buttonValue);
		clickToElement(driver, LoginPageUI.BUTTON_BY_VALUE, buttonValue);		
	}



}
