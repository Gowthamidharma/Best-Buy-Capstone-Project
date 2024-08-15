package ecommerceutils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import ecommerceprojetbase.PSMethodecommerce;

public class ListenerEcommerce extends PSMethodecommerce implements ITestListener {

	
	@Override
	public void onTestStart(ITestResult result) {
		
		// TODO Auto-generated method stub
		
		test = extent.createTest(result.getMethod().getMethodName()); 		
		 
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test passed");
		String filepath= testName;
		try {
			filepath = screenShot(result.getMethod().getMethodName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
		
	}
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		
		String filepath = null;
		try {
			filepath = screenShot(result.getMethod().getMethodName());			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		
		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
	}	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test skipped");
	}


	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Failed with TimeOut Exception");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}	
	
	
}

