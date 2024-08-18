package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.CheckCartPage;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommercepages.SelectProductPage;
import ecommercepages.Signinpage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_013AddtionalTask2 extends PSMethodecommerce {
	
	// details before each test
	@BeforeTest	
	public void setup() {
		testName = "tc_013_AdditionalTask2";
		testDescription = " Validating ForgotPassword, OfferMsgForPremimumProduct";
		testCategory = "Sanity";
		testAuthor = "Gowthami Dharmalingam";
		sheetName="ForgotPasswordTestCase";
	}
	
	
	
	@Test(dataProvider="getdata",priority = 4)
	public void tc_013_A_ForgotpasswordFunctionality(String email,String xpath,String expMsg) throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp=new Homepage(driver);
		hp.goToSignIn();
		Signinpage sp=new Signinpage(driver);
		String actMsg = sp.forgotpasswordFunctionality(email,xpath);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			screenShot("Validating Sign-In ForgotPassword - Pass"+ testName);
		} else {
			screenShot("Validating Sign-In ForgotPassword - Fail"+ testName);
		}
	}

	
	
	@Test(priority = 1)
	public void tc_013_B_AddItemByDeptMenuWithOffer() throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp = new Homepage(driver);
		hp.selectTheardmillbyDeptInHomePage();
		SelectProductPage pp = new SelectProductPage(driver);
		String ThreadmillatProdPage = pp.addTreadmillInProdPageWithOffer();
		hp.goToCartPage();
		CheckCartPage cp = new CheckCartPage(driver);
		String ThreadMillatCartPage = cp.validateTreadMillInCartwithOffer();
		softAssert(ThreadMillatCartPage, ThreadmillatProdPage);
		if (ThreadMillatCartPage.equals(ThreadmillatProdPage)) {
			screenShot("Validating Product Title - Pass"+ testName);
		} else {
			screenShot("Validating Product Title - Fail"+ testName);
		}
		String actOfferMsg=cp.validateTreadMillInCartwithOfferMsg();
		String expOfferMsg="As a Plus member you’d save $400.00 on this order.";
		hardAssert(actOfferMsg, expOfferMsg);
		if(actOfferMsg.equalsIgnoreCase(expOfferMsg)) {
			screenShot("Validating Product Title - Pass"+ testName);			
		} else {
			screenShot("Validating Product Title - Fail"+ testName);
		}
		
		
	}
	
}
