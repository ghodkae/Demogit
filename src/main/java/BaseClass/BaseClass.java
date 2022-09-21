package BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ConfigurationPath.Configuration;

public class BaseClass {
	public WebDriver driver;
	public void launchbrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver",Configuration.driver );
		driver= new ChromeDriver();
		driver.get("https://kite.zerodha.com/");
		Thread.sleep(2000);
	 driver.manage().window().maximize();
		
	}
	@SuppressWarnings("deprecation")
	public void implicitwait(int wait)
	{
		driver.manage().timeouts().implicitlyWait(wait,TimeUnit.SECONDS);
		
	}

}
