package playwrightNAL;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
	     BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(0));
		Page page= browser.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=114.0.5735.90/");
		Download  download =	page.waitForDownload(() -> {
		page.click("//a[text()='chromedriver_win32.zip']");
		});
		
		//download.cancel();
	    System.out.println(download.failure());
		
	    System.out.println(download.url());
	  //System.out.println(download.page().title());
	   String path= download.path().toString();
       System.out.println(path);
       
       download.saveAs(Paths.get("nanda_Chrome1.zip"));
       System.out.println(download.suggestedFilename());
	}

}
