package framework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_2 {
	WebDriver driver;
	Page_Login login;
  @Test
  public void verify_sdlogin() throws InterruptedException {
  //Launch chrome browser
	  driver= new EdgeDriver();
	  //Go to URL "https://www.saucedemo.com/"
	  driver.get("https://www.saucedemo.com/");
	  Thread.sleep(3000);
	  login= new Page_Login(driver);
	  //Fill Username textbox
	  login.type_username("standard_user");
	  Thread.sleep(3000);
	//Fill Password textbox
	  login.type_password("secret_sauce");
	  Thread.sleep(3000);
	  //Click on login
	  login.click_login();
	  Thread.sleep(3000);
	 
	  //Operation functionality
	  //Verify page by text
	  String ExpText ="Sauce Labs Backpack";
	  String ActText= login.SLBPText();
	  Assert.assertEquals(ExpText, ActText);   
	  Thread.sleep(3000);
	  //click on add to cart
	  login.ClickAddtoCart();
	  Thread.sleep(3000);
	  //click on cart
	  login.ClickCart(); 
	  Thread.sleep(3000);
	  //verify the cart page
	  String expText= "Your Cart";
	  String actText= login.Yourcart();
	  Assert.assertEquals(expText, actText);
	  Thread.sleep(3000);
	  //Close the Browser
	  driver.close();
  }
}
