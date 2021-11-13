package pageObjects.jQuery;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToTextboxByColumnName(String textValue, String columnName) {
		waitForElementClickable(driver, HomePageUI.TEXTBOX_BY_COLUMN_NAME, columnName);
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_NAME, textValue, columnName);
		pressKeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_NAME, Keys.ENTER, columnName);
	}

	public void openPageByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGING_BY_PAGE_NUMBER, pageNumber);
	}

	public boolean isPageActived(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.VERIFY_PAGING_ACTIVED, pageNumber);
		return isElementDisplayed(driver, HomePageUI.VERIFY_PAGING_ACTIVED, pageNumber);
	}

	public void clickToIconActionByTextboxName(String textboxName, String actionName) {
		waitForElementClickable(driver, HomePageUI.ACTION_BUTTON_BY_TEXTBOX_NAME, textboxName,
				actionName);
		clickToElement(driver, HomePageUI.ACTION_BUTTON_BY_TEXTBOX_NAME, textboxName, actionName);
	}

	public boolean isRowValueDisplayed(String females, String country, String males, String total) {
		waitForElementClickable(driver, HomePageUI.VERIFY_ROW_VALUE, females, country, males, total);
		return isElementDisplayed(driver, HomePageUI.VERIFY_ROW_VALUE, females, country, males, total);
	}

	public void inputToTextboxByRowIndex(String headerName, String textValue, String rowIndex) {
		int columnIndex = getElementSize(driver, HomePageUI.HEADER_NAME_INDEX, headerName) + 1;
		waitForElementClickable(driver, HomePageUI.TEXTBOX_BY_ROW_INDEX, rowIndex, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_ROW_INDEX, textValue, rowIndex, String.valueOf(columnIndex));
	}

	public void clickToActionButtonAtRowByRowIndex(String rowIndex, String actionName) {
		waitForElementClickable(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex, actionName);
		clickToElement(driver, HomePageUI.ACTION_BUTTON_BY_ROW_INDEX, rowIndex, actionName);
		
	}

}
