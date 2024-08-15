package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.CheckCartPage;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommercepages.SelectProductPage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_007SearchAddItemInCart extends PSMethodecommerce {
	
	// details before each test
	@BeforeTest
	public void setup() {
		testName = "tc_007SearchAddItemInCart";
		testDescription = "Adding Item In Cart With SearchBox and Validation";
		testCategory = "Smoke";
		testAuthor = "Gowthami Dharmalingam";
	}
	
	
	@Test(priority=3)
	public void tc_007SearchAddItemInCart() throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp = new Homepage(driver);
		hp.searchProduct("Kettle");
		SelectProductPage pp = new SelectProductPage(driver);
		String prodTitleAtProductPage = pp.addKettleInProdPage();		
		CheckCartPage cp = new CheckCartPage(driver);
		String prodTitleAtCartPage = cp.validateKettleInCart();		
		softAssert(prodTitleAtProductPage, prodTitleAtCartPage);
		if (prodTitleAtProductPage.equals(prodTitleAtCartPage)) {
			screenShot("Validating Product Title - Pass"+ testName);
		} else {
			screenShot("Validating Product Title - Fail"+ testName);
		}
		
		
	}

}
