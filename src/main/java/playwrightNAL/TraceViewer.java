package playwrightNAL;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

// to open traceviewer
//https://trace.playwright.dev/ 
//else use command mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"


public class TraceViewer {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
   // Start tracing before creating / navigating a page.
      context.tracing().start(new Tracing.StartOptions()
        .setScreenshots(true)
        .setSnapshots(true)
        .setSources(true));
      Page page = context.newPage();
      page.navigate("https://academy.naveenautomationlabs.com/");
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
      page.locator("#microfe-popup-login").contentFrame().getByText("Sign up").click();
      page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Name").click();
      page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Name").fill("Nanda");
      page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Email address").click();
      page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Email address").fill("Nanda@gmail.com");
      page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Password").click();
      page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Password").fill("nanda");
      page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Enter your number").click();
      page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Enter your number").fill("+91 12345-67890");
      page.locator("#microfe-popup-login").contentFrame().locator("#loginPopupCloseBtn svg").click();
      page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
      page.locator("#microfe-popup-login").contentFrame().locator("#loginPopupCloseBtn svg").click();
      
   // Stop tracing and export it into a zip archive.
      context.tracing().stop(new Tracing.StopOptions()
        .setPath(Paths.get("trace.zip")));
    }
  }
}
