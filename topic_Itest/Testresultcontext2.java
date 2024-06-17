package topic_Itest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testresultcontext2 {
	WebDriver driver;
	@Parameters({"browser"})
  @BeforeMethod
  public void setup(String Browser) throws InterruptedException {
	  System.out.println("My setup methods");
	  
	//  String Browser=testcontext.getCurrentXmlTest().getParameter("browser");
	  if(Browser.equals("edge"))
	  {
		 driver=new EdgeDriver();
	  }
	  else if(Browser.equals("chrome"))
	  {
		 driver=new ChromeDriver();
	  }
	  else if(Browser.equals("ff"))
	  {
		 driver=new FirefoxDriver();
	  }
	}
	
	@Parameters({"Username","Password"})
	@Test
	public void sdLogin(String uname,String pwd) throws InterruptedException
	{
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
	public void tearDown()
	{
		//Close the browser
		  driver.close();
	}
}
