package com.tr.utils;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePageObject {
	
	public WebDriver uiDriver;
	public BasePageObject(WebDriver driver){
	this.uiDriver = driver;	
	
	}
	
	public void waitForAnElement(final By theElement,int timeoutInSeconds) {
		try {
			WebElement element = uiDriver.findElement(theElement);
			WebDriverWait wait = new WebDriverWait(uiDriver, timeoutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Reporter.log("There was an issue in finding the webelement, " + theElement.getClass() + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void javaScriptClick(By theElement) {
		WebElement element = uiDriver.findElement(theElement);
		((JavascriptExecutor) uiDriver).executeScript("arguments[0].click();", element);
	}
	
	public boolean isElementPresent(By by) {
        try {
            uiDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
public  String getText(By theElement) {
		
		WebElement element= uiDriver.findElement(theElement);
		return element.getText();
	}

public  void switchToDefaultFrame() {
	uiDriver.switchTo().defaultContent();
}

public  void switchToFrame(String id) {
	uiDriver.switchTo().frame(id);
}

public  void switchToFrame(By theElement) {
	WebElement element = uiDriver.findElement(theElement);
	uiDriver.switchTo().frame(element);
}

public  void refreshPage() {
	uiDriver.navigate().refresh();
}


public boolean isTextPresent(String textValue) {
	// Reporter.log("Looking for the element...: " + textValue);
	System.out.println("Looking for the element...: " + textValue);
	WebElement webElement = uiDriver.findElement(By.tagName("html"));
	if (webElement.getText().contains(textValue)) {
		return true;
	} else {
		System.out.println("Element not found : " + textValue);
		return false;
	}
}

public boolean isElementChecked(By theElement) {
	WebElement element = uiDriver.findElement(theElement);
	boolean retValue = false;
	if (element.isSelected()) {
		retValue = true;
	}
	return retValue;
}

public void waitImplicit() {
	uiDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

public  void closeBrowser() {

	uiDriver.quit();
}

public  void alert() {
	Alert alert = uiDriver.switchTo().alert();
	alert.accept();

}

public void closePresentWindow() throws Exception {
    try {
        uiDriver.close();
    } catch (Exception e) {
        throw new Exception(
                "ISSUE IN CLOSING THE 'window'" + "\nMETHOD:clickOnCloseWindow\n" + e
                        .getLocalizedMessage());
    }
}

public void closePopUp() throws InterruptedException{
	String parent = uiDriver.getWindowHandle();
	Set<String>pops=uiDriver.getWindowHandles();
    {
    Iterator<String>it = pops.iterator();
    while (it.hasNext()) {
        String popupHandle=it.next().toString();
        if(!popupHandle.contains(parent))
        {
        uiDriver.switchTo().window(popupHandle);
        System.out.println("Popu Up Title: "+ uiDriver.switchTo().window(popupHandle).getTitle());
        uiDriver.close();
        Thread.sleep(5000);
        }
    }
}
}

public  void waitImplicit(int millisecods) {
	uiDriver.manage().timeouts().implicitlyWait(millisecods,
	TimeUnit.SECONDS);
	try {
		Thread.sleep(millisecods);
	} catch (InterruptedException e) {
	}
}

public  void logOut() throws InterruptedException {
	WebElement logout = uiDriver.findElement(By.xpath(""));
		logout.click();
		waitImplicit(10);
		Thread.sleep(3000);
}

public  String getPageTitle()
{
		return uiDriver.getTitle().trim();
}

}
