package utility;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

	
public class setup {
	WebDriver driver;
	final static String URL = "https://www.saucedemo.com/v1/index.html"; 
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser) {
		System.out.println("Running tests on: " + browser);

		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println("CHROME BROWSER");
			}
			else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println("EDGE BROWSER");
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				System.out.println("FIREFOX BROWSER");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void login(String username, String pass) throws Exception {
		try {
			driver.findElement(By.id("user-name")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(pass);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(5000);
			System.out.println("Login Success");
		}catch(Exception e) {
			System.out.println("Login Failed");
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
		
	}
}
