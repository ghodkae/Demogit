package PomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="userid") private WebElement userid;
	@FindBy(id="password") private WebElement password;
	@FindBy(xpath="//button[text()='Login ']") private WebElement loginbtn;
	public LoginPage(WebDriver driver)
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
}
