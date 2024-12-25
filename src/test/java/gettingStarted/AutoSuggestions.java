package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoSuggestions {

	public static void main(String[] args) {
		
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
	//		BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page= browser.newPage();
		page.navigate("https://www.google.com/");
		page.locator("//textarea[@name='q']").fill("Mukesh Otwani");
	//	Locator locators=	page.locator("//ul[@role='listbox']//li").nth(5).click();
		Locator locators=	page.locator("//ul[@role='listbox']//li");
		System.out.println(locators.count());
		
		for (int i = 1; i < locators.count(); i++) {
	//	String texts=locators.nth(i).textContent();
		String texts=locators.nth(i).innerText();
		System.out.println(texts);
		if(texts.contains("playwright")) {
			locators.nth(i).click();
			break;
		}
		}
		
		page.close();
		browser.close();
		pw.close();
		
	}

}
