package com.proquest.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import net.thucydides.core.webdriver.DriverSource;

public class WebDriverManager implements DriverSource {

	public WebDriver newDriver() {
		WebDriver driver = null;
		String sBrowser = ConfigFileReader.getInstance().getBrowser();
		System.out.println("************************* Setting up driver *************************");
		driver = createDriver(sBrowser);
		return driver;
	}

	private WebDriver createDriver(String sBrowser) {
		WebDriver driver = null;

		if (sBrowser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ConfigFileReader.getInstance().getChromeDriverLoc());

			driver = new ChromeDriver();

		} else
			throw new IllegalArgumentException(sBrowser + " is an invalid browser!");

		System.out.println(
				"************************* Test starting on: " + sBrowser.toUpperCase() + " *************************");
		return driver;
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}

}
