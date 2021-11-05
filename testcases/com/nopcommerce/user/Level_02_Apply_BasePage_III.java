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

public class Level_02_Apply_BasePage_III extends BasePage { // Thua ke

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

		emailAddress = "NopCom" + getRandomNumber() + "@mail.net";

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/en/register?returnUrl=%2Fen%2Fdemo");
	}

	@Test
	public void TC_01_Empty_Data() {
		waitForElementClickable(driver, "//input[@id='register-button']");
		clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmEmail-error']"), "Email is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Username-error']"), "Username is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");

	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.navigate().refresh();

		sendkeyToElement(driver, "//input[@id='Email']", "kfc123");
		sendkeyToElement(driver, "//input[@id='ConfirmEmail']", "kfc123");

		waitForElementClickable(driver, "//input[@id='register-button']");
		clickToElement(driver, "//input[@id='register-button']");

	}

	@Test
	public void TC_03_Valid_Info() {
		action.moveToElement(getWebElement(driver, "//span[@class='ico-user sprite-image']")).perform();

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Dung");
		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='ConfirmEmail']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Username']", "dungnguyen" + getRandomNumber());
		waitForElementClickable(driver, "//input[@id='check-availability-button']");
		clickToElement(driver, "//input[@id='check-availability-button']");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		select = new Select(getWebElement(driver, "//select[@id='Details_CompanyIndustryId']"));
		select.selectByVisibleText("" + "I am student");

		waitForElementClickable(driver, "//input[@id='register-button']");
		clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='sub-title']//h2"),
				"Almost done! To complete your nopCommerce registration, we just need to verify your email address. You have just been sent an email to confirm your email address. Open the email, and click the link to confirm your address.");

	}

	@Test
	public void TC_04_Existing_Email() {
		action.moveToElement(getWebElement(driver, "//span[@class='ico-user sprite-image']")).perform();

		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		sendkeyToElement(driver, "//input[@id='FirstName']", "Dung");
		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='ConfirmEmail']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Username']", "dungnguyen" + getRandomNumber());
		waitForElementClickable(driver, "//input[@id='check-availability-button']");
		clickToElement(driver, "//input[@id='check-availability-button']");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		select = new Select(getWebElement(driver, "//select[@id='Details_CompanyIndustryId']"));
		select.selectByVisibleText("I am student");

		waitForElementClickable(driver, "//input[@id='register-button']");
		clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(
				getElementText(driver, "//div[@class='message-error validation-summary-errors']//li[1]"),
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

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
