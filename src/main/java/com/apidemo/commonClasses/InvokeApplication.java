package com.apidemo.commonClasses;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.apidemo.propertyClass.PropertyFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class InvokeApplication {

	public static AppiumDriver<MobileElement> driver;

	public static AppiumDriver<MobileElement> startAppWithAPK() throws IOException{
		String device=PropertyFactory.getPropertyData("Capability", "deviceName");
		String url=PropertyFactory.getPropertyData("Capability", "url");

		File f=new File("ApkFolder");
		File fs=new File(f,"ApiDemos-debug.apk");
		System.out.println("The Path fo the apk file is "+fs.getAbsolutePath());


		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
		cap.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
		driver=new AndroidDriver<MobileElement>(new URL(url),cap);
		return driver;

	}

	
	public static AppiumDriver<MobileElement> startWithPreInstalledApp() throws IOException{

		String device=PropertyFactory.getPropertyData("Capability", "deviceName");
		String url=PropertyFactory.getPropertyData("Capability", "url");
		String packagename=PropertyFactory.getPropertyData("Capability", "package");
		String activityname=PropertyFactory.getPropertyData("Capability", "activity");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 15);
		cap.setCapability("appPackage",packagename);
		cap.setCapability("appActivity",activityname );
		driver= new AndroidDriver<MobileElement>(new URL(url),cap);
		return driver;
		
		
	}

	public static AppiumDriver<MobileElement> runappiumBrowserStack(String userName,String accessKey) throws MalformedURLException{
		
		DesiredCapabilities caps = new DesiredCapabilities();
		
		caps.setCapability("device", "Google Pixel");
		
		caps.setCapability("app", "bs://91259592108e0c91bff672a189ec134cd6614be4");

		driver = new AndroidDriver<MobileElement>(new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
		return driver;

	}


}
