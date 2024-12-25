package gettingStarted;

import java.nio.file.Paths;
import java.util.Base64;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;


public class screenshotPlaywright {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
	//		BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page= browser.newPage();
		page.navigate("https://www.naukri.com/");
		
       Utility.captureScreenshot(page);
		
//		byte[] b=page.screenshot(new ScreenshotOptions().setPath(Paths.get("ss.png")).setFullPage(true));
//		
//		page.locator("//img[@alt='awareness']").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("ss1.png")));
		
	//	System.out.println(Base64.getEncoder().encodeToString(b));
		page.close();
		browser.close();
		pw.close();

	}

}
