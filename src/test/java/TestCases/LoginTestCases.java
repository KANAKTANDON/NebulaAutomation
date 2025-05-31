package TestCases;

import org.testng.annotations.Test;

import driverInitialization.operations;
//import driverInitialization.operations;
import pages.loginPage;

public class LoginTestCases extends operations{

	@Test
	public void TC01_Login_with_Incorrect_credentials() {
		loginPage lp = new loginPage(driver);
		
		try {
			driver.get("https://demo.guru99.com/V4/index.php");
			lp.enterLoginCredentials("uname", "pwd");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
