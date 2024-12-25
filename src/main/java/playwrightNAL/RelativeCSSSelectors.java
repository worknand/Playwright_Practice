package playwrightNAL;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class RelativeCSSSelectors {
	static Page page;
	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		page= browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		selectUser("Joe.Root");
		selectUser("John.Smith");
		userRole("Joe.Root");
		userRole("John.Smith");
		String above=page.locator("a:above(:text('Joe.Root'))").first().textContent();
		System.out.println(above);
		String below=page.locator("a:below(:text('Joe.Root'))").first().textContent();
		System.out.println(below);
		
		Locator nearelements=page.locator("td:near(:text('Joe.Root'),100)");
	//	List<String> allNearElements=nearelements.allInnerTexts();
		List<String> allNearElements=nearelements.allTextContents();
         System.out.println(allNearElements);
	}
	
	public static void selectUser(String username) {
		page.locator("input[type='checkbox']:left-of(:text('"+username+"'))").first().click();
	}
	
	public static void userRole(String userrole) {
		
	String text=page.locator("td:right-of(:text('"+userrole+"'))").first().textContent();
	System.out.println(text);
	}

}
