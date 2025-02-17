package com.page_object;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utility.Base_Utility;

public class Feedback_and_About_Hero extends Base_Utility {

	public Feedback_and_About_Hero() {
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

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Help & Support']")
	private WebElement help_Support;

	public WebElement help_Support() {
		return help_Support;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Feedback')]")
	private WebElement feedback;

	public WebElement feedback() {
		return feedback;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='App Related']")
	private WebElement App_Related;

	public WebElement App_Related() {
		return App_Related;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Continue']")
	private WebElement Continue_btn;

	public WebElement Continue_btn() {
		return Continue_btn;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Feedback for')]")
	private WebElement feedbackFor;

	public WebElement feedbackFor() {
		return feedbackFor;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='back']")
	private WebElement back_btn;

	public WebElement back_btn() {
		return back_btn;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	private WebElement Back_btn;

	public WebElement Back_btn() {
		return Back_btn;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sales']")
	private WebElement Sales;

	public WebElement Sales() {
		return Sales;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Service']")
	private WebElement Service;

	public WebElement Service() {
		return Service;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Parts']")
	private WebElement Parts;

	public WebElement Parts() {
		return Parts;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Goodlife']")
	private WebElement Goodlife;

	public WebElement Goodlife() {
		return Goodlife;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='Suggestions']")
	private WebElement Suggestions;

	public WebElement Suggestions() {
		return Suggestions;
	}

	// ****************** About Hero *******
	@FindBy(xpath = "//XCUIElementTypeStaticText[@name='About Hero']")
	private WebElement about_hero;

	public WebElement about_hero() {
		return about_hero;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Riding')]")
	private WebElement about_hero_message_1;

	public WebElement about_hero_message_1() {
		return about_hero_message_1;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Two')]")
	private WebElement about_hero_message_2;

	public WebElement about_hero_message_2() {
		return about_hero_message_2;
	}

	// *************** Wheels of Trust ******************
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,' Wheels')]")
	private WebElement wheels_of_trust;

	public WebElement wheels_of_trust() {
		return wheels_of_trust;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText")
	private List<WebElement> exchange_info;

	public void exchange_info() {
		for (int i = 17; i < exchange_info.size(); i++) {
			msg(exchange_info.get(i), " ");
		}
	}

	// ********************** Joyride *********************************
	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Joyride')]")
	private WebElement Joyride;

	public WebElement Joyride() {
		return Joyride;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'ce')]")
	private List<WebElement> Joyride_info;

	public void Joyride_info() {
		for (int i = 0; i < Joyride_info.size(); i++) {
			msg(Joyride_info.get(i), " ");
		}
	}
}
