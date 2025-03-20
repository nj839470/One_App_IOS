package Page_Test;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.page_object.Home_Page;
import com.utility.Base_Utility;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

@Listeners(com.utility.listner.class)
public class Home_Page_Test extends Base_Utility {

	public Login_Page_Test login;
	public Home_Page ob;
	String device = config_getdata("Platform_name");

	@Test(priority = 0)
	public void TC019_Home_page_verify() throws InterruptedException {
		Message("*********Home_Page_Test*********");
		ob = new Home_Page();
		login = new Login_Page_Test();
		login.login();
		try {
			Thread.sleep(3000);
			VerifyElementPresent(ob.vehicle_img(), "Vehicle Img is");
			Thread.sleep(2000);
			ob.all_vehicle_inside_drop_down();
			try {
				if (ob.Collapse_btn().isDisplayed()) {
					Custom_click(ob.Collapse_btn(), ob.Collapse_btn().getText());
					Thread.sleep(2000);
					Custom_click(ob.Collapse_btn(), ob.Collapse_btn().getText());
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				Scroll_down_page_Action("Collapse button");
				Custom_click(ob.Collapse_btn(), ob.Collapse_btn().getText());
				Thread.sleep(2000);
				Custom_click(ob.Collapse_btn(), ob.Collapse_btn().getText());
				Thread.sleep(2000);
			}
			Custom_click(ob.notification(), "Notification");
			ob.notification_count();

		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		} finally {
			Custom_click(ob.notification_back(), "Notification back");
		}
	}

	@Test(priority = 1)
	public void TC020_verify_SOS() throws InterruptedException {
		try {
			Custom_click(ob.SOS_icon(), "SOS icon");
			msg(ob.SOS_message(), "Alert message = ");
			Custom_click(ob.sent_alert_btn(), ob.sent_alert_btn().getText());
			Thread.sleep(2000);
			Custom_click(ob.SOS_icon(), "SOS icon");
			ob.dont_send();
			Thread.sleep(2000);
			Custom_click(ob.SOS_icon(), "SOS icon");
			Custom_click(ob.SOS_close_btn(), "SOS close button");
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(priority = 2)
	public void TC021_verify_Navigate() {
		try {
			Custom_click(ob.Navigate_menu(), "Navigate menu");
			Custom_click(ob.Search_destination(), "Search destination");
			custom_sendkeys(ob.Search_here(), " railway", "Place name");
			Custom_click(ob.chose_place_name(), "Choose Place name");
			Custom_click(ob.Navigate_button(), " Navigate ");
			Custom_click(ob.Start(), "Start button");
			try {
				Custom_click(ob.stop_navigation(), " Stop navigation");
			} catch (Exception e) {
				Message("Sorry Route not found");
			}
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		} finally {
			Custom_click(ob.Back_Start_Navigation(), "Back from Start navigate page");
			Custom_click(ob.Back(), "Back from Navigation page");
		}

	}

	@Test(priority = 3)
	public void TC022_verify_Exchange() throws InterruptedException {
		try {
			Custom_click(ob.Exchange_Menu(), "Exchange menu");
			Thread.sleep(2000);
			ob.exchange_info();
			Custom_click(ob.Exchange_vehicle_name(), ob.Exchange_vehicle_name().getText());
			Thread.sleep(2000);
			msg(ob.real_value_msg(), "Exchange info =");
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "TC022_verify_Exchange()", priority = 4)
	public void TC023_verify_Vehicle_details() {
		try {
			msg(ob.choose_city(), "City = ");
			custom_sendkeys(ob.city_sell(), config_getdata("City_to_sell_vehicle"), "City name where sell vehicle");
			Custom_click(ob.choose_city_sell(), ob.choose_city_sell().getText());
			custom_sendkeys(ob.city_pin_code(), "110037", "PIN code");
			Custom_click(ob.done(), " Done ");
			Custom_click(ob.next_btn(), ob.next_btn().getText());
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "TC022_verify_Exchange()", priority = 5)
	public void TC024_verify_Vehicle_condition() {
		try {
			msg(ob.vehicle_condition(), "");
			msg(ob.condition_msg(), "");
			ob.all_question();
			Custom_click(ob.next_btn(), ob.next_btn().getText());
		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		}
	}

	@Test(dependsOnMethods = "TC022_verify_Exchange()", priority = 6)
	public void TC025_verify_Vehicle_valution() throws InterruptedException {
		try {
			ob.exchange_info();
			Thread.sleep(2000);

		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		} finally {
			Custom_click(ob.back(), "Back from estimated resell value page");
			Thread.sleep(2000);
			Custom_click(ob.Back(), "Back from Exchange page");
		}
	}

	@Test(priority = 7)
	public void TC026_Verify_RC_Documents() throws InterruptedException {

		Custom_click(ob.Documents_Menu(), "Document menu");
		Thread.sleep(2000);
		String Do_name = ob.RC_document().getText();
		Message("Document first = " + Do_name);
		String status = ob.document_Status().get(1).getText();
		if (status.equalsIgnoreCase("Upload")) {
			Custom_click(ob.document_Status().get(1), Do_name + " " + status);
			Thread.sleep(2000);
			Custom_click(ob.Choose_Document_from_library(), Do_name + " " + "Choose from library");
			Custom_click(ob.cancel_library(), "Cancel Library");
			Thread.sleep(2000);
			Custom_click(ob.document_Status().get(1), Do_name + status);
			Thread.sleep(2000);
			Custom_click(ob.Take_a_Photo(), "Take a Photo");
			Custom_click(ob.cancel_library(), "Cancel Library");
			Thread.sleep(2000);
			Custom_click(ob.document_Status().get(1), Do_name + status);
			Thread.sleep(2000);
			Custom_click(ob.Choose_from_Digilocker(), Do_name + "Choose from Digilocker");
			Thread.sleep(2000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.document_Status().get(1), Do_name + status);
			Thread.sleep(2000);
			Custom_click(ob.document_upload_close_button(), "Close upload document page");
		} else if (status.equalsIgnoreCase("View File")) {
			Message(Do_name + " is already available");
			Custom_click(ob.document_Status().get(1), Do_name + status);
			Thread.sleep(2000);
			Custom_click(ob.share_document(), "Share document button");
			Thread.sleep(2000);
			Custom_click(ob.cancel_Background(), "Cancel Background ");
			try {
				if (ob.download_document().isDisplayed()) {
					Custom_click(ob.download_document(), "Download document button");
				}
			} catch (Exception e) {
				Custom_click(ob.cancel_Background(), "Cancel Background ");
				Thread.sleep(2000);
				Custom_click(ob.download_document(), "Download document button");
			}
			Custom_click(ob.update_doc(), "Update document button");
			Thread.sleep(2000);
			Custom_click(ob.Choose_Document_from_library(), Do_name + " Choose from library");
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.update_doc(), "Update document button");
			Thread.sleep(2000);
			Custom_click(ob.Take_a_Photo(), "Take a Photo");
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.update_doc(), "Update document button");
			Custom_click(ob.Choose_from_Digilocker(), "Choose from Digilocker");
			Thread.sleep(3000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.update_doc(), "Update document button");
			Custom_click(ob.document_upload_close_button(), "Close upload document page");
			Custom_click(ob.Back(), "Back from " + Do_name + " page");

		} else {
			System.out.println("Not able to read" + status);
		}

	}

	@Test(priority = 8)
	public void TC027_Verify_Insurance_Documents() throws InterruptedException {
		String Do_name = ob.Insurance_document().getText();
		Message("Document Second = " + Do_name);
		String status = ob.document_Status().get(2).getText();
		if (status.equalsIgnoreCase("Upload")) {
			Custom_click(ob.document_Status().get(2), Do_name + " " + status);
			Thread.sleep(2000);
			Custom_click(ob.Choose_Document_from_library(), Do_name + " " + "Choose from library");
			Thread.sleep(2000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.document_Status().get(2), Do_name + " " + status);
			Thread.sleep(2000);
			Custom_click(ob.Take_a_Photo(), "Take a Photo");
			Thread.sleep(2000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Thread.sleep(2000);
			Custom_click(ob.document_Status().get(2), Do_name + " " + status);
			Thread.sleep(2000);
			Custom_click(ob.Choose_from_Digilocker(), Do_name + " " + "Choose from Digilocker");
			Thread.sleep(2000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Thread.sleep(2000);
			Custom_click(ob.document_Status().get(2), Do_name + " " + status);
			Custom_click(ob.document_upload_close_button(), "Close upload document page");
		} else if (status.equalsIgnoreCase("View File")) {
			Message(Do_name + " is already available");
			Custom_click(ob.document_Status().get(2), Do_name + status);
			Thread.sleep(2000);
			Custom_click(ob.share_document(), "Share document button");
			Thread.sleep(2000);
			Custom_click(ob.cancel_Background(), "Cancel Background ");
			try {
				if (ob.download_document().isDisplayed()) {
					Custom_click(ob.download_document(), "Download document button");
					Thread.sleep(5000);
				}
			} catch (Exception e) {
				Custom_click(ob.cancel_Background(), "Cancel Background ");
				Thread.sleep(2000);
				Custom_click(ob.download_document(), "Download document button");
			}
			Custom_click(ob.update_doc(), "Update document button");
			Thread.sleep(2000);
			Custom_click(ob.Choose_Document_from_library(), Do_name + " Choose from library");
			Thread.sleep(3000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.update_doc(), "Update document button");
			Thread.sleep(2000);
			Custom_click(ob.Take_a_Photo(), "Take a Photo");
			Thread.sleep(2000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.update_doc(), "Update document button");
			Custom_click(ob.Choose_from_Digilocker(), "Choose from Digilocker");
			Thread.sleep(3000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.update_doc(), "Update document button");
			Custom_click(ob.document_upload_close_button(), "Close upload document page");
			Custom_click(ob.Back(), "Back from " + Do_name + " page");

		} else {
			System.out.println("Not able to read" + status);
		}
	}

	@Test(priority = 9)
	public void TC028_Verify_PUC_Documents() throws InterruptedException {
		String Do_name = ob.PUC_document().getText();
		Message("Document Third = " + Do_name);
		String status = ob.document_Status().get(3).getText();
		if (status.equalsIgnoreCase("Upload")) {
			Custom_click(ob.document_Status().get(3), Do_name + " " + status);
			Thread.sleep(2000);
			Custom_click(ob.Choose_Document_from_library(), Do_name + " " + "Choose from library");
			Thread.sleep(2000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.document_Status().get(3), Do_name + " " + status);
			Thread.sleep(2000);
			Custom_click(ob.Take_a_Photo(), "Take a Photo");
			Thread.sleep(3000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Thread.sleep(2000);
			Custom_click(ob.document_Status().get(3), Do_name + " " + status);
			Thread.sleep(2000);
			Custom_click(ob.document_upload_close_button(), "Close upload document page");
		} else if (status.equalsIgnoreCase("View File")) {
			Message(Do_name + " is already available");
			Custom_click(ob.document_Status().get(3), Do_name + " " + status);
			Thread.sleep(2000);
			Custom_click(ob.share_document(), "Share document button");
			Thread.sleep(2000);
			Custom_click(ob.cancel_Background(), "Cancel Background ");
			try {
				if (ob.download_document().isDisplayed()) {
					Custom_click(ob.download_document(), "Download document button");
					Thread.sleep(5000);
				}
			} catch (Exception e) {
				Custom_click(ob.cancel_Background(), "Cancel Background ");
				Thread.sleep(2000);
				Custom_click(ob.download_document(), "Download document button");

			}
			Custom_click(ob.update_doc(), "Update document button");
			Thread.sleep(2000);
			Custom_click(ob.Choose_Document_from_library(), Do_name + " Choose from library");
			Thread.sleep(3000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.update_doc(), "Update document button");
			Thread.sleep(2000);
			Custom_click(ob.Take_a_Photo(), "Take a Photo");
			Thread.sleep(3000);
			Custom_click(ob.cancel_library(), "Cancel Library");
			Custom_click(ob.update_doc(), "Update document button");
			Custom_click(ob.document_upload_close_button(), "Close upload document page");
			Custom_click(ob.Back(), "Back from " + Do_name + " page");

		} else

		{
			System.out.println("Not able to read" + status);
		}
	}

	@Test(priority = 10)
	public void TC029_Verify_Challans_Documents() throws InterruptedException {
		String Do_name = ob.Challans_document().getText();
		Message("Document fourth =" + Do_name);
		String status = ob.document_Status().get(4).getText();
		Custom_click(ob.document_Status().get(4), status);
		Thread.sleep(2000);
		Custom_click(ob.cancel_library(), "Cancel Library");
		Custom_click(ob.Back(), "Back from Documents");
	}

	@Test(priority = 11)
	public void TC030_Verify_Relationship_Manager() throws InterruptedException {
		Thread.sleep(2000);
		Custom_click(ob.Relationship_Manager(), "Relationship Manager");
		Thread.sleep(2000);
		ob.Relationship_manager_info();
		Custom_click(ob.Back(), "Back from Relationship Manager");

	}

	@Test(priority = 12)
	public void TC031_Verify_RSA() throws InterruptedException {
		Custom_click(ob.RSA(), "RSA");
		Thread.sleep(4000);
		ob.RSA_info();
	}

	@Test(priority = 13)
	public void TC032_Renew_RSA() throws InterruptedException {
		Custom_click(ob.renew_rsa(), ob.renew_rsa().getText());
		Thread.sleep(2000);
		ob.RSA_info();
		try {
			msg(ob.registration_number(), "Registraction number = ");
		} catch (Exception e) {
			Message("Registraction number  is not given");
		}
		Thread.sleep(1000);
		Custom_click(ob.Back(), "Back from Payment");
		Thread.sleep(1000);
	}

	@Test(priority = 14)
	public void TC033_frequently_asked_questions() throws InterruptedException {
		Scroll_down_page_Action("Step 2 ");
		Scroll_down_page_Action("Asked question ");
		Custom_click(ob.asked_questions_1(), ob.asked_questions_1().getText());
		msg(ob.answer_1(), "Answer = ");
		Custom_click(ob.asked_questions_2(), ob.asked_questions_2().getText());
		msg(ob.answer_2(), "Answer = ");
		Custom_click(ob.Back(), "Back from Roadside Assistance");
	}

	@Test(priority = 15)
	public void TC034_Verify_Technical_Support_Manager() throws InterruptedException {
		Custom_click(ob.Technical_Support(), "Technical Support");
		Thread.sleep(2000);
		try {
			if (ob.no_data_found().isDisplayed()) {
				Message("" + ob.no_data_found().getText());
			}
		} catch (Exception e) {
			Message("Technical support manager info is visible");
			ob.technicalManagerInfo();
		} finally {
			Custom_click(ob.Back(), "Back from Technical Support Manager");
		}
	}

	@Test(priority = 16)
	public void TC035_Verify_Dealer_Locator() throws InterruptedException {

		Custom_click(ob.Dealer_Locator(), "Dealer Locator");
		Thread.sleep(2000);
	}

//	@Test(priority = 17)
	public void TC036_Select_city() {
		Custom_click(ob.Select_City(), "Select city");
		Custom_click(ob.Select_State_list(), ob.Select_State_list().getText());
	}

	@Test(priority = 18)
	public void TC037_View_dealer_name_and_address() {
		Custom_click(ob.map_view(), "Map View dealer name and address");
		ob.Dealer_info();
		Custom_click(ob.Back(), "Back from Dealer Locator");
	}

	@SuppressWarnings("deprecation")
	@Test(priority = 19)
	public void TC038_verify_Service_at_home_page() throws InterruptedException {
		Scroll_down_page_Action("Last Serviced");
		msg(ob.service_due(), " ");
		msg(ob.due_data(), " due date = ");
	}

	@Test(priority = 20)
	public void TC039_Helmets_in_PAM() throws InterruptedException {
		try {
			Scroll_down_page_Action("Helmets");
//			Scroll_down_page_Action("Helmets");
			Custom_click(ob.Helmets(), "Helemets ");
			Thread.sleep(1000);
			msg(ob.Helemet_name(), " Helmets name  ");
			String name = ob.Helemet_name().getText();
			msg(ob.Helemet_price(), "Helemets price  ");
			Custom_click(ob.Helemet_name(), " Open helemets details  ");
			Thread.sleep(7000);
			try {
				if (ob.allow_location().isDisplayed()) {
					Custom_click(ob.allow_location(), " All location to be use ");
					Custom_click(ob.add_Location(), ob.add_Location().getText());
					Custom_click(ob.confirm_location(), "Confirm location");
				}
			} catch (Exception e) {
				Message("No location is given" + e.getMessage());
			}
			Thread.sleep(3000);
			Custom_click(ob.plane_header(), " Plane Header");
			try {
				if (ob.mobile_header().isDisplayed()) {
					Custom_click(ob.mobile_header(), "Mobile header ");
					msg(ob.Signed_msg(), "");
					msg(ob.Signed_contact_number(), "Signed contact number ");
					Custom_click(ob.close_icon(), "Close icon for signed page ");
				}
			} catch (Exception e) {
				if (Base_Utility.lis != null) {
					Base_Utility.lis.get_Screen_shot(name);
					test.log(Status.FAIL, name + "= Unable to Click = "
							+ test.addScreenCaptureFromPath(Base_Utility.lis.getcapcture(name)));
				} else {
					test.log(Status.FAIL, name + "= Unable to capture screenshot, 'lis' is null.");
				}
				test.log(Status.FAIL, e);
				log.error(name + " is not clickable: " + e.getMessage());
			}

		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		} finally {
			Custom_click(ob.Back(), "back from " + "Helmets");
		}
	}

	@Test(priority = 21)
	public void TC040_Lubricant_in_PAM() throws InterruptedException {
		try {
			Custom_click(ob.Lubricant(), "Lubricant ");
			Thread.sleep(1000);
			msg(ob.Lubricant_name(), " Lubricant name  ");
			String name = ob.Lubricant_name().getText();
			msg(ob.Helemet_price(), "Lubricant price  ");
			Custom_click(ob.Lubricant_name(), " Open Lubricant details  ");
			Thread.sleep(6000);
			try {
				if (ob.plane_header().isDisplayed())
					Custom_click(ob.plane_header(), " Plane Header");
			} catch (Exception e) {
				Message("Please enable location firstly ");
			}

			try {
				if (ob.mobile_header().isDisplayed()) {
					Custom_click(ob.mobile_header(), "Mobile header ");
					msg(ob.Signed_msg(), "");
					msg(ob.Signed_contact_number(), "Signed contact number  ");
					Custom_click(ob.close_icon(), "Close icon for signed page ");
				}
			} catch (Exception e) {
				Base_Utility.lis.get_Screen_shot(name);
				test.log(Status.FAIL, e);
				log.error(name + " is not clickable: " + e.getMessage());
			}

		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		} finally {
			Custom_click(ob.Back(), "back from " + "Lubricant");
		}
	}

	@Test(priority = 22)
	public void TC041_Merchandise_in_PAM() throws InterruptedException {
		try {
			Custom_click(ob.Merchandise(), "Merchandise ");
			Thread.sleep(1000);
			msg(ob.Merchandise_name(), " Merchandise name  ");
			String name = ob.Merchandise_name().getText();
			msg(ob.Helemet_price(), "Merchandise price ");
			Custom_click(ob.Merchandise_name(), " Open Merchandise details ");
			Thread.sleep(5000);
			Custom_click(ob.plane_header(), " Plane Header");
			try {
				if (ob.mobile_header().isDisplayed()) {
					Custom_click(ob.mobile_header(), "Mobile header ");
					msg(ob.Signed_msg(), "");
					msg(ob.Signed_contact_number(), "Signed contact number ");
					Custom_click(ob.close_icon(), "Close icon for signed page ");
				}
			} catch (Exception e) {
				if (Base_Utility.lis != null) {
					Base_Utility.lis.get_Screen_shot(name);
					test.log(Status.FAIL, name + "= Unable to Click = "
							+ test.addScreenCaptureFromPath(Base_Utility.lis.getcapcture(name)));
				} else {
					test.log(Status.FAIL, name + "= Unable to capture screenshot, 'lis' is null.");
				}
				test.log(Status.FAIL, e);
				log.error(name + " is not clickable: " + e.getMessage());
			}

		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());

		} finally {
			Custom_click(ob.Back(), "back from " + "Merchandise");
		}
	}

	@Test(priority = 23)
	public void TC042_Accessories_in_PAM() throws InterruptedException {
		try {
			Custom_click(ob.Accessories(), "Accessories ");
			Thread.sleep(1000);
			msg(ob.Accessories_name(), " Accessories name ");
			String name = ob.Accessories_name().getText();
			msg(ob.Helemet_price(), "Accessories price  ");
			Custom_click(ob.Accessories_name(), " Open Accessories details ");
			Thread.sleep(6000);
			Custom_click(ob.plane_header(), " Plane Header");
			try {
				if (ob.mobile_header().isDisplayed()) {
					Custom_click(ob.mobile_header(), "Mobile header ");
					msg(ob.Signed_msg(), "");
					msg(ob.Signed_contact_number(), "Signed contact number ");
					Custom_click(ob.close_icon(), "Close icon for signed page ");
				}
			} catch (

			Exception e) {
				if (Base_Utility.lis != null) {
					Base_Utility.lis.get_Screen_shot(name);
					test.log(Status.FAIL, name + "= Unable to Click = "
							+ test.addScreenCaptureFromPath(Base_Utility.lis.getcapcture(name)));
				} else {
					test.log(Status.FAIL, name + "= Unable to capture screenshot, 'lis' is null.");
				}
				test.log(Status.FAIL, e);
				log.error(name + " is not clickable: " + e.getMessage());
			}

		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		} finally {
			Custom_click(ob.Back(), "back from " + "Accessories");

		}
	}

	@Test(priority = 24)
	public void TC043_View_All_Accessories_in_PAM() throws InterruptedException {
		try {
			Custom_click(ob.viewAll(), "View all ");
			Custom_click(ob.plane_header(), " Plane Header");
			try {
				if (ob.mobile_header().isDisplayed()) {
					Custom_click(ob.mobile_header(), "Mobile header ");
					msg(ob.Signed_msg(), "");
					msg(ob.Signed_contact_number(), "Signed contact number ");
					Custom_click(ob.close_icon(), "Close icon for signed page ");
				}
			} catch (

			Exception e) {
				if (Base_Utility.lis != null) {
					Base_Utility.lis.get_Screen_shot("All Assessories");
					test.log(Status.FAIL, "All Assessories" + "= Unable to Click = "
							+ test.addScreenCaptureFromPath(Base_Utility.lis.getcapcture("All Assessories")));
				} else {
					test.log(Status.FAIL, "All Assessories" + "= Unable to capture screenshot, 'lis' is null.");
				}
				test.log(Status.FAIL, e);
				log.error("All Assessories" + " is not clickable: " + e.getMessage());
			}

		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		} finally {
			Custom_click(ob.Back(), "Back from View_All_Accessories ");
		}
	}

	@Test(priority = 25)
	public void TC044_verify_Check_Out_at_home_page() throws InterruptedException {
		try {
			Scroll_down_page_Action("Check Out");
			Custom_click(ob.Latest_Vehicle(), "Check Out");
			Thread.sleep(2000);
			ob.latest_vehicle_message();

		} catch (Exception e) {
			Assert.fail("Test interrupted: " + e.getMessage());
		} finally {
			Custom_click(ob.Back(), "Back from Check out Vehicle page ");
		}
	}

	@Test(priority = 26)
	public void TC045_verify_Benifits_Vehicle_Exchange() throws InterruptedException {
		try {
			if (ob.Benifits().isDisplayed()) {
				Custom_click(ob.Benifits(), "Benifits ");
				Thread.sleep(5000);
				ob.goodlife_message();
			}
		} catch (Exception e) {
			Message("Benifit is not visible" + e);
			Assert.fail("Test interrupted: " + e.getMessage());
		} finally {
			Custom_click(ob.Back(), " Back from Gift RSA page");
		}
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence scroll = new Sequence(finger, 0);
		scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 502, 300));
		scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), 502, 2013));
		scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singletonList(scroll));

	}
}