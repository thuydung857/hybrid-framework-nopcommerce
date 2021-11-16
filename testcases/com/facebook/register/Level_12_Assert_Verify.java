package com.facebook.register;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.RegisterPageObject;

public class Level_12_Assert_Verify extends BaseTest {

	private WebDriver driver;
	String emailAddress;
	private RegisterPageObject registerPage;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		driver.get("https://vi-vn.facebook.com/r.php");
		registerPage = new RegisterPageObject(driver);

	}

	@Test
	public void Register_01_Assert() {
		registerPage.inputToEmailTextBox("dung@gmail.com");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());

	}

	@Test
	public void Register_02_Verify() {
		registerPage.inputToEmailTextBox("");
		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());

		verifyTrue(registerPage.isConfirmEmailTextboxDisplayed());

		verifyFalse(registerPage.isConfirmEmailTextboxDisplayed());

		verifyTrue(registerPage.isConfirmEmailTextboxDisplayed());

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
