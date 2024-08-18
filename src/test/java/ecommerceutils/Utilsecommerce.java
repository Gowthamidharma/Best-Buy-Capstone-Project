package ecommerceutils;

import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilsecommerce {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static ExtentReports extent; 
	public static ExtentTest test;	
	public String sheetName;
	public String testName;
	public String testDescription;
	public String testCategory;
	public String testAuthor;	
	
	
	public static String readProperty(String key) throws Exception {
		String filepath = "C:\\Users\\Lishanth\\eclipse-workspace\\ecommerceprojet\\src\\test\\resources\\Bestbuy.properties";
		File file = new File(filepath);
		FileInputStream fileInput = new FileInputStream(file);
		prop = new Properties();
		prop.load(fileInput);
		return prop.get(key).toString();
	}
	
	
	public static void getApplication(String url) {
		driver.get(url);
	}	
	
	public static int getResponseCode(String url) throws Exception, Exception {
		URL link = new URL(url);
		HttpURLConnection connect = (HttpURLConnection) link.openConnection();
		int responseCode = connect.getResponseCode();
		return responseCode;
	}
	

	public static void launchBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");			
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--disable-notifications");			
			driver = new FirefoxDriver(options);
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			driver= new EdgeDriver(options);
		} else {
			System.out.println("Opening Chrome browser as Default browser");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		waitPageloadTimeout();
		driver.manage().window().maximize();
		waitImplicit();
	}
	
	
	public static void waitPageloadTimeout() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(35));
	}
	
	
	public static void waitImplicit() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
	}	

	public static void waitExplicit(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitExplicitString(By Locator) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
	
	public static void waitExplicitforclickable(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitExplicitforselectable(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	

	public static void waitExplicitUntillTitle(String titleToWait) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs(titleToWait));
	}	

	public static void type(WebElement element, String text) {
		waitExplicit(element);
		element.clear();
		element.sendKeys(text);
	}

	public static void clickOn(WebElement element) {
		waitExplicit(element);
		element.click();
	}
	
	public static void clickOnclickable(WebElement element) {
		waitExplicitforclickable(element);
		element.click();
	}
	
	public static void clickOnSelectable(WebElement element) {
		waitExplicitforselectable(element);
		element.click();
	}

	public static String getPageTitle() {
		waitExplicitUntillTitle(driver.getTitle());
		return driver.getTitle();
	}

	public static String extractText(WebElement element) {
		waitExplicit(element);
		return element.getText();
	}
	
	 public void performMouseAction(WebElement element, String actionType) {
	        Actions actions = new Actions(driver);
	        switch (actionType) {
	            case "hover":
	                actions.moveToElement(element).perform();
	                break;
	            case "click":
	                actions.click(element).perform();
	                break;
	            case "doubleClick":
	                actions.doubleClick(element).perform();
	                break;
	            case "rightClick":
	                actions.contextClick(element).perform();
	                break;	           
	            default:
	                System.out.println("Invalid action type");
	        }
	 }
    

	
	public static void PopUpwaitFluent() {
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(100));
		 try {
			 if(wait1.until(ExpectedConditions.alertIsPresent())!= null);
			  driver.switchTo().alert().dismiss();		 	
		  	  
		    } catch (Exception e) {
		    	System.out.println("No Pop-Up Displayed");			     
		 
		    }
		 
	}	

	public static String getAlertmessage(WebElement element) {
		waitExplicit(element);
		Alert alert= driver.switchTo().alert();
		String alertmsg = alert.getText();
		return alertmsg;
	}
	
	public static void acceptAlert(WebElement element) {
		waitExplicit(element);
		Alert alert= driver.switchTo().alert();
		alert= driver.switchTo().alert();
		alert.accept();	
		
	}	

	public static String[][] readexcel(String sheetName) throws Exception   {
		
		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\Lishanth\\eclipse-workspace\\ecommerceprojet\\src\\test\\resources\\EcommerceBestBuy.xlsx");
		
		XSSFSheet sheet= book.getSheet(sheetName);
		
		int rowcount = sheet.getLastRowNum();
		
		short coloumncount=sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowcount][coloumncount];
		
		for (int i=1; i<=rowcount; i++) {
			XSSFRow row = sheet.getRow(i);		
		
			for (int j =0; j<coloumncount; j++ ) { 
				XSSFCell cell=row.getCell(j);
			//System.out.println("Read Excel "+ cell.getStringCellValue());
				
			data[i-1][j]=cell.getStringCellValue();	
	}
		
		}
		
		book.close();	
		return data;			
		
	}

	public static void selectFromDropDown(WebElement element, String visibleText) {
		waitExplicit(element);
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public static void titleAssertion(String expTitle) {
		Assert.assertEquals(getPageTitle(), expTitle);
	}

	public static void jsScrollUntillElement(WebElement element) {
		waitExplicit(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void jsscrollUntilInput(By Locator) {
		waitExplicitString(Locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Locator);
			
	}

	public static void jsClickOn(WebElement element) {
		waitExplicit(element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	public static void sendkeys(WebElement element,String value) {
		element.sendKeys(value);
	}
	
	
	public static String screenShot(String testName) throws Exception {
		waitImplicit();		
		String filepath ="C:\\Users\\Lishanth\\eclipse-workspace\\ecommerceprojet\\ScreenshotEcommerce" +testName+ ".png";
		File src = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File(filepath);
		FileUtils.copyFile(src, des);
		return filepath;
	}
		
	
	public static void softAssert(String actResult, String expResult) {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actResult, expResult);
	}
	
	public static void hardAssert(String actResult,String expResult) {
		Assert.assertEquals(actResult, expResult);
	}
	

}
