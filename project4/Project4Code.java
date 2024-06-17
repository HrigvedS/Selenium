
package project4;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Project4Code {
	WebDriver driver;
	FlipkartPageElements element;
	
	
  @Test
  public void setup() throws InterruptedException {
	  driver= new ChromeDriver();
	  
	  
	  //Go to test URL "https://www.flipkart.com/"
	  driver.get("https://www.flipkart.com/");
	  driver.manage().window().maximize();
	  element = new FlipkartPageElements(driver); 
	  Thread.sleep(3000);
	  
	  //Dissmiss the login page as it needs OTP to login.
	  element.loginpage();
	  
	  //Search for Iphone 12 in searchBar
	  element.searchBox("Iphone 12");
	  Thread.sleep(3000);
	  
	  //Click on 64GB iphone
	  element.iphone12_64GB();
	  
	  //close the browser
	  driver.close();
	
  }
}
