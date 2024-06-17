/*TestCase 1 - Launch Google Chrome browser. Verify chrome browser launched successfully.
TestCase 2 - Navigate to URL "https://testautomationpractice.blogspot.com/" in the browser. 
TestCase 3 - Locate the name, email, phone number fields on page. Enter valid values meeting 
criteria into these fields. For example, 10 digit numeric value in phone number. Verify 
successful entry.
TestCase 4 - Test date picker by selecting different dates. Test slider control by moving 
the slider. Test tabs by switching between tab content. Verify correct functionality.
TestCase 5 - Test drag and drop feature. Drag elements and drop them on target elements
successfully. Test resize of elements using resize handles. Test elements selection 
by clicking on them.
TestCase 6 - Test dropdown fields by selecting different values from them. Trigger 
javascript alert and verify alert appears correctly. Accept/dismiss alert.
TestCase 7 - Close the browser.*/

package intellipaatPRT;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestautomationpracticeBlogspotCom {
WebDriver driver; //make WebDriver public
//TestCase 1 - Launch Google Chrome browser. Verify chrome browser launched successfully.
	  @BeforeMethod
	  public void setup() throws InterruptedException {
		  //Launch browser
		  driver= new ChromeDriver();
		  //Maximize the window
		  driver.manage().window().maximize();
		  // launch "https://testautomationpractice.blogspot.com/"
		  driver.get("https://testautomationpractice.blogspot.com/");
			Thread.sleep(3000);  //specify a wait time
		// Verify Chrome browser launch
	        String pageTitle = driver.getTitle();
	        Assert.assertTrue(pageTitle.contains("Automation Testing Practice"), "Chrome browser launched successfully");
	  }
	  
//TestCase 7 - Close the browser.
	  @AfterMethod
	  public void afterTest() {
		  //Close Browser
		  driver.quit();
	  }

	  
		//TestCase 3 - Locate the name, email, phone number fields on page. Enter valid values meeting criteria into these fields. For example, 10 digit numeric value in phone number. Verify successful entry.
		@Test(priority=1)
		public void enterField() throws InterruptedException {
		
						
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hrigved");
			Thread.sleep(3000);  //specify a wait time
			
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sharma.hrigved@gmail.com");
			Thread.sleep(3000);  //specify a wait time
			
			driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("8109790438");
			Thread.sleep(3000);  //specify a wait time
		}

			
	//TestCase 4 - Test date picker by selecting different dates. Test slider control by moving the slider. Test tabs by switching between tab content. Verify correct functionality.
	@Test(priority=2)
	public void datePicker() throws InterruptedException {
		
		// insert date
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06/05/1999");
		Thread.sleep(3000);  //specify a wait time  
	}
	
	// Test online widgets like sliders
	@Test(priority=3)
	public void slider() throws InterruptedException {
	
		//drage slider
		WebElement slider=driver.findElement(By.xpath("//div[@id='slider']"));
		Actions a= new Actions(driver);
		a.dragAndDropBy(slider, 50, 0).build().perform();
		Thread.sleep(3000);  //specify a wait time
	}
	
	//Test online widgets Tabs
	@Test(priority=4)
	public void tabs() throws InterruptedException {
		//2. Test online widgets like Tabs
		
		
		//click on New Browser Window
		driver.findElement(By.xpath("//button[text()='New Browser Window']")).click();
		
		//switch to new tab
		ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(5000);  //specify a wait time
		
		//get current url in the console
		String URL=driver.getCurrentUrl();
		System.out.println(URL);
		Thread.sleep(5000);  //specify a wait time
		
		//switch to previous tab
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(5000);  //specify a wait time
		
		//Get the heading in the console
		String text=driver.findElement(By.xpath("//h1[contains(text(),'Automation')]")).getText();
		System.out.println(text);
		Thread.sleep(5000);  //specify a wait time
		
		//switch to new tab to close it
		driver.switchTo().window(tabs.get(1));
		driver.close();
	}
	
	
//TestCase 5 - Test drag and drop feature. Drag elements and drop them on target elements successfully. Test resize of elements using resize handles. Test elements selection by clicking on them.
	//Test interactive actions like draggable
	@Test(priority=5)
	public void draggable() throws InterruptedException {
	
		//page down
		Actions ab= new Actions(driver);
		ab.sendKeys(Keys.PAGE_DOWN).build().perform();
		ab.sendKeys(Keys.PAGE_DOWN).build().perform();
		ab.sendKeys(Keys.PAGE_DOWN).build().perform();
		ab.sendKeys(Keys.PAGE_DOWN).build().perform();
		//Drop the dropable element to its final location
		
		WebElement draggable = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement toDragOn= driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions a= new Actions(driver);
		a.dragAndDrop(draggable, toDragOn).build().perform();
		Thread.sleep(4000);  //specify a wait time
	}

	//TestCase 6 - Test dropdown fields by selecting different values from them. Trigger javascript alert and verify alert appears correctly. Accept/dismiss alert.
	@Test(priority=6)
	public void resizable() throws InterruptedException {
		
		//Automate the resizable box
		WebElement resizable=driver.findElement(By.xpath("(//div[contains(@class,'ui-resizable')])[4]"));
		Actions ab= new Actions(driver);
		ab.sendKeys(Keys.PAGE_DOWN).build().perform();
		ab.sendKeys(Keys.PAGE_DOWN).build().perform();
		ab.sendKeys(Keys.PAGE_DOWN).build().perform();
		ab.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);  //specify a wait time
		ab.dragAndDropBy(resizable,100,50).build().perform();
		Thread.sleep(3000);  //specify a wait time
	}
	//Test interactive actions like selectable
		@Test(priority=7)
		public void selectable() throws InterruptedException {
			
			Actions ab= new Actions(driver);// Page down to see the performance
			ab.sendKeys(Keys.PAGE_DOWN).build().perform();
			ab.sendKeys(Keys.PAGE_DOWN).build().perform();
			ab.sendKeys(Keys.PAGE_DOWN).build().perform();
			ab.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(3000); 
			//select country as INDIA
			WebElement country=driver.findElement(By.xpath("//select[@id='country']"));
		Select value= new Select(country);
		value.selectByValue("india");
		Thread.sleep(3000);  //specify a wait time
		}
			
		}
		

