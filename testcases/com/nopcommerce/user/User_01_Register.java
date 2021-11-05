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

public class User_01_Register extends BasePage { // Thua ke

	WebDriver driver;
	Select select;
	Actions action;
	String projectPath = System.getProperty("user.dir");
	static String EMAIL_ADDRESS = "NopCom" + getRandomNumber() + "@mail.net";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);

		EMAIL_ADDRESS = "NopCom" + getRandomNumber() + "@mail.net";

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Empty_Data() {
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.navigate().refresh();

		sendkeyToElement(driver, "//input[@id='Email']", "kfc123");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
	}

	@Test
	public void TC_03_Valid_Info() {
		checkToDefaultCheckboxRadio(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Dung");
		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "23");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "October");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "2000");
		sendkeyToElement(driver, "//input[@id='Email']", User_01_Register.EMAIL_ADDRESS);
		sendkeyToElement(driver, "//input[@id='Company']", "Automation FC");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

	}

	@Test
	public void TC_04_Existing_Email() {
		waitForElementClickable(driver, "//a[@class='ico-logout']");
		clickToElement(driver, "//a[@class='ico-logout']");

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		checkToDefaultCheckboxRadio(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Dung");
		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "23");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "October");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "2000");
		sendkeyToElement(driver, "//input[@id='Email']", User_01_Register.EMAIL_ADDRESS);
		sendkeyToElement(driver, "//input[@id='Company']", "Automation FC");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"),
				"The specified email already exists");

	}

	@Test
	public void TC_05_Password_Less_Than_6_Chars() {
		driver.navigate().refresh();

		sendkeyToElement(driver, "//input[@id='Password']", "123");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Password_Different_Confirm_Password() {
		driver.navigate().refresh();

		sendkeyToElement(driver, "//input[@id='Password']", "123");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		clickToElement(driver, "//input[@id='Password']");

		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");

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
