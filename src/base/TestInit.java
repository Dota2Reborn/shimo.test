package base;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import elementFile.SearchWith;

public class TestInit {
	public WebDriver driver = null;
	public WebDriverWait wait = null;
	public Actions action = null;
	String test_url;
	baseFunc init = new baseFunc();

	public TestInit() {

	}

	@BeforeClass
	public void firstMethod() {
		test_url = init.getUrl();
		driver = init.initData(this);
		action = new Actions(driver);
		driver.navigate().to(test_url + "login");
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		// System.out.println("11111111111111111111111111111111111111");
		wait = new WebDriverWait(driver, 6);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("--------------------------------------------");
		String url = driver.getCurrentUrl();
		if (!url.equals(test_url + "login")) {
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
		driver.quit();
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
		printLog(className, user);

		if (!driver.getCurrentUrl().equals(test_url + "login")) {
			driver.navigate().to(test_url + "login");
		}
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		try {
			click(login_submit);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
	}

	/**
	 * 登录（For登录报错验证）
	 * 
	 * @author 刘晨
	 * @Time 2017-01-08
	 *
	 */
	public void login_error(String user, String pwd) {
		String className = new Exception().getStackTrace()[1].getMethodName();
		printLog(className, user);

		driver.navigate().to(test_url + "login");
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		// login_submit.click();
		try {
			click(login_submit);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 注册(yanzheng=1时，仅作错误输入验证使用)
	 * 
	 * @author 王继程
	 * @Time 2017-11-21
	 *
	 */
	public void Registered(String name, String user, String pwd, int yanzheng) {
		if (yanzheng == 1) {
			String className = new Exception().getStackTrace()[1].getMethodName();
			printLog(className, className);
			driver.navigate().to(test_url + "register");
			wait.until(ExpectedConditions.elementToBeClickable(Next));
			userName.sendKeys(name);
			Email.sendKeys(user);
			Pwd.sendKeys(pwd);
			Next.click();
		} else {
			return;
		}
	}

	/**
	 * 登出
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void logout() {
		try {
			driver.navigate().to(test_url + "logout");
			driver.switchTo().alert().accept();
			// driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
			action.sendKeys(Keys.ESCAPE);
		} catch (UnhandledAlertException e) {
			// 报错
			driver.switchTo().alert().accept();
			driver.navigate().to(test_url + "logout");
			System.out.println("Unhandled Alert!!!!");
		} catch (NoAlertPresentException e) {
			// 正常情况
			action.sendKeys(Keys.ESCAPE);
		}
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
	 * Log
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	public void printLog(String classname, String userID) {
		System.out.println(classname + "[" + userID + "]");

	}

	/**
	 * 判断元素是否存在
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public boolean doesWebElementExist(By selector) {

		try {
			driver.findElement(selector);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * 右键点击
	 * 
	 * @author 刘晨
	 * @Time 2018-03-23
	 *
	 */
	public void contextClick(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.contextClick(element).perform();
		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
		}

	}

	/**
	 * 左键点击
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2018-03-23
	 * 
	 */
	public void click(WebElement element) throws InterruptedException {
		try {
			if (element.toString().equals(b_back.toString()) || element.toString().equals(Back_to_Table.toString())
					|| element.toString().equals(Back_to_Desktop.toString())) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				checkPageIsReady();
				wait.until(ExpectedConditions
						.invisibilityOfElementWithText(By.xpath("//span[@id='save-status']//span[2]"), "正在保存..."));
				element.click();
				driver.switchTo().alert().accept();
			} else if (element.toString().equals(desktop.toString())
					|| element.toString().equals(favorites.toString())) {
				clickDesktop(element);
			} else if (element.toString().equals(menu_shortcut.toString())) {
				clickShortcut();
			} else {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
			}
		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
			assertTrue(false);
		} catch (ElementClickInterceptedException e) {
			// 被遮挡
			System.out.println(element + "is obscuring");
			assertTrue(false);
		} catch (ElementNotVisibleException e) {
			// 不可见
			System.out.println(element + "is not visible");
			assertTrue(false);
		} catch (UnhandledAlertException e) {
			// 报错
			driver.switchTo().alert().accept();
			System.out.println("Unhandled Alert!!!!");
			assertTrue(false);
		} catch (TimeoutException e) {
			// 超时
			System.out.println("time out ->" + element);
			assertTrue(false);
		} catch (NoAlertPresentException e) {
			// 正常情况
		} catch (JavascriptException e) {
			String msg = driver.switchTo().alert().getText();
			System.out.println("Unhandled Alert :" + msg);
			System.out.println("javascript Error:" + e.getMessage());
			assertTrue(false);
		}
	}

	/**
	 * 点击切换到我的桌面
	 * 
	 * @author 刘晨
	 * @Time 2018-4-13
	 *
	 */
	public void clickShortcut() {
		String setting_2 = getText(menu_shortcut);
		if (setting_2.equals("从快捷方式移除")) {
			menu_shortcut.click();
			contextClick(desktop1_1);
			wait.until(ExpectedConditions.elementToBeClickable(menu_shortcut));
			menu_shortcut.click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(menu_shortcut));
			menu_shortcut.click();
		}
	}

	/**
	 * 点击切换到我的桌面
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void clickDesktop(WebElement element) {
		String msg = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			msg = desktop_order.getText();
			if (msg.equals("更新时间")) {
				desktop_order.click();
				wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
				desktop_orderByFolderUP.click();

				desktop_order.click();
				wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
				desktop_orderByDefault.click();
			} else {
				return;
			}
		} finally {
			msg = desktop_show_type.getText();
			if (msg.equals("平铺")) {
				desktop_show_type.click();
			}
		}

	}

	/**
	 * 获取文本信息
	 * 
	 * @author 刘晨
	 * @Time 2018-03-23
	 *
	 */
	public String getText(WebElement element) {
		String msg = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			msg = element.getText();
		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
		}
		return msg;
	}

