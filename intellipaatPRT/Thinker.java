/*TestCase1- Open chrome browser and go to      https://thinking-tester-contact-list.herokuapp.com/

TestCase2- Click the “Sign-up” button.

TestCase3– Fill out all the details mentioned and click on Submit button

TestCase4– Click on “add new contact” button and fill out all your details followed by submit button

TestCase5-  Print The Entire table listed on screen including table headings.
*/

package intellipaatPRT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Thinker {

	public static void main(String[] args) throws InterruptedException {
		//TestCase1- Open chrome browser and go to https://thinking-tester-contact-list.herokuapp.com/
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://thinking-tester-contact-list.herokuapp.com");
		
		//TestCase2- Click the “Sign-up” button.
		driver.findElement(By.id("signup")).click();
		
		//TestCase3– Fill out all the details mentioned and click on Submit button
		driver.findElement(By.id("firstName")).sendKeys("Hrigved");
		
		driver.findElement(By.id("lastName")).sendKeys("Sharma");
		
		driver.findElement(By.id("email")).sendKeys("hrigved@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("Hrigved@123");
		
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		//TestCase4– Click on “add new contact” button and fill out all your details followed by submit button
		
	
		driver.findElement(By.id("add-contact")).click();
		
		driver.findElement(By.id("firstName")).sendKeys("Hrigved");
		
		driver.findElement(By.id("lastName")).sendKeys("Sharma");
		
		driver.findElement(By.id("birthdate")).sendKeys("2000-12-31");
		
		driver.findElement(By.id("email")).sendKeys("hrigved@gmail.com");
		
		driver.findElement(By.id("phone")).sendKeys("9999999999");
		
		driver.findElement(By.id("street1")).sendKeys("xyz");
		
		driver.findElement(By.id("street2")).sendKeys("abc");
		
		driver.findElement(By.id("city")).sendKeys("Haridwar");
		
		driver.findElement(By.id("stateProvince")).sendKeys("Uttrakhand");
		
		driver.findElement(By.id("postalCode")).sendKeys("4642004");
		
		driver.findElement(By.id("country")).sendKeys("India");
		
		driver.findElement(By.id("submit")).click();
		
		WebElement tableHeader= driver.findElement(By.className("contactTable-Body"));
		System.out.println(tableHeader);
		
}
	}





