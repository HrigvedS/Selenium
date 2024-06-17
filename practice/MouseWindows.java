package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseWindows {


public static void main(String[] arg) throws InterruptedException {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	JavascriptExecutor js = (JavascriptExecutor)driver;
    WebElement text= driver.findElement(By.xpath("//a[text()='About Us']"));
    js.executeScript("arguments[0].scrollIntoView();", text);
    Thread.sleep(3000);
WebElement about= driver.findElement(By.xpath("//a[text()='About Us']"));
Actions a = new Actions(driver);
a.contextClick(about).perform();
Thread.sleep(3000);
a.sendKeys(Keys.ARROW_DOWN).perform();
Thread.sleep(3000);
a.sendKeys(Keys.ENTER).perform();
	
}}