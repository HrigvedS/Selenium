package intellipaatPRT2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Candy
{

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		String country ="Worcestershire";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://candymapper.com/an-automation-sandbox%3F");
		
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//div[@class='x-el x-el-div c1-1 c1-2 c1-r c1-4a c1-5i c1-5j c1-5g c1-12 c1-u c1-av c1-bw c1-b c1-c c1-d c1-e c1-f c1-g']//*[name()='svg']")).click();
		
		driver.findElement(By.xpath("(//div//ul//li//a)[1]")).click();
		
		js.executeScript("window.scrollBy(0,1000)");
	//	WebElement frameElement = driver.findElement(By.xpath("//iframe[contains(@id,'iframe')]"));
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("/html/body/center/select"));
		js.executeScript("arguments[0].click()", element1);
		driver.findElement(By.xpath("//select[@id='tCounty']//option[@value='SC']")).click();
		driver.switchTo().defaultContent();
		js.executeScript("window.scrollBy(0,1300)");
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//h2[@data-aid='CONTACT_SECTION_TITLE_REND']//span")).getText());
		WebElement name= 
				driver.findElement(By.xpath("(//input[contains(@id,'input')])[1]"));
		name.sendKeys(("intellipaat"));
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/div/section/div/div/div[1]/span/div/div/div/form/div[2]/div/div/input")).sendKeys("support@intellipat.com");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[5]/div/div/section/div/div/div[1]/span/div/div/div/form/div[3]/div/textarea")).sendKeys("Hello, This is Intellipaat");
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-aid='CONTACT_SUBMIT_BUTTON_REND']")).click();
		Thread.sleep(5000);
		String response = driver.findElement(By.xpath("//div[@data-aid='CONTACT_FORM_SUBMIT_SUCCESS_MESSAGE']//p//span")).getText();
		System.out.println(response);
		Thread.sleep(2000);
		WebElement more = driver.findElement(By.xpath("//div//span[contains(text(),'More')]"));
		js.executeScript("arguments[0].click()", more);
		driver.findElement(By.partialLinkText("PACKT P")).click();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> itr = s.iterator();
		String parentWindow =  itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		driver.quit();
	}

}