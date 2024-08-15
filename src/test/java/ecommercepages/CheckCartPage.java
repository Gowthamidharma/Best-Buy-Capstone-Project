package ecommercepages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ecommerceprojetbase.PSMethodecommerce;

public class CheckCartPage extends PSMethodecommerce {
	

	@FindBy(xpath="//select[@class='tb-select']")
	WebElement selectNumberinKettle;
	
	@FindBy(xpath="//a[contains(text(),'Zojirushi - Micom 3L Water Boiler & Warmer - Silver Dark Brown')]")
	WebElement KettleTitleatCartpage;
	
	@FindBy(xpath="//a[contains(text(),'Bella Pro Series - 4.2-qt. Digital Air Fryer - Black')]")
	WebElement AirfryerTitleCartPageText;
	
	@FindBy(xpath="//select[@class='tb-select']")
	WebElement selectNumberinAirfryer;
	
	@FindBy(xpath="//a[text()='ProForm - Carbon TL - Black']")
	WebElement ThreadMillTitleCartPageText2;	
	
	@FindBy(xpath="//a[contains(text(),'NordicTrack T Series 8.5 S Treadmill - Black'])")
	WebElement ThreadMillTitleCartPageText;	
	
	
	@FindBy(xpath="//img[@alt='NordicTrack T Series 8.5 S Treadmill - Black']")
	WebElement altThreadMillTitleCartPageText;	
	
	@FindBy(xpath="//h2[@class='my-bby-banner__title']")
	WebElement actOfferMsg;	
	
	@FindBy(xpath="//button[@class='c-close-icon c-modal-close-icon']")
	WebElement ThreadMillcloseofferPopup;
	
	@FindBy(xpath="//a[contains(text(),'Sony - 75\" Class BRAVIA XR X90K 4K HDR Full Array LED Google TV')]")
	WebElement sony75InchTvAddedInCart;
	
	@FindBy(xpath="//a[contains(text(),'Dell - S3222DGM 32\" LED Curved QHD FreeSync Gaming')]")
	WebElement DellGamingAddedInCart;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkOutInCart;
	
	
	
	public CheckCartPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	// method to get the product text from the product page for validating in cart page
	public String validateKettleInCart() {
		return extractText(KettleTitleatCartpage);
	}
	
	// method to get the product text from the product page for validating in cart page
	public String validateAirfryerInCart() {
		return extractText(AirfryerTitleCartPageText);
	}
	
	
	// method to get the product text from the product page for validating in cart page
	public String validateThreadMillInCart() {	
		
		return extractText(ThreadMillTitleCartPageText2);
	}
	
	// method to get the product text from the product page	for validating in cart page
	public String validateThreadMillInCartwithOffer() {	
		PopUpwaitFluent();
		return extractText(altThreadMillTitleCartPageText);
	}
	
	// method to get the product text from the product page for validating in cart page
	public String validateThreadMillInCartwithOfferMsg() {
		PopUpwaitFluent();
		return extractText(actOfferMsg);
	}	
		
	// method to get the product text from the product page for validating in cart page
	public String validateDellInCart() {
		return extractText(DellGamingAddedInCart);
	}
	
	//method to increase the select item number in cart page
	public void selectNoOfItemsInKettle() {
		selectFromDropDown(selectNumberinKettle, "2");
	}
	
	//method to increase the select item number in cart page
	public void selectNoOfItemsInAirfryer() {
		selectFromDropDown(selectNumberinAirfryer, "2");
	}
	
	//method for checkout
	public void goToCheckOutPage() {
		waitExplicit(checkOutInCart);
		clickOn(checkOutInCart);
	}
	

}
