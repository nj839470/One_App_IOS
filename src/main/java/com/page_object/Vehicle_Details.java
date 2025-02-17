package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class Vehicle_Details extends Base_Utility {

	public Vehicle_Details() {
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

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'MBLH')]")
	private WebElement vehicle_number;

	public WebElement vehicle_number() {
		return vehicle_number;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Vehicle Details']")
	private WebElement Vehicle_Details;

	public WebElement Vehicle_details() {
		return Vehicle_Details;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'HA')]")
	private WebElement Engine_no;

	public WebElement Engine_no() {
		return Engine_no;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=' Goodlife']")
	private WebElement verify_GoodLife;

	public WebElement verify_GoodLife() {
		return verify_GoodLife;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Every Journey ')]")
	private WebElement verify_goodlife_page;

	public WebElement verify_goodlife_page() {
		return verify_goodlife_page;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='RSA']")
	private WebElement verify_RSA;

	public WebElement verify_RSA() {
		return verify_RSA;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Joyride']")
	private WebElement verify_joyRide;

	public WebElement verify_joyRide() {
		return verify_joyRide;
	}

//*************************************Documents *************************************

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Registration')]")
	private WebElement RC_Document;

	public WebElement RC_Document() {
		return RC_Document;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Challans')]")
	private WebElement Challans;

	public WebElement Challans() {
		return Challans;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'PUC')]")
	private WebElement PUC;

	public WebElement PUC() {
		return PUC;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Vehicle Insurance')]")
	private WebElement Vehicle_Insurance;

	public WebElement Vehicle_Insurance() {
		return Vehicle_Insurance;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='close']")
	private WebElement Document_upload_cross_btn;

	public WebElement Document_upload_cross_btn() {
		return Document_upload_cross_btn;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	private WebElement Back;

	public WebElement Back() {
		return Back;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Cancel']")
	private WebElement Cancel;

	public WebElement Cancel() {
		return Cancel;
	}

//******************************************My owners Manual *****************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Owner')]")
	private WebElement owners_manual;

	public WebElement owners_manual() {
		return owners_manual;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Owner's Manual\"]")
	private WebElement owners_title;

	public WebElement owners_title() {
		return owners_title;
	}
	// ********************** Tips and DIY videos **********************

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Tips')]")
	private WebElement Tips_and_DIY_videos;

	public WebElement Tips_and_DIY_videos() {
		return Tips_and_DIY_videos;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name='Tips'])[2]")
	private WebElement Tips_info;

	public WebElement Tips_info() {
		return Tips_info;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='DIY Videos']")
	private WebElement DIY_Videos;

	public WebElement DIY_Videos() {
		return DIY_Videos;
	}

}
