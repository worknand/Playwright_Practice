package playwrightNAL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class ReactElementSelectors {
	
	static Page page;

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		page= browser.newPage();
		page.navigate("https://www.netflix.com/in/");
		page.locator("_react=Anonymous[type='submit']").first().click();

	}

}
