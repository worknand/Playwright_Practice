package playwrightNAL;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.ScreenshotOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScreenshotConcept {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
	//		BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page= browser.newPage();
		page.navigate("https://naveenautomationlabs.com/opencart/");
		
//		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")).setFullPage(true));
		
//		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")).setFullPage(false));
		// take screen shot particular image
		page.locator("//img[@title='MacBook']").screenshot(new ScreenshotOptions().setPath(Paths.get("screenshot.png")));
		page.locator("(//div[@class='row'])[last()-1]").screenshot(new ScreenshotOptions().setPath(Paths.get("screenshot.png")));

	}

}
