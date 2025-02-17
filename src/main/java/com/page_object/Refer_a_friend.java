package com.page_object;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utility.Base_Utility;

public class Refer_a_friend extends Base_Utility {

	public Refer_a_friend() {
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

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Refer a friend']")
	private WebElement refer_friend;

	public WebElement refer_friend() {
		return refer_friend;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Add Contact']")
	private WebElement add_contact;

	public WebElement add_contact() {
		return add_contact;
	}

	@FindBy(xpath = "//XCUIElementTypeImage[@name='user']")
	private List<WebElement> choose_contact;

	public List<WebElement> choose_contact() {
		return choose_contact;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Continue']")
	private WebElement continue_btn;

	public WebElement continue_btn() {
		return continue_btn;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	private WebElement Back;

	public WebElement Back() {
		return Back;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[contains(@name,' Contact')]")
	private WebElement friend_mob_no;

	public WebElement friend_mob_no() {
		return friend_mob_no;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Friend’s name']")
	private WebElement friend_name;

	public WebElement friend_name() {
		return friend_name;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Done']")
	private WebElement Done;

	public WebElement Done() {
		return Done;
	}

//************************************	Select_City **********************************
	@FindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeButton[2]")
	private WebElement Select_City;

	public WebElement Select_City() {
		return Select_City;
	}

	@FindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText")
	private List<WebElement> choose_city;

	public List<WebElement> choose_city() {
		return choose_city;
	}

//************************************	Select_Model **********************************
	@FindBy(xpath = "//XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeButton")
	private WebElement Select_Model;

	public WebElement Select_Model() {
		return Select_Model;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Practical']")
	private WebElement Practical;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Performance']")
	private WebElement Performance;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Executive']")
	private WebElement Executive;
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Scooters']")
	private WebElement Scooters;

	public void Vehicle_category() {
		try {
			Thread.sleep(2000);
			Custom_click(Performance, "Performance");
			Custom_click(Executive, "Executive");
			Custom_click(Scooters, "Scooters");
			Custom_click(Practical, "Practical");
		} catch (Exception e) {

		}
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Splendor')]")
	private WebElement Vehicle_name;

	public WebElement Vehicle_name() {
		return Vehicle_name;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Submit']")
	private WebElement Submit_button;

	public WebElement Submit_button() {
		return Submit_button;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Congrat')]")
	private WebElement message;

	public WebElement message() {
		return message;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'referral')]")
	private WebElement message_2;

	public WebElement message_2() {
		return message_2;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Refer Another Friend']")
	private WebElement refer_abother_friend;

	public WebElement refer_abother_friend() {
		return refer_abother_friend;
	}
}
