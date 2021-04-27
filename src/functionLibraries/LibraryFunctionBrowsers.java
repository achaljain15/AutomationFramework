package functionLibraries;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import configurations.Configuration;

public class LibraryFunctionBrowsers {
	WebDriver driver;
	TakesScreenshot	screenshot;
	File src;
	String name;
	public WebDriver launchBrowser(String browser) {
	WebDriver driver= null;
		
		if(browser.equals("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			System.setProperty("webdriver.chrome.driver",Configuration.chromeDriverPath);
			driver= new ChromeDriver(options);
		}
		else if(browser.equals("Firefox"))
	{
			System.setProperty("webdriver.gecko.driver",Configuration.firefoxDriverPath);
			driver=new FirefoxDriver();
	}
		return driver;
	}
	
	/*
	 * Author : Achal hi hai
	 * Date : 22/04/2021 
	 * Description : Mere mobile k screen todi gayi thi aaj
	 * Parameters :  
	 */

	public boolean checkIsElementPresent(WebDriver driver,  By element) {
		List <WebElement> elements = driver.findElements(element);
		if (elements.size()>0)
			return true;
		else 
			return false;
		
	}
	
	public void TakesScreenshot(WebDriver driver, String fileName) throws IOException {
		screenshot=(TakesScreenshot)driver;
	src= screenshot.getScreenshotAs(OutputType.FILE);
	String timeStamp=new SimpleDateFormat("yyyy_mm_dd_HH.mm.ss").format(new Date());
	FileHandler.copy(src,new File(Configuration.screenshotPath+fileName+"_"+timeStamp+".png"));
	}
}
