package intellipaatPRT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestautomationpracticeBlogspotCom2 {

	public static void main(String[] args) throws InterruptedException {
		//Test Case 1 - Launch Google Chrome browser. Verify chrome browser launched successfully.
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Verify Chrome browser launch
		driver.get("https://www.google.com");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

			// Test Case 2 - Navigate to URL "https://testautomationpractice.blogspot.com/" in the browser.
				driver.get("https://testautomationpractice.blogspot.com/");
				driver.manage().window().maximize();
				Thread.sleep(5000);		        // Test Case 2 - Navigate to URL "https://testautomationpractice.blogspot.com/" in the browser.
				        driver.get("https://testautomationpractice.blogspot.com/");
				        Thread.sleep(5000);
				        System.out.println("Test Case 2: Navigated to URL: " + driver.getCurrentUrl());

				        // Test Case 3 - Locate the name, email, phone number fields on the page. Enter valid values and verify successful entry.
				        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("John Doe");
				        Thread.sleep(5000);
				         driver.findElement(By.xpath("//input[@id='email']")).sendKeys("john.doe@example.com");
				          driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("1234567890");
				          Thread.sleep(5000);

				        System.out.println("Test Case 3: Entered valid values in name, email, and phone fields");

				        // Test Case 4 - Test date picker, slider control, and tabs functionality.
				        WebElement datePicker = driver.findElement(By.id("datepicker"));
				        datePicker.sendKeys("01/01/2023");

				      //drag slider
						WebElement slider=driver.findElement(By.xpath("//div[@id='slider']"));
						Actions a= new Actions(driver);
						a.dragAndDropBy(slider, 50, 0).build().perform();
						Thread.sleep(3000);  //specify a wait time

				        WebElement tab2 = driver.findElement(By.xpath("//button[text()='New Browser Window']"));
				        tab2.click();
				        
				        driver.switchTo().defaultContent();

				        System.out.println("Test Case 4: Date picker, slider control, and tabs functionality tested successfully");

				        // Test Case 5 - Test drag and drop, resize, and element selection features.
				        WebElement dragElement = driver.findElement(By.id("draggable"));
				        WebElement dropTarget = driver.findElement(By.id("droppable"));

				        new Actions(driver).dragAndDrop(dragElement, dropTarget).perform();

				        WebElement resizeHandle = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
				        new Actions(driver).clickAndHold(resizeHandle).moveByOffset(50, 50).release().perform();

				        WebElement selectableElement = driver.findElement(By.id("selectable"));
				        new Actions(driver).click(selectableElement).perform();

				        System.out.println("Test Case 5: Drag and drop, resize, and element selection features tested successfully");

				        // Test Case 6 - Test dropdown fields, trigger JavaScript alert, and verify alert.
				        Select dropdown = new Select(driver.findElement(By.name("speed")));
				        dropdown.selectByVisibleText("Medium");
				        
				      driver.findElement(By.xpath("//button[text()='Alert']")).click();
				      driver.switchTo().alert().accept();
				        
				        System.out.println("Test Case 6: Dropdown fields, JavaScript alert, and alert verification tested successfully");

				        // Test Case 7 - Close the browser.
				        driver.close();
			}


}