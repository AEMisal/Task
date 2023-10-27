package testCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAddEditDelete{

	
	@FindBy(xpath="//input[@placeholder='Search']") private WebElement searchBox;
	@FindBy(xpath="//span[@class='input-group-btn']") private WebElement searchBar;
	@FindBy(xpath="//img[@title='iPhone']") private WebElement iphoneImage;
	@FindBy(xpath ="//span[text()='Add to Cart']")private WebElement addToCart;
	@FindBy(xpath ="//button[@data-loading-text='Loading...']")private WebElement itemsCount;
	@FindBy(xpath ="(//td[@class='text-center'])[1]")private WebElement viewCart;
	@FindBy(xpath="//input[@id='input-quantity']") private WebElement quantity;
	@FindBy(xpath="//button[text()='Add to Cart']") private WebElement addExtraquantity;
	@FindBy(xpath="//button[@title='Remove']") private WebElement removeItems;

	
	

	public SearchAddEditDelete(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void SendTextInSearchBox()
	{
		searchBox.sendKeys("Iphone");
		searchBar.click();
	}

	public WebElement CheckIphoneImage()
	{
		return iphoneImage;
	}

	public void ClickOnAddToCart() throws InterruptedException
	{
		addToCart.click();
		Thread.sleep(2000);
	}
	public WebElement CheckItemsCount()
	{
		return itemsCount;
	}

	public void sendQuantity() throws InterruptedException
	{
		itemsCount.click();
		viewCart.click();
		Thread.sleep(1000);
		quantity.clear();
		quantity.sendKeys("2");
	}
	public void AddExtraQuantity() throws InterruptedException
	{
		addExtraquantity.click();
		Thread.sleep(2000);
	}

	public void DeleteItemsFromcart() throws InterruptedException
	{
		itemsCount.click();
		removeItems.click();
		Thread.sleep(2000);
		
	}

	
}
