/*TestCase 1 – Launch the Google Chrome browser and navigate to the URL “https://in.bookmyshow.com“. 

TestCase 2 – select the region as “Hyderabad”

TestCase 3 – On the home page scroll down and  you need to click on the movie “Fighter”

TestCase 4 -On the movie page click on “Book tickets” and select the movie type as “2D”

TestCase 5 –When utilizing an automated browser, Book My Show may prevent us from progressing. Utilize the Asserts Class to confirm that the actual link matches the provided link below:

     “https://in.bookmyshow.com/buytickets/fighter-hyderabad/movie-hyd-ET00304730-MT/”

If the actual link corresponds to the given link, capture a screenshot, save it to your Desktop, and validate the match.

TestCase 6 – Close the browser.*/
package intellipaatPRT2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Q1 {

    public static void main(String[] args) throws IOException, InterruptedException {
        // WebDriver setup
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
       
            // TestCase 1 - Navigate to BookMyShow
            driver.get("https://in.bookmyshow.com");

            // TestCase 2 - Select region "Hyderabad"
            driver.findElement(By.xpath("//img[@alt='HYD']")).click();

            // TestCase 3 - Click on movie "Fighter"
            // Use WebDriverWait for reliable element interaction
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Lal Salaam')]"))).click();

            // TestCase 4 - Select movie type "2D"
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Book tickets'])[1]"))).click();
            driver.findElement(By.xpath("//span[normalize-space()='2D']")).click();
            Thread.sleep(3000);
            // TestCase 5 - Assert URL and capture screenshot
            
            String Expresult = "https://in.bookmyshow.com/buytickets/lal-salaam-hyderabad/movie-hyd-ET00359069-MT/";
      	  String Actualresult = driver.getCurrentUrl();
      	  //https://in.bookmyshow.com/buytickets/lal-salaam-hyderabad/movie-hyd-ET00359069-MT/
      	  System.out.println(Expresult + "\n" + Actualresult);
      	Assert.assertEquals(Expresult, Actualresult);
		if(Actualresult.equals(Expresult))
{
      		  System.out.println("screenshot");
      		  TakesScreenshot ts= (TakesScreenshot)driver;
      		  File src=ts.getScreenshotAs(OutputType.FILE);
      		  File trg= new File("C:\\Users\\hrigv\\Desktop\\BookMyShowScreenshot.png");
      		  FileUtils.copyFile(src, trg);
      		  Thread.sleep(6000);
      		  driver.close();
      		  }
      		  else {
      			  System.out.println("Noss");
      			  driver.close();
      		  }
        }}
            //https://in.bookmyshow.com/buytickets/teri-baaton-mein-aisa-uljha-jiya-hyderabad/movie-hyd-ET00383266-MT/20240211

         
        
   

