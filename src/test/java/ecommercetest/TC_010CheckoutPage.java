package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.CheckCartPage;
import ecommercepages.CheckoutPage;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommercepages.SelectProductPage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_010CheckoutPage extends PSMethodecommerce {

	// details before each test
	@BeforeTest
	public void setup() {
		testName = "tc_010Checkout";
		testDescription = "CheckOut Page Validation";
		testCategory = "Smoke";
		testAuthor = "Gowthami Dharmalingam";
		sheetName="CheckoutDetails";
	}
	
	
	@Test(dataProvider = "getdata", priority=1)	
	public void tc_010CheckOutPageFilling(String emailCheckOut,String mobileNumAtCheckOut,String expMsg) throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp = new Homepage(driver);
		hp.searchProduct("airfryer");
		SelectProductPage pp = new SelectProductPage(driver);
		pp.addAirfryerInProdPage();
		CheckCartPage cp = new CheckCartPage(driver);
		cp.selectNoOfItemsInAirfryer();
		waitImplicit();
		cp.goToCheckOutPage();
		CheckoutPage cop=new CheckoutPage(driver) ;
		String actMsg =cop.contactInfoAtCheckOut(emailCheckOut, mobileNumAtCheckOut);		
		softAssert(actMsg, expMsg);
		if(actMsg.equalsIgnoreCase(expMsg)) {			
			screenShot("Validating CheckOut page. - Pass"+ testName);
		} else {			
			screenShot("Validating CheckOut page. - Fail"+ testName);
		}
		 
		
   }
	
	
}
