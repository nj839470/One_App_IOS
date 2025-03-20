package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;
import com.utility.Base_Utility;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Allure;

public class Home_Page extends Base_Utility {
	public Services_Page ob1;
	String device = config_getdata("Platform_name");

	public Home_Page() {
		PageFactory.initElements(driver, this);
	}

	// *************************Temperature**********************
	@FindBy(xpath = "//XCUIElementTypeButton[@name='crossGreyIcon']")
	private WebElement close_drop_down;
	@FindBy(xpath = "")
	private WebElement enable_now;

	public WebElement enable_now() {
		return enable_now;
	}

	@FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='OneApp.HomeView']/XCUIElementTypeOther")
	private WebElement vehicle_drop_down;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Primary')]")
	private List<WebElement> all_vehicle_inside_drop_down;
	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'crossGreyIcon')]")
	private WebElement select_vehicle_close_btn;
	@FindBy(xpath = "(//XCUIElementTypeButton[contains(@name,'Allow')])[1]")
	private WebElement Allow;

	public WebElement Allow() {
		return Allow;
	}

	public void all_vehicle_inside_drop_down() throws InterruptedException {

		Custom_click(vehicle_drop_down, " Drop down");
		try {
			if (Allow.isDisplayed())
				Custom_click(Allow, "Allow location");
		} catch (Exception e) {
			Message("Allow loction pop is not given");

		}
		Custom_click(all_vehicle_inside_drop_down.get(0), "Select Vehicle");
		Custom_click(vehicle_drop_down, " Drop down");
		Thread.sleep(2000);
		Custom_click(select_vehicle_close_btn, "select vehicle close button");
	}

	@FindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeImage[2]")
	private WebElement vehicle_img;

	public WebElement vehicle_img() {
		return vehicle_img;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='notification']")
	private WebElement notification;

	public WebElement notification() {
		return notification;
	}

	@FindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<WebElement> notification_count;

	public void notification_count() {
		try {
			for (int i = 0; i < notification_count.size(); i++) {
				msg(notification_count.get(i), "");
				i++;
			}
		} catch (Exception e) {

		}
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='back']")
	private WebElement notification_back;

	public WebElement notification_back() {
		return notification_back;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Actions')]")
	private WebElement Collapse_btn;

	public WebElement Collapse_btn() {
		return Collapse_btn;
	}

	// **************************************SOS********************************
	@FindBy(xpath = "//XCUIElementTypeButton[@name='sos']")
	private WebElement SOS_icon;

	public WebElement SOS_icon() {
		return SOS_icon;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'The app will alert with')]")
	private WebElement SOS_message;

	public WebElement SOS_message() {
		return SOS_message;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'x')]")
	private WebElement SOS_close_btn;

	public WebElement SOS_close_btn() {
		return SOS_close_btn;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Send Alert ')]")
	private WebElement sent_alert_btn;

	public WebElement sent_alert_btn() {
		return sent_alert_btn;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Don’t send.']")
	private WebElement dont_send;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'safe')]")
	private WebElement safe;

	public void dont_send() {
		Custom_click(dont_send, dont_send.getText() + " " + safe.getText());
	}

