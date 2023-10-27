package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

	
	@FindBy(xpath="(//a[text()='Login'])[1]") private WebElement logIn;
	@FindBy(xpath="//input[@name='email']") private WebElement EmailId;
	@FindBy(xpath="//input[@name='password']") private WebElement password;
	@FindBy(xpath ="//input[@value='Login']")private WebElement logInButton;
	@FindBy(xpath ="//div[@class='alert alert-danger alert-dismissible']")private WebElement errorMessage;

	
	
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickingOnLoginOption()
	{
		logIn.click();
	}

	public void SendEmailid(String EmailID)
	{
		EmailId.sendKeys(EmailID);
	}

	public void SendPasswordForLogin(String PassWord)
	{
		password.sendKeys(PassWord);
	}
	public void ClickOnlogin()
	{
		logInButton.click();
	}

	public WebElement GetErrorMessageText()
	{
		return errorMessage;
	}
}
