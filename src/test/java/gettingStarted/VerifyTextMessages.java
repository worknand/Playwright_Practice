package gettingStarted;

import java.util.regex.Pattern;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class VerifyTextMessages {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		Page page= browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.getByText("Sign in").last().click();
		String expected="Email and Password is required";
	    String actual=	page.locator(".errorMessage").textContent();
	    System.out.println(actual);
	    
	    String actualnew=	page.locator(".errorMessage").innerText();
	    System.out.println(actualnew);
	    
	    //using console window
	    String actualviaJS=	(String) page.evaluate("document.getElementsByClassName('errorMessage')[0].textContent");
	    System.out.println(actualviaJS);
	    
	    Assert.assertEquals(actual, expected);
	    
	    Assert.assertTrue(actual.contains("Email and Password"));
	    //exact match
	    PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText("Email and Password is required");
	    //partial match
	    PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText(Pattern.compile("required"));
	    
	    
	    
	    page.close();
		browser.close();
		pw.close();

	}

}
