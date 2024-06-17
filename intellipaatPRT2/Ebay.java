package intellipaatPRT2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Ebay {
	public
WebDriver driver; //make WebDriver public
int list;
List<WebElement> Price;
List<WebElement> Product;

	  @BeforeClass
	  public void setup() throws InterruptedException {
		  //Launch browser
		  driver= new ChromeDriver();
		  //Maximize the window
		  driver.manage().window().maximize();
		  // launch "https://ebay.com/"
		  driver.get("https://ebay.com/");
			Thread.sleep(3000);  //specify a wait time
		// Verify Chrome browser launch
	        String pageTitle = driver.getTitle();
	        Assert.assertTrue(pageTitle.contains("Electronics, Cars, Fashion, Collectibles & More | eBay"), "Chrome browser launched successfully");
	  }
	  
	  @AfterClass
	  public void afterTest() {
		  //Close Browser
		  driver.quit();
	  }
	    @Test(priority=1)
	    public void mouseHover() throws InterruptedException {
	        WebElement electronics = driver.findElement(By.xpath("(//a[text()='Electronics'])[2]"));
		Actions a= new Actions(driver); 
		a.moveToElement(electronics).build().perform();
		Thread.sleep(3000);
		//Click on Apple
		driver.findElement(By.xpath("//a[text()='Apple']")).click();
		
	    }

	    @Test(priority=2)
	    public void scrolldown() {
	        JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement about= driver.findElement(By.xpath("//*[@id=\"gf-l\"]/li[1]/a")); 
		js.executeScript("arguments[0].scrollIntoView", about); //"arguments[0].scrollIntoView"
		
	    }

	    @Test(priority = 3)
	    public void ProductList() {
	        //to get all the phonenames from the search result
		Product= driver.findElements(By.xpath("//h3[@class='s-item__title']"));
		Price =	driver.findElements(By.xpath("//span[@class='s-item__price']"));
		for (int i=0; i<Product.size();i++) {
			System.out.println(Product.get(i).getText()+"---"+ Price.get(i).getText());
		}
		    }
	    @Test(priority = 4)
		public void test_Result() {
			//to get all the phonenames from the search result
	    	Product=driver.findElements(By.xpath("//h3[@class='s-item__title']"));
				int noOf_Product=Product.size();
				System.out.println("Number of phones displayed="+noOf_Product);
				for(int i=0;i<=noOf_Product-1;i++)
				{
					System.out.println(Product.get(i).getText());
				}
			//to get the price of the phone from the search result	
				 Price=	driver.findElements(By.xpath("//span[@class='s-item__price']"));
				 list=Price.size();
				for(int i=0;i<=list-1;i++)
				{
					System.out.println(Price.get(i).getText());
				}
				
				}
		@Test(priority = 5)
	    public void ListToExcel() throws IOException {
			File f=new File("C:\\Users\\hrigv\\Desktop\\MEMO\\Ebay_output.xlsx");
			
			XSSFWorkbook w= new XSSFWorkbook();
			XSSFSheet s=w.createSheet("Ebayoutput");
			XSSFRow r=s.createRow(0);
			r.createCell(0).setCellValue("items");
			r.createCell(1).setCellValue("price");
			
			
			for(int i=0;i<=list-1;i++)
			{
				XSSFRow r1=s.createRow(i+1);
				r1.createCell(0).setCellValue(Product.get(i).getText());
				r1.createCell(1).setCellValue(Price.get(i).getText());
			}
			
			FileOutputStream fop=new FileOutputStream(f);
			try {
				w.write(fop);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			w.close();
			
			
			
		}
		
	
	    
	    }

		




