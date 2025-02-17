package Page_Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.page_object.Refer_a_friend;
import com.utility.Base_Utility;
public class Refer_a_friend_test extends Base_Utility {
	public Refer_a_friend ob;
	public Login_Page_Test login;
	String device = config_getdata("Platform_name");
	String enveronment = config_getdata("env"), mobileno;

	@Test(priority = 0)
	public void TC079_Refer_a_friend() throws InterruptedException {
		Message("************************Refer a Friend**************************");
		ob = new Refer_a_friend();
//		login = new Login_Page_Test();
//		login.login();
		try {
			Custom_click(ob.home(), "Home");
			Custom_click(ob.side_menu_button(), "Side menu button");
			Custom_click(ob.refer_friend(), ob.refer_friend().getText());
			Custom_click(ob.add_contact(), "Add contact button ");
			try {
				if (ob.choose_contact().get(0).isDisplayed()) {
					Custom_click(ob.choose_contact().get(0), "Choose contact");
					Custom_click(ob.continue_btn(), "Continue Btn");
				}
			} catch (Exception e) {
				Custom_click(ob.Back(), "Back from add contact");
				custom_sendkeys(ob.friend_mob_no(), config_getdata("Friend_mob_no"), "Friend mob no");
				Custom_click(ob.Done(), "Done");
			}
			custom_sendkeys(ob.friend_name(), config_getdata("Friend_name"), "Friend name");
			Custom_click(ob.Done(), "Done");
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(priority = 1, alwaysRun = true)
	public void TC080_Verify_Select_City() {
		try {
			Custom_click(ob.Select_City(), "City ");
			int size = ob.choose_city().size();
			Custom_click(ob.choose_city().get(size - 1), ob.choose_city().get(size - 1).getText());

		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(priority = 2, alwaysRun = true)
	public void TC081_Verify_Select_Model() {
		try {
			Custom_click(ob.Select_Model(), "Select Module");
//			ob.Vehicle_category();
			Custom_click(ob.Vehicle_name(), ob.Vehicle_name().getText());

		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(priority = 3, alwaysRun = true)
	public void TC082_Verify_Submit_button() {
		try {
			if (ob.Submit_button().isEnabled())
				Custom_click(ob.Submit_button(), ob.Submit_button().getText());
			msg(ob.message(), "Success message =");
			msg(ob.message_2(), " Success message =");
			Custom_click(ob.refer_abother_friend(), "Refer another friend ");
		} catch (Exception e) {
			Message("Submit button is not clickable");
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(groups = { "Negative" }, priority = 4, alwaysRun = true)
	public void TC083_Verify_Refer_friend_Without_name() throws InterruptedException {
		try {
			Custom_click(ob.Select_Model(), "Select Module");
			Custom_click(ob.Vehicle_name(), ob.Vehicle_name().getText());
			custom_sendkeys(ob.friend_mob_no(), config_getdata("Friend_mob_no"), "Friend mob no");
			Custom_click(ob.Select_City(), "City ");
			int size = ob.choose_city().size();
			Custom_click(ob.choose_city().get(size - 1), ob.choose_city().get(size - 1).getText());
			try {
				if (ob.Submit_button().isEnabled()) {
					Message("Submit Button is tappable.");
				} else {
					Message("Submit Button is not tappable.");
					Message("please enter Friend name and fill all fields");
				}
			} catch (Exception e) {
				Message("Submit Button is not visiable" + e);
			}
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(groups = { "Negative" }, priority = 5, alwaysRun = true)
	public void TC084_Verify_Refer_friend_Without_Mobile_number() {
		try {
			custom_sendkeys(ob.friend_name(), config_getdata("Friend_name"), "Friend name");
			Delete_message(ob.friend_mob_no(), "Friend mob no ");
			try {
				if (ob.Submit_button().isEnabled()) {
					Message("Submit Button is tappable.");
				} else {
					Message("Submit Button is not tappable.");
					Message("please enter Friend mobile number and fill all fields");
				}
			} catch (Exception e) {
				Message("Submit Button is not visiable" + e);

			}
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(groups = { "Negative" }, priority = 6, alwaysRun = true)
	public void TC085_Verify_Refer_friend_With_Nine_digit_Mobile_number() {
		try {
			custom_sendkeys(ob.friend_mob_no(), config_getdata("short_digit_mobile_number"),
					" Nine DigitMobile number ");
			try {
				if (ob.Submit_button().isEnabled()) {
					Message("Submit Button is tappable.");
				} else {
					Message("Submit Button is not tappable.");
					Message("please enter 10 digit Friend mobile number and fill all fields");
				}
			} catch (Exception e) {
				Message("Submit Button is not visiable" + e);
			}
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(groups = { "Negative" }, priority = 7, alwaysRun = true)
	public void TC086_Refer_friend_without_Select_State_and_City() throws InterruptedException {
		try {
			Custom_click(ob.Back(), "Back from Refer a friend");
			Thread.sleep(2000);
			Custom_click(ob.side_menu_button(), "Side menu button");
			Custom_click(ob.refer_friend(), ob.refer_friend().getText());
			custom_sendkeys(ob.friend_name(), config_getdata("Friend_name"), "Friend name");
			custom_sendkeys(ob.friend_mob_no(), config_getdata("Friend_mob_no"), "Friend mob no");
			Custom_click(ob.Select_Model(), "Select Module");
			Custom_click(ob.Vehicle_name(), ob.Vehicle_name().getText());
			try {
				if (ob.Submit_button().isEnabled()) {
					Message("Submit Button is tappable.");
				} else {
					Message("Submit Button is not tappable.");
					Message("please Select State & City And fill all fields");
				}
			} catch (Exception e) {
				Message("Submit Button is not visiable" + e);

			}
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(groups = { "Negative" }, priority = 8, alwaysRun = true)
	public void TC087_Refer_friend_without_Select_Model() throws InterruptedException {
		try {
			Custom_click(ob.Back(), "Back from Refer a friend");
			Thread.sleep(2000);
			Custom_click(ob.side_menu_button(), "Side menu button");
			Custom_click(ob.refer_friend(), ob.refer_friend().getText());
			custom_sendkeys(ob.friend_name(), config_getdata("Friend_name"), "Friend name");
			custom_sendkeys(ob.friend_mob_no(), config_getdata("Friend_mob_no"), "Friend mob no");
			Custom_click(ob.Select_City(), "City ");
			int size = ob.choose_city().size();
			Custom_click(ob.choose_city().get(size - 1), ob.choose_city().get(size - 1).getText());
			try {
				if (ob.Submit_button().isEnabled()) {
					Message("Submit Button is tappable.");
				} else {
					Message("Submit Button is not tappable.");
					Message("please Select Vehicle Model and fill all fields");
				}
			} catch (Exception e) {
				Message("Submit Button is not visiable" + e);
			}
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		} finally {
			Custom_click(ob.Back(), "Back from Refer a friend");
		}
	}

}
