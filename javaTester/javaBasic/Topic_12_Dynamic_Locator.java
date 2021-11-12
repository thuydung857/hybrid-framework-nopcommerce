package javaBasic;

public class Topic_12_Dynamic_Locator {

	public static void main(String[] args) {
		// UI

		String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']";
		String DYNAMIC1_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']//a[text()='%s']";
		String DYNAMIC2_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']//a[text()='%s']//a[text()='%s']";

		// Page Object
		// Truyền bao nhiêu text cũng đc
		clickToElement(DYNAMIC_FOOTER_LINK, "vietnam");
		clickToElement(DYNAMIC1_FOOTER_LINK, "vietnam", "hcm");
		clickToElement(DYNAMIC2_FOOTER_LINK, "vietnam", "hcm", "hanoi");
		
	}

	// Fix cứng 1 tham số
	public static void clickToElement(String xpathLocator) {
		System.out.println(xpathLocator);
	}

	// 1 tham số dynamic, xài String.format để gắn text vô locator
	public static void clickToElement(String xpathLocator, String carName) {
		System.out.println(String.format(xpathLocator, carName));

	}
	
	// 2 tham số dynamic, tối đa xài đc 2 text cho String.format
	public static void clickToElement(String xpathLocator, String carName, String carColor) {
		System.out.println(String.format(xpathLocator, carName, carColor));

	}
	
	// Dynamic locator: xài Object[]... , có dấu ... trước variable
	public static void clickToElement(String xpathLocator, String...params) {
		System.out.println(String.format(xpathLocator, (Object[]) params));

	}

}
