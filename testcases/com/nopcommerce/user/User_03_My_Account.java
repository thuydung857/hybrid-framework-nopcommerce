package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class User_03_My_Account extends BaseTest {
	private WebDriver driver;
	Select select;
	Actions action;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private MyAccountPageObject myAccountPage;
	String newFirstName, newLastName, newDate, newMonth, newYear, newCompany, productName;
	String projectPath = System.getProperty("user.dir");

	static String NEW_MAIL = "myduyen" + getRandomNumber() + "@gmail.com";
	static String NEW_PASSWORD = "654321";

	static String AD_FIRSTNAME = "Automation";
	static String AD_LASTNAME = "FC";
	static String AD_FULLNAME = AD_FIRSTNAME + " " + AD_LASTNAME;
	static String AD_EMAIL = "myduyen" + getRandomNumber() + "@gmail.com";
	static String AD_COMPANY = "Automation FC";
	static String AD_COUNTRY = "Viet Nam";
	static String AD_PROVINCE = "Other";
	static String AD_CITY = "HCM";
	static String AD_ADDRESS1 = "123 Le Loi";
	static String AD_ADDRESS2 = "456 Le Lai";
	static String AD_ZIP = "880000";
	static String AD_PHONENUMBER = "0987654321";
	static String AD_FAX = "13579";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		action = new Actions(driver);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		newFirstName = "Duyen";
		newLastName = "Tran";
		newDate = "21";
		newMonth = "April";
		newYear = "2003";
		newCompany = "Cong ty NHO";
		productName = "Build your own computer";

	}

	@Test
	public void My_Account_00_Login() {
		System.out.println("Login_06_Valid_Email_Correct_Password - Step 1: Click to Login Link");
		homePage.clickToLoginLink();

		System.out.println("Login_06_Valid_Email_Correct_Password - Step 2: Input valid email/empty password");
		loginPage.inputToEmailTextBox(User_01_Register.EMAIL_ADDRESS);
		loginPage.inputToPasswordTextBox(User_01_Register.PASSWORD);

		System.out.println("Login_06_Valid_Email_Correct_Password - Step 3: Click Login Button");
		loginPage.clickToLoginButton();

		System.out.println("Login_06_Valid_Email_Correct_Password - Step 4: Verify My account link displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void My_Account_01_Update_Customer_Info() {
		myAccountPage.clickToMyAccountLink();

		Assert.assertEquals(myAccountPage.getCustomerInfoHeader(), "My account - Customer info");

		myAccountPage.inputToCustomerFirstNameTextBox(newFirstName);
		myAccountPage.inputToCustomerLastNameTextBox(newLastName);
		myAccountPage.inputToCustomerEmailTextBox(User_03_My_Account.NEW_MAIL);
		myAccountPage.inputToCustomerCompanyTextBox(newCompany);

		myAccountPage.clickToSaveButton();

		Assert.assertEquals(myAccountPage.getFirstNameAttribute(), newFirstName);
		Assert.assertEquals(myAccountPage.getLastNameAttribute(), newLastName);
		Assert.assertEquals(myAccountPage.getEmailAttribute(), User_03_My_Account.NEW_MAIL);
		Assert.assertEquals(myAccountPage.getCompanyAttribute(), newCompany);

	}

	@Test
	public void My_Account_02_Add_Address() {
		myAccountPage.clickToAddressLink();
		myAccountPage.clickToAddressAddNewButton();

		myAccountPage.inputToAddressFirstNameTextBox(User_03_My_Account.AD_FIRSTNAME);
		myAccountPage.inputToAddressLastNameTextBox(User_03_My_Account.AD_LASTNAME);
		myAccountPage.inputToAddressEmailTextBox(User_03_My_Account.AD_EMAIL);
		myAccountPage.inputToAddressCompanyTextBox(User_03_My_Account.AD_COMPANY);
		myAccountPage.selectAddressCountryDropdown(User_03_My_Account.AD_COUNTRY);
		myAccountPage.selectAddressProvinceDropdown(User_03_My_Account.AD_PROVINCE);
		myAccountPage.inputToAddressCityTextBox(User_03_My_Account.AD_CITY);
		myAccountPage.inputToAddressAddress1TextBox(User_03_My_Account.AD_ADDRESS1);
		myAccountPage.inputToAddressAddress2TextBox(User_03_My_Account.AD_ADDRESS2);
		myAccountPage.inputToAddressZipTextBox(User_03_My_Account.AD_ZIP);
		myAccountPage.inputToAddressPhoneNumberTextBox(User_03_My_Account.AD_PHONENUMBER);
		myAccountPage.inputToAddressFaxTextBox(User_03_My_Account.AD_FAX);
		myAccountPage.clickToAddresSaveButton();

		Assert.assertEquals(myAccountPage.getAddressFullNameText(), User_03_My_Account.AD_FULLNAME);
		Assert.assertEquals(myAccountPage.getAddressEmailText(), "Email: " + User_03_My_Account.AD_EMAIL);
		Assert.assertEquals(myAccountPage.getAddressPhoneNumberText(),
				"Phone number: " + User_03_My_Account.AD_PHONENUMBER);
		Assert.assertEquals(myAccountPage.getAddressFaxText(), "Fax number: " + User_03_My_Account.AD_FAX);
		Assert.assertEquals(myAccountPage.getAddressCompanyText(), User_03_My_Account.AD_COMPANY);
		Assert.assertEquals(myAccountPage.getAddress1Text(), User_03_My_Account.AD_ADDRESS1);
		Assert.assertEquals(myAccountPage.getAddressZipCityText(),
				User_03_My_Account.AD_CITY + ", " + User_03_My_Account.AD_ZIP);
		Assert.assertEquals(myAccountPage.getAddressCountryText(), User_03_My_Account.AD_COUNTRY);

	}

	@Test
	public void My_Account_03_Change_Password() {
		myAccountPage.clickToChangePasswordLink();
		myAccountPage.inputToOldPasswordTextBox("123456");
		myAccountPage.inputToNewPasswordTextBox(User_03_My_Account.NEW_PASSWORD);
		myAccountPage.inputToConfirmPasswordTextBox(User_03_My_Account.NEW_PASSWORD);

		myAccountPage.clickToChangePasswordButton();

		myAccountPage.clickToCloseMessageButton();

		registerPage.clickToLogoutLink();

		homePage.clickToLoginLink();

		loginPage.inputToEmailTextBox(User_03_My_Account.NEW_MAIL);
		loginPage.inputToPasswordTextBox(User_03_My_Account.NEW_PASSWORD);
		loginPage.clickToLoginButton();

		Assert.assertTrue(myAccountPage.isMyAccountLinkDisplayed());

	}

	@Test
	public void My_Account_04_Product_Reviews() {
		myAccountPage.clickToProductName(productName);

		myAccountPage.clickToAddYourReviewLink();

		myAccountPage.inputToReviewTitleTextbox("Review Title");
		myAccountPage.inputToReviewTextTextbox("This is my review");
		myAccountPage.checkToReviewRatingRadio();
		myAccountPage.clickToReviewSubmitButton();

		myAccountPage.clickToMyAccountLink();
		myAccountPage.clickToMyProductReviewLink();
		Assert.assertTrue(myAccountPage.isProductNameDisplayed(productName));
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
