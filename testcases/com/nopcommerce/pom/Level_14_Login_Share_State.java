package com.nopcommerce.pom;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.commons.Common_01_login;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;

public class Level_14_Login_Share_State extends BaseTest {

	private WebDriver driver;
	Select select;
	Actions action;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	String emailAddress, firstName, lastName, password, company;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		driver.get("https://demo.nopcommerce.com/");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Precondition - Step 1: Click to Login link");
		homePage.clickToLoginLink();

		log.info("Precondition - Step 2: Set all cookie");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		loginPage.setAllCookies(driver, Common_01_login.loginPageCookie);
		loginPage.sleepInSecond(3);
		loginPage.refreshPage(driver);

		log.info("Precondition - Step 3: Verify My Account Link Displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyFalse(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void Login_01_Login_To_System() {

	}

	@Test
	public void Login_02_Login_To_System() {

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
