/*
TestCase1- Open chrome Browser & Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
TestCase2- Log in using the credentials given on the website.
TestCase3- Click “Time” from the Navigation bar
TestCase4- Click on the “Attendance” drop-down List and then click on “Employee records”
TestCase5- Select the date as 4 July 2023 in the “dateSelector element” and click on the “view” button.
TestCase6- Print all the records found on the console screen.*/

package PRT3;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangHRM_Q3 {
	public static void main(String[] args) throws InterruptedException, IOException {
    	
        WebDriver driver = new ChromeDriver();

         	// TestCase1: Open Chrome Browser & Go to the specified URL
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();
            Thread.sleep(5000);
            // TestCase2: Login using credentials given on the website.
             driver.findElement(By.name("username")).sendKeys("Admin");
             Thread.sleep(5000);
             driver.findElement(By.name("password")).sendKeys("admin123");
             Thread.sleep(5000);
             driver.findElement(By.tagName("button")).click();
             Thread.sleep(5000);
          
            // TestCase3: Click "Time" from the Navigation bar
            driver.findElement(By.xpath("//span[text()='Time']")).click();
            Thread.sleep(5000);
     
            // TestCase4: Click on "Attendance" drop down List and then click on "Employee records"
            
         // Scenario-Select- Selecting from a drop down menu
    		WebElement leave = driver.findElement(By.xpath("//span[text()='Attendance ']"));
    		Actions act=new Actions(driver);
    		act.moveToElement(leave).click().perform();
    		//TestCase5- Select the date as 4 July 2023 in the “dateSelector element” and click on the “view” button.
    		driver.findElement(By.xpath("//a[text()='Employee Records']")).click();
            // Wait for a moment for the records to load
            Thread.sleep(2000);

            WebElement form = driver.findElement(By.xpath("//form[@class='oxd-form']"));

	        WebElement dateField = form.findElement(By.xpath("//input[@placeholder='mm-dd-yyyy']"));
	        dateField.click();

	        WebElement clearButton = driver.findElement(By.xpath("//div[@class='oxd-date-input-link --clear']")); 
	        clearButton.click();

	        Thread.sleep(2000);

	        dateField.sendKeys("07-04-2023");

	        WebElement viewButton = driver.findElement(By.xpath("//button[@type='submit']"));
	        viewButton.click();

	        List<WebElement> allRecords = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));

            // TestCase6- Print all the records found on the console screen.
            java.util.List<WebElement> allRecords1 = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));
            for (WebElement record : allRecords1) {
                System.out.println(record.getText().replace("\n", "\t"));
            }
    
            driver.close();
       }
 
	}