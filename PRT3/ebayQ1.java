
/*1) Perform the following test cases.
TestCase 1- Open Chrome browser and go to https://www.ebay.com/
TestCase 2- Hover your mouse to the “Electronics” element from the nav bar
TestCase 3- Click on “Apple” under Electronics Element
TestCase 4- scroll down the page until you see All listings
TestCase4- Fetch all the mobile phones listed in the product listing page(All Listings) along with their prices and Print them on the console screen
TestCase5- Create an Excel file and output all the products listed along with their prices in the Excel file*/

package PRT3;

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

public class ebayQ1 {
    WebDriver driver; // make WebDriver public
    List<WebElement> productNames;
    List<WebElement> prices;

    @BeforeClass
    public void setup() {
        try {
            // Launch browser
            driver = new ChromeDriver();
            // Maximize the window
            driver.manage().window().maximize();
            // Launch "https://ebay.com/"
            driver.get("https://ebay.com/");
            Thread.sleep(3000); // specify a wait time
            // Verify Chrome browser launch
            String pageTitle = driver.getTitle();
            Assert.assertTrue(pageTitle.contains("Electronics, Cars, Fashion, Collectibles & More | eBay"),
                    "Chrome browser launched successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        // Close Browser
        driver.quit();
    }

    @Test(priority = 1)
    public void hoverElectronicsAndClickApple() {
        WebElement electronics = driver.findElement(By.xpath("(//a[text()='Electronics'])[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(electronics).build().perform();
        try {
            Thread.sleep(3000);
            // Click on Apple
            driver.findElement(By.xpath("//a[text()='Apple']")).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement about = driver.findElement(By.xpath("//*[@id=\"gf-l\"]/li[1]/a"));
        js.executeScript("arguments[0].scrollIntoView", about);
    }

    @Test(priority = 3)
    public void fetchProductsAndPrices() {
        // Fetch all the phone names and prices from the search result
        productNames = driver.findElements(By.xpath("//h3[@class='s-item__title']"));
        prices = driver.findElements(By.xpath("//span[@class='s-item__price']"));
        // Print them on the console screen
        for (int i = 0; i < productNames.size(); i++) {
            System.out.println(productNames.get(i).getText() + "---" + prices.get(i).getText());
        }
    }

    @Test(priority = 4)
    public void createExcelFile() throws IOException {
        File file = new File("C:\\Users\\hrigv\\Desktop\\EbayOutput.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("EbayOutput");
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Item");
        headerRow.createCell(1).setCellValue("Price");

        for (int i = 0; i < productNames.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(productNames.get(i).getText());
            row.createCell(1).setCellValue(prices.get(i).getText());
        }

        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
