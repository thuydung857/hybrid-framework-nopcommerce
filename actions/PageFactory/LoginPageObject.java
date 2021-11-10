package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page UI
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	private WebElement loginButton;

	@FindBy(xpath = "//span[@class='field-validation-error']")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement loginUnsuccessfulMessage;

	// Page Action

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);

	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);

	}

	public void inputToEmailTextBox(String wrongEmail) {
		waitForElementClickable(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, wrongEmail);

	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);

	}

	public String getLoginUnsuccessfulMessage() {
		waitForElementVisible(driver, loginUnsuccessfulMessage);
		return getElementText(driver, loginUnsuccessfulMessage);

	}

}
