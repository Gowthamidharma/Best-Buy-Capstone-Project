package ecommercepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ecommerceprojetbase.PSMethodecommerce;

public class Signinpage  extends PSMethodecommerce {

	@FindBy(id="fld-e")
	WebElement email;
	
	@FindBy(id="fld-p1")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signInButton;
	
	@FindBy(xpath="//a[text()='Visit our homepage']")
	WebElement goToHomePage;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	WebElement forgotpassword;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement resetpasswordwithemail;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continuetoresetpassword;
	
	@FindBy(xpath="//div[text()='Sorry, something went wrong. Please try again.']")
	WebElement errormsg;
	
	
	public Signinpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// method for sign in 
	public String signInFunctionality(String email, String password,String textXpath) throws Exception {
		type(this.email, email);
		type(this.password, password);
		clickOn(signInButton);
		String actMsg=driver.findElement(By.xpath(""+textXpath+"")).getText();
		return actMsg;
	}
	
	// method for forgot password 
	public String forgotpasswordFunctionality(String email,String textXpath) {
		clickOn(forgotpassword);		
		type(this.resetpasswordwithemail,email);
		clickOn(continuetoresetpassword);
		String actMsg=driver.findElement(By.xpath(""+textXpath+"")).getText();
		return actMsg;
				
	}	

	// method check for broken links in forgot password page
	public void forgotpasswordPagetoValidatebrokenLink() {
		clickOn(forgotpassword);
			
	}
	
}
