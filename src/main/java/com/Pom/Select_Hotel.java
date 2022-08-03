package com.Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Select_Hotel {
	

	public static WebDriver driver;

	@FindBy(xpath = "//input[@id='radiobutton_0']")
	private WebElement s1;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement s2;
	
	public static WebDriver getDriver() {
		return driver;
	}

	public Select_Hotel(WebDriver driver2) {
		Select_Hotel.driver = driver2;
		PageFactory.initElements(driver, this);
	}
	public WebElement getS1() {
		return s1;
	}

	public WebElement getS2() {
		return s2;
	}
}
