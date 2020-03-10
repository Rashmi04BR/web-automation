package com.proquest.steps;

import org.junit.Assert;

import com.proquest.core.CommonUtils;
import com.proquest.core.Loggger;
import com.proquest.pages.GooglePage;
import com.proquest.pages.GoogleSearchResultsPage;
import com.proquest.pages.ProQuestPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;

public class Steps {

	@Managed
	private WebDriverFacade driver;

	private CommonUtils utils;

	private GooglePage googePage;
	private GoogleSearchResultsPage googleSearchResultsPage;
	private ProQuestPage proQuestPage;

	private Loggger log;

	@Given("^User is on google page$")
	public void user_is_on_google_page() throws Exception {
		googePage.getGooglePage();
		Assert.assertEquals("Google Page is not successfully loaded", "Google", driver.getTitle());
		log.entry("Google Page is successfully loaded");
	}

	@When("user searches for \"([^\"]*)\"$")
	public void user_searches_for(String sSearchText) {
		googePage.input_search.typeAndEnter(sSearchText);
		log.entry("Searched for: " + sSearchText);
	}

	@Then("the user is able to save the titles of all the results on the first page to a text file")
	public void the_user_is_able_to_save_the_titles_of_all_the_results_on_the_first_page_to_a_text_file() {
		googleSearchResultsPage.writeResultsToTitlesFile();
	}

	@When("user clicks on \"([^\"]*)\" website fom the results")
	public void user_clicks_on_website_fom_the_results(String sTitle) {
		googleSearchResultsPage.selectResultWithTitle(sTitle);
		log.entry("Selected google result: " + sTitle);
	}

	@When("search for \"([^\"]*)\" in the top nav")
	public void search_for_in_the_top_nav(String sText) {
		proQuestPage.clickAgreeIfDisplayed();
		proQuestPage.btn_search.click();
		proQuestPage.input_search.typeAndEnter(sText);
		log.entry("Searched for: " + sText + " on ProQuest website");
	}

	@Then("user takes a screenshot")
	public void user_takes_a_screenshot() {
		utils.captureScreenshot("ProQuest");
		log.entry("Screenshot found in loc: src/test/resources/files");
	}

}
