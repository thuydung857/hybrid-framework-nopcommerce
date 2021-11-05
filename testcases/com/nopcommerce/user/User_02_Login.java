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

import commons.BasePage;

public class User_02_Login extends BasePage {
	WebDriver driver;
	String emailAddress;
	Select select;
	Actions action;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Empty_Data() {
		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElementByJS(driver, "//a[@class='ico-login']");

		waitForElementClickable(driver, "//button[@class='button-1 login-button']");
		clickToElement(driver, "//button[@class='button-1 login-button']");

		Assert.assertEquals(getElementText(driver, "//span[@class='field-validation-error']"),
				"Please enter your email");

	}

	@Test
	public void TC_02_Wrong_Email() {
		sendkeyToElement(driver, "//input[@id='Email']", "abc");

		waitForElementClickable(driver, "//button[@class='button-1 login-button']");
		clickToElement(driver, "//button[@class='button-1 login-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void TC_03_Login_Email_Not_Register() {
		sendkeyToElement(driver, "//input[@id='Email']", "abc@gmail.com");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");

		waitForElementClickable(driver, "//button[@class='button-1 login-button']");
		clickToElement(driver, "//button[@class='button-1 login-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void TC_04_Valid_Email_Empty_Password() {
		sendkeyToElement(driver, "//input[@id='Email']", User_01_Register.EMAIL_ADDRESS);

		waitForElementClickable(driver, "//button[@class='button-1 login-button']");
		clickToElement(driver, "//button[@class='button-1 login-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_05_Valid_Email_Incorrect_Password() {
		sendkeyToElement(driver, "//input[@id='Email']", User_01_Register.EMAIL_ADDRESS);
		sendkeyToElement(driver, "//input[@id='Password']", "abc");

		waitForElementClickable(driver, "//button[@class='button-1 login-button']");
		clickToElement(driver, "//button[@class='button-1 login-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']"),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void TC_06_Valid_Email_Correct_Password() {
//		//Precondition: Login success
//		waitForElementClickable(driver, "//a[@class='ico-register']");
//		clickToElement(driver, "//a[@class='ico-register']");
//		
//		checkToDefaultCheckboxRadio(driver, "//input[@id='gender-female']");
//		sendkeyToElement(driver, "//input[@id='FirstName']", "Dung");
//		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
//		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "23");
//		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "10");
//		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "2000");
//		sendkeyToElement(driver, "//input[@id='Email']", User_01_Register.EMAIL_ADDRESS);
//		sendkeyToElement(driver, "//input[@id='Company']", "Automation FC");
//		sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		waitForElementClickable(driver, "//button[@id='register-button']");
//		clickToElement(driver, "//button[@id='register-button']");
//		
		//Testcase
//		waitForElementClickable(driver, "//a[@class='ico-login']");
//		clickToElementByJS(driver, "//a[@class='ico-login']");		
		
		sendkeyToElement(driver, "//input[@id='Email']", User_01_Register.EMAIL_ADDRESS);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");

		waitForElementClickable(driver, "//button[@class='button-1 login-button']");
		clickToElement(driver, "//button[@class='button-1 login-button']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));
	}

	@AfterClass
	public void afterClass() {
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
