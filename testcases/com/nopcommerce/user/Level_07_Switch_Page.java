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
import pageObjects.NewsPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageObjects.SearchPageObject;

public class Level_07_Switch_Page extends BaseTest {

	private WebDriver driver;
	Select select;
	Actions action;
	String emailAddress, firstName, lastName, password, company;
	private HomePageObject homePage;
	private NewsPageObject newsPage;
	private SearchPageObject searchPage;
	private RegisterPageObject registerPage;
	String projectPath = System.getProperty("user.dir");
	static String EMAIL_ADDRESS = "NopCom" + getRandomNumber() + "@mail.net";

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
		newsPage = homePage.openNewsPage(driver);

		searchPage = newsPage.openSearchPage(driver);

		newsPage = searchPage.openNewsPage(driver);
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
