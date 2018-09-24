package com.apidemo.commonClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePage {
  public static  AppiumDriver<MobileElement> driver;
  public static ExtentTest test; 
  WebDriverWait wait;
  String data;
  
  
	public BasePage(AppiumDriver<MobileElement> driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		wait=new WebDriverWait(driver, 15);
	}
	
	
	/**
	 * this function will help to click on the mobile element
	 * */
	
	public void clickOn(MobileElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		test.log(LogStatus.INFO, "clicked on the element found by "+element);
		
	}
	
	/**
	 * This function will help to send data to the mobile element
	 * */
	
	public void sendText(MobileElement element ,String text){
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
		test.log(LogStatus.INFO, "send the text "+text+"to the element found by "+element);
	}
	
	/**
	 * Important Note 1: Value of @content-desc property can be obtained at runtime
	 by using getAttribute() method and passing the attribute name as “contentDescription” .
	Instead of “contentDescription”, you can also use “name” as well. 
	But “name” doesn’t work with UIAutomator2. 
	Hence it’s a good approach to use “contentDescription”.
	
	Important Note 2: content-desc would be the ideal property that you can use in 
	your test automation scripts. This is due to the fact that app developers can 
	set value for this property. 
	They might not be able to set the property for resource-id always, 
	because a lot of times, the resource-id value is set by the underlying 
	Android or iOS framework.
	 * */
	
	public String getText(MobileElement element,String attribute){
		
		if(attribute.equals("text")){
			data=element.getAttribute("text");
		}else if(attribute.equals("content-desc")){
			data=element.getAttribute("contentDescription");
		}else{
			System.out.println("The attribute you have eneterd is wrong.Please enter correct one ...");
		}
		return data;
	}
	
	
}
