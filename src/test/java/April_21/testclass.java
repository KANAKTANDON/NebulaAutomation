package April_21;

import org.testng.annotations.Test;

public class testclass extends setupClass{

	@Test(groups = {"smoke"})
	public void TC_01() {
		driver.get("https://www.google.co.in/");
	}
	
	@Test
	public void TC_02() {
		driver.get("https://www.wikipedia.org/");
	}
}
