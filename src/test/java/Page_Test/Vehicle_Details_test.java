package Page_Test;

import org.testng.annotations.Test;
import com.page_object.Vehicle_Details;
import com.utility.Base_Utility;

public class Vehicle_Details_test extends Base_Utility {
	public Vehicle_Details ob;
	public Login_Page_Test login;

	@Test(priority = 0)
	public void TC049_Verify_My_Vehicle() throws InterruptedException {
		Message("*********************My Vehicle page**************************");
		ob = new Vehicle_Details();
//		login = new Login_Page_Test();
//		login.login();
		Thread.sleep(5000);
		Custom_click(ob.home(), "Home");
		Custom_click(ob.side_menu_button(), "Side menu button");
		msg(ob.vehicle_number(), "Vehicle number = ");
		Custom_click(ob.Vehicle_details(), "Vehicle Details");
		Thread.sleep(5000);
		msg(ob.Engine_no(), "Engine_no = ");
	}

	@Test(priority = 1)
	public void TC050_Verify_My_Vehicle_Documents() throws InterruptedException {
		Scroll_down_page_Action("Vehicle Document");
		Custom_click(ob.Vehicle_Insurance(), "Vehicle Insurance ");
		Thread.sleep(2000);
		Custom_click(ob.Document_upload_cross_btn(), " Close my vehicle Insurance upload page");
		Custom_click(ob.RC_Document(), "R.C ");
		Thread.sleep(2000);
		Custom_click(ob.Back(), " Back from RC page");
		Custom_click(ob.Challans(), "Challans ");
		Thread.sleep(2000);
		Custom_click(ob.Cancel(), " Cancel Digilocker");
		Custom_click(ob.PUC(), "PUC ");
		Thread.sleep(2000);
		try {
			if (ob.Document_upload_cross_btn().isDisplayed())
				Custom_click(ob.Document_upload_cross_btn(), " Close my PUC document upload page");
		} catch (Exception e) {
			Message("Already PUC is Uploaded");
		}
	}

	@Test(priority = 2)
	public void TC051_Verify_My_Vehicle_Subscriptions_details() {
		Custom_click(ob.verify_GoodLife(), " Verify Good Life");
		msg(ob.verify_goodlife_page(), "verify goodlife page = ");
		Custom_click(ob.Back(), " Back from GoodLife page");
		Custom_click(ob.verify_RSA(), " Verify RSA ");
		Custom_click(ob.Back(), " Back from RSA page");
		Scroll_down_page_Action("JoyRide");
		Custom_click(ob.verify_joyRide(), " Verify JoyRide ");
		Custom_click(ob.Back(), " Back from joyRide page");

	}

	@Test(priority = 3)
	public void TC052_Verify_Owners_Manual() {
		Custom_click(ob.owners_manual(), "Owners manual");
		try {
			if (ob.owners_title().isDisplayed()) {
				msg(ob.owners_title(), "My Vehicle Owners manual = ");
				Custom_click(ob.Back(), " Back from Owners manual page");
				Custom_click(ob.Back(), " Back from My Vehicle page");
			}
		} catch (Exception e) {
			Message("Owner details already given");
			Custom_click(ob.Back(), " Back from Owners manual page");
			Custom_click(ob.Back(), " Back from My Vehicle page");
		}
	}

	@Test(priority = 4)
	public void TC053_Verify_Tips_and_DIY_videos_inside_sideMenu() throws InterruptedException {
		Custom_click(ob.side_menu_button(), "Side menu button");
		Custom_click(ob.Tips_and_DIY_videos(), ob.Tips_and_DIY_videos().getText());
		Custom_click(ob.Tips_info(), ob.Tips_info().getText());
		Custom_click(ob.DIY_Videos(), ob.DIY_Videos().getText());
		Custom_click(ob.Back(), " Back from My Tips page");
	}
}
