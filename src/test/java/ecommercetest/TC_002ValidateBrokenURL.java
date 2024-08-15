package ecommercetest;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.FirstSelectcountry;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_002ValidateBrokenURL extends PSMethodecommerce {
	
	// details before each test
	@BeforeTest
	public void setup() {
		testName = "tc_002validatebrokenurl";
		testDescription = "Check For Broken URL";
		testCategory = "Smoke";
		testAuthor = "Gowthami Dharmalingam";
	}
	

	@Test(priority = 2)
	public void tc_002validatebrokenurl() throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		if (url.urlResponseCode()==200) {
			screenShot("Validating Best Buy page URL is broken or not - Pass"+ testName);
		} else {
			screenShot("Validating Best Buy page URL is broken or not - Fail"+ testName);
		}
		AssertJUnit.assertTrue(url.urlResponseCode()==200);
	}

}
