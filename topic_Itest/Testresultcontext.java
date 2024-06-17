package topic_Itest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Testresultcontext {
	WebDriver driver;
  @Test
  public void setup(ITestContext testcontext) throws InterruptedException {
	  System.out.println("My setup methods");
	  String Browser=testcontext.getCurrentXmlTest().getParameter("browser");
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
	  
	  //Goto Test URL
	  driver.get("https://www.selenium.dev");
	  Thread.sleep(5000);
	  //Close the browser
	  driver.close();
  }
}
