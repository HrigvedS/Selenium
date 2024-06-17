package intellipaatPRT2;

import java.awt.AWTException;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Que2 {
	 

    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://candymapper.com/");
        Thread.sleep(5000);

        // Validate Chrome browser launch
        if (driver.getTitle().contains("CandyMapper.Com")) {
            System.out.println("Chrome browser launched successfully!");
        } else {
            System.out.println("Failed to launch Chrome browser.");
            driver.quit();
            return;
        }

        // TestCase 3 - Click the 'x' to close the popup
        driver.findElement(By.xpath("//div[@class='x-el x-el-div c1-1 c1-2 c1-r c1-48 c1-5g c1-5h c1-5e c1-12 c1-u c1-ep c1-b4 c1-b c1-c c1-d c1-e c1-f c1-g']//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]")).click();
        Thread.sleep(3000);

        

        // TestCase 5 - Select the country as Worcestershire in the select the country Drop-down menu
       JavascriptExecutor js = (JavascriptExecutor)driver;
       WebElement text= driver.findElement(By.xpath("//*[@id=\"810c3f2a-aa9d-41a2-8dac-300177917a3a\"]/div/div/section/div/h2/span"));
       js.executeScript("arguments[0].scrollIntoView();", text);
       Thread.sleep(3000);
       driver.switchTo().frame(0);
		WebElement element1 = driver.findElement(By.xpath("/html/body/center/select"));
		js.executeScript("arguments[0].click()", element1);
		driver.findElement(By.xpath("//select[@id='tCounty']//option[@value='SC']")).click();
		driver.switchTo().defaultContent();
       
    }
    }