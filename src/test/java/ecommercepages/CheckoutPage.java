package ecommercepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ecommerceprojetbase.PSMethodecommerce;

public class CheckoutPage extends PSMethodecommerce {
	
	@FindBy(id="fld-e")
	WebElement emailoSignInAtCheckOut;
	
	@FindBy(id="fld-p1")
	WebElement passToSignInAtCheckOut;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement submitSigInAtCheckOut;
	
	@FindBy(xpath="//button[text()='Continue as Guest']")
	WebElement continueAsGuest;
	
	@FindBy(id="user.emailAddress")
	WebElement emailAtCheckOut;
	
	@FindBy(id="user.phone")
	WebElement mobileNumAtCheckOut;
	
	@FindBy(xpath="//input[@id='text-updates']")
	WebElement textUpdateCheckBox;
	
	@FindBy(xpath="//span[text()='Continue to Payment Information']")
	WebElement continueToPayement;	
	
	@FindBy(xpath="//span[text()='Request failed because of network connection']")
	WebElement errormsgaftercartpage;
	
	@FindBy(xpath="//div[contains(@class,'c-alert-content rounded-r')]")
	WebElement alterrormsgaftercartpage;	
	
	@FindBy(xpath="//input[@id='number']")
	WebElement debitCardNumber;	
	
	@FindBy(id="save-to-profile")
	WebElement saveToProfile;
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(xpath="//button[text()='Hide Suggestions']")
	WebElement hideSuggestion;
	
	@FindBy(id="address-input")
	WebElement address;
	
	@FindBy(id="//button[text()='Edit this address']")
	WebElement editThisAddress;
	
	@FindBy(id="//button[text()='Add a new address']")
	WebElement addNewAddress;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="postalCode")
	WebElement postalCode;	
	
	@FindBy(id="//input[@name='password']")
	WebElement createpasswordincheckoutpage;	
	
	@FindBy(id="//p[text()='Please enter a valid card number.']")
	WebElement Validatecheckoutpage;	
	
	@FindBy(xpath="//span[text()='Place Your Order']")
	WebElement placeYourOrder;
	
	@FindBy(xpath="//p[text()='Please enter a valid card number.']")
	WebElement inValidCardMsg;	
	
		
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// method to continue as guest after checkout page
	public String contactInfoAtCheckOut(String emailCheckOut,String mobileNumAtCheckOut) throws Exception {
		clickOn(continueAsGuest);
		jsScrollUntillElement(emailAtCheckOut);
		type(this.emailAtCheckOut, emailCheckOut);
		type(this.mobileNumAtCheckOut, mobileNumAtCheckOut);
		clickOn(textUpdateCheckBox);
		clickOn(continueToPayement);
		jsScrollUntillElement(errormsgaftercartpage);		
		String actMsg= extractText(errormsgaftercartpage);
		return actMsg;
	}
	
	//method to enter details in payment page
	public String enterDetailsOnCheckOut(String debitCardNumber,String firstName,String lastName, 
			String address, String city, String stateVisibleText,String postalCode) throws Exception {
		type(this.debitCardNumber, debitCardNumber);
		type(this.firstName, firstName);
		type(this.lastName, lastName);
		type(this.address, address);
		type(this.city, city);
		selectFromDropDown(state, stateVisibleText);
		type(this.postalCode, postalCode);
		clickOn(placeYourOrder);
		String actText = extractText(inValidCardMsg);
		return actText;
	}
	
	

}
