package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page UI
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextBox;

	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextBox;

	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmpasswordTextBox;

	@FindBy(xpath = "//input[@id='Company']")
	private WebElement companyTextBox;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']//li")
	private WebElement existingEmailErrorMessage;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccessMessage;

	// Page Action

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageFirstNameTextBox() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);

	}

	public String getErrorMessageLastNameTextBox() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageEmailTextBox() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}

	public String getErrorMessagePasswordTextBox() {
		waitForElementClickable(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageConfirmPasswordTextBox() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}

	public void inputToFirstNameTextBox(String firstName) {
		waitForElementClickable(driver, firstNameTextBox);
		sendkeyToElement(driver, firstNameTextBox, firstName);
	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementClickable(driver, lastNameTextBox);
		sendkeyToElement(driver, lastNameTextBox, lastName);

	}

	public void inputToPasswordTextBox(String password) {
		waitForElementClickable(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);
	}

	public void inputToConfirmPasswordTextBox(String password) {
		waitForElementClickable(driver, confirmpasswordTextBox);
		sendkeyToElement(driver, confirmpasswordTextBox, password);
	}

	public void inputToCompanyTextBox(String company) {
		waitForElementClickable(driver, companyTextBox);
		sendkeyToElement(driver, companyTextBox, company);
	}

	public String getRegisterSuccessfulMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);

	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

	public String getExistingErrorMessageEmailTextBox() {
		waitForElementVisible(driver, existingEmailErrorMessage);
		return getElementText(driver, existingEmailErrorMessage);
	}

	public void inputToEmailTextBox(String emailAddress) {
		waitForElementClickable(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

}
