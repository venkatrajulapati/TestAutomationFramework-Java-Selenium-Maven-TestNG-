package com.application.listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.application.libs.web.test_base;

public class testngListener extends test_base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
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
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		/*LocalDateTime dt = dateUtils.getDate(0);//LocalDateTime.now();
		String todaysDt1 = dateUtils.getFormattedDate(dt, "dd-MM-yyyy-HHmmss");//dt.format(formatter);
		String todaysDt2 = dateUtils.getFormattedDate(dt, "dd-MM-yyyy");//dt.format(formatter1);
		screenShotFolder = "./results/screenshots/" + todaysDt1;
		repFolder = "./results/reports/" + todaysDt2;
		confilePropertiesFile = "./config/application.properties";*/
		
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		ITestListener.super.onFinish(context);
	}

}
