package testClass;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Baseclass;
import testCases.CreatingAccount;
import utility.Utility;


public class TestClassForCreatingAccount extends Baseclass
{  
	CreatingAccount createAct;

	@BeforeClass
	public void LaunchBrowser() throws IOException
	{
		OpenBrowser();
		createAct= new CreatingAccount (driver);

	}

	@BeforeMethod
	public void ClickingOnMyAccount() throws IOException
	{   
		createAct.clcikingOnMyAccount();
		createAct.ClickOnLogInButton();
		createAct.ClickOnContinueButton();
	}

	@Test
	public void CreatingAccount() throws IOException      
	{
		createAct.SendFirstName(Utility.readDataFromExcel(1, 0));
		createAct.SendLastName(Utility.readDataFromExcel(1, 1));
		createAct.SendEmail(Utility.readDataFromExcel(1, 2));
		createAct.SendTelephone(Utility.readDataFromExcel(1, 3));
		createAct.SendCreatingPassword(Utility.readDataFromExcel(1, 4));
		createAct.SendConfirmedPassword(Utility.readDataFromExcel(1, 5));
		createAct.ClickingOnPrivacyPolicy();
		createAct.ClickingOncontinueButtonForCreatingAccount();
		
		Assert.assertEquals(createAct.GetCongratulationsText(), "Congratulations! Your new account has been successfully created!");
		System.out.println(createAct.GetCongratulationsText());
	}

	@AfterMethod
	public void LogoutfromApp() throws InterruptedException
	{
		createAct.ClickingOnLogOutButton();
		
	}

	@AfterClass
	public void CloseBrower()
	{
		driver.close();
	}

}


