package com.adactin.baseclass;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {
	public static WebDriver driver;

	public static WebDriver browser(String name) {

		if (name.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\MyProject\\Cucumber_Adactin\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	// launch url
	public static WebDriver launchurl(String url) {
		driver.get(url);
		return driver;
	}

	// sendkeys
	public static void sendValues(WebElement element, String Values) {
		element.sendKeys(Values);
	}

	// click eventselectbyvalue
	public static void clickable(WebElement element) {
		element.click();
	}

	// select by value
	public static void selectbyvalue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	// select by index
	public static void selectbyindex(WebElement element, int i) {
		Select s = new Select(element);
		s.selectByIndex(i);
	}

	// select by visible text
	public static void selectbytext(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	// clear sendkeys
	public static void clearsendkeys(WebElement element, String Values) {
		element.clear();
		element.sendKeys(Values);
	}

	// window handle
	public static void handle() {
		String win1 = driver.getWindowHandle();
		System.out.println(win1);
	}

	// window handles
	public static void handles() {
		Set<String> st = driver.getWindowHandles();
		for (String string : st) {
			String title = driver.switchTo().window(string).getTitle();
			System.out.println(title);
		}

	}

	// get title
	public static void pagetitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	// gettext
	public static void text(String path) {
		String txt = driver.findElement(By.xpath(path)).getText();
		System.out.println(txt);
	}

	// getattribute
	public static void attrib(String path) {
		String att = driver.findElement(By.xpath(path)).getAttribute(path);
		System.out.println(att);
	}

	// is displayed
	public static void display(String path) {
		WebElement login = driver.findElement(By.xpath(path));
		boolean displayed = login.isDisplayed();
		if (displayed == true) {
			System.out.println("selected");
		} else
			System.out.println("not selected");
	}

	// is enabled
	public static void enabled(String path) {
		WebElement login = driver.findElement(By.xpath(path));
		boolean enabled = login.isEnabled();
		if (enabled == true) {
			System.out.println("enabled");
		} else
			System.out.println("not enabled");

	}

	// is selected
	public static void selected(String path) {
		WebElement login = driver.findElement(By.xpath(path));
		boolean select = login.isSelected();
		if (select == true) {
			System.out.println("selected");
		} else
			System.out.println("not selected");

	}

	// navigate to next url
	public static void nexturl(String url1) {
		driver.navigate().to(url1);
	}

	// navigate to previous page
	public static void back() {
		driver.navigate().back();
	}

	// navigate to next page
	public static void nextpage() {
		driver.navigate().forward();
	}

	// navigate to refresh
	public static void navigateref() {
		driver.navigate().refresh();
	}

	// scrolldown
	public static void scrolldown() {
		JavascriptExecutor se = (JavascriptExecutor) driver;
		se.executeScript("window.scrollBy(0, 9000)");
	}

	// scrollup
	public static void scrollup() {
		JavascriptExecutor se = (JavascriptExecutor) driver;
		se.executeScript("window.scrollBy(0, -9000)");
	}

	// Alert
	public static void clickbtn(String path) {
		driver.findElement(By.xpath(path)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
	}

	public static void disbtn(String path) {
		driver.findElement(By.xpath(path)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().dismiss();
	}

	public static void prombtn(String path) throws Throwable {
		driver.findElement(By.xpath(path)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().sendKeys("Hello");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();
	}

	// single frame
	public static void fram(String path) {
		driver.switchTo().frame("singleframe");
		driver.findElement(By.xpath(path)).sendKeys("Hello");

	}

	// Action and Robot using rightclick and keypress
	public static void rightclick_newtab(String path) throws Throwable {
		Actions act = new Actions(driver);
		Robot rob = new Robot();
		WebElement ele = driver.findElement(By.xpath(path));
		act.contextClick(ele).build().perform();
		rob.keyPress(KeyEvent.VK_DOWN);
		rob.keyPress(KeyEvent.VK_ENTER);
	}

	// mouse double click
	public static void double_click(String path) throws Throwable {
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(path));
		act.doubleClick(ele).build().perform();
	}

	// quit
	public static WebDriver quitapp() {
		driver.quit();
		return driver;
	}

	// close
	public static WebDriver close() {
		driver.close();
		return driver;
	}

	// Excel Read
	public static String read_Data1(String path, int row_index, int cell_index) throws IOException {
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(row_index);
		Cell cell = row.getCell(cell_index);

		CellType cellType = cell.getCellType();

		String value = null;
		if (cellType.equals(CellType.STRING)) {
			value = cell.getStringCellValue();
		} else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			int data = (int) numericCellValue;
			value = String.valueOf(data);
		}
		wb.close();
		return value;
	}

	// screenshot
	public static File screen(String filename) throws Throwable {
		TakesScreenshot s = (TakesScreenshot) driver;// narrowing type casting
		File src = s.getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\MyProject\\Maven_Project\\Screenshot_images\\" + filename + ".png");
		FileUtils.copyFile(src, dest);
		return src;
	}
}
