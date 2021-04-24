package functionLibraries;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import configurations.Configuration;

public class LibraryFunctionBrowsers {
	WebDriver driver;
	public WebDriver launchBrowser(String browser) {
//		WebDriver driver= null;
		
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
	
	
	public boolean checkIsElementPresent(WebDriver dr,  By element) {
		List <WebElement> elements = dr.findElements(element);
		if (elements.size()>0)
			return true;
		else return false;
		
	}

}
