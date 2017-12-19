package test;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.baseFunc;
import elementFile.SearchWith;

public class testDashboard {
	public WebDriver driver = null;
	WebDriverWait wait;
	String test_url;
	baseFunc init = new baseFunc();

	public testDashboard() {

		test_url = init.getUrl();
		driver = init.initData(this);
		driver.navigate().to(test_url);
		wait = new WebDriverWait(driver, 20);
	}

	@BeforeClass
	public void firstMethod() {

	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("--------------------------------------------");
		String url = driver.getCurrentUrl();
		if (url != test_url) {
			logout();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		pageInit();
	}

	@AfterClass
	public void lastMethod() {
		System.out.println("--------------------------------------------");
		// 关闭浏览器
		// driver.quit();
	}

	/**
	 * 登录
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void login(String user, String pwd) {
		String className = new Exception().getStackTrace()[1].getMethodName();
		init.printLog(className, user);

		driver.navigate().to(test_url + "login");
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		login_submit.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
	}

	/**
	 * 登出
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void logout() {
		driver.navigate().to(test_url + "logout");
	}

	/**
	 * 页签切换
	 * 
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
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void pageInit() {
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
	 * 
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
	 * 最近更新验证
	 * 
	 * @author 刘晨
	 * @Time 2017-12-18
	 *
	 */
	@Test(enabled = true)
	public void dashboard_update() throws InterruptedException {
		login("autoTest06@shimo.im", "123123");
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		desktop1_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.sendKeys("la");
		Thread.sleep(500);
		b_back.click();
		logout();
		login("autoTest05@shimo.im", "123123");

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
		String msg = dashboard_update_time.getText();

		assertEquals(msg, "刚刚 autoTest06 更新");
	}

	/**
	 * 最近使用验证
	 * 
	 * @author 刘晨
	 * @Time 2017-12-18
	 *
	 */
	@Test(enabled = true)
	public void dashboard_used() throws InterruptedException {
		login("autoTest06@shimo.im", "123123");
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		desktop1_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard));
		dashboard.click();
		dashboard_2.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
		String msg = dashboard_update_time.getText();

		assertEquals(msg, "刚刚 我 打开");
	}

	/**
	 * 我创建的验证
	 * 
	 * @author 刘晨
	 * @Time 2017-12-18
	 *
	 */
	@Test(enabled = true)
	public void dashboard_create() throws InterruptedException {
		login("autoTest07@shimo.im", "123123");

		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(b_back));

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);
		driver.findElement(By.id("ql-title-input")).sendKeys(time);
		b_back.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard));
		dashboard_3.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_name));
		String msg = dashboard_update_name.getText();

		Actions action = new Actions(driver);
		action.contextClick(dashboard_update_name).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_setting_doc_12));
		dashboard_setting_doc_12.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		assertEquals(msg, time);
	}

	/**
	 * 共享给我的验证
	 * 
	 * @author 刘晨
	 * @Time 2017-12-19
	 *
	 */
	@Test(enabled = true)
	public void dashboard_share() throws InterruptedException {
		login("autoTest06@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1_folder).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("autoTest07@shimo.im");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();

		logout();
		login("autoTest07@shimo.im", "123123");

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_shareTime_1));
		action.moveToElement(dashboard_shareTime_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_shareTime_unread));
		dashboard_shareTime_unread.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_4));
		dashboard_4.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_share_file));
		action.contextClick(dashboard_share_file).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_share_setting_doc_10));
		dashboard_share_setting_doc_10.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		Thread.sleep(1000);

		msg = driver.findElement(By.className("none-file")).getText();
		assertEquals("没有文件", msg);

	}

	/**
	 * 工作台-文件定位的所在文件夹
	 * 
	 * @author 刘晨
	 * @Time 2017-12-18
	 *
	 */
	@Test(enabled = true)
	public void dashboard_setting_locatFolder() throws InterruptedException {
		login("autoTest08@shimo.im", "123123");

		dashboard_3.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_name));
		Actions action = new Actions(driver);
		action.contextClick(dashboard_update_name).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_setting_doc_8));
		Thread.sleep(500);
		dashboard_setting_doc_8.click();

		String url_sample = "https://release.shimodev.com/folder/x2zSDzXqfQI9TaKr";
		wait.until(ExpectedConditions.urlToBe(url_sample));
		String url = driver.getCurrentUrl();
		assertEquals(url_sample, url);
	}

	@SearchWith(pageName = "homePage", elementName = "userEmail")
	public WebElement userEmail;
	@SearchWith(pageName = "homePage", elementName = "userPwd")
	public WebElement userPwd;
	@SearchWith(pageName = "homePage", elementName = "login_submit")
	public WebElement login_submit;

	@SearchWith(pageName = "desktop", elementName = "desktop_new")
	public WebElement desktop_new;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1")
	public WebElement desktop1_1;
	@SearchWith(pageName = "desktop", elementName = "desktop")
	public WebElement desktop;
	@SearchWith(pageName = "desktop", elementName = "desktop_newDoc")
	public WebElement desktop_newDoc;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_ok")
	public WebElement desktop_newFolder_name_ok;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1_folder")
	public WebElement desktop1_1_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop_show_type")
	public WebElement desktop_show_type;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_5")
	public WebElement desktop_setting_doc_5;

	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator")
	public WebElement button_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "input_addCollaborator")
	public WebElement input_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_1_add")
	public WebElement b_addCollaborator_1_add;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_ok")
	public WebElement b_addCollaborator_ok;

	@SearchWith(pageName = "doc", elementName = "b_back")
	public WebElement b_back;
	@SearchWith(pageName = "doc", elementName = "doc_edit")
	public WebElement doc_edit;

	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_time")
	public WebElement dashboard_update_time;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_file")
	public WebElement dashboard_update_file;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_name")
	public WebElement dashboard_update_name;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_setting_doc_8")
	public WebElement dashboard_setting_doc_8;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_setting_doc_12")
	public WebElement dashboard_setting_doc_12;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_share_setting_doc_10")
	public WebElement dashboard_share_setting_doc_10;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_shareTime_1")
	public WebElement dashboard_shareTime_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_shareTime_unread")
	public WebElement dashboard_shareTime_unread;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_share_file")
	public WebElement dashboard_share_file;

	@SearchWith(pageName = "dashboard", elementName = "dashboard")
	public WebElement dashboard;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_1")
	public WebElement dashboard_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_2")
	public WebElement dashboard_2;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_3")
	public WebElement dashboard_3;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_4")
	public WebElement dashboard_4;
}
