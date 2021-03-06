package com.nopcommerce.pom;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.MyAccountPageObject;
import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.SearchPageObject;

//Switch page = ham GET o trong BasePage (1 ham, 1 localtor, nhung de xai thi 2 dong - TC2)
public class Level_08_Dynamic_Locator extends BaseTest {

	private WebDriver driver;
	String emailAddress, firstName, lastName, password, company;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private OrderPageObject orderPage;
	private MyAccountPageObject myAccountPage;
	private SearchPageObject searchPage;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
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
	public void Switch_Page_Using_Dynamic_Locator() {
		myAccountPage.getfooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);

		searchPage.getfooterPageByName(driver, "Orders");
		orderPage = PageGeneratorManager.getOrderPage(driver);

		orderPage.getfooterPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);

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