	/**
	 * 通过JS判断页面是否加载完毕
	 * 
	 * @author 刘晨
	 * @Time 2018-04-10
	 *
	 */
	public void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 10; i++) {
			if ("complete".equals(js.executeScript("return document.readyState").toString())) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 等待元素加载
	 * 
	 * @author 刘晨
	 * @Time 2018-01-25
	 *
	 */
	public void waitFor() {

	}

	@SearchWith(pageName = "homePage", elementName = "userEmail", noteName = "用户名")
	public WebElement userEmail;
	@SearchWith(pageName = "homePage", elementName = "userPwd", noteName = "密码")
	public WebElement userPwd;
	@SearchWith(pageName = "homePage", elementName = "login_submit", noteName = "登录按钮")
	public WebElement login_submit;

	// desktop
	@SearchWith(pageName = "desktop", elementName = "desktop_new", noteName = "新建文件按钮")
	public WebElement desktop_new;
	@SearchWith(pageName = "desktop", elementName = "desktop_show_type", noteName = "列表平铺模式切换")
	public WebElement desktop_show_type;
	@SearchWith(pageName = "desktop", elementName = "desktop", noteName = "切换到我的桌面")
	public WebElement desktop;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1", noteName = "平铺模式第一行第一个文件")
	public WebElement desktop1_1;
	@SearchWith(pageName = "desktop", elementName = "desktop1_2", noteName = "平铺模式第一行第二个文件")
	public WebElement desktop1_2;
	@SearchWith(pageName = "desktop", elementName = "desktop_newDoc", noteName = "新建文档")
	public WebElement desktop_newDoc;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_ok", noteName = "文件夹命名确定,退出共享确认")
	public WebElement desktop_newFolder_name_ok;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1_folder", noteName = "平铺模式第一行第一个文件夹")
	public WebElement desktop1_1_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop1_2_folder", noteName = "平铺模式第一行第二个文件夹")
	public WebElement desktop1_2_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_1_file", noteName = "列表模式第一个文件")
	public WebElement desktop_list_1_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_2_file", noteName = "列表模式第二个文件")
	public WebElement desktop_list_2_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_3_file", noteName = "列表模式第三个文件")
	public WebElement desktop_list_3_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_order", noteName = "桌面排序")
	public WebElement desktop_order;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByUpdate", noteName = "桌面排序-按更新时间")
	public WebElement desktop_orderByUpdate;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByCreate", noteName = "桌面排序-按创建时间")
	public WebElement desktop_orderByCreate;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByFile", noteName = "桌面排序-文件名")
	public WebElement desktop_orderByFile;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByOwner", noteName = "桌面排序-所有者")
	public WebElement desktop_orderByOwner;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByFolderUP", noteName = "桌面排序-文件夹置顶")
	public WebElement desktop_orderByFolderUP;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByDefault", noteName = "桌面排序-默认")
	public WebElement desktop_orderByDefault;
	@SearchWith(pageName = "desktop", elementName = "desktop_newSheet", noteName = "新建表格")
	public WebElement desktop_newSheet;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder", noteName = "新建文件夹")
	public WebElement desktop_newFolder;
	@SearchWith(pageName = "desktop", elementName = "desktop_import", noteName = "导入")
	public WebElement desktop_import;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name", noteName = "文件夹命名")
	public WebElement desktop_newFolder_name;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_cancel", noteName = "文件夹命名取消")
	public WebElement desktop_newFolder_name_cancel;
	@SearchWith(pageName = "desktop", elementName = "desktop_set", noteName = "hover文件的齿轮")
	public WebElement desktop_setting;
	@SearchWith(pageName = "desktop", elementName = "desktop_shortcut_1", noteName = "桌面快捷方式第一个")
	public WebElement desktop_shortcut_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_button", noteName = "移动到测试文件夹")
	public WebElement desktop_moveFolder_button;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_back_button", noteName = "移动文件到文件夹，列表中后退按钮")
	public WebElement desktop_moveFolder_back_button;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_list_1", noteName = "移动文件到文件夹，选择列表中第一个文件夹")
	public WebElement desktop_moveFolder_list_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_moveFolder_list_2", noteName = "移动文件到文件夹，选择列表中第二个文件夹")
	public WebElement desktop_moveFolder_list_2;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderHeader_1", noteName = "表头文件名排序")
	public WebElement desktop_orderHeader_1;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderHeader_2", noteName = "表头所有者排序")
	public WebElement desktop_orderHeader_2;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderHeader_3", noteName = "表头时间排序")
	public WebElement desktop_orderHeader_3;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1_name", noteName = "获取第一个文件名称")
	public WebElement desktop1_1_name;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByFolderUP_Hook", noteName = "桌面排序-文件夹置顶-对钩")
	public WebElement desktop_orderByFolderUP_Hook;

	// doc
	@SearchWith(pageName = "doc", elementName = "b_back", noteName = "后退")
	public WebElement b_back;
	@SearchWith(pageName = "doc", elementName = "doc_saveStatus", noteName = "文档/表格提示同步完成状态")
	public WebElement doc_saveStatus;
	@SearchWith(pageName = "doc", elementName = "quick_access_point", noteName = "收索&快速打开")
	public WebElement quick_access_point;
	@SearchWith(pageName = "doc", elementName = "Back_to_Desktop", noteName = "一级文件夹下的文档或者表格中，下箭头直接返回桌面")
	public WebElement Back_to_Desktop;
	@SearchWith(pageName = "doc", elementName = "Back_to_Table", noteName = "一级文件夹下的文档或者表格中，下箭头直接返回工作台")
	public WebElement Back_to_Table;
	@SearchWith(pageName = "doc", elementName = "doc_edit", noteName = "文档编辑入口")
	public WebElement doc_edit;
	@SearchWith(pageName = "doc", elementName = "doc_notice_user", noteName = "@用户，被选列表中内容第一个用户")
	public WebElement doc_notice_user;
	@SearchWith(pageName = "doc", elementName = "doc_menu", noteName = "文档编辑页面中右上角 点点点")
	public WebElement doc_menu;
	@SearchWith(pageName = "doc", elementName = "doc_menu_msg", noteName = "文档编辑页面中右上角 点点点-文档信息")
	public WebElement doc_menu_msg;
	@SearchWith(pageName = "doc", elementName = "doc_menu_delete", noteName = "文档编辑页面中右上角 点点点-删除文档")
	public WebElement doc_menu_delete;
	@SearchWith(pageName = "doc", elementName = "doc_menu_delete_OK", noteName = "文档编辑页面中右上角 点点点-删除文档-确定按钮")
	public WebElement doc_menu_delete_OK;
	@SearchWith(pageName = "doc", elementName = "doc_discuss", noteName = "文档编辑页面中评论按钮")
	public WebElement doc_discuss;
	@SearchWith(pageName = "doc", elementName = "doc_discuss_input", noteName = "文档编辑页面中评论输入框")
	public WebElement doc_discuss_input;
	@SearchWith(pageName = "doc", elementName = "doc_discuss_input_ok", noteName = "文档编辑页面中评论输入框-确定按钮")
	public WebElement doc_discuss_input_ok;
	@SearchWith(pageName = "doc", elementName = "ql_comment_Comments", noteName = "工具栏中发起评论按钮")
	public WebElement ql_comment_Comments;
	@SearchWith(pageName = "doc", elementName = "Folder_settings", noteName = "文件夹中上方设置按钮")
	public WebElement Folder_settings;
	@SearchWith(pageName = "doc", elementName = "Exit_share_OK", noteName = "管理员删除文档-选择退出共享")
	public WebElement Exit_share_OK;
	@SearchWith(pageName = "doc", elementName = "Collection_OK", noteName = "标题栏收藏按钮")
	public WebElement Collection_OK;
	@SearchWith(pageName = "doc", elementName = "End_Discussion", noteName = "结束讨论")
	public WebElement End_Discussion;
	@SearchWith(pageName = "doc", elementName = "End_Discussion_OK", noteName = "确定结束讨论")
	public WebElement End_Discussion_OK;

	// dashboard
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_time", noteName = "工作台-最近更新-更新时间")
	public WebElement dashboard_update_time;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_file", noteName = "工作台-共享给我的-文件")
	public WebElement dashboard_update_file;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_name", noteName = "工作台-最近更新-文件名")
	public WebElement dashboard_update_name;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_shareTime_1", noteName = "新的共享-大标签-更新时间")
	public WebElement dashboard_shareTime_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_shareTime_unread", noteName = "新的共享-大标签-标记已读")
	public WebElement dashboard_shareTime_unread;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_share_file", noteName = "工作台-共享给我的-文件")
	public WebElement dashboard_share_file;
	@SearchWith(pageName = "dashboard", elementName = "New_Share_1", noteName = "新的共享第一个")
	public WebElement New_Share_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_1", noteName = "工作台-最近更新")
	public WebElement dashboard_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_2", noteName = "工作台-最近使用")
	public WebElement dashboard_2;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_3", noteName = "工作台-我创建的")
	public WebElement dashboard_3;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_4", noteName = "工作台-共享给我的")
	public WebElement dashboard_4;
	@SearchWith(pageName = "dashboard", elementName = "dashboard", noteName = "切换到工作台")
	public WebElement dashboard;
	@SearchWith(pageName = "dashboard", elementName = "favorites", noteName = "切换到我的收藏")
	public WebElement favorites;
	@SearchWith(pageName = "dashboard", elementName = "trash", noteName = "切换到回收站")
	public WebElement trash;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_search_button", noteName = "桌面搜索按钮")
	public WebElement dashboard_search_button;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_search_input", noteName = "桌面搜索输入框")
	public WebElement dashboard_search_input;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_search_result_1", noteName = "桌面搜索结果第一行")
	public WebElement dashboard_search_result_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice", noteName = "桌面通知铃铛")
	public WebElement dashboard_notice;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_1", noteName = "桌面通知铃铛-通知列表中第一个")
	public WebElement dashboard_notice_list_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_1_button", noteName = "桌面通知铃铛-通知列表中第一个-按钮")
	public WebElement dashboard_notice_list_1_button;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_1_time", noteName = "桌面通知铃铛-通知列表中第一个时间")
	public WebElement dashboard_notice_list_1_time;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_unread", noteName = "桌面通知铃铛-未读")
	public WebElement dashboard_notice_list_unread;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_allRead", noteName = "桌面通知铃铛-标记全部已读")
	public WebElement dashboard_notice_list_allRead;

	// addCollaborator
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_close", noteName = "关闭添加协作者弹框")
	public WebElement button_addCollaborator_close;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_1_list", noteName = "协作者列表第一个协作者权限下拉框")
	public WebElement b_addCollaborator_1_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_2_list", noteName = "协作者列表第二个协作者权限下拉框")
	public WebElement b_addCollaborator_2_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_3_list", noteName = "协作者列表第三个协作者权限下拉框")
	public WebElement b_addCollaborator_3_list;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_1", noteName = "协作者权限列表--转让所有权")
	public WebElement list_addCollaborator_1;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_4", noteName = "协作者权限列表--移除")
	public WebElement list_addCollaborator_4;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_total", noteName = "协作者人数")
	public WebElement addCollaborator_total;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_1_add", noteName = "最近协作者列表第一个添加按钮")
	public WebElement addCollaborator_1_add;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_companyList_2_add", noteName = "企业协作者列表第二个添加按钮")
	public WebElement addCollaborator_companyList_2_add;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_company_list", noteName = "协作者页面切换到企业成员列表")
	public WebElement addCollaborator_company_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_back", noteName = "从协作者列表反馈按钮")
	public WebElement b_addCollaborator_back;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_confirm", noteName = "协作者移除或者降低自己权限时提示弹窗的确定按钮")
	public WebElement b_addCollaborator_confirm;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_changeOwner_1", noteName = "协作者权限列表--转让所有权列表--选择第一个用户为转让对象按钮")
	public WebElement list_addCollaborator_changeOwner_1;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_1_list_userName", noteName = "协作者列表第一个协作者用户名")
	public WebElement addCollaborator_1_list_userName;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_2_list_userName", noteName = "协作者列表第二个协作者用户名")
	public WebElement addCollaborator_2_list_userName;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_folder_add", noteName = "文件夹内右侧(加号)添加协作人按钮")
	public WebElement addCollaborator_folder_add;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator", noteName = "添加协作者按钮")
	public WebElement button_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "input_addCollaborator", noteName = "添加协作者邮箱输入框")
	public WebElement input_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_1_add", noteName = "搜索显示被添加协作者列表第一个添加按钮")
	public WebElement b_addCollaborator_1_add;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_ok", noteName = "确认添加协作者按钮")
	// 王继程3/12
	public WebElement b_addCollaborator_ok;
	@SearchWith(pageName = "addCollaborator", elementName = "Can_edit_1", noteName = "可以编辑")
	public WebElement Can_edit_1;
	@SearchWith(pageName = "addCollaborator", elementName = "can_only_comment_2", noteName = "只能评论")
	public WebElement can_only_comment_2;
	@SearchWith(pageName = "addCollaborator", elementName = "can_only_read_3", noteName = "只能阅读")
	public WebElement can_only_read_3;
	@SearchWith(pageName = "addCollaborator", elementName = "Shut_down_sm_modal_close_x", noteName = "关闭添加协作窗口")
	public WebElement Shut_down_sm_modal_close_x;

	// 企业管理
	@SearchWith(pageName = "companyManagement", elementName = "company_Management", noteName = "桌面-企业管理入口")
	public WebElement company_Management;
	@SearchWith(pageName = "companyManagement", elementName = "company_setting", noteName = "企业管理-企业设置")
	public WebElement company_setting;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member", noteName = "企业设置-谁能邀请新成员进企业")
	public WebElement invite_member;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_OK", noteName = "企业设置-谁能邀请新成员进企业-保存按钮")
	public WebElement invite_member_OK;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_1", noteName = "企业设置-谁能邀请新成员进企业-所有企业成员")
	public WebElement invite_member_1;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_2", noteName = "企业设置-谁能邀请新成员进企业-仅企业创建者和管理员")
	public WebElement invite_member_2;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_3", noteName = "企业设置-谁能邀请新成员进企业-仅企业创建者")
	public WebElement invite_member_3;
	@SearchWith(pageName = "companyManagement", elementName = "addMember", noteName = "成员管理-添加成员按钮")
	public WebElement addMember;
	@SearchWith(pageName = "companyManagement", elementName = "address_cppy", noteName = "企业设置-添加成员-复制链接按钮")
	public WebElement address_cppy;
	@SearchWith(pageName = "companyManagement", elementName = "message_ok", noteName = "消息确认按钮")
	public WebElement message_ok;
	@SearchWith(pageName = "companyManagement", elementName = "message_warning", noteName = "提示消息")
	public WebElement message_warning;
	@SearchWith(pageName = "companyManagement", elementName = "button_companyName", noteName = "企业设置-企业名称（更改按钮）")
	public WebElement button_companyName;
	@SearchWith(pageName = "companyManagement", elementName = "input_companyName", noteName = "企业设置-企业名称")
	public WebElement input_companyName;
	@SearchWith(pageName = "companyManagement", elementName = "text_companyName", noteName = "企业设置-企业名称（输入框）")
	public WebElement text_companyName;
	@SearchWith(pageName = "companyManagement", elementName = "setAdmin", noteName = "企业设置-设置管理员")
	public WebElement setAdmin;
	@SearchWith(pageName = "companyManagement", elementName = "setAdmin_ManagerAndCreater", noteName = "企业设置-设置管理员-管理员和创建者")
	public WebElement setAdmin_ManagerAndCreater;
	@SearchWith(pageName = "companyManagement", elementName = "setAdmin_Creater", noteName = "企业设置-设置管理员-仅创建者")
	public WebElement setAdmin_Creater;
	@SearchWith(pageName = "companyManagement", elementName = "button_addCollaborators", noteName = "企业设置-谁能添加外部协作者（更改按钮）")
	public WebElement button_addCollaborators;
	@SearchWith(pageName = "companyManagement", elementName = "addCollaborators_1", noteName = "企业设置-谁能添加外部协作者-所有企业成员")
	public WebElement addCollaborators_1;
	@SearchWith(pageName = "companyManagement", elementName = "addCollaborators_2", noteName = "企业设置-谁能添加外部协作者-仅企业创建者和管理员")
	public WebElement addCollaborators_2;
	@SearchWith(pageName = "companyManagement", elementName = "addCollaborators_3", noteName = "企业设置-谁能添加外部协作者-仅企业创建者和管理员，以及文件所有者")
	public WebElement addCollaborators_3;
	@SearchWith(pageName = "companyManagement", elementName = "transferCompany", noteName = "企业设置-移交企业")
	public WebElement transferCompany;
	@SearchWith(pageName = "companyManagement", elementName = "transferCompany_button", noteName = "企业设置-移交企业-移交企业确认按钮")
	public WebElement transferCompany_button;
	@SearchWith(pageName = "companyManagement", elementName = "memberSearch", noteName = "企业设置-成员列表-搜索")
	public WebElement memberSearch;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_banUser_2", noteName = "企业设置-成员列表-移除成员-禁用")
	public WebElement xpath_banUser_2;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_banUser_ok", noteName = "企业设置-成员列表-移除成员-禁用-确认")
	public WebElement xpath_banUser_ok;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_userTab_1", noteName = "企业设置-成员列表")
	public WebElement xpath_userTab_1;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_userTab_3", noteName = "企业设置-禁用成员列表")
	public WebElement xpath_userTab_3;
	@SearchWith(pageName = "companyManagement", elementName = "button_exitCompany", noteName = "企业设置-成员退出企业")
	public WebElement button_exitCompany;
	@SearchWith(pageName = "companyManagement", elementName = "addmember_copyLink_open", noteName = "企业设置-打开或者关闭邀请链接")
	public WebElement addmember_copyLink_open;

	@SearchWith(pageName = "dashboard", elementName = "desktop_user_icon", noteName = "桌面-右上角头像")
	public WebElement desktop_user_icon;
	@SearchWith(pageName = "dashboard", elementName = "desktop_user_icon_companyManagement", noteName = "桌面-右上角头像-我的企业")
	public WebElement desktop_user_icon_companyManagement;

	// Registered
	@SearchWith(pageName = "Registered", elementName = "userName", noteName = "昵称")
	public WebElement userName;
	@SearchWith(pageName = "Registered", elementName = "userEmail", noteName = "登录邮箱")
	public WebElement Email;
	@SearchWith(pageName = "Registered", elementName = "userPwd", noteName = "密码")
	public WebElement Pwd;
	@SearchWith(pageName = "Registered", elementName = "Next", noteName = "下一步")
	public WebElement Next;

	// 桌面/工作台-菜单
	@SearchWith(pageName = "menu", elementName = "menu_newPage", noteName = "新标签页中打开")
	public WebElement menu_newPage;
	@SearchWith(pageName = "menu", elementName = "menu_shortcut", noteName = "添加到快捷方式")
	public WebElement menu_shortcut;
	@SearchWith(pageName = "menu", elementName = "menu_collection", noteName = "收藏")
	public WebElement menu_collection;
	@SearchWith(pageName = "menu", elementName = "menu_cooperation", noteName = "添加协作者")
	public WebElement menu_cooperation;
	@SearchWith(pageName = "menu", elementName = "menu_move", noteName = "移动")
	public WebElement menu_move;
	@SearchWith(pageName = "menu", elementName = "menu_rename", noteName = "重命名")
	public WebElement menu_rename;
	@SearchWith(pageName = "menu", elementName = "menu_creatCopy", noteName = "创建副本")
	public WebElement menu_creatCopy;
	@SearchWith(pageName = "menu", elementName = "menu_delete", noteName = "删除")
	public WebElement menu_delete;
	@SearchWith(pageName = "menu", elementName = "menu_mute", noteName = "消息免打扰")
	public WebElement menu_mute;
	@SearchWith(pageName = "menu", elementName = "menu_moveToFolder", noteName = "定位到所在文件夹")
	public WebElement menu_moveToFolder;
	@SearchWith(pageName = "menu", elementName = "menu_Recovery", noteName = "恢复文件")
	public WebElement menu_Recovery;
	@SearchWith(pageName = "menu", elementName = "menu_Completely_removed", noteName = "彻底删除")
	public WebElement menu_Completely_removed;
	@SearchWith(pageName = "menu", elementName = "menu_Point_Menu", noteName = "工作台-最近使用-第一个文件点点(仅有一个文件时使用)")
	public WebElement menu_Point_Menu;

	// 文档表格编辑页点点等-菜单
	@SearchWith(pageName = "file_menu", elementName = "file_menu_version", noteName = "保存版本")
	public WebElement file_menu_version;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_shortcut", noteName = "添加快捷方式")
	public WebElement file_menu_shortcut;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_collection", noteName = "添加收藏")
	public WebElement file_menu_collection;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_list", noteName = "查看目录")
	public WebElement file_menu_list;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_move", noteName = "移动")
	public WebElement file_menu_move;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_history", noteName = "查看历史")
	public WebElement file_menu_history;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_creatCopy", noteName = "创建副本")
	public WebElement file_menu_creatCopy;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_delete", noteName = "删除")
	public WebElement file_menu_delete;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_mute", noteName = "消息免打扰")
	public WebElement file_menu_mute;
	@SearchWith(pageName = "file_menu", elementName = "file_menu_msg", noteName = "文档信息")
	public WebElement file_menu_msg;
}
