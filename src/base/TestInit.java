package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		driver.navigate().to(test_url);
		wait = new WebDriverWait(driver, 20);
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
		printLog(className, user);

		driver.navigate().to(test_url + "login");
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		login_submit.click();
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
		login_submit.click();
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
		driver.navigate().to(test_url + "logout");
		action.sendKeys(Keys.ESCAPE);
	}

	/**
	 * 点击切换到我的桌面
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void clickDesktop() {
		desktop.click();
		String msg = desktop_order.getText();
		if (msg.equals("更新时间")) {
			desktop_order.click();
			wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
			desktop_orderByFolderUP.click();

			desktop_order.click();
			wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
			desktop_orderByDefault.click();
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
	public boolean doesWebElementExist(WebDriver driver, By selector) {

		try {
			driver.findElement(selector);
			return true;
		} catch (NoSuchElementException e) {
			return false;
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

	// homePage
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
	@SearchWith(pageName = "desktop", elementName = "desktop_newDoc", noteName = "新建文档")
	public WebElement desktop_newDoc;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_11")
	public WebElement desktop_setting_doc_11;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_ok")
	public WebElement desktop_newFolder_name_ok;
	@SearchWith(pageName = "desktop", elementName = "desktop1_1_folder")
	public WebElement desktop1_1_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_5")
	public WebElement desktop_setting_doc_5;
	@SearchWith(pageName = "desktop", elementName = "desktop1_2_folder")
	public WebElement desktop1_2_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_1_file")
	public WebElement desktop_list_1_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_2_file")
	public WebElement desktop_list_2_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_3_file")
	public WebElement desktop_list_3_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_order")
	public WebElement desktop_order;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByUpdate")
	public WebElement desktop_orderByUpdate;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByCreate")
	public WebElement desktop_orderByCreate;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByFile")
	public WebElement desktop_orderByFile;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByOwner")
	public WebElement desktop_orderByOwner;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByFolderUP")
	public WebElement desktop_orderByFolderUP;
	@SearchWith(pageName = "desktop", elementName = "desktop_orderByDefault")
	public WebElement desktop_orderByDefault;
	@SearchWith(pageName = "desktop", elementName = "desktop_newSheet")
	public WebElement desktop_newSheet;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder")
	public WebElement desktop_newFolder;
	@SearchWith(pageName = "desktop", elementName = "desktop_import")
	public WebElement desktop_import;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name")
	public WebElement desktop_newFolder_name;
	@SearchWith(pageName = "desktop", elementName = "desktop_newFolder_name_cancel")
	public WebElement desktop_newFolder_name_cancel;
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
	@SearchWith(pageName = "desktop", elementName = "desktop_setting_folder_9")
	public WebElement desktop_setting_folder_9;
	@SearchWith(pageName = "desktop", elementName = "desktop_set")
	public WebElement desktop_setting;
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

	// doc
	@SearchWith(pageName = "doc", elementName = "b_back")
	public WebElement b_back;
	@SearchWith(pageName = "doc", elementName = "quick_access_point")
	public WebElement quick_access_point;
	@SearchWith(pageName = "doc", elementName = "Back_to_Desktop")
	public WebElement Back_to_Desktop;
	@SearchWith(pageName = "doc", elementName = "doc_edit")
	public WebElement doc_edit;
	@SearchWith(pageName = "doc", elementName = "doc_notice_user")
	public WebElement doc_notice_user;
	@SearchWith(pageName = "doc", elementName = "doc_menu")
	public WebElement doc_menu;
	@SearchWith(pageName = "doc", elementName = "doc_menu_msg", noteName = "文档编辑页面中右上角 点点点-文档信息")
	public WebElement doc_menu_msg;
	@SearchWith(pageName = "doc", elementName = "doc_menu_delete")
	public WebElement doc_menu_delete;
	@SearchWith(pageName = "doc", elementName = "doc_menu_delete_OK")
	public WebElement doc_menu_delete_OK;
	@SearchWith(pageName = "doc", elementName = "doc_discuss")
	public WebElement doc_discuss;
	@SearchWith(pageName = "doc", elementName = "doc_discuss_input")
	public WebElement doc_discuss_input;
	@SearchWith(pageName = "doc", elementName = "doc_discuss_input_ok")
	public WebElement doc_discuss_input_ok;
	@SearchWith(pageName = "doc", elementName = "ql_comment_Comments")
	public WebElement ql_comment_Comments;
	@SearchWith(pageName = "doc", elementName = "Folder_settings")
	public WebElement Folder_settings;
	@SearchWith(pageName = "doc", elementName = "Exit_share_OK")
	public WebElement Exit_share_OK;
	@SearchWith(pageName = "doc", elementName = "Collection_OK", noteName = "标题栏收藏按钮")
	public WebElement Collection_OK;

	// dashboard
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_time")
	public WebElement dashboard_update_time;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_file")
	public WebElement dashboard_update_file;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_update_name")
	public WebElement dashboard_update_name;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_setting_doc_8")
	public WebElement dashboard_setting_doc_8;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_setting_doc_10")
	public WebElement dashboard_setting_doc_10;
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
	@SearchWith(pageName = "dashboard", elementName = "dashboard_1")
	public WebElement dashboard_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_2")
	public WebElement dashboard_2;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_3")
	public WebElement dashboard_3;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_4")
	public WebElement dashboard_4;
	@SearchWith(pageName = "dashboard", elementName = "dashboard")
	public WebElement dashboard;
	@SearchWith(pageName = "dashboard", elementName = "favorites")
	public WebElement favorites;
	@SearchWith(pageName = "dashboard", elementName = "trash")
	public WebElement trash;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_search_button")
	public WebElement dashboard_search_button;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_search_input")
	public WebElement dashboard_search_input;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_search_result_1")
	public WebElement dashboard_search_result_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice")
	public WebElement dashboard_notice;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_1")
	public WebElement dashboard_notice_list_1;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_1_button")
	public WebElement dashboard_notice_list_1_button;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_1_time")
	public WebElement dashboard_notice_list_1_time;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_unread")
	public WebElement dashboard_notice_list_unread;
	@SearchWith(pageName = "dashboard", elementName = "dashboard_notice_list_allRead")
	public WebElement dashboard_notice_list_allRead;

	// addCollaborator
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_close")
	public WebElement button_addCollaborator_close;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_1_list")
	public WebElement b_addCollaborator_1_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_2_list")
	public WebElement b_addCollaborator_2_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_3_list")
	public WebElement b_addCollaborator_3_list;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_1")
	public WebElement list_addCollaborator_1;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_4")
	public WebElement list_addCollaborator_4;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_total")
	public WebElement addCollaborator_total;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_1_add")
	public WebElement addCollaborator_1_add;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_companyList_2_add")
	public WebElement addCollaborator_companyList_2_add;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_company_list")
	public WebElement addCollaborator_company_list;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_back")
	public WebElement b_addCollaborator_back;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_confirm")
	public WebElement b_addCollaborator_confirm;
	@SearchWith(pageName = "addCollaborator", elementName = "list_addCollaborator_changeOwner_1")
	public WebElement list_addCollaborator_changeOwner_1;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_1_list_userName")
	public WebElement addCollaborator_1_list_userName;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_2_list_userName")
	public WebElement addCollaborator_2_list_userName;
	@SearchWith(pageName = "addCollaborator", elementName = "addCollaborator_folder_add")
	public WebElement addCollaborator_folder_add;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator")
	public WebElement button_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "input_addCollaborator")
	public WebElement input_addCollaborator;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_1_add")
	public WebElement b_addCollaborator_1_add;
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_ok")
	// 王继程3/12
	public WebElement b_addCollaborator_ok;
	@SearchWith(pageName = "addCollaborator", elementName = "Can_edit_1")
	public WebElement Can_edit_1;
	@SearchWith(pageName = "addCollaborator", elementName = "can_only_comment_2")
	public WebElement can_only_comment_2;
	@SearchWith(pageName = "addCollaborator", elementName = "can_only_read_3")
	public WebElement can_only_read_3;
	@SearchWith(pageName = "addCollaborator", elementName = "Shut_down_sm_modal_close_x")
	public WebElement Shut_down_sm_modal_close_x;

	// 企业管理
	@SearchWith(pageName = "companyManagement", elementName = "company_Management")
	public WebElement company_Management;
	@SearchWith(pageName = "companyManagement", elementName = "company_setting")
	public WebElement company_setting;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member")
	public WebElement invite_member;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_OK")
	public WebElement invite_member_OK;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_1")
	public WebElement invite_member_1;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_2")
	public WebElement invite_member_2;
	@SearchWith(pageName = "companyManagement", elementName = "invite_member_3")
	public WebElement invite_member_3;
	@SearchWith(pageName = "companyManagement", elementName = "addMember", noteName = "成员管理-添加成员按钮")
	public WebElement addMember;
	@SearchWith(pageName = "companyManagement", elementName = "address_cppy")
	public WebElement address_cppy;
	@SearchWith(pageName = "companyManagement", elementName = "message_ok")
	public WebElement message_ok;
	@SearchWith(pageName = "companyManagement", elementName = "message_warning")
	public WebElement message_warning;
	@SearchWith(pageName = "companyManagement", elementName = "button_companyName")
	public WebElement button_companyName;
	@SearchWith(pageName = "companyManagement", elementName = "input_companyName")
	public WebElement input_companyName;
	@SearchWith(pageName = "companyManagement", elementName = "text_companyName")
	public WebElement text_companyName;
	@SearchWith(pageName = "companyManagement", elementName = "setAdmin")
	public WebElement setAdmin;
	@SearchWith(pageName = "companyManagement", elementName = "setAdmin_ManagerAndCreater")
	public WebElement setAdmin_ManagerAndCreater;
	@SearchWith(pageName = "companyManagement", elementName = "setAdmin_Creater")
	public WebElement setAdmin_Creater;
	@SearchWith(pageName = "companyManagement", elementName = "button_addCollaborators")
	public WebElement button_addCollaborators;
	@SearchWith(pageName = "companyManagement", elementName = "addCollaborators_1")
	public WebElement addCollaborators_1;
	@SearchWith(pageName = "companyManagement", elementName = "addCollaborators_2")
	public WebElement addCollaborators_2;
	@SearchWith(pageName = "companyManagement", elementName = "addCollaborators_3")
	public WebElement addCollaborators_3;
	@SearchWith(pageName = "companyManagement", elementName = "transferCompany")
	public WebElement transferCompany;
	@SearchWith(pageName = "companyManagement", elementName = "transferCompany_button")
	public WebElement transferCompany_button;
	@SearchWith(pageName = "companyManagement", elementName = "memberSearch")
	public WebElement memberSearch;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_banUser_2")
	public WebElement xpath_banUser_2;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_banUser_ok")
	public WebElement xpath_banUser_ok;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_userTab_1")
	public WebElement xpath_userTab_1;
	@SearchWith(pageName = "companyManagement", elementName = "xpath_userTab_3")
	public WebElement xpath_userTab_3;
	@SearchWith(pageName = "companyManagement", elementName = "button_exitCompany")
	public WebElement button_exitCompany;
	@SearchWith(pageName = "companyManagement", elementName = "addmember_copyLink_open")
	public WebElement addmember_copyLink_open;

	@SearchWith(pageName = "dashboard", elementName = "desktop_user_icon")
	public WebElement desktop_user_icon;
	@SearchWith(pageName = "dashboard", elementName = "desktop_user_icon_companyManagement")
	public WebElement desktop_user_icon_companyManagement;

	// Registered
	@SearchWith(pageName = "Registered", elementName = "userName")
	public WebElement userName;
	@SearchWith(pageName = "Registered", elementName = "userEmail")
	public WebElement Email;
	@SearchWith(pageName = "Registered", elementName = "userPwd")
	public WebElement Pwd;
	@SearchWith(pageName = "Registered", elementName = "Next")
	public WebElement Next;
	
	//桌面/工作台-菜单
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
	
	//文档表格编辑页点点等-菜单
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
