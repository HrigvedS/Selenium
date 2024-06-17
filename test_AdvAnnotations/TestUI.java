package test_AdvAnnotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUI {
	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("@BeforeTest - UILogin");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("@AfterTest - UILogout");
	  }
	  
  @Test(groups="ui")
  public void test_HomePage() {
	  System.out.println("test_HomePage()");
  }
  @Test(groups="ui")
  public void test_CampaignsPage() {
	  System.out.println("test_CampaignsPage()");
  }
  @Test(groups="ui")
  public void test_SlotsPage() {
	  System.out.println("test_SlotsPage()");
  }
}
