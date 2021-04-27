package pages.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import functionLibraries.LibraryFunctionBrowsers;

public class HomePage {

	WebDriver driver;

	LibraryFunctionBrowsers lib=new LibraryFunctionBrowsers();

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By automobile = By.xpath("//a[@id='nav_automobile']");
	By truck = By.xpath("//div[@class='main-navigation']/ul/li/a[@id='nav_truck']");
	By motorcycle = By.xpath("//div[@class='main-navigation']/ul/li/a[@id='nav_motorcycle']");
	By camper = By.xpath("//div[@class='main-navigation']/ul/li/a[@id='nav_camper']");
	
	public void clickAutomobile() {
			driver.findElement(automobile).click();
	}

	public boolean isAutomobilePresent() {
		if (lib.checkIsElementPresent(driver, automobile))
			return true;	
		else 
			return false;		
	}
	
	public void clickTruck() {
			driver.findElement(truck).click();
	}
	
	public boolean isTruckPresent() {
		if (lib.checkIsElementPresent(driver, truck))
			return true;
		else return false;		
	}

	public void clickMotorcycle() {
driver.findElement(motorcycle).click();
	}

	public boolean isMotorcyclePresent() {
		if (lib.checkIsElementPresent(driver, motorcycle))
			return true;
		else return false;		
	}
		
	public void clickCamper() {
			driver.findElement(camper).click();
	}
	
	public boolean isCamperPresent() {
		if (lib.checkIsElementPresent(driver, camper))
			return true;
		else return false;		
	}	
}
