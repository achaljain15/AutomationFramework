package configurations;
// This class is used for all reusable common path, data and variables
public class Configuration {
	
	public static final String  url="http://sampleapp.tricentis.com/101/";
	public static final String chromeDriverPath=System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe";
	public static final String firefoxDriverPath=System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe";
	public static final String testDataPath= System.getProperty("user.dir")+"\\testData\\TestData.xlsx";
	public static final String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\";
}
