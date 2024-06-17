package intellipaatPRT;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hdfc {
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		Thread.sleep(3000);
		
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		String PTitle= driver.getTitle();
		System.out.println(PTitle);
		Thread.sleep(3000);
		
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Know More")).click();
		Thread.sleep(3000);
		
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(list.get(1));
		
		String GTitle= driver.getTitle();
		System.out.println(GTitle);
		Thread.sleep(3000);
	
	
		driver.switchTo().window(list.get(0));
	
		String VTitle= driver.getTitle();
		System.out.println(VTitle);
		Thread.sleep(3000);
	
		driver.quit();
	
	
	}

}
