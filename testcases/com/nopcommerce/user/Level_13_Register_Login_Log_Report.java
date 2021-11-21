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

public class Level_13_Register_Login_Log_Report extends BaseTest {

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
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		firstName = "Dung";
		lastName = "Nguyen";
		password = "123456";
		company = "Automation";

		Assert.assertTrue(false);
	}

	@Test
	public void Login_01_Valid_Info() {
		log.info("Login_01_Valid_Info - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();

		log.info("Login_01_Valid_Info - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstName);

		log.info("Login_01_Valid_Info - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstName);

		log.info("Login_01_Valid_Info - Step 3: Input to required fields");
		registerPage.inputToLastNameTextBox(lastName);

		log.info("Login_01_Valid_Info - Step 4: Input to required fields");
		registerPage.inputToEmailTextBox(Level_13_Register_Login_Log_Report.EMAIL_ADDRESS);

		log.info("Login_01_Valid_Info - Step 4: Input to required fields");
		registerPage.inputToCompanyTextBox(company);

		log.info("Login_01_Valid_Info - Step 5: Input to required fields");
		registerPage.inputToPasswordTextBox(password);

		log.info("Login_01_Valid_Info - Step 6: Input to required fields");
		registerPage.inputToConfirmPasswordTextBox(password);

		log.info("Login_01_Valid_Info - Step 7: Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("Login_01_Valid_Info - Step 8: Verify register successful message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");

	}

	@Test
	public void Login_02_Valid_Email_Correct_Password() {
		log.info("Login_02_Valid_Email_Correct_Password - Step 4: Verify My account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login_02_Valid_Email_Correct_Password - Step 5: Verify My account link displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login_02_Valid_Email_Correct_Password - Step 6: Verify My account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login_02_Valid_Email_Correct_Password - Step 7: Verify My account link displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login_02_Valid_Email_Correct_Password - Step 8: Verify My account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login_02_Valid_Email_Correct_Password - Step 9: Verify My account link displayed");
		verifyFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login_02_Valid_Email_Correct_Password - Step 10: Verify My account link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Parameters("browser")
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
		
	}

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
