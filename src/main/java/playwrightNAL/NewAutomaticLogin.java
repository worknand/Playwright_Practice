package playwrightNAL;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class NewAutomaticLogin {
	
	static Page page;

	public static void main(String[] args) {
		Playwright playwright=	Playwright.create();
		LaunchOptions lp=new LaunchOptions();
		lp.setHeadless(false);
		lp.setSlowMo(500);
		lp.setChannel("chrome");
		Browser browser=playwright.chromium().launch(lp);
		BrowserContext context = browser.newContext(new Browser.NewContextOptions()
		        .setStorageStatePath(Paths.get("applogin1.json")));
		page= context.newPage();
		
//		mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen --save-storage=auth.json"
//		mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen --load-storage=applogin1.json https://freelance-learn-automation.vercel.app"
		
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		

	}

}
