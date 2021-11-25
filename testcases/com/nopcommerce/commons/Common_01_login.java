package com.nopcommerce.commons;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Common_01_login extends BaseTest {

	private WebDriver driver;
	Select select;
	Actions action;
	public static Set<Cookie> loginPageCookie;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	String emailAddress, firstName, lastName, password, company;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeTest
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		loginPage = PageGeneratorManager.getLoginPage(driver);

		emailAddress = "nopCom" + getRandomNumber() + "@mail.net";
		firstName = "Dung";
		lastName = "Nguyen";
		password = "123456";
		company = "Automation";

		log.info("Common_01 - Step 1: Click to Register Link");
		homePage.clickToRegisterLink();

		log.info("Common_01 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstName);

		log.info("Common_01 - Step 2: Input to required fields");
		registerPage.inputToFirstNameTextBox(firstName);

		log.info("Common_01 - Step 3: Input to required fields");
		registerPage.inputToLastNameTextBox(lastName);

		log.info("Common_01 - Step 4: Input to required fields");
		registerPage.inputToEmailTextBox(emailAddress);

		log.info("Common_01 - Step 5: Input to required fields");
		registerPage.inputToCompanyTextBox(company);

		log.info("Common_01 - Step 6: Input to required fields");
		registerPage.inputToPasswordTextBox(password);

		log.info("Common_01 - Step 7: Input to required fields");
		registerPage.inputToConfirmPasswordTextBox(password);

		log.info("Common_01 - Step 8 Click to Register Button");
		registerPage.clickToRegisterButton();

		log.info("Common_01 - Step 9: Verify register successful message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");

		log.info("Common_01 - Step 10: Click to Logout link");
		registerPage.clickToLogoutLink();

		log.info("Common_01 - Step 11: Click to Login link");
		homePage.clickToLoginLink();

		log.info("Common_01 - Step 12: Input to Email textbox");
		loginPage.inputToEmailTextBox(emailAddress);

		log.info("Common_01 - Step 13: Input to Password textbox");
		loginPage.inputToPasswordTextBox(password);

		log.info("Common_01 - Step 14: Click to Login Button");
		loginPage.clickToLoginButton();

		log.info("Common_01 - Step 15: Verify My Account Link Displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Common_01 - Step 16: Get all page cookies");
		loginPageCookie = homePage.getAllCookies(driver);
		System.out.println(loginPageCookie);
		
		log.info("Post-Condition -  Step 14: Close browser");
		closeBrowserAndDriver();

	}

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
