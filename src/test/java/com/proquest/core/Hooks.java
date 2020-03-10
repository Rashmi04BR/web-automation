package com.proquest.core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;

public class Hooks {

	@Managed
	private WebDriverFacade driver;

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		} else
		driver.quit();
	}
}
