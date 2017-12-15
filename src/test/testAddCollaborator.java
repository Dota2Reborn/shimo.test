package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
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

public class testAddCollaborator {
	public WebDriver driver = null;
	WebDriverWait wait;
	String test_url;
	baseFunc init = new baseFunc();

	public testAddCollaborator() {

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
		System.out.println("--------------------------------------------");
	}

	@AfterClass
	public void lastMethod() {
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
	 * 基础版用户，文件协作者为5人，不能继续添加协作者
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_1() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_2_list));
		Boolean exist = button_addCollaborator.isEnabled();

		assertFalse(exist);
	}

	/**
	 * 通过输入邮箱地址添加协作者，并且在协作者列表中移除该协作者
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_2() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");
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

	/**
	 * 通过【最近】列表中的第一个添加为协作者
	 * 
	 * @author 刘晨
	 * @Time 2017-11-29
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_3() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");
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
		String msg_a = addCollaborator_total.getText();
		button_addCollaborator.click();

		wait.until(ExpectedConditions.elementToBeClickable(addCollaborator_1_add));
		addCollaborator_1_add.click();

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

	/**
	 * 通过【企业成员】列表中的第二个添加为协作者
	 * 
	 * @author 刘晨
	 * @Time 2017-11-29
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_4() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");
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
		String msg_a = addCollaborator_total.getText();
		button_addCollaborator.click();

		wait.until(ExpectedConditions.elementToBeClickable(addCollaborator_company_list));
		addCollaborator_company_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(addCollaborator_companyList_2_add));
		addCollaborator_companyList_2_add.click();

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

	/**
	 * 点击协作者列表中添加协作者之后，不点击确定，点击返回，协作者不会被添加
	 * 
	 * @author 刘晨
	 * @Time 2017-11-29
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_5() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");
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
		String msg_a = addCollaborator_total.getText();
		button_addCollaborator.click();

		wait.until(ExpectedConditions.elementToBeClickable(addCollaborator_1_add));
		addCollaborator_1_add.click();

		b_addCollaborator_back.click();
		Thread.sleep(500);
		String msg_b = addCollaborator_total.getText();

		assertEquals(msg_a, msg_b);
	}

	/**
	 * 协作者在协作者列表中移除自己
	 * 
	 * @author 刘晨
	 * @Time 2017-12-01
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_6() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");
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

		input_addCollaborator.sendKeys("autoTest04@shimo.im");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();

		logout();
		login("autoTest04@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg1 = desktop_show_type.getText();
		if (msg1.equals("平铺")) {
			desktop_show_type.click();
		}

		action = new Actions(driver);
		action.contextClick(desktop1_1_folder).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_2_list));
		b_addCollaborator_2_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_4));
		list_addCollaborator_4.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_confirm));
		b_addCollaborator_confirm.click();

		Thread.sleep(500);
		String fileName = desktop1_1_folder.getText();
		assertNotEquals(fileName, "添加协作者测试");
	}

	/**
	 * 作为协作者添加协作者
	 * 
	 * @author 刘晨
	 * @Time 2017-12-01
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_7() throws InterruptedException {
		login("autoTest03@shimo.im", "123123");
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

		input_addCollaborator.sendKeys("autoTest04@shimo.im");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();

		logout();
		login("autoTest04@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg1 = desktop_show_type.getText();
		if (msg1.equals("平铺")) {
			desktop_show_type.click();
		}

		action = new Actions(driver);
		action.contextClick(desktop1_1_folder).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_2_list));
		b_addCollaborator_2_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_4));
		list_addCollaborator_4.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_confirm));
		b_addCollaborator_confirm.click();

		Thread.sleep(500);
		String fileName = desktop1_1_folder.getText();
		assertNotEquals(fileName, "添加协作者测试");
	}

	/**
	 * 企业成员之间转让所有权
	 * 
	 * @author 刘晨
	 * @Time 2017-12-01
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_8() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		Actions action = new Actions(driver);
		action.contextClick(desktop1_1_folder).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_list));
		b_addCollaborator_1_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_1));
		list_addCollaborator_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_changeOwner_1));
		list_addCollaborator_changeOwner_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_confirm));
		b_addCollaborator_confirm.click();
		Thread.sleep(500);

		logout();
		login("autoTest03@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg1 = desktop_show_type.getText();
		if (msg1.equals("平铺")) {
			desktop_show_type.click();
		}

		action = new Actions(driver);
		action.contextClick(desktop1_1_folder).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_list));
		b_addCollaborator_1_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_1));
		list_addCollaborator_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_changeOwner_1));
		list_addCollaborator_changeOwner_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_confirm));
		b_addCollaborator_confirm.click();
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_list));

		String email = addCollaborator_1_list_userName.getText();
		assertEquals(email, "autoTest01");
	}

	/**
	 * 通过文件夹右侧添加协作者
	 * 
	 * @author 刘晨
	 * @Time 2017-12-07
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_9() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		desktop1_1_folder.click();

		wait.until(ExpectedConditions.elementToBeClickable(addCollaborator_folder_add));
		addCollaborator_folder_add.click();

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
		String username = addCollaborator_2_list_userName.getText();
		assertNotEquals(username, "李磊");

	}

	/**
	 * 非企业成员之间转让所有权
	 * 
	 * @author 刘晨
	 * @Time 2017-12-07
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_10() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		Actions action = new Actions(driver);
		action.contextClick(desktop1_2_folder).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_list));
		b_addCollaborator_1_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_1));
		list_addCollaborator_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_changeOwner_1));
		list_addCollaborator_changeOwner_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_confirm));
		b_addCollaborator_confirm.click();

		Thread.sleep(500);

		logout();
		login("autoTest_addCollabor@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg1 = desktop_show_type.getText();
		if (msg1.equals("平铺")) {
			desktop_show_type.click();
		}

		action = new Actions(driver);
		action.contextClick(desktop1_1_folder).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_list));
		b_addCollaborator_1_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_1));
		list_addCollaborator_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_changeOwner_1));
		list_addCollaborator_changeOwner_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_confirm));
		b_addCollaborator_confirm.click();
		// wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_list));
		Thread.sleep(500);

		String email = addCollaborator_1_list_userName.getText();
		assertEquals(email, "autoTest01");
	}

	/**
	 * 桌面排序as更新时间
	 * 
	 * @author 刘晨
	 * @Time 2017-11-28
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byUpdate() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByUpdate));
		desktop_orderByUpdate.click();

		Boolean f1 = desktop_list_1_file.getText().equals("最近更新");
		Boolean f2 = desktop_list_2_file.getText().equals("最新创建");
		Boolean f3 = desktop_list_3_file.getText().equals("111");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}

	/**
	 * 桌面排序as创建时间
	 * 
	 * @author 刘晨
	 * @Time 2017-11-28
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byCreate() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByCreate));
		desktop_orderByCreate.click();

		Boolean f1 = desktop_list_1_file.getText().equals("最新创建");
		Boolean f2 = desktop_list_2_file.getText().equals("111");
		Boolean f3 = desktop_list_3_file.getText().equals("最近更新");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}

	/**
	 * 桌面排序as文件名
	 * 
	 * @author 刘晨
	 * @Time 2017-11-28
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byFileName() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFile));
		desktop_orderByFile.click();
		Thread.sleep(600);

		Boolean f1 = desktop_list_1_file.getText().equals("111");
		Boolean f2 = desktop_list_2_file.getText().equals("表格排序");
		Boolean f3 = desktop_list_3_file.getText().startsWith("所有者排序");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}

	/**
	 * 桌面排序as所有者
	 * 
	 * @author 刘晨
	 * @Time 2017-11-28
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byOwner() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByOwner));
		desktop_orderByOwner.click();

		Boolean f1 = desktop_list_1_file.getText().startsWith("所有者排序");
		Boolean f2 = desktop_list_2_file.getText().equals("最新创建");
		Boolean f3 = desktop_list_3_file.getText().equals("111");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}

	/**
	 * 桌面排序as文件夹置顶
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byFolderUP() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
		desktop_orderByFolderUP.click();

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByCreate));
		desktop_orderByCreate.click();

		Boolean f1 = desktop_list_1_file.getText().equals("文件夹排序");
		Boolean f2 = desktop_list_2_file.getText().equals("最新创建");
		Boolean f3 = desktop_list_3_file.getText().equals("111");

		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
		desktop_orderByFolderUP.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

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
	@SearchWith(pageName = "desktop", elementName = "desktop1_2_folder")
	public WebElement desktop1_2_folder;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_1_file")
	public WebElement desktop_list_1_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_2_file")
	public WebElement desktop_list_2_file;
	@SearchWith(pageName = "desktop", elementName = "desktop_list_3_file")
	public WebElement desktop_list_3_file;

	@SearchWith(pageName = "desktop", elementName = "desktop_setting_doc_5")
	public WebElement desktop_setting_doc_5;

	@SearchWith(pageName = "desktop", elementName = "desktop_show_type")
	public WebElement desktop_show_type;
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

	@SearchWith(pageName = "homePage", elementName = "userEmail")
	public WebElement userEmail;
	@SearchWith(pageName = "homePage", elementName = "userPwd")
	public WebElement userPwd;
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
	@SearchWith(pageName = "addCollaborator", elementName = "b_addCollaborator_ok")
	public WebElement b_addCollaborator_ok;
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

}
