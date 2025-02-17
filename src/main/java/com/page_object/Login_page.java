package com.page_object;

import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.utility.Base_Utility;

import android.inputmethodservice.Keyboard.Key;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.ElementOption;

@Listeners(com.utility.listner.class)
public class Login_page extends Base_Utility {
	public Login_page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Registered mobile number']")
	private WebElement mobile_No;

	public WebElement mobile_No() {
		return mobile_No;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Number not regist')]")
	private WebElement registerd_message;

	public WebElement registerd_message() {
		return registerd_message;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Update registered')]")
	private WebElement registerd_message_1;

	public WebElement registerd_message_1() {
		return registerd_message_1;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='crossGreyIcon']")
	private WebElement cancel_button_r;

	public WebElement cancel_button_r() {
		return cancel_button_r;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name =' Proceed ']")
	private WebElement process_require_notification;

	public WebElement process_require_notification() {
		return process_require_notification;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Continue']")
	private WebElement continue_button;

	public WebElement continue_button() {
		return continue_button;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField")
	private List<WebElement> OTP;

	public void enter_Valid_OTP() {
		try {
			for (int i = 0; i < OTP.size(); i++) {
				OTP.get(i).click();
				Thread.sleep(2000);
				custom_sendkeys(OTP.get(i), "" + (i + 1), "enterOTP =" + (i + 1));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void enter_Valid_OTP_prod() {
		try {
			custom_sendkeys(OTP.get(0), "" + 2, "enterOTP =" + 2);
			custom_sendkeys(OTP.get(1), "" + 3, "enterOTP =" + 3);
			custom_sendkeys(OTP.get(2), "" + 4, "enterOTP =" + 4);
			custom_sendkeys(OTP.get(3), "" + 6, "enterOTP =" + 6);
			custom_sendkeys(OTP.get(4), "" + 5, "enterOTP =" + 5);
			custom_sendkeys(OTP.get(5), "" + 1, "enterOTP =" + 1);

		} catch (Exception e) {
			Message("" + e);
		}
	}

	public void enter_inavalid_OTP() {
		try {
			System.out.println(OTP.size());
			for (int i = 0, j = 3; i < OTP.size(); i++) {

				custom_sendkeys(OTP.get(i), "" + (j + 1), "OTP is " + (j + 1));
				j++;
			}
		} catch (Exception e) {
			Message("" + e);
		}
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Resend']")
	private WebElement resend_button;

	public WebElement resend_button() {
		return resend_button;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Verify']")
	private WebElement verify_button;

	public WebElement verify_button() {
		return verify_button;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private WebElement Cancel_digi;

	public WebElement Cancel_digi() {
		return Cancel_digi;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Terms of Use']")
	private WebElement Terms_of_Use;

	public WebElement Terms_of_Use() {
		return Terms_of_Use;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Terms of Use']")
	private WebElement Terms_of_Use_condition;

	public WebElement Terms_of_Use_condition() {
		return Terms_of_Use_condition;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Terms of Use'])[1]")
	private WebElement Terms_of_Use_condition_for_real_device;

	public WebElement Terms_of_Use_condition_for_real_device() {
		return Terms_of_Use_condition_for_real_device;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name=' Privacy Policy']")
	private WebElement Privacy_Policy;

	public WebElement Privacy_Policy() {
		return Privacy_Policy;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Privacy Policy']")
	private WebElement Privacy_Policy_condition;

	public WebElement Privacy_Policy_condition() {
		return Privacy_Policy_condition;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Privacy Policy'])[1]")
	private WebElement Privacy_of_Use_condition_for_real_device;

	public WebElement Privacy_of_Use_condition_for_real_device() {
		return Privacy_of_Use_condition_for_real_device;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Contact Us']")
	private WebElement contact_us;

	public WebElement contact_us() {
		return contact_us;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Facebook']")
	private WebElement contact_us_message;

	public WebElement contact_us_message() {
		return contact_us_message;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	private WebElement back_page;

	public WebElement back_page() {
		return back_page;
	}

	@FindBy(xpath = "//*[@name='back']")
	private WebElement back_contact;

	public WebElement back_contact() {
		return back_contact;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='editredcircle']")
	private WebElement edit_moble_button;

	public WebElement edit_moble_button() {
		return edit_moble_button;
	}

	@FindBy(xpath = "//*[@name='Done']")
	private WebElement done;

	public WebElement done() {
		return done;
	}

	@FindBy(xpath = "(//XCUIElementTypeButton[contains(@name,'Allow')])[1]")
	private WebElement Allow;

	public WebElement Allow() {
		return Allow;
	}

	@FindBy(xpath = "//*[@name='Allow']")
	private WebElement allow;

	public WebElement allow() {
		return allow;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Continue as guest']")
	private WebElement Continue_as_guest;

	public WebElement Continue_as_guest() {
		return Continue_as_guest;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Find A Dealer']")
	private WebElement nearby_dealer;

	public WebElement nearby_dealer() {
		return nearby_dealer;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Exchange')]")
	private WebElement vehicle_exchange;

	public WebElement vehicle_exchange() {
		return vehicle_exchange;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='View Challans']")
	private WebElement View_Challans;

	public WebElement View_Challans() {
		return View_Challans;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Update mobile number for Hero vehicle?']")
	private WebElement update_mobile_number;

	public WebElement update_mobile_number() {
		return update_mobile_number;
	}

	@FindBy(xpath = "//*[contains(@name,'Enter 6-digit OTP sent to') ]")
	private WebElement registered_mobile_no;

	public WebElement registered_mobile_no() {
		return registered_mobile_no;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Update Number']")
	private WebElement update_number;

	public WebElement update_number() {
		return update_number;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Continue as guest'])[2]")
	private WebElement Continue_guest_btn;

	public WebElement Continue_guest_btn() {
		return Continue_guest_btn;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name]")
	private List<WebElement> details_verify;

	public void details_verify() {
		for (int i = 0; i < 3; i++) {
			Message(details_verify.get(i).getText());
		}
	}
}
