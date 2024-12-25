package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstPlayWrightScript {
	
	public static void main(String[] args) {
		
		Playwright  pw =Playwright.create();
		BrowserType  browserType= pw.chromium();
//	   BrowserType  browserType= pw.firefox();
//		BrowserType  browserType= pw.webkit();
		//normal headless browser engine to test
//		Browser  browser= browserType.launch();
		// using browser engines to test
//		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		// using brand browser to test
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page= browser.newPage();
		
		page.navigate("https://playwright.dev/java/");
		
		String titleOfWebpage=page.title();
		System.out.println(titleOfWebpage);
		page.close();
		browser.close();
		pw.close();
		
	}

}
