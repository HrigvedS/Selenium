package framework.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Login {
	WebDriver driver;
//Specify the address of WebElement
	By login=By.xpath("//input[@id='user-name']");
	By password=By.xpath("//input[@id='password']");
	By LoginButton=By.xpath("//input[@id='login-button']");
	By SLBPText=By.xpath("//div[text()='Sauce Labs Backpack']");
	By ClickOnAddToCart=By.xpath("(//button[text()='Add to cart'])[1]");
	By ClickOnCart=By.xpath("//a[@class='shopping_cart_link']");
	By YourCart= By.xpath("//span[text()='Your Cart']");
	
	
	public Page_Login(WebDriver driver) {
		this.driver= driver;
	}

	public void type_username(String uname) {
		//fill username txtbox
		driver.findElement(login).sendKeys(uname);
	}
	
	public void type_password(String pwd) {
		//fill Pass txtbox
		driver.findElement(password).sendKeys(pwd);
	}
	public void click_login() {
		//Click Login Button
		driver.findElement(LoginButton).click();
	}
	
	public String SLBPText() {
		return driver.findElement(SLBPText).getText();
	}

	public void ClickAddtoCart() {
		driver.findElement(ClickOnAddToCart).click();
	}
	
	public void ClickCart() {
		driver.findElement(ClickOnCart).click();
	}
	
	public String Yourcart() {
		return driver.findElement(YourCart).getText();
		
	}
	

}
