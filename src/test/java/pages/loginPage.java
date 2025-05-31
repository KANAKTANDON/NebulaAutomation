package pages;

import org.openqa.selenium.WebDriver;

import driverInitialization.operations;
import locators.loginPageLocators;

public class loginPage extends operations{
	commonMethods cm ;
	public loginPage(WebDriver driver) {
		this.driver = driver;
		 cm = new commonMethods(driver);
	}
	
	loginPageLocators lc = new loginPageLocators();
	 
	
	public void enterLoginCredentials(String username, String pwd) {
		
		String usernameXpath = lc.getUserName();
		String pwdXpath = lc.getPwd();
		
		cm.enterTextByXpath(usernameXpath, username);
		cm.enterTextByXpath(pwdXpath, pwd);
	}
	
}
