package com.nopcommerce.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_20_Test_Data extends BaseTest {

	private WebDriver driver;
	String emailAddress, firstName, lastName, password, company;
	String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	// khai báo
	UserData userData;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);
	}

	@Test
	public void Register_01_Valid_Info() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(UserData.Register.FIRSTNAME);
		registerPage.inputToLastNameTextBox(UserData.Register.LASTNAME);
		registerPage.inputToEmailTextBox(UserData.Register.EMAIL);
		registerPage.inputToCompanyTextBox(UserData.Register.COMPANY);
		registerPage.inputToPasswordTextBox(UserData.Register.PASSWORD);
		registerPage.inputToConfirmPasswordTextBox(UserData.Register.PASSWORD);
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	
}
