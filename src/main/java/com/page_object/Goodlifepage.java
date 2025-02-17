package com.page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base_Utility;

public class Goodlifepage extends Base_Utility {

	public Goodlifepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id/navigation') and @text='GoodLife']")
	private WebElement GoodLife;

	public WebElement goodLife() {
		return GoodLife;
	}

	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl1'])[1]")
	private WebElement goodlife_msg1;

	public WebElement goodlife_msg1() {
		return goodlife_msg1;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/plan_name']")
	private WebElement plan_name;

	public WebElement plan_name() {
		return plan_name;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/point_value']")
	private WebElement point_value;

	public WebElement point_value() {
		return point_value;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement Renew_membership;

	public WebElement Renew_membership() {
		return Renew_membership;
	}

	@FindBy(xpath = "(//android.widget.EditText[@resource-id = 'com.customerapp.hero:id/text_input_editext'])[1]")
	private WebElement Nominee_Name;

	public WebElement Nominee_Name() {
		return Nominee_Name;
	}

	@FindBy(xpath = "(//android.widget.EditText[@resource-id = 'com.customerapp.hero:id/text_input_editext'])[2]")
	private WebElement Nominee_Contact_Number;

	public WebElement Nominee_Contact_Number() {
		return Nominee_Contact_Number;
	}

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Show dropdown menu']")
	private WebElement Nominee_Relationship_with_Member;

	public WebElement Nominee_Relationship_with_Member() {
		return Nominee_Relationship_with_Member;
	}

	@FindBy(xpath = "//android.widget.CheckBox[@resource-id='com.customerapp.hero:id/nominee_address_same_as_user_check']")
	private WebElement Nominee_address_same_as_member;

	public WebElement Nominee_address_same_as_member() {
		return Nominee_address_same_as_member;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement Pay_amount;

	public WebElement Pay_amount() {
		return Pay_amount;
	}

	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id/tv')]")
	private List<WebElement> membership_plan_info;

	public void membership_plan_info() {
		for (int i = 0; i < membership_plan_info.size(); i++) {
			msg(membership_plan_info.get(i), " ");
		}
	}

	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id/benefit')]")
	private List<WebElement> plan_benifits;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.customerapp.hero:id/tv_title' and starts-with(@text,'Experience')]")
	private WebElement ex_surprise;

	public void plan_benifits() {
		for (int i = 0; i < plan_benifits.size(); i++) {
			msg(plan_benifits.get(i), " ");
			if (i == 3) {
				msg(ex_surprise, " ");
			}
		}
	}

	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.customerapp.hero:id/back_btn']")
	private WebElement back_btn;

	public WebElement back_btn() {
		return back_btn;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/down_ic_btn']")
	private WebElement Show_More;

	public WebElement Show_More() {
		return Show_More;
	}

	@FindBy(xpath = "//android.view.ViewGroup[@resource-id ='com.customerapp.hero:id/const_lay2']//android.widget.TextView")
	private List<WebElement> Membership_info;

	public void Membership_info() {
		for (int i = 0; i < Membership_info.size(); i++) {
			msg(Membership_info.get(i), " = ");
		}
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl' and starts-with(@text ,'Earning')]")
	private WebElement Earning_and_R_History;

	public WebElement Earning_and_R_History() {
		return Earning_and_R_History;
	}

	@FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Earning History']/android.widget.TextView")
	private WebElement Earning_History;

	public WebElement Earning_History() {
		return Earning_History;
	}

	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id')]")
	private List<WebElement> Earning_History_value;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/title']")
	private WebElement Earning_History_title;

	public void Earning_History_value() {
		try {
			msg(Earning_History_title, "Earning_History =");
		} catch (Exception e) {
			for (int i = 1; i < Earning_History_value.size(); i++) {
				msg(Earning_History_value.get(i), "");
			}
		}
	}

	@FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Redemption History']/android.widget.TextView")
	private WebElement Redemption_History;

	public WebElement Redemption_History() {
		return Redemption_History;
	}

	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/pleasure_txt'])[1]")
	private WebElement Complete_Profile;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/pleasure_txt'])[2]")
	private WebElement Welcome_Rewards;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/renewal_txt'])[1]")
	private WebElement Complete_Profile_benifit;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/renewal_txt'])[2]")
	private WebElement Welcome_Rewards_benifit;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/view_detail_btn'])[1]")
	private WebElement Update_Profile_btn;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/view_detail_btn'])[2]")
	private WebElement View_detail_btn;

	public WebElement Complete_Profile() {
		return Complete_Profile;
	}

	public WebElement Welcome_Rewards() {
		return Welcome_Rewards;
	}

	public WebElement Complete_Profile_benifit() {
		return Complete_Profile_benifit;
	}

	public WebElement Welcome_Rewards_benifit() {
		return Welcome_Rewards_benifit;
	}

	public WebElement Update_Profile_btn() {
		return Update_Profile_btn;
	}

	public WebElement View_detail_btn() {
		return View_detail_btn;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/offer_frnd_lbl']")
	private WebElement Referral_Offer;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/points_earning_redemption_view_detail_btn']")
	private WebElement Know_more;
	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id/lbl')]")
	private List<WebElement> Referral_all_offer;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/offer_frnd_lbl']")
	private WebElement refer_offer;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/referral_view_detail_btn']")
	private WebElement refer_btn;
	@FindBy(xpath = "//android.widget.TextView[@resource-id='com.customerapp.hero:id/termCondition']")
	private WebElement term_Condition;

	public WebElement Referral_Offer() {
		return Referral_Offer;
	}

	public WebElement refer_btn() {
		return refer_btn;
	}

	public WebElement Know_more() {
		return Know_more;
	}

	public void Referral_all_offer() {
		try {
			for (int i = 0; i < Referral_all_offer.size(); i++) {
				msg(Referral_all_offer.get(i), "");
			}
			msg(refer_offer, "Refferal offer =");
		} catch (Exception e) {
			Message("refer all offier not able to click");
		}

	}

	public WebElement term_Condition() {
		return term_Condition;
	}

	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/winner_trophy_ic']")
	private WebElement Winner_Of_The_Month;

	public WebElement Winner_Of_The_Month() {
		return Winner_Of_The_Month;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl1']")
	private WebElement winner_month;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/digital_voucher_peice']")
	private WebElement digital_voucher_info;
	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'com.customerapp.hero:id/winner')]")
	private List<WebElement> Winner_of_the_month_info;

	public void Winner_of_the_month_info() {
		msg(winner_month, "winne month =");
		for (int i = 0; i < Winner_of_the_month_info.size(); i++) {
			msg(Winner_of_the_month_info.get(i), "");
		}
		msg(digital_voucher_info, "digital voucher info =");
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl3']")
	private WebElement point_earning_message;

	public WebElement point_earning_message() {
		return point_earning_message;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/points_earning_redemption_view_detail_btn' and @text ='View Details']")
	private WebElement View_details_arrow;

	public WebElement View_details_arrow() {
		return View_details_arrow;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/points_earning_redemption_view_detail_btn']")
	private List<WebElement> points_earning_redemption_view_detail;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl19']")
	private WebElement Tier3_message;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl13']")
	private WebElement Tier3_distance;
	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id/lbl')]")
	private List<WebElement> point_earn_condition;
	@FindBy(xpath = "//android.widget.TextView[@resource-id = 'com.customerapp.hero:id/lbl3']")
	private List<WebElement> Tier3_distance_message;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/thats_not_end_lbl1']")
	private WebElement point_earning_end_message;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/back_btn']")
	private WebElement back_button;

	public void points_earning_redemption_view_detail() {
		for (int i = 0; i < points_earning_redemption_view_detail.size(); i++) {
			String name = points_earning_redemption_view_detail.get(i).getText();
			if (name.equalsIgnoreCase("View Details")) {
				Custom_click(points_earning_redemption_view_detail.get(i), "points earning redemption" + name);
			}
		}
	}

	public WebElement Tier3_message() {
		return Tier3_message;
	}

	public void point_earn_condition() {
		try {
			for (int i = 0; i < point_earn_condition.size() - 1; i++) {
				if (i < 3) {
					msg(point_earn_condition.get(i), "");
				} else if (i >= 3 && i <= 12) {
					msg(point_earn_condition.get(i), "" + " = " + point_earn_condition.get(i + 1).getText());
					i++;
				} else if (i == 13) {
					msg(point_earn_condition.get(i), "");
				} else if (i >= 14 && i <= 24) {
					Message(point_earn_condition.get(i).getText() + " = " + point_earn_condition.get(i + 1).getText());
					i++;
				} else {
					break;
				}
			}
		} catch (Exception e) {
			Message("" + e);
		}
	}

	public void Tier3_distance_message() {
		int size = Tier3_distance_message.size();
		Message(Tier3_distance.getText() + " = " + Tier3_distance_message.get(size - 1).getText());
	}

	public WebElement point_earning_end_message() {
		return point_earning_end_message;
	}

	// ******************************show_more_service_privilegers*******************************
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/down_ic_btn'])[1]")
	private WebElement show_more_service_privilegers;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/benefit_lbl']")
	private List<WebElement> service_previleges_all_message;

	public WebElement show_more_service_privilegers() {
		return show_more_service_privilegers;
	}

	public void service_previleges_all_message() {
		for (int i = 0; i < 4; i++) {
			Message(service_previleges_all_message.get(i).getText());
		}
	}

	// ******************************Benefits and
	// Experiences****************************
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/down_ic_btn'])[2]")
	private WebElement show_more_Benefits_and_Experiences;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/benefit_lbl']")
	private List<WebElement> Benefits_message;

	public WebElement show_more_Benefits_and_Experiences() {
		return show_more_Benefits_and_Experiences;
	}

	public void Benefits_message() {
		for (int i = 2; i < Benefits_message.size(); i++) {
			Message(Benefits_message.get(i).getText());
		}
	}

}
