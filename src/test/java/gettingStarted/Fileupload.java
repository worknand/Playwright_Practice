package gettingStarted;

import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Fileupload {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
	     BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page= browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/upload");
	//	page.locator("//input[@id='file-upload']").setInputFiles(Path.of("C:/Users/nanda/Downloads/Payment Receipt.pdf"));
	//	page.locator("//input[@id='file-upload']").setInputFiles(Path.of(System.getProperty("user.dir")+"/files/Payment Receipt.pdf"));
		Path[] files= {
				Path.of(System.getProperty("user.dir")+"/files/Payment Receipt (2).pdf")
				};
		page.locator("//input[@id='file-upload']").setInputFiles(files);
		
		// to remove uploaded files
		page.locator("//input[@id='file-upload']").setInputFiles(new Path[0]);
//		page.close();
//		browser.close();
//		pw.close();

	}

}
