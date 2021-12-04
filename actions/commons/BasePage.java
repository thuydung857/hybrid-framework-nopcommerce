package commons;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.OrderPageObject;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.SearchPageObject;
import pageUIs.hrm.BasePageUI_HRM;
import pageUIs.hrm.HomePageUI_HRM;
import pageUIs.nopCommerce.BasePageUI;

public class BasePage {
	WebDriver driver;
	Actions action;

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageURL(WebDriver driver, String pageURL) {
		driver.get(pageURL);

	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();

	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();

	}

	public Alert waitAlertPrecense(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		return explicitWait.until(ExpectedConditions.alertIsPresent());

	}

	public void acceptAlert(WebDriver driver) {
		waitAlertPrecense(driver).accept();

	}

	public void cancelacceptAlert(WebDriver driver) {
		waitAlertPrecense(driver).dismiss();

	}

	public String getTextAlert(WebDriver driver) {
		return waitAlertPrecense(driver).getText();

	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitAlertPrecense(driver).sendKeys(textValue);

	}

	public void pressKeyToElement(WebDriver driver, String xpathLocator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String xpathLocator, Keys key, String... params) {
		action = new Actions(driver);
		xpathLocator = getDynamicLocator(xpathLocator, params);
		action.sendKeys(getWebElement(driver, xpathLocator), key).perform();
	}

	public void selectWindowByID(WebDriver driver, String expectedPageID) {
		Set<String> allwindowIDs = driver.getWindowHandles();
		for (String window : allwindowIDs) {
			if (!window.equals(expectedPageID)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	public void selectWindowByTitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String window : allWindowIDs) {
			driver.switchTo().window(window);
			String actualPageTitle = driver.getTitle();
			if (actualPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String window : allWindowIDs) {
			if (!window.equals(parentID)) {
				driver.switchTo().window(window);
				driver.close();

			}
			driver.switchTo().window(parentID);
		}
	}

	private By getByXpath(String xpathLocator) {
		return By.xpath(xpathLocator);

	}

	public WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXpath(xpathLocator));
	}

