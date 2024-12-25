package gettingStarted;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;

public class Utility {

	public static byte[] captureScreenshot(Page page) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yy_MM_dd_HH_mm_ss");
		
		Date date=new Date();
		
	    String timeStamp=dateFormat.format(date);
		
		byte[] b=page.screenshot(new ScreenshotOptions().setPath(Paths.get("screenshots/"+timeStamp+".png")).setFullPage(true));
		return b;
		

	}

}
