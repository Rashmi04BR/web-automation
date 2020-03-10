package com.proquest.pages;

import com.proquest.core.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class GooglePage extends BasePage{
	
	@FindBy(how=How.CSS, using ="input[title='Search']")
	public WebElementFacade input_search;
	
	String sURL = "https://www.google.co.uk";
	
	public void getGooglePage() {
		getWebDriver().navigate().to(sURL);
		getWebDriver().manage().window().maximize();
	}
}
