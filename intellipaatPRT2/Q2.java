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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Q2 {
	 

    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://candymapper.com/an-automation-sandbox%3F");
        Thread.sleep(5000);

        // Validate Chrome browser launch
        if (driver.getTitle().contains("An Automation Sandbox?")) {
            System.out.println("Chrome browser launched successfully!");
        } else {
            System.out.println("Failed to launch Chrome browser.");
            driver.quit();
            return;
        }

        // TestCase 3 - Click the 'x' to close the popup
        driver.findElement(By.xpath("//div[@class='x-el x-el-div c1-1 c1-2 c1-r c1-4a c1-5i c1-5j c1-5g c1-12 c1-u c1-av c1-bw c1-b c1-c c1-d c1-e c1-f c1-g']//*[name()='svg']")).click();
        Thread.sleep(3000);

        // TestCase 4 - Click on ‘Home’ button in the nav bar
        driver.findElement(By.xpath("(//a[text()='Home'])[1]")).click();
        Thread.sleep(3000);

        // TestCase 5 - Select the country as Worcestershire in the select the country Drop-down menu
       JavascriptExecutor js = (JavascriptExecutor)driver;
//       WebElement text= driver.findElement(By.xpath("//*[@id=\"810c3f2a-aa9d-41a2-8dac-300177917a3a\"]/div/div/section/div/h2/span"));
//       js.executeScript("arguments[0].scrollIntoView();", text);
//       Thread.sleep(3000);
        Duration timeout = Duration.ofSeconds(10);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
//		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe-010")));
//
//		WebElement iframe = driver.findElement(By.cssSelector("iframe-010"));
//		
//		// Switch context to iframe  
//		driver.switchTo().frame(iframe);
//        Thread.sleep(3000);
//         //Perform actions within the iframe
//        driver.findElement(By.xpath("//*[@id=\"tCounty\"]")).sendKeys("Worcestershire");
//
//        // Switch back to the default content
//        driver.switchTo().defaultContent();
//
//        // TestCase 6 - Scroll down to ‘contact us’ form and populate it.
       WebElement text1= driver.findElement(By.xpath("//*[@id=\"13177999-c08f-4f9c-ba5a-5b9aab59e4b5\"]/div/section/div/h2/span"));
       js.executeScript("arguments[0].scrollIntoView();", text1);
       Thread.sleep(3000);
        // Populate contact form fields
        // Specify the timeout duration (e.g., 10 seconds)
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/input[1]"))).sendKeys("Hrigved");
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/input[1]"))).sendKeys("sharma.hrigved@gmail.com");
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[5]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/span[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/textarea[1]"))).sendKeys("ABC");
       Thread.sleep(3000);
       

        // TestCase 7 - Submit the form by clicking on ‘send’ button
        driver.findElement(By.xpath("//*[@id=\"bs-7\"]/span/div/div/div/form/div[4]/div/div/button")).click();
        Thread.sleep(6000);

        // Test case 8 - Verify the submit by printing the confirmation text in the console screen.
        String expectedText = "Thank you for your inquiry! We will get back to you within 48 hours.";
        String actualText = driver.findElement(By.xpath("//*[@id=\"bs-7\"]/span/div/div/div/div/div/div[2]/p/span"))
                .getText();
        Assert.assertEquals(actualText, expectedText);
        System.out.println("Test case 8: " + actualText);

        // Test case 9 - Click on ‘more’ from nav bar and choose ‘Packt publishing’
        driver.findElement(By.id("2")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"more-10877\"]/li[5]/a")).click();
        Thread.sleep(3000);

        // Test case 10 - Print the title of the new tab opened in the console screen.
        ArrayList<String> windowTabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Test case 10: Title of the new tab - " + driver.switchTo().window(windowTabs.get(1)).getTitle());

        // Test case 11 - Close the original window of the browser.
        driver.switchTo().window(windowTabs.get(0));
        driver.close();
    }
}
