package com.nopcommerce.user;

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

public class User_04_Search extends BasePage {
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
	public void TC_00_Login() {
		waitForElementClickable(driver, "//a[@class='ico-login']");
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", User_03_My_Account.NEW_MAIL);
		sendkeyToElement(driver, "//input[@id='Password']", User_03_My_Account.NEW_PASSWORD);

		waitForElementClickable(driver, "//button[@class='button-1 login-button']");
		clickToElement(driver, "//button[@class='button-1 login-button']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));

	}

	@Test
	public void TC_01_Search_Empty_Data() {
		clickToElement(driver, "//a[text()='Search']");
		waitForElementClickable(driver, "//button[@class='button-1 search-button']");
		clickToElement(driver, "//button[@class='button-1 search-button']");
		Assert.assertEquals(getElementText(driver, "//div[@class='warning']"),
				"Search term minimum length is 3 characters");

	}

	@Test
	public void TC_02_Data_Not_Existed() {
		sendkeyToElement(driver, "//input[@class='search-text']", "Macbook Pro 2050");
		waitForElementClickable(driver, "//button[@class='button-1 search-button']");
		clickToElement(driver, "//button[@class='button-1 search-button']");
		Assert.assertEquals(getElementText(driver, "//div[@class='no-result']"),
				"No products were found that matched your criteria.");

	}

	@Test
	public void TC_03_Search_Partial_ProductName() {
		sendkeyToElement(driver, "//input[@class='search-text']", "Lenovo");
		waitForElementClickable(driver, "//button[@class='button-1 search-button']");
		clickToElement(driver, "//button[@class='button-1 search-button']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[text()='Lenovo IdeaCentre 600 All-in-One PC']"));
		Assert.assertTrue(isElementDisplayed(driver, "//a[text()='Lenovo Thinkpad X1 Carbon Laptop']"));
		Assert.assertEquals(getElementSize(driver, "//div[@class='item-grid']//div[@class='product-item']"), 2);

	}

	@Test
	public void TC_04_Search_Exactly_ProductName() {
		sendkeyToElement(driver, "//input[@class='search-text']", "Lenovo Thinkpad X1 Carbon Laptop");
		waitForElementClickable(driver, "//button[@class='button-1 search-button']");
		clickToElement(driver, "//button[@class='button-1 search-button']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[text()='Lenovo Thinkpad X1 Carbon Laptop']"));

	}

	@Test
	public void TC_05_Advanced_Search_Parent_Categories() {
		sendkeyToElement(driver, "//input[@class='search-text']", "Apple MacBook Pro");
		checkToDefaultCheckboxRadio(driver, "//input[@id='advs']");
		selectItemInDefaultDropdown(driver, "//select[@id='cid']", "Computers");

		waitForElementClickable(driver, "//button[@class='button-1 search-button']");
		clickToElement(driver, "//button[@class='button-1 search-button']");
		Assert.assertEquals(getElementText(driver, "//div[@class='no-result']"),
				"No products were found that matched your criteria.");
	}

	@Test
	public void TC_06_Advanced_Search_Sub_Categories() {
		sendkeyToElement(driver, "//input[@class='search-text']", "Apple MacBook Pro");
		checkToDefaultCheckboxRadio(driver, "//input[@id='advs']");
		selectItemInDefaultDropdown(driver, "//select[@id='cid']", "Computers");
		checkToDefaultCheckboxRadio(driver, "//input[@id='isc']");

		waitForElementClickable(driver, "//button[@class='button-1 search-button']");
		clickToElement(driver, "//button[@class='button-1 search-button']");
		Assert.assertTrue(isElementDisplayed(driver, "//a[text()='Apple MacBook Pro 13-inch']"));

	}

	@Test
	public void TC_07_Advanced_Search_Incorrect_Manufacturer() {
		sendkeyToElement(driver, "//input[@class='search-text']", "Apple MacBook Pro");
		selectItemInDefaultDropdown(driver, "//select[@id='mid']", "HP");

		waitForElementClickable(driver, "//button[@class='button-1 search-button']");
		clickToElement(driver, "//button[@class='button-1 search-button']");
		Assert.assertEquals(getElementText(driver, "//div[@class='no-result']"),
				"No products were found that matched your criteria.");
	}

	@Test
	public void TC_08_Advanced_Search_Correct_Manufacturer() {
		sendkeyToElement(driver, "//input[@class='search-text']", "Apple MacBook Pro");
		selectItemInDefaultDropdown(driver, "//select[@id='mid']", "Apple");

		waitForElementClickable(driver, "//button[@class='button-1 search-button']");
		clickToElement(driver, "//button[@class='button-1 search-button']");
		Assert.assertTrue(isElementDisplayed(driver, "//a[text()='Apple MacBook Pro 13-inch']"));

	}

	@AfterClass
	public void afterClass() {
	}

}
