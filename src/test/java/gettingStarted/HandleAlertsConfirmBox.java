package gettingStarted;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleAlertsConfirmBox {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
	     BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page= browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		page.onDialog(dialog -> {
			String msg=dialog.message();
			System.out.println(msg);
			Assert.assertTrue(msg.contentEquals("I am a JS prompt"));
//			dialog.accept("Nanda Kumar");
			dialog.dismiss();
		});


		page.locator("//button[text()='Click for JS Prompt']").click();
	}

}
