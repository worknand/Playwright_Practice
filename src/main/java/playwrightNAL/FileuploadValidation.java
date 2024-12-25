package playwrightNAL;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class FileuploadValidation {

	public static void main(String[] args) {
	
			Playwright pw=	Playwright.create();
	     BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page= browser.newPage();
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");
//		page.locator("//input [@name='upfile']").setInputFiles(Path.of("sampleupload.txt"));
		//run time upload
		page.setInputFiles("//input [@name='upfile']", new FilePayload("nanda.txt", "text/plain", "Hello World!!!".getBytes(StandardCharsets.UTF_8)));
		page.locator("//input [@value='Press']").click();
	}

}
