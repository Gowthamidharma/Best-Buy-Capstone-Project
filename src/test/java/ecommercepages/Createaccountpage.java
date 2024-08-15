package ecommercepages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ecommerceprojetbase.PSMethodecommerce;


public class Createaccountpage extends PSMethodecommerce {
	
	
		@FindBy(id="firstName")
		WebElement firstName;
		
		@FindBy(id="lastName")
		WebElement lastName;
		
		@FindBy(id="email")
		WebElement email;
		
		@FindBy(id="fld-p1")
		WebElement password;
		
		@FindBy(id="reenterPassword")
		WebElement confirmPassword;
		
		@FindBy(id="phone")
		WebElement mobileNumber;
		
		@FindBy(id="is-recovery-phone")
		WebElement recoveryCheckBox;
		
		@FindBy(xpath="//button[text()='Create an Account']")
		WebElement creatAnAccount;
		
		@FindBy(id="//*[text()='Sign Up with Google']")
		WebElement googleSignUp;
		
		@FindBy(xpath= "//a[text()='Create a business account']")	
		WebElement createBussinessAccount;
		
		@FindBy(xpath="//a[text()='Create a Business Account']")
		WebElement BusinesAccount;
		
		@FindBy(xpath="//a[text()='Return to previous page']")
		WebElement clickPreviouspage;
		
		
		public Createaccountpage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
		
		//method to validate create Account
		public String creatAccountFunctionality(String fName, String lName, String email,
				String password, String confirmPassword,String mobileNumber, String textXpath) {
			type(firstName, fName);
			type(lastName, lName);
			type(this.email, email);
			type(this.password, password);
			type(this.confirmPassword, confirmPassword);
			type(this.mobileNumber, mobileNumber);
			clickOn(creatAnAccount);
			String actMsg=driver.findElement(By.xpath(""+textXpath+"")).getText();
			return actMsg;
		}
		
		//method to validate create Business Account
		public String createBussinessAccount() throws Exception {
			clickOn(createBussinessAccount);
			clickOn(BusinesAccount);
			String actTitle = getPageTitle();			
			screenShot("Create Business Account");
			return actTitle;
			
		}
		
		

}