//*************************Navigate Page**********************
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Navigate']")
	private WebElement Navigate_menu;

	public WebElement Navigate_menu() {
		return Navigate_menu;
	}

	@FindBy(xpath = "//XCUIElementTypeSearchField[contains(@name,'Search Destination')]")
	private WebElement Search_destination;

	public WebElement Search_destination() {
		return Search_destination;
	}

	@FindBy(xpath = "//XCUIElementTypeSearchField[@name='Search']")
	private WebElement Search_here;

	public WebElement Search_here() {
		return Search_here;
	}

	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]")
	private WebElement chose_place_name;

	public WebElement chose_place_name() {
		return chose_place_name;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Navigate']")
	private WebElement Navigate_button;

	public WebElement Navigate_button() {
		return Navigate_button;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Start']")
	private WebElement Start;

	public WebElement Start() {
		return Start;

	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='close']")
	private WebElement stop_navigation;

	public WebElement stop_navigation() {
		return stop_navigation;
	}

	// ****************************Exchange Page*******************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Exchange']")
	private WebElement Exchange_Menu;

	public WebElement Exchange_Menu() {
		return Exchange_Menu;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='SPLENDOR +']")
	private WebElement Exchange_vehicle_name;

	public WebElement Exchange_vehicle_name() {
		return Exchange_vehicle_name;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Find estimated ')]")
	private WebElement real_value_msg;

	public WebElement real_value_msg() {
		return real_value_msg;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Choose city')]")
	private WebElement choose_city;

	public WebElement choose_city() {
		return choose_city;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[contains(@name,' City to ')]")
	private WebElement city_sell;

	public WebElement city_sell() {
		return city_sell;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'New Delhi ')]")
	private WebElement choose_city_sell;

	public WebElement choose_city_sell() {
		return choose_city_sell;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[contains(@name,' Pin ')]")
	private WebElement city_pin_code;

	public WebElement city_pin_code() {
		return city_pin_code;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private WebElement done;

	public WebElement done() {
		return done;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Next']")
	private WebElement next_btn;

	public WebElement next_btn() {
		return next_btn;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText")
	private List<WebElement> exchange_info;

	public void exchange_info() {
		try {
			for (int i = 0; i < exchange_info.size(); i++) {
				msg(exchange_info.get(i), "");
			}
		} catch (Exception e) {
			Message("All real value message not visible");
		}
	}

//****************************Vehicle Condition************************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Vehicle Condition']")
	private WebElement vehicle_condition;

	public WebElement vehicle_condition() {
		return vehicle_condition;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Identify your ')]")
	private WebElement condition_msg;

	public WebElement condition_msg() {
		return condition_msg;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Smoke'])[2]")
	private WebElement Smoke;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Is there any Smoke')]")
	private WebElement Smoke_msg;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='No Smoke']")
	private WebElement no_smok_radio_btn;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Starting']")
	private WebElement Starting;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Starting the vehicle?')]")
	private WebElement Starting_msg;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='Starts Normally']")
	private WebElement Starts_normal_radio_btn;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Light Indicator']")
	private WebElement Light_indicator;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Lights & Indicators?')]")
	private WebElement Light_indicator_msg;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Working']")
	private WebElement Working_radio_btn;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Front Tyre']")
	private WebElement front_tyre;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Front Tyre?')]")
	private WebElement front_tyre_msg;
	@FindBy(xpath = "(//XCUIElementTypeButton[@name='OK'])[1]")
	private WebElement ok_radio_btn;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Rear Tyre']")
	private WebElement rear_tyre;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Rear Tyre?')]")
	private WebElement rear_tyre_msg;
	@FindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
	private WebElement ok_rear_radion_btn;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Body Part']")
	private WebElement body_part;
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Body Parts?')]")
	private WebElement body_part_msg;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='No Scratch / Dent / Cracks']")
	private WebElement no_scrtch_radio_btn;

	public void all_question() {
		try {
			msg(Smoke, "");
			msg(Smoke_msg, "");
			Custom_click(no_smok_radio_btn, no_smok_radio_btn.getText() + " radio button");
			msg(Starting, "");
			msg(Starting_msg, "");
			Custom_click(Starts_normal_radio_btn, Starts_normal_radio_btn.getText() + " radio button");
			msg(Light_indicator, "");
			msg(Light_indicator_msg, "");
			Custom_click(Working_radio_btn, Working_radio_btn.getText() + " radio button");
			msg(front_tyre, "");
			msg(front_tyre_msg, "");
			Custom_click(ok_radio_btn, ok_radio_btn.getText() + " radio button");
			msg(rear_tyre, "");
			msg(rear_tyre_msg, "");
			Custom_click(ok_rear_radion_btn, ok_rear_radion_btn.getText() + " radio button");
			msg(body_part, "");
			msg(body_part_msg, "");
			Custom_click(no_scrtch_radio_btn, no_scrtch_radio_btn.getText() + " radio button");
		} catch (Exception e) {
			if (Base_Utility.lis != null) {
				Base_Utility.lis.get_Screen_shot("");
				test.log(Status.FAIL, "" + test.addScreenCaptureFromPath(Base_Utility.lis.getcapcture("")));
			} else {
				test.log(Status.FAIL, "= Unable to capture screenshot, 'lis' is null.");
			}
			test.log(Status.FAIL, e);
			log.error(" " + e.getMessage());
			Allure.addAttachment("Error Log", "" + e.getMessage());
			throw new RuntimeException(e);
		}
	}

//****************************Documents Page************************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Documents']")
	private WebElement Documents_Menu;

	public WebElement Documents_Menu() {
		return Documents_Menu;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='R.C.']")
	private WebElement RC_document;

	public WebElement RC_document() {
		return RC_document;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@type = 'XCUIElementTypeButton']")
	private List<WebElement> document_Status;

	public List<WebElement> document_Status() {
		return document_Status;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'library')]")
	private WebElement Choose_Document_from_library;

	public WebElement Choose_Document_from_library() {
		return Choose_Document_from_library;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private WebElement cancel_library;

	public WebElement cancel_library() {
		return cancel_library;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'photo')]")
	private WebElement Take_a_Photo;

	public WebElement Take_a_Photo() {
		return Take_a_Photo;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Digilocker')]")
	private WebElement Choose_from_Digilocker;

	public WebElement Choose_from_Digilocker() {
		return Choose_from_Digilocker;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='close']")
	private WebElement document_upload_close_button;

	public WebElement document_upload_close_button() {
		return document_upload_close_button;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Close']")
	private WebElement cancel_Background;

	public WebElement cancel_Background() {
		return cancel_Background;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='shareRedLarge1']")
	private WebElement share_document;

	public WebElement share_document() {
		return share_document;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='download invoice']")
	private WebElement download_document;

	public WebElement download_document() {
		return download_document;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Update']")
	private WebElement update_doc;

	public WebElement update_doc() {
		return update_doc;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'ic back')]")
	private WebElement Back_Start_Navigation;

	public WebElement Back_Start_Navigation() {
		return Back_Start_Navigation;

	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	private WebElement Back;

	public WebElement Back() {
		return Back;

	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='back']")
	private WebElement back;

	public WebElement back() {
		return back;

	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Insurance']")
	private WebElement Insurance_document;

	public WebElement Insurance_document() {
		return Insurance_document;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='P.U.C.']")
	private WebElement PUC_document;

	public WebElement PUC_document() {
		return PUC_document;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Challans']")
	private WebElement Challans_document;

	public WebElement Challans_document() {
		return Challans_document;
	}

//****************************Relationship Manager************************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Relationship Manager']")
	private WebElement Relationship_Manager;

	public WebElement Relationship_Manager() {
		return Relationship_Manager;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText")
	private List<WebElement> Relationship_manager_info;

	public void Relationship_manager_info() {
		try {
			if (Relationship_manager_info.size() != 0) {
				for (int i = 0; i < Relationship_manager_info.size(); i++) {
					Message("Relationship manage information =" + Relationship_manager_info.get(i).getText());
				}
			}
		} catch (Exception e) {
			Message("" + e);
		}

	}

//****************************RSA************************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='RSA']")
	private WebElement RSA;

	public WebElement RSA() {
		return RSA;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText")
	private List<WebElement> RSA_info;

	public void RSA_info() {
		for (int i = 0; i < RSA_info.size(); i++) {
			msg(RSA_info.get(i), " ");
		}
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Roadside Assistance Now')]")
	private WebElement renew_rsa;

	public WebElement renew_rsa() {
		return renew_rsa;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Registration number']")
	private WebElement registration_number;

	public WebElement registration_number() {
		return registration_number;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'RSA program in a year?')]")
	private WebElement asked_questions_1;

	public WebElement asked_questions_1() {
		return asked_questions_1;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'The RSA program covers')]")
	private WebElement answer_1;

	public WebElement answer_1() {
		return answer_1;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'RSA coverage start?')]")
	private WebElement asked_questions_2;

	public WebElement asked_questions_2() {
		return asked_questions_2;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'Certificate is issued post payment ')]")
	private WebElement answer_2;

	public WebElement answer_2() {
		return answer_2;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'avail RSA services?')]")
	private WebElement asked_questions_3;

	public WebElement asked_questions_3() {
		return asked_questions_3;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,'You can avail RSA services ')]")
	private WebElement answer_3;

	public WebElement answer_3() {
		return answer_3;
	}

//****************************Technical Support************************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Technical Support']")
	private WebElement Technical_Support;

	public WebElement Technical_Support() {
		return Technical_Support;
	}

	@FindBy(className = "XCUIElementTypeStaticText")
	private List<WebElement> techinalManagerInfo;

	public void technicalManagerInfo() {
		for (int i = 1; i < techinalManagerInfo.size(); i++) {
			Message(techinalManagerInfo.get(i).getText());
		}
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='No data found']")
	private WebElement no_data_found;

	public WebElement no_data_found() {
		return no_data_found;
	}

//****************************Dealer Locator************************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Dealer Locator']")
	private WebElement Dealer_Locator;

	public WebElement Dealer_Locator() {
		return Dealer_Locator;
	}

	@FindBy(xpath = "//XCUIElementTypeApplication[@name='Hero App']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeButton")
	private WebElement Select_City;

	public WebElement Select_City() {
		return Select_City;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'DELHI')]")
	private WebElement Select_State_list;

	public WebElement Select_State_list() {
		return Select_State_list;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='locator']")
	private WebElement map_view;

	public WebElement map_view() {
		return map_view;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText")
	private List<WebElement> Dealer_info;

	public void Dealer_info() {
		try {
			for (int i = 3; i < 9; i++) {
				Message("" + Dealer_info.get(i).getText());
			}
		} catch (Exception e) {
			Message("Some dealer info is missing");
		}
	}

	// ****************************Service_at_home_page************************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name , 'Service was')]")
	private WebElement service_due;
	
	public WebElement service_due() {
		return service_due;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'20')]")
	private WebElement due_data;

	public WebElement due_data() {
		return due_data;
	}

	
	// ****************************verify_PAM************************************

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Helmets']")
	private WebElement Helmets;

	public WebElement Helmets() {
		return Helmets;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'Helmet Full')])[1]")
	private WebElement Helemet_name;

	public WebElement Helemet_name() {
		return Helemet_name;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'₹')])[2]")
	private WebElement Helemet_price;

	public WebElement Helemet_price() {
		return Helemet_price;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Allow']")
	private WebElement allow_location;

	public WebElement allow_location() {
		return allow_location;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[contains(@name,' Add New Location')]")
	private WebElement add_Location;

	public WebElement add_Location() {
		return add_Location;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name= 'Confirm Location']")
	private WebElement confirm_location;

	public WebElement confirm_location() {
		return confirm_location;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='']")
	private WebElement plane_header;

	public WebElement plane_header() {
		return plane_header;
	}

	@FindBy(xpath = "(//XCUIElementTypeButton[@name=''])[1]")
	private WebElement mobile_header;

	public WebElement mobile_header() {
		return mobile_header;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Signed')]")
	private WebElement Signed_msg;

	public WebElement Signed_msg() {
		return Signed_msg;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'+')]")
	private WebElement Signed_contact_number;

	public WebElement Signed_contact_number() {
		return Signed_contact_number;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='']")
	private WebElement close_icon;

	public WebElement close_icon() {
		return close_icon;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Lubricant')]")
	private WebElement Lubricant;

	public WebElement Lubricant() {
		return Lubricant;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'HERO GENUINE')])[1]")
	private WebElement Lubricant_name;

	public WebElement Lubricant_name() {
		return Lubricant_name;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Merchandise']")
	private WebElement Merchandise;

	public WebElement Merchandise() {
		return Merchandise;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'HERO OFFICIAL')])[3]")
	private WebElement Merchandise_name;

	public WebElement Merchandise_name() {
		return Merchandise_name;

	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Accessories']")
	private WebElement Accessories;

	public WebElement Accessories() {
		return Accessories;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'HERO GENUINE')])[2]")
	private WebElement Accessories_name;

	public WebElement Accessories_name() {
		return Accessories_name;

	}

	// ****************************View_All_Accessories_in_PAM************************************
	@FindBy(xpath = "//XCUIElementTypeButton[@name='View All Accessories']")
	private WebElement viewAll;

	public WebElement viewAll() {
		return viewAll;

	}

	// ****************************Latest_at_home_page************************************
	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[2]")
	private WebElement Latest_Vehicle;

	public WebElement Latest_Vehicle() {
		return Latest_Vehicle;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText")
	private List<WebElement> latest_vehicle_message;

	public void latest_vehicle_message() {
		for (int i = 0; i < 5; i++) {
			Message(latest_vehicle_message.get(i).getText());
		}
	}

	// ****************************Benifits_Vehicle_Exchange************************************
	@FindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[3]")
	private WebElement Benifits;

	public WebElement Benifits() {
		return Benifits;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'RSA')]")
	private List<WebElement> goodlife_message;

	public void goodlife_message() {
		for (int i = 0; i < 3; i++) {
			Message(goodlife_message.get(i).getText());
		}
	}

}
