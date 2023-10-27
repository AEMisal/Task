package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingAccount 
{

		@FindBy(xpath = "//span[text()='My Account']")private WebElement myAccount;
		@FindBy(xpath = "//a[text()='Login']") private WebElement logInButton;
		@FindBy(xpath = "//a[text()='Continue']") private WebElement continueButton;
		@FindBy(xpath = "//input[@id='input-firstname']") private WebElement sendFirstName;
		@FindBy(xpath = "//input[@id='input-lastname']") private WebElement sendLastName;
		
		@FindBy(xpath = "//input[@id='input-email']") private WebElement sendEmail;
		@FindBy(xpath = "//input[@id='input-telephone']") private WebElement sendTelephone;
		
		@FindBy(xpath = "//input[@id='input-password']") private WebElement passWordForCreAct;
		@FindBy(xpath = "//input[@id='input-confirm']") private WebElement confirmPassWordForCreAct;

		@FindBy(xpath = "//input[@type='checkbox']") private WebElement privacyPolicy;
		@FindBy(xpath = "//input[@value='Continue']") private WebElement continueButtonForCreatingAct;

		@FindBy(xpath = "//p[contains(text(),'Congratulations!')]") private WebElement congratsText;
		@FindBy(xpath = "(//a[text()='Logout'])[2]") private WebElement logOutButton;

		
		
		
		
		public CreatingAccount(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public void clcikingOnMyAccount()
		{
			myAccount.click();
		}
		public void ClickOnLogInButton()
		{
			logInButton.click();
		}
		
		public void ClickOnContinueButton()
		{
			continueButton.click();
		}
		
		public void SendFirstName(String FirstName)
		{
			sendFirstName.sendKeys(FirstName);
		}
		public void SendLastName(String LastName)
		{
			sendLastName.sendKeys(LastName);
		}
		public void SendEmail(String Email)
		{
			sendEmail.sendKeys(Email);
		}
		
		public void SendTelephone(String Telephone)
		{
			sendTelephone.sendKeys(Telephone);
		}
		
		public void SendCreatingPassword(String crePassword)
		{
			passWordForCreAct.sendKeys(crePassword);
		}
		
		public void SendConfirmedPassword(String confirmPassword)
		{
			confirmPassWordForCreAct.sendKeys(confirmPassword);
		}
		
		public void ClickingOnPrivacyPolicy()
		{
			privacyPolicy.click();
		}
		
		public void ClickingOncontinueButtonForCreatingAccount()
		{
			continueButtonForCreatingAct.click();
		}
		
		public String GetCongratulationsText()
		{
			String getCongratsText= congratsText.getText();
			System.out.println(getCongratsText);
			return getCongratsText;	
		}
		
		public void ClickingOnLogOutButton()
		{
			logOutButton.click();
		}
		
		
}


