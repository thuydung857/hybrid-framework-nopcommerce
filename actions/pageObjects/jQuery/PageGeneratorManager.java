package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager { // Dung để tối ưu việc khởi tạo page

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);

	}

	

}
