package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

public class testDesktop {
	public WebDriver driver = null;
	WebDriverWait wait;
	// Boolean firstTest = true;

	public testDesktop() {
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
	* @Time 2017-11-20
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
	* @Time 2017-11-20
	*
	*/
	public void logout() {
		driver.navigate().to("https://release.feature.shimodev.com/logout");
	}

	/**
	* 页签切换
	* @author 刘晨
	* @Time 2017-11-20
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
	* @Time 2017-11-20
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
	* @Time 2017-11-20
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

	@Test(enabled = false)
	public void dashboard() {

		login("autoTest@shimo.im", "123123");

		String url = "error";
		desktop.click();
		url = driver.getCurrentUrl();
		// System.out.println(url);
		Boolean desktop_url = url.equals("https://release.feature.shimodev.com/desktop");

		dashboard.click();
		url = driver.getCurrentUrl();
		Boolean dashboard_url1 = url.equals("https://release.feature.shimodev.com/dashboard/updated");

		dashboard_2.click();
		url = driver.getCurrentUrl();
		Boolean dashboard_url2 = url.equals("https://release.feature.shimodev.com/dashboard/used");

		dashboard_3.click();
		url = driver.getCurrentUrl();
		Boolean dashboard_url3 = url.equals("https://release.feature.shimodev.com/dashboard/own");

		dashboard_4.click();
		url = driver.getCurrentUrl();
		Boolean dashboard_url4 = url.equals("https://release.feature.shimodev.com/dashboard/shared");

		assertEquals(true, desktop_url && dashboard_url1 && dashboard_url2 && dashboard_url3 && dashboard_url4);

		// favorites.click();
		// trash.click();
		// dashboard.click();
	}

	/**
	* 新建文档
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_newDoc() throws InterruptedException {

		login("autoTest@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		Actions action = new Actions(driver);
		action.moveToElement(desktop1_1).perform();
		desktop_setting.click();
		desktop_setting_doc_11.click();
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg1 = desktop1_1.getText();

		assertEquals(msg, msg1);

	}

	/**
	* 新建表格
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_newSheet() {

		login("autoTest@shimo.im", "123123");

		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newSheet));
		desktop_newSheet.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		Actions action = new Actions(driver);
		action.moveToElement(desktop1_1).perform();
		desktop_setting.click();
		desktop_setting_doc_11.click();
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg1 = desktop1_1.getText();

		assertEquals(msg, msg1);

	}

	/**
	* 新建文件夹
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_newFolder() {

		login("autoTest@shimo.im", "123123");

		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder));
		desktop_newFolder.click();

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);

		desktop_newFolder_name.sendKeys(time);
		desktop_newFolder_name_ok.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.className("settings")));
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		Actions action = new Actions(driver);
		action.moveToElement(desktop1_1).perform();
		desktop_setting.click();
		desktop_setting_folder_9.click();
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg1 = desktop1_1.getText();

		assertEquals(msg, msg1);
	}

	/**
	* 桌面-列表/平铺 模式切换
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_show_type() throws InterruptedException {

		login("autoTest@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_show_type));
		desktop_show_type.click();

		Boolean result = false;
		Boolean exist1 = doesWebElementExist(driver, By.className("table-head-cell"));

		desktop_show_type.click();

		Boolean exist2 = doesWebElementExist(driver, By.className("table-head-cell"));

		if (exist1 == true && exist2 == false) {
			result = true;
		}

		assertTrue(result);

	}

	/**
	* 右键文档-在新标签页中打开
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_doc_setting_1() {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_1.click();

		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		int n = it.size();
		assertEquals(2, n);
	}

	/**
	* 右键文档-添加到快捷方式
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_doc_setting_2() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_2));
		desktop_setting_doc_2.click();
		Thread.sleep(500);
		String msg = desktop_shortcut_1.getText();
		String doc_name = desktop1_1.getText();

		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_2));
		desktop_setting_doc_2.click();

		assertEquals(doc_name, msg);

	}

	/**
	* 右键文档-收藏
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_doc_setting_3() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		String doc_name = desktop1_1.getText();
		Actions action = new Actions(driver);
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_3));
		desktop_setting_doc_3.click();

		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String doc_name1 = desktop1_1.getText();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_3));
		desktop_setting_doc_3.click();

		assertEquals(doc_name, doc_name1);
	}

	/**
	* 右键文档-移动
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_doc_setting_6() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		String msg = desktop1_1.getText();

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_6));
		desktop_setting_doc_6.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_list_1));
		desktop_moveFolder_list_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_button));
		desktop_moveFolder_button.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		desktop1_1_folder.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_6));
		desktop_setting_doc_6.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_back_button));
		desktop_moveFolder_back_button.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_button));
		desktop_moveFolder_button.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop));
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg1 = desktop1_1.getText();

		assertEquals(msg, msg1);
	}

	/**
	* 右键文档-重命名
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_doc_setting_8() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		desktop1_1_folder.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_8));
		desktop_setting_doc_8.click();

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);

		desktop_newFolder_name.sendKeys(time);
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();

		assertEquals(time, msg);
	}

	/**
	* 右键文档-创建副本
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_doc_setting_9() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		String msg = desktop1_1.getText();
		Actions action = new Actions(driver);
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_9));
		desktop_setting_doc_9.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg1 = desktop1_1.getText();

		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		desktop_newFolder_name_ok.click();

		assertEquals(msg1, "副本 " + msg);
	}

	/**
	* 右键文件夹-在新标签页打开
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_folder_setting_1() {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1_folder).perform();
		desktop_setting_doc_1.click();

		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		int n = it.size();
		assertEquals(2, n);
	}

	/**
	* 右键文件夹-添加到快捷方式
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_folder_setting_2() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1_folder).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_2));
		desktop_setting_doc_2.click();
		Thread.sleep(500);
		String msg = desktop_shortcut_1.getText();
		String doc_name = desktop1_1_folder.getText();

		action.contextClick(desktop1_1_folder).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_2));
		desktop_setting_doc_2.click();

		assertEquals(doc_name, msg);

	}

	/**
	* 右键文件夹-收藏
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_folder_setting_3() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		String doc_name = desktop1_1_folder.getText();
		Actions action = new Actions(driver);
		action.contextClick(desktop1_1_folder).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_3));
		desktop_setting_doc_3.click();

		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String doc_name1 = desktop1_1_folder.getText();
		action.contextClick(desktop1_1_folder).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_3));
		desktop_setting_doc_3.click();

		assertEquals(doc_name, doc_name1);
	}

	/**
	* 右键文件夹-文件夹移动，重命名，删除
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_folder_setting() {

		login("autoTest@shimo.im", "123123");

		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder));
		desktop_newFolder.click();

		desktop_newFolder_name.sendKeys("FFFFF");
		desktop_newFolder_name_ok.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.className("settings")));
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_6));
		desktop_setting_doc_6.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_list_2));
		desktop_moveFolder_list_2.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_button));
		desktop_moveFolder_button.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		desktop1_1_folder.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_8));
		desktop_setting_doc_8.click();

		desktop_newFolder_name.sendKeys("删除文件夹");
		desktop_newFolder_name_ok.click();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();

		action.moveToElement(desktop1_1).perform();
		desktop_setting.click();
		desktop_setting_folder_9.click();
		desktop_newFolder_name_ok.click();

		assertEquals(msg, "删除文件夹");
	}

	@Test(enabled = false)
	public void desktop_moveTo() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		Thread.sleep(1000);
		Actions action = new Actions(driver);
		// action.clickAndHold(desktop1_1).perform();
		// Thread.sleep(1000);
		// action.moveToElement(desktop1_1_folder).perform();
		// Thread.sleep(1000);
		// action.release().perform();
		action.dragAndDrop(desktop1_1, desktop1_1_folder).perform();
		// action.dragAndDropBy(desktop1_1,100,100).perform();

	}

	/**
	* 导入文档
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_import_doc() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		WebElement uploadButton = desktop_import;
		String url = System.getProperty("user.dir") + "/doc/test_doc.docx";
		System.out.println(url);
		uploadButton.sendKeys(url);

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();
		Actions action = new Actions(driver);
		action.moveToElement(desktop1_1).perform();
		desktop_setting.click();
		desktop_setting_doc_11.click();
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		assertEquals(msg, "test_doc");

	}

	/**
	* 导入表格
	* @author 刘晨
	* @Time 2017-11-20
	*
	*/
	@Test
	public void desktop_import_sheet() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		WebElement uploadButton = desktop_import;
		String url = System.getProperty("user.dir") + "/doc/test_sheet.xlsx";
		System.out.println(url);
		uploadButton.sendKeys(url);

		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_cancel));
		desktop_newFolder_name_cancel.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();

		Actions action = new Actions(driver);
		action.moveToElement(desktop1_1).perform();
		desktop_setting.click();
		desktop_setting_doc_11.click();
		desktop_newFolder_name_ok.click();

		assertEquals(msg, "test_sheet");

	}

	@SearchWith(pageName = "desktop", elementName = "desktop")
	public WebElement desktop;
	@SearchWith(pageName = "desktop", elementName = "desktop_new")
	public WebElement desktop_new;
	@SearchWith(pageName = "desktop", elementName = "desktop_newDoc")
	public WebElement desktop_newDoc;
	@SearchWith(pageName = "desktop", elementName = "desktop_newSheet")
	public WebElement desktop_newSheet;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder")
	public WebElement desktop_newFolder;
	@SearchWith(pageName = "desktop", elementName = "desktop_import")
	public WebElement desktop_import;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name")
	public WebElement desktop_newFolder_name;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_ok")
	public WebElement desktop_newFolder_name_ok;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_cancel")
	public WebElement desktop_newFolder_name_cancel;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1")
	public WebElement desktop1_1;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1_folder")
	public WebElement desktop1_1_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_1")
	public WebElement desktop_setting_doc_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_2")
	public WebElement desktop_setting_doc_2;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_3")
	public WebElement desktop_setting_doc_3;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_6")
	public WebElement desktop_setting_doc_6;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_8")
	public WebElement desktop_setting_doc_8;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_9")
	public WebElement desktop_setting_doc_9;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_11")
	public WebElement desktop_setting_doc_11;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_folder_9")
	public WebElement desktop_setting_folder_9;
	@SearchWith(pageName = "desktop", elementName = "desktop_set")
	public WebElement desktop_setting;
	@SearchWith(pageName = "desktop", elementName = "desktop_show_type")
	public WebElement desktop_show_type;
	@SearchWith(pageName = "desktop", elementName = "desktop_shortcut_1")
	public WebElement desktop_shortcut_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_button")
	public WebElement desktop_moveFolder_button;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_back_button")
	public WebElement desktop_moveFolder_back_button;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_list_1")
	public WebElement desktop_moveFolder_list_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_list_2")
	public WebElement desktop_moveFolder_list_2;

	@SearchWith(pageName = "doc", elementName = "b_back")
	public WebElement b_back;

	@SearchWith(pageName = "dashboard", elementName = "dashboard")
	public WebElement dashboard;
	@SearchWith(pageName = "dashboard", elementName = "favorites")
	public WebElement favorites;
	@SearchWith(pageName = "dashboard", elementName = "trash")
	public WebElement trash;

	@SearchWith(pageName = "dashboard", elementName = "dashboard_1")
	public WebElement dashboard_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_2")
	public WebElement dashboard_2;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_3")
	public WebElement dashboard_3;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_4")
	public WebElement dashboard_4;

	@SearchWith(pageName = "homePage", elementName = "userEmail")
	public WebElement userEmail;
	@SearchWith(pageName = "homePage", elementName = "userPwd")
	public WebElement userPwd;
	@SearchWith(pageName = "homePage", elementName = "xpath_login")
	public WebElement xpath_login;
	@SearchWith(pageName = "homePage", elementName = "login_submit")
	public WebElement login_submit;

}
