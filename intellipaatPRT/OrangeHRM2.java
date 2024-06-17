package intellipaatPRT;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OrangeHRM2 {
	public static void main(String[] args) throws InterruptedException, IOException {
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

         	// TestCase1: Open Chrome Browser & Go to the specified URL
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();
            Thread.sleep(5000);
            // TestCase2: Login using credentials given on the website.
             driver.findElement(By.name("username")).sendKeys("Admin");
             Thread.sleep(5000);
             driver.findElement(By.name("password")).sendKeys("admin123");
             Thread.sleep(5000);
             driver.findElement(By.tagName("button")).click();
             Thread.sleep(5000);
          
            // TestCase3: Click "Time" from the Navigation bar
            driver.findElement(By.xpath("//span[text()='Time']")).click();
            Thread.sleep(5000);
     
            // TestCase4: Click on "Attendance" drop down List and then click on "Employee records"
            
         // Scenario-Select- Selecting from a drop down menu
    		WebElement leave = driver.findElement(By.xpath("//span[text()='Attendance ']"));
    		Actions act=new Actions(driver);
    		act.moveToElement(leave).click().perform();

    		driver.findElement(By.xpath("//a[text()='Employee Records']")).click();
            // Wait for a moment for the records to load
            Thread.sleep(2000);

            // Printing records
            java.util.List<WebElement> allRecords = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));
            for (WebElement record : allRecords) {
                System.out.println(record.getText().replace("\n", "\t"));
            }
    	
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Records");

            int rowCount = 0;

            // Assuming records is a List<WebElement>
            java.util.List<WebElement> records = driver.findElements(By.xpath("//div[@class='oxd-table-body']/div"));

            if (records != null && !records.isEmpty()) {
                for (WebElement record : records) {
                    XSSFRow row = sheet.createRow(rowCount++);
                    String[] recordDetails = record.getText().split("\n");

                    int columnCount = 0;
                    for (String detail : recordDetails) {
                        XSSFCell cell = row.createCell(columnCount++);
                        cell.setCellValue(detail.trim());
                    }
                }

                FileOutputStream fileOut = new FileOutputStream("orangehrm_records.xlsx");
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
            } else {
                System.out.println("No records found.");
            }


       }
 
	}