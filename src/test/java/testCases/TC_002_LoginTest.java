package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass

{

	
	@Test(groups={"Sanity","master"})
	public void VerifyLogin() 
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");

		hp.Clicklogin();
		logger.info("Clicked on login Link.. ");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setpwd(p.getProperty("pwd"));
		lp.Clicklogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean Targetpage=macc.ismyaccountpageExist();
		Assert.assertTrue(Targetpage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
		
		
		
		
	}
}
