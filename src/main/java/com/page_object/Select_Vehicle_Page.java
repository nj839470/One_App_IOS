package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.utility.Base_Utility;

public class Select_Vehicle_Page extends Base_Utility {

	char Vehicle_count;

	public Select_Vehicle_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//XCUIElementTypeButton[@name])[1]")
	private WebElement edit_nickame_button;

	public WebElement edit_nickame_button() {
		return edit_nickame_button;
	}

	@FindBy(xpath = "//XCUIElementTypeTextField[@name=' Enter Nickname']")
	private WebElement edit_nickame_text;

	public WebElement edit_nickame_text() {
		return edit_nickame_text;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[@name])[6]")
	private WebElement Nick_name;

	public WebElement Nick_name() {
		return Nick_name;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Save']")
	private WebElement save_button;

	public WebElement save_button() {
		return save_button;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Continue']")
	private WebElement continue_button;

	public WebElement continue_button() {
		return continue_button;
	}

	@FindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'Primary')])[1]")
	private WebElement click_first_vehicle;

	public WebElement click_first_vehicle() {
		return click_first_vehicle;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'We found')]")
	private WebElement vehicle_info;

	public void vehicle_count() {
		String vehicle_mess = vehicle_info.getText();
		Message(vehicle_mess);
		char vehicle[] = vehicle_mess.toCharArray();
		for (int i = 0; i < vehicle.length; i++) {
			if (Character.isDigit(vehicle[i])) {
				Vehicle_count = vehicle[i];
			}
		}
		Message("Total number of Vehicles registered in this number is = " + Vehicle_count);
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='close']")
	private WebElement nick_name_close_button;

	public WebElement nick_name_close_button() {
		return nick_name_close_button;
	}

	@FindBy(xpath = "(//XCUIElementTypeButton[contains(@name,'Allow')])[1]")
	private WebElement Allow;

	public WebElement Allow() {
		return Allow;
	}

	@FindBy(xpath = "//*[@name='Done']")
	private WebElement done;

	public WebElement done() {
		return done;
	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name=' Proceed ']")
	private WebElement Processed;

	public WebElement Processed() {
		return Processed;
	}

}
