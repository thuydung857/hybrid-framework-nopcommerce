package com.facebook.register;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.RegisterPageObject;

public class Level_11_Element_Undisplayed extends BaseTest {

	private WebDriver driver;
	Select select;
	Actions action;
	String emailAddress;
	private RegisterPageObject registerPage;

	String projectPath = System.getProperty("user.dir");
	static String EMAIL_ADDRESS = "NopCom" + getRandomNumber() + "@mail.net";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		driver.get("https://vi-vn.facebook.com/r.php");
		registerPage = new RegisterPageObject(driver);

		emailAddress = "auto" + getRandomNumber() + "@gmail.net";

	}

	@Test
	public void Register_01_Element_Displayed() {
		registerPage.inputToEmailTextBox("dung@gmail.com");
		Assert.assertTrue(registerPage.isConfirmEmailTextboxDisplayed());

	}

	@Test
	public void Register_02_Element_Undisplayed_In_DOM() {
		registerPage.inputToEmailTextBox("");
		registerPage.sleepInSecond(1);
		Assert.assertFalse(registerPage.isConfirmEmailTextboxDisplayed());

	}

	@Test
	public void Register_03_Element_Undisplayed_NOT_In_DOM() {
		// Pick random element not in page
		Assert.assertTrue(registerPage.isConfirmEmailTextboxUndisplayed());

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
