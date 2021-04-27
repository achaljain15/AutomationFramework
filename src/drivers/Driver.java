package drivers;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import configurations.Configuration;
import functionLibraries.ExcelFunctionLibrary;
import functionLibraries.LibraryFunctionBrowsers;

public class Driver {
	
	public LibraryFunctionBrowsers lib;
	public ExcelFunctionLibrary xlLib;
	
	
	@BeforeSuite
																																						public void oneTimeSetUp(){
		
		//e.g. Login to Dependent Machines
		//Clear Database
		//Delete Log files
		//Config files required (Web.config) to update i.e. Update any flag
		lib=new LibraryFunctionBrowsers();
		xlLib= new ExcelFunctionLibrary(Configuration.testDataPath);
		
	}

	@AfterSuite
	public void oneTimeTearDown() {
		
		//Close all connections
	}
}
