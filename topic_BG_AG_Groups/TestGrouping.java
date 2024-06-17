package topic_BG_AG_Groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestGrouping {
//UI
 @BeforeGroups("ui")
 public void setupUI()
 {
	 System.out.println("setupUI");
 }
 @AfterGroups("ui")
 public void tearDownUI()
 {
	 System.out.println("tearDownUI");
 }
 
//security
@BeforeGroups("security")
public void setupSecurity()
{
	 System.out.println("setupSecurity");
}
@AfterGroups("security")
public void tearDownSecurity()
{
	 System.out.println("tearDownSecurity");
}
//database
@BeforeGroups("db")
public void setupDB()
{
	 System.out.println("setupDB");
}
@AfterGroups("db")
public void tearDownDB()
{
	 System.out.println("tearDownDB");
}


//RealTestCases for UI
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

//RealTestCases for Security
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

//Real TestCases for DB
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
