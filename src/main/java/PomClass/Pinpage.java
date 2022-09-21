package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Pinpage {
	@FindBy (xpath="//input[@id='pin']")private WebElement pinno;
	@FindBy (xpath="//h2[text()='UVS618']")private WebElement verifyuserid;
	@FindBy (xpath="//button[text()='Continue ']")private WebElement continuebtn;
	
	public Pinpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterpinno(String pin) throws InterruptedException
	{
		pinno.sendKeys(pin);
		Thread.sleep(2000);
		pinno.click();
	
	}
	public void usernameverify()
	{
		String act=verifyuserid.getText();
		String expect="UVS618";
		Assert.assertEquals(act,expect);
	
	}
	public void continuebtn()
	{
		continuebtn.click();
	}
	

}
