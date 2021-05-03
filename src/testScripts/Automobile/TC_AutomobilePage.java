package testScripts.Automobile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import configurations.Configuration;
import drivers.Driver;
import pages.Home.HomePage;

public class TC_AutomobilePage extends Driver {
	WebDriver driver;
	HomePage homepage;

	String name = new SimpleDateFormat("yyyy_mm_dd_HH.mm.ss").format(new Date());

	ExtentReports repo = new ExtentReports();

	pages.Automobile.EnterVehicleData automobileEnterVehicleData;
	pages.Truck.EnterVehicleData truckEnterVehicleData;
	pages.Motorcycle.EnterVehicleData motorcycleEnterVehicleData;
	pages.Camper.EnterVehicleData camperEnterVehicleData;

	By make = By.id("make");
	By enginePerformance = By.id("engineperformance");
	By date = By.id("dateofmanufacture");
	By seats = By.id("numberofseats");
	By fuel = By.id("fuel");
	By listPrice = By.id("listprice");
	By LicensePlate = By.id("licenseplatenumber");
	By Mileage = By.id("annualmileage");
	By firstNext = By.id("nextenterinsurantdata");

	By automobileLink = By.xpath("//div[@class='main-navigation']/ul/li/a[@id='nav_automobile']");
	// EnterInsurantData automobileEnterInsuranceData;

	@BeforeClass
	public void setUp() {

		// launchBrowser is returning WebDriver which is used to perform actions further
		// and is assigned to local driver here
		this.driver = lib.launchBrowser("Chrome");
		homepage = new HomePage(driver);
		automobileEnterVehicleData = new pages.Automobile.EnterVehicleData(driver);
		driver.get(Configuration.url);
	}

	@BeforeMethod
	public void navigate() {

	}

	@Test
	public void testAutomobileClicked() {
		automobileEnterVehicleData.clickElement(driver, automobileLink);
		Assert.assertTrue(automobileEnterVehicleData.isselectedAutomobilePagePresent(), "Automobile page is selected");
	}

	@Test(dependsOnMethods = { "testAutomobileClicked" })
	public void EnterVehicleDataisSelected() {
		automobileEnterVehicleData.clickElement(driver, automobileLink);
		Assert.assertTrue(automobileEnterVehicleData.isMakePresent(), "Enter Vehicle Data is not ready for inputs");
	}

	@Test(dependsOnMethods = "EnterVehicleDataisSelected")
	public void elementsCheck() {
//		String path="C:\\Users\\ssand\\eclipse-workspace\\Automation Framework\\Screenshots\\"+name+"_Testing.html";
//		ExtentHtmlReporter reporter= new ExtentHtmlReporter(path);
//		repo.attachReporter(reporter);
//		ExtentTest test1=repo.createTest("elementsCheck");
		if (automobileEnterVehicleData.allElementsPresent())
			System.out.println("Elements are present");
		// test1.pass("All elements present. Enter data");
		// else
		// test1.fail("Invalid page");
	}

	@Test(dependsOnMethods = "elementsCheck")
	public void enterDetails() {
		automobileEnterVehicleData.fillDetails("BMW", "3000", "RW1354");
	}
	
	 @AfterMethod
	  public void afterMethodStatus(ITestResult result) throws IOException {
		  if (result.getStatus()==ITestResult.SUCCESS)
			try {
				lib.TakesScreenshot(driver, result.getName());	  
			}
		  catch (Exception e) {
			  System.out.println(e.getMessage());
		  }
		  
	  }

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
