package testClass;

import java.io.IOException;
import java.util.Set;
import java.util.Iterator;		
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.Baseclass;
import testCases.CreatingAccount;
import testCases.LogInPage;
import testCases.NewTabAndWindowHandle;
import utility.Utility;


public class NewTabAndWindowsHandlesTestClass extends Baseclass {

	CreatingAccount createAct;
	LogInPage login;
	NewTabAndWindowHandle tab;
	Actions act;

	@BeforeClass
	public void LaunchBrowser() throws IOException
	{
		OpenBrowser();
		createAct= new CreatingAccount (driver);
		login= new LogInPage(driver);
		tab= new NewTabAndWindowHandle(driver);
		act = new Actions(driver);
	}

	@Test
	public void OpeningNewTabAndValidatiingText() throws IOException, InterruptedException
	{   
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com/");
		Set<String> ids=driver.getWindowHandles();		
		Iterator<String> id=ids.iterator();
		String Parent=id.next();
		String Child=id.next();
		driver.switchTo().window(Child);
		tab.SendTextInNewTab(Utility.getDataFromPropertyFile("TEXT"));
		act.sendKeys(Keys.ENTER).perform();
		Assert.assertTrue(tab.validateTextOnNewTab().contains("results"));
		driver.switchTo().window(Parent);
	}



	@AfterClass
	public void CloseBrower()
	{
		driver.quit();
	}

}

