package testscript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.PredefinedActions;

public class TestBase {
	@BeforeMethod
	public void setUp(){
		System.out.println("STEP - Open Browser");
		PredefinedActions.start();
		
	}
	@AfterMethod
	public void teardown() {
		System.out.println("STEP - close Browser");
		PredefinedActions.close();
		
		
	}

}
