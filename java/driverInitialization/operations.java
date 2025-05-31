package driverInitialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class operations {

	 public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		String driverpath = System.getProperty("user.dir") + "/chromedriver129.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
}
