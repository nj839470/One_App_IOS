package com.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;

@SuppressWarnings("deprecation")
@Listeners(com.utility.listner.class)
public class Base_Utility
		implements Config_data_provider, Excel_data_Provider, extent_reports_generator, library, ITestListener {
	public static Logger log;
	public static ExtentSparkReporter report;
	public static AppiumDriverLocalService service;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static listner lis;
	public static WebDriverWait wait;
	String confipath = System.getProperty("user.dir") + "/config_data/config.properties";
	String excelpath = System.getProperty("user.dir") + "/Data/data1.xlsx";
	public static IOSDriver driver;
	String enveronment = config_getdata("env");
	public static String userName = "nitesh.jhaintellicredence";
	public static String accessKey = "LT_pdTpLmaeK7kbQOAdzZ6B28TN3ZQe0AMG5sByOIKzxWq0ngT";

	@BeforeTest
	public void OPEN_AND_INSTALL_APP() {
		String deviceName = config_getdata("Platform_name");
		if (deviceName.equalsIgnoreCase("simulator")) {
			try {
				XCUITestOptions options = new XCUITestOptions();
				options.setCapability("appium:automationName", "uiautomator2");
				options.setCapability("platformName", "Android");
				options.setCapability("appium:deviceName", "Pixel_6_API_31");
				options.setCapability("appium:udid", "emulator-5554");
				options.setCapability("appium:avdLaunchTimeout", 90000);
				options.setCapability("appium:app", System.getProperty("user.dir") + "\\apk\\app-debug.apk");
				options.setCapability("appium:ensureWebviewsHavePages", true);
				options.setCapability("appium:nativeWebScreenshot", true);
				options.setCapability("appium:newCommandTimeout", 9600);

				driver = new IOSDriver(new URL(config_getdata("IpAddress")), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

				log = LogManager.getLogger("One_App_IOS");
				lis = new listner();
			} catch (Exception e) {
				log.error("Failed to open and install app: " + e.getMessage(), e);
			}
		} else if (deviceName.equalsIgnoreCase("Lambda")) {
			try {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				HashMap<String, Object> ltOptions = new HashMap<String, Object>();
				ltOptions.put("w3c", true);
				ltOptions.put("platformName", "ios");
				ltOptions.put("deviceName", "iPhone.*");
				if (enveronment.equalsIgnoreCase("prod")) {
					ltOptions.put("app", "lt://APP10160361821740414249380285");
				} else {
					ltOptions.put("app", "lt://APP10160401231739365633247837");
				}
				ltOptions.put("devicelog", true);
				ltOptions.put("visual", true);
				ltOptions.put("video", true);
				ltOptions.put("isRealMobile", true);
				ltOptions.put("autoAcceptAlerts", true);
				ltOptions.put("permissions", "{\"com.customerapp.hero\": {\"location\": \"always\"}}");
				capabilities.setCapability("lt:options", ltOptions);
				driver = new IOSDriver(
						new URL("https://" + userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"),
						capabilities);
				driver.activateApp("com.customerapp.hero");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				log = LogManager.getLogger("One_App_IOS");

			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (deviceName.equalsIgnoreCase("realdevice")) {
			try {
				XCUITestOptions options = new XCUITestOptions();
				options.setCapability("platformName", "iOS");
				options.setCapability("appium:udid", "00008120-0004798A21F9A01E");
				options.setCapability("appium:automationName", "XCUITest");
				options.setCapability("appium:bundleId", "com.customerapp.hero");
				options.setCapability("appium:showXcodeLog", true);
				options.setCapability("autoAcceptAlerts", true);
				options.setCapability("appium:permissions", "{\"com.customerapp.hero\": {\"location\": \"always\"}}");
				driver = new IOSDriver(new URL(config_getdata("IpAddress")), options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				log = LogManager.getLogger("One_App_IOS");
				lis = new listner();
			} catch (Exception e) {
				System.out.println("Error in handling location permission: " + e);
			}
		}

	}

	@Override
	public String config_getdata(String key) {
		String value = "";
		try {
			FileInputStream fis = new FileInputStream(confipath);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);

		} catch (Exception e) {
			System.out.println("Problem in read data from property file" + e);
		}
		return value;
	}

	@Override
	public String excel_getdata(int sheetno, int row_No, int col_No) {
		String value = "";
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			XSSFWorkbook wf = new XSSFWorkbook(fis);
			XSSFSheet sheet = wf.getSheetAt(sheetno);
			value = sheet.getRow(row_No).getCell(col_No).getStringCellValue();

		} catch (Exception e) {
			System.out.println("Problem in read data from excel file" + e);
		}
		return value;
	}

	@Override
	public int getRowCount(int sheetno) {
		int count = 0;
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			XSSFWorkbook wf = new XSSFWorkbook(fis);
			XSSFSheet sheet = wf.getSheetAt(sheetno);
			count = sheet.getLastRowNum();

		} catch (Exception e) {
			System.out.println("Problem in read data from excel file for Row_Count" + e);
		}
		return count;
	}

	@Override
	public int getColCount(int sheetno) {
		int count = 0;
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			XSSFWorkbook wf = new XSSFWorkbook(fis);
			XSSFSheet sheet = wf.getSheetAt(sheetno);
			count = sheet.getRow(0).getLastCellNum();
		} catch (Exception e) {
			System.out.println("Problem in read data from excel file for Row_Count" + e);
		}
		return count;
	}

	@Override
	public void excel_writedata(int sheetno, int row_No, int col_No, String value) {
		try {
			FileInputStream fis = new FileInputStream(excelpath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(sheetno);
			sheet.createRow(row_No).createCell(col_No).setCellValue(value);
			FileOutputStream fos = new FileOutputStream(excelpath);
			workbook.write(fos);
			workbook.close();
		} catch (Exception e) {
			System.out.println("Problem in Write data in excel file" + e);
		}

	}

	@Override
	public ExtentReports getreports() {
		String currenttime = new SimpleDateFormat("dd.MM.YYYY.HH.mm.ss").format(new Date());
		String path = System.getProperty("user.dir") + "/Report/Test-Report -" + currenttime + ".html";
		report = new ExtentSparkReporter(path);
		report.config().setDocumentTitle("One_App Test Report");
		report.config().setReportName("One_App");
		report.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Project Name", "One App");
		extent.setSystemInfo("Laptop", "MacBook Pro intel core i7");
		extent.setSystemInfo("QA", "Nitesh Kumar");
		extent.setSystemInfo("Operating system", "Sonoma 14.5");
		extent.setSystemInfo("BrowserName", "Android Studio");
		return extent;

	}

	@Override
	public void custom_sendkeys(WebElement element, String value, String fieldname) {
		try {
			if (element.isEnabled() || element.isDisplayed() == true) {
				Thread.sleep(2000);
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOf(element));
				element.click();
				element.sendKeys(value);
				test.log(Status.PASS, fieldname + " send successfully =" + value);
				log.info(fieldname + " send successfully");
			}
		} catch (Exception e) {
			if (Base_Utility.lis != null) {
				test.log(Status.FAIL, fieldname + "= is not able to send = "
						+ test.addScreenCaptureFromBase64String(Base_Utility.lis.get_Screen_shot(fieldname)));

			} else {
				test.log(Status.FAIL, fieldname + "= Unable to capture screenshot, 'lis' is null.");
			}
			test.log(Status.FAIL, e);
			log.error(fieldname + " is not able to send: " + e.getMessage());
			Allure.addAttachment("Error Log", fieldname + " Unable to send with error: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}

	public void Delete_message(WebElement ele, String Field_name) {
		try {
			if (ele.isDisplayed() || ele.isEnabled() == true) {
				ele.clear();
				test.log(Status.PASS, Field_name + " is cleared");
				log.info(Field_name + "is cleared");
				Allure.addAttachment("Log", Field_name + " is cleared");
			}
		} catch (Exception e) {
			if (Base_Utility.lis != null) {
				
				test.log(Status.FAIL, Field_name + " is not able to clear = "
						+ test.addScreenCaptureFromBase64String(Base_Utility.lis.get_Screen_shot(Field_name)));
			} else {
				test.log(Status.FAIL, Field_name + "= Unable to capture screenshot, 'lis' is null.");
			}
			test.log(Status.FAIL, e);
			log.error(Field_name + " is not able to clear: " + e.getMessage());
			Allure.addAttachment("Error Log", Field_name + " is not able to clear with error " + e.getMessage());

		}
	}

	@Override
	public void Custom_click(WebElement element, String fieldname) {
		try {
			if (element.isDisplayed() || element.isEnabled() == true) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				test.log(Status.PASS, "Successfully click on = " + fieldname);
				log.info(fieldname + " is clickable");
			}
		} catch (Exception e) {
			if (Base_Utility.lis != null) {
				test.log(Status.FAIL, fieldname + "= Unable to Click = "
						+ test.addScreenCaptureFromBase64String(Base_Utility.lis.get_Screen_shot(fieldname)));
			} else {
				test.log(Status.FAIL, fieldname + "= Unable to capture screenshot, 'lis' is null.");
			}
			test.log(Status.FAIL, e);
			log.error(fieldname + " is not clickable: " + e.getMessage());
			Allure.addAttachment("Error Log", fieldname + " Unable to Click with error: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public void Click_me(WebElement element, String fieldname) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.invisibilityOf(element));
			element.click();
			test.log(Status.PASS, "Successfully click on = " + fieldname);
			log.info(fieldname + " is clickable");

		} catch (Exception e) {
			if (Base_Utility.lis != null) {
				test.log(Status.FAIL, fieldname + "= Unable to Click = "
						+ test.addScreenCaptureFromBase64String(Base_Utility.lis.get_Screen_shot(fieldname)));
			} else {
				test.log(Status.FAIL, fieldname + "= Unable to capture screenshot, 'lis' is null.");
			}
			test.log(Status.FAIL, e);
			log.error(fieldname + " is not clickable: " + e.getMessage());
			Allure.addAttachment("Error Log", fieldname + " Unable to Click with error: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

//======================================================================================================================================================	    

	public static void Scroll_down_page_Action(String fieldname) {
		try {
			Dimension dim = driver.manage().window().getSize();
			int startX = dim.width / 2;
			int startY = (int) (dim.height * 0.8);
			int endY = (int) (dim.height * 0.2);

			PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
			Sequence scroll = new Sequence(finger, 0);
			scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
			scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			scroll.addAction(
					finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY));
			scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(Collections.singletonList(scroll));

			test.log(Status.PASS, "Successfully scrolled down. Action = " + fieldname);
			log.info("Successfully scrolled down. Action: " + fieldname);
			Allure.addAttachment("Log", "Scroll action success: " + fieldname);

		} catch (Exception e) {
			if (Base_Utility.lis != null) {
				Base_Utility.lis.get_Screen_shot(fieldname);
				test.log(Status.FAIL, fieldname + "= Unable To Scroll page Action = "
						+ test.addScreenCaptureFromPath(Base_Utility.lis.getcapcture(fieldname)));
			} else {
				test.log(Status.FAIL, fieldname + "= Unable to capture screenshot, 'lis' is null.");
			}
			test.log(Status.FAIL, e);
			log.error(fieldname + " Unable To Scroll page Action: " + e.getMessage());
			Allure.addAttachment("Error Log",
					fieldname + " Unable To Scroll page action with error: " + e.getMessage());
		}
	}

	// ======================================================================================================================================================
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public static void Scroll_UP_page_Action(String fieldname) {
		try {
			Dimension dim = driver.manage().window().getSize();
			int startx = (int) (dim.width / 2);
			int starty = (int) (dim.height / 2);
			int endx = (int) (dim.width * 0);
			int endy = (int) (dim.height * 0);
			TouchAction action = new TouchAction(driver);
			for (int i = 0; i <= 1; i++) {
				action.press(PointOption.point(startx, starty))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(endx, endy)).release().perform();
			}
			test.log(Status.PASS, "Successfully Scroll page Action ==" + fieldname);
			log.info("Successfully  Scroll page up Action " + fieldname);
		} catch (Exception e) {
			log.error("==NOT==Unable To Scroll up page Action " + fieldname);
		}
	}

//======================================================================================================================================================
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public void swipe_page_direction(int startx, int starty, int endx, int endy, String fieldname) {
		try {
			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(startx, starty)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(endx, endy)).release().perform();
			log.info("Successfully  Swipe page direction Action " + fieldname);
			test.log(Status.PASS, "Successfully  Swipe page direction Action = " + fieldname);
		} catch (Exception e) {
			log.error("==NOT==Unable To Swipe page direction Action " + fieldname);
			test.log(Status.FAIL, fieldname + "Unable To Swipe page direction Action " + fieldname + e);
			test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
		}
	}

	// =================================================================================================================================
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void horizontal_scroll_image(WebElement end_position, WebElement Start_position, String fieldname) {
		try {
			TouchAction action = new TouchAction(driver);
			if (end_position.isDisplayed() || end_position.isEnabled() && Start_position.isDisplayed()
					|| Start_position.isEnabled() == true) {
				Point location1 = end_position.getLocation();
				Point location2 = Start_position.getLocation();
				System.out.println("location1 =" + location1 + "location2 =" + location2);
				int end_x = location1.x;
				int end_y = location1.y - 90;
				int start_x = location2.x;
				int start_y = location2.y - 90;
				System.out.println(
						"end_x =" + end_x + "end_y =" + end_y + "start_x = " + start_x + "start_y =" + start_y);
				action.press(PointOption.point(start_x, start_y))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point(end_x, end_y)).release().perform();
				log.info("Successfully  Swipe page direction Action " + fieldname);
				test.log(Status.PASS, "Successfully  Swipe page direction Action = " + fieldname);
			}
		} catch (Exception e) {
			log.error("==NOT==Unable To Swipe page direction Action " + fieldname);
			test.log(Status.FAIL, fieldname + "Unable To Swipe page direction Action " + fieldname + e);
			test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
		}
	}
//=================================================================================================================================

	// ======================================================================================================================================================
	public void scrollByText(String menuText) {

		try {

			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""
							+ menuText + "\").instance(0));"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void VerifyImagePresent(WebElement image, String fieldname) {
		try {
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					image);
			if (ImagePresent) {
				test.log(Status.PASS, "Image is present:  " + fieldname);
				log.info("Image is present " + fieldname);
			} else {
				test.log(Status.FAIL, fieldname + "==Image is not present ==");
				test.addScreenCaptureFromPath(lis.getcapcture(fieldname));
				log.error("Image is not present" + fieldname);

			}
		} catch (Exception e) {
			if (Base_Utility.lis != null) {
				Base_Utility.lis.get_Screen_shot(fieldname);
				test.log(Status.FAIL, fieldname + "= Image is not present = "
						+ test.addScreenCaptureFromPath(Base_Utility.lis.getcapcture(fieldname)));
			} else {
				test.log(Status.FAIL, fieldname + "= Unable to capture screenshot, 'lis' is null.");
			}
			test.log(Status.FAIL, e);
			log.error(fieldname + " Image is not present " + e.getMessage());
			Allure.addAttachment("Error Log", fieldname + " Image is not present with error: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void PageLoaded() {
		String Title = null;
		try {
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			Title = driver.getTitle();
			test.log(Status.PASS, "Page is loaded :  " + Title);
			log.info("Page is loaded " + Title);
		} catch (Exception e) {
			test.log(Status.FAIL, "==page is not loaded :" + e);
			log.error("page is not able to loaded " + Title);

		}
	}

	@Override
	public void VerifyElementPresent(WebElement ele, String fieldname) {
		try {
			if (ele.isDisplayed() && ele.isEnabled() == true) {
				String Text = ele.getText();
				test.log(Status.PASS, fieldname + " present:");
				log.info(fieldname + " present");
			} else {
				test.log(Status.PASS, fieldname + "  not present");
				log.info(fieldname + "  not present");
			}
		} catch (Exception e) {
			if (Base_Utility.lis != null) {
				Base_Utility.lis.get_Screen_shot(fieldname);
				test.log(Status.FAIL, fieldname + "= not present = "
						+ test.addScreenCaptureFromPath(Base_Utility.lis.getcapcture(fieldname)));
			} else {
				test.log(Status.FAIL, fieldname + "= Unable to capture screenshot, 'lis' is null.");
			}
			test.log(Status.FAIL, e);
			log.error(fieldname + "  not present " + e.getMessage());
			Allure.addAttachment("Error Log", fieldname + " not present with error: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}

	@Override
	public void msg(WebElement ele, String filedname) {
		try {
			if (ele.isDisplayed()) {
				wait = new WebDriverWait(driver, Duration.ofSeconds(17));
				wait.until(ExpectedConditions.visibilityOf(ele));
				String mes = ele.getText();
				test.log(Status.PASS, filedname + mes);
				log.info(filedname + mes);
			}
		} catch (Exception e) {
			if (Base_Utility.lis != null) {
				test.log(Status.FAIL, filedname + "= is not readable = "
						+ test.addScreenCaptureFromBase64String(Base_Utility.lis.get_Screen_shot(filedname)));
			} else {
				test.log(Status.FAIL, filedname + "= Unable to capture screenshot, 'lis' is null.");
			}
			test.log(Status.FAIL, e);
			log.error(filedname + "  is not readable " + e.getMessage());
			Allure.addAttachment("Error Log", filedname + " is not readable with error: " + e.getMessage());
			throw new RuntimeException(e);
		}

	}

	@Override
	public void Message(String message) {
		test.log(Status.PASS, message);
		log.info(message);
	}

	public void error_message(String message) {
		test.log(Status.FAIL, message);
		log.error(" ");
		test.addScreenCaptureFromPath(lis.getcapcture(message));
	}

	@AfterTest
	public void tear_Down() {
		driver.quit();
	}
}
