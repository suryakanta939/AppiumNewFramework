package com.apidemo.pagesClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.apidemo.commonClasses.AndroidGestures;
import com.apidemo.commonClasses.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RadioGroup extends BasePage {

	public static AppiumDriver<MobileElement> driver;
	public static ExtentTest test;
	
	public RadioGroup(AppiumDriver<MobileElement> driver, ExtentTest test) {
		super(driver, test);
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Radio Group']")
	MobileElement radioGroup;
	
	@AndroidFindBy(className="android.widget.RadioButton")
	List<MobileElement> allButtons;
	
	@AndroidFindBy(id="io.appium.android.apis:id/clear")
	MobileElement clear;
	
	
	public void scrollToRadioGroup() throws InterruptedException{
		AndroidGestures.scrollDownToElement(driver, By.xpath("//android.widget.TextView[@text='Radio Group']"));
		test.log(LogStatus.INFO, "scrolling to radio group");
	}
	
	public void clickOnRadioGroup(){
		clickOn(radioGroup);
		test.log(LogStatus.INFO, "clicked on the radio group");
	}
	
	public void EatStatus(){
		int totalSize=allButtons.size();
		for(int i=0;i<totalSize;i++){
			String data=allButtons.get(i).getText();
			System.out.println("The status is "+data);
		}
		
	}
	
	public void clickOnClear(){
		clickOn(clear);
		test.log(LogStatus.INFO, "clicked on the clear button");
	}
}
