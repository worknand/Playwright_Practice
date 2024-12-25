package playwrightNAL;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class HandleVisibleElements {

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		Page page= browser.newPage();
		
		page.navigate("https://www.amazon.in/");
		List<String> alltexts=	page.locator("a:visible").allInnerTexts();
		for (String string : alltexts) {
			System.out.println(string);
		}
		
	 int countImages =	page.locator("//img >> visible=true").count();
	 System.out.println(countImages);

	}

}
