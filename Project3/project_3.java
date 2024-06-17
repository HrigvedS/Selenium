package Project3;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class project_3 {
  @Test
  public void f() throws MalformedURLException, InterruptedException {
	//1.Define Desired Capabilities
	  DesiredCapabilities cap=new DesiredCapabilities();
	  cap.setBrowserName("chrome");; //provide browser Name
	  cap.setPlatform(Platform.WIN11); //Provide Platform Name
	  //2. Chrome Options Definition:
	  ChromeOptions options=new ChromeOptions();
	  options.merge(cap);
	  WebDriver driver=new RemoteWebDriver(new URL( "http://192.168.139.13:4444"),options);

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
  
