package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JSExecutor {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		BrowserType  browserType= pw.firefox();
//	    BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page= browser.newPage();
		page.navigate("https://login.yahoo.com/");
		//page.locator("input#persistent").click();
		// why it is not clicked because in styles tab  width is .94118  which is less than 1 so playwright assume its not a visible property
		System.out.println (page.locator("input#persistent").boundingBox().height);
		System.out.println (page.locator("input#persistent").boundingBox().width);
		
		//using JS executor
//		page.evaluate("document.getElementById('persistent').click()");
		
		//another approach
	Locator locator=page.locator("input#persistent");
	locator.evaluate("locator => locator.click()");
}
}
