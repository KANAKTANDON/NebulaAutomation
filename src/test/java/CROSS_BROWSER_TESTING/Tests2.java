package CROSS_BROWSER_TESTING;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Tests2 extends baseclass {

	@Test
	public void TC01() throws Throwable {
		
		
		
		/*************************************888
		 * WRITE A PROGRAM TO SELECT ALL OPTIONS ONE BY ONE
		 */
		WebElement e = driver.findElement(By.id("inputGroupSelect03"));
		Select sel = new Select(e);
		List<WebElement> dropdown = sel.getOptions();
		
		for(WebElement i: dropdown) {
			
			try {
				if(i.isEnabled()) {
					String currentdropdownOption = i.getText().trim();
					sel.selectByVisibleText(currentdropdownOption);
					Thread.sleep(1000);
				}
			}catch(Exception error) {
				System.out.println("ISSUE WITH: "+ i.getText());
				error.printStackTrace();
			}
			
		}
		
}
}
