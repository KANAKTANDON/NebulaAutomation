package locators;

public class loginPageLocators {

	String userid = "//*[@name='uid']";
	String pwd = "//*[@name='password']";
	
	public String getUserName() {
		return this.userid;
	}
	
	public String getPwd() {
		return this.pwd;
	}
}
