package Project1;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class project_1 {
WebDriver driver; //make WebDriver public

	  @BeforeClass
	  public void setup() {
		  //Launch browser
		  driver= new ChromeDriver();
		  //Maximize the window
		  driver.manage().window().maximize();
		  
	  }

	  @AfterClass
	  public void afterTest() {
		  //Close Browser
		  driver.quit();
	  }

	  
//1.  Test the login screen
	@Test(priority=1)
  public void login() throws InterruptedException {
		//1.  Test the login screen with username and password (using "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);  //specify a wait time
		
		//Inspect username and send the value
	    driver.findElement(By.name("username")).sendKeys("Admin");
	    Thread.sleep(3000);  //specify a wait time
	    
		//Inspect password and send the value
	    driver.findElement(By.name("password")).sendKeys("admin123");
	    Thread.sleep(3000);  //specify a wait time
	    
		//Inspect login button and click
	    driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	    Thread.sleep(3000);  //specify a wait time
	}
	
	
	//2. Test online widgets like date pickers
	@Test(priority=2)
	public void datePicker() throws InterruptedException {
		//2. Test online widgets like date pickers
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);  //specify a wait time
		 
		// insert date
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("06/05/1999");
		Thread.sleep(3000);  //specify a wait time  
	}
	
	//2. Test online widgets like Tabs
	@Test(priority=3)
	public void tabs() throws InterruptedException {
		//2. Test online widgets like Tabs
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(5000);  //specify a wait time
		
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
	
	
	//2. Test online widgets like sliders
	@Test(priority=4)
	public void slider() throws InterruptedException {
		//2. Test online widgets like sliders
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);  //specify a wait time
		
		//drage slider
		WebElement slider=driver.findElement(By.xpath("//div[@id='slider']"));
		Actions a= new Actions(driver);
		a.dragAndDropBy(slider, 50, 0).build().perform();
		Thread.sleep(3000);  //specify a wait time
	}
	
	//3. Test interactive actions like draggable
	@Test(priority=5)
	public void draggable() throws InterruptedException {
		//3. Test interactive actions like draggable
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);  //specify a wait time
		
		//Drop the dropable element to its final location
		WebElement draggable = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement toDragOn= driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions a= new Actions(driver);
		a.dragAndDrop(draggable, toDragOn).build().perform();
		Thread.sleep(3000);  //specify a wait time
	}
	
	//3. Test interactive actions like resizable
	@Test(priority=6)
	public void resizable() throws InterruptedException {
		//3. Test interactive actions like resizable
		driver.get("https://testautomationpractice.blogspot.com/");
		Thread.sleep(3000);  //specify a wait time
		
		//Automate the resizable box
		WebElement resizable=driver.findElement(By.xpath("(//div[contains(@class,'ui-resizable')])[4]"));
		Actions ab= new Actions(driver);
		ab.sendKeys(Keys.PAGE_DOWN).build().perform();
		ab.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(5000);  //specify a wait time
		ab.dragAndDropBy(resizable,100,50).build().perform();
		Thread.sleep(3000);  //specify a wait time
	}
	//3. Test interactive actions like selectable
		@Test(priority=7)
		public void selectable() throws InterruptedException {
			//3. Test interactive actions like resizable
			driver.get("https://testautomationpractice.blogspot.com/");
			Thread.sleep(3000);  //specify a wait time
			
			//select country as INDIA
			WebElement country=driver.findElement(By.xpath("//select[@id='country']"));
		Select value= new Select(country);
		value.selectByValue("india");
		Thread.sleep(3000);  //specify a wait time
		}
		
		//4. Test the filling up of registration form and submission
		@Test(priority=8)
		public void registrationForm() throws InterruptedException {
			//4. Test the filling up of registration form and submission
			driver.get("https://testautomationpractice.blogspot.com/");
			Thread.sleep(3000);  //specify a wait time
			
			//5.Test frames and windows
			driver.switchTo().frame("frame-one796456169");
			//Fill the form
			driver.findElement(By.id("RESULT_TextField-0")).sendKeys("Hrigved");
			Thread.sleep(3000);  //specify a wait time
			driver.findElement(By.xpath("//label[text()='Male']")).click();
			Thread.sleep(3000);  //specify a wait time
			driver.findElement(By.xpath("(//input[@id='RESULT_TextField-2'])[1]")).sendKeys("06/05/1999");
			Thread.sleep(3000);  //specify a wait time
			
			//6.Test drop-down menus
			Select value=new Select(driver.findElement(By.xpath("//select[@id='RESULT_RadioButton-3']")));
			value.selectByValue("Radio-1");
			Thread.sleep(3000);  //specify a wait time
			driver.findElement(By.xpath("//input[@name='Submit']")).click();
			Thread.sleep(3000);  //specify a wait time
		}
		//4. Test alert Boxs
		@Test(priority=9)
		public void alerts() throws InterruptedException {
			//4. Test alert Box
			driver.get("https://testautomationpractice.blogspot.com/");
			Thread.sleep(3000);  //specify a wait time
			
			//Click on first alert and accept the box
			driver.findElement(By.xpath("//button[text()='Alert']")).click();
			Thread.sleep(3000);  //specify a wait time
			driver.switchTo().alert().accept();
			Thread.sleep(3000);  //specify a wait time
			
			//Click on second alert and decline the box
			driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
			Thread.sleep(3000);  //specify a wait time
			driver.switchTo().alert().dismiss();
			Thread.sleep(3000);  //specify a wait time
			
			//Click on third alert and pass the value the box
			driver.findElement(By.xpath("//button[text()='Prompt']")).click();
			Thread.sleep(3000);  //specify a wait time
			driver.switchTo().alert().sendKeys("Hrigved");
			Thread.sleep(3000);  //specify a wait time
			driver.switchTo().alert().accept();
			Thread.sleep(3000);  //specify a wait time
		}
		
}
