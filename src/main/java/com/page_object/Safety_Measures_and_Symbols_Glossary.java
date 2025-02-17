package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class Safety_Measures_and_Symbols_Glossary extends Base_Utility {

	public Safety_Measures_and_Symbols_Glossary() {
		PageFactory.initElements(driver, this);
	}

//************************************Safety Measures**************************

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Home']")
	private WebElement Home;

	public WebElement Home() {
		return Home;
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

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Safety')]")
	private WebElement Safety_Measures;

	public WebElement Safety_Measures() {
		return Safety_Measures;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Stay Safe')]")
	private WebElement Safety_message;

	public WebElement Safety_message() {
		return Safety_message;

	}

	@FindBy(xpath = "//XCUIElementTypeButton[@name='Back']")
	private WebElement back_button;

	public WebElement back_button() {
		return back_button;
	}

//************************************Symbols Glossary**************************

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Symbols')]")
	private WebElement Symbols_Glossary;

	public WebElement Symbols_Glossary() {
		return Symbols_Glossary;
	}

	@FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'Turn')]")
	private List<WebElement> Symbols_Glossary_message;

	public void Symbols_Glossary_message() {
		try {
			for (int i = 0, j = 0; i < Symbols_Glossary_message.size(); i++) {
				msg(Symbols_Glossary_message.get(i), "");
			}
		} catch (Exception e) {
			
		}
	}
}
