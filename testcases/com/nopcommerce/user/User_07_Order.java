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

public class User_07_Order extends BasePage {
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
	public void TC_01_Add_Product_To_Cart() {
		clickToElement(driver, "//a[text()='Build your own computer']");
		selectItemInDefaultDropdown(driver, "//select[@id='product_attribute_2']", "8GB [+$60.00]");
		checkToDefaultCheckboxRadio(driver, "//input[@id='product_attribute_3_7']");
		checkToDefaultCheckboxRadio(driver, "//input[@id='product_attribute_4_9']");
		checkToDefaultCheckboxRadio(driver, "//input[@id='product_attribute_5_11']");
		checkToDefaultCheckboxRadio(driver, "//input[@id='product_attribute_5_12']");
		clickToElement(driver, "//button[text()='Add to cart']");
		waitForElementInvisible(driver, "//div[@class='ajax-loading-block-window']");
		Assert.assertEquals(getElementText(driver, "//p[@class='content']"),
				"The product has been added to your shopping cart");
		clickToElement(driver, "//span[@class='close']");

		hoverToElement(driver, "//span[@class='cart-label']//following-sibling::span");

		// Assert.assertEquals(getElementText(driver, "//div[@class='count']"), "1
		// item(s)");
		// Assert.assertEquals(getElementText(driver, "//div[@class='totals']"),
		// "Sub-Total: $1,500.00");

	}

	@Test
	public void TC_02_Edit_Product_In_Cart() {
		hoverToElement(driver, "//span[@class='cart-label']//following-sibling::span");
		clickToElement(driver, "//button[text()='Go to cart']");
		waitForElementInvisible(driver, "//div[@class='ajax-loading-block-window']");
		waitForElementClickable(driver, "//div[@class='edit-item']//a");
		clickToElement(driver, "//div[@class='edit-item']//a");

		selectItemInDefaultDropdown(driver, "//select[@id='product_attribute_2']", "2 GB");
		checkToDefaultCheckboxRadio(driver, "//input[@id='product_attribute_3_6']");
		checkToDefaultCheckboxRadio(driver, "//input[@id='product_attribute_4_8']");
		uncheckToDefaultCheckbox(driver, "//input[@id='product_attribute_5_11']");
		uncheckToDefaultCheckbox(driver, "//input[@id='product_attribute_5_12']");
		sendkeyToElement(driver, "//input[@id='product_enteredQuantity_1']", "2");

		clickToElement(driver, "//button[text()='Update']");
		waitForElementInvisible(driver, "//div[@class='ajax-loading-block-window']");
		Assert.assertEquals(getElementText(driver, "//p[@class='content']"),
				"The product has been added to your shopping cart");
		clickToElement(driver, "//span[@class='close']");

		hoverToElement(driver, "//span[@class='cart-label']//following-sibling::span");

//		Assert.assertEquals(getElementText(driver, "//div[@class='count']"), "There are 2 item(s) in your cart.");
//		Assert.assertEquals(getElementText(driver, "//div[@class='totals']"), "Sub-Total: $2,770.00");

	}

	@Test
	public void TC_03_Remove_Product_From_Cart() {
		waitForElementClickable(driver, "//button[text()='Go to cart']");
		clickToElement(driver, "//button[text()='Go to cart']");
		waitForElementClickable(driver, "//button[@class='remove-btn']");
		clickToElement(driver, "//button[@class='remove-btn']");
		Assert.assertEquals(getElementText(driver, "//div[@class='no-data']").trim(), "Your Shopping Cart is empty!");

	}

	@Test
	public void TC_04_Update_Shopping_Cart() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[contains(text(),'Notebooks')]");

