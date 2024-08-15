
package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.Createaccountpage;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_004CreateAccount extends PSMethodecommerce {
	
	// details before each test
	@BeforeTest
	public void setup() {
		testName = " tc_004_validateCreatAccount";
		testDescription = "CreatAccount Functionality";
		testCategory = "Smoke";
		testAuthor = "Gowthami Dharmalingam";
		sheetName="CreateAcTestCase";
	}
	
	
	
	@Test(dataProvider="getdata", priority=1)
	public void tc_004_validateCreatAccount(String fname, String lname, String emailId,
			String pass, String repass, String mob, String xpathText, String expMsg) throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp=new Homepage(driver);
		hp.goToCreatAccount();
		Createaccountpage cap= new Createaccountpage(driver);
		String actMsg = cap.creatAccountFunctionality(fname, lname, emailId, pass, repass, mob, xpathText);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			screenShot("Validating CreatAccount Functionality - Pass"+ testName);
		} else {
			screenShot("Validating CreatAccount Functionality - Fail"+ testName);
		}
	}
	
	
}	
		
		


