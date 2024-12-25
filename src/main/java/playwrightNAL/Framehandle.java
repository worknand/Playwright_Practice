package playwrightNAL;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class Framehandle {

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		Page page= browser.newPage();
//		page.navigate("https://www.londonfreelance.org/courses/frames/index.html");
//		//css selector
////	   String header=	page.frameLocator("frame[name='main']").locator("h2").textContent();
////	   System.out.println(header);
//		
//		String header=page.frame("main").locator("h2").textContent();
//		System.out.println(header);
		
		page.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		page.locator("//img[@title='Vehicle-Registration-Forms-and-Examples']").click();
		page.frameLocator("//iframe[contains(@id,'frame-one')]").locator("#RESULT_TextField-1").fill("Nanda");
		
		

	}

}
