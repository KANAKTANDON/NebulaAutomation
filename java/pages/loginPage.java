package pages;

import locators.loginPageLocators;

public class loginPage extends commonMethods{
	loginPageLocators lc = new loginPageLocators();
	
	public void enterLoginCredentials(String username, String pwd) {
		
		String usernameXpath = lc.getUserName();
		String pwdXpath = lc.getPwd();
		
		enterTextByXpath(usernameXpath, username);
		enterTextByXpath(pwdXpath, pwd);
		
		
		
	}
	
}
