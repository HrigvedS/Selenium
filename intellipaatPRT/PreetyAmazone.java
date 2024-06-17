package intellipaatPRT;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreetyAmazone {
	
    public static void main(String[] args) {
     
        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open eBay
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        // Hover over the Electronics element in the nav bar
        
        WebElement leave = driver.findElement(By.xpath("(//a[text()='Electronics'])[2]"));
		Actions act=new Actions(driver);
		act.moveToElement(leave).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/div[2]/div[1]/nav[2]/ul/li[1]/a"))).click();

        // Scroll to page height
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        // Getting all mobile list
        List<WebElement> allMobileList = driver.findElements(By.xpath("//li[@class='s-item s-item--large']"));

        List<String> mobileName = new ArrayList<>();
        List<String> mobilePrice = new ArrayList<>();

        for (WebElement mobile : allMobileList) {
            List<WebElement> names = mobile.findElements(By.xpath(".//h3[@class='s-item__title']"));
            for (WebElement name : names) {
                mobileName.add(name.getText());
            }

            List<WebElement> prices = mobile.findElements(By.xpath(".//span[@class='s-item__price']"));
            for (WebElement price : prices) {
                mobilePrice.add(price.getText());
            }
        }

        System.out.println(mobileName);
        System.out.println(mobilePrice);
        
                
                    // TestCase 5: Fetch all the mobile phones listed in the product listing page (All Listings)
        	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='s-item s-item--large']")));

                    List<WebElement> mobilePhones = driver.findElements(By.xpath("//li[@class='s-item s-item--large']"));

                    // TestCase 6: Create an Excel file and output all the products listed along with their prices
                    try (XSSFWorkbook workbook = new XSSFWorkbook()) {
                    XSSFSheet sheet = workbook.createSheet("Mobile Phones");

                    int rowNum = 0;
                    for (WebElement phone : mobilePhones) {
                        Row row = sheet.createRow(rowNum++);
                        row.createCell(0).setCellValue(phone.findElement(By.xpath(".//h3[@class='s-item__title']")).getText());
                        row.createCell(1).setCellValue(phone.findElement(By.xpath(".//span[@class='s-item__price']")).getText());
                    }

                    // Save the workbook to a file
                   FileOutputStream fileOut = new FileOutputStream("\"C:\\Users\\hrigv\\Desktop\\MobilePhones.xlsx");
                        workbook.write(fileOut);
                        fileOut.close();
                  
                        System.out.println("Excel file created successfully.");
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   
                    // Close the browser
                    driver.quit();
                    }
    }