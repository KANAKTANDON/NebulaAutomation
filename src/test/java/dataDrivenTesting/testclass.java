package dataDrivenTesting;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class testclass extends setupClass{

	@Test(dataProvider = "dimio")
	public void TC01(String username, String password) throws Exception {
		driver.get("https://www.saucedemo.com/v1/");
		System.out.println("current userid: "+username);
		System.out.println("current password: "+password);
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(5000);
	}
}
