package testNg_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1_ChromeTest {

  @Test
		public void Setup() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		
//* TC2- GO TO TEST URL HTTPS://WWW.SELENIUM.DEV
		driver.get("HTTPS://WWW.SELENIUM.DEV");
//wait time
		Thread.sleep(5000);
//* TC3- MINIMIZE THE BROWSER WINDOW
		driver.manage().window().minimize();
//wait time
		Thread.sleep(5000);
//* TC-4 MAXIMIZE THE BROWSER WINDOW
		driver.manage().window().maximize();
//wait time
		Thread.sleep(5000);
//* TC-5 GET THE TITLE OF THE PAGE
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);
//wait time
		Thread.sleep(5000);
//* TC-6 GET THE CURRENT URL OF THE PAGE
		String PageUrl=driver.getCurrentUrl();
		System.out.println(PageUrl);
//wait time
		Thread.sleep(5000);	
//* TC-7 CLOSE THE BROWSER
		driver.close();
		
  }
}
