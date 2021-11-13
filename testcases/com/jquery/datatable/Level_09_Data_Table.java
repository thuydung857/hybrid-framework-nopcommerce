package com.jquery.datatable;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject;
import pageObjects.jQuery.PageGeneratorManager;

public class Level_09_Data_Table extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		// driver.get("https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		driver.get("https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	public void Table_01_Paging() {
		homePage.openPageByPageNumber("15");
		Assert.assertTrue(homePage.isPageActived("15"));

		homePage.openPageByPageNumber("6");
		Assert.assertTrue(homePage.isPageActived("6"));

		homePage.openPageByPageNumber("21");
		Assert.assertTrue(homePage.isPageActived("21"));

	}

	public void Table_02_Input_To_Textbox_By_Column_Name() {
		homePage.inputToTextboxByColumnName("Aruba", "Country");
		homePage.refreshPage(driver);

		homePage.inputToTextboxByColumnName("571000", "Females");
		homePage.refreshPage(driver);

		homePage.inputToTextboxByColumnName("279000", "Total");
		homePage.refreshPage(driver);

	}

	public void Table_03_Click_To_Icon_Action_By_Textbox_Name() {
		homePage.clickToIconActionByTextboxName("Angola", "remove");
		homePage.refreshPage(driver);

		homePage.clickToIconActionByTextboxName("Armenia", "remove");
		homePage.refreshPage(driver);

		homePage.clickToIconActionByTextboxName("Antigua and Barbuda", "edit");
		homePage.refreshPage(driver);

	}

	public void Table_04_Verify_Row_Value() {
		homePage.inputToTextboxByColumnName("Arab Rep of Egypt", "Country");
		Assert.assertTrue(homePage.isRowValueDisplayed("764956", "Arab Rep of Egypt", "802948", "1567904"));
		homePage.refreshPage(driver);

	}

	@Test
	public void Table_05_Input_To_Textbox_By_Row_Index() {
		homePage.inputToTextboxByRowIndex("Contact Person", "Dung Nguyen", "3");

		homePage.inputToTextboxByRowIndex("Company", "Automation", "2");

	}

	@Test
	public void Table_06_Click_Button_At_Row() {
		homePage.clickToActionButtonAtRowByRowIndex("3", "Insert Row Above");

		homePage.clickToActionButtonAtRowByRowIndex("1", "Move Down");

		homePage.clickToActionButtonAtRowByRowIndex("2", "Remove Current Row");

		homePage.clickToActionButtonAtRowByRowIndex("1", "Move Down");

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
