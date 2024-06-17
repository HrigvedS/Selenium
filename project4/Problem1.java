/*• Search for ‘Mobile Phone’ on the ‘flipkart.com’ homepage.
• Fetch all the mobile phones listed in the product listing page along with their prices
and output them to an excel file and store them inside folder ‘testresult’ in
‘src/test/resources’*/

package project4;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Problem1 {
	WebDriver driver;
	FlipkartPageElements element;
	
	
  @Test
  public void setup() throws InterruptedException, IOException {
	  driver= new ChromeDriver();
	  
	  
	  //Go to test URL "https://www.flipkart.com/"
	  driver.get("https://www.flipkart.com/");
	  driver.manage().window().maximize();
	  element = new FlipkartPageElements(driver); 
	  Thread.sleep(3000);
	  
	  //Dissmiss the login page as it needs OTP to login.
	  element.loginpage();
	  
	  //Search for Iphone 12 in searchBar
	  element.searchBox("Mobile Phone");
	  Thread.sleep(3000);
	  
	  
	 XSSFWorkbook workbook= new XSSFWorkbook();
	 XSSFSheet sheet1 = workbook.createSheet("Sheet1");
	 
	// Find all mobile phone elements on the page
     java.util.List<WebElement> mobilePhones = driver.findElements(element.mobilePhone);
	 
     int rownum = 0;

     // Iterate through mobile phone elements and extract data
     for (WebElement mobilePhone : mobilePhones) {
         String name = mobilePhone.findElement(element.mobilePhone).getText();
         String price = mobilePhone.findElement(element.mobilePrice).getText();

         Row row = sheet1.createRow(rownum++);
         row.createCell(0).setCellValue(name);
         row.createCell(1).setCellValue(price);
     }

     
	Row r= sheet1.createRow(0);
	Cell c= r.createCell(0);
	c.setCellValue("");
	
	File f= new File("C:\\Users\\hrigv\\eclipse-workspace\\myFirstAutomationProject\\src\\test\\java\\project4\\mobilePhoneData.xls");
	  FileOutputStream fos = new FileOutputStream(f);
	  workbook.write(fos);
	  fos.close();
	  workbook.close();
	  //close the browser
	  driver.close();
	
  }
}
