
package ecommerceprojetbase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import ecommerceutils.Utilsecommerce;



public class PSMethodecommerce extends Utilsecommerce  {
	
	  public static ExtentSparkReporter reporter; 
	  public static ExtentReports  extent;
	  public static ExtentTest test;
	
	  
	  // extent report in before suite
	@BeforeSuite
	public void startReport() {
		System.out.println("BestBuy Automation has started Successfully");
		String extentreport= "C:\\Users\\Lishanth\\eclipse-workspace\\ecommerceprojet\\ExtentReportEcommerce1.html";
		reporter = new ExtentSparkReporter(extentreport);		
		reporter.config().setReportName("Ecommerce Extent Report");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	
	// information to be extended before each class
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	// passing the browser in parameter in before method
	@Parameters("browser")
	@BeforeMethod
	public void start(String browser) throws Exception {
		launchBrowser(browser);
		getApplication(readProperty("url"));
	}
	
	
	// quit the browser after method
	@AfterMethod 
	public void close() {
		  driver.quit();
		  }
	 
	// message after extent report and we flush report in listener class
	@AfterSuite
	public void endReport() {
		System.out.println("BestBuy Automation has completed Successfully");
		
	}
	
	// providing data to the methods
	@DataProvider (name="getdata")
	public String[][] getdata() throws Exception {
		
		String[][] data= readexcel(sheetName);
		return data;
		
	}	
	
	 
	 
}
	
	
	
	
	

	
		
		