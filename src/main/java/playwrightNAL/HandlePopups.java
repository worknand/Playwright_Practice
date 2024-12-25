package playwrightNAL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class HandlePopups {
	
	static Page page;

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		BrowserContext browserContext=	browser.newContext();
		page= browserContext.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");

	}

}
