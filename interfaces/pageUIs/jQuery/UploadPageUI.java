package pageUIs.jQuery;

import commons.BasePage;

public class UploadPageUI extends BasePage {
	public static final String UPLOAD_BUTTON = "//input[@type='file']";
	public static final String VERIFY_FILE_NAME = "//p[@class='name' and text()='%s']";
	public static final String CANCEL_BUTTON = "//tbody[@class='files']//button[@class='btn btn-warning cancel']";

}
