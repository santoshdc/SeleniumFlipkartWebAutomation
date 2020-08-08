package com.tr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tr.utils.BasePageObject;

public class Flipkart_Login extends BasePageObject {

	public Flipkart_Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By site_Logo =By.xpath(" //img[@class='_1e_EAo']");
	By sign_InBtn =By.xpath("//a[@class='_3Ep39l']");
	By logo_mouse_hover= By.xpath("//img[@class='_1e_EAo']");
	By mobile_Email_TextBox= By.xpath("//input[@class='_2zrpKA _1dBPDZ']");
	By enter_Password_TextBox= By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']");
	By login_Button=By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']");
	By login_popContent = By.xpath("//span[contains(text(),'Get access to your Orders, Wishlist and Recommenda')]");
    
	boolean flag=false;
	String pageTitle = null;
	String parentWindo= null;
    String actualResult= null;
    String ExpectedResult = null;
   
    
    public boolean verify_SiteLogo() throws Exception {
    	
    	try {
    		flag =isElementPresent(site_Logo);
    		Assert.assertTrue(flag,"The flipkart site logo is missing");
			
		} catch (Exception e ) {
			// TODO: handle exception
				throw new Exception("Faled to verify the site logo" + "\n verify_SiteLogo " +e.getLocalizedMessage());
		}
		return flag;
    	 	
    }
    
    public void verifyHomePageTitle() {
    	try {
			
		} catch (Exception e) {
			// TODO: handle exception
			pageTitle =uiDriver.getTitle().trim();
			Assert.assertEquals(pageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
			
		}
    }
    
    public boolean verifySignIn_Button() throws Exception {
    	
    	try {
    		
    		verifySignIn_Button();
    		flag= isElementPresent(sign_InBtn);
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			
			throw new Exception("FAILED WHILE Verifying the Sign_in Btn FOR USER" +"\n clickOnSignInBtn" +e.getLocalizedMessage());
		};
		return flag;
    	
    }
    
    public void clickOnLoginBtn() {
    	
    	try {
			uiDriver.findElement(login_Button).isDisplayed();
			uiDriver.findElement(login_Button).click();		
		} catch (Exception e) {
			// TODO: handle exception
}
    	  	
    	
    }
    
    public void verifyloginTextConent() {
    	
    	String bodyText = uiDriver.findElement(login_popContent).getText();
    	Assert.assertTrue(bodyText.contains("Get access to your Orders, Wishlist and Recommendations"));
    }
    
    public boolean verifyEmail_MobileTextBox() {
    	try {
    		
    		flag=isElementPresent(mobile_Email_TextBox);
    		Assert.assertTrue(flag,"Email/Mobile text box is missing");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;	
    }
    
    public boolean verifyPasswordTextbox() {
    	
    	try {
			flag= isElementPresent(enter_Password_TextBox);
			Assert.assertTrue(flag,"passwrd text box is missing");
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
    	
    }
    
    public boolean verifySignIn_Btn() {
    	try {
    		
    		flag=isElementChecked(sign_InBtn);
    		Assert.assertTrue(flag,"Sign in clickbale button is missing");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return flag;
    	
    }
    
    public void sendingCredentialForSignIn() { 	
    try {
    	uiDriver.findElement(mobile_Email_TextBox).clear();
    	uiDriver.findElement(mobile_Email_TextBox).sendKeys("Email_ID");
    	
    	uiDriver.findElement(enter_Password_TextBox).clear();
    	uiDriver.findElement(enter_Password_TextBox).sendKeys("userPassword");
		
	} catch (Exception e) {
		// TODO: handle exception
}
    	
    }
    
    public DashBoard clickSignIn() {
    	uiDriver.findElement(login_Button).isEnabled();
    	uiDriver.findElement(login_Button).click();
		return null;
    }
    
}








