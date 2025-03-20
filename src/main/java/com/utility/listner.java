package com.utility;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.qameta.allure.Allure;

public class listner extends Base_Utility implements ITestListener {

	ExtentReports extent = getreports();
	ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName() + " = " + result.getMethod().getMethodName());

		extent_test.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		test = test.log(Status.PASS, "Test Case Pass");
		extent_test.set(test);
	}

	public void onTestFailure(ITestResult result) {
		test = test.log(Status.FAIL, "Test Case Fail");
		test = test.addScreenCaptureFromBase64String(get_Screen_shot(result.getName()));
		getcapcture(result.getName());
		extent_test.set(test);

	}

	public void onTestSkipped(ITestResult result) {
		test = test.log(Status.SKIP, "Test Case Skip");
		test = test.addScreenCaptureFromBase64String(get_Screen_shot(result.getName()));
		getcapcture(result.getName());
		extent_test.set(test);
	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}

	public String getcapcture(String screenshot_name) {
		String destination = System.getProperty("user.dir") + "/failed_Tests_ScreenShots/" + screenshot_name + ".png"
				+ date_and_Time("dd-MM-yyyy_hh mm ss");
		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File finaldestination = new File(destination);
			FileUtils.copyFile(source, finaldestination);
			Allure.addAttachment("Page Screenshot", FileUtils.openInputStream(finaldestination));
		} catch (Exception e) {
			System.out.println(e);
		}
		return destination;
	}

	public String get_Screen_shot(String screenshot_name) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			String source = ts.getScreenshotAs(OutputType.BASE64);
			Allure.addAttachment(screenshot_name,
					new ByteArrayInputStream(java.util.Base64.getDecoder().decode(source)));
			System.out.println("Screenshot attached to Allure report.");
			return source;
		} catch (Exception e) {
			Message("Screenshot not attached due to an error: " + e.getMessage());
			System.out.println("Screenshot not attached due to an error: " + e.getMessage());
			return null;
		}
		
	}

	public String date_and_Time(String formate) {
		String value = "";
		try {
			Date db = new Date();
			DateFormat df = new SimpleDateFormat(formate);
			value = df.format(db);
		} catch (Exception e) {
			System.out.println("Problem in data and time" + e);
		}
		return value;
	}

}
