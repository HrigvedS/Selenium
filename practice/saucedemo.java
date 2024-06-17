package practice;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class saucedemo {
	WebDriver driver;
	List<WebElement> products;
	List<WebElement> price;
  @Test(priority=1)
  public void SD_Login(String Uname, String Pwd) throws InterruptedException {
	// Enter Username
		  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Uname);
		  Thread.sleep(3000);
		  
		  //Enter Password
		  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Pwd);
		  Thread.sleep(3000);
		  
		  //Click on Login
		  driver.findElement(By.xpath("//input[@id='login-button']")).click();
		  Thread.sleep(3000);
		  
		  //verify login
		  String ExpURL= "https://www.saucedemo.com/inventory.html";
		  String ActURL= driver.getCurrentUrl();
		  Assert.assertEquals(ActURL, ExpURL);
		  Thread.sleep(3000);
  }
  @Test(priority=2)
  public void productList() {
	  products = driver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
	  price = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
	  for(int i=0;i<products.size();i++) {
		  System.out.println(products);
		  for(int j=0;j<price.size();j++) {
			  System.out.println(price);
		  }
		  
	  }
	  
	  
  }
  @DataProvider(name="SD_TestData")
  public Object[][] readExcel() throws BiffException, IOException {
	  //Open excel file to read and right same for the project.
	  File f = new File("\"C:\\Users\\hrigv\\eclipse-workspace\\myFirstAutomationProject\\src\\test\\resources\\TestData_SwagDemo.xls\"");
	  Workbook w =Workbook.getWorkbook(f);
	  Sheet s= w.getSheet(0);
	  int row = s.getRows();
	  int coloums = s.getColumns();
	  
	  // Creating an array to store data of excel sheet
	  
	  String inputData[][]= new String[row-1][coloums];
	  int count=0;
	  for (int i=1;i<row;i++) {
		  
		  for(int j=1;j<coloums;j++) {
			  Cell c=s.getCell(j,i);
			  inputData[count][j]=c.getContents();
		  }
		  count ++;
	  }
	return inputData;
	  
	  
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  //Launch the Website "https://www.saucedemo.com/"
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com/");
  }

  @AfterClass
  public void afterClass() {
  }

  
}
