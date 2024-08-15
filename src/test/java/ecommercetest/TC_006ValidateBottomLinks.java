package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_006ValidateBottomLinks extends PSMethodecommerce {

	// details before each test
	@BeforeTest
	public void setup() {
		testName = "tc_006validatebottomlink of Homepage ";
		testDescription = "Link in HomePage bottom is broken or not";
		testCategory = "Sanity";
		testAuthor = "Gowthami Dharmalingam";
		sheetName="BottomLink";
	}
	
	
	@Test(dataProvider = "getdata", priority = 3)
	public void tc_006validatebottomlink(String bottommenu, String expTitle) throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp=new Homepage(driver);
		String actTitle = hp.validateBottomLink(bottommenu);	
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			screenShot("Validating the Title of link in bottom of Home Page - Pass"+ testName);
		} else {
			screenShot("Validating the Title of link in bottom of Home Page - Fail"+ testName);
		}
	}
}
