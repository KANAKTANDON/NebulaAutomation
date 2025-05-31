package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class setupClass {

	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		String driverPath = System.getProperty("user.dir") + "/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@DataProvider(name="dimio")
	public String [][] readExcelData() throws Exception{
		String filePath = System.getProperty("user.dir") + "/testdata/selenium_data.xlsx";
		
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int totalColumns = sheet.getRow(0).getLastCellNum();
		int totalRows = sheet.getPhysicalNumberOfRows();
		
		System.out.println("Total Column: "+ totalColumns);
		System.out.println("Total Row: "+ totalRows);
		
		System.out.println("Headers: "+ sheet.getRow(0).getCell(0)+ " | "+ sheet.getRow(0).getCell(1));
		
		String [][] arr = new String [totalRows-1][totalColumns];
		for(int i=1; i<totalRows; i++) {
			for(int j=0; j<totalColumns ;j++) {
				String currentCell = sheet.getRow(i).getCell(j).toString();
				arr[i-1][j] = currentCell;
			}
		}
		
		fis.close();
		wb.close();
		
		System.out.println(Arrays.deepToString(arr));
		return arr;
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
