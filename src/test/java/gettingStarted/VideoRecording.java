package gettingStarted;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class VideoRecording {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
	BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		BrowserContext browserContext=browser.newContext(new Browser.NewContextOptions().setRecordVideoSize(500, 500).setRecordVideoDir(Paths.get("myVideos/")));
		Page page= browserContext.newPage();
		try {
			page.navigate("https://freelance-learn-automation.vercel.app/login");
			String titleOfWebpage=page.title();
			System.out.println(titleOfWebpage);
			PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
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
			
			String Path=page.video().path().toString();
			System.out.println(Path);
		} finally {
			page.close();
			browser.close();
			pw.close();
		}

	}

}
