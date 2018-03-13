package cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.google.common.base.Preconditions;

import base.TestInit;

public class testCompanyManagement extends TestInit {
	/**
	 * 谁能邀请新成员进企业-所有企业成员
	 * 
	 * @author 刘晨
	 * @Time 2017-01-08
	 *
	 */
	@Test(enabled = true)
	public void inviteMember_allMember() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();
		wait.until(ExpectedConditions.elementToBeClickable(invite_member));
		invite_member.click();
		wait.until(ExpectedConditions.elementToBeClickable(invite_member_OK));
		invite_member_1.click();
		invite_member_OK.click();

		logout();
		login("amei@qq.com", "123123");

		action.moveToElement(desktop_user_icon).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_user_icon_companyManagement));
		desktop_user_icon_companyManagement.click();
		wait.until(ExpectedConditions.elementToBeClickable(addMember));
		addMember.click();

		wait.until(ExpectedConditions.elementToBeClickable(address_cppy));
		Boolean clickAble = address_cppy.isDisplayed();

		assertTrue(clickAble);
	}

	/**
	 * 谁能邀请新成员进企业-仅企业创建者和管理员
	 * 
	 * @author 刘晨
	 * @Time 2017-01-08
	 *
	 */
	@Test(enabled = true)
	public void inviteMember_ManagerAndCreater() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();
		wait.until(ExpectedConditions.elementToBeClickable(invite_member));
		invite_member.click();
		wait.until(ExpectedConditions.elementToBeClickable(invite_member_OK));
		invite_member_2.click();
		invite_member_OK.click();

		logout();
		login("amei@qq.com", "123123");

		action.moveToElement(desktop_user_icon).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_user_icon_companyManagement));
		desktop_user_icon_companyManagement.click();
		wait.until(ExpectedConditions.elementToBeClickable(addMember));
		addMember.click();
		wait.until(ExpectedConditions.elementToBeClickable(message_ok));

		String msg = message_warning.getText();
		assertEquals(msg, "没有权限，请联系企业管理员添加");
	}

	/**
	 * 谁能邀请新成员进企业-仅企业创建者
	 * 
	 * @author 刘晨
	 * @Time 2017-01-08
	 *
	 */
	@Test(enabled = true)
	public void inviteMember_JustByCreater() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();
		wait.until(ExpectedConditions.elementToBeClickable(invite_member));
		invite_member.click();
		wait.until(ExpectedConditions.elementToBeClickable(invite_member_OK));
		invite_member_3.click();
		invite_member_OK.click();

		logout();
		login("pipi@qq.com", "123123");

		action.moveToElement(desktop_user_icon).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_user_icon_companyManagement));
		desktop_user_icon_companyManagement.click();
		wait.until(ExpectedConditions.elementToBeClickable(addMember));
		addMember.click();
		wait.until(ExpectedConditions.elementToBeClickable(message_ok));

		String msg = message_warning.getText();
		assertEquals(msg, "没有权限，请联系企业创建者添加");
	}

	/**
	 * 谁能邀请新成员进企业-仅企业创建者
	 * 
	 * @author 刘晨
	 * @Time 2017-01-08
	 *
	 */
	@Test(enabled = true)
	public void inviteMember_changeCompanyName() throws InterruptedException {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);

		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();
		wait.until(ExpectedConditions.elementToBeClickable(button_companyName));
		button_companyName.click();
		wait.until(ExpectedConditions.elementToBeClickable(message_ok));
		input_companyName.clear();
		input_companyName.sendKeys(time);
		message_ok.click();

		wait.until(ExpectedConditions.textToBePresentInElement(text_companyName, time));
		String companyName = text_companyName.getText();

		assertEquals("您的企业名称为 " + time, companyName);

	}

	/**
	 * 谁能设置管理员-仅企业创建者
	 * 
	 * @author 刘晨
	 * @Time 2017-01-08
	 *
	 */
	@Test(enabled = true)
	public void setManager_Creater() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();
		wait.until(ExpectedConditions.elementToBeClickable(setAdmin));
		setAdmin.click();
		wait.until(ExpectedConditions.elementToBeClickable(setAdmin_Creater));
		setAdmin_Creater.click();
		message_ok.click();

		logout();
		login("pipi@qq.com", "123123");

		action.moveToElement(desktop_user_icon).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_user_icon_companyManagement));
		desktop_user_icon_companyManagement.click();
		wait.until(ExpectedConditions.elementToBeClickable(addMember));

		List<WebElement> elements = driver.findElements(By.className("member-row"));
		int number = elements.size(); // 成员列表
		String kk;
		String pp;
		int n = 1;
		for (int i = 1; i <= number; i++) {
			kk = "//div[@class='waterfall-inner']//div[" + i + "]//div[@class='action']//div//div[1]//span[1]";
			pp = driver.findElement(By.xpath(kk)).getText();
			if (pp.equals("成员")) {
				n = i;
				break;
			}
		}

		String ii = "//div[@class='waterfall-inner']//div[" + n + "]//div[@class='action']";
		String jj = "//div[@class='waterfall-inner']//div[" + n + "]//div[@class='action']//div//div[2]//span[1]";
		driver.findElement(By.xpath(ii)).click();
		String text = "";
		text = driver.findElement(By.xpath(jj)).getText();
		System.out.println(text);

		assertEquals("移除成员", text);
	}

	/**
	 * 谁能设置管理员-仅企业创建者和管理者
	 * 
	 * @author 刘晨
	 * @Time 2018-03-05
	 *
	 */
	@Test(enabled = true)
	public void setManager_ManagerAndCreater() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();
		wait.until(ExpectedConditions.elementToBeClickable(setAdmin));
		setAdmin.click();
		wait.until(ExpectedConditions.elementToBeClickable(setAdmin_Creater));
		setAdmin_ManagerAndCreater.click();
		message_ok.click();

		logout();
		login("pipi@qq.com", "123123");

		action.moveToElement(desktop_user_icon).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_user_icon_companyManagement));
		desktop_user_icon_companyManagement.click();
		wait.until(ExpectedConditions.elementToBeClickable(addMember));

		List<WebElement> elements = driver.findElements(By.className("member-row"));
		int number = elements.size(); // 成员列表
		String kk;
		String pp;
		int n = 1;
		for (int i = 1; i <= number; i++) {
			kk = "//div[@class='waterfall-inner']//div[" + i + "]//div[@class='action']//div//div[1]//span[1]";
			pp = driver.findElement(By.xpath(kk)).getText();
			if (pp.equals("成员")) {
				n = i;
				break;
			}
		}

		String ii = "//div[@class='waterfall-inner']//div[" + n + "]//div[@class='action']";
		String jj = "//div[@class='waterfall-inner']//div[" + n + "]//div[@class='action']//div//div[2]//span[1]";
		driver.findElement(By.xpath(ii)).click();
		String text = "";
		text = driver.findElement(By.xpath(jj)).getText();
		System.out.println(text);

		assertEquals("设置为管理员", text);
	}

	/**
	 * 谁能添加外部协作者-仅企业创建者和管理员
	 * 
	 * @author 刘晨
	 * @Time 2018-03-05
	 *
	 */
	@Test(enabled = true)
	public void addCollaborators_ManagerAndCreater() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();
		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborators));
		button_addCollaborators.click();
		wait.until(ExpectedConditions.elementToBeClickable(addCollaborators_2));
		addCollaborators_2.click();
		message_ok.click();

		logout();
		login("amei@qq.com", "123123");

		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		// b_addCollaborator_1_add.click();

		String t = b_addCollaborator_1_add.getAttribute("disabled");
		Boolean R1 = t.equals("true");

		logout();
		login("pipi@qq.com", "123123");

		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();

		Thread.sleep(500);
		String m1 = driver.findElement(By.className("sm-toast")).getText();
		Boolean R2 = m1.equals("成功添加 1 个协作者");

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		b_addCollaborator_2_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_4));
		list_addCollaborator_4.click();

		assertTrue(R1 && R2);
	}

	/**
	 * 谁能添加外部协作者-全体成员
	 * 
	 * @author 刘晨
	 * @Time 2018-03-05
	 *
	 */
	@Test(enabled = true)
	public void addCollaborators_all() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();
		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborators));
		button_addCollaborators.click();
		wait.until(ExpectedConditions.elementToBeClickable(addCollaborators_1));
		addCollaborators_1.click();
		message_ok.click();

		logout();
		login("amei@qq.com", "123123");

		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();

		Thread.sleep(500);
		String m1 = driver.findElement(By.className("sm-toast")).getText();
		Boolean R2 = m1.equals("成功添加 1 个协作者");

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		b_addCollaborator_2_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_4));
		list_addCollaborator_4.click();

		assertTrue(R2);
	}

	/**
	 * 谁能添加外部协作者-作者，企业创建者和管理员
	 * 
	 * @author 刘晨
	 * @Time 2018-03-06
	 *
	 */
	@Test(enabled = true)
	public void addCollaborators_ownerManagerAndCreater() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();
		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborators));
		button_addCollaborators.click();
		wait.until(ExpectedConditions.elementToBeClickable(addCollaborators_3));
		addCollaborators_3.click();
		message_ok.click();

		logout();
		login("shimo03@sina.com", "123123");

		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		
		Boolean R1 = b_addCollaborator_1_add.getAttribute("disabled").equalsIgnoreCase("true");

		logout();
		login("amei@qq.com", "123123");

		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();

		Thread.sleep(500);
		String m1 = driver.findElement(By.className("sm-toast")).getText();
		Boolean R2 = m1.equals("成功添加 1 个协作者");

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_2_list));
		b_addCollaborator_2_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_4));
		list_addCollaborator_4.click();

		logout();
		login("pipi@qq.com", "123123");

		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();

		Thread.sleep(500);
		String m2 = driver.findElement(By.className("sm-toast")).getText();
		Boolean R3 = m2.equals("成功添加 1 个协作者");

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_2_list));
		b_addCollaborator_2_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_4));
		list_addCollaborator_4.click();

		assertTrue(R1 && R2 && R3);
	}

	/**
	 * 移交企业
	 * 
	 * @author 刘晨
	 * @Time 2018-03-06
	 *
	 */
	@Test(enabled = true)
	public void transferCompany() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();

		Preconditions.checkArgument(transferCompany.isDisplayed(), "Creater is not panpan");
		wait.until(ExpectedConditions.elementToBeClickable(transferCompany));
		transferCompany.click();

		wait.until(ExpectedConditions.elementToBeClickable(transferCompany_button));
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-list']//div[@class='ui-list-row']"));
		int number = elements.size();

		String kk;
		String pp;
		int n = 1;
		for (int i = 1; i <= number; i++) {
			kk = "//div[@class='ui-list']//div[" + i + "]//div//span[1]";
			pp = driver.findElement(By.xpath(kk)).getText();
			if (pp.equals("pipi")) {
				n = i;
				break;
			}
		}

		driver.findElement(By.xpath("//div[@class='ui-list']//div[" + n + "]//div//span[1]")).click();
		transferCompany_button.click();

		Thread.sleep(500);
		Boolean R1 = transferCompany.isDisplayed();

		logout();
		login("pipi@qq.com", "123123");

		company_Management.click();
		switchToPage(2);
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();

		wait.until(ExpectedConditions.elementToBeClickable(transferCompany));
		transferCompany.click();

		wait.until(ExpectedConditions.elementToBeClickable(transferCompany_button));
		elements = driver.findElements(By.xpath("//div[@class='ui-list']//div[@class='ui-list-row']"));
		number = elements.size();

		n = 1;
		for (int i = 1; i <= number; i++) {
			kk = "//div[@class='ui-list']//div[" + i + "]//div//span[1]";
			pp = driver.findElement(By.xpath(kk)).getText();
			if (pp.equals("panpan")) {
				n = i;
				break;
			}
		}

		driver.findElement(By.xpath("//div[@class='ui-list']//div[" + n + "]//div//span[1]")).click();
		transferCompany_button.click();

		Thread.sleep(500);
		Boolean R2 = transferCompany.isDisplayed();
		assertFalse(R1 && R2);
	}
	
	/**
	 * 企业管理-成员列表-搜索
	 * 
	 * @author 刘晨
	 * @Time 2018-03-06
	 *
	 */
	@Test(enabled = true)
	public void memberSearch() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		memberSearch.sendKeys("刘晨");
		
		Thread.sleep(500);
		String user = driver.findElement(By.xpath("//div[@class='name']")).getText();

		assertEquals(user, "刘晨");
	}
	
	/**
	 * 企业管理-成员列表-禁用成员
	 * 
	 * @author 刘晨
	 * @Time 2018-03-06
	 *
	 */
	@Test(enabled = true)
	public void banUser() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		
		List<WebElement> elements = driver.findElements(By.className("email"));
		int number = elements.size(); // 成员列表
		String kk;
		String pp;
		int n = 1;
		for (int i = 1; i <= number; i++) {
			kk = "//div[@class='waterfall-inner']//div[" + i + "]//div[@class='email']";
			pp = driver.findElement(By.xpath(kk)).getText();
			if (pp.equals("shimo0724@sina.com")) {
				n = i;
				break;
			}
		}

		String aa = "//div[@class='waterfall-inner']//div[" + n
				+ "]//div[@class='action']//div//div[@class='dropdown-toggle']";
		String bb = "//div[@class='waterfall-inner']//div[" + n
				+ "]//div[@class='action']//div//div[@class='dropdown-menu dropdown-menu-right']//span[@class='dropdown-item red']";

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(aa)));
		driver.findElement(By.xpath(aa)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bb)));
		driver.findElement(By.xpath(bb)).click();
		
		xpath_banUser_2.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_banUser_ok));
		xpath_banUser_ok.click();
