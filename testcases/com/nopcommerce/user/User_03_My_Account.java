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

public class User_03_My_Account extends BasePage {
	WebDriver driver;
	String emailAddress, newFirstName, newLastName, newDate, newMonth, newYear, newCompany;

	static String NEW_MAIL = "myduyen" + getRandomNumber() + "@gmail.com";
	static String NEW_PASSWORD = "654321";
	
	static String AD_FIRSTNAME = "Automation";
	static String AD_LASTNAME = "FC";
	static String AD_FULLNAME = AD_FIRSTNAME + " " + AD_LASTNAME;
	static String AD_EMAIL = "myduyen" + getRandomNumber() + "@gmail.com";
	static String AD_COMPANY = "Automation FC";
	static String AD_COUNTRY = "Viet Nam";
	static String AD_PROVINCE = "Other";
	static String AD_CITY = "HCM";
	static String AD_ADDRESS1 = "123 Le Loi";
	static String AD_ADDRESS2 = "456 Le Lai";
	static String AD_ZIP = "880000";
	static String AD_PHONENUMBER = "0987654321";
	static String AD_FAX = "13579";

	Select select;
	Actions action;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);

		emailAddress = "NopCom" + getRandomNumber() + "@mail.net";

		newFirstName = "Duyen";
		newLastName = "Tran";
		newDate = "21";
		newMonth = "April";
		newYear = "2003";
		newCompany = "Cong ty NHO";

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_00_Login() {
		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElementByJS(driver, "//a[@class='ico-login']");
		sendkeyToElement(driver, "//input[@id='Email']", User_01_Register.EMAIL_ADDRESS);
		sendkeyToElement(driver, "//input[@id='Password']", "123456");

		waitForElementClickable(driver, "//button[@class='button-1 login-button']");
		clickToElement(driver, "//button[@class='button-1 login-button']");

	}

	@Test
	public void TC_01_Update_Customer_Info() {
		waitForElementClickable(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");
		sleepInSecond(1);
		Assert.assertEquals(getElementText(driver, "//div[@class='page-title']//h1"), "My account - Customer info");

		checkToDefaultCheckboxRadio(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", newFirstName);
		sendkeyToElement(driver, "//input[@id='LastName']", newLastName);
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", newDate);
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", newMonth);
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", newYear);
		sendkeyToElement(driver, "//input[@id='Email']", User_03_My_Account.NEW_MAIL);
		sendkeyToElement(driver, "//input[@id='Company']", newCompany);

		waitForElementClickable(driver, "//button[@id='save-info-button']");
		clickToElement(driver, "//button[@id='save-info-button']");

		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), newFirstName);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), newLastName);
		Assert.assertEquals(getElementAttribute(driver, "//select[@name='DateOfBirthDay']", "value"), newDate);
		Assert.assertEquals(getElementAttribute(driver, "//select[@name='DateOfBirthMonth']", "value"), "4");
		Assert.assertEquals(getElementAttribute(driver, "//select[@name='DateOfBirthYear']", "value"), newYear);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), User_03_My_Account.NEW_MAIL);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), newCompany);

	}

	@Test
	public void TC_02_Add_Address() {
		clickToElement(driver, "//a[text()='Addresses']");
		clickToElement(driver, "//button[@class='button-1 add-address-button']");

		sendkeyToElement(driver, "//input[@id='Address_FirstName']", User_03_My_Account.AD_FIRSTNAME);
		sendkeyToElement(driver, "//input[@id='Address_LastName']", User_03_My_Account.AD_LASTNAME);
		sendkeyToElement(driver, "//input[@id='Address_Email']", User_03_My_Account.AD_EMAIL);
		sendkeyToElement(driver, "//input[@id='Address_Company']", User_03_My_Account.AD_COMPANY);
		selectItemInDefaultDropdown(driver, "//select[@id='Address_CountryId']", User_03_My_Account.AD_COUNTRY);
		selectItemInDefaultDropdown(driver, "//select[@id='Address_StateProvinceId']", User_03_My_Account.AD_PROVINCE);
		sendkeyToElement(driver, "//input[@id='Address_City']", User_03_My_Account.AD_CITY);
		sendkeyToElement(driver, "//input[@id='Address_Address1']", User_03_My_Account.AD_ADDRESS1);
		sendkeyToElement(driver, "//input[@id='Address_Address2']", User_03_My_Account.AD_ADDRESS2);
		sendkeyToElement(driver, "//input[@id='Address_ZipPostalCode']", User_03_My_Account.AD_ZIP);
		sendkeyToElement(driver, "//input[@id='Address_PhoneNumber']", User_03_My_Account.AD_PHONENUMBER);
		sendkeyToElement(driver, "//input[@id='Address_FaxNumber']", User_03_My_Account.AD_FAX);
		clickToElement(driver, "//button[@class='button-1 save-address-button']");

		Assert.assertEquals(getElementText(driver, "//li[@class='name']"), User_03_My_Account.AD_FULLNAME);
		Assert.assertEquals(getElementText(driver, "//li[@class='email']"), "Email: " + User_03_My_Account.AD_EMAIL);
		Assert.assertEquals(getElementText(driver, "//li[@class='phone']"), "Phone number: " + User_03_My_Account.AD_PHONENUMBER);
		Assert.assertEquals(getElementText(driver, "//li[@class='fax']"), "Fax number: " + User_03_My_Account.AD_FAX);
		Assert.assertEquals(getElementText(driver, "//li[@class='company']"), User_03_My_Account.AD_COMPANY);
		Assert.assertEquals(getElementText(driver, "//li[@class='address1']"), User_03_My_Account.AD_ADDRESS1);
		Assert.assertEquals(getElementText(driver, "//li[@class='city-state-zip']"), User_03_My_Account.AD_CITY + ", " + User_03_My_Account.AD_ZIP);
		Assert.assertEquals(getElementText(driver, "//li[@class='country']"), User_03_My_Account.AD_COUNTRY);

	}

	@Test
	public void TC_03_Change_Password() {
		clickToElement(driver, "//a[text()='Change password']");

		sendkeyToElement(driver, "//input[@id='OldPassword']", "123456");
		sendkeyToElement(driver, "//input[@id='NewPassword']", User_03_My_Account.NEW_PASSWORD);
		sendkeyToElement(driver, "//input[@id='ConfirmNewPassword']", User_03_My_Account.NEW_PASSWORD);
		clickToElement(driver, "//button[@class='button-1 change-password-button']");

		waitForElementClickable(driver, "//span[@class='close']");
		clickToElement(driver, "//span[@class='close']");

		waitForAllElementInvisible(driver, "//span[@class='close']");
		waitForElementClickable(driver, "//a[@class='ico-logout']");
		clickToElement(driver, "//a[@class='ico-logout']");

		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", User_03_My_Account.NEW_MAIL);
		sendkeyToElement(driver, "//input[@id='Password']", User_03_My_Account.NEW_PASSWORD);

		waitForElementClickable(driver, "//button[@class='button-1 login-button']");
		clickToElement(driver, "//button[@class='button-1 login-button']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));

	}

	@Test
	public void TC_04_Product_Reviews() {
		waitForElementClickable(driver, "//a[text()='Build your own computer']");
		clickToElement(driver, "//a[text()='Build your own computer']");

		waitForElementClickable(driver, "//a[text()='Add your review']");
		clickToElement(driver, "//a[text()='Add your review']");

		sendkeyToElement(driver, "//input[@id='AddProductReview_Title']", "Review Title");
		sendkeyToElement(driver, "//textarea[@id='AddProductReview_ReviewText']", "This is my review");
		checkToDefaultCheckboxRadio(driver, "//input[@id='addproductrating_3']");
		clickToElement(driver, "//button[@name='add-review']");

		waitForElementClickable(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[text()='My product reviews']");
		Assert.assertTrue(isElementDisplayed(driver, "//a[text()='Build your own computer']"));
	}

	@AfterClass
	public void afterClass() {
	}

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
