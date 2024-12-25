package playwrightNAL;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeBrowser {

	public static void main(String[] args) {
//		Dimension dimension =	Toolkit.getDefaultToolkit().getScreenSize();
//		int height =(int) dimension.getHeight();
//		int width =	(int) dimension.getWidth();
//		System.out.println(width + ":" + height);
//		
//		Playwright pw=	Playwright.create();
//	     BrowserType  browserType=	pw.chromium();
////		  BrowserType  browserType= pw.firefox();
////			BrowserType  browserType= pw.webkit();
//		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(0));
//		BrowserContext browserContext=browser.newContext(new Browser.NewContextOptions().setViewportSize(width , height));
//		Page page= browserContext.newPage();
//		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
		
		
		
		
	       Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	        int width = (int) dimension.getWidth();
	        int height = (int) dimension.getHeight();

	        Playwright  playwright = Playwright.create();
	        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
	        launchOptions.setHeadless(false).setArgs(List.of("--start-maximized"));

	        Browser  browser = playwright
	                .chromium()
	                .launch(launchOptions);

	        Page page = browser.newPage();
	       page.setViewportSize(width,height);
	       page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");

	}

}
