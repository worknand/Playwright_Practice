package playwrightNAL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class TextSelector {

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		Page page= browser.newPage();
//		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		page.navigate("https://demo.opencart.com/en-gb?route=account/login");
		//text selector
//		page.locator("text=Contact Sales").last().click();
//		page.locator("text=Privacy Policy").click();
//		page.locator("'Privacy Policy'").click();
		
//		page.locator("text= Login").click();
		page.locator("form button:has-text('Login')").click();
		

	}

}
