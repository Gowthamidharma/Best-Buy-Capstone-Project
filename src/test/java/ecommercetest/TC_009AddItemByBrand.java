package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.CheckCartPage;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommercepages.SelectProductPage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_009AddItemByBrand extends PSMethodecommerce {
	
	// details before each test
	@BeforeTest
	public void setup() {
		testName = "tc_009AddItemByBrand";
		testDescription = "Add Item by Brands and Validation";
		testCategory = "Sanity";
		testAuthor = "Gowthami Dharmalingam";
	}
	

	@Test(priority = 2)
	public void tc_009AddItemShopByBrandMenu() throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp = new Homepage(driver);
		hp.selectDellBrandInHomePage();
		SelectProductPage pp = new SelectProductPage(driver);
		String DellGamingTitleAtProdPage = pp.addDellGamingInProdPage();
		hp.goToCartPage();
		CheckCartPage cp = new CheckCartPage(driver);
		String DellGamingAtCartPage = cp.validateDellInCart();
		softAssert( DellGamingAtCartPage,DellGamingTitleAtProdPage);
		if ( DellGamingAtCartPage.equals(DellGamingTitleAtProdPage)) {
			screenShot("Validating Product Title - Pass" + testName);
		} else {
			screenShot("Validating Product Title - Fail" + testName);
		}
	}

}
