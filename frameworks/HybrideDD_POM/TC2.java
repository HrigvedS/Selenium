package frameworks.HybrideDD_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2 {
	WebDriver driver;
	Page_Login login;
  @Test
  public void verify_Products() throws InterruptedException {
	//Launch Edge Browser 
		driver=new EdgeDriver();
		//Goto TestURL https://www.saucedemo.com/
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(5000);
		login=new Page_Login(driver);
		//Fill username textbox with input 
		login.type_Username("standard_user");
		//Fill Password textbox with input
		login.type_Password("secret_sauce");
		//Click on login button
		login.click_Login();
		Thread.sleep(5000);
		//Verify SLB Text
		String ExpSLBText="Sauce Labs Backpack";
		String ActSLBText=login.captureSLBPtext();
		Assert.assertEquals(ActSLBText, ExpSLBText);
		
		//Click on AddtoCart bttn
		login.click_AddtocartBttn();
		Thread.sleep(5000);
		//Click on cart
		login.click_Cart();
		Thread.sleep(5000);
		//Verify Cart Text
		String ExpCartText="Your Cart";
		String ActCartText=login.capturecartText();
		Assert.assertEquals(ActCartText, ExpCartText);
		Thread.sleep(5000);
		//Close Browser
		driver.close();
		
  }
}
