package test_AdvAnnotations;

import org.testng.annotations.Test;

public class TestDB {
  @Test(groups="db")
  public void testInsert() {
	  System.out.println("testInsert()");
  }
  @Test(groups="db")
  public void testDelete() {
	  System.out.println("testDelete()");
  }
  @Test(groups="db")
  public void testUpdate() {
	  System.out.println("testUpdate()");
  }
}
