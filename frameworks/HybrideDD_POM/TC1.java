package frameworks.HybrideDD_POM;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TC1 {
	WebDriver driver;
	Page_Login login;
  @Test(dataProvider="SD_TestData")
  public void verify_sdLogin(String uname,String pwd) throws InterruptedException {
	//Launch Edge Browser 
		driver=new EdgeDriver();
		//Goto TestURL https://www.saucedemo.com/
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(5000);
		login=new Page_Login(driver);
		//Fill username textbox with input 
		login.type_Username(uname);
		//Fill Password textbox with input
		login.type_Password(pwd);
		//Click on login button
		login.click_Login();
		driver.close();
		
		
  }
  
  
  
  @DataProvider(name="SD_TestData")
  public Object[][] readExcel() throws BiffException, IOException
  {
	  //Open the Excel File for read and write which is available in same project
	File f=new File("D:\\Trainings_BhanuSai\\WeekendBatch_July29th_2023\\Automation\\myAutomationProject\\src\\test\\resources\\alResourceFiles\\TestData_SwagDemo.xls");
	Workbook w=Workbook.getWorkbook(f);	
	Sheet s=w.getSheet(0);
	int noofrows=s.getRows();
	int noofColumns=s.getColumns();
	
	//Creating an Array to store data of an excel sheet
	String inputData[][]=new String[noofrows-1][noofColumns];
	int count=0;
	for(int i=1;i<noofrows;i++)
	{
		for (int j=0;j<noofColumns;j++)
		{
			Cell c=s.getCell(j,i);
			inputData[count][j]=c.getContents();
			
		}
		count++;
	}
	return inputData;
	
	
  }
  
}
