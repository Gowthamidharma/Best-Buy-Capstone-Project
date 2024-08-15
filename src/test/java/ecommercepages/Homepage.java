
package ecommercepages;


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ecommerceprojetbase.PSMethodecommerce;

public class Homepage extends PSMethodecommerce {
	
	
	@FindBy(xpath = "//span[text()='Back to School']")
	WebElement BackToSchoolMenu;
	
	@FindBy(xpath = "//li[@class='liDropdownList']//a[text()='K-12 Tech']")
	WebElement K12Menu;	
	
	@FindBy(xpath = "//button[text()='Deals']")
	WebElement DealsMenu;
	
	@FindBy(xpath = "//li[@class='liDropdownList']//a[text()='Top Deals']")
	WebElement topDealsMenu;

	@FindBy(xpath = "//li[@class='liDropdownList']//a[text()='Deal of the Day']")
	WebElement dealsOfTheDayMenu;

	@FindBy(xpath = "//li[@class='liDropdownList']//a[text()='Clearance Deals']")
	WebElement ClearanceDeals;	

	@FindBy(xpath = "//span[text()='More']")
	WebElement moreMenu;

	@FindBy(xpath = "//li[@class='liDropdownList']//a[text()='Credit Cards']")
	WebElement creditCardsMenu;

	@FindBy(xpath = "//li[@class='liDropdownList']//a[text()='My Best Buy Memberships']")
	WebElement MyBestBuyMembershipMenu;

	@FindBy(xpath = "//li[@class='liDropdownList']//a[text()='Gift Ideas']")
	WebElement giftIdeasMenu;

	@FindBy(xpath = "//button[text()='Health, Wellness & Fitness']")
	WebElement healthWellnessFitnesMenu;
	
	@FindBy(xpath = "//button[text()='Exercise & Fitness']")
	WebElement exercisefitness;
	
	@FindBy(xpath = "//a[text()='Treadmills']")
	WebElement ThreadMillinHomPage;	

	@FindBy(xpath = "//a[text()='Best Buy Outlet']")
	WebElement bestBuyOutletMenu;

	@FindBy(xpath = "//a[text()='Best Buy Business']")
	WebElement bestBuyBusinessMenu;

	@FindBy(xpath = "//span[text()='Account']")
	WebElement account;

	@FindBy(xpath = "//a[text()='Sign In']")
	WebElement signIn;

	@FindBy(xpath = "//a[text()='Create Account']")
	WebElement createAccount;

	@FindBy(xpath = "//button[@aria-label='Menu']")
	WebElement menuButton;

	@FindBy(id = "gh-search-input")
	WebElement searchBox;

