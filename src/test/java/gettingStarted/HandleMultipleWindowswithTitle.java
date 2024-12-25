package gettingStarted;

import java.util.Iterator;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleMultipleWindowswithTitle {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
	     BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		BrowserContext  browserContext =	browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
	
		Locator allLinks =	page.locator("div.social a");
		for (int i = 0; i < allLinks.count(); i++) {
			
			allLinks.nth(i).click();
		}
	
		List<Page> allPages =	browserContext.pages();
		
		for (Page p : allPages) 
		{
		String title =	p.title();
		System.out.println(title);
		if(title.contains("Facebook")) {
			p.bringToFront();
			p.locator("input[name='email']").first().fill("Hello World!!!!");
			break;
		}
		}
		page.getByPlaceholder("Enter Email").fill ("nandunanda0728@gmail.com");
		page.getByPlaceholder("Enter Password").fill ("Hello@123");
		page.bringToFront();
		
	     page.close();
	     browserContext.close();
	     browser.close();
	     pw.close();
		
		
	}

}
