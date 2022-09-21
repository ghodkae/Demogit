package TestClass;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import PomClass.KiteLoginPage;
import PomClass.Pinpage;
import UtilityClass.UtilityClass;

public class PinPageVerify  {
	

	BaseClass base;
	KiteLoginPage login;
	Pinpage pin;
	UtilityClass utility;
	String tcid;
	
	@BeforeClass
	public void luachbrowser() throws InterruptedException
	{
		
		 base= new BaseClass();
		base.launchbrowser();
		base.implicitwait(2);
	 login= new KiteLoginPage(base.driver);
	 pin= new Pinpage(base.driver);
	 utility= new UtilityClass();
		
	}
	@BeforeMethod
	public void LoginApp() throws IOException, InterruptedException
	{
		login.enteruser("UVS618");
		Thread.sleep(500);
		login.enterpass("14354096");
		Thread.sleep(500);
		login.clicklogin();
	}
	@Test
	public void verifypinno() throws InterruptedException, IOException
	{
		Thread.sleep(500);
		pin.enterpinno("143540");
		Thread.sleep(500);
		pin.continuebtn();
		
	}
	@Test(enabled=false)
	public void checkuseridonpinPage() throws InterruptedException
	{
		Thread.sleep(500);
		pin.continuebtn();
	}
	@AfterMethod
	public void takescreenshot() throws IOException
	{
		UtilityClass.capatureScreenShot(base. driver, tcid);
		
		
	}
	@AfterClass
	public void closeapp()
	{
		 base.driver.close();
	}
	

}
