package com.apidemo.propertyClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class PropertyFactory {
	
	public static String getPropertyData(String fileName,String keyName) throws IOException{
		File f=new File("PropertyFolder");
		File fs=new File(f,fileName+".properties");
		System.out.println("the path of the Properties file is "+fs.getAbsolutePath());
		FileInputStream fis=new FileInputStream(fs.getAbsolutePath());
		Properties pro=new Properties();
		pro.load(fis);
		String value=pro.getProperty(keyName);
		return value;
		
	}

}
