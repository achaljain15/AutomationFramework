package testScripts.Home;

import org.testng.Assert;
import org.testng.ITestResult;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import configurations.Configuration;
import drivers.Driver;
import pages.Home.HomePage;

public class TC_HomePage_Validation extends Driver {
	WebDriver driver;
	HomePage homepage;
//
//	pages.Automobile.EnterVehicleData automobileEnterVehicleData;
//	pages.Truck.EnterVehicleData truckEnterVehicleData;
//	pages.Motorcycle.EnterVehicleData motorcycleEnterVehicleData;
//	pages.Camper.EnterVehicleData camperEnterVehicleData; 
	
	//EnterInsurantData automobileEnterInsuranceData;	
	
	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		
	//launchBrowser is returning WebDriver which is used to perform actions further and is assigned to local driver here
	driver=lib.launchBrowser(browser);
	homepage=new HomePage(driver);
		
		automobileEnterVehicleData= new pages.Automobile.EnterVehicleData(driver);
		truckEnterVehicleData= new pages.Truck.EnterVehicleData(driver);
		motorcycleEnterVehicleData =new pages.Motorcycle.EnterVehicleData(driver);
		camperEnterVehicleData=new pages.Camper.EnterVehicleData(driver);
	}

	
	@BeforeMethod
	public void navigate() {
		driver.get(Configuration.url);
	}
	
	@Test
	public void testAutomobileLink() throws InterruptedException, IOException {
	Thread.sleep(2000);
	System.out.println("Yaaha tak aagaya");
	lib.TakesScreenshot(driver,"Achal");
	Assert.assertTrue(homepage.isAutomobilePresent(),"Nahi h bhai automobile");
	homepage.clickAutomobile();
	lib.TakesScreenshot(driver,"Achal");
	Assert.assertTrue( automobileEnterVehicleData.isMakePresent(), "Automobile page par hai apan loog");
	
	}
	
	  @Test public void testCamperLink() {
	 
	  }
	  
	  @Test public void testMotorCycleLink() {
	  
	  }
	  
	  @Test public void testTruckLink() {
	  
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
	public void  tearDown() {
		driver.close();
	}
}
