package pageUIs.nopCommerce;

import commons.BasePage;

public class BasePageUI extends BasePage {
	public static final String SEARCH_PAGE_LINK_FOOTER = "//a[text()='Search']";
	public static final String NEWS_PAGE_LINK_FOOTER = "//a[text()='News']";
	public static final String DYNAMIC_PAGE_LINK_FOOTER = "//div[@class='footer']//a[text()='%s']";

	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_LINK_BY_TEXT = "//a[contains(string(),'%s')]";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "//button[text()='%s']";

}

