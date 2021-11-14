package pageObjects.jQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.jQuery.UploadPageUI;

public class UploadPageObject extends BasePage {
	private WebDriver driver;
	

	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadSingleFile(String fileName) {
		waitForElementClickable(driver, UploadPageUI.UPLOAD_BUTTON);
		fileName = GlobalConstants.UPLOAD_FOLDER_PATH + fileName;
		sendkeyToElement(driver, UploadPageUI.UPLOAD_BUTTON, fileName);

	}

	public boolean isSingleDisplayed(String fileName1) {
		waitForElementVisible(driver, UploadPageUI.VERIFY_FILE_NAME, fileName1);
		return isElementDisplayed(driver, UploadPageUI.VERIFY_FILE_NAME, fileName1);
	}

	public void clickToUploadFileButton() {
		waitForElementClickable(driver, UploadPageUI.UPLOAD_BUTTON);
		List<WebElement> uploadFileButtons = getListWebElement(driver, UploadPageUI.CANCEL_BUTTON);
		for (WebElement uploadFileButton : uploadFileButtons) {
			uploadFileButton.click();
		}
	}

	public void uploadMultipleFile(String fileName1, String fileName2) {
		waitForElementClickable(driver, UploadPageUI.UPLOAD_BUTTON);
		uploadMultileFiles(driver, UploadPageUI.UPLOAD_BUTTON, fileName1, fileName2);
	}

	public boolean isMultipleDisplayed(String fileName1, String fileName2) {
		waitForElementVisible(driver, UploadPageUI.VERIFY_FILE_NAME, fileName1, fileName2);
		return isElementDisplayed(driver, UploadPageUI.VERIFY_FILE_NAME, fileName1, fileName2);
	}

}
