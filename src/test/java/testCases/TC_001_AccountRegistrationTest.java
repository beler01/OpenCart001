package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest  extends BaseClass {
	
	@Test(groups={"reggression","master"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");

		hp.ClickRegister();
		logger.info("Clicked on Register Link.. ");

		
		AccountRegisterationPage regpage=new AccountRegisterationPage(driver);
		
			

			logger.info("Providing customer details...");
			
			regpage.setFirstName(RandamString().toLowerCase());
			
			regpage.setLastName(RandamString().toLowerCase());
			
			regpage.setEmail(RandamString()+"@gmail.com");
			
			regpage.setTelephone(Randamnumber());
			
			String Password=Randamnumalpha();
			regpage.setPassword(Password);
			
			regpage.setConfirmPassword(Password);
			regpage.setPrivacyPolicy();
			regpage.clickContinue();
			
			logger.info("Validating expected message..");

			
			String confmsg=regpage.getConfirmationMsg();
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			
			logger.info("Test passed");
		 }
		
		catch(Exception e)
		 {
			logger.error("Test failed: " + e.getMessage());
			Assert.fail("Test failed: " + e.getMessage());
		 }
		finally 
		{
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		}

		
	}

}
