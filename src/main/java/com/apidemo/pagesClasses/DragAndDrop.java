package com.apidemo.pagesClasses;

import org.openqa.selenium.support.PageFactory;

import com.apidemo.commonClasses.AndroidGestures;
import com.apidemo.commonClasses.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DragAndDrop extends BasePage{
	
	public static AppiumDriver<MobileElement> driver;
	public static ExtentTest test;
	
	public DragAndDrop(AppiumDriver<MobileElement> driver, ExtentTest test) {
		super(driver, test);
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Drag and Drop']")
	MobileElement dragAndDrop;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_1")
	MobileElement dotOne;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_3")
	MobileElement dotThree;
	
	public void clickOnDragAndDrop(){
		clickOn(dragAndDrop);
		test.log(LogStatus.INFO, "clicked on the drag and drop");
	}
	
	public void moveOneDotToAnother(){
		AndroidGestures.dragAndDrop(driver, dotOne, dotThree);
		test.log(LogStatus.INFO, "moving one to another ");
	}

}
