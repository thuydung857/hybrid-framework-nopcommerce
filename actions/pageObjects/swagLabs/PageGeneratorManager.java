package pageObjects.swagLabs;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager { // Dung để tối ưu việc khởi tạo page

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
	

}
