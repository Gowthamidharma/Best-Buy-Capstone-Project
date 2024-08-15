package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_005ValidateMenu extends PSMethodecommerce {
	
	// details before each test
	@BeforeTest
	public void setup() {
		testName = "tc_005validateMenu";
		testDescription = "Check the different Menu titles";
		testCategory = "Regression";
		testAuthor = "Gowthami Dharmalingam";
		sheetName="MenuTestCase";
	}
	
	
	@Test(dataProvider="getdata",priority = 2)
	public void tc_005validateMenu(String menuName,String expTitle) throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp=new Homepage(driver);
		String actTitle = hp.menuValidation(menuName);
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			screenShot("Validating the Title of different Menu - Pass"+ testName);
		} else {
			screenShot("Validating the Title of different Menu - Fail"+ testName);
		}
	}

}
