package test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import elementFile.CustomFieldDecorator;
import elementFile.MyElementLocatorFactory;
import elementFile.SearchWith;

public class testAddCollaborator {
	public WebDriver driver = null;
	WebDriverWait wait;
	// Boolean firstTest = true;

	public testAddCollaborator() {
		// System.setProperty("webdriver.firefox.bin", "C:\\Program
		// Files\\(x86)\\Firefox\\firefox.exe");//»ðºü
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// ¹È¸è
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().setSize(new Dimension(1200, 1000));
		// driver.manage().window().maximize();
		// driver.manage().window().fullscreen();
		ElementLocatorFactory locatorFactory = new MyElementLocatorFactory(driver);
		FieldDecorator customFieldDecorator = new CustomFieldDecorator(locatorFactory);
		PageFactory.initElements(customFieldDecorator, this);
		wait = new WebDriverWait(driver, 20);
		driver.navigate().to("https://release.feature.shimodev.com/");

	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("--------------------------------------------");
		String url = driver.getCurrentUrl();
		if (url != "https://release.feature.shimodev.com/") {
			logout();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		// logout();
		// Set<String> winHandels = driver.getWindowHandles();
		// List<String> it = new ArrayList<String>(winHandels);
		// int n = it.size();
		// for (int i = 0; i < n - 1; i++) {
		// driver.switchTo().window(it.get(i));
		// driver.close();
		// }
		//
		// winHandels = driver.getWindowHandles();
		// it = new ArrayList<String>(winHandels);
		// driver.switchTo().window(it.get(0));
		init();
		System.out.println("--------------------------------------------");
	}

	@AfterClass
	public void lastMethod() {
		// ¹Ø±Õä¯ÀÀÆ÷
		// driver.quit();
	}

	// µÇÂ¼
	public void login(String user, String pwd) {

		driver.navigate().to("https://release.feature.shimodev.com/login");

		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		login_submit.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
	}

	// µÇ³ö
	public void logout() {
		driver.navigate().to("https://release.feature.shimodev.com/logout");
	}

	// Ò³Ç©ÇÐ»»
	public void switchToPage(int i) {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		driver.switchTo().window(it.get(i));
	}

	public void init() {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		int n = it.size();
		for (int i = 0; i < n - 1; i++) {
			driver.switchTo().window(it.get(i));
			driver.close();
		}

		winHandels = driver.getWindowHandles();
		it = new ArrayList<String>(winHandels);
		driver.switchTo().window(it.get(0));
	}

	// ÅÐ¶ÏÔªËØÊÇ·ñ´æÔÚ
	public boolean doesWebElementExist(WebDriver driver, By selector) {

		try {
			driver.findElement(selector);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Test(enabled = false)
	public void dashboard() {
		login("autoTest01@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		Actions action = new Actions(driver);
		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

	}

	@SearchWith(pageName = "desktop", elementName = "desktop")
	public WebElement desktop;
	@SearchWith(pageName = "dashboard", elementName = "dashboard")
	public WebElement dashboard;
	@SearchWith(pageName = "dashboard", elementName = "favorites")
	public WebElement favorites;
	@SearchWith(pageName = "dashboard", elementName = "trash")
	public WebElement trash;
	@SearchWith(pageName = "desktop", elementName = "desktop_new")
	public WebElement desktop_new;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1")
	public WebElement desktop1_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_5")
	public WebElement desktop_setting_doc_5;

	@SearchWith(pageName = "homePage", elementName = "userEmail")
	public WebElement userEmail;
	@SearchWith(pageName = "homePage", elementName = "userPwd")
	public WebElement userPwd;
	@SearchWith(pageName = "homePage", elementName = "xpath_login")
	public WebElement xpath_login;
	@SearchWith(pageName = "homePage", elementName = "login_submit")
	public WebElement login_submit;
}
