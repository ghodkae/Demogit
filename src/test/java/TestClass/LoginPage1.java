package TestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseClass.BaseClass;
import PomClass.KiteLoginPage;
import UtilityClass.UtilityClass;

public class LoginPage1 {
	BaseClass base;
	UtilityClass utility;
	KiteLoginPage login;
	String tcid;
	
	@BeforeClass
	
	public void lauchbrowser() throws InterruptedException
	{
		base= new BaseClass();
		base.launchbrowser();
		base.implicitwait(0);
		utility= new UtilityClass();
		login = new KiteLoginPage(base.driver);
		
	}
	
	@BeforeMethod
	public void loginapp()
	{
		Reporter.log("..........open browser......");
	}
	@Test(priority=1)
	public void verifyuser() throws EncryptedDocumentException, IOException, InterruptedException
	{
		tcid="100";
		login.enteruser("pati");
		login.clicklogin();
		String act=login.passerrortext();
		String expect= "Password should be minimum 6 characters.";
		Assert.assertEquals(act,expect);
		
		
	}
	@Test(priority=2)
	public void verifypass() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Thread.sleep(500);
		login.clearusername();
		tcid="101";
		Thread.sleep(2000);
		login.enterpass("14354");
		login.clicklogin();
		String act1=login.errorusertext();
		String expect1= "User ID should be minimum 6 characters.";
		Assert.assertEquals(act1,expect1);
		
	}
	@Test(priority=3)
	public void verifyloginbtn() throws InterruptedException
	{
		login.clearpass();
		Thread.sleep(500);
		login.clearpass();
		Thread.sleep(2000);
		tcid="102";
		
		
		login.clicklogin();
		
		
	}
	@AfterMethod
	public void screenshot() throws IOException
	{
		UtilityClass.capatureScreenShot(base. driver, tcid);
	}

}
