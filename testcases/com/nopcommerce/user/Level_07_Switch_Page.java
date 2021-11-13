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
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;

// Switch page = ham GET o trong BasePage (10 page = 10 ham)
public class Level_07_Switch_Page extends BaseTest {

	private WebDriver driver;
	Select select;
	Actions action;
	String emailAddress, firstName, lastName, password, company;
	private HomePageObject homePage;
	private OrderPageObject orderPage;
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
	public void Register_01_Valid_Info() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);
		registerPage.inputToLastNameTextBox(lastName);
		registerPage.inputToEmailTextBox(emailAddress);
		registerPage.inputToCompanyTextBox(company);
		registerPage.inputToPasswordTextBox(password);
		registerPage.inputToConfirmPasswordTextBox(password);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");

	}

	@Test
	public void Switch_Page() {
		orderPage = homePage.getNewsPage(driver);

		searchPage = orderPage.getSearchPage(driver);

		orderPage = searchPage.getNewsPage(driver);
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
