package CROSS_BROWSER_TESTING;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class baseclass {

	public WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws Exception {
        if (browser.equalsIgnoreCase("chrome")) {
        	String driverpath = System.getProperty("user.dir") + "/driver/chromedriver.exe";
    		System.setProperty("webdriver.chrome.driver", driverpath);
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
        	String driverpath = System.getProperty("user.dir") + "/driver/msedgedriver.exe";
    		System.setProperty("webdriver.chrome.driver", driverpath);
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");
        Thread.sleep(5000);
        
    }
    
    @AfterMethod
    public void tearDown() throws Exception {
    	Thread.sleep(15000);
//    	driver.close();
    	driver.quit();
    }
    
    
    
    
    
    
}
