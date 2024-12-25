package gettingStarted;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleMultipleWindows {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
	     BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		BrowserContext  browserContext =	browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		Page newpage= browserContext.waitForPage(() -> {
			page.locator("//a[@target='_blank']").first().click();
		});
		newpage.waitForLoadState();
		
	     System.out.println (newpage.title());
	     newpage.locator("input#search").fill("Naveen Automarion labs");
	     newpage.locator("button#search-icon-legacy").click();
	     page.bringToFront();
	     newpage.bringToFront();
	     page.bringToFront();
	     newpage.bringToFront();	     
	     List<Page> listOfPages=browserContext.pages();
	     listOfPages.forEach(e -> System.out.println(e));
	     System.out.println (page.title());
	     newpage.close();
	     page.close();
	     browserContext.close();
	     browser.close();
	     pw.close();
		
		
	}

}
