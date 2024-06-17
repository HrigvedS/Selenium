package frameworks.HybrideKeywordDataDriven;

import java.io.IOException;

import org.testng.annotations.Test;

public class DriverScript {
  @Test
  public void setup() throws IOException, InterruptedException {
	  String spath="D:\\Trainings_BhanuSai\\WeekendBatch_July29th_2023\\Automation\\myAutomationProject\\src\\test\\resources\\alResourceFiles\\HybrideDriven.xlsx";
	  ExcelUtils.setExcelFile(spath,"Sheet1");
	  for(int iRow=1;iRow<=6;iRow++)
	  {
		  String sActionKeywords=ExcelUtils.getCellData(iRow,3);
		  String sTestData=ExcelUtils.getCellData(iRow,4);
		  if(sActionKeywords.equals("openBrowser"))
		  {
			  Actionkeywords.openBrowser();
		  }
		  else if(sActionKeywords.equals("navigate"))
		  {
			  Actionkeywords.navigate(sTestData);
		  }
		  else if(sActionKeywords.equals("inputUserName"))
		  {
			  Actionkeywords.inputUserName(sTestData);
		  }
		  else if(sActionKeywords.equals("inputPassword"))
		  {
			  Actionkeywords.inputPassword(sTestData);
		  }
		  else if(sActionKeywords.equals("clickSigin"))
		  {
			  Actionkeywords.clickSigin();
		  }
		  else if(sActionKeywords.equals("closeBrowser"))
		  {
			  Actionkeywords.closeBrowser();
		  }	
		  
	  }
  }
}
