package driverInitialization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class operations {

	 public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		String driverpath = System.getProperty("user.dir") + "/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
}
