/*1. Automate Facebook Registration Page using Direct Locator's in Chrome Browser 
 https://www.facebook.com/*/

package project4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class FlipkartPageElements {
WebDriver driver;
//Specify the address of webElement.
By declineLogin= By.xpath("//span[text()='Login']/preceding::*[1]");
By search= By.xpath("//input[@title='Search for Products, Brands and More']");
By iphone64GB= By.xpath("//div[contains(text(),'White, 64 GB')]");
By addToCart= By.xpath("//button[text()='Add to cart']");
By verifycart= By.xpath("//div[text()='Safe and Secure Payments.']");
By mobilePhone= By.xpath("//div[@class='_4rR01T']");
By mobilePrice= By.xpath("//div[@class='_30jeq3 _1_WHN1']");
By addCart= By.xpath("//button[text()='Add to cart']");


public FlipkartPageElements(WebDriver driver) {
	this.driver = driver;
}



public void loginpage() {
	driver.findElement(declineLogin).click();
}

public void searchBox(String Iphone) {
	driver.findElement(search).sendKeys(Iphone,Keys.ENTER);
}

public void iphone12_64GB() {
	driver.findElement(iphone64GB).click();
}

public void CartAdd() {
	driver.findElement(addToCart).click();
}

public String CartVerify() {
	return driver.findElement(verifycart).getText();

}

public void mobile() {
	driver.findElement(mobilePhone).getText();
}

public void price() {
	driver.findElement(mobilePrice).getText();
}

public void addToCart() {
	driver.findElement(addCart).click();
	
}


}
