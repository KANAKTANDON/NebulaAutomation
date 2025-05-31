package dataDrivenTesting;


import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MAIN {

	public static void main(String[] args) throws Exception {
		
		String driverPath = System.getProperty("user.dir") + "/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		/*******************************88
		 * ACTIONS CLASS 
		 * How to perform keyboard actions CTRL, SHIFT, ALT + mouse operations
		 */
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Infosys"+Keys.ENTER);
		Thread.sleep(15000);
		System.out.println("wait over");
		String parentWindow = driver.getWindowHandle();
		
		String xpath = "(//*[text()='Infosys - Consulting | IT Services | Digital Transformation'])[1]";
		WebElement el = driver.findElement(By.xpath(xpath));
		
		Actions ac = new Actions (driver);
		ac.
		keyDown(Keys.CONTROL)
		.click(el)
		.keyUp(Keys.CONTROL)
		.perform(); 
		System.out.println("Action performed");
		
		
		/*******************************
		 * WINDOW HANDLE 
		 *******************/
		
		Set<String> handles = driver.getWindowHandles();
		
		for(String str: handles) {
			if(!str.equals(parentWindow)) {
				driver.switchTo().window(str);
				Thread.sleep(5000);
				
			}
		}
		
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		

	}

}
