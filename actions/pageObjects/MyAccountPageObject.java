package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.MyAccountPageUI;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountLink() {
		waitForElementClickable(driver, MyAccountPageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, MyAccountPageUI.MY_ACCOUNT_LINK);
	}

	public String getCustomerInfoHeader() {
		waitForElementVisible(driver, MyAccountPageUI.CUSTOMER_INFO_HEADER);
		return getElementText(driver, MyAccountPageUI.CUSTOMER_INFO_HEADER);

	}

	public void inputToCustomerFirstNameTextBox(String firstName) {
		waitForElementClickable(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, firstName);

	}

	public void inputToCustomerLastNameTextBox(String lastName) {
		waitForElementClickable(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, lastName);

	}

	public void inputToCustomerEmailTextBox(String emailaddress) {
		waitForElementClickable(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, emailaddress);

	}

	public void inputToCustomerCompanyTextBox(String company) {
		waitForElementClickable(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.COMPANY_TEXTBOX, company);

	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.CUSTOMER_SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.CUSTOMER_SAVE_BUTTON);
	}

	public String getFirstNameAttribute() {
		waitForElementVisible(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.FIRST_NAME_TEXTBOX, "value");

	}

	public String getLastNameAttribute() {
		waitForElementVisible(driver, MyAccountPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.LAST_NAME_TEXTBOX, "value");

	}

	public String getEmailAttribute() {
		waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.EMAIL_TEXTBOX, "value");

	}

	public String getCompanyAttribute() {
		waitForElementVisible(driver, MyAccountPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, MyAccountPageUI.COMPANY_TEXTBOX, "value");

	}

	public void clickToAddressLink() {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_LINK);
		clickToElement(driver, MyAccountPageUI.ADDRESS_LINK);
	}

	public void clickToAddressAddNewButton() {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_ADD_NEW_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESS_ADD_NEW_BUTTON);
	}

	public void inputToAddressFirstNameTextBox(String addressFirstName) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_FIRST_NAME_TEXTBOX, addressFirstName);

	}

	public void inputToAddressLastNameTextBox(String addressLastName) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_LAST_NAME_TEXTBOX, addressLastName);

	}

	public void inputToAddressEmailTextBox(String addressEmail) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX, addressEmail);

	}

	public void inputToAddressCompanyTextBox(String addressCompany) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_COMPANY_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_COMPANY_TEXTBOX, addressCompany);

	}

	public void selectAddressCountryDropdown(String addressCountry) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, MyAccountPageUI.ADDRESS_COUNTRY_DROPDOWN, addressCountry);

	}

	public void selectAddressProvinceDropdown(String addressProvince) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_PROVINCE_DROPDOWN);
		selectItemInDefaultDropdown(driver, MyAccountPageUI.ADDRESS_PROVINCE_DROPDOWN, addressProvince);

	}

	public void inputToAddressCityTextBox(String addressCity) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_CITY_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_CITY_TEXTBOX, addressCity);

	}

	public void inputToAddressAddress1TextBox(String addressAddress1) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_ADDRESS1_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_ADDRESS1_TEXTBOX, addressAddress1);

	}

	public void inputToAddressAddress2TextBox(String addressAddress2) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_ADDRESS2_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_ADDRESS2_TEXTBOX, addressAddress2);

	}

	public void inputToAddressZipTextBox(String addressZip) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_ZIP_CODE_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_ZIP_CODE_TEXTBOX, addressZip);

	}

	public void inputToAddressPhoneNumberTextBox(String addressPhoneNumber) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX, addressPhoneNumber);

	}

	public void inputToAddressFaxTextBox(String addressFax) {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_FAX_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.ADDRESS_FAX_TEXTBOX, addressFax);

	}

	public void clickToAddresSaveButton() {
		waitForElementClickable(driver, MyAccountPageUI.ADDRESS_SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUI.ADDRESS_SAVE_BUTTON);

	}

	public String getAddressFullNameText() {
		waitForElementVisible(driver, MyAccountPageUI.VERIFY_ADDRESS_FULL_NAME);
		return getElementText(driver, MyAccountPageUI.VERIFY_ADDRESS_FULL_NAME);

	}

	public String getAddressEmailText() {
		waitForElementVisible(driver, MyAccountPageUI.VERIFY_ADDRESS_EMAIL);
		return getElementText(driver, MyAccountPageUI.VERIFY_ADDRESS_EMAIL);

	}

	public String getAddressPhoneNumberText() {
		waitForElementVisible(driver, MyAccountPageUI.VERIFY_ADDRESS_PHONE_NUMBER);
		return getElementText(driver, MyAccountPageUI.VERIFY_ADDRESS_PHONE_NUMBER);

	}

	public String getAddressFaxText() {
		waitForElementVisible(driver, MyAccountPageUI.VERIFY_ADDRESS_FAX);
		return getElementText(driver, MyAccountPageUI.VERIFY_ADDRESS_FAX);

	}

	public String getAddressCompanyText() {
		waitForElementVisible(driver, MyAccountPageUI.VERIFY_ADDRESS_COMPANY);
		return getElementText(driver, MyAccountPageUI.VERIFY_ADDRESS_COMPANY);

	}

	public String getAddress1Text() {
		waitForElementVisible(driver, MyAccountPageUI.VERIFY_ADDRESS_ADDRESS1);
		return getElementText(driver, MyAccountPageUI.VERIFY_ADDRESS_ADDRESS1);

	}

	public String getAddressZipCityText() {
		waitForElementVisible(driver, MyAccountPageUI.VERIFY_ADDRESS_CITY_ZIP);
		return getElementText(driver, MyAccountPageUI.VERIFY_ADDRESS_CITY_ZIP);

	}

	public String getAddressCountryText() {
		waitForElementVisible(driver, MyAccountPageUI.VERIFY_ADDRESS_COUNTRY);
		return getElementText(driver, MyAccountPageUI.VERIFY_ADDRESS_COUNTRY);

	}

	public void clickToChangePasswordLink() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_LINK);

	}

	public void inputToOldPasswordTextBox(String oldPassword) {
		waitForElementClickable(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX, oldPassword);

	}

	public void inputToNewPasswordTextBox(String newPassword) {
		waitForElementClickable(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX, newPassword);

	}

	public void inputToConfirmPasswordTextBox(String confirmPassword) {
		waitForElementClickable(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);

	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);

	}

	public void clickToCloseMessageButton() {
		waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_MESSAGE_CLOSE_BUTTON);
		clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_MESSAGE_CLOSE_BUTTON);
		waitForElementInvisible(driver, MyAccountPageUI.CHANGE_PASSWORD_MESSAGE_CLOSE_BUTTON);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, MyAccountPageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, MyAccountPageUI.MY_ACCOUNT_LINK);
	}

	public void clickToProductName(String params) {
		waitForElementClickable(driver, MyAccountPageUI.PRODUCT_NAME, params);
		clickToElement(driver, MyAccountPageUI.PRODUCT_NAME, params);
	}

	public void clickToAddYourReviewLink() {
		waitForElementClickable(driver, MyAccountPageUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, MyAccountPageUI.ADD_YOUR_REVIEW_LINK);
	}

	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementClickable(driver, MyAccountPageUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, MyAccountPageUI.REVIEW_TITLE_TEXTBOX, reviewTitle);

	}

	public void inputToReviewTextTextbox(String reviewText) {
		waitForElementClickable(driver, MyAccountPageUI.REVIEW_TEXT_TEXTAREA);
		sendkeyToElement(driver, MyAccountPageUI.REVIEW_TEXT_TEXTAREA, reviewText);

	}

	public void checkToReviewRatingRadio() {
		waitForElementClickable(driver, MyAccountPageUI.REVIEW_RATING_RADIO);
		checkToDefaultCheckboxRadio(driver, MyAccountPageUI.REVIEW_RATING_RADIO);
	}

	public void clickToReviewSubmitButton() {
		waitForElementClickable(driver, MyAccountPageUI.REVIEW_SUBMIT_BUTTON);
		clickToElement(driver, MyAccountPageUI.REVIEW_SUBMIT_BUTTON);
	}

	public void clickToMyProductReviewLink() {
		waitForElementClickable(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, MyAccountPageUI.MY_PRODUCT_REVIEW_LINK);
	}

	public boolean isProductNameDisplayed(String productName) {
		waitForElementVisible(driver, MyAccountPageUI.PRODUCT_NAME, productName);
		return isElementDisplayed(driver, MyAccountPageUI.PRODUCT_NAME, productName);
	}

}
