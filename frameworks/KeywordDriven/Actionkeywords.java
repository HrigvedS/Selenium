package frameworks.KeywordDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Actionkeywords {
	public static WebDriver driver;
  @Test(priority=0)
  public static void openBrowser() {
	//Launch Edge Browser 
		 driver=new EdgeDriver();
  }
  @Test(priority=1)
  public static void navigate() throws InterruptedException
  {
	//Goto TestURL https://www.saucedemo.com/
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(5000);
  }
  
  @Test(priority=2)
  public static void inputUserName() throws InterruptedException
  {
	//Fill username textbox with input
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		Thread.sleep(5000);
  }
  @Test(priority=3)
  public static void inputPassword() throws InterruptedException
  {

		//Fill password textbox with input
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		Thread.sleep(5000);
  }
  @Test(priority=4)
  public static void clickSigin() throws InterruptedException
  {

	//Click on Login Button
		
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		Thread.sleep(5000); 
		}
  
  @Test(priority=5)
  public static void closeBrowser() throws InterruptedException
  {
	//Close the Browser
		driver.close();
  }
  
}
