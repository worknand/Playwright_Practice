package playwrightNAL;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class ComplexWebTable {

	static Page page;
	
	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		page= browser.newPage();
		page.navigate("https://datatables.net/extensions/select/examples/checkbox/order.html");
		selectCheckbox("Ashton Cox");
		selectCheckbox("Brielle Williamson");
		selectCheckbox("Accountant");
		
		
	}
	
	public static void selectCheckbox(String name) {
		Locator row=page.locator("table#example tr");
		row.locator(":scope", new Locator.LocatorOptions().setHasText(name))
		.locator(".dt-select-checkbox").click();
		
		List<String> rowname=row.locator(":scope").allInnerTexts();
		for ( String string : rowname) {
			System.out.println(string);
		}
	}

}
