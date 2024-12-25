package playwrightNAL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Playwrightstart {

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
	    Page page=browser.newPage();
	    page.navigate("https://www.amazon.in/");
	    String title= page.title();
	    System.out.println(title);
	     String url=  page.url();
	     System.out.println(url);
	       page.close();
			browser.close();
			playwright.close();

	}

}
