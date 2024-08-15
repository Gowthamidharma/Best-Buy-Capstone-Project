package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommercepages.Signinpage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_003SignIn extends PSMethodecommerce {
	
	// details before each test
	@BeforeTest
	public void setup() {
		testName = "tc_003SignIn";
		testDescription = "Sign-In Functionality";
		testCategory = "Smoke";
		testAuthor = "Gowthami Dharmalingam";
		sheetName="SigninTestCase";
	}
	
	@Test(dataProvider="getdata",priority = 4)
	public void tc_003SignIn(String email, String password, String xpath, String expMsg) throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp=new Homepage(driver);
		hp.goToSignIn();
		 Signinpage sp=new Signinpage(driver);
		String actMsg = sp.signInFunctionality(email,password,xpath);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			screenShot("Validating Sign-In Functionality - Pass"+ testName);
		} else {
			screenShot("Validating Sign-In Functionality - Fail"+ testName);
		}
	}	
	
	
}
	
	
	
