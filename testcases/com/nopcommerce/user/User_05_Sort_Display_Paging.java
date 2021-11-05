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

public class User_05_Sort_Display_Paging extends BasePage {
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

	public void TC_01_Sort_A_To_Z() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Computers ']");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Notebooks ']");
		selectItemInDefaultDropdown(driver, "//select[@id='products-orderby']", "Name: A to Z");

	}

	public void TC_02_Sort_A_To_Z() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Computers ']");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Notebooks ']");
		selectItemInDefaultDropdown(driver, "//select[@id='products-orderby']", "Name: A to Z");

	}

	public void TC_03_Sort_A_To_Z() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Computers ']");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Notebooks ']");
		selectItemInDefaultDropdown(driver, "//select[@id='products-orderby']", "Name: A to Z");

	}

	public void TC_04_Sort_A_To_Z() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Computers ']");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Notebooks ']");
		selectItemInDefaultDropdown(driver, "//select[@id='products-orderby']", "Name: A to Z");

	}

	@Test
	public void TC_05_3_Items_Per_Page() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Computers ']");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Notebooks ']");
		selectItemInDefaultDropdown(driver, "//select[@id='products-orderby']", "Position");
		selectItemInDefaultDropdown(driver, "//select[@name='products-pagesize']", "3");
		waitForElementInvisible(driver, "//div[@class='ajax-products-busy']");
		Assert.assertEquals(getElementSize(driver, "//div[@class='item-grid']//div[@class='product-item']"), 3);
		Assert.assertTrue(isElementDisplayed(driver, "//li[@class='next-page']"));
		clickToElement(driver, "//li[@class='individual-page']");
		Assert.assertTrue(isElementDisplayed(driver, "//li[@class='previous-page']"));
	}

	@Test
	public void TC_06_6_Items_Per_Page() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Computers ']");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Notebooks ']");
		selectItemInDefaultDropdown(driver, "//select[@id='products-orderby']", "Position");
		selectItemInDefaultDropdown(driver, "//select[@name='products-pagesize']", "6");
		waitForElementInvisible(driver, "//div[@class='ajax-products-busy']");
		Assert.assertEquals(getElementSize(driver, "//div[@class='item-grid']//div[@class='product-item']"), 6);
	}

	@Test
	public void TC_07_9_Items_Per_Page() {
		hoverToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Computers ']");
		clickToElement(driver, "//ul[@class='top-menu notmobile']//a[text()='Notebooks ']");
		selectItemInDefaultDropdown(driver, "//select[@id='products-orderby']", "Position");
		selectItemInDefaultDropdown(driver, "//select[@name='products-pagesize']", "9");
		waitForElementInvisible(driver, "//div[@class='ajax-products-busy']");
		Assert.assertEquals(getElementSize(driver, "//div[@class='item-grid']//div[@class='product-item']"), 6);
	}

	@AfterClass
	public void afterClass() {
	}

}
