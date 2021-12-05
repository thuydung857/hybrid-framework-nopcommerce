package pageObjects.swagLabs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.swagLabs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInDropDown(String value) {
		waitForElementClickable(driver, HomePageUI.DEFAULT_DROPDOWN);
		selectItemInDefaultDropdown(driver, HomePageUI.DEFAULT_DROPDOWN, value);
	}

	public boolean isTextSortAscending() {
		List<WebElement> productElements = getListWebElement(driver, HomePageUI.PRODUCT_NAME);

		// List 1
		List<String> productName = new ArrayList<>();

		for (WebElement element : productElements) {
			productName.add(element.getText());
		}

		System.out.println("1 -----------");
		for (String product : productName) {
			System.out.println(product);
		}
		
		// List 2
		List<String> productNameClone = new ArrayList<>();
		for (String product : productName) {
			productNameClone.add(product);
		}

		Collections.sort(productNameClone);

		System.out.println("2 -----------");
		for (String product : productNameClone) {
			System.out.println(product);

		}

		return productName.equals(productNameClone);

	}
	
	public boolean isTextSortDescending() {
		List<WebElement> productElements = getListWebElement(driver, HomePageUI.PRODUCT_NAME);

		// List 1
		List<String> productName = new ArrayList<>();

		for (WebElement element : productElements) {
			productName.add(element.getText());
		}

		System.out.println("1 -----------");
		for (String product : productName) {
			System.out.println(product);
		}
		
		// List 2
		List<String> productNameClone = new ArrayList<>();
		for (String product : productName) {
			productNameClone.add(product);
		}

		Collections.sort(productNameClone);
		Collections.reverse(productNameClone);

		System.out.println("2 -----------");
		for (String product : productNameClone) {
			System.out.println(product);

		}

		return productName.equals(productNameClone);

	}

	public boolean isPriceSortAscending() {
		List<WebElement> productElements = getListWebElement(driver, HomePageUI.PRODUCT_PRICE);

		// List 1
		List<Float> productPrice = new ArrayList<Float>();

		for (WebElement element : productElements) {
			productPrice.add(Float.parseFloat(element.getText().replace("$", "")));
		}

		// List 2
		List<Float> productPriceClone = new ArrayList<Float>();
		for (Float product : productPrice) {
			productPriceClone.add(product);
		}

		Collections.sort(productPriceClone);

			return productPrice.equals(productPriceClone);

	}
	
	public boolean isPriceSortDescending() {
		List<WebElement> productElements = getListWebElement(driver, HomePageUI.PRODUCT_PRICE);

		// List 1
		List<Float> productPrice = new ArrayList<Float>();

		for (WebElement element : productElements) {
			productPrice.add(Float.parseFloat(element.getText().replace("$", "")));
		}

		// List 2
		List<Float> productPriceClone = new ArrayList<Float>();
		for (Float product : productPrice) {
			productPriceClone.add(product);
		}

		Collections.sort(productPriceClone);
		Collections.reverse(productPriceClone);

			return productPrice.equals(productPriceClone);

	}

}


