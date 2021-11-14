package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isConfirmEmailTextboxDisplayed() {
		return isElementDisplayed(driver, RegisterPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void inputToEmailTextBox(String textValue) {
		waitForElementClickable(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, textValue);
		
	}

	public boolean isConfirmEmailTextboxUndisplayed() {
		//Sử dụng List<WebElement> để get size ra
		//Check = 0 thì trả về true
		//Check > 0 && ko hien thi tren UI , trả về true
		//Sau do set lai timeout cho implicitWait 
		return isElementUndisplayed(driver, RegisterPageUI.LOGIN_BUTTON);
	}

}
