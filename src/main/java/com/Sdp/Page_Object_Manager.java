package com.Sdp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Pom.Book_Hotel;
import com.Pom.Login_Page;
import com.Pom.Search_Hotel;
import com.Pom.Select_Hotel;

public class Page_Object_Manager {

	public static WebDriver driver;
	private Login_Page lp;
	private Search_Hotel sh;
	private Select_Hotel selhot;
	private Book_Hotel bh;

	public Login_Page getLp() {
		lp = new Login_Page(driver);
		return lp;
	}

	public Search_Hotel getSh() {
		sh = new Search_Hotel(driver);
		return sh;
	}

	public Select_Hotel getSelhot() {
		selhot = new Select_Hotel(driver);
		return selhot;
	}

	public Book_Hotel getBh() {
		bh = new Book_Hotel(driver);
		return bh;
	}
	
	
	public Page_Object_Manager(WebDriver driver) {
		Page_Object_Manager.driver = driver;
		PageFactory.initElements(driver, this);
	
	}

}
