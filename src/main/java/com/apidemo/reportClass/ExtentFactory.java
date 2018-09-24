package com.apidemo.reportClass;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
    public static ExtentReports report;
    
	public static ExtentReports getExtent(String fileName){
		File f=new File("ReportFolder");
		File fs=new File(f,"");
		report=new ExtentReports(fs.getAbsolutePath()+"\\"+fileName+".html",false);
		System.out.println("The path of the rport is "+fs.getAbsolutePath()+"\\"+fileName+".html");
		return report;
	}
}
