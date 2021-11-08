package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class Level_03_Page_Objects_Register {

	private WebDriver driver;
	Select select;
	Actions action;
	String emailAddress, wrongEmail, invalidEmail, password;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	String projectPath = System.getProperty("user.dir");
	static String EMAIL_ADDRESS = "NopCom" + getRandomNumber() + "@mail.net";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);

		emailAddress = "auto" + getRandomNumber() + "@gmail.net";
		wrongEmail = "abc";
		password = "123456";
		invalidEmail = "abc@gmail.com";

	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_01_Empty_Data - Step 1: Click to Login Link");
		homePage.clickToLoginLink();

		System.out.println("Login_01_Empty_Data - Step 2: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("Login_01_Empty_Data - Step 3: Verify email message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");

	}

	@Test
	public void Login_02_Wrong_Email() {
		System.out.println("Login_02_Wrong_Email - Step 1: Click to Login Link");
		homePage.clickToLoginLink();

		System.out.println("Login_02_Wrong_Email - Step 2: Input Wrong Email");
		loginPage.inputToEmailTextBox(wrongEmail);
		loginPage.inputToPasswordTextBox(password);

		System.out.println("Login_02_Wrong_Email - Step 3: Click Login Button");
		loginPage.clickToLoginButton();

		System.out.println("Login_02_Wrong_Email - Step 4: Verify email error message displayed");
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email");

	}

	@Test
	public void Login_03_Login_Email_Not_Register() {
		System.out.println("Login_03_Login_Email_Not_Register - Step 1: Click to Login Link");
		homePage.clickToLoginLink();

		System.out.println("Login_03_Login_Email_Not_Register - Step 2: Input invalid email");
		loginPage.inputToEmailTextBox(invalidEmail);
		loginPage.inputToPasswordTextBox(password);

		System.out.println("Login_03_Login_Email_Not_Register - Step 3: Click Login Button");
		loginPage.clickToLoginButton();

		System.out.println(
				"Login_03_Login_Email_Not_Register - Step 4: Verify login unsuccesful email message displayed");
		Assert.assertEquals(loginPage.getLoginUnsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Valid_Email_Empty_Password() {
		System.out.println("Login_04_Valid_Email_Empty_Password - Step 1: Click to Login Link");
		homePage.clickToLoginLink();

		System.out.println("Login_04_Valid_Email_Empty_Password - Step 2: Input valid email/empty password");
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox("");

		System.out.println("Login_04_Valid_Email_Empty_Password - Step 3: Click Login Button");
		loginPage.clickToLoginButton();

		System.out.println(
				"Login_04_Valid_Email_Empty_Password - Step 4: Verify login unsuccesful email message displayed");
		Assert.assertEquals(loginPage.getLoginUnsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_05_Valid_Email_Incorrect_Password() {
		System.out.println("Login_05_Valid_Email_Incorrect_Password - Step 1: Click to Login Link");
		homePage.clickToLoginLink();

		System.out.println("Login_05_Valid_Email_Incorrect_Password - Step 2: Input valid email/empty password");
		loginPage.inputToEmailTextBox(emailAddress);
		loginPage.inputToPasswordTextBox(emailAddress);

		System.out.println("Login_05_Valid_Email_Incorrect_Password - Step 3: Click Login Button");
		loginPage.clickToLoginButton();

		System.out.println(
				"Login_05_Valid_Email_Incorrect_Password - Step 4: Verify login unsuccesful email message displayed");
		Assert.assertEquals(loginPage.getLoginUnsuccessfulMessage(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_06_Valid_Email_Correct_Password() {
		System.out.println("Login_06_Valid_Email_Correct_Password - Step 1: Click to Login Link");
		homePage.clickToLoginLink();

		System.out.println("Login_06_Valid_Email_Correct_Password - Step 2: Input valid email/empty password");
		loginPage.inputToEmailTextBox(Level_03_Page_Objects_Login.EMAIL_ADDRESS);
		loginPage.inputToPasswordTextBox(password);

		System.out.println("Login_06_Valid_Email_Correct_Password - Step 3: Click Login Button");
		loginPage.clickToLoginButton();

		System.out.println("Login_06_Valid_Email_Correct_Password - Step 4: Verify My account link displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

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
