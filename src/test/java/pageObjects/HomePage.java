package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage

{
     
     
     public HomePage(WebDriver driver)
     {
    	 super(driver);
     }
     
    
     @FindBy(xpath="//a[@title='My Account']")
     WebElement lnkmyaccount;
     
     @FindBy(xpath="//a[normalize-space()='Register']")
     WebElement lnkregister;
     
     @FindBy(linkText = "Login")   // Login link added in step5
     WebElement linkLogin;
     
     
     
     public void ClickMyAccount() 
     {
    	 lnkmyaccount.click();
     }
     
     public void ClickRegister() 
     {
    	 lnkregister.click();
     }
     public void Clicklogin() 
     {
    	 linkLogin.click();
     }
     
     
     
  
     
     
     
     
     
}
