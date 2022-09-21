package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage {

	
	@FindBy(xpath="//input[@id='userid']") private WebElement userid;
	@FindBy(xpath="//input[@type='password']") private WebElement password;
	@FindBy(xpath="//span[contains(text(),'Password should be minimum 6 characters.')]")private WebElement errorpass;
	@FindBy(xpath="//span[text()='User ID should be minimum 6 characters.']")private WebElement erroruser;
	@FindBy(xpath="//button[text()='Login ']") private WebElement loginbtn;
	public KiteLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enteruser(String name)
	{
		userid.sendKeys(name);
	}
	
	public void enterpass(String pass)
	{
		password.sendKeys(pass);
	}
	public void clicklogin()
	{
		loginbtn.click();
	}
	public String errorusertext()
	{
		
	  String act = erroruser.getText();
	  return act;
	
	  
	}
	public String passerrortext()
	{
	 String act1 = errorpass.getText();
	  
	  return act1;
	 
	}
	public void clearusername()
	{
		userid.clear();
	}
	public void clearpass()
	{
		password.clear();
	}
}
