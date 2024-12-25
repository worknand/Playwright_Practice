package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class waitsInPlayWright {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		BrowserContext  browserContext =browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://the-internet.herokuapp.com/download", new Page.NavigateOptions().setTimeout(10000));
		
		// another way to set navigation time
		page.setDefaultNavigationTimeout(60000); 
		
		page.setDefaultTimeout(5000);
		
		//default wait is 30 seconds
		page.locator("#nanda").click();

	}

}
