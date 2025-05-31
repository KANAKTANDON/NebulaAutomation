package April_21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class setupClass {

	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		String driverPath = System.getProperty("user.dir") + "/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
}