	public String getDynamicLocator(String xpathLocator, String... params) {
		return String.format(xpathLocator, (Object[]) params);
	}

	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}

	public void clickToElement(WebDriver driver, String xpathLocator, String... params) {
		getWebElement(driver, getDynamicLocator(xpathLocator, params)).click();
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(textValue);
	}

	public void sendkeyToElement(WebDriver driver, String xpathLocator, String textValue, String... params) {
		xpathLocator = getDynamicLocator(xpathLocator, params);
		getWebElement(driver, xpathLocator).clear();
		getWebElement(driver, xpathLocator).sendKeys(textValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByVisibleText(textItem);
	}

	public String getSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(1);

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}

	public String getElementAttribute(WebDriver driver, String xpathLocator, String attributeValue) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeValue);
	}

	public String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText().trim();
	}

	public String getElementText(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).getText().trim();
	}

	public void getElementCSS(WebDriver driver, String xpathLocator) {
		Color.fromString(xpathLocator).asHex();
	}

	public String getHeraColorFromRGBA(WebDriver driver, String xpathLocator, String cssValue) {
		return getWebElement(driver, xpathLocator).getCssValue(cssValue);
	}

	public int getElementSize(WebDriver driver, String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}

	public int getElementSize(WebDriver driver, String xpathLocator, String... params) {
		xpathLocator = getDynamicLocator(xpathLocator, params);
		return getListWebElement(driver, xpathLocator).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}

	public boolean isElementUndisplayed(WebDriver driver, String xpathLocator) {
		overrideGlobalTimeOut(driver, shortTimeOut);
		List<WebElement> elements = getListWebElement(driver, xpathLocator);
		overrideGlobalTimeOut(driver, longTimeOut);
		if (elements.size() == 0) {
			System.out.println("Element is not in DOM");
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element is in DOM, but not visible");
			return true;
		} else {
			System.out.println("Element is in DOM and visible");
		}
		return false;
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... params) {
		return getWebElement(driver, getDynamicLocator(xpathLocator, params)).isDisplayed();
	}

	public boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}

	public void hoverToElement(WebDriver driver, String xpathLocator, String... params) {
		Actions action = new Actions(driver);
		xpathLocator = getDynamicLocator(xpathLocator, params);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}

	public void scrollToBottomPage() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void hightlightElement(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, xpathLocator));
	}

	public boolean isJQueryAndPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jsQueryLoad = new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}

			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jsQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, xpathLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, xpathLocator));
		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(
				ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, params))));
	}

	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}

	public void waitForAllElementVisible(WebDriver driver, String xpathLocator, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(getByXpath(getDynamicLocator(xpathLocator, params))));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForElementInvisible(WebDriver driver, String xpathLocator, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(
				ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(xpathLocator, params))));
	}

	public void waitForAllElementInvisible(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}

	public void waitForAllElementInvisible(WebDriver driver, String xpathLocator, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions
				.invisibilityOfAllElements(getListWebElement(driver, getDynamicLocator(xpathLocator, params))));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait
				.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(xpathLocator, params))));
	}

	public void waitForElementPrecense(WebDriver driver, String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}

	public void overrideGlobalTimeOut(WebDriver driver, long shortTimeOut) {
		driver.manage().timeouts().implicitlyWait(shortTimeOut, TimeUnit.SECONDS);
	}

	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for (Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}

	public void uploadSingleFile(WebDriver driver, String xpathLocator, String fileName) {
		waitForElementClickable(driver, xpathLocator);
		fileName = GlobalConstants.UPLOAD_FOLDER_PATH + fileName;
		sendkeyToElement(driver, xpathLocator, fileName);

	}
	
	// Open Page

	public SearchPageObject getSearchPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.SEARCH_PAGE_LINK_FOOTER);
		clickToElement(driver, BasePageUI.SEARCH_PAGE_LINK_FOOTER);
		return PageGeneratorManager.getSearchPage(driver);

	}

	public OrderPageObject getNewsPage(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.NEWS_PAGE_LINK_FOOTER);
		clickToElement(driver, BasePageUI.NEWS_PAGE_LINK_FOOTER);
		return PageGeneratorManager.getOrderPage(driver);

	}

	public void getfooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_PAGE_LINK_FOOTER, pageName);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE_LINK_FOOTER, pageName);

	}

	public String getDirectorySlash(WebDriver driver, String folderName) {
		String separator = System.getProperty("file.separator");
		System.out.println(separator);
		separator = FileSystems.getDefault().getSeparator();
		System.out.println(separator);
		separator = File.separator;
		System.out.println(separator);
		return separator + folderName + separator;
	}

	public void uploadMultileFiles(WebDriver driver, String xpathLocator, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FOLDER_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		sendkeyToElement(driver, xpathLocator, fullFileName);
	}

	// Page Object Pattern

	public void clickToLinkByText(WebDriver driver, String... params) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_LINK_BY_TEXT, params);
		clickToElement(driver, BasePageUI.DYNAMIC_LINK_BY_TEXT, params);

	}

	public void clickToButtonByText(WebDriver driver, String... params) {
		waitForElementClickable(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, params);
		clickToElement(driver, BasePageUI.DYNAMIC_BUTTON_BY_TEXT, params);

	}

	public void inputToTextBoxByID(WebDriver driver, String textValue, String... params) {
		waitForElementClickable(driver, BasePageUI_HRM.DYNAMIC_TEXTBOX_BY_ID, params);
		sendkeyToElement(driver, BasePageUI.DYNAMIC_TEXTBOX_BY_ID, textValue, params);
	}

	// HRM
	public void inputToTextboxByID(WebDriver driver, String textValue, String... params) {
		waitForElementClickable(driver, BasePageUI_HRM.DYNAMIC_TEXTBOX_BY_ID, params);
		sendkeyToElement(driver, BasePageUI_HRM.DYNAMIC_TEXTBOX_BY_ID, textValue, params);
	}

	public void clickToButtonByValue(WebDriver driver, String... params) {
		waitForElementClickable(driver, BasePageUI_HRM.DYNAMIC_BUTTON_BY_VALUE, params);
		clickToElement(driver, BasePageUI_HRM.DYNAMIC_BUTTON_BY_VALUE, params);

	}

	public void hoverToParentMenu(WebDriver driver, String... params) {
		waitForElementClickable(driver, HomePageUI_HRM.DYNAMIC_PARENT_MENU_BY_TEXT, params);
		hoverToElement(driver, HomePageUI_HRM.DYNAMIC_PARENT_MENU_BY_TEXT, params);
		
	}
	
	public void hoverToSubMenu(WebDriver driver, String... params) {
		waitForElementClickable(driver, HomePageUI_HRM.DYNAMIC_SUB_MENU_BY_TEXT, params);
		hoverToElement(driver, HomePageUI_HRM.DYNAMIC_SUB_MENU_BY_TEXT, params);
		
	}
	
	public String getValueDisplayedAtColumnNameAndRowIndex(WebDriver driver, String tableID, String headerName, String rowIndex) {
		int columnIndex = getElementSize(driver, BasePageUI_HRM.TABLE_HEADER_BY_ID_NAME, tableID, headerName) +1;
		waitForElementClickable(driver, BasePageUI_HRM.TABLE_ROW_BY_COLUMN_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
		return getElementText(driver, BasePageUI_HRM.TABLE_ROW_BY_COLUMN_ROW_INDEX, tableID, rowIndex, String.valueOf(columnIndex));
	}
	
	public void logoutToSystem(WebDriver driver, String welcomeLinkText, String logoutLinkText) {
		waitForElementClickable(driver, BasePageUI_HRM.LINK_BY_TEXT, welcomeLinkText);
		clickToElement(driver, BasePageUI_HRM.LINK_BY_TEXT, welcomeLinkText);
		waitForElementClickable(driver, BasePageUI_HRM.LINK_BY_TEXT, logoutLinkText);
		clickToElement(driver, BasePageUI_HRM.LINK_BY_TEXT, logoutLinkText);		
	}

	
	private long longTimeOut = 30;

	private long shortTimeOut = 10;

	public void sleepInSecond(long timeoutInSecond) {
		try {
			Thread.sleep(timeoutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}