package testClass;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentTest;
import base.Baseclass;
import testCases.CreatingAccount;
import testCases.LogInPage;
import testCases.SearchAddEditDelete;


public class SearchAddEditDeleteTestClass extends Baseclass
{  
	CreatingAccount createAct;
	LogInPage login;
	SearchAddEditDelete checkfuntionality;
	SoftAssert soft;
	public  ExtentTest logger;

	@BeforeClass
	public void LaunchBrowser() throws IOException
	{
		OpenBrowser();
		createAct= new CreatingAccount (driver);
		login= new LogInPage(driver);
		checkfuntionality= new SearchAddEditDelete(driver);
		soft=new SoftAssert();
	}

	@Test(priority = 0)
	public void CheckSearchFunctionality() throws IOException      
	{
		checkfuntionality.SendTextInSearchBox();
		WebElement IphoneImage = checkfuntionality.CheckIphoneImage();	
		soft.assertTrue(IphoneImage.isDisplayed());
		soft.assertAll();
		
	}
	
	@Test(priority = 1)
	public void CheckAddToCartFunctionality() throws IOException, InterruptedException      
	{
		checkfuntionality.ClickOnAddToCart();
		String getItemsCount = checkfuntionality.CheckItemsCount().getText();
		soft.assertTrue(getItemsCount.contains("1 item(s"));
		soft.assertAll();
	}
	

	@Test(priority = 2)
	public void CheckEditFunctionality() throws IOException, InterruptedException      
	{
		checkfuntionality.sendQuantity();
		checkfuntionality.AddExtraQuantity();
		String getItemsCount = checkfuntionality.CheckItemsCount().getText();
		soft.assertTrue(getItemsCount.contains("3 item(s"));
		soft.assertAll();
	}
	
	@Test(priority = 3)
	public void DeleteFunctionality() throws IOException, InterruptedException      
	{
		checkfuntionality.DeleteItemsFromcart();
		String getItemsCount = checkfuntionality.CheckItemsCount().getText();
		soft.assertTrue(getItemsCount.contains("0 item(s"));
		soft.assertAll();
	}
	
	@AfterClass
	public void CloseBrower()
	{
		driver.close();
	}

}
