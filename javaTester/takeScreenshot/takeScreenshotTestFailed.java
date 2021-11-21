package takeScreenshot;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.RegisterPageObject;

@Listeners(TestListener.class)
public class takeScreenshotTestFailed extends BaseTest {

	private WebDriver driver;
	Select select;
	Actions action;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	String emailAddress, firstName, lastName, password, company;
	String projectPath = System.getProperty("user.dir");
	static String EMAIL_ADDRESS = "NopCom" + getRandomNumber() + "@mail.net";
	static String PASSWORD = "123456";

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		homePage = PageGeneratorManager.getHomePage(driver);
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		firstName = "Dung";
		lastName = "Nguyen";
		password = "123456";
		company = "Automation";

	}

	@Test
	public void Login_01_Valid_Info() {
		homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(takeScreenshotTestFailed.EMAIL_ADDRESS);

		registerPage.inputToCompanyTextBox(company);

		registerPage.inputToPasswordTextBox(password);

		registerPage.inputToConfirmPasswordTextBox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessfulMessage(), "Your registration completed");


	}

	@Test
	public void Login_02_Valid_Email_Correct_Password() {
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());


	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
	
	public WebDriver getWebDriver() {
		return this.driver;
		
	}

	

}
