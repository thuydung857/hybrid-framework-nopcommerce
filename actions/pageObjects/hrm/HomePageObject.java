package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openAddEmployeePage(String parentMenu, String subMenu) {
		hoverToParentMenu(driver, parentMenu);
		hoverToSubMenu(driver, subMenu);
		clickToLinkByText(driver, subMenu);
	}

	

	

}