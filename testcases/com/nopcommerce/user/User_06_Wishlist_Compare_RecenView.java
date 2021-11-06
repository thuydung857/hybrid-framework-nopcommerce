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

public class User_06_Wishlist_Compare_RecenView extends BasePage {
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
	public void TC_01_Add_To_Wishlist() {
		clickToElement(driver, "//a[text()='Apple MacBook Pro 13-inch']");
		clickToElement(driver, "//div[@class='add-to-wishlist']");
		Assert.assertEquals(getElementText(driver, "//p[@class='content']"),
				"The product has been added to your wishlist");
		clickToElement(driver, "//a[text()='wishlist']");
		Assert.assertEquals(getElementText(driver, "//td[@class='product']"), "Apple MacBook Pro 13-inch");
		clickToElement(driver, "//a[@class='share-link']");
		Assert.assertEquals(getElementText(driver, "//td[@class='product']"), "Apple MacBook Pro 13-inch");

	}

	@Test
	public void TC_02_Add_To_Cart() {
		backToPage(driver);
		checkToDefaultCheckboxRadio(driver, "//input[@name='addtocart']");
		clickToElement(driver, "//button[@name='addtocartbutton']");
		waitForElementInvisible(driver, "//div[@class='ajax-loading-block-window']");
		Assert.assertEquals(getElementText(driver, "//div[@class='page-title']"), "Shopping cart");
		Assert.assertEquals(getElementText(driver, "//span[@class='wishlist-label']//following-sibling::span"), "(0)");
		Assert.assertEquals(getElementText(driver, "//span[@class='cart-label']//following-sibling::span"), "(2)");

	}

	@Test
	public void TC_03_Remove_Product_From_Wishlist() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Computers ']");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Notebooks ']");

		clickToElement(driver, "//a[text()='Asus N551JK-XO076H Laptop']");
		clickToElement(driver, "//div[@class='add-to-wishlist']");
		Assert.assertEquals(getElementText(driver, "//p[@class='content']"),
				"The product has been added to your wishlist");
		clickToElement(driver, "//a[text()='wishlist']");
		Assert.assertEquals(getElementText(driver, "//td[@class='product']"), "Asus N551JK-XO076H Laptop");
		checkToDefaultCheckboxRadio(driver, "//input[@name='addtocart']");
		clickToElement(driver, "//button[@class='remove-btn']");
		Assert.assertEquals(getElementText(driver, "//div[@class='no-data']").trim(), "The wishlist is empty!");

	}

	@Test
	public void TC_04_Add_Product_To_Compare() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[contains(text(),'Notebooks')]");

		clickToElement(driver,
				"//a[text()='HP Envy 6-1180ca 15.6-Inch Sleekbook']//parent::h2//following-sibling::div[@class='add-info']//button[@class='button-2 add-to-compare-list-button']");
		waitForElementInvisible(driver, "//div[@class='ajax-loading-block-window']");
		Assert.assertEquals(getElementText(driver, "//p[@class='content']"),
				"The product has been added to your product comparison");

		clickToElement(driver,
				"//a[text()='HP Spectre XT Pro UltraBook']//parent::h2//following-sibling::div[@class='add-info']//button[@class='button-2 add-to-compare-list-button']");
		waitForElementInvisible(driver, "//div[@class='ajax-loading-block-window']");
		Assert.assertEquals(getElementText(driver, "//p[@class='content']"),
				"The product has been added to your product comparison");

		clickToElement(driver, "//a[text()='product comparison']");

		Assert.assertEquals(getElementText(driver,
				"//label[text()='Name']//parent::td//following-sibling::td//a[text()='HP Spectre XT Pro UltraBook']"),
				"HP Spectre XT Pro UltraBook");
		Assert.assertEquals(getElementText(driver,
				"//label[text()='Price']//parent::td//following-sibling::td[text()='$1,350.00']"), "$1,350.00");
		Assert.assertEquals(getElementText(driver,
				"//label[text()='Name']//parent::td//following-sibling::td//a[text()='HP Envy 6-1180ca 15.6-Inch Sleekbook']"),
				"HP Envy 6-1180ca 15.6-Inch Sleekbook");
		Assert.assertEquals(getElementText(driver,
				"//label[text()='Price']//parent::td//following-sibling::td[text()='$1,460.00']"), "$1,460.00");

		clickToElement(driver, "//a[@class='clear-list']");
		Assert.assertEquals(getElementSize(driver, "//table[@class='compare-products-table']//button"), 0);
		Assert.assertEquals(getElementText(driver, "//div[@class='no-data']"), "You have no items to compare.");

	}

	@Test
	public void TC_05_Recently_Viewed_Products() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Computers ']");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Notebooks ']");

		clickToElement(driver, "//h2[@class='product-title']//a[text()='Apple MacBook Pro 13-inch']");
		clickToElement(driver, "//h2[@class='product-title']//a[text()='Asus N551JK-XO076H Laptop']");
		clickToElement(driver, "//h2[@class='product-title']//a[text()='Samsung Series 9 NP900X4C Premium Ultrabook']");
		clickToElement(driver, "//h2[@class='product-title']//a[text()='HP Spectre XT Pro UltraBook']");
		clickToElement(driver, "//h2[@class='product-title']//a[text()='HP Envy 6-1180ca 15.6-Inch Sleekbook']");

		clickToElement(driver, "//a[text()='Recently viewed products']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[text()='Samsung Series 9 NP900X4C Premium Ultrabook']"));
		Assert.assertTrue(isElementDisplayed(driver, "//a[text()='HP Spectre XT Pro UltraBook']"));
		Assert.assertTrue(isElementDisplayed(driver, "//a[text()='HP Envy 6-1180ca 15.6-Inch Sleekbook']"));

	}

	@AfterClass
	public void afterClass() {
	}

}
