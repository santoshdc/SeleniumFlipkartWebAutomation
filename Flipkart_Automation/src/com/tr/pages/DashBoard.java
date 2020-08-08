package com.tr.pages;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.tr.utils.BasePageObject;

public class DashBoard extends BasePageObject {

	public DashBoard(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By User_Id= By.xpath("//div[contains(@class, '_2aUbKa')]");
	By Search_for_Product= By.xpath("//input[@placeholder='Search for products, brands and more']");
	By submit_Search=By.xpath(" //button[@class='vh79eN']");
	By produt_list=By.xpath("//div[contains(@class, '_3wU53n')]");
	By product_Price =By.xpath("//div[contains(@class, '_1vC4OE _2rQ-NK')]");
	By product_5=By.xpath("//div[contains(@class, '_1vC4OE _2rQ-NK')][position()=5]");
	By product_Image =By.xpath("//div[contains(@class, '_2rDnao')]");
	By add_To_Cart_Btn= By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']");
	By product_text_header= By.xpath("//span[@class='_35KyD6']");
	By cart_details_text= By.xpath("//a/@href[@class='_325-ji _3ROwx']");
	By user_location= By.xpath("//div[@class='_2aUbKa']");
	By logout_btn= By.xpath("//div[contains(text(),'logout')");
	
	String ExpectedUser= "Santosh";
	boolean flag= false;
	
	public void verifyuserLoggedName() throws Exception {
		
		try {
			
			String actualUser=uiDriver.findElement(User_Id).getText();
			Assert.assertEquals(actualUser, ExpectedUser);
		} catch (Exception e) {
			
			throw new Exception("Te getting user ID is not matching with expeted userID  " + "\n verifyUserTitle " +e.getLocalizedMessage());
			// TODO: handle exception
		}
				
	}
	
	public boolean verifySerachTextBox() {
		try {
			
			flag =isElementPresent(Search_for_Product);
 			Assert.assertTrue(flag, "*search -TextBox is missing on home page");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;	
	}
	
	public void itemToSearch() {
		try {
			uiDriver.findElement(Search_for_Product).clear();
			uiDriver.findElement(Search_for_Product).sendKeys("Camera");
			uiDriver.findElement(submit_Search).isEnabled();
			uiDriver.findElement(submit_Search).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void verifySearchPageTitle() throws Exception {
		
		try 
		{
			String exp_search_title = "Camera - Buy Products Online at Best Price in India - All Categories | Flipkart.com";
			String actual_search_title = uiDriver.getTitle();
			if(actual_search_title.toLowerCase().contains(exp_search_title.toLowerCase())) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
		} 
		catch (Exception e) {
			
			throw new Exception("FAILED GETING THE Search TITLE  " + "\n verifySearchPageTitle " +e.getLocalizedMessage());
		}
		
	}
	
	public void FetchAllTheProduct() {
		try {
			
			List<WebElement> list_of_products= uiDriver.findElements(produt_list);
			List<WebElement> list_of_products_price =uiDriver.findElements(product_Price);
			
			//Use of HashMaop to store Products and Their prices(after conversion to Integer)
			String product_name;
			String product_price;
			int int_product_price;
			
			HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
			
			for(int i=0;i<list_of_products.size();i++) {
				product_name = list_of_products.get(i).getText();
				//Iterate and fetch product name
				product_price = list_of_products_price.get(i).getText();
				//Iterate and fetch product price
				product_price = product_price.replaceAll("[^0-9]", "");
				//Replace anything wil space other than numbers
				int_product_price = Integer.parseInt(product_price);
				//Convert to Integer
				map_final_products.put(int_product_price,product_name);
				//Add product and price in HashMap
			
			}
			
			
			
			//Get all the keys from Hash Map
			java.util.Set<Integer> allKeys=map_final_products.keySet();
			
			ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allKeys);
			
			//Sort the Prices in Array List using Collections class
			//this will sort in ascending order lowest at the top and highest at the bottom
			Collections.sort(array_list_values_product_prices);
			
			//Highest Product is
			int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
			
			//Low price is
			int low_price = array_list_values_product_prices.get(0);
			Reporter.log("High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price),true);
			Reporter.log("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price),true);
					
		} catch (Exception e) {
			// TODO: handle exception
			
		}
			
		
	}
	
         public void selectAndaddInCart() {
        	 String currentHandle = uiDriver.getWindowHandle();
        	 
        	//Scroll down the webpage by 2500 pixels
        	    JavascriptExecutor js = (JavascriptExecutor)uiDriver;
        	    js.executeScript("scrollBy(0, 2500)");
        	    
        	    uiDriver.findElement(product_5).click();
        	    java.util.Set<String> handles =uiDriver.getWindowHandles();
                for (String actual: handles) {
                    if (!actual.equalsIgnoreCase(currentHandle)) { 
                    	//switching to the opened tab              
                        uiDriver.switchTo().window(actual); //opening the URL saved.                                     
                    }
                }
                
                //move to element and zoom to ousehover
               WebElement element= uiDriver.findElement(product_Image);
               Actions action = new Actions(uiDriver);
               action.moveToElement(element).build().perform();
               	
       }
         
         public void addIn_Cart() {
        	 
        	 try {
        		 
        		String  header_contet_ofProduct = uiDriver.findElement(product_text_header).getText();
        		
        		uiDriver.findElement(add_To_Cart_Btn).isEnabled();
        		uiDriver.findElement(add_To_Cart_Btn).click();
        		
        		//page to cart details
        		
        		String carHeadrdetails =uiDriver.findElement(cart_details_text).getText();
        		
        		if (cart_details_text.equals(header_contet_ofProduct)) {
        			System.out.println("Product added your cart successfully");
        		}
        			
        		
        		
        		 WebElement element2= uiDriver.findElement(user_location);
                 Actions action = new Actions(uiDriver);
                 action.moveToElement(element2).perform();
                 WebElement element3= uiDriver.findElement(logout_btn);
                 action.moveToElement(element3).click();
        		
        		
     	
			} catch (Exception e) {
				// TODO: handle exception
		}
        	 
         }
         
         
	

}
