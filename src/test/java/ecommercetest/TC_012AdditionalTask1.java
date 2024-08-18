package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.Createaccountpage;
import ecommercepages.FirstSelectcountry;
import ecommercepages.Homepage;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_012AdditionalTask1 extends PSMethodecommerce {
	
	
	// details before each test
	@BeforeTest	
	public void setup() {
		testName = "tc_012_AdditionalTask1";
		testDescription = "Validating SearchBox, CreateBusinessAccount, BrokenLinksOfSignInPage ";
		testCategory = "Regression";
		testAuthor = "Gowthami Dharmalingam";
		sheetName="SearchBoxFuntionality";
	}
	
	
	@Test(dataProvider = "getdata",priority = 5)
	public void tc_012_A_SearchBoxValidation(String Input, String ExpText) throws Exception {
		FirstSelectcountry url=new 	FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp = new Homepage(driver);
		String actText=hp.SearchBoxValidation(Input);
		softAssert(actText, ExpText);
		if(actText.equalsIgnoreCase(ExpText)) {
			screenShot("Validating SearchBox Functionality - Pass"+ testName);
		} else {
			screenShot("Validating SearchBox Functionality - Pass"+ testName);
			
		}
	}				
			
	@Test(priority=6)
	public void tc_012_B_validateBusinessAccount() throws Exception {
		FirstSelectcountry url=new FirstSelectcountry(driver);
		url.deliveryAtUSA();
		Homepage hp=new Homepage(driver);
		hp.goToCreatAccount();
		Createaccountpage cap= new Createaccountpage(driver);
		String expTitle="Create an Account - Create a business account - Best Buy";
		String actTitle= cap.createBussinessAccount();
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			screenShot("Validating BusinessAccount Functionality - Pass"+ testName);
		} else {
			screenShot("Validating BusinessAccount Functionality - Fail"+ testName);
		}
		
	}
		
		
		@Test
		public void tc_012_C_ValiadateBrokenLinksInSignInPage() throws Exception {
			FirstSelectcountry url=new FirstSelectcountry(driver);
			url.deliveryAtUSA();
			Homepage hp = new Homepage(driver);
			hp.goToSignIn();			
			hp.brokenLinkFinder();
			screenShot("Validating Broken Links In SignIn page " + testName);
			
		}
		
		
}
