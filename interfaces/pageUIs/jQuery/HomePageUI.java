package pageUIs.jQuery;

import commons.BasePage;

public class HomePageUI extends BasePage {
	public static final String PAGING_BY_PAGE_NUMBER = "//ul[@class='qgrd-pagination-ul']//a[text()='%s']";
	public static final String VERIFY_PAGING_ACTIVED = "//ul[@class='qgrd-pagination-ul']//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TEXTBOX_BY_COLUMN_NAME = "//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ACTION_BUTTON_BY_TEXTBOX_NAME = "//td[text()='%s']/preceding-sibling::td/button[@class='qgrd-%s-row-btn']";
	public static final String VERIFY_ROW_VALUE = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";
	public static final String HEADER_NAME_INDEX = "//th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_ROW_INDEX = "//tr[%s]/td[%s]/input";
	public static final String ACTION_BUTTON_BY_ROW_INDEX = "//tr[%s]//button[@title='%s']";

}
