/*2) Perform the following test cases.
Test Case-1 Launch Chrome browser
Test Case-2 go to test URL - https://netbanking.hdfcbank.com/netbanking/
Test Case-3 Maximize the browser window
Test Case-4 get the title of the page
Test Case-5 Click on the know more link text
Test Case-6 switch from 0th window to 1st window
Test Case-7 After switching get the title of the page
Test Case-8 switch from 1st window to 0th window
Test Case-9 After switching, get the title of the page
Test Case-10 close all windows of the browse*/

package PRT3;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDFC_Q2 {
	public static void main(String[] args) throws InterruptedException {
		
		//Test Case-1 Launch Chrome browser
		WebDriver driver= new ChromeDriver();
		
		//Test Case-2 go to test URL - https://netbanking.hdfcbank.com/netbanking/
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		Thread.sleep(3000);
		
		//Test Case-3 Maximize the browser window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		//Test Case-4 get the title of the page
		String PTitle= driver.getTitle();
		System.out.println(PTitle);
		Thread.sleep(3000);
		
		//Test Case-5 Click on the know more link text
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Know More")).click();
		Thread.sleep(3000);
		
		//Test Case-6 switch from 0th window to 1st window
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(list.get(1));
		
		//Test Case-7 After switching get the title of the page
		String GTitle= driver.getTitle();
		System.out.println(GTitle);
		Thread.sleep(3000);
	
		//Test Case-8 switch from 1st window to 0th window
		driver.switchTo().window(list.get(0));
	
		//Test Case-9 After switching, get the title of the page
		String VTitle= driver.getTitle();
		System.out.println(VTitle);
		Thread.sleep(3000);
		//Test Case-10 close all windows of the browse
		driver.quit();
		
	}
	}