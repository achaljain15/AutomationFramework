package pages.Automobile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import functionLibraries.LibraryFunctionBrowsers;
import pages.Home.HomePage;

public class EnterVehicleData {

	LibraryFunctionBrowsers lib = new LibraryFunctionBrowsers();
	WebDriver driver;
	HomePage homepage = new HomePage(driver);

	public EnterVehicleData(WebDriver dr) {
		this.driver = dr;
	}

	// WebElements
	// 1. Make
	By make = By.id("make");
	By enginePerformance = By.id("engineperformance");
	By date = By.id("dateofmanufacture");
	By seats = By.id("numberofseats");
	By fuel = By.id("fuel");
	By listPrice = By.id("listprice");
	By LicensePlate = By.id("licenseplatenumber");
	By Mileage = By.id("annualmileage");
	By firstNext = By.id("nextenterinsurantdata");
	By selectedAutomobilePage = By.id("entervehicledata");
	By calendarSymbol = By.xpath("//*[@id=\"opendateofmanufacturecalender\"]/i");
	By prevCalendarScroll= By.xpath("//a[@data-handler='prev']");
	
	String month;
	String year;
	String monthYear;
	
	public boolean isselectedAutomobilePagePresent() {
		// TODO Auto-generated method stub if(lib.checkIsElementPresent(driver,
		// enginePerformance))
		if (lib.checkIsElementPresent(driver, selectedAutomobilePage))
			return true;
		else
			return false;
	}

	public boolean isMakePresent() {
		if (lib.checkIsElementPresent(driver, make))
			return true;
		else
			return false;
	}

	// Actions

	public boolean allElementsPresent() {
		boolean flag = false;
		if (lib.checkIsElementPresent(driver, date))
			if (lib.checkIsElementPresent(driver, seats))
				if (lib.checkIsElementPresent(driver, fuel))
					if (lib.checkIsElementPresent(driver, listPrice))
						if (lib.checkIsElementPresent(driver, LicensePlate))
							if (lib.checkIsElementPresent(driver, Mileage))
								if (lib.checkIsElementPresent(driver, firstNext))
									flag = true;
								else
									flag = false;
		return flag;
	}

	public void fillDetails(String car, String ePerform, String License) {
		Select select = new Select(driver.findElement(make));
		select.selectByValue(car);
		driver.findElement(enginePerformance).sendKeys(ePerform);
		driver.findElement(LicensePlate).sendKeys(License);
		driver.findElement(calendarSymbol).click();
		monthYear = month + " " + year;
		do {
			driver.findElement(prevCalendarScroll).click();
			month =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			monthYear = month + " " + year;
		} while (!monthYear.equals("January 2021"));
		WebElement dateSelect=driver.findElement(By.xpath("//td[@data-month='0']/a[text()='2']"));
		dateSelect.click();
		System.out.println(driver.findElement(By.id("dateofmanufacture")).getText());
		
		driver.findElement(seats).click();
		select=new Select(driver.findElement(seats));
		select.selectByValue("4");
		select=new Select(driver.findElement(fuel));
		driver.findElement(fuel).click();
		select.selectByValue("Petrol");
	}

	public void enterEngineeringPerformance(int data) {
		driver.findElement(enginePerformance).sendKeys("" + data);
	}

	public void clickElement(WebDriver driver, By element) {
		driver.findElement(element).click();
	}

}
