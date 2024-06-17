package testNg_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2_CheckPointsAssertURL {

	@Test
	public void SeleniumLaunch() throws InterruptedException {
		//Launch Browser
		WebDriver driver = new EdgeDriver();
		
		// Go to URL "https://www.selenium.dev"
		driver.get("https://www.selenium.dev");
		Thread.sleep(3000);
		
		//Expected Title
		
		String ExpURL= "https://www.selenium.dev";
		String ActualURL= driver.getCurrentUrl();
		Assert.assertEquals(ExpURL, ActualURL);
		if(ActualURL.equals(ExpURL))
		{
			System.out.println("Launch Selenium Page - PASS");
		}
		else
		{
			System.out.println("Launch Selenium Page - Fail");
		}
		Thread.sleep(3000);
		//Close the Browser
		driver.close();
		
		
	}
}
