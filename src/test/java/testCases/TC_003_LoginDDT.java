package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass

{
    @Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="datadriven")
  
	public void Verify_Login(String email,String pwd,String exp)
	{
    	try
    	{
	HomePage hp=new HomePage(driver);
	hp.ClickMyAccount();
	logger.info("Clicked on MyAccount Link.. ");

	hp.Clicklogin();
	logger.info("Clicked on login Link.. ");
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(email);
	lp.setpwd(pwd);
	lp.Clicklogin();
	
	MyAccountPage macc=new MyAccountPage(driver);
	boolean Targetpage=macc.ismyaccountpageExist();
	Assert.assertTrue(Targetpage);
	
	if(exp.equalsIgnoreCase("Valid"))
	{
		if(Targetpage==true)
		{
			macc.clickLogout();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(Targetpage==true)
		{
			macc.clickLogout();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
		}
	}	

	}catch(Exception e)
   {
	Assert.fail("An exception occurred: " + e.getMessage());
   }
   
   logger.info("**** Finished TC_003_LoginDDT *****");
   
}

}
	

