package com.apidemo.commonClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidGestures {
	
	public static void dragAndDrop(AppiumDriver<MobileElement> driver,MobileElement src,MobileElement dst){
		TouchAction ta=new TouchAction(driver);
		ta.longPress(src).moveTo(dst).release().perform();
	}
	public static void swipeToElement(AppiumDriver<MobileElement> driver,MobileElement src,MobileElement dst){
		TouchAction ta=new TouchAction(driver);
		int srcDateXcod=src.getLocation().getX();
		System.out.println(srcDateXcod);
		int srcDateYcod=src.getLocation().getY();
		System.out.println(srcDateYcod);
		
		int dstDateXcord=dst.getLocation().getX();
		System.out.println(dstDateXcord);
		int dstDateYcord=dst.getLocation().getY();
		System.out.println(dstDateYcord);
	
		ta.longPress(src, srcDateXcod, srcDateYcod).moveTo(dst, dstDateXcord, dstDateYcord).release().perform();
		//ta.press(src).waitAction(Duration.ofNanos(1000)).moveTo(0, dstDateYcord).release().perform();
	}
	public static void swipe(AppiumDriver<MobileElement> driver,MobileElement src,MobileElement dst){
		TouchAction ta=new TouchAction(driver);
		ta.press(src).moveTo(dst).release().perform();
		
	}
	
	public static void longPressOnElement(AppiumDriver<MobileElement> driver,MobileElement element){
		TouchAction ta=new TouchAction(driver);
		ta.longPress(element).waitAction().release().perform();
	}
	
	/*
	 * This function is to scroll to particular element
	 * he re is the real 
	 * driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Animation\"));");
	 * */
	public static void scrollToElemntBytext(AppiumDriver<MobileElement> driver,String text){
		String s1="new UiScrollable(new UiSelector()).scrollIntoView(text(\"";
		String s2="\"));";
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(s1+text+s2);
	}

	public static void scrollToElemntByid(AppiumDriver<MobileElement> driver,String id){
		String s1="new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"";
		String s2="\"));";
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(s1+id+s2);
	}
	/*
	 * 
	 * This function is to do tap operation
	 * on the element by scrolling to top or bottom
	 *  
	 *  */
	public static Boolean tapCellByTitle(AppiumDriver<MobileElement> driver,String title) {
        System.out.println("  tapCellByTitle(): " + title);
        List<MobileElement> elementList = driver.findElements(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceIdMatches(\".*id/list\")).setMaxSearchSwipes(5).scrollIntoView("
                        + "new UiSelector().text(\"" + title + "\"))"));
        if (elementList.isEmpty())
            return false;
        else {
           try {
        	   //TouchAction act=new TouchAction((MobileDriver)driver);
             new TouchAction((MobileDriver) driver).press(elementList.get(0)).waitAction(Duration.ofMillis(70)).release().perform();
            } catch (Exception e) {
              e.printStackTrace();
            }
        }
        return true;
        
       
    }
	
	/*
	 * This function is to only scroll to the element
	 * on vertical way both top and bottom
	 * 
	 * */
	public static void scrollToDesiredElementInVertcalWay(AppiumDriver<MobileElement> driver,String title){
		
	        System.out.println("  tapCellByTitle(): " + title);
	        List<MobileElement> elementList = driver.findElements(MobileBy.AndroidUIAutomator(
	                "new UiScrollable(new UiSelector().resourceIdMatches(\".*id/list\")).setMaxSearchSwipes(5).scrollIntoView("
	                        + "new UiSelector().text(\"" + title + "\"))"));
	        
	}
	public static void scrollToDesiredElementInVertcalWayById(AppiumDriver<MobileElement> driver,String id){
		
        System.out.println("  tapCellByTitle(): " + id);
        List<MobileElement> elementList = driver.findElements(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceIdMatches(\".*id/list\")).setMaxSearchSwipes(5).scrollIntoView("
                        + "new UiSelector().resourceId(\"" + id + "\"))"));
        
}
	/*
	 * This function is to only scroll to the element
	 * on horizontal way both left and right
	 * 
	 * */
	public static void scrollToHorizantalWay(AppiumDriver<MobileElement> driver,String title){
		List<MobileElement> elementList = driver.findElements(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceIdMatches(\".*id/list\")).setAsHorizontalList().setMaxSearchSwipes(5).scrollIntoView("
                        + "new UiSelector().text(\"" + title + "\"))"));
		
	}
	/*
	 * This is an other function to scroll down
	 * 
	 * 
	 * */
	public static void scrollDown(AppiumDriver<MobileElement> driver){
		TouchAction act=new TouchAction(driver);
		int height = driver.manage().window().getSize().getHeight();
		act.press(5, height * 2 / 3).waitAction().moveTo(5, height / 3).release().perform();
	}

	public  static void scrollDownToElement(AppiumDriver<MobileElement> driver,By locatorOfElement) throws InterruptedException {
		int i = 0;
		while (i < 12) {
			if (driver.findElements(locatorOfElement).size() > 0){
				return;
			}
			Thread.sleep(2000);
			scrollDown(driver);
			i++;
		}
		System.out.println("Couldn't find element: " +
				locatorOfElement.toString());
	}
	/*---------------------------------------------------------------------------*/
	/*---------------------------------------------------------------------------*/
	/*
	 * This functions are to perform the scroll up
	 * 
	 * */
	public static void scrollUp(AppiumDriver<MobileElement> driver){
		TouchAction act=new TouchAction(driver);
		int height = driver.manage().window().getSize().getHeight();
		act.press(5, height / 3).waitAction().moveTo(5, height * 2 / 3).release().perform();
	}

	public  static void scrollUpToElement(AppiumDriver<MobileElement> driver,By locatorOfElement) throws InterruptedException {
		int i = 0;
		while (i < 12) {
			if (driver.findElements(locatorOfElement).size() > 0){
				return;
			}
			Thread.sleep(2000);
			scrollUp(driver);
			i++;
		}
		System.out.println("Couldn't find element: " +
				locatorOfElement.toString());
	}
	/*******************************************************************************/
	 /*
	  * Bellow function are to swipe horizontally
	  * 
	  * */
	/*******************************************************************************/
	
	/********************this function is to swipe left to right*********************/
	
	public static void swipeLeftToRight(AppiumDriver<MobileElement> driver) {
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		TouchAction act=new TouchAction(driver);
		  act.press(width/3,height/2).waitAction().moveTo((width*2)/3,height/2).release().perform();
		}
	
	public  static void swipeLeftToRightToAnElement(AppiumDriver<MobileElement> driver,By locatorOfElement) throws InterruptedException {
		int i = 0;
		while (i < 12) {
			if (driver.findElements(locatorOfElement).size() > 0){
				return;
			}
			Thread.sleep(2000);
			swipeLeftToRight(driver);
			i++;
		}
		System.out.println("Couldn't find element: " +
				locatorOfElement.toString());
	}
	/*****************This function is swipe right to left******************************/
	
	public static void swipeRightToLeft(AppiumDriver<MobileElement> driver) {
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		TouchAction act=new TouchAction(driver);
		act.press((width*9)/10, height/2).waitAction().moveTo(width/10, height/2).release().perform();
		}
	
	public  static void swipeRightToLeftToAnElement(AppiumDriver<MobileElement> driver,By locatorOfElement) throws InterruptedException {
		int i = 0;
		while (i < 12) {
			if (driver.findElements(locatorOfElement).size() > 0){
				return;
			}
			Thread.sleep(2000);
			swipeRightToLeft(driver);
			i++;
		}
		System.out.println("Couldn't find element: " +
				locatorOfElement.toString());
	}
	
}
