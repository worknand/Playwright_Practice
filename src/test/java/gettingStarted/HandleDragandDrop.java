package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleDragandDrop {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		BrowserContext  browserContext =browser.newContext();
		Page page= browserContext.newPage();
		//page.navigate("https://www.toptal.com/developers/keycode");
		page.navigate("https://jqueryui.com/droppable/");
		FrameLocator frame=	page.frameLocator(".demo-frame");
	   // frame.locator("div#draggable").dragTo(frame.locator("#droppable"));
	    
	  //  page.locator(null).dragTo(page.locator(null));
		
		frame.locator("#draggable").hover();
		page.mouse().down();
		frame.locator("#droppable").hover();
		page.mouse().up();
		
		page.close();
		browserContext.close();
		browser.close();
		pw.close();

	}

}
