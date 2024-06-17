package frameworks.DataDriven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Test_DataProvider {
	public WebDriver driver;
  @Test(dataProvider="SD_TestData")
  public void sdLogin(String uname,String pwd) throws InterruptedException {
	  
	//Launch Edge Browser 
	  	WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		//Goto TestURL https://www.saucedemo.com/
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(5000);
		//Fill username textbox with input
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(uname);
		Thread.sleep(5000);
		//Fill password textbox with input
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		


		Thread.sleep(5000);
		//Click on Login Button
		
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		

		Thread.sleep(5000);
		
		String ExpURL="https://www.saucedemo.com/inventory.html";
		String ActURL=driver.getCurrentUrl();
		Assert.assertEquals(ActURL, ExpURL);
		Thread.sleep(5000);
		
  }
  
  @AfterMethod
  public void getTestResult(ITestResult testResult)
  {
	  System.out.println("TestCase Name: "+testResult.getName());

	  System.out.println("TestCase Result: "+testResult.getStatus());// Result as 1 --passed , Result as 2 --Failed 
	
	  
	  
	  int status=testResult.getStatus();
	  if(status==1)
	  {

		  //Close the Browser
		driver.close();
	  }
	  else
	  {
		/*  //Take Screenshot of Entire Screen and close browser
		 File outfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(outfile, new File("D:\\Trainings_BhanuSai\\WeekendBatch_July29th_2023\\Automation\\myAutomationProject\\src\\test\\resources\\alResourceFiles\\"+testResult.getParameters()[0]+"Defect.jpeg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		  
		//Take Screenshot of Specific Element and close browser
		  WebElement erromsg=driver.findElement(By.xpath("//*[contains(text(),'Epic sadface')]"));
			 File outfile=((TakesScreenshot)erromsg).getScreenshotAs(OutputType.FILE);
			 try {
				FileUtils.copyFile(outfile, new File("D:\\Trainings_BhanuSai\\WeekendBatch_July29th_2023\\Automation\\myAutomationProject\\src\\test\\resources\\alResourceFiles\\"+testResult.getParameters()[0]+"Defect.jpeg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		//Close the Browser
			driver.close();
	  }
			  
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
