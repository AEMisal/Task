package testClass;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Baseclass;
import testCases.CreatingAccount;
import testCases.LogInPage;
import utility.Utility;


public class LoginTestClass extends Baseclass
{  
	CreatingAccount createAct;
	LogInPage login;

	@BeforeClass
	public void LaunchBrowser() throws IOException
	{
		OpenBrowser();
		createAct= new CreatingAccount (driver);
		login= new LogInPage(driver);
	}

	@BeforeMethod
	public void LoginIntoApp() throws IOException
	{   
		createAct.clcikingOnMyAccount();
		login.ClickingOnLoginOption();	
	}

	@Test
	public void CheckLoginFunctionality() throws IOException      
	{
		login.SendEmailid(Utility.getDataFromPropertyFile("UN"));
		login.SendPasswordForLogin(Utility.getDataFromPropertyFile("WRONG_PWD"));
		login.ClickOnlogin();	
		WebElement errorMessage = login.GetErrorMessageText();	
		Assert.assertTrue(errorMessage.isDisplayed(), " Warning: No match for E-Mail Address and/or Password.");
	}

	@AfterClass
	public void CloseBrower()
	{
		driver.close();
	}

}
