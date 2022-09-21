package TestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PomClass.LoginPage;
import UtilityClass.UtilityClass;

public class TestLoginPage {
	WebDriver driver;
	BaseClass base;
	LoginPage login;
	UtilityClass utility;
	String tcid;

	@BeforeClass
	public void openbrowser() throws InterruptedException
	{
		 base= new BaseClass();
		 base.launchbrowser();
		 login = new LoginPage(base.driver);
		 
	}
	@Test
	public void verifylgoinpage() throws InterruptedException
	{
		tcid="100";
		login.enteruser("prati");
		login.enterpass("prati123");
		Thread.sleep(500);
		login.clicklogin();
	}
	@BeforeMethod
	public void m1()
	{
		System.out.println("before method run");
	}
	@AfterMethod
	public void m2() throws IOException
	{
	
		UtilityClass.capatureScreenShot(base.driver, "tcid");
		
	}
}
