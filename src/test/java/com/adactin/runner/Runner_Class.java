package com.adactin.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.adactin.baseclass.Base_Class;
import com.adactin.properties.File_Reader_Manager;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//java//com//adactin//feature", 
glue = "com.adactin.stepdefinition",
monochrome = true,
dryRun = false,
strict = true
/*plugin = {"html:Report/HTML_Report", 
		"pretty",
		"json:Report/Cucumber_Adactin.json",
		"com.cucumber.listener.ExtentCucumberFormatter:Report/Adactin_Extent.html"}*/
)
public class Runner_Class {

	public static WebDriver driver;

	@BeforeClass
	public static void setUP() throws IOException {
		String browser = File_Reader_Manager.getInstance().getInstanceCR().getBrowser();
		driver = Base_Class.browser(browser);
	}

	@AfterClass
	public static void tearDown() {
		driver = Base_Class.close();
	}

}
