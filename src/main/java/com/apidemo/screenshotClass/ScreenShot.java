package com.apidemo.screenshotClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ScreenShot {

	public static String takeScreenShot(AppiumDriver<MobileElement> driver,String fileName) throws IOException{
		
		File f=new File("ScreenShot");
		File fs=new File(f,fileName+".png");
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		File dstFile=new File(fs.getAbsolutePath());
		FileUtils.copyFile(srcFile, dstFile);
		System.out.println("The path of the screenshot file is "+fs.getAbsolutePath());
		return fs.getAbsolutePath();
		
	}
	
}
