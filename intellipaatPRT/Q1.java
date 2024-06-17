package intellipaatPRT;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q1 
{

	public static void main(String[] args) throws InterruptedException, AWTException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://form.jotform.com/233611152830042");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		// Store iframe web element
				Duration timeout = Duration.ofSeconds(10);
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe")));

				WebElement iframe = driver.findElement(By.cssSelector("iframe"));
				
				// Switch context to iframe  
				driver.switchTo().frame(iframe);
				
	        //TestCase 2 – Enter valid details in all the mandatory fields like Full Name, Date of Birth, Gender, Email ID, Mobile Number etc. Values should meet the criteria set for each field, for example mobile number should be 10 digits.
	     	  driver.findElement(By.xpath("//input[@id='first_4']")).sendKeys("Hrigved"); //first name
	     	 Thread.sleep(3000);
	     	  driver.findElement(By.xpath("//input[@id='middle_4']")).sendKeys("kumar"); //middle name
	     	 Thread.sleep(3000);
	     	  driver.findElement(By.xpath("//input[@id='last_4']")).sendKeys("sharma"); //Last name
	     	 Thread.sleep(3000);
	     	  Select month = new Select(driver.findElement(By.xpath("//select[@id='input_24_month']")));
	    	  month.selectByValue("5"); //Enter month
	    	  Thread.sleep(3000);
	    	  Select day = new Select(driver.findElement(By.xpath("//select[@id='input_24_day']")));
	    	  day.selectByValue("6"); //Enter day
	    	  Thread.sleep(3000);
	  	  Select year = new Select(driver.findElement(By.xpath("//select[@id='input_24_year']")));
	  	  year.selectByValue("1998"); //Enter year
	  	Thread.sleep(3000);
	  	  Select gender = new Select(driver.findElement(By.xpath("//select[@id='input_3']")));
	  	  gender.selectByValue("Male"); //Enter Gender
	  	Thread.sleep(3000);
	  	  driver.findElement(By.xpath("//input[@id='input_23_addr_line1']")).sendKeys("XYZ Address"); //Input Address
	  	Thread.sleep(3000);
	  	  driver.findElement(By.xpath("//input[@id='input_23_addr_line2']")).sendKeys("XYZ street"); //Input StreetAddress
	  	Thread.sleep(3000);
	  	  driver.findElement(By.xpath("//input[@id='input_23_city']")).sendKeys("Vidisha"); //Input city
	  	Thread.sleep(3000);
	  	  driver.findElement(By.xpath("//input[@id='input_23_state']")).sendKeys("Madhya Pradesh"); //Input state
	  	Thread.sleep(3000);
	  	  driver.findElement(By.xpath("//input[@id='input_23_postal']")).sendKeys("464001"); //Input state
	  	Thread.sleep(3000);
	  	  driver.findElement(By.xpath("//input[@id='input_6']")).sendKeys("sharma.hrigved@gmail.com"); //Input Email
	  	Thread.sleep(3000);
	  	driver.findElement(By.xpath("//input[@id='input_27_full']")).sendKeys("8839115611"); //Input Phone number
	  	Thread.sleep(3000);
	  	  driver.findElement(By.xpath("//input[@id='input_25_full']")).sendKeys("8839115621"); //Input Phone number
	  	Thread.sleep(3000);
	  	  driver.findElement(By.xpath("//input[@id='input_26_full']")).sendKeys("8109790438"); //Input Phone number
	  	Thread.sleep(3000);
	  	  driver.findElement(By.xpath("//input[@id='input_14']")).sendKeys("Intellipat"); //Input Company
	  	Thread.sleep(3000);
	  	  Select course = new Select(driver.findElement(By.xpath("//select[@id='input_46']")));
	  	  course.selectByValue("selenium "); //Enter course
	  	Thread.sleep(3000);
	  	
	  	 //Test Case3: Upload a resume file
	  	//Click on Choos file Button
	  	driver.findElement(By.xpath("//div[@class='inputContainer']")).click();
	  	Thread.sleep(3000);
	  	
	  	//Put the data into clipboard
	  	StringSelection S= new StringSelection("\"C:\\Users\\hrigv\\Desktop\\Hrigved QA .pdf\"");
	  	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(S,null);
	  	
	  	//Implementing JAVA robot
	  	Robot r=new Robot();
	  	
	  	//paste operation ctrl + v
	  	r.keyPress(KeyEvent.VK_CONTROL);
	  	r.keyPress(KeyEvent.VK_V);
	  	r.keyRelease(KeyEvent.VK_V);
	  	r.keyRelease(KeyEvent.VK_CONTROL);
	  	Thread.sleep(3000);
	  	
	  	//Click enter
	  	r.keyPress(KeyEvent.VK_ENTER);
	  	r.keyRelease(KeyEvent.VK_ENTER);
	  	Thread.sleep(12000);

	    //TestCase 4 - In the Joining Date field, enter a valid future date in DD/MM/YYYY format as mentioned in the form.
	      driver.findElement(By.xpath("//label[@id='label_55']/following::*[2]")).click();
	      
	      
	   // TestCase 5 - Once all details are filled, click on the Submit button at the bottom of the form.
	      driver.findElement(By.xpath("//button[text()='Submit']"));
	      
	        //TestCase6- Close the browser
	        driver.quit();
	    }
	}
