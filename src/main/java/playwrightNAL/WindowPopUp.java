package playwrightNAL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class WindowPopUp {

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(0);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		
		BrowserContext browserContext1=browser.newContext();
	    Page page=	browserContext1.newPage();
	    page.navigate("https://www.cricbuzz.com/");
//	    Page popupPage=  page.waitForPopup(() -> {
//	    	page.click("//a//span[text()='twitter']");
//	    });
//	     popupPage.waitForLoadState();
//	     System.out.println (popupPage.title());
//	     popupPage.close();
//	     System.out.println (page.title());
	    
	    
	    
	    Page popupPage=  page.waitForPopup(() -> {
    	page.locator("a[target='_blank']").last().click(); //open new tab blank window
    });
	    popupPage.waitForLoadState();
	    popupPage.navigate("https://www.amazon.com/");
	     System.out.println (popupPage.title());
	     popupPage.close();
	     System.out.println (page.title());
	     page.close();

	    
	    
//		BrowserContext browserContext2=browser.newContext();
//		
//		Page page1= browserContext1.newPage();
//		Page page2= browserContext2.newPage();
//		
//		page1.navigate("https://www.google.com/");
//		page2.navigate("https://www.amazon.com/");

	}

}