//		Thread.sleep(3000);
		
		wait.until(ExpectedConditions.elementToBeClickable(xpath_userTab_3));
		xpath_userTab_3.click();

		String cc = "//div[@class='member-list']//div[1]//div[@class='action']//div//div[@class='dropdown-toggle']";
		String dd = "//div[@class='member-list']//div[1]//div[@class='action']//div//div[@class='dropdown-menu dropdown-menu-right']//span";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cc)));
		driver.findElement(By.xpath(cc)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dd)));
		driver.findElement(By.xpath(dd)).click();

		xpath_userTab_1.click();
		Thread.sleep(500);

		elements = driver.findElements(By.className("email"));
		number = elements.size(); // 成员列表
		Boolean result = false;
		for (int i = 1; i <= number; i++) {
			kk = "//div[@class='waterfall-inner']//div[" + i + "]//div[@class='email']";
			pp = driver.findElement(By.xpath(kk)).getText();
			if (pp.equals("shimo0724@sina.com")) {
				result = true;
				break;
			}
		}
		assertTrue(result);
	}
	
	/**
	 * 企业管理-加入/退出企业
	 * 
	 * @author 刘晨
	 * @Time 2018-03-06
	 *
	 */
	@Test(enabled = true)
	public void exitCompany() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		
		wait.until(ExpectedConditions.elementToBeClickable(addMember));
		addMember.click();
		String xpath_email = "//div[@class='tab-head-wrap']//div[2]";
		driver.findElement(By.xpath(xpath_email)).click();
		Thread.sleep(1000);
		String xpath_emailInvite = "//div[@class='invitation-email-panel']//div//input";
		driver.findElement(By.xpath(xpath_emailInvite)).sendKeys("testQiYe@qq.com");
		String xpath_email1 = "//div[@class='share-user-li invitation-user-li']//span[2]";
		wait.until(ExpectedConditions.textToBe(By.xpath(xpath_email1), "testQiYe@qq.com"));
		String xpath_emailSelect = "//div[@class='ui-list']//div[1]";
		driver.findElement(By.xpath(xpath_emailSelect)).click();
		String xpath_sendInvite = "//button[@class='sm-btn sm-btn-primary ']";
		driver.findElement(By.xpath(xpath_sendInvite)).click();

		String xpath_msg = "//div[@class='title']//span";
		Thread.sleep(500);
		Boolean R1 = driver.findElement(By.xpath(xpath_msg)).getText().equals("成功邀请 1 人");
		
		logout();
		login("testQiYe@qq.com", "123123");
		
		action.moveToElement(dashboard_notice).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1_button));
		// String msg = dashboard_notice_list_1_time.getText();
		dashboard_notice_list_1_button.click();
		wait.until(ExpectedConditions.elementToBeClickable(company_setting));
		company_setting.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_exitCompany));
		button_exitCompany.click();
		wait.until(ExpectedConditions.elementToBeClickable(transferCompany_button));
		transferCompany_button.click();

		Thread.sleep(500);
		Boolean R2 = driver.findElement(By.xpath(xpath_msg)).getText().equals("操作成功");
		
		assertTrue(R1 && R2);
	}
	
	/**
	 * 企业管理-开启/关闭企业邀请链接
	 * 
	 * @author 刘晨
	 * @Time 2018-03-13
	 *
	 */
	@Test(enabled = true)
	public void copyLink() throws InterruptedException {
		login("panpan@qq.com", "123123");
		company_Management.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(addMember));
		addMember.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("close-invitation-link")));
		Boolean R1 = driver.findElement(By.className("close-invitation-link")).getText().equals("开启链接");
	}
}
