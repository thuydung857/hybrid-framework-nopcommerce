package com.nopcommerce.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.swagLabs.HomePageObject;
import pageObjects.swagLabs.LoginPageObject;
import pageObjects.swagLabs.PageGeneratorManager;

public class Level_18_Sort extends BaseTest {

	private WebDriver driver;
	String emailAddress, password;
	LoginPageObject loginPage;
	HomePageObject homePage;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		driver.get("https://www.saucedemo.com/");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		emailAddress = "standard_user";
		password = "secret_sauce";

	}

	@Test
	public void Sort_01_Login() {
		loginPage.inputToTextboxByID(emailAddress, "user-name");
		loginPage.inputToTextboxByID(password, "password");
		loginPage.clickToButtonByValue("Login");

	}

	@Test
	public void Sort_02_Sort_A_To_Z() {
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.selectItemInDropDown("Name (A to Z)");
		verifyTrue(homePage.isTextSortAscending());

	}

	@Test
	public void Sort_03_Sort_Z_To_A() {
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.selectItemInDropDown("Name (Z to A)");
		verifyFalse(homePage.isTextSortDescending());

	}

	@Test
	public void Sort_04_Sort_Price_Low_To_High() {
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.selectItemInDropDown("Price (low to high)");
		verifyTrue(homePage.isPriceSortAscending());

	}

	@Test
	public void Sort_05_Sort_Price_High_To_Low() {
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.selectItemInDropDown("Price (high to low)");
		verifyTrue(homePage.isPriceSortDescending());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
