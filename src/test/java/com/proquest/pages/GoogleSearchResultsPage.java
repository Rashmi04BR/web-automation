package com.proquest.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.By;

import com.proquest.core.BasePage;
import com.proquest.core.CommonUtils;
import net.serenitybdd.core.pages.WebElementFacade;

public class GoogleSearchResultsPage extends BasePage {

	private CommonUtils utils;

	public By hdr_tiles = By.cssSelector(".bkWMgd h3[class='LC20lb DKV0Md']");

	private String sTitlesFileLoc = "src/test/resources/files/titles.txt";

	private boolean areResultsAvailable() {
		find(hdr_tiles).withTimeoutOf(Duration.ofSeconds(5));
		List<WebElementFacade> results = findAll(hdr_tiles);
		return (results.size() > 0);
	}

	public void writeResultsToTitlesFile() {
		Set<String> titles = getAllTitles();
		try {
			FileWriter writer = new FileWriter(sTitlesFileLoc);
			writer.write("Search Results Titles: \n");
			for (String eachTitle : titles) {
				if (!eachTitle.isEmpty()) {
					writer.append("\n" + eachTitle);
					System.out.println("Title: '" + eachTitle + "' updated to file");
				}
			}
			writer.write("\n\n\nLast Updated on: " + utils.getLastUpdatedOn());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Set<String> getAllTitles() {
		return getResults().keySet();
	}

	public Map<String, WebElementFacade> getResults() {
		Map<String, WebElementFacade> results = new LinkedHashMap();
		if (areResultsAvailable()) {
			for (WebElementFacade eachResult : findAll(hdr_tiles)) {
				results.put(eachResult.getText(), eachResult);
			}
		} // else
			// throw new RuntimeException("Results page not loaded");
		return results;
	}

	public void selectResultWithTitle(String sTitle) {
		getResults().get(sTitle).click();
	}

}