	@FindBy(xpath = "//button[@title='submit search']")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@class='title-wrapper title']")
	WebElement serachInput;	
	

	@FindBy(xpath="//div[@class='no-results-copy-new']")
	WebElement serachInputInvalid;	

	@FindBy(xpath = "//span[text()='Cart']")
	WebElement cartButton;

	@FindBy(xpath = "//button[text()='Brands']")
	WebElement brandsInMenu;

	@FindBy(xpath = "//a[text()='Dell']")
	WebElement DellInBrandsMenu;

	
	@FindBy(xpath="//a[text()='Health Data Privacy']")
	WebElement HealthDataPrivacy;
	
	@FindBy(xpath="//a[text()='Privacy']")
	WebElement Privacy;
	
	@FindBy(xpath="//a[text()='Accessibility']")
	WebElement Accessibility;	
	
	

	
	public  Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//method for create account
	public void goToCreatAccount() {
		clickOn(account);
		clickOn(createAccount);
	}

	//method for signin
	public void goToSignIn() {
		clickOn(account);
		clickOn(signIn);
	}

	//method for openmenu
	public void openMenu() {
		clickOn(menuButton);
		clickOn(DealsMenu);
	}

	//method to find broken links of a page
	public List<String> brokenLinkFinder() throws Exception {
		List<WebElement> elements = driver.findElements(By.xpath("//footer//a"));
		for(WebElement element:elements)
			System.out.println("List of links in Current Page "+ extractText(element));
		int brokenLinkCount = 0;
		List<String> brokenLinks = new ArrayList<String>();
		for (int i = 0; i < elements.size(); i++) {
			String links = elements.get(i).getAttribute("href");
			int responseCode = getResponseCode(links);
			if (responseCode >= 400) {
				brokenLinkCount++;
				brokenLinks.add(links);
			}
		}
		System.out.println("No.of BrokenLinks In the Current Page is " + brokenLinkCount);
		return brokenLinks;
	}

	// method to select a product via serach box
	public void searchProduct(String productName) {
		type(searchBox, productName);
		clickOn(searchButton);
	}
	
	//method to select threadmill by dept in homepage
	public void selectTheardmillbyDeptInHomePage() {
		clickOn(menuButton);
		jsScrollUntillElement(healthWellnessFitnesMenu);
		clickOn(healthWellnessFitnesMenu);
		clickOn(exercisefitness);
		clickOn(ThreadMillinHomPage);	
		
	}

	//method to select dell brands laptop
	public void selectDellBrandInHomePage() {
		clickOn(menuButton);
		clickOn(brandsInMenu);
		jsScrollUntillElement(DellInBrandsMenu);
		clickOn(DellInBrandsMenu);
		
	}

	//method to go to cart
	public void goToCartPage() {
		jsClickOn(cartButton);
	}
	
	
	//method to validate menu in homepage 
	public String menuValidation(String menuName) {		
		
		if (menuName.equalsIgnoreCase("Credit Cards")) {
			clickOn(moreMenu);
			clickOn(driver.findElement(By.xpath("//li[@class='liDropdownList']//a[text()='" + menuName + "']")));
			String actTitle = getPageTitle();
			return actTitle;
			
				
		} else if (menuName.equalsIgnoreCase("My Best Buy Memberships")) {
			clickOn(moreMenu);
			clickOn(driver.findElement(By.xpath("//li[@class='liDropdownList']//a[text()='" + menuName + "']")));
			String actTitle = getPageTitle();
			return actTitle;
			
				
		}  else if (menuName.equalsIgnoreCase("Gift Ideas")) {
			clickOn(moreMenu);
			clickOn(driver.findElement(By.xpath("//li[@class='liDropdownList']//a[text()='" + menuName + "']")));
			String actTitle = getPageTitle();
			return actTitle;			
				
		}	else if(menuName.equalsIgnoreCase("K-12 Tech")) {
			clickOn(BackToSchoolMenu);
			clickOn(driver.findElement(By.xpath("//li[@class='liDropdownList']//a[text()='" + menuName + "']")));
			String actTitle = getPageTitle();
			return actTitle;
			
		}	else if(menuName.equalsIgnoreCase("Top Deals")) {
			openMenu();
			clickOn(driver.findElement(By.xpath("//a[text()='" + menuName + "']")));
			String actTitle = getPageTitle();
			return actTitle;
			
		}	else if(menuName.equalsIgnoreCase("Deal of the Day")) {
			openMenu();
			clickOn(driver.findElement(By.xpath("//li[@class='liDropdownList']//a[text()='" + menuName + "']")));
			String actTitle = getPageTitle();
			return actTitle;
			
		}	else if(menuName.equalsIgnoreCase("Clearance Deals")) {
				openMenu();
				clickOn(driver.findElement(By.xpath("//li[@class='liDropdownList']//a[text()='" + menuName + "']")));
				String actTitle = getPageTitle();
				return actTitle;
				
		}	else if(menuName.equalsIgnoreCase("Home Gym")) {
				clickOn(menuButton);
				jsScrollUntillElement(healthWellnessFitnesMenu);
				clickOn(healthWellnessFitnesMenu);
				clickOn(exercisefitness);
				clickOn((driver.findElement(By.xpath("//a[text()='" + menuName + "']"))));			
				String actTitle = getPageTitle();
				return actTitle;
				
		}	else {
				clickOn(driver.findElement(By.xpath("//a[text()='" + menuName + "']")));
				String actTitle = getPageTitle();
				return actTitle;
			}		
		
	}
	
	//  method to validate bottonlinks in homepage 
	public String validateBottomLink(String Bottommenu) {
		
		jsScrollUntillElement(driver.findElement(By.xpath("//a[text()='"+Bottommenu+"']")));
		clickOn(driver.findElement(By.xpath("//a[text()='"+Bottommenu+"']")));
		String  actTitle = getPageTitle();
		return actTitle;
	}
	
	// method to validate searchbox in homepage
	public String SearchBoxValidation(String Input) {	
		
		if (Input.equalsIgnoreCase("%^*")) {
			type(this.searchBox, Input);
			clickOn(searchButton);			
			String actText = extractText(serachInputInvalid);
			return actText;
				
		} else {
			type(this.searchBox, Input);
			clickOn(searchButton);	
			String actText =  extractText(serachInput); 
			return actText;
		}		
		
	
	}
}
