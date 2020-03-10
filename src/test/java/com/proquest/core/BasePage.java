package com.proquest.core;

import org.openqa.selenium.WebDriver;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject{
	
	protected WebDriver getWebDriver() {
		return super.getDriver();
	}
}
