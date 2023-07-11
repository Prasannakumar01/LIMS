package org.NewaInsurance_GenrericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution has been finished");
		report.flush();
	}

	@Override
	public void onStart(ITestContext context) { 
		System.out.println("Suite Execution has started");
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".//ExtentReports//reports-"+new JavaUtilities().getSystemdatainFormat()+".html");
		htmlreport.config().setDocumentTitle("LifeInsurance Reports");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("LifeInusranceReport");
		 report=new ExtentReports();
		 report.attachReporter(htmlreport);
		 report.setSystemInfo("Base url","http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		 report.setSystemInfo("Base Browser","chrome");
		 report.setSystemInfo("Reporter name","Prasanna");
		 
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		JavaUtilities jlib=new JavaUtilities();
		WebdriverPerformUtilities wlib= new WebdriverPerformUtilities();
		String methodname=	result.getMethod().getMethodName();
	      test.log(Status.FAIL,methodname+"----Fail");
	      test.log(Status.INFO,result.getThrowable());
	      
	      String screenshotname=methodname+"-"+jlib.getSystemdatainFormat();
	      try {
	    	 String path=wlib.takesScreenshot(BaseClass.sDriver,screenshotname);
	    	 test.addScreenCaptureFromPath(path);  
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		test.log(Status.FAIL,methodname+"-----Skip");
		test.log(Status.INFO,result.getThrowable());
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---Execution has started");
		test=report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		test.log(Status.PASS,methodname+"------pass");
		
	}
	


}
