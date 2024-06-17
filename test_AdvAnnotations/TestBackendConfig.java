package test_AdvAnnotations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestBackendConfig {
 
 

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("@BeforeSuite - setup");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("@AfterSuite - teardown");
  }

  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("@BeforeTest - Login");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("@AfterTest - Logout");
  }
}