		clickToElement(driver, "//a[text()='HP Envy 6-1180ca 15.6-Inch Sleekbook']");
		clickToElement(driver, "//div[@class='add-to-cart-panel']//button[text()='Add to cart']");
		clickToElement(driver, "//a[text()='shopping cart']");
		sendkeyToElement(driver, "//input[@class='qty-input']", "5");
		clickToElement(driver, "//div[@class='common-buttons']/button[@name='updatecart']");
		Assert.assertEquals(getElementText(driver, "//td[@class='subtotal']//span"), "$7,300.00");

	}

	@Test
	public void TC_05_Payment_Cash() {
		checkToDefaultCheckboxRadio(driver, "//input[@id='termsofservice']");
		clickToElement(driver, "//button[@id='checkout']");
		clickToElement(driver, "//div[@id='billing-buttons-container']//button[text()='Continue']");
		clickToElement(driver, "//div[@id='shipping-method-buttons-container']//button[text()='Continue']");
		clickToElement(driver, "//div[@id='payment-method-buttons-container']//button[text()='Continue']");
		clickToElement(driver, "//div[@id='payment-info-buttons-container']//button[text()='Continue']");
		clickToElement(driver, "//button[text()='Confirm']");

//		Assert.assertEquals(getElementText(driver, "//div[@class='title']"),
//				"Your order has been successfully processed!");
		String orderNumber = getElementText(driver, "//div[@class='order-number']");
		System.out.println(orderNumber);

		waitForElementClickable(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[text()='Orders']");
//		Assert.assertEquals(getElementText(driver, "//div[@class='title']/strong"), orderNumber);

	}

	@Test
	public void TC_06_Payment_Credit_Card() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[contains(text(),'Computers')]");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[contains(text(),'Notebooks')]");

		clickToElement(driver, "//a[text()='Apple MacBook Pro 13-inch']");
		clickToElement(driver, "//div[@class='add-to-cart-panel']//button[text()='Add to cart']");
		clickToElement(driver, "//a[text()='shopping cart']");

		checkToDefaultCheckboxRadio(driver, "//input[@id='termsofservice']");
		clickToElement(driver, "//button[@id='checkout']");
		clickToElement(driver, "//div[@id='billing-buttons-container']//button[text()='Continue']");
		clickToElement(driver, "//div[@id='shipping-method-buttons-container']//button[text()='Continue']");

		checkToDefaultCheckboxRadio(driver, "//input[@id='paymentmethod_1']");
		clickToElement(driver, "//div[@id='payment-method-buttons-container']//button[text()='Continue']");
		sendkeyToElement(driver, "//input[@id='CardholderName']", "Dung Nguyen");
		sendkeyToElement(driver, "//input[@id='CardNumber']", "4716567729771498");
		selectItemInDefaultDropdown(driver, "//select[@id='ExpireMonth']", "06");
		selectItemInDefaultDropdown(driver, "//select[@id='ExpireYear']", "2025");
		sendkeyToElement(driver, "//input[@id='CardCode']", "469");

		clickToElement(driver, "//div[@id='payment-info-buttons-container']//button[text()='Continue']");
		sleepInSecond(30);
		waitForElementClickable(driver, "//button[text()='Confirm']");
		clickToElement(driver, "//button[text()='Confirm']");
//		Assert.assertEquals(getElementText(driver, "//div[@class='title']/strong"),
//				"Your order has been successfully processed!");
		String orderNumber = getElementText(driver, "//div[@class='order-number']");
		System.out.println(orderNumber);
		waitForElementClickable(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[text()='Orders']");
//		Assert.assertEquals(getElementText(driver, "//div[@class='title']/strong"), orderNumber);

	}

	@Test
	public void TC_07_Reorder() {
		clickToElement(driver, "(//button[@class='button-2 order-details-button'])[1]");
		clickToElement(driver, "//button[@class='button-1 re-order-button']");

		checkToDefaultCheckboxRadio(driver, "//input[@id='termsofservice']");
		clickToElement(driver, "//button[@id='checkout']");
		clickToElement(driver, "//div[@id='billing-buttons-container']//button[text()='Continue']");
		clickToElement(driver, "//div[@id='shipping-method-buttons-container']//button[text()='Continue']");
		clickToElement(driver, "//div[@id='payment-method-buttons-container']//button[text()='Continue']");
		clickToElement(driver, "//div[@id='payment-info-buttons-container']//button[text()='Continue']");
		sleepInSecond(30);
		clickToElement(driver, "//button[text()='Confirm']");

//		Assert.assertEquals(getElementText(driver, "//div[@class='title']/strong"),
//				"Your order has been successfully processed!");
		String orderNumber = getElementText(driver, "//div[@class='order-number']");
		System.out.println(orderNumber);

		waitForElementClickable(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[@class='ico-account']");
		clickToElement(driver, "//a[text()='Orders']");
//		Assert.assertEquals(getElementText(driver, "//div[@class='title']/strong"), orderNumber);

	}

	@AfterClass
	public void afterClass() {
	}

}
