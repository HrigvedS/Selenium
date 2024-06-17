package testNg_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test7_BeforeMethodAfterMethod {
 WebDriver driver;
	
	@BeforeMethod
	public void Launch() throws InterruptedException {
		//Launch Chrome Browser
		 driver = new ChromeDriver();
	}
		
	@AfterMethod
	public void CloseBrowser() {
		//Close the Browser
		driver.close();
	}
	
	@Test(priority=1)
	public void verifyGooglePage() throws InterruptedException {
		// Go to URL "https://www.selenium.com/"
		driver.get("https://www.Google.com/");
		Thread.sleep(3000);
		//Verify Login
		String ExpTitle= "Google";
		String ActualTitle= driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpTitle);
	}
	
	@Test(priority=2)
	public void verifySeleniumPage() throws InterruptedException {
		// Go to URL "https://www.selenium.dev/"
		driver.get("https://www.selenium.dev/");
		Thread.sleep(3000);
		//Verify Login
		String ExpTitle= "Selenium";
		String ActualTitle= driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpTitle);
	}
	
	@Test(priority=3)
	public void verifyBhanuPage() throws InterruptedException {
		// Go to URL "https://bhanusaii.wordpress.com/"
		driver.get("https://bhanusaii.wordpress.com/");
		Thread.sleep(3000);
		//Verify Login
		String ExpTitle= "Bhanu Sai – “Learning gives creativity Creativity leads to thinking Thinking provides knowledge Knowledge makes you great.”";
		String ActualTitle= driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpTitle);
	}

	}

