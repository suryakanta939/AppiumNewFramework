package com.apidemo.testCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.apidemo.propertyClass.PropertyFactory;
import com.apidemo.reportClass.ExtentFactory;
import com.apidemo.screenshotClass.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TestApiDemo {
	AppiumDriver<MobileElement> driver;
	ExtentReports report;
	ExtentTest test;
	@BeforeClass
	public void setUp() throws MalformedURLException{
		 report=ExtentFactory.getExtent("apitest");
		 test=report.startTest("Checking the details");
		  DesiredCapabilities cap=new DesiredCapabilities();
		  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		  test.log(LogStatus.INFO, "setting the plat form");
		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		  test.log(LogStatus.INFO, "setting the type of device");
		  cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		  test.log(LogStatus.INFO, "setting the time");
		  cap.setCapability(MobileCapabilityType.APP, "D:\\appiumcode\\NewTypeDesign\\ApkFolder\\ApiDemos-debug.apk");
		  test.log(LogStatus.INFO, "lunching the application");
		  driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	}
	
	
	
  @Test
  public void f() throws IOException {
	  driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
	  test.log(LogStatus.INFO, "clciking on the views");
	  String data=PropertyFactory.getPropertyData("Capability", "name");
	  System.out.println(data);
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
