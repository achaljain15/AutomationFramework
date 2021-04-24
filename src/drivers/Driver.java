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
		lib=new LibraryFunctionBrowsers();
		xlLib= new ExcelFunctionLibrary(Configuration.testDataPath);
		
	}

	@AfterSuite
	public void oneTimeTearDown() {
		
	}
}
