package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
		// Files\\(x86)\\Firefox\\firefox.exe");//火狐
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 谷歌
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
		init();
		System.out.println("--------------------------------------------");
	}

	@AfterClass
	public void lastMethod() {
		// 关闭浏览器
		// driver.quit();
	}

	/**
	* 登录
	* @author 刘晨
	* @Time 2017-11-21
	*
	*/
	public void login(String user, String pwd) {

		driver.navigate().to("https://release.feature.shimodev.com/login");
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		login_submit.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
	}

	/**
	* 登出
	* @author 刘晨
	* @Time 2017-11-21
	*
	*/
	public void logout() {
		driver.navigate().to("https://release.feature.shimodev.com/logout");
	}

	/**
	* 页签切换
	* @author 刘晨
	* @Time 2017-11-21
	*
	*/
	public void switchToPage(int i) {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		driver.switchTo().window(it.get(i));
	}

	/**
	* 删除浏览器多余标签页
	* @author 刘晨
	* @Time 2017-11-21
	*
	*/
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

	/**
	* 判断元素是否存在
	* @author 刘晨
	* @Time 2017-11-21
	*
	*/
	public boolean doesWebElementExist(WebDriver driver, By selector) {

		try {
			driver.findElement(selector);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	* 基础版用户，文件协作者为5人，不能继续添加协作者
	* @author 刘晨
	* @Time 2017-11-21
	*
	*/
	@Test(enabled = true)
	public void addCollaborator_1() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator_close));
		Boolean exist = button_addCollaborator.isEnabled();

		assertFalse(exist);
	}

	/**
	* 通过输入邮箱地址添加协作者，并且在协作者列表中移除该协作者
	* @author 刘晨
	* @Time 2017-11-21
	*
	*/
	@Test(enabled = true)
	public void addCollaborator_2() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1_folder).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		String msg_a = addCollaborator_total.getText();
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("11@cc.ccc");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		b_addCollaborator_2_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_4));
		list_addCollaborator_4.click();

		Thread.sleep(500);
		String msg_b = addCollaborator_total.getText();
		
		assertEquals(msg_a, msg_b);
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
	@SearchWith(pageName = "desktop", elementName = "desktop1_1_folder")
	public WebElement desktop1_1_folder;

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

	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator")
	public WebElement button_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_close")
	public WebElement button_addCollaborator_close;
	@SearchWith(pageName = "addCollaborator", elementName = "input_addCollaborator")
	public WebElement input_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_1_add")
	public WebElement b_addCollaborator_1_add;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_2_list")
	public WebElement b_addCollaborator_2_list;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_4")
	public WebElement list_addCollaborator_4;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_total")
	public WebElement addCollaborator_total;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_ok")
	public WebElement b_addCollaborator_ok;
}
