package intellipaatPRT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Question1 {
public WebDriver driver;
  @Test(priority = 1, alwaysRun = true)
  public void Setup() {
 driver = new ChromeDriver();
 driver.get("https://in.bookmyshow.com");
// driver.manage().window().maximize();
  }
  @Test (priority = 2,alwaysRun = true)
  public void Selectregion() throws InterruptedException {
// Select region = new Select(driver.findElement(By.xpath("//span[text()='Hyderabad'")));
 //region.selectByVisibleText("Hyderabad");
 driver.findElement(By.xpath("//body/div[@id='modal-root']/div[1]/div[1]/div[1]/div[3]/ul[1]/li[4]/div[1]/div[1]/img[1]")).click();
 Thread.sleep(1000);
  }
 
  @Test(priority = 3,alwaysRun = true)
  public void click_movie() throws InterruptedException {
 driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[2]/div[1]/img[1]")).click();
 Thread.sleep(2000);
   
  }
 
  @Test(priority = 4,alwaysRun = true)
  public void booticket() throws InterruptedException {
// WebElement movie = driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]"));
//  Actions  a =  new Actions(driver);
// a.moveToElement(movie).build().perform();
//  Thread.sleep(2000);////div[text() = '2D']
 driver.findElement(By.xpath("//body/div[@id='super-wrapper']/div[@id='super-container']/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]")).click();
 Thread.sleep(1000);
  }
 
  @Test(priority = 4,alwaysRun = true)
  public void verifyURL() throws InterruptedException {
 String ExpURL = "https://in.bookmyshow.com";
 String ActURL = driver.getCurrentUrl();
 Assert.assertEquals(ActURL,ExpURL);
 Thread.sleep(3000);
  }
  @Test(priority = 5,alwaysRun = true)
  public void closebrowser() {
 driver.close();
  }
 
 
}