package frameworks.HybrideDD_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Page_Login {
	WebDriver driver;
	
	//Specify the address of Object/Element
	By UserNameField=By.xpath("//input[@id='user-name']");
	By PasswordField=By.xpath("//input[@id='password']");
	By SigninBttn=By.xpath("//input[@id='login-button']");
	By SLBPlainText=By.xpath("(//div[@class='inventory_item_name'])[1]");
	By AddtoCartBttn=By.xpath("(//button[text()='Add to cart'])[1]");
	By cart=By.xpath("//a[@class='shopping_cart_link']");
	By cartPText=By.xpath("//span[text()='Your Cart']");
	
	public Page_Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public String captureSLBPtext()
	{
		return driver.findElement(SLBPlainText).getText();
	}
	public void click_AddtocartBttn()
	{
		driver.findElement(AddtoCartBttn).click();
	}
	
	public void click_Cart()
	{
		driver.findElement(cart).click();
	}
	public String capturecartText()
	{
	return driver.findElement(cartPText).getText();
	}
	
	public void type_Username(String uname) throws InterruptedException
	{
		//Fill username textbox with input
				driver.findElement(UserNameField).sendKeys(uname);
				Thread.sleep(5000);
	}
	
	
	public void type_Password(String pwd) throws InterruptedException
	{
		//Fill password textbox with input
				driver.findElement(PasswordField).sendKeys(pwd);
				Thread.sleep(5000);
	}
	
	
	public void click_Login() throws InterruptedException
	{
		//Click on Login Button
		
		driver.findElement(SigninBttn).click();
		Thread.sleep(5000);
	}
	
}
