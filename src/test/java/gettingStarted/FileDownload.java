package gettingStarted;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileDownload {

	public static void main(String[] args) throws IOException {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		BrowserContext  browserContext =browser.newContext();
		Page page= browserContext.newPage();
		page.navigate("https://the-internet.herokuapp.com/download");
		Download download=	page.waitForDownload(()->{
			page.locator("//*[contains(text(),'testfile.txt')]").click();
		});
		
		String pathString=System.getProperty("user.dir")+"/downloadfiles/"+download.suggestedFilename();
		
		System.out.println(pathString);
		
		download.saveAs(Paths.get(pathString));
		
		if (pathString.endsWith(".txt")) {
			System.out.println("Correct file downloaded");
		}
		else 
		{
			System.out.println("wrong downloaded");
		}
		
		if(Files.size(Path.of(pathString))>0) {	
			System.out.println("file size greater than zero");
		}
		else 
		{
			System.out.println("wrong downloaded");
		}
		
		String fileDataString=	Files.readString(Path.of(pathString));
		System.out.println(fileDataString);
		
		System.out.println(download.suggestedFilename());
		System.out.println(download.url());
		System.out.println(download.path());
		
		
		page.close();
		browserContext.close();
		browser.close();
		pw.close();
	}

}
