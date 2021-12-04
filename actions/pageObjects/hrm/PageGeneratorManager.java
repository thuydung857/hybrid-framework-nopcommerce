package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager { // Dung để tối ưu việc khởi tạo page

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
	
	public static AddEmployeePageObject getAddEmployeePage(WebDriver driver) {
		return new AddEmployeePageObject(driver);
		
	}
	
	public static PersonalDetailsPageObject getPersonalDetailsPage(WebDriver driver) {
		return new PersonalDetailsPageObject(driver);
		
	}
	
	public static DashBoardPageObject getDashBoardPage(WebDriver driver) {
		return new DashBoardPageObject(driver);
		
	}
	
	public static EmployeeListPageObject getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPageObject(driver);

	}

}
