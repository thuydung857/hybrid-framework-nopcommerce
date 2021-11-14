package com.jquery.upload;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.PageGeneratorManager;
import pageObjects.jQuery.UploadPageObject;

public class Level_10_Upload extends BaseTest {

	private WebDriver driver;
	private UploadPageObject uploadPage;
	String projectPath = System.getProperty("user.dir");

	String Desert = "Desert.jpg";
	String Food = "Food.jpg";

	// Neu co folderName cu the thi truyen thang vao
	// String vieonPath = projectPath + "\\uploadFiles\\" + Vieonname;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		uploadPage = PageGeneratorManager.getUploadPage(driver);

	}

	@Test
	public void Upload_01_Single_File() {
		uploadPage.sleepInSecond(5);
		uploadPage.uploadSingleFile(Desert);
		Assert.assertTrue(uploadPage.isSingleDisplayed(Desert));
		uploadPage.clickToUploadFileButton();
	}

	@Test
	public void Upload_02_Multiple_File() {
		uploadPage.refreshPage(driver);
		uploadPage.uploadMultipleFile(Desert, Food);
		Assert.assertTrue(uploadPage.isMultipleDisplayed(Desert, Food));
		uploadPage.clickToUploadFileButton();
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
