package com.apidemo.testCases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apidemo.commonClasses.InvokeApplication;
import com.apidemo.pagesClasses.Animations;
import com.apidemo.pagesClasses.Api;
import com.apidemo.pagesClasses.DragAndDrop;
import com.apidemo.pagesClasses.RadioGroup;
import com.apidemo.propertyClass.PropertyFactory;
import com.apidemo.reportClass.ExtentFactory;
import com.apidemo.screenshotClass.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TestApi {
	AppiumDriver<MobileElement> driver;
	ExtentReports report;
	ExtentTest test;
	Api api;
	Animations animation;
	RadioGroup radiogroup;
	DragAndDrop dragdrop;
	@BeforeClass
	public void setUp() throws IOException{
		report=ExtentFactory.getExtent("apitest");
		test=report.startTest("Checking the details");
		driver=InvokeApplication.startAppWithAPK();
		api=new Api(driver, test);
		radiogroup=new RadioGroup(driver, test);
		animation=new Animations(driver, test);
		dragdrop=new DragAndDrop(driver, test);

		api.clickOnViews();

	}

	@Test(priority=1)
	public void radioGroup() throws InterruptedException {
		test=report.startTest("This test is for radio group");
		radiogroup.scrollToRadioGroup();
		radiogroup.clickOnRadioGroup();
		radiogroup.EatStatus();
		radiogroup.clickOnClear();
		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	@Test(priority=2)
	public void animations() throws InterruptedException{
		test=report.startTest("This test is for animations");
		animation.scrollToAnimation();
		animation.clickOnAnimation();
		animation.clickOnTransition();
		animation.performTransition();
		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(500);
		((PressesKeyCode) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	@Test(priority=3)
	public void dragDrop(){
		test=report.startTest("This test is for drag and drop");
		dragdrop.clickOnDragAndDrop();
		dragdrop.moveOneDotToAnother();

	}

	@AfterMethod
	public void executingAfterMethod(ITestResult result) throws IOException{
		if(result.getStatus()==result.SUCCESS){
			test.log(LogStatus.PASS, "test case "+result.getName()+"got pass");  
		}
		else if (result.getStatus()==result.SKIP) {
			test.log(LogStatus.SKIP, "test case got skipped");
		}
		else if(result.getStatus()==result.FAILURE){
			String path=ScreenShot.takeScreenShot(driver, result.getName());
			test.log(LogStatus.FAIL, "screen shot"+test.addScreenCapture(path));
		}

	}



	@AfterClass
	public void tearDown(){
		test.assignAuthor("suriya kishoore");
		report.endTest(test);
		report.flush();
	}
}
