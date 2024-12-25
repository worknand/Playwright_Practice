package playwrightNAL;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class ComplexWebTable2 {

	static Page page;
	
	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		page= browser.newPage();
		page.navigate("https://primeng.org/");
		selectCheckbox(" Josephine Darakjy ");
		selectCheckbox(" Donette Foller ");
		selectCheckbox(" Art Venere ");
		
		
	}
	
	public static void selectCheckbox(String name) {
		Locator row=page.locator("table#pn_id_1-table tr");
		row.locator(":scope", new Locator.LocatorOptions().setHasText(name))
		.locator(".p-checkbox-box.p-component").click();
		
		List<String> rowname=row.locator(":scope").allInnerTexts();
		for ( String string : rowname) {
			System.out.println(string);
		}
	}

}
