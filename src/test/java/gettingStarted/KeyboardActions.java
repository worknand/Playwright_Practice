package gettingStarted;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class KeyboardActions {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		BrowserContext  browserContext =browser.newContext();
		Page page= browserContext.newPage();
		//page.navigate("https://www.toptal.com/developers/keycode");
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.getByPlaceholder("Enter Email").fill ("nandunanda0728@gmail.com");
//		page.getByPlaceholder("Enter Password").fill ("Hello@123");
//		page.keyboard().press("Enter");
//		page.keyboard().down("Control");
//		page.keyboard().press("a");
//		page.keyboard().up("Control");
//		page.keyboard().down("Control");
//		page.keyboard().press("c");
//		page.keyboard().up("Control");
//		page.keyboard().press("Tab");
//		page.keyboard().down("Control");
//		page.keyboard().press("v");
//		page.keyboard().up("Control");
//		page.keyboard().press("Tab");
//		page.keyboard().press("Enter");
		page.keyboard().press("Control+A")		;
		page.keyboard().press("Control+C")		;
		page.keyboard().press("Tab");
		page.keyboard().press("Control+V")		;
		page.keyboard().press("Enter");
		
		
//		page.close();
//		browserContext.close();
//		browser.close();
//		pw.close();
	}

	}


