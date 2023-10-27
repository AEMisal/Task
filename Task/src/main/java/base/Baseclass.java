package base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import utility.Utility;

public class Baseclass
{
	static String driverPath=System.getProperty("user.dir")+"\\src\\test\\java\\chromedriver\\chromedriver.exe";
	protected WebDriver driver;
	
	public void OpenBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", driverPath);
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		opt.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get(Utility.getDataFromPropertyFile("URL"));
		Reporter.log("Launching Browser",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
	
	
}

