package testNg_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test4_Priority {
 WebDriver driver;
	
	@Test(priority=1)
	public void SeleniumLaunch() throws InterruptedException {
		//Launch Browser
		 driver = new EdgeDriver();
	}
	@Test(priority=2)
	public void URL() throws InterruptedException {
		// Go to URL "https://www.saucedemo.com/"
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
	}
	@Test(priority=3)
	public void Username() throws InterruptedException {
		//Enter Username
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		Thread.sleep(3000);
	}
	@Test(priority=4)
	public void Password() throws InterruptedException {
		//Enter Password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		Thread.sleep(3000);
	}
	@Test(priority=5)
	public void Login() throws InterruptedException {
		//Click to login Button
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(3000);
	}	
	@Test(priority=6)
	public void VerifyLogin() {
		//Verify Login
		String ExpURL= "https://www.saucedemo.com/inventory.html";
		String ActualURL= driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpURL);
//		if (ExpURL.equals(ActualURL))
//		{
//			System.out.println("Login verifyed == Test Pass");
//		}
//		else 
//		{
//			System.out.println("Login Failed == Test Fail");
//		}
	}
	@Test(priority=7)
	public void CloseBrowser() {
		//Close the Browser
		driver.close();
	}
		
	}

