package pageUIs.hrm;

import commons.BasePage;

public class BasePageUI_HRM extends BasePage {
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";
	public static final String TABLE_HEADER_BY_ID_NAME = "//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String TABLE_ROW_BY_COLUMN_ROW_INDEX = "//table[@id='%s']//tbody//tr[%s]//td[%s]";
	public static final String LINK_BY_TEXT = "//a[contains(string(),'%s')]";
	public static final String UPLOAD_BUTTON = "//input[@type='file']";

	
}

