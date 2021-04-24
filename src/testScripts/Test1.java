package testScripts;

import org.testng.annotations.Test;

import drivers.Driver;

public class Test1 extends Driver {
	
	@Test
	public void test1() {
		lib.launchBrowser("Chrome");
	}

}
