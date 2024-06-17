/*TestCase 1– Open chrome browser and go to      https://www.amazon.in/

TestCase 2- Hover your mouse to “Account & Lists” element

TestCase 3– Click on “Your recommendations” element

TestCase4- Fetch all the Products listed in the product listing page(Top picks for you) along with their prices and Print them on console screen

TestCase5- Create a Excel file and output all the products listed along with their prices in the Excel file

*/
package intellipaatPRT;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Amazone {


	public static void main(String[] args) {
		// TestCase 1– Open chrome browser and go to      https://www.amazon.in/
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		//TestCase 2- Hover your mouse to “Account & Lists” element
	WebElement accountAndList = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
	Actions a = new Actions(driver);
	a.moveToElement(accountAndList).build().perform();
	
	//TestCase 3– Click on “Your recommendations” element
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-al-your-account\"]/a[4]/span"))).click();
	
	
	//TestCase4- Fetch all the Products listed in the product listing page(Top picks for you) along with their prices and Print them on console screen
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='p13n-sc-truncate-desktop-type2  p13n-sc-truncated']")));
	List<WebElement> products = driver.findElements(By.xpath("//div[@class='p13n-sc-truncate-desktop-type2  p13n-sc-truncated']"));
	List<WebElement> price = driver.findElements(By.xpath("//span[@class='_cDEzb_p13n-sc-price_3mJ9Z']"));
	
	for (int i=0; i<products.size(); i++) {
		System.out.println(products.get(i).getText()+"----"+price.get(i).getText());
	}
	
	
	}

}
