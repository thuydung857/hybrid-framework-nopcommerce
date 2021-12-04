package com.hrm.employee;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.hrm.AddEmployeePageObject;
import pageObjects.hrm.DashBoardPageObject;
import pageObjects.hrm.EmployeeListPageObject;
import pageObjects.hrm.HomePageObject;
import pageObjects.hrm.LoginPageObject;
import pageObjects.hrm.PageGeneratorManager;
import pageObjects.hrm.PersonalDetailsPageObject;

public class Level_16_Live_Coding extends BaseTest {

	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private AddEmployeePageObject addEmployeePage;
	private PersonalDetailsPageObject personalDetailsPage;
	private DashBoardPageObject dashboardPage;
	private EmployeeListPageObject employeeListPage;
	String emailAddress, password, firstName, lastName, username;
	String projectPath = System.getProperty("user.dir");
	String Avatar = "Avatar.png";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowsers(browserName);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		loginPage = PageGeneratorManager.getLoginPage(driver);

		emailAddress = "Admin";
		password = "admin123";
		firstName = "Sue";
		lastName = "Swift" + getRandomNumber();
		username = "sueswift" + getRandomNumber();

		log.info("Precondition - Step 1: Input 'Admin' to email textbox");
		loginPage.inputToTextboxByID(driver, emailAddress, "txtUsername");

		log.info("Precondition - Step 2: Input 'admin123' to password textbox");
		loginPage.inputToTextboxByID(driver, password, "txtPassword");

		log.info("Precondition - Step 3: Click to Login button");
		loginPage.clickToButtonByValue(driver, "LOGIN");

	}

	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Employee_01_Add_New - Step 1: Open Add Employee page");
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openAddEmployeePage("PIM", "Add Employee");

		log.info("Employee_01_Add_New - Step 2: Input to first name fields");
		addEmployeePage = PageGeneratorManager.getAddEmployeePage(driver);
		addEmployeePage.inputToTextboxByID(driver, firstName, "firstName");

		log.info("Employee_01_Add_New - Step 2: Input to last name fields");
		addEmployeePage.inputToTextboxByID(driver, lastName, "lastName");

		log.info("Employee_01_Add_New - Step 3: Check to Create Login Details");
		addEmployeePage.checkToCreateLoginDeatilsCheckbox();

		log.info("Employee_01_Add_New - Step 4: Input to user name fields");
		addEmployeePage.inputToTextBoxByID(driver, username, "user_name");

		log.info("Employee_01_Add_New - Step 5: Input to password fields");
		addEmployeePage.inputToTextBoxByID(driver, username, "user_password");

		log.info("Employee_01_Add_New - Step 6: Input to confirm password fields");
		addEmployeePage.inputToTextBoxByID(driver, username, "re_password");

		log.info("Employee_01_Add_New - Step 7: Select Enabled in dropdown");
		addEmployeePage.selectStatusInDropdown("Enabled");

		log.info("Employee_01_Add_New - Step 8: Verify register successful message displayed");
		addEmployeePage.clickToButtonByValue(driver, "Save");

	}

	@Test
	public void Employee_02_Search_Employee() {
		log.info("Employee_02_Search_Employee - Step 1: Open Employee List page");
		personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);
		personalDetailsPage.openEmployeeListPage("Employee List");

		log.info("Employee_02_Search_Employee - Step 2: Open Employee List page");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
		employeeListPage.inputToTextboxByID(driver, firstName, "empsearch_employee_name_empName");

		log.info("Employee_02_Search_Employee - Step 3: Click to Search button");
		employeeListPage.clickToButtonByValue(driver, "Search");
		employeeListPage.sleepInSecond(3);

		log.info("Employee_02_Search_Employee - Step 4: Verify new employee displayed");
		verifyEquals(employeeListPage.getValueDisplayedAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"),
				lastName);
		verifyEquals(employeeListPage.getValueDisplayedAtColumnNameAndRowIndex(driver, "resultTable",
				"First (& Middle) Name", "1"), firstName);
	}

	@Test
	public void Employee_03_Login_New_Employee_Upload_Avatar() {
		log.info("Employee_03_Login_New_Employee_Upload_Avatar - Step 1: Logout");
		employeeListPage.logoutToSystem(driver, "Welcome", "Logout");

		log.info("Employee_03_Login_New_Employee_Upload_Avatar - Step 2: Login by new employee");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		log.info("Employee_03_Login_New_Employee_Upload_Avatar - Step 3: Input 'sueswift' to email textbox");
		loginPage.inputToTextboxByID(driver, username, "txtUsername");
		log.info("Employee_03_Login_New_Employee_Upload_Avatar - Step 4: Input 'sueswift' to password textbox");
		loginPage.inputToTextboxByID(driver, username, "txtPassword");
		log.info("Employee_03_Login_New_Employee_Upload_Avatar - Step 5: Click to Login button");
		loginPage.clickToButtonByValue(driver, "LOGIN");

		log.info("Employee_03_Login_New_Employee_Upload_Avatar - Step 6: Click to My Info in Menu Header");
		dashboardPage = PageGeneratorManager.getDashBoardPage(driver);
		dashboardPage.clickToLinkByText(driver, "My Info");
		log.info("Employee_03_Login_New_Employee_Upload_Avatar - Step 7: Click to Image Profile");
		dashboardPage.clickToProfileImage();
		log.info("Employee_03_Login_New_Employee_Upload_Avatar - Step 8: Upload Avatar");
		dashboardPage.uploadAvatar(Avatar);
		log.info("Employee_03_Login_New_Employee_Upload_Avatar - Step 9: Upload Avatar");
		dashboardPage.clickToButtonByValue(driver, "Upload");
	}

	public void Employee_04_Personal_Details() {
		log.info("Employee_04_Personal_Details - Step 1: Click To Personal Details link");
		dashboardPage.clickToLinkByText(driver, "Personal Details");
		personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);

	}

	public void Employee_05_Contact_Details() {

	}

	public void Employee_06_Emergency_Contacts() {

	}

	public void Employee_07_Assigned_Dependents() {

	}

	public void Employee_08_Login_With_HR_Edit_Job() {
		//login with HR - Edit Job
		//Login with Employee(View Job) - Verify readonly fields

	}

	public void Employee_09_Login_With_HR_Edit_Salary() {
		// Login HR - Edit Salary
		// Login with Employee (View Salary) - Verify readonly fields
	}

	public void Employee_10_Tax_Exemptions() {

	}

	public void Employee_11_Qualifications() {

	}

	@Parameters("browser")
	@AfterClass(alwaysRun = true)
	// public void afterClass() {
	// closeBrowserAndDriver();

	public static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);

	}
}
