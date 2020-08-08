package com.tr.test;

import org.testng.annotations.Test;

import com.tr.pages.DashBoard;
import com.tr.utils.BaseTestObject;

public class DashBoardTest extends BaseTestObject {
	
	
	DashBoard objDashBoard;
	
	
	@Test
	public void verifyIsUserLoggedIn() throws Exception {
		try {
			
			objDashBoard = new DashBoard(uiDriver);
			objDashBoard.verifyuserLoggedName();
			objDashBoard.verifySearchPageTitle();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
			
	}
	@Test
	public void vrifyingSerchitem() throws Exception {
		try {
			objDashBoard.itemToSearch();
			objDashBoard.verifySearchPageTitle();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Test
	public void analysingtoFetchAllrelatedData() {
		try {
			objDashBoard.FetchAllTheProduct();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	
	public void VerifyingToAddingInCartAndLogOut() {
		try {
			
			objDashBoard.selectAndaddInCart();
			objDashBoard.addIn_Cart();	
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}
