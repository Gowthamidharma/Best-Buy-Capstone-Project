package ecommercetest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ecommercepages.FirstSelectcountry;
import ecommerceprojetbase.PSMethodecommerce;

public class TC_001NavigatetoURL extends PSMethodecommerce {
	
	
		// details before each test
	  @BeforeTest 
	  public void setup() { 
		  testName = "tc_001navigatToBestBest";
		  testDescription = "Navigating to the Best Buy e-commerce website";
		  testCategory = "Smoke"; 
		  testAuthor = "Gowthami Dharmalingam"; 
		  }
	 
	 
	
	   @Test(priority = 4)
		public void tc_001navigatToBestBest() throws Exception {
		FirstSelectcountry url =new FirstSelectcountry(driver);
		String actTitle = url.bestBuyPageTitle();
		String expTitle="Best Buy International: Select your Country - Best Buy";
		softAssert(actTitle, expTitle);
		if (actTitle.equalsIgnoreCase(expTitle)) {
			screenShot("Validating Best Buy Page Title - Pass "+ testName );
			} else	{
			screenShot("Validating Best Buy Page Title - Fail" + testName);
		}

	}
		

}
