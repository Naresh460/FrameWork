package com.utility;

import java.io.IOException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.actiondriver.ActionClass;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.baseclass.Base;

public class ITestListnerclass extends Base implements ITestListener{
	
	ActionClass action= new ActionClass();
	String path;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		Capabilities Browsername = ((HasCapabilities) getDriver()).getCapabilities();
		String Device=Browsername.getBrowserName()+""+Browsername.getBrowserVersion();
		
		extenttest=reprtengine.createTest(result.getName());        //use ItestContext to get the name of test from xml file or 
		extenttest.assignAuthor("reddy");
		extenttest.assignCategory(Device);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {		
	
		
			try {
				path = action.screenShot(getDriver(), result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extenttest.fail("This Method is Failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			extenttest.fail(result.getThrowable());
			
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {     //screenshot for pass test
		
			
			try {
				path = action.screenShot(getDriver(), result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			extenttest.pass("Methid is Passed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		

	
}}
