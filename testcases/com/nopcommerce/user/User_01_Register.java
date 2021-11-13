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
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class User_01_Register extends BaseTest {

	private WebDriver driver;
	Select select;
	Actions action;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	String emailAddress, firstName, lastName, password, company;
	String projectPath = System.getProperty("user.dir");
	static String EMAIL_ADDRESS = "NopCom" + getRandomNumber() + "@mail.net";
	static String PASSWORD = "123456";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		action = new Actions(driver);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		emailAddress = "auto" + getRandomNumber() + "@gmail.net";
		firstName = "Dung";
		lastName = "Nguyen";
		password = "123456";
		company = "Automation";

	}

	@Test
	public void Register_01_Empty_Data() {
		System.out.println("Register_01_Empty_Data - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register_01_Empty_Data - Step 2: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_01_Empty_Data - Step 3: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageFirstNameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageLastNameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageEmailTextBox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessagePasswordTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageConfirmPasswordTextBox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		System.out.println("Register_02_Invalid_Email - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register_02_Invalid_Email - Step 2: Input invalid Email");
		registerPage.inputToEmailTextBox(company);

		System.out.println("Register_02_Invalid_Email - Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_02_Invalid_Email - Step 4: Verify error message displayed");
		Assert.assertEquals(registerPage.getErrorMessageEmailTextBox(), "Wrong email");

	}

	@Test
	public void Register_03_Valid_Info() {
		System.out.println("Register_03_Valid_Info - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register_03_Valid_Info - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(User_01_Register.EMAIL_ADDRESS);
		registerPage.inputToCompanyTextBox(company);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);

		System.out.println("Register_03_Valid_Info - Step 3: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_03_Valid_Info - Step 4: Verify register successful message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");

	}

	@Test
	public void Register_04_Existing_Email() {
		System.out.println("Register_04_Existing_Email - Step 1: Click to Logout Link");
		registerPage.clickToLogoutLink();

		System.out.println("Register_04_Existing_Email - Step 2: Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register_04_Existing_Email - Step 3: Input existing email");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(User_01_Register.EMAIL_ADDRESS);
		registerPage.inputToCompanyTextBox(company);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);

		System.out.println("Register_04_Existing_Email - Step 4: Click to Register Button");
		registerPage.clickToRegisterButton();

		System.out.println("Register_04_Existing_Email - Step 5: Verify existing email message displayed");
		Assert.assertEquals(registerPage.getExistingErrorMessageEmailTextBox(), "The specified email already exists");

	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		System.out.println("Register_05_Password_Less_Than_6_Chars - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register_05_Password_Less_Than_6_Chars - Step 2: Input password less than 6 characters");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(User_01_Register.EMAIL_ADDRESS);
		registerPage.inputToCompanyTextBox(company);
		registerPage.inputToPasswordTextBox("123");
		registerPage.inputToConfirmPasswordTextBox(password);

		System.out.println("Register_05_Password_Less_Than_6_Chars - Step 3: Verify error password message displayed");
		Assert.assertEquals(registerPage.getErrorMessagePasswordTextBox(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Password_Different_Confirm_Password() {
		System.out.println("Home Page - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();

		System.out.println("Register Page - Step 2: Input password diff confirm password");
		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(User_01_Register.EMAIL_ADDRESS);
		registerPage.inputToCompanyTextBox(company);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(emailAddress);

		System.out.println("Register_05_Password_Less_Than_6_Chars - Step 4: Click to Register Button");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageConfirmPasswordTextBox(),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
