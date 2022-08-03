package com.adactin.stepdefinition;


import com.Sdp.Page_Object_Manager;
import com.adactin.baseclass.Base_Class;
import com.adactin.properties.File_Reader_Manager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step_Definition extends Base_Class{
	
	public static Page_Object_Manager pom = new Page_Object_Manager(driver);
	
	//Launch Url
	@Given("^user Launch The Url In Adactin Application$")
	public void user_Launch_The_Url_In_Adactin_Application() throws Throwable {
		String url = File_Reader_Manager.getInstance().getInstanceCR().getUrl();
		driver = launchurl(url);
	}

	//Login Hotel
	@When("^user Enter The Username In Username Field$")
	public void user_Enter_The_Username_In_Username_Field() throws Throwable {
		sendValues(pom.getLp().getUsername(), "saravananrk");
	}

	@When("^user Enter The Password In Password Field$")
	public void user_Enter_The_Password_In_Password_Field() throws Throwable {
		sendValues(pom.getLp().getPassword(), "saran@123");
	}
	
	/*@When("^user Enter The \"([^\"]*)\" In Username Field$")
	public void user_Enter_The_In_Username_Field(String username) throws Throwable {
		sendValues(pom.getLp().getUsername(), username);
	}

	@When("^user Enter The \"([^\"]*)\" In Password Field$")
	public void user_Enter_The_In_Password_Field(String password) throws Throwable {
		sendValues(pom.getLp().getPassword(), password);
	}*/

	@Then("^user Click On The Login Button To Search Hotel Page$")
	public void user_Click_On_The_Login_Button_To_Search_Hotel_Page() throws Throwable {
		clickable(pom.getLp().getLogin());
	}
	
	
	//Search a Hotel
	@When("^user Select The Location Of A Hotel$")
	public void user_Select_The_Location_Of_A_Hotel() throws Throwable {
		selectbyvalue(pom.getSh().getLocation(), "London");
	}

	@When("^user Select The Name Of A Hotel At Selected Location$")
	public void user_Select_The_Name_Of_A_Hotel_At_Selected_Location() throws Throwable {
		selectbyindex(pom.getSh().getHotels(), 2);
	}

	@When("^user Select The Type Of A Hotel Room In Selected Hotel$")
	public void user_Select_The_Type_Of_A_Hotel_Room_In_Selected_Hotel() throws Throwable {
		selectbyindex(pom.getSh().getRoom_type(), 2);  
	}

	@When("^user Select Number Of Rooms In Selected Hotel Room$")
	public void user_Select_Number_Of_Rooms_In_Selected_Hotel_Room() throws Throwable {
		selectbyindex(pom.getSh().getRoom_nos(), 2);
	}

	@When("^user Enter Date Of Checkin In Date Field In A Format Of DD/MM/YYYY$")
	public void user_Enter_Date_Of_Checkin_In_Date_Field_In_A_Format_Of_DD_MM_YYYY() throws Throwable {
		clearsendkeys(pom.getSh().getDatepick_in(), "20/07/22");
	}

	@When("^user Enter Date Of Checkout In Date Field In A Format Of DD/MM/YYYY$")
	public void user_Enter_Date_Of_Checkout_In_Date_Field_In_A_Format_Of_DD_MM_YYYY() throws Throwable {
		clearsendkeys(pom.getSh().getDatepick_out(), "24/07/22");
	}

	@When("^user Select Number Of Adults In The Adults Per Room Field$")
	public void user_Select_Number_Of_Adults_In_The_Adults_Per_Room_Field() throws Throwable {
		selectbyindex(pom.getSh().getAdult_room(), 2);
	}

	@When("^user Select Number Of Children In The Children Per Room Field$")
	public void user_Select_Number_Of_Children_In_The_Children_Per_Room_Field() throws Throwable {
		selectbyindex(pom.getSh().getChild_room(), 2);
	}

	@Then("^user Click On The Search Button To Select Hotel Page$")
	public void user_Click_On_The_Search_Button_To_Select_Hotel_Page() throws Throwable {
		clickable(pom.getSh().getSubmit());
	}
	
	//Select a Hotel
	@When("^user Select The Radio Button In The Select Hotel Page$")
	public void user_Select_The_Radio_Button_In_The_Select_Hotel_Page() throws Throwable {
		clickable(pom.getSelhot().getS1());
	}

	@Then("^user Click On The Continue Button To Book Hotel Page$")
	public void user_Click_On_The_Continue_Button_To_Book_Hotel_Page() throws Throwable {
		clickable(pom.getSelhot().getS2());
	}
	
	//Book a Hotel
	@When("^user Enter The First Name In First Name Field$")
	public void user_Enter_The_First_Name_In_First_Name_Field() throws Throwable {
		sendValues(pom.getBh().getFirst_name(), "Saravanan");
	}

	@When("^user Enter The Last Name In Last Name Field$")
	public void user_Enter_The_Last_Name_In_Last_Name_Field() throws Throwable {
		sendValues(pom.getBh().getLast_name(), "saran");
	}

	@When("^user Enter The User Address In Billing Address Field$")
	public void user_Enter_The_User_Address_In_Billing_Address_Field() throws Throwable {
		sendValues(pom.getBh().getAddress(), "29, Thiruvalluvar Street, Kundrathur");
	}

	@When("^user Enter Sixteen Digit Credit Card Number In Credit Card Number Field$")
	public void user_Enter_Sixteen_Digit_Credit_Card_Number_In_Credit_Card_Number_Field() throws Throwable {
		sendValues(pom.getBh().getCc_num(), "1234567891234567");
	}

	@When("^user Select The Credit Card Type In Credit Card Type Field$")
	public void user_Select_The_Credit_Card_Type_In_Credit_Card_Type_Field() throws Throwable {
		selectbytext(pom.getBh().getCc_type(), "Master Card");
	}

	@When("^user Select The Expiry Month Of The Credit Card In Expiry Date Field$")
	public void user_Select_The_Expiry_Month_Of_The_Credit_Card_In_Expiry_Date_Field() throws Throwable {
		selectbytext(pom.getBh().getCc_exp_month(), "November");
	}

	@When("^user Select The Expiry Year Of The Credit Card In Expiry Date Field$")
	public void user_Select_The_Expiry_Year_Of_The_Credit_Card_In_Expiry_Date_Field() throws Throwable {
		selectbytext(pom.getBh().getCc_exp_year(), "2022");
	}

	@When("^user Enter the CVV Number In CVV Number Field$")
	public void user_Enter_the_CVV_Number_In_CVV_Number_Field() throws Throwable {
		sendValues(pom.getBh().getCc_cvv(), "012");
	}

	//Logout
	@Then("^user Click On The Book Now Button To Booking Confirmation Page$")
	public void user_Click_On_The_Book_Now_Button_To_Booking_Confirmation_Page() throws Throwable {
		clickable(pom.getBh().getBook_now());
	}

	@When("^user Click On The Logout Button To Logout Page$")
	public void user_Click_On_The_Logout_Button_To_Logout_Page() throws Throwable {
		clickable(pom.getBh().getLogout());
	}

}
