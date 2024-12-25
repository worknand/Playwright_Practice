package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitForSelectorState;

public class waitsInPlayWright2 {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		BrowserContext  browserContext =browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		
		// another way to set navigation time
		page.setDefaultNavigationTimeout(60000); 
		
		page.setDefaultTimeout(30000);
		
		//default wait is 30 seconds
		page.locator("//button[text()='Click me to start timer']").click();
		page.locator("//p[text()='WebDriver']").waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(20000));
		
		System.out.println("Is Visible ?" +page.locator("//p[text()='WebDriver']").isVisible());
		

	}

}
