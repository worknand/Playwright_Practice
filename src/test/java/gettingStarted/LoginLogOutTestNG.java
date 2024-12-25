package gettingStarted;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class LoginLogOutTestNG {
@Test
	public void loginTest() {
		Playwright pw=	Playwright.create();
		 BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page= browser.newPage();
		try {
			page.navigate("https://freelance-learn-automation.vercel.app/login");
			String titleOfWebpage=page.title();
			System.out.println(titleOfWebpage);
		PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
			Assert.assertTrue(page.title().contains("Learn Automation Courses"));
//			page.locator("#email1").fill("nandunanda0728@gmail.com");
//			page.locator("xpath=//input[@name='password1']").fill("Hello@123");
//			page.locator("//button[@type='submit']").click();	
			page.getByPlaceholder("Enter Email").fill ("nandunanda0728@gmail.com");
			page.getByPlaceholder("Enter Password").fill ("Hello@123");
			//page.locator("//button[@type='submit']").click();
//			page.getByText("Sign in").nth(1).click();
			page.getByText("Sign in").last().click();
		    PlaywrightAssertions.assertThat(page.locator("//*[text()='Cypress']")).containsText("Cypress");
		    //page.locator("//*[@alt='menu']").click();
		    page.getByAltText("menu").click();
		    page.getByText("Sign out").click();
			PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
		} finally {
			page.close();
			browser.close();
			pw.close();
		}
	
		

	}

}
