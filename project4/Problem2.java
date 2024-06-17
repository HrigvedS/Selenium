/*• Do login and validate if Login is successful.
• Search for ‘iPhone 12’ and select a 64GB phone on product details page after
selecting the phone from product listing page.
• Add the product to cart and validate if the product added and available in Cart.
• Add a new address for shipping and proceed to checkout page then validate it.
• Same test to be repeated on Chrome browser (assuming you’re using Firefox as
default browser else vice-versa).
• Any actions in any page are welcome (like sorting the products in product listing
page, page header assertions in each page to validate if on right page, etc).*/
package project4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Problem2 {
	WebDriver driver;
	FlipkartPageElements element;
	
	
  @Test
  public void setup() throws InterruptedException, IOException {
	  Properties prop =new Properties();
      FileInputStream ip= new FileInputStream("C:\\Users\\hrigv\\eclipse-workspace\\myFirstAutomationProject\\src\\test\\java\\project4\\InsertData.propertiesFile");
  	  prop.load(ip);
  	  String Browser= prop.getProperty("browser");
		if(Browser.equals("edge")) {
			driver= new EdgeDriver();
		}    	
		if(Browser.equals("chrome")) {
			driver= new ChromeDriver();
		}    	
		if(Browser.equals("firefox")) {
			driver= new FirefoxDriver();
		}    	    	
	  
	  driver= new ChromeDriver();
	  
	  
	  //Go to test URL "https://www.flipkart.com/"
	  driver.get(prop.getProperty("URL"));
	  driver.manage().window().maximize();
	  element = new FlipkartPageElements(driver); 
	  Thread.sleep(3000);
	  
	  //Dissmiss the login page as it needs OTP to login.
	  element.loginpage();
	  
	  //Search for Iphone 12 in searchBar
	  element.searchBox(prop.getProperty("Search"));
	  Thread.sleep(3000);
	  
	  //Click on 64GB iphone
	  element.iphone12_64GB();
	  Thread.sleep(3000);

	  //Handling Tabs		
	  ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
	  System.out.println(tabs);
	  Thread.sleep(3000);
	  //switch from 0 to 1 Tab
	  driver.switchTo().window(tabs.get(1));
	  Thread.sleep(3000);
	  
	  //Click Add to cart
	  element.addToCart();
	  
	  
	  //verify cart
	  String Exptext= "Safe and Secure Payments.Easy returns.100% Authentic products.";
	  String Acttext= element.CartVerify();
		
		Assert.assertEquals(Exptext, Acttext);
		
		if(Acttext.equals(Exptext))
		{
			System.out.println("Cart verify - PASS");
		}
		else
		{
			System.out.println("Cart verify  - Fail");
		}

     
	  //close the browser
	  driver.quit();
	
  }

}

