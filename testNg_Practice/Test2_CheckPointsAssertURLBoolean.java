package testNg_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Test2_CheckPointsAssertURLBoolean {

	
	@Test
	public void SeleniumLaunch() throws InterruptedException {
		//Launch Browser
		WebDriver driver = new EdgeDriver();
		
		// Go to URL "https://www.selenium.dev"
		driver.get("https://www.selenium.dev");
		Thread.sleep(3000);
		
		//Expected Title
		boolean textPresent= driver.findElement(By.xpath("//h1[contains(text(),'Selenium')]")).isDisplayed();
		System.out.println(textPresent);
	
		if(textPresent==true)
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
