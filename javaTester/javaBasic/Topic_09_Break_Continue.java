package javaBasic;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_09_Break_Continue {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	// Example

	@Parameters("browser")

	public void TC_01_Get_Browser(String browserName) {
		driver = getBrowserDrivers(browserName);

		System.out.println(browserName);

		driver.quit();
	}

	public WebDriver getBrowserDrivers(String browserName) {
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browseDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			// Dung break de thoat khoi vong lap
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browseDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			// Dung break de thoat khoi vong lap
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath + "\\browseDrivers\\msedgedriver.exe");
			driver = new ChromeDriver();
			// Dung break de thoat khoi vong lap

		}
		return driver;
	}

	@Test
	public void TC_02_Continue() {

		for (int i = 0; i <= 5; i++) {
			if (i == 4) {
				continue;
			}
			System.out.println("i skip 4 :" + i);

		}
	}
}