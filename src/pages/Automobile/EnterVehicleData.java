package pages.Automobile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import functionLibraries.LibraryFunctionBrowsers;

public  class EnterVehicleData {
	
	LibraryFunctionBrowsers lib=new LibraryFunctionBrowsers();
	WebDriver driver;
	public EnterVehicleData(WebDriver dr) {
	this.driver=dr;	
	}
	
	//WebElements
	//1. Make
	By make=By.xpath("//select[@id='make']");
	By engineeringPerformance=By.id("engineperformance");
	
	public boolean isMakePresent() {
		if(lib.checkIsElementPresent(driver, make))
			return true;
		else return false;
	}
	
	public boolean isEngineerPerformancePresent() {
		if(lib.checkIsElementPresent(driver, engineeringPerformance))
			return true;
		else return false;
	}
	
	
	//Actions
	public void enterEngineeringPerformance(int data) {
		driver.findElement(engineeringPerformance).sendKeys(""+data);
	}
	
}
