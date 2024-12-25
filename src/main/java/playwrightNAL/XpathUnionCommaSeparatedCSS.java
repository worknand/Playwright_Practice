package playwrightNAL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class XpathUnionCommaSeparatedCSS {

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		Page page= browser.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		// comma separated css
//		page.locator("a:has-text('SignIn'),"
//				+ "a:has-text('LogIn'),"
//				+ "a:has-text('signin'),"
//				+ "a:has-text('login'),"
//				+ "a:has-text('signIn')").click();
		
		// xpath union
		page.locator("//a[text()='Login']|//a[text()='Signin']").click();
		

	}

}
