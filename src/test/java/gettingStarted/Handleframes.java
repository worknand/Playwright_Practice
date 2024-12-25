package gettingStarted;

import java.util.List;
import java.util.regex.Pattern;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Handleframes {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
	//		BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page= browser.newPage();
		page.navigate("https://www.redbus.in/");
		page.locator("//li[@id='account_dd']").click();
		page.locator("//li[@id='user_sign_in_sign_up']").click();
		List<Frame> allFrames =	page.frames();
		System.out.println(allFrames.size());
		//frame using locator
//		FrameLocator frame=	page.frameLocator("iframe.modalIframe");
//		frame.locator("//input[@id='mobileNoInp']").last().fill("1234567890");
//		page.frameLocator("iframe.modalIframe").last().locator("//input[@id='mobileNoInp']").last().fill("1234567890");
		
		//frame using url 
		page.frameByUrl(Pattern.compile(".*login.*")).locator("//input[@id='mobileNoInp']").last().fill("1234567890");

	}

}
