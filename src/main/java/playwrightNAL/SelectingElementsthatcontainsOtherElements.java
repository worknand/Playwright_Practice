package playwrightNAL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class SelectingElementsthatcontainsOtherElements {

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		Page page= browser.newPage();
//		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
//		
//		Locator locator=page.locator("select#Form_getForm_Country:has(option[value='India'])");
//		locator.allInnerTexts().forEach(e -> System.out.println(e));
		
		page.navigate("https://www.amazon.com/");
		//                  //div[text()='Get to Know Us']//..//li
		
		Locator locator=	page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
		locator.allInnerTexts().forEach(e -> System.out.println(e));
		
		
	}

}
