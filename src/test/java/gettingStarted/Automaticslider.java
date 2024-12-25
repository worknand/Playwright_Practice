package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Automaticslider {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		BrowserContext  browserContext =browser.newContext();
		Page page= browserContext.newPage();
		//page.navigate("https://www.toptal.com/developers/keycode");
		page.navigate("https://jqueryui.com/slider/");
		FrameLocator frame=	page.frameLocator(".demo-frame");
		Locator  locator=	frame.locator(".ui-slider-handle.ui-corner-all.ui-state-default");
		locator.focus();
		for (int i = 0; i <20; i++) {
			page.keyboard().press("ArrowRight");
		}
		
		page.close();
		browserContext.close();
		browser.close();
		pw.close();

	}

}
