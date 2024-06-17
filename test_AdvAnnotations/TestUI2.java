package test_AdvAnnotations;

import org.testng.annotations.Test;

public class TestUI2 {
	  
	  
  @Test(groups="ui")
  public void test_HomePage1() {
	  System.out.println("test_HomePage1()");
  }
  @Test(groups="ui")
  public void test_CampaignsPage1() {
	  System.out.println("test_CampaignsPage1()");
  }
  @Test(groups="ui")
  public void test_SlotsPage1() {
	  System.out.println("test_SlotsPage1()");
  }
}
