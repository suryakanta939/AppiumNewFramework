package com.apidemo.pagesClasses;

import org.openqa.selenium.support.PageFactory;

import com.apidemo.commonClasses.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Api extends BasePage {
	
	public static AppiumDriver<MobileElement> driver;
	public static ExtentTest test;
	
	public Api(AppiumDriver<MobileElement> driver,ExtentTest test){
		super(driver, test);
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Views']")
	 MobileElement views;
	
	public void clickOnViews(){
		clickOn(views);
		test.log(LogStatus.INFO, "clicked on views");
	}

}
