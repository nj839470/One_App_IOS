package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class My_Profile_Page extends Base_Utility {
	public My_Profile_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Home']")
	private WebElement home;

	public WebElement home() {
		return home;
	}

	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='OneApp.HomeView']/XCUIElementTypeButton[3]")
	private WebElement side_menu_button;

	public WebElement side_menu_button() {
		return side_menu_button;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'My Profile')]")
	private WebElement my_profile;

	public WebElement my_profile() {
		return my_profile;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'gmail.com')]")
	private WebElement user_email;

	public WebElement user_email() {
		return user_email;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Now, Add ')]")
	private WebElement Didi_info;

	public WebElement Didi_info() {
		return Didi_info;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='SPLENDOR +'])[2]")
	private WebElement Vehicle_name;

	public WebElement Vehicle_name() {
		return Vehicle_name;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'MBLHAR073H')])[2]")
	private WebElement vin_number;

	public WebElement vin_number() {
		return vin_number;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Edit Profile']")
	private WebElement edit_profile_details_button;

	public WebElement edit_profile_details_button() {
		return edit_profile_details_button;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='editWhite']")
	private WebElement profile_pic_edit_btn;

	public WebElement profile_pic_edit_btn() {
		return profile_pic_edit_btn;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'library')]")
	private WebElement Choose_from_library;

	public WebElement Choose_from_library() {
		return Choose_from_library;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private WebElement Cancel;

	public WebElement Cancel() {
		return Cancel;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'photo')]")
	private WebElement Take_a_Photo;

	public WebElement Take_a_Photo() {
		return Take_a_Photo;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='close']")
	private WebElement upload_close_button;

	public WebElement upload_close_button() {
		return upload_close_button;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	private WebElement Back;

	public WebElement Back() {
		return Back;
	}

//************************************************Edit personal Details**************************	
	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Full Name']")
	private WebElement edit_full_name;

	public WebElement edit_full_name() {
		return edit_full_name;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Email ID']")
	private WebElement edit_email_id;

	public WebElement edit_email_id() {
		return edit_email_id;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Registered Mobile Number']")
	private WebElement edit_registered_mobile_number;

	public WebElement edit_registered_mobile_number() {
		return edit_registered_mobile_number;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private WebElement done;

	public WebElement done() {
		return done;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Male']")
	private WebElement male_radio_button;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Female']")
	private WebElement Female_radio_button;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Other']")
	private WebElement Other_radio_button;

	public void gender_selection() throws InterruptedException {
		try {
			Custom_click(male_radio_button, "Tset radio button for =" + male_radio_button.getText());
			Custom_click(Female_radio_button, "Tset radio button for =" + Female_radio_button.getText());
			Custom_click(Other_radio_button, "Tset radio button for =" + Other_radio_button.getText());
		} catch (Exception e) {
			Message("Issue in Radio button " + e.getMessage());
		} finally {
			Custom_click(male_radio_button, "Finally choose is =" + male_radio_button.getText());
		}

	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Date Of Birth']")
	private WebElement edit_date_of_birth;

	public WebElement edit_date_of_birth() {
		return edit_date_of_birth;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private WebElement Cancel_DOB;

	public WebElement Cancel_DOB() {
		return Cancel_DOB;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private WebElement done_dob;

	public WebElement done_dob() {
		return done_dob;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Blood Group']")
	private WebElement blood_group;

	public WebElement blood_group() {
		return blood_group;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Street Name']")
	private WebElement Street_name;

	public WebElement Street_name() {
		return Street_name;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' PIN Code']")
	private WebElement pin_code;

	public WebElement pin_code() {
		return pin_code;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Save']")
	private WebElement Save_button;

	public WebElement Save_button() {
		return Save_button;
	}

//	*******************************Manage License *****************************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name= 'Driving License']")
	private WebElement manage_license;

	public WebElement manage_license() {
		return manage_license;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Update']")
	private WebElement Update_licence;

	public WebElement Update_licence() {
		return Update_licence;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Digilocker')]")
	private WebElement Choose_from_Digilocker;

	public WebElement Choose_from_Digilocker() {
		return Choose_from_Digilocker;
	}

	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/cross_btn']")
	private WebElement close_button_for_license_upload;

	public WebElement close_button_for_license_upload() {
		return close_button_for_license_upload;
	}

//****************************emergency_contacts***************************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Emergency Contacts ')]")
	private WebElement emergency_contacts;

	public WebElement emergency_contacts() {
		return emergency_contacts;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='more']")
	private WebElement more_contact;

	public WebElement more_contact() {
		return more_contact;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Edit']")
	private WebElement Edit_Contact;

	public WebElement Edit_Contact() {
		return Edit_Contact;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Mobile Number']")
	private WebElement mobile_no;

	public WebElement mobile_no() {
		return mobile_no;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Continue']")
	private WebElement continue_save_contact;

	public WebElement continue_save_contact() {
		return continue_save_contact;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='back']")
	private WebElement back;

	public WebElement back() {
		return back;
	}

}
