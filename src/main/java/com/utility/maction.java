package com.utility;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.Dimension;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

@SuppressWarnings("deprecation")
public class maction {
	public static ExtentTest test;
	public static AndroidDriver driver1;

	// private AndroidDriver driver1;
	    public maction (AndroidDriver driver1) {
	        maction.driver1 = driver1;
	    }
	    //Tap to an element for 250 milliseconds
	    @SuppressWarnings({ "rawtypes" })
	    public void tapByElement (AndroidBy androidElement) {
	        new TouchAction(driver1)
	            .tap(tapOptions().withElement(element(androidElement)))
	            .waitAction(waitOptions(ofMillis(250))).perform();
	    }
	    private ElementOption element(AndroidBy androidElement) {
			// TODO Auto-generated method stub
			return null;
		}
		//Tap by coordinates
	    @SuppressWarnings("rawtypes")
		public static void tapByCoordinates (int x,  int y) {
	        new TouchAction(driver1)
	            .tap(point(x,y))
	            .waitAction(waitOptions(ofMillis(250))).perform();
	       
	    }
	    //Press by element
	    @SuppressWarnings("rawtypes")
		public  void pressByElement (AndroidBy element, long seconds) {
	        new TouchAction(driver1)
	            .press(element(element))
	            .waitAction(waitOptions(ofSeconds(seconds)))
	            .release()
	            .perform();
	    }
	    //Press by coordinates
	    @SuppressWarnings("rawtypes")
		public static void pressByCoordinates (int x, int y, long seconds) {
	        new TouchAction(driver1)
	            .press(point(x,y))
	            .waitAction(waitOptions(ofSeconds(seconds)))
	            .release()
	            .perform();
	    }
	    //Horizontal Swipe by percentages
	    @SuppressWarnings("rawtypes")
		public static void horizontalSwipeByPercentage (double startPercentage, double endPercentage, double anchorPercentage) {
	        Dimension size = driver1.manage().window().getSize();
	        int anchor = (int) (size.height * anchorPercentage);
	        int startPoint = (int) (size.width * startPercentage);
	        int endPoint = (int) (size.width * endPercentage);
	        new TouchAction(driver1)
	            .press(point(startPoint, anchor))
	            .waitAction(waitOptions(ofMillis(1000)))
	            .moveTo(point(endPoint, anchor))
	            .release().perform();
	    }
	    //Vertical Swipe by percentages
	    @SuppressWarnings("rawtypes")
		public static void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
	        Dimension size = driver1.manage().window().getSize();
	        int anchor = (int) (size.width * anchorPercentage);
	        int startPoint = (int) (size.height * startPercentage);
	        int endPoint = (int) (size.height * endPercentage);
	        new TouchAction(driver1)
	            .press(point(anchor, startPoint))
	            .waitAction(waitOptions(ofMillis(1000)))
	            .moveTo(point(anchor, endPoint))
	            .release().perform();
	    }
	    //Swipe by elements
//	    public void swipeByElements (AndroidBy startElement, AndroidBy endElement) {
//	        int startX = ((Object) startElement).getLocation().getX() + (((Window) startElement).getSize().getWidth() / 2);
//	        int startY = ((Object) startElement).getLocation().getY() + (((Window) startElement).getSize().getHeight() / 2);
//	        int endX = ((Object) endElement).getLocation().getX() + (((Window) endElement).getSize().getWidth() / 2);
//	        int endY = ((Object) endElement).getLocation().getY() + (((Window) endElement).getSize().getHeight() / 2);
//	        new TouchAction(driver1)
//	            .press(point(startX,startY))
//	            .waitAction(waitOptions(ofMillis(1000)))
//	            .moveTo(point(endX, endY))
//	            .release().perform();
//	    }
	    //Multitouch action by using an android element
	    public  void multiTouchByElement (AndroidKey androidElement) {
        @SuppressWarnings("rawtypes")
			TouchAction press = new TouchAction(driver1)
	            .press(element(androidElement))
	            .waitAction(waitOptions(ofSeconds(1)))
	            .release();
	        new MultiTouchAction(driver1)
	            .add(press)
	            .perform();
	    }		@SuppressWarnings("rawtypes")
		private PointOption element(AndroidKey androidElement) {
			
			return null;
		}

}
