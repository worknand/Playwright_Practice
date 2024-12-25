package playwrightNAL;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class Fileupload {

	public static void main(String[] args) throws InterruptedException {
		Playwright pw=	Playwright.create();
	     BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page= browser.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		//page.locator("//input[@id='filesToUpload']").setInputFiles(Path.of("C:/Users/nanda/Downloads/Payment Receipt.pdf"));
		
		// input tag should type=file
		//single file select
		//single file remove
		
//        page.setInputFiles("//input[@id='filesToUpload']", Paths.get("applogin.json"));
//        Thread.sleep(2000);
//        page.setInputFiles("//input[@id='filesToUpload']", new Path[0]);
//        
//        
//        // multiple file select
//        page.setInputFiles("//input[@id='filesToUpload']", new Path[] {
//        		Paths.get("C:/Users/nanda/Downloads/Payment Receipt.pdf"),
//				Paths.get("C:/Users/nanda/Downloads/Payment Receipt (1).pdf"),
//				Paths.get("C:/Users/nanda/Downloads/Payment Receipt (2).pdf")	
//        });
//        
//        
//        Thread.sleep(2000);
//        page.setInputFiles("//input[@id='filesToUpload']", new Path[0]);
        
        //runtime file upload
        page.setInputFiles("//input[@id='filesToUpload']", new FilePayload("nanda.txt", "text/plain", "Hello World!!!".getBytes(StandardCharsets.UTF_8)));
	}

}
