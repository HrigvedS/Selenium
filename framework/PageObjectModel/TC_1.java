package framework.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TC_1 {
	WebDriver driver;
	Page_Login login;
  @Test
  public void verify_sdlogin() throws InterruptedException {
  //Launch chrome browser
	  driver = new EdgeDriver();
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
	  //close the driver
	  driver.close();
  }
}
