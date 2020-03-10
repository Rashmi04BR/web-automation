package com.proquest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import com.proquest.core.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.annotations.findby.How;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProQuestPage extends BasePage {

	@FindBy(how = How.CSS, using = "i[class=' fa  fa-2  fa-search ']")
	public WebElementFacade btn_search;

	@FindBy(how = How.CSS, using = "#search-form input[name='searchKeyword']")
	public WebElementFacade input_search;

	public void clickAgreeIfDisplayed() {
		CookiesWindow cookiesWindow = new CookiesWindow(this);
		cookiesWindow.clickAgreeIfDisplayed();
	}

	private class CookiesWindow {

		private By btn_agreeAndProcceed = By.cssSelector(".call");
		private By btn_close = By.id("gwt-debug-close_id");
		private By frame = By.xpath("//*[contains(@id,'pop-frame')]");
		private ProQuestPage root;

		CookiesWindow(ProQuestPage root) {
			this.root = root;
		}

		public void clickAgreeIfDisplayed() {
			try {
				getWebDriver().switchTo().frame(root.find(frame));
				root.find(btn_agreeAndProcceed).withTimeoutOf(Duration.ofSeconds(6));
				root.find(btn_agreeAndProcceed).click();
				root.find(btn_close).click();
			} catch (TimeoutException e) {
				// do nothing
			}
		}
	}

}
