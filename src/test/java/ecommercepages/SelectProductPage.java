package ecommercepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ecommerceprojetbase.PSMethodecommerce;

public class SelectProductPage extends PSMethodecommerce  {	
	

		@FindBy(xpath="//span[contains(text(),'Zojirushi - Micom 3L Water Boiler & Warmer - Silver Dark Brown')]")
		WebElement KettleSearch;
		
		@FindBy(xpath="//h1[contains(text(),'Zojirushi - Micom 3L Water Boiler & Warmer')]")
		WebElement KettleProductPageText;	
		
		@FindBy(xpath="//button[contains(@class,'c-button c-button-primary c-button-lg c-button-block c-button')]")
		WebElement KettleCartButton;
		
		@FindBy(xpath="//a[text()='Go to Cart']")
		WebElement goToCartButton;
		
		@FindBy(xpath="//button[text()='Continue shopping']")
		WebElement continueShoping;
		
		@FindBy(xpath="//span[contains(text(),'Bella Pro Series - 4.2-qt')]")
		WebElement AirfryerSearch;
		
		@FindBy(xpath="(//img[@alt='Bella Pro Series - 4.2-qt. Digital Air Fryer - Black'])[1]")
		WebElement altAirfryerSearch;
		
		@FindBy(xpath="//h1[contains(text(),'Bella Pro Series - 4.2-qt')]")
		WebElement AirfryerProductPageText;
	
		@FindBy(xpath="//span[text()='Save']")	 
		WebElement altforAirfryeraddtocart1;
		
		@FindBy(xpath="//strong[text()='Pickup']")	 
		WebElement altforAirfryeraddtocart2;	
		
		@FindBy(xpath="//button[contains(@class,'c-button c-button-primary c-button-lg c-button')]")
		WebElement AirfryerCartButton;
		
		@FindBy(xpath="(//span[text()='$1,599.00'])[3]")
		WebElement alternativeforThreadmillSearch;
		
		
		@FindBy(xpath="//img[@alt='NordicTrack T Series 8.5 S Treadmill - Black - Front_Zoom']")
		WebElement alternativeforThreadmillSearch1;	

	
		 @FindBy(xpath="//a[contains(text(),'NordicTrack T Series 8.5 S Treadmill - Black')]")
		 WebElement ThreadmillSearch;
		 
		 @FindBy(xpath="//h1[text()='NordicTrack T Series 8.5 S Treadmill - Black']")	 
		 WebElement ThreadmillProductPageText; 
		 
		 @FindBy(xpath="//span[text()='See all pickup locations']")
		 WebElement alternativeforcartelement0;
		
		 @FindBy(xpath=" //strong[text()='Pickup']")
		 WebElement alternativeforcartelement1;	 
	 
		 @FindBy(xpath="//button[contains(@class,'c-button c-button-primary c-button-lg c-button')]")	 
		 WebElement addtoCartThreadMill;
	 
	 	@FindBy(xpath="//a[text()='ProForm - Carbon TL - Black']")
	 	WebElement ThreadmillSearch2;

		@FindBy(css="img[alt='ProForm - Carbon TL - Black - Front_Zoom']")
		WebElement alternativeforThreadmillSearch2;
		
		@FindBy(xpath="//img[@alt='ProForm - Carbon TL - Black - Front_Zoom']")
		WebElement alternativeforThreadMillSearch3;	 	
	 
	 	@FindBy(xpath="//h1[text()='ProForm - Carbon TL - Black']")	 
	 	WebElement ThreadmillProductPageText2;
	
	 	@FindBy(xpath="//span[text()='Save']")	 
	 	WebElement altforThreadmilladdtocart2;	 	
	
		@FindBy(xpath = "//a[text()='Dell gaming laptops']")
		WebElement DellGamingLink;
		
		@FindBy(xpath = "(//a[@class='flex-image-inner-wrapper flex-fluid-image'])[4]")
		WebElement altDellGamingLink;		
		
		@FindBy(xpath = "//a[contains(text(),'Dell - S3222DGM 32\" LED Curved QHD FreeSync Gaming Monitor')]")
		WebElement DellLaptopSelect;		
		
		@FindBy(css = "img[alt='Dell - S3222DGM 32\" LED Curved QHD FreeSync Gaming Monitor (DisplayPort, HDMI) - Black - Front_Zoom']")
		WebElement altDellLaptopSelect;		
		
