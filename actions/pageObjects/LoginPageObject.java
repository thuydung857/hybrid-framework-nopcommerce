package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);

	}

	public void inputToEmailTextBox(String wrongEmail) {
		waitForElementClickable(driver, LoginPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, wrongEmail);

	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);

	}

	public String getLoginUnsuccessfulMessage() {
		waitForElementVisible(driver, LoginPageUI.LOGIN_UNSUCCESSFUL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.LOGIN_UNSUCCESSFUL_ERROR_MESSAGE);

	}

}
