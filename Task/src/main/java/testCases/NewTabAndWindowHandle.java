package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewTabAndWindowHandle {

	
	@FindBy(xpath="//textarea[@name='q']") private WebElement searchBar;
	@FindBy(xpath="//div[@id='result-stats']") private WebElement TextForValidationOnNewTab;

	
	
	public NewTabAndWindowHandle(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void SendTextInNewTab(String Text)
	{
		searchBar.sendKeys(Text);		
	}


	public String validateTextOnNewTab()
	{
		String getTextForValidationOnNewTab= TextForValidationOnNewTab.getText();
		System.out.println(getTextForValidationOnNewTab);
		return getTextForValidationOnNewTab;	
	}


}
