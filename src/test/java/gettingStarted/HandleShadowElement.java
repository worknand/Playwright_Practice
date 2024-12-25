package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleShadowElement {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
	     BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		BrowserContext  browserContext =	browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		// make sure shadow should be open to interact
		Locator shadowRoot=	page.locator("div#userName");
		shadowRoot.locator("input#kils").fill("Nanda");

		// for shadow Dom Xpath not allowed only CSS selector
		
	}

}
