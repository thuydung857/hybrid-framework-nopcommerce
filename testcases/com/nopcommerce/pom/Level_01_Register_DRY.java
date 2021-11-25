package com.nopcommerce.pom;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_DRY {
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
		emailAddress = "NopCom" + getRandomNumber() + "@mail.net";

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.nopcommerce.com/en/register?returnUrl=%2Fen%2Fdemo");
	}

	@Test
	public void TC_01_Empty_Data() {
		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("#FirstName-error")).getText(),
				"First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#LastName-error")).getText(), "Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmEmail-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#Username-error")).getText(), "Username is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error")).getText(), "Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(),
				"Password is required.");
	}

	@Test
	public void TC_02_Invalid_Email() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector("#Email")).sendKeys("kfc123");
		driver.findElement(By.cssSelector("#ConfirmEmail")).sendKeys("kfc123");

		driver.findElement(By.cssSelector("#register-button")).click();

	}

	@Test
	public void TC_03_Valid_Info() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Dung");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Nguyen");
		driver.findElement(By.cssSelector("#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#ConfirmEmail")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#Username")).sendKeys("dungnguyen" + getRandomNumber());
		driver.findElement(By.cssSelector("input#check-availability-button")).click();
		driver.findElement(By.cssSelector("#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123456");

		select = new Select(driver.findElement(By.cssSelector("select#Details_CompanyIndustryId")));
		select.selectByVisibleText("I am student");

		driver.findElement(By.cssSelector("#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector(".sub-title h2")).getText(),
				"Almost done! To complete your nopCommerce registration, we just need to verify your email address. You have just been sent an email to confirm your email address. Open the email, and click the link to confirm your address.");

	}

	@Test
	public void TC_04_Existing_Email() {
		action.moveToElement(driver.findElement(By.cssSelector("span.ico-user"))).perform();
		driver.findElement(By.cssSelector(".ico-register")).click();

		driver.findElement(By.cssSelector("#FirstName")).sendKeys("Dung");
		driver.findElement(By.cssSelector("#LastName")).sendKeys("Nguyen");
		driver.findElement(By.cssSelector("#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#ConfirmEmail")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("#Username")).sendKeys("dungnguyen" + getRandomNumber());
		driver.findElement(By.cssSelector("input#check-availability-button")).click();
		driver.findElement(By.cssSelector("#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123456");

		select = new Select(driver.findElement(By.cssSelector("select#Details_CompanyIndustryId")));
		select.selectByVisibleText("I am student");

		driver.findElement(By.cssSelector("#register-button")).click();
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[@class='message-error validation-summary-errors']//li[1]")).getText(),
				"The specified email already exists");
	}

	@Test
	public void TC_05_Password_Less_Than_6_Chars() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector("#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123");

		Assert.assertEquals(driver.findElement(By.cssSelector("#Password-error")).getText(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Password_Different_Confirm_Password() {
		driver.navigate().refresh();

		driver.findElement(By.cssSelector("#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("#Password")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("#ConfirmPassword-error")).getText(),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