		@FindBy(xpath = "//span[text()='$329.99']")
		WebElement altDellLaptopFind;		
		
		@FindBy(xpath = "//h1[contains(text(),'Dell - S3222DGM 32\" LED Curved QHD FreeSync Gaming')]")
		WebElement DellLaptopAtProdPage;		
		
		@FindBy(xpath = "//strong[normalize-space()='Pickup']")
		WebElement altaddtoCartDell;		
		
		@FindBy(xpath = "//button[@class='c-button c-button-primary c-button-lg c-button-block c-button-icon c-button-icon-leading add-to-cart-button ']")
		WebElement addtoCartDell;
		
		@FindBy(xpath = "//a[contains(text(),'Shark - Navigator Lift-Away Deluxe')]")
		WebElement VaccumSelect;
		
		@FindBy(xpath = "//img[contains(@alt,'Shark - Navigator Lift-Away Deluxe Upright Vacuum')]")
		WebElement altVaccumSelect;		
		
		@FindBy(xpath = "//button[text()='Add to Cart']")
		WebElement addtocartVaccum;		
		
		@FindBy(xpath = "//a[text()='Go to Cart']")
		WebElement gotoCartVaccum;		

		@FindBy(xpath = "//button[text()='Checkout']")
		WebElement CheckOutpage;	
	
	
	
	public SelectProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//method to search the product via search box
	public String addKettleInProdPage() throws Exception {
		
		clickOn(KettleSearch);
		String KettleTitleAtProdPage = extractText(KettleProductPageText);
		jsScrollUntillElement(alternativeforcartelement0);
		clickOn(KettleCartButton);
		clickOn(goToCartButton);
		return KettleTitleAtProdPage;
	}
	
	
	// method to search product via search box
	public String addAirfryerInProdPage() {
				
		//jsScrollUntillElement(AirfryerSearch);
		clickOn(altAirfryerSearch);
		String AirfryerTitleAtProductPage = extractText(AirfryerProductPageText);
		jsScrollUntillElement(altforAirfryeraddtocart2);
		clickOn(AirfryerCartButton);
		clickOn(goToCartButton);
		return AirfryerTitleAtProductPage;		
	}
	
	
	// method to search product via dept menu
	public String addThreadmillInProdPage() {
		
		jsScrollUntillElement(alternativeforThreadmillSearch2);
		clickOn(alternativeforThreadMillSearch3);
		String ThreadMillTitleAtProdPage= extractText(ThreadmillProductPageText2);
		jsClickOn(altforThreadmilladdtocart2);
		clickOn(addtoCartThreadMill);
		clickOn(goToCartButton);;
		return ThreadMillTitleAtProdPage;
		
	}
	
		// method to search product which has a offer 
	public String addThreadmillInProdPageWithOffer() {
		
		//jsScrollUntillElement(alternativeforThreadmillSearch);
		jsScrollUntillElement(alternativeforThreadmillSearch1);
		clickOn(alternativeforThreadmillSearch1);
		String ThreadMillTitleAtProdPage= extractText(ThreadmillProductPageText);
		jsClickOn(alternativeforcartelement1);
		clickOn(addtoCartThreadMill);
		clickOn(goToCartButton);;
		return ThreadMillTitleAtProdPage;
		
	}
		
		//method to search for product via search box
	public void addVaccumInCart() {
			jsScrollUntillElement(VaccumSelect);
			clickOn(altVaccumSelect);
			jsClickOn(altforAirfryeraddtocart1);
			clickOn(addtocartVaccum);
			clickOn(gotoCartVaccum);			
			
		}	
	
	// method to search for product via brands
	public String addDellGamingInProdPage() {
	
		jsScrollUntillElement(DellGamingLink);
		clickOn(altDellGamingLink);
		jsScrollUntillElement(altDellLaptopFind);
		jsScrollUntillElement(DellLaptopSelect);
		clickOn(altDellLaptopSelect);		
		String DellLaptopTitleAtProdPage = extractText(DellLaptopAtProdPage);
		jsScrollUntillElement(altaddtoCartDell);
		jsClickOn(addtoCartDell);
		return DellLaptopTitleAtProdPage;
	}

}
