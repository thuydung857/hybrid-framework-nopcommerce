package com.nopcommerce.pom;

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

public class Level_15_Page_Object_Pattern extends BaseTest {

	private WebDriver driver;
	Select select;
	Actions action;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	String emailAddress, firstName, lastName, password, company;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		emailAddress = "nopCom" + getRandomNumber() + "@mail.net";
		firstName = "Dung";
		lastName = "Nguyen";
		password = "123456";
		company = "Automation";

	}

	@Test
	public void Login_01_Register() {
		log.info("Login_01_Valid_Info - Step 1: Click to Register Link");
		homePage.clickToLinkByText(driver, "Register");

		log.info("Login_01_Valid_Info - Step 2: Input to first name fields");
		registerPage.inputToTextBoxByID(driver, firstName, "FirstName");

		log.info("Login_01_Valid_Info - Step 2: Input to last name fields");
		registerPage.inputToTextBoxByID(driver, lastName, "LastName");

		log.info("Login_01_Valid_Info - Step 4: Input to email fields");
		registerPage.inputToTextBoxByID(driver, emailAddress, "Email");

		log.info("Login_01_Valid_Info - Step 4: Input to company fields");
		registerPage.inputToTextBoxByID(driver, company, "Company");

		log.info("Login_01_Valid_Info - Step 5: Input to password fields");
		registerPage.inputToTextBoxByID(driver, password, "Password");

		log.info("Login_01_Valid_Info - Step 6: Input to confirm password fields");
		registerPage.inputToTextBoxByID(driver, password, "ConfirmPassword");

		log.info("Login_01_Valid_Info - Step 7: Click to Register Button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Login_01_Valid_Info - Step 8: Verify register successful message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");

	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();

	}

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
