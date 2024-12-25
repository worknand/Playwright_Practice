package playwrightNAL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class HandleShadowDOM {

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		Page page= browser.newPage();
		
		//page-->DOM-->Shadow DOM -->Elements
		//page-->DOM --> iframe -->Shadow DOM -->Elements
		
//		page.navigate("https://books-pwakit.appspot.com/");
//		page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
//	    String text=	page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
//	    System.out.println(text);
		
//		page.navigate("https://selectorshub.com/xpath-practice-page/");
		page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
		
		page.frameLocator("#pact").locator("div#snacktime #tea").fill("YES");
	
		
		

	}

}
