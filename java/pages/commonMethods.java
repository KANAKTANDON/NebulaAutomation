package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverInitialization.operations;

public class commonMethods extends operations{

	public void enterTextByXpath(String xpath, String value) {
		
		try {
			WebElement e = driver.findElement(By.xpath(xpath));
			e.sendKeys(value);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void scrollDownOnce() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	
	
	
	
	/*************
	 * EXPLICIT WAIT METHOD
	 ************/
	
	public void waitUntilElementFound(int seconds, String xpath) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			WebElement e = driver.findElement(By.xpath(xpath));
			wait.until(ExpectedConditions.visibilityOf(e));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
