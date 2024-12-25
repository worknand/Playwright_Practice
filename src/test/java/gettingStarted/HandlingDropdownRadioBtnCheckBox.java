package gettingStarted;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class HandlingDropdownRadioBtnCheckBox {

	public static void main(String[] args) {
		Playwright pw=	Playwright.create();
		BrowserType  browserType=	pw.chromium();
//		  BrowserType  browserType= pw.firefox();
//			BrowserType  browserType= pw.webkit();
		Browser  browser= browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page= browser.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		page.locator("//a[text()='New user? Signup']").click();
		
		page.pause();
		
		page.locator("//*[@class='submit-btn']");
		PlaywrightAssertions.assertThat(page.locator("//*[@class='submit-btn']")).isDisabled();
		page.locator("#name").fill("Nanda");
		//page.locator("#email").fill("Nanda");
		page.locator("#password").fill("Nanda");
		//page.getByPlaceholder("email").fill("Nanda");
		page.getByPlaceholder("email").fill("Nanda_"+System.currentTimeMillis()+"@yahoo.com");
		
		page.locator("//*[text()='Selenium']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='Selenium']//..//input")).isChecked();
		page.locator("//*[text()='AWS']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='AWS']//..//input")).isChecked();
		page.locator("//*[text()='SQL']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='SQL']//..//input")).isChecked();
		page.locator("//*[text()='Jenkins']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='Jenkins']//..//input")).isChecked();
		page.locator("//*[text()='AWSssttt']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='AWSssttt']//..//input")).isChecked();
		page.locator("//*[text()='AWSssttt_19_30_11_24_09_2024']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='AWSssttt_19_30_11_24_09_2024']//..//input")).isChecked();
		page.locator("//*[text()='Cypress']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='Cypress']//..//input")).isChecked();
		page.locator("//*[text()='Playwright']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='Playwright']//..//input")).isChecked();
		page.locator("//*[text()='Grid']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='Grid']//..//input")).isChecked();
		page.locator("//*[text()='Java']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='Java']//..//input")).isChecked();
		page.locator("//*[text()='AWSssttt_19_19_34_24_09_2024']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='AWSssttt_19_19_34_24_09_2024']//..//input")).isChecked();
		page.locator("//*[text()='AWSssttt_19_32_35_24_09_2024']//..//input").click();
		PlaywrightAssertions.assertThat(page.locator("//*[text()='AWSssttt_19_32_35_24_09_2024']//..//input")).isChecked();
		page.locator("//input[@value='Female']").click();
		PlaywrightAssertions.assertThat(page.locator("//input[@value='Female']")).isChecked();
		
		page.locator("#state").selectOption("Tamil Nadu");
		
		String hobbies[]= {"Playing","Swimming","Dancing"};
		page.locator("#hobbies").selectOption(hobbies);
		
		PlaywrightAssertions.assertThat(page.locator("//*[@class='submit-btn']")).isEnabled();
		
		
		page.close();
		browser.close();
		pw.close();

	}

}
