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
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Animations extends BasePage {
	
	public static AppiumDriver<MobileElement> driver;
	public static ExtentTest test;
	
	public Animations(AppiumDriver<MobileElement> driver,ExtentTest test){
		super(driver,test);
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Animation']")
	MobileElement animations;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='3D Transition']")
	MobileElement transiton;
	
	@AndroidFindBy(id="android:id/text1")
	List<MobileElement> allTransitions;
	
	@AndroidFindBy(className="android.widget.ImageView")
	MobileElement image;
	
	public void scrollToAnimation() throws InterruptedException{
		AndroidGestures.scrollUpToElement(driver, By.xpath("//android.widget.TextView[@text='Animation']"));
		test.log(LogStatus.INFO, "scrolling to animation");
	}
	
	public void clickOnAnimation(){
		clickOn(animations);
		test.log(LogStatus.INFO, "clicked on the animation");
	}

	public void clickOnTransition(){
		clickOn(transiton);
		test.log(LogStatus.INFO, "clicked on the transition");
	}
	
	public void clickOnImage(){
		clickOn(image);
		test.log(LogStatus.INFO, "clicked on the image");
	}
	
	public void performTransition() throws InterruptedException{
		int transionSize=allTransitions.size();
		for(int i=0;i<transionSize;i++ ){
			String data=allTransitions.get(i).getText();
			System.out.println("The transitions is "+data);
			allTransitions.get(i).click();
			Thread.sleep(500);
			clickOnImage();
		}
	}
}
