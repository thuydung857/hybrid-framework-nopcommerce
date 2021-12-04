package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.AddEmployeePageUI_HRM;

public class AddEmployeePageObject extends BasePage {
	private WebDriver driver;

	public AddEmployeePageObject(WebDriver driver) {
		this.driver = driver;
	}

		public void checkToCreateLoginDeatilsCheckbox() {
		waitForElementClickable(driver, AddEmployeePageUI_HRM.CREATE_LOGIN_DETAILS_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, AddEmployeePageUI_HRM.CREATE_LOGIN_DETAILS_CHECKBOX);
	}

	public void selectStatusInDropdown(String itemText) {
		waitForElementClickable(driver, AddEmployeePageUI_HRM.STATUS_DROPDOWN);
		selectItemInDefaultDropdown(driver, AddEmployeePageUI_HRM.STATUS_DROPDOWN, itemText);
	}

	

	

	

}