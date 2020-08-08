package com.tr.test;

import org.testng.annotations.Test;

import com.tr.pages.Flipkart_Login;
import com.tr.utils.BaseTestObject;

public class FlipkartLoginTest extends BaseTestObject {
	
	Flipkart_Login objFlipkart_Login;
	
	@Test
	public void clickOnSiteLogoAndCheckThePageTitle() throws Exception {
		
		objFlipkart_Login =new Flipkart_Login(uiDriver);
		objFlipkart_Login.verify_SiteLogo();
		objFlipkart_Login.verifyHomePageTitle();			
	}
	
	@Test 
	public void clickOnLoginBtnVerifyInputTextBoxes() {
		
		objFlipkart_Login = new Flipkart_Login(uiDriver);
		objFlipkart_Login.verifySignIn_Btn();
		objFlipkart_Login.clickOnLoginBtn();
		objFlipkart_Login.verifyEmail_MobileTextBox();
		objFlipkart_Login.verifyPasswordTextbox();
		objFlipkart_Login.verifySignIn_Btn();	
	}
	
	@Test
	public void checkToginWithValidCredentils() {		
		objFlipkart_Login.sendingCredentialForSignIn();
		objFlipkart_Login.clickSignIn();
			
	}

}
