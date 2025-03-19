package Page_Test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.page_object.Select_Vehicle_Page;
import com.utility.Base_Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

@Listeners(com.utility.listner.class)

public class Select_Vehicle_Page_Test extends Base_Utility {
	public Select_Vehicle_Page ob;
	public Login_Page_Test login;
	String device = config_getdata("Platform_name");

	@Test(priority = 0)
	public void TC014_verify_Nick_Name() throws InterruptedException {
		Message("************************Select_Vehicle_Page_Test**************************");
		ob = new Select_Vehicle_Page();
//		login = new Login_Page_Test();
//		login.login();
		Thread.sleep(5000);
		Custom_click(ob.edit_nickame_button(), "Tap on pencil for Nick name ");
		VerifyElementPresent(ob.save_button(), "Save button before updating the nick name is ");
		ob.edit_nickame_text().clear();
		custom_sendkeys(ob.edit_nickame_text(), config_getdata("nickname"), "Nick Name ");
		Custom_click(ob.done(), "Done ");
		Custom_click(ob.nick_name_close_button(), "Nick name close button ");
		Thread.sleep(2000);
		if (ob.Nick_name().getText().equalsIgnoreCase(config_getdata("nickname"))) {
			Message("Nick name saved with close button");
		} else {
			Message("Nick name is not saved");
		}

	}

	@Test(dependsOnMethods = "TC014_verify_Nick_Name()", priority = 1)
	public void TC015_Verify_With_30_letter_nick_name() throws InterruptedException {

		Custom_click(ob.edit_nickame_button(), "Tap on pencil for Nick name ");
		ob.edit_nickame_text().clear();
		custom_sendkeys(ob.edit_nickame_text(), config_getdata("30_letter_nick_name"), " 30 letter Nick Name ");
		driver.navigate().back();
		Custom_click(ob.save_button(), "Save button after updating the 30 letter nick name is ");
		Thread.sleep(2000);
		String nick1 = ob.Nick_name().getText();
		if (nick1.length() == 30) {
			Message(" = 30 letter nick name are acceptable");
		} else {
			Message(" = 30 letter nick name are not acceptable");
		}

	}

	@Test(dependsOnMethods = "TC015_Verify_With_30_letter_nick_name()", priority = 2)
	public void TC016_Verify_With_31_letter_nick_name() throws InterruptedException {

		Custom_click(ob.edit_nickame_button(), "Tap on pencil for Nick name ");
		ob.edit_nickame_text().clear();
		custom_sendkeys(ob.edit_nickame_text(), config_getdata("31_letter_nick_name"), "31 letter Nick Name ");
		driver.navigate().back();
		Custom_click(ob.save_button(), "Save button after updating 31 letter nick name the nick name  ");
		Thread.sleep(2000);
		String nick2 = ob.Nick_name().getText();
		if (nick2.length() == 31) {
			Message(" = 31 letter nick name are acceptable");
		} else {
			Message(" = 31 letter nick name are not acceptable");
		}

	}

	@Test(dependsOnMethods = "TC016_Verify_With_31_letter_nick_name()", priority = 3)
	public void TC017_Verify_With_29_letter_nick_name() throws InterruptedException {

		Custom_click(ob.edit_nickame_button(), "Tap on pencil for Nick name ");
		ob.edit_nickame_text().clear();
		custom_sendkeys(ob.edit_nickame_text(), config_getdata("29_letter_nick_name"), "29 letter Nick Name ");
		driver.navigate().back();
		Custom_click(ob.save_button(), "Save button after updating the 29 letter nick name ");
		Thread.sleep(2000);
		String nick3 = ob.Nick_name().getText();
		if (nick3.length() == 29) {
			Message(" = 29 letter nick name are acceptable");
		} else {
			Message(" = 29 letter nick name are not acceptable");
		}

	}

	@Test(priority = 4)
	public void TC018_Select_Vehicle() throws InterruptedException {

		VerifyElementPresent(ob.continue_button(), "Continue Button before select vehicle is");
		ob.vehicle_count();
		Custom_click(ob.click_first_vehicle(), " Select first vehicle");
		VerifyElementPresent(ob.continue_button(), "Continue Button after select vehicle is");
		Custom_click(ob.continue_button(), "Continue Button after select vehicle");
		Thread.sleep(6000);
		try {
			if (ob.Allow().isDisplayed()) {
				Custom_click(ob.Allow(), "Allow location");
			}
		} catch (Exception e) {
			Message("Allow loction pop is not given");
		}
	}
}