package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.GetElementText;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_I { //gọi hàm từ basePage ra xài
	WebDriver driver;
	String emailAddress;
	Select select;
	Actions action;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		basePage = new BasePage();
		emailAddress = "NopCom" + getRandomNumber() + "@mail.net";

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/en/register?returnUrl=%2Fen%2Fdemo");
	}

	@Test
	public void TC_01_Empty_Data() {
		basePage.waitForElementClickable(driver, "//input[@id='register-button']");
		basePage.clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmEmail-error']"), "Email is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Username-error']"), "Username is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"Password is required.");

	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.navigate().refresh();

		basePage.sendkeyToElement(driver, "//input[@id='Email']", "kfc123");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmEmail']", "kfc123");

		basePage.waitForElementClickable(driver, "//input[@id='register-button']");
		basePage.clickToElement(driver, "//input[@id='register-button']");

	}

	@Test
	public void TC_03_Valid_Info() {
		action.moveToElement(basePage.getWebElement(driver, "//span[@class='ico-user sprite-image']")).perform();

		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Dung");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmEmail']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Username']", "dungnguyen" + getRandomNumber());
		basePage.waitForElementClickable(driver, "//input[@id='check-availability-button']");
		basePage.clickToElement(driver, "//input[@id='check-availability-button']");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		select = new Select(basePage.getWebElement(driver, "//select[@id='Details_CompanyIndustryId']"));
		select.selectByVisibleText(""
				+ "I am student");

		basePage.waitForElementClickable(driver, "//input[@id='register-button']");
		basePage.clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='sub-title']//h2"),
				"Almost done! To complete your nopCommerce registration, we just need to verify your email address. You have just been sent an email to confirm your email address. Open the email, and click the link to confirm your address.");

	}

	@Test
	public void TC_04_Existing_Email() {
		action.moveToElement(basePage.getWebElement(driver, "//span[@class='ico-user sprite-image']")).perform();

		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Dung");
		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmEmail']", emailAddress);
		basePage.sendkeyToElement(driver, "//input[@id='Username']", "dungnguyen" + getRandomNumber());
		basePage.waitForElementClickable(driver, "//input[@id='check-availability-button']");
		basePage.clickToElement(driver, "//input[@id='check-availability-button']");
		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		select = new Select(basePage.getWebElement(driver, "//select[@id='Details_CompanyIndustryId']"));
		select.selectByVisibleText("I am student");

		basePage.waitForElementClickable(driver, "//input[@id='register-button']");
		basePage.clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(
				basePage.getElementText(driver, "//div[@class='message-error validation-summary-errors']//li[1]"),
				"The specified email already exists");

	}

	@Test
	public void TC_05_Password_Less_Than_6_Chars() {
		driver.navigate().refresh();

		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Password_Different_Confirm_Password() {
		driver.navigate().refresh();

		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123");
		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		basePage.clickToElement(driver, "//input[@id='Password']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
