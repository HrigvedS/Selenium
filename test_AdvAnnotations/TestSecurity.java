package test_AdvAnnotations;

import org.testng.annotations.Test;

public class TestSecurity {
  @Test(groups="security")
  public void accessAdminPage() {
	  System.out.println("accessAdminPage()");
  }
  @Test(groups="security")
  public void accessPaymentPage() {
	  System.out.println("accessPaymentPage()");
  }
  @Test(groups="security")
  public void accessRulesMapping() {
	  System.out.println("accessRulesMapping()");
  }
}
