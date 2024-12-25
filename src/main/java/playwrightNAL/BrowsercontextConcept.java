package playwrightNAL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

public class BrowsercontextConcept {

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		//lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		
		// window1
		BrowserContext browserContext1=browser.newContext();
		Page page1=	browserContext1.newPage();
		page1.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		page1.fill("#Form_getForm_Name", "nanda");
		System.out.println(page1.title());
		
		//window2
		BrowserContext browserContext2=browser.newContext();
		Page page2=	browserContext2.newPage();
		page2.navigate("https://testautomationpractice.blogspot.com/");
		page2.fill("#name", "nanda");
		System.out.println(page2.title());
		
		page1.close();
		page2.close();
		browserContext1.close();
		browserContext2.close();
		browser.close();
		playwright.close();

	}

}
