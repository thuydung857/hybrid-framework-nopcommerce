package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager { // Dung để tối ưu việc khởi tạo page

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);

	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);

	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);

	}

	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);

	}

	public static OrderPageObject getOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);

	}

	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);

	}

}
