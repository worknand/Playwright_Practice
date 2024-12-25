package gettingStarted;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileuploadWithoutInputTag {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
	     BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page= browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/upload");
		FileChooser  fileChooser =	page.waitForFileChooser(() -> page.locator("#drag-drop-upload").click());
		//fileChooser.setFiles(Paths.get("C:/Users/nanda/Downloads/Payment Receipt.pdf"));
		
		Path[] files= {
				Paths.get("C:/Users/nanda/Downloads/Payment Receipt.pdf"),
				Paths.get("C:/Users/nanda/Downloads/Payment Receipt (1).pdf"),
				Paths.get("C:/Users/nanda/Downloads/Payment Receipt (2).pdf")
				};
		fileChooser.setFiles(files);
		
	}

}
