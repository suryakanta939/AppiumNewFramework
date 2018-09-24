package com.apidemo.commonClasses;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

public class Server {
	
	/*
	 * this function is used to run 
	 * the appium server 1.7.0/1.6.5 and also for all the version
	 * only thing u have to give the proper path of the node.exe and main.js
	 * String nodepath="C:/Program Files/nodejs/node.exe";
	   String apppath="C:/Users/User/AppData/Roaming/npm/node_modules/appium/build/lib/main.js";
	 *  */
	
	 public static void startServeronConsol(String nodePath,String appPath){
		 CommandLine cmd = new CommandLine(nodePath);
			cmd.addArgument(appPath);
//			cmd.addArgument("--address");
//			cmd.addArgument("127.0.0.1");
//			cmd.addArgument("--port");
//			cmd.addArgument("4723");
			
			DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
			DefaultExecutor executor = new DefaultExecutor();
			executor.setExitValue(1);
			try {
				executor.execute(cmd, handler);
				Thread.sleep(5000);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
		 	}
	  }
	 /*************************************************************/
	 /*
	  * here how to run server from command prompt
	  * here you have to give the only your .bat file name
	  * */
	 public static void startServerOnCommandPrompt(String urBatFileNAme) throws IOException{
		 File app=new File("BatFolder");
		  File fs=new File(app,urBatFileNAme+".bat");
		  System.out.println(fs.getAbsolutePath());
		Runtime.getRuntime().exec("cmd /c start "+fs.getAbsolutePath());
	 }
	 
	 /***********************************************************/
	 
	 /*
	  *This is the function how to stop the server
	  *it will help to stop the server where ever u started
	  *like command prompt or console 
	  * 
	  * */
	 
	 public static boolean stopServer(){
		 Runtime runtime = Runtime.getRuntime();
			try {
				System.out.println("killing the server.....");
				runtime.exec("taskkill /F /IM node.exe");
				runtime.exec("taskkill /F /IM cmd.exe");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			
			
		}
	 /****************************************************/
	 
	 /*
	  * this function is to check whether the server is running or not
	  * 
	  * */
	 public static boolean checkIfServerIsRunnning(int port) {
			
			boolean isServerRunning = false;
			ServerSocket serverSocket;
			try {
				serverSocket = new ServerSocket(port);
				serverSocket.close();
			} catch (IOException e) {
				//If control comes here, then it means that the port is in use
				isServerRunning = true;
			} finally {
				serverSocket = null;
			}
			return isServerRunning;
		}

}
