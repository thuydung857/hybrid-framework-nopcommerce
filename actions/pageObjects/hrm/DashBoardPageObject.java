package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.BasePageUI_HRM;
import pageUIs.hrm.PersonalDetailsUI_HRM;

public class DashBoardPageObject extends BasePage {
	private WebDriver driver;

	public DashBoardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToProfileImage() {
		waitForElementClickable(driver, PersonalDetailsUI_HRM.PROFILE_IMAGE);
		clickToElement(driver, PersonalDetailsUI_HRM.PROFILE_IMAGE);
	}

	public void uploadAvatar(String avatar) {
		uploadSingleFile(driver, BasePageUI_HRM.UPLOAD_BUTTON, avatar);
	}

	

	

}