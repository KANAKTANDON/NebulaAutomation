package utility;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class testclass extends setup{

	@Test
	public void TC01_Login_CorrectUser() throws Exception {
		login("standard_user", "secret_sauce");
	}
	
	@Test
	public void TC02_Login_InCorrectUser() throws Exception{
		login("standard_user", "secret_sauc");
	}
}
