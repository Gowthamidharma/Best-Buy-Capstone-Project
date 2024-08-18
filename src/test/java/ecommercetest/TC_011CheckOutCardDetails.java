package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.CheckCartPage;
import ecommercepages.CheckoutPage;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommercepages.SelectProductPage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_011CheckOutCardDetails extends PSMethodecommerce {
	
	// details before each test
	@BeforeTest
	public void setup() {
		testName = "tc_011Checkout";
		testDescription = "CheckOut Page Validation";
		testCategory = "Smoke";
		testAuthor = "Gowthami Dharmalingam";
		sheetName="CardDetails";
	}
	
	
	//tried to validate the CheckoutPage by passing the url but still display connection error message
	// used enable attribute to false, as this method is not proceeding because of connection error
	@Test(enabled = false, dataProvider = "getdata",priority=7)
	public void tc_010CheckOutPageFilling(String debitCardNumber,String firstName,String lastName, 
			String address, String city, String stateVisibleText,String postalCode,String expText) throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp = new Homepage(driver);
		hp.searchProduct("vaccum");
		SelectProductPage pp = new SelectProductPage(driver);
		pp.addVaccumInCart();	
		CheckCartPage cp = new CheckCartPage(driver);			
		cp.goToCheckOutPage();		
		CheckoutPage cop = new CheckoutPage(driver);
		driver.get("https://www.bestbuy.com/checkout/r/payment");
		String actText=cop.enterDetailsOnCheckOut(debitCardNumber, firstName, lastName, address, city, stateVisibleText, postalCode);
		softAssert(actText, expText);
		if(actText.equalsIgnoreCase(expText)) {
			screenShot("CheckoutPage Validation Successfull" + testName);				
		} else {
			screenShot("CheckoutPage Validation UnSuccessfull" + testName);
		}
		
	}
	
}	
