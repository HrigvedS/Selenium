package intellipaatPRT;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException, AWTException
	{
		//Launch Chrome Browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//launch "https://opensource-demo.orangehrmlive.com/"
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Specify the timeout duration (e.g., 10 seconds)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Username']/following::*[2]"))).sendKeys("Admin");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Password']/following::*[2]"))).sendKeys("admin123");
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Login ']"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Time']"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Time']"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Attendance ']"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Employee Records']"))).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='yyyy-mm-dd']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='oxd-date-input-link --clear']"))).click();
        
        WebElement form = driver.findElement(By.xpath("//form[@class='oxd-form']"));
        
        WebElement datefield = form.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']"));
        
        datefield.sendKeys("2023-07-04");
        
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='yyyy-mm-dd']"))).sendKeys("2023-07-04");
        
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']"))).click();
        
    	//List<WebElement>Product= driver.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']"));
    	// Printing records in table form
        List<WebElement> allRecords = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
        for (WebElement a : allRecords) {
			System.out.println(a.getText().replace("\n", "---------------------"));
		}
	driver.close(); // close the browser
     
	}
	}

