package testing;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import functionLibraries.LibraryFunctionBrowsers;

public class CaptureScreenshot {
WebDriver driver;
	@Test
	public void captureScreenshot() throws IOException {
	
		LibraryFunctionBrowsers lib=new LibraryFunctionBrowsers();
		driver=lib.launchBrowser("Chrome");
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File src= screenshot.getScreenshotAs(OutputType.FILE);
		String name=new SimpleDateFormat("yyyy_mm_dd_HH.mm.ss").format(new Date());
		
		FileHandler.copy(src,new File("C:\\Users\\ssand\\eclipse-workspace\\Automation Framework\\Screenshots\\"+name+"_Testing.png"));
		
	}
	
	
}
