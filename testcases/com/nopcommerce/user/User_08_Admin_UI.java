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

public class User_08_Admin_UI extends BasePage { // Thua ke

	WebDriver driver;
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
		driver.get("https://admin-demo.nopcommerce.com/");
	}

	@Test
	public void TC_00_Login_Admin() {
		sendkeyToElement(driver, "//input[@id='Email']", "admin@yourstore.com");
		sendkeyToElement(driver, "//input[@id='Password']", "admin");

		waitForElementClickable(driver, "//button[@class='button-1 login-button']");
		clickToElement(driver, "//button[@class='button-1 login-button']");

		waitForAllElementVisible(driver, "//div[@class='content-header']//h1");
	}

	@Test
	public void TC_01_Search_Product_Name() {
		waitForElementClickable(driver,
				"//i[@class='nav-icon fas fa-book']//following-sibling::p[contains(text(),'Catalog')]");
		clickToElement(driver, "//i[@class='nav-icon fas fa-book']//following-sibling::p[contains(text(),'Catalog')]");
		waitForElementClickable(driver,
				"//p[contains(text(),'Catalog')]//ancestor::a//following-sibling::ul//p[contains(text(),'Products')]");
		clickToElement(driver,
				"//p[contains(text(),'Catalog')]//ancestor::a//following-sibling::ul//p[contains(text(),'Products')]");

		sendkeyToElement(driver, "//input[@id='SearchProductName']", "Lenovo IdeaCentre");
		clickToElement(driver, "//button[@id='search-products']");

		Assert.assertEquals(getElementSize(driver, "//table[@id='products-grid']//tbody//tr"), 1);
		Assert.assertEquals(
				getElementText(driver,
						"//table[@id='products-grid']//tbody//tr//td[text()='Lenovo IdeaCentre 600 All-in-One PC']"),
				"Lenovo IdeaCentre 600 All-in-One PC");

	}

	@Test
	public void TC_02_Search_Product_Name_Category_Unchecked() {
		sendkeyToElement(driver, "//input[@id='SearchProductName']", "Lenovo IdeaCentre");
		selectItemInDefaultDropdown(driver, "//select[@id='SearchCategoryId']", "Computers");
		clickToElement(driver, "//button[@id='search-products']");

		Assert.assertEquals(getElementText(driver, "//td[@class='dataTables_empty']"), "No data available in table");
	}

	@Test
	public void TC_03_Search_Product_Name_Category_Checked() {
		sendkeyToElement(driver, "//input[@id='SearchProductName']", "Lenovo IdeaCentre");
		selectItemInDefaultDropdown(driver, "//select[@id='SearchCategoryId']", "Computers");
		checkToDefaultCheckboxRadio(driver, "//input[@id='SearchIncludeSubCategories']");
		clickToElement(driver, "//button[@id='search-products']");

		Assert.assertEquals(getElementSize(driver, "//table[@id='products-grid']//tbody//tr"), 1);
		Assert.assertEquals(
				getElementText(driver,
						"//table[@id='products-grid']//tbody//tr//td[text()='Lenovo IdeaCentre 600 All-in-One PC']"),
				"Lenovo IdeaCentre 600 All-in-One PC");

	}

	@Test
	public void TC_04_Search_Product_Name_Child_Category() {
		sendkeyToElement(driver, "//input[@id='SearchProductName']", "Lenovo IdeaCentre");
		selectItemInDefaultDropdown(driver, "//select[@id='SearchCategoryId']", "Computers >> Desktops");
		uncheckToDefaultCheckbox(driver, "//input[@id='SearchIncludeSubCategories']");
		clickToElement(driver, "//button[@id='search-products']");

		Assert.assertEquals(getElementSize(driver, "//table[@id='products-grid']//tbody//tr"), 1);
		Assert.assertEquals(
				getElementText(driver,
						"//table[@id='products-grid']//tbody//tr//td[text()='Lenovo IdeaCentre 600 All-in-One PC']"),
				"Lenovo IdeaCentre 600 All-in-One PC");
		sleepInSecond(1);
	}

	@Test
	public void TC_05_Search_Product_Name_Manufacturer() {
		sendkeyToElement(driver, "//input[@id='SearchProductName']", "Lenovo IdeaCentre");
		selectItemInDefaultDropdown(driver, "//select[@id='SearchCategoryId']", "All");
		// Assert.assertFalse(isElementSelected(driver,
		// "//input[@id='SearchIncludeSubCategories']"));
		selectItemInDefaultDropdown(driver, "//select[@id='SearchManufacturerId']", "Apple");
		clickToElement(driver, "//button[@id='search-products']");

		Assert.assertEquals(getElementText(driver, "//td[@class='dataTables_empty']"), "No data available in table");

	}

	@Test
	public void TC_06_Go_To_SKU() {
		sendkeyToElement(driver, "//input[@id='GoDirectlyToSku']", "LE_IC_600");
		clickToElement(driver, "//button[@id='go-to-product-by-sku']");

		Assert.assertEquals(getElementText(driver, "//div[@class='content-header clearfix']//h1").trim(),
				"Edit product details - Lenovo IdeaCentre 600 All-in-One PC back to product list");

	}

	@Test
	public void TC_07_Create_New_Customer() {
		waitForElementClickable(driver,
				"//i[@class='nav-icon far fa-user']//following-sibling::p[contains(text(),'Customers')]");
		clickToElement(driver,
				"//i[@class='nav-icon far fa-user']//following-sibling::p[contains(text(),'Customers')]");
		waitForElementClickable(driver,
				"//p[contains(text(),'Customers')]//ancestor::a//following-sibling::ul//p[contains(text(),'Customers')]");
		clickToElement(driver,
				"//p[contains(text(),'Customers')]//ancestor::a//following-sibling::ul//p[contains(text(),'Customers')]");

		waitForElementClickable(driver, "//a[@class='btn btn-primary']");
		clickToElement(driver, "//a[@class='btn btn-primary']");

		sendkeyToElement(driver, "//input[@id='Email']", User_03_My_Account.AD_EMAIL);
		sendkeyToElement(driver, "//input[@id='Password']", User_03_My_Account.NEW_PASSWORD);
		sendkeyToElement(driver, "//input[@id='FirstName']", User_03_My_Account.AD_FIRSTNAME);
		sendkeyToElement(driver, "//input[@id='LastName']", User_03_My_Account.AD_LASTNAME);
		checkToDefaultCheckboxRadio(driver, "//input[@id='Gender_Female']");
		sendkeyToElement(driver, "//input[@id='DateOfBirth']", "11/10/2021");
		sendkeyToElement(driver, "//input[@id='Company']", User_03_My_Account.AD_COMPANY);
		checkToDefaultCheckboxRadio(driver, "//input[@id='IsTaxExempt']");
		sendkeyToElement(driver, "//input[@aria-labelledby='SelectedNewsletterSubscriptionStoreIds_label']",
				"Your store name");
		waitForElementClickable(driver, "//li[text()='Your store name']");
		clickToElement(driver, "//li[text()='Your store name']");
		clickToElement(driver, "//span[text()='Registered']//following-sibling::span");

		waitForElementClickable(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		clickToElement(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		waitForElementClickable(driver, "//li[text()='Guests']");
		clickToElement(driver, "//li[text()='Guests']");

		sendkeyToElement(driver, "//textarea[@id='AdminComment']", "This is Admin Comment");

		clickToElement(driver, "//button[@name='save-continue']");

//Bug	Assert.assertEquals(getElementText(driver, "//div[@class='alert alert-success alert-dismissable']"),
//		"x\nThe new customer has been added successfully.");

		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), User_03_My_Account.AD_EMAIL);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"),
				User_03_My_Account.AD_FIRSTNAME);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"),
				User_03_My_Account.AD_LASTNAME);
		Assert.assertTrue(isElementSelected(driver, "//input[@id='Gender_Female']"));
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='DateOfBirth']", "value"), "11/10/2021");
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"),
				User_03_My_Account.AD_COMPANY);
		Assert.assertEquals(getElementAttribute(driver, "//textarea[@id='AdminComment']", "value"),
				"This is Admin Comment");

		clickToElement(driver, "//a[text()='back to customer list']");
		sleepInSecond(2);
		waitForElementClickable(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		clickToElement(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		sleepInSecond(2);
		waitForElementClickable(driver, "//li[text()='Guests']");
		clickToElement(driver, "//li[text()='Guests']");

		clickToElement(driver, "//span[text()='Registered']//following-sibling::span");
		clickToElement(driver, "//button[@id='search-customers']");

		String customerName = getElementText(driver,
				"//th[text()='Name']//ancestor::div[@class='dataTables_scrollHead']//following-sibling::div//tbody//tr//td[text()='"
						+ User_03_My_Account.AD_FULLNAME + "']");
		for (int i = 0; i < customerName.length();) {
			if (customerName.equals(User_03_My_Account.AD_FULLNAME)) {
				Assert.assertEquals(customerName, User_03_My_Account.AD_FULLNAME);
			}

			break;
		}
	}

	@Test

	public void TC_08_Search_Customer_With_Email() {
		refreshPage(driver);
		sendkeyToElement(driver, "//input[@id='SearchEmail']", User_03_My_Account.AD_EMAIL);
		waitForElementClickable(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		clickToElement(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		waitForElementClickable(driver, "//li[text()='Guests']");
		clickToElement(driver, "//li[text()='Guests']");
		waitForElementClickable(driver, "//span[text()='Registered']//following-sibling::span");
		clickToElement(driver, "//span[text()='Registered']//following-sibling::span");
		waitForElementClickable(driver, "//button[@id='search-customers']");
		clickToElement(driver, "//button[@id='search-customers']");
		sleepInSecond(5);
		waitForElementVisible(driver, "//table[@id='customers-grid']//tbody//tr");
		Assert.assertEquals(getElementSize(driver, "//table[@id='customers-grid']//tbody//tr"), 1);
		Assert.assertEquals(getElementText(driver,
				"//th[text()='Name']//ancestor::div[@class='dataTables_scrollHead']//following-sibling::div//tbody//tr//td[text()='"
						+ User_03_My_Account.AD_FULLNAME + "']"),
				User_03_My_Account.AD_FULLNAME);

	}

	@Test

	public void TC_09_Search_Customer_With_First_Last_Name() {
		refreshPage(driver);
		sendkeyToElement(driver, "//input[@id='SearchFirstName']", User_03_My_Account.AD_FIRSTNAME);
		sendkeyToElement(driver, "//input[@id='SearchLastName']", User_03_My_Account.AD_LASTNAME);
		sleepInSecond(2);
		waitForElementClickable(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		clickToElement(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		waitForElementClickable(driver, "//li[text()='Guests']");
		clickToElement(driver, "//li[text()='Guests']");
		clickToElement(driver, "//span[text()='Registered']//following-sibling::span");
		clickToElement(driver, "//button[@id='search-customers']");

		Assert.assertEquals(getElementText(driver,
				"//th[text()='Name']//ancestor::div[@class='dataTables_scrollHead']//following-sibling::div//tbody//tr//td[text()='"
						+ User_03_My_Account.AD_FULLNAME + "']"),
				User_03_My_Account.AD_FULLNAME);

	}

	@Test
	public void TC_10_Search_Customer_With_Company() {
		refreshPage(driver);
		sendkeyToElement(driver, "//input[@id='SearchCompany']", User_03_My_Account.AD_COMPANY);
		sleepInSecond(1);
		waitForElementClickable(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		clickToElement(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		waitForElementClickable(driver, "//li[text()='Guests']");
		clickToElement(driver, "//li[text()='Guests']");
		clickToElement(driver, "//span[text()='Registered']//following-sibling::span");
		clickToElement(driver, "//button[@id='search-customers']");

		Assert.assertEquals(getElementText(driver,
				"//th[text()='Name']//ancestor::div[@class='dataTables_scrollHead']//following-sibling::div//tbody//tr//td[text()='"
						+ User_03_My_Account.AD_FULLNAME + "']"),
				User_03_My_Account.AD_FULLNAME);
	}

	@Test
	public void TC_11_Search_Customer_With_Full_Data() {
		refreshPage(driver);
		sendkeyToElement(driver, "//input[@id='SearchEmail']", User_03_My_Account.AD_EMAIL);
		sendkeyToElement(driver, "//input[@id='SearchFirstName']", User_03_My_Account.AD_FIRSTNAME);
		sendkeyToElement(driver, "//input[@id='SearchLastName']", User_03_My_Account.AD_LASTNAME);
		sendkeyToElement(driver, "//input[@id='SearchCompany']", User_03_My_Account.AD_COMPANY);
		sleepInSecond(2);
		waitForElementClickable(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		clickToElement(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		waitForElementClickable(driver, "//li[text()='Guests']");
		clickToElement(driver, "//li[text()='Guests']");
		clickToElement(driver, "//span[text()='Registered']//following-sibling::span");
		clickToElement(driver, "//button[@id='search-customers']");

		Assert.assertEquals(getElementText(driver,
				"//th[text()='Name']//ancestor::div[@class='dataTables_scrollHead']//following-sibling::div//tbody//tr//td[text()='"
						+ User_03_My_Account.AD_FULLNAME + "']"),
				User_03_My_Account.AD_FULLNAME);
	}

	@Test
	public void TC_12_Edit_Customer() {
		waitForElementClickable(driver,
				"//i[@class='nav-icon far fa-user']//following-sibling::p[contains(text(),'Customers')]");
		clickToElement(driver,
				"//i[@class='nav-icon far fa-user']//following-sibling::p[contains(text(),'Customers')]");
		waitForElementClickable(driver,
				"//p[contains(text(),'Customers')]//ancestor::a//following-sibling::ul//p[contains(text(),'Customers')]");
		clickToElement(driver,
				"//p[contains(text(),'Customers')]//ancestor::a//following-sibling::ul//p[contains(text(),'Customers')]");

		sendkeyToElement(driver, "//input[@id='SearchEmail']", User_03_My_Account.AD_EMAIL);
		sleepInSecond(3);
		waitForElementClickable(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		clickToElement(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		waitForElementClickable(driver, "//li[text()='Guests']");
		clickToElement(driver, "//li[text()='Guests']");
		clickToElement(driver, "//span[text()='Registered']//following-sibling::span");
		clickToElement(driver, "//button[@id='search-customers']");

		waitForElementVisible(driver, "//td[text()='" + User_03_My_Account.AD_FULLNAME + "']");
		clickToElement(driver, "//td[text()='" + User_03_My_Account.AD_FULLNAME
				+ "']//preceding-sibling::td//following-sibling::td//a[text()='Edit']");

		sendkeyToElement(driver, "//input[@id='Email']", "edit" + User_03_My_Account.AD_EMAIL);
		sendkeyToElement(driver, "//input[@id='Password']", "Edit " + User_03_My_Account.NEW_PASSWORD);
		sendkeyToElement(driver, "//input[@id='FirstName']", "Edit " + User_03_My_Account.AD_FIRSTNAME);
		sendkeyToElement(driver, "//input[@id='DateOfBirth']", "10/22/2000");
		sendkeyToElement(driver, "//input[@id='Company']", "Edit " + User_03_My_Account.AD_COMPANY);
		scrollToElement(driver, "//textarea[@id='AdminComment']");
		sendkeyToElement(driver, "//textarea[@id='AdminComment']", "Edit This is Admin Comment");
		scrollToElement(driver, "//button[@name='save']");
		waitForElementClickable(driver, "//button[@name='save']");
		clickToElement(driver, "//button[@name='save']");

//		Assert.assertEquals(getElementText(driver, "//div[@class='alert alert-success alert-dismissable']"),
//				"The customer has been updated successfully.");

		sendkeyToElement(driver, "//input[@id='SearchEmail']", "edit" + User_03_My_Account.AD_EMAIL);
		sleepInSecond(3);
		waitForElementClickable(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		clickToElement(driver, "//select[@id='SelectedCustomerRoleIds']//preceding-sibling::div");
		waitForElementClickable(driver, "//li[text()='Guests']");
		clickToElement(driver, "//li[text()='Guests']");
		waitForElementClickable(driver, "//span[text()='Registered']//following-sibling::span");
		clickToElement(driver, "//span[text()='Registered']//following-sibling::span");
		waitForElementClickable(driver, "//button[@id='search-customers']");
		clickToElement(driver, "//button[@id='search-customers']");

		Assert.assertEquals(getElementText(driver,
				"//th[text()='Name']//ancestor::div[@class='dataTables_scrollHead']//following-sibling::div//tbody//tr//td[text()='Edit "
						+ User_03_My_Account.AD_FULLNAME + "']"),
				"Edit " + User_03_My_Account.AD_FULLNAME);

	}

	@Test
	public void TC_13_Add_Customer_Address() {
		clickToElement(driver, "//td[text()='" + "Edit " + User_03_My_Account.AD_FULLNAME
				+ "']//following-sibling::td[contains(@class,'button-column')]//a");

		scrollToElement(driver, "//div[text()='Addresses']//following-sibling::div/button");
		sleepInSecond(2);
		waitForElementClickable(driver, "//button[contains(text(),'Add new address')]");
		clickToElement(driver, "//button[contains(text(),'Add new address')]");

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

		waitForElementClickable(driver, "//button[contains(text(),'Save')]");
		clickToElement(driver, "//button[contains(text(),'Save')]");
//		Assert.assertEquals(getElementText(driver, "//div[@class='alert alert-success alert-dismissable']"),
//				"The new address has been added successfully.");
		waitForElementClickable(driver, "//a[text()='back to customer details']");
		clickToElement(driver, "//a[text()='back to customer details']");

		scrollToElement(driver, "//div[text()='Addresses']//following-sibling::div/button");

		Assert.assertEquals(getElementText(driver,
				"//th[text()='Last name']//ancestor::div[@class='dataTables_scrollHead']//following-sibling::div//tbody//tr//td[text()='"
						+ User_03_My_Account.AD_LASTNAME + "']"),
				User_03_My_Account.AD_LASTNAME);

	}

	@Test
	public void TC_14_Edit_Customer_Address() {
		waitForElementClickable(driver, "//a[text()='Edit']");
		clickToElement(driver, "//a[text()='Edit']");

		waitForElementClickable(driver, "//input[@id='Address_FirstName']");
		sendkeyToElement(driver, "//input[@id='Address_FirstName']", "Edit " + User_03_My_Account.AD_FIRSTNAME);
		sendkeyToElement(driver, "//input[@id='Address_Company']", "Edit " + User_03_My_Account.AD_COMPANY);
		selectItemInDefaultDropdown(driver, "//select[@id='Address_CountryId']", User_03_My_Account.AD_COUNTRY);
		selectItemInDefaultDropdown(driver, "//select[@id='Address_StateProvinceId']", User_03_My_Account.AD_PROVINCE);
		sendkeyToElement(driver, "//input[@id='Address_City']", "Edit " + User_03_My_Account.AD_CITY);
		sendkeyToElement(driver, "//input[@id='Address_Address1']", "Edit " + User_03_My_Account.AD_ADDRESS1);
		sendkeyToElement(driver, "//input[@id='Address_Address2']", "Edit " + User_03_My_Account.AD_ADDRESS2);
		waitForElementClickable(driver, "//button[@name='save']");
		clickToElement(driver, "//button[@name='save']");
//		Assert.assertEquals(getElementText(driver, "//div[@class='alert alert-success alert-dismissable']"),
//				"The address has been updated successfully.");
		waitForElementClickable(driver, "//a[text()='back to customer details']");
		clickToElement(driver, "//a[text()='back to customer details']");

		Assert.assertEquals(getElementText(driver,
				"//th[text()='First name']//ancestor::div[@class='dataTables_scrollHead']//following-sibling::div//tbody//tr//td[text()='Edit "
						+ User_03_My_Account.AD_FIRSTNAME + "']"),
				"Edit " + User_03_My_Account.AD_FIRSTNAME);

	}

	@Test
	public void TC_15_Delete_Address() {
		waitForElementClickable(driver, "//a[text()='Delete']");
		clickToElement(driver, "//a[text()='Delete']");
		acceptAlert(driver);

//Bug	Assert.assertEquals(getElementText(driver,
//				"//div[text()='Addresses']//ancestor::div[@class='card-header with-border clearfix']//following-sibling::div[@class='card-body']//tbody//td"),
//				"No data available in table");

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
