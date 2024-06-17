package testNg_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Test2_CheckPoints {

	@Test
	public void SeleniumLaunch() throws InterruptedException {
		//Launch Browser
		WebDriver driver = new EdgeDriver();
		
		// Go to URL "https://www.selenium.dev"
		driver.get("https://www.selenium.dev");
		Thread.sleep(3000);
		
		//Expected Title
		
		String ExpTitle= "Selenium";
		String ActualTitle= driver.getTitle();
		
		if(ActualTitle.equals(ExpTitle))
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
