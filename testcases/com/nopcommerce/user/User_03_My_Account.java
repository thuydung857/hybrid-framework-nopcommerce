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
	String emailAddress, newFirstName, newLastName, newEmail, newDate, newMonth, newYear, newCompany;
	String adFirstName, adLastName, adEmail, adCompany, adCountry, adProvince, adCity, adAddress1, adAddress2, adZip,
			adPhoneNumber, adFaxNumber, adFullName;
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
		newEmail = "myduyen" + getRandomNumber() + "@gmail.com";
		newDate = "21";
		newMonth = "April";
		newYear = "2003";
		newCompany = "Cong ty NHO";

		adFirstName = "Automation";
		adLastName = "FC";
		adFullName = adFirstName + " " + adLastName;
		adEmail = "myduyen" + getRandomNumber() + "@gmail.com";
		adCompany = "Automation FC";
		adCountry = "Viet Nam";
		adProvince = "Other";
		adCity = "HCM";
		adAddress1 = "123 Le Loi";
		adAddress2 = "456 Le Lai";
		adZip = "880000";
		adPhoneNumber = "0987654321";
		adFaxNumber = "13579";

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_00_Valid_Email_Correct_Password() {
		// Precondition: Login success
		waitForElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		checkToDefaultCheckboxRadio(driver, "//input[@id='gender-female']");
		sendkeyToElement(driver, "//input[@id='FirstName']", "Dung");
		sendkeyToElement(driver, "//input[@id='LastName']", "Nguyen");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthDay']", "23");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthMonth']", "October");
		selectItemInDefaultDropdown(driver, "//select[@name='DateOfBirthYear']", "2000");
		sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
		sendkeyToElement(driver, "//input[@id='Company']", "Automation FC");
		sendkeyToElement(driver, "//input[@id='Password']", "123456");
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

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
		sendkeyToElement(driver, "//input[@id='Email']", newEmail);
		sendkeyToElement(driver, "//input[@id='Company']", newCompany);

		waitForElementClickable(driver, "//button[@id='save-info-button']");
		clickToElement(driver, "//button[@id='save-info-button']");

		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), newFirstName);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), newLastName);
		Assert.assertEquals(getElementAttribute(driver, "//select[@name='DateOfBirthDay']", "value"), newDate);
		Assert.assertEquals(getElementAttribute(driver, "//select[@name='DateOfBirthMonth']", "value"), "4");
		Assert.assertEquals(getElementAttribute(driver, "//select[@name='DateOfBirthYear']", "value"), newYear);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), newEmail);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), newCompany);

	}

	@Test
	public void TC_02_Add_Address() {
		clickToElement(driver, "//a[text()='Addresses']");
		clickToElement(driver, "//button[@class='button-1 add-address-button']");

		sendkeyToElement(driver, "//input[@id='Address_FirstName']", adFirstName);
		sendkeyToElement(driver, "//input[@id='Address_LastName']", adLastName);
		sendkeyToElement(driver, "//input[@id='Address_Email']", adEmail);
		sendkeyToElement(driver, "//input[@id='Address_Company']", adCompany);
		selectItemInDefaultDropdown(driver, "//select[@id='Address_CountryId']", adCountry);
		selectItemInDefaultDropdown(driver, "//select[@id='Address_StateProvinceId']", adProvince);
		sendkeyToElement(driver, "//input[@id='Address_City']", adCity);
		sendkeyToElement(driver, "//input[@id='Address_Address1']", adAddress1);
		sendkeyToElement(driver, "//input[@id='Address_Address2']", adAddress2);
		sendkeyToElement(driver, "//input[@id='Address_ZipPostalCode']", adZip);
		sendkeyToElement(driver, "//input[@id='Address_PhoneNumber']", adPhoneNumber);
		sendkeyToElement(driver, "//input[@id='Address_FaxNumber']", adFaxNumber);
		clickToElement(driver, "//button[@class='button-1 save-address-button']");

		Assert.assertEquals(getElementText(driver, "//li[@class='name']"), adFullName);
		Assert.assertEquals(getElementText(driver, "//li[@class='email']"), "Email: " + adEmail);
		Assert.assertEquals(getElementText(driver, "//li[@class='phone']"), "Phone number: " + adPhoneNumber);
		Assert.assertEquals(getElementText(driver, "//li[@class='fax']"), "Fax number: " + adFaxNumber);
		Assert.assertEquals(getElementText(driver, "//li[@class='company']"), adCompany);
		Assert.assertEquals(getElementText(driver, "//li[@class='address1']"), adAddress1);
		Assert.assertEquals(getElementText(driver, "//li[@class='city-state-zip']"), adCity + ", " + adZip);
		Assert.assertEquals(getElementText(driver, "//li[@class='country']"), adCountry);

	}

	@Test
	public void TC_03_Change_Password() {
		clickToElement(driver, "//a[text()='Change password']");

		sendkeyToElement(driver, "//input[@id='OldPassword']", "123456");
		sendkeyToElement(driver, "//input[@id='NewPassword']", "654321");
		sendkeyToElement(driver, "//input[@id='ConfirmNewPassword']", "654321");
		clickToElement(driver, "//button[@class='button-1 change-password-button']");

		waitForElementClickable(driver, "//span[@class='close']");
		clickToElement(driver, "//span[@class='close']");

		waitForAllElementInvisible(driver, "//span[@class='close']");
		waitForElementClickable(driver, "//a[@class='ico-logout']");
		clickToElement(driver, "//a[@class='ico-logout']");

		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", newEmail);
		sendkeyToElement(driver, "//input[@id='Password']", "654321");

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

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
