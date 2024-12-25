package playwrightNAL;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;

public class LocatorConcept {

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		BrowserContext browserContext=browser.newContext();
		Page page=	browserContext.newPage();
		page.navigate("https://www.orangehrm.com/en/30-day-free-trial");
		
		//locator  single element
		
////		Locator contactSales=page.locator("text= Contact Sales").nth(1);
//	//	Locator contactSales=page.locator("text= Contact Sales").first();
//		Locator contactSales=page.locator("text= Contact Sales").last();
//		int count=contactSales.count();
//	     System.out.println(count);
//		contactSales.hover();
//		contactSales.click();
		
		//multiple elements
		Locator countryList=page.locator("select#Form_getForm_Country option");
		System.out.println(countryList.count());
		
//		for (int i = 0; i < countryList.count(); i++) {
//		System.out.println(	countryList.nth(i).textContent());
//		}
		
		List<String> listCountries=	countryList.allTextContents();
//		for (String string : listCountries) {
//			System.out.println(string);
//		}
		
		
		listCountries.forEach(ele ->System.out.println(ele));

	}

}
