package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.CheckCartPage;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommercepages.SelectProductPage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_008AddItemByDept extends PSMethodecommerce {
	
	// details before each test
	@BeforeTest
	public void setup() {
		testName = "tc_008AddItemByDept";
		testDescription = "Adding Item in Cart by Dept and Validation";
		testCategory = "Sanity";
		testAuthor = "Gowthami Dharmalingam";
	}
	
	@Test(priority=1)
	public void tc_008AddItemByDeptMenu() throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp = new Homepage(driver);
		hp.selectTheardmillbyDeptInHomePage();
		SelectProductPage pp = new SelectProductPage(driver);
		String ThreadmillatProdPage = pp.addThreadmillInProdPage();
		hp.goToCartPage();
		CheckCartPage cp = new CheckCartPage(driver);
		String ThreadMillatCartPage = cp.validateThreadMillInCart();
		softAssert(ThreadMillatCartPage, ThreadmillatProdPage);
		if (ThreadMillatCartPage.equals(ThreadmillatProdPage)) {
			screenShot("Validating Product Title - Pass"+ testName);
		} else {
			screenShot("Validating Product Title - Fail"+ testName);
		}
	}

}
