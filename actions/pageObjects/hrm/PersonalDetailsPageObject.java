package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.BasePageUI_HRM;

public class PersonalDetailsPageObject extends BasePage {
	private WebDriver driver;

	public PersonalDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openAddEmployeePage(String parentMenu, String subMenu) {
		hoverToParentMenu(driver, parentMenu);
		hoverToSubMenu(driver, subMenu);
		clickToElement(driver, subMenu);
	}

	public void openEmployeeListPage(String...params) {
		waitForElementClickable(driver, BasePageUI_HRM.LINK_BY_TEXT, params);
		sleepInSecond(2);
		clickToElement(driver, BasePageUI_HRM.LINK_BY_TEXT, params);
		sleepInSecond(2);
	}


}