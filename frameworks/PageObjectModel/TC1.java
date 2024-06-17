package frameworks.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TC1 {
	WebDriver driver;
	Page_Login login;
  @Test
  public void verify_sdLogin() throws InterruptedException {
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
		driver.close();
		
		
  }
}
