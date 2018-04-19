package cases.management;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

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
		click(company_Management);
		switchToPage(1);
		click(company_setting);
		click(invite_member);
		click(invite_member_1);
		click(invite_member_OK);

		logout();
		login("amei@qq.com", "123123");

		moveToElement(desktop_user_icon);
		click(desktop_user_icon_companyManagement);
		click(addMember);

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
		click(company_Management);
		switchToPage(1);
		click(company_setting);
		click(invite_member);
		click(invite_member_2);
		click(invite_member_OK);

		logout();
		login("amei@qq.com", "123123");

		moveToElement(desktop_user_icon);
		click(desktop_user_icon_companyManagement);
		click(addMember);
		wait.until(ExpectedConditions.elementToBeClickable(message_ok));

		String msg = getText(message_warning);
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
		click(company_Management);
		switchToPage(1);
		click(company_setting);
		click(invite_member);
		click(invite_member_3);
		click(invite_member_OK);

		logout();
		login("pipi@qq.com", "123123");

		moveToElement(desktop_user_icon);
		click(desktop_user_icon_companyManagement);
		click(addMember);
		wait.until(ExpectedConditions.elementToBeClickable(message_ok));

		String msg = getText(message_warning);
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
		String time = getDate();

		login("panpan@qq.com", "123123");
		click(company_Management);
		switchToPage(1);
		click(company_setting);
		click(button_companyName);
		wait.until(ExpectedConditions.elementToBeClickable(message_ok));
		input_companyName.clear();
		input_companyName.sendKeys(time);
		click(message_ok);

		wait.until(ExpectedConditions.textToBePresentInElement(text_companyName, time));
		String companyName = getText(text_companyName);

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
		click(company_Management);
		switchToPage(1);
		click(company_setting);
		click(setAdmin);
		click(setAdmin_Creater);
		click(message_ok);

		logout();
		login("pipi@qq.com", "123123");

		moveToElement(desktop_user_icon);
		click(desktop_user_icon_companyManagement);
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
		click(company_Management);
		switchToPage(1);
		click(company_setting);
		click(setAdmin);
		click(setAdmin_ManagerAndCreater);
		click(message_ok);

		logout();
		login("pipi@qq.com", "123123");

		moveToElement(desktop_user_icon);
		click(desktop_user_icon_companyManagement);
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
		click(company_Management);
		switchToPage(1);
		click(company_setting);
		click(button_addCollaborators);
		click(addCollaborators_2);
		click(message_ok);

		logout();
		login("amei@qq.com", "123123");

		click(desktop);

		contextClick(desktop1_1);
		click(menu_cooperation);
		click(button_addCollaborator);

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));

		String t = b_addCollaborator_1_add.getAttribute("disabled");
		Boolean R1 = t.equals("true");

		logout();
		login("pipi@qq.com", "123123");

		click(desktop);

		contextClick(desktop1_1);
		click(menu_cooperation);
		click(button_addCollaborator);

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		click(b_addCollaborator_1_add);
		click(b_addCollaborator_ok);

		Thread.sleep(500);
		String m1 = driver.findElement(By.className("sm-toast")).getText();
		Boolean R2 = m1.equals("成功添加 1 个协作者");

		click(b_addCollaborator_2_list);
		click(list_addCollaborator_4);

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
		click(company_Management);
		switchToPage(1);
		click(company_setting);
		click(button_addCollaborators);
		click(addCollaborators_1);
		click(message_ok);

		logout();
		login("amei@qq.com", "123123");

		click(desktop);
		contextClick(desktop1_1);
		click(menu_cooperation);
		click(button_addCollaborator);

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		click(b_addCollaborator_1_add);
		click(b_addCollaborator_ok);

		Thread.sleep(500);
		String m1 = driver.findElement(By.className("sm-toast")).getText();
		Boolean R2 = m1.equals("成功添加 1 个协作者");

//		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		click(b_addCollaborator_2_list);
		click(list_addCollaborator_4);

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
		click(company_Management);
		switchToPage(1);
		click(company_setting);
		click(button_addCollaborators);
		click(addCollaborators_3);
		click(message_ok);

		logout();
		login("shimo03@sina.com", "123123");

		click(desktop);
		contextClick(desktop1_1);
		click(menu_cooperation);
		click(button_addCollaborator);

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));

		Boolean R1 = b_addCollaborator_1_add.getAttribute("disabled").equalsIgnoreCase("true");

		logout();
		login("amei@qq.com", "123123");

		click(desktop);
		contextClick(desktop1_1);
		click(menu_cooperation);
		click(button_addCollaborator);

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		click(b_addCollaborator_1_add);
		click(b_addCollaborator_ok);
		Thread.sleep(500);
		String m1 = driver.findElement(By.className("sm-toast")).getText();
		Boolean R2 = m1.equals("成功添加 1 个协作者");

		click(b_addCollaborator_2_list);
		click(list_addCollaborator_4);

		logout();
		login("pipi@qq.com", "123123");

		click(desktop);

		contextClick(desktop1_1);
		click(menu_cooperation);
		click(button_addCollaborator);

		input_addCollaborator.sendKeys("erdan@qq.com");
		Thread.sleep(500);
		click(b_addCollaborator_1_add);
		click(b_addCollaborator_ok);

		Thread.sleep(500);
		String m2 = driver.findElement(By.className("sm-toast")).getText();
		Boolean R3 = m2.equals("成功添加 1 个协作者");

		click(b_addCollaborator_2_list);
		click(list_addCollaborator_4);

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
		click(company_Management);
		switchToPage(1);
		click(company_setting);

		Preconditions.checkArgument(transferCompany.isDisplayed(), "Creater is not panpan");
		click(transferCompany);

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
		click(transferCompany_button);

		Thread.sleep(500);
		Boolean R1 = transferCompany.isDisplayed();

		logout();
		login("pipi@qq.com", "123123");

		click(company_Management);
		switchToPage(2);
		click(company_setting);
		click(transferCompany);

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
		click(transferCompany_button);

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
		click(company_Management);
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
		click(company_Management);
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

		click(xpath_banUser_2);
		click(xpath_banUser_ok);
		driver.navigate().refresh();
		click(xpath_userTab_3);

		String cc = "//div[@class='member-list']//div[1]//div[@class='action']//div//div[@class='dropdown-toggle']";
		String dd = "//div[@class='member-list']//div[1]//div[@class='action']//div//div[@class='dropdown-menu dropdown-menu-right']//span";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cc)));
		driver.findElement(By.xpath(cc)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dd)));
		driver.findElement(By.xpath(dd)).click();

		click(xpath_userTab_1);
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
		click(company_Management);
		switchToPage(1);

		click(addMember);
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

		moveToElement(dashboard_notice);
		click(dashboard_notice_list_1_button);
		click(company_setting);

		click(button_exitCompany);
		click(transferCompany_button);

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
		click(company_Management);
		switchToPage(1);
		click(addMember);
		wait.until(ExpectedConditions.elementToBeClickable(addmember_copyLink_open));
		Boolean R1 = addmember_copyLink_open.getText().equals("开启链接");
		// TODO
		click(addmember_copyLink_open);
		Thread.sleep(100);
		if (R1.equals(true)) {
			Boolean R2 = address_cppy.getAttribute("class").equals("sm-btn sm-btn-primary invitation-link-copy");
			assertTrue(R2);
		} else {
			Boolean R2 = address_cppy.getAttribute("class")
					.equals("sm-btn sm-btn-primary invitation-link-copy disable");
			assertTrue(R2);
		}

	}

	/**
	 * 企业管理-不输入邮箱，点击发送邀请
	 * 
	 * @author 刘晨
	 * @Time 2018-03-20
	 *
	 */
	@Test(enabled = true)
	public void addMember() throws InterruptedException {
		login("panpan@qq.com", "123123");
		click(company_Management);
		switchToPage(1);
		click(addMember);
		String xpath_email = "//div[@class='tab-head-wrap']//div[2]";
		driver.findElement(By.xpath(xpath_email)).click();
		Thread.sleep(1000);
		String xpath_sendInvite = "//button[@class='sm-btn sm-btn-primary ']";
		driver.findElement(By.xpath(xpath_sendInvite)).click();

		String xpath_msg = "//div[@class='title']//span";
		Thread.sleep(500);
		Boolean R1 = driver.findElement(By.xpath(xpath_msg)).getText().equals("请输入正确的邮箱");

		assertTrue(R1);
	}

	/**
	 * 企业管理-试图邀请一个已经存在于企业中的用户
	 * 
	 * @author 刘晨
	 * @Time 2018-03-06
	 *
	 */
	@Test(enabled = true)
	public void addMember_1() throws InterruptedException {
		login("panpan@qq.com", "123123");
		click(company_Management);
		switchToPage(1);

		click(addMember);
		String xpath_email = "//div[@class='tab-head-wrap']//div[2]";
		driver.findElement(By.xpath(xpath_email)).click();
		Thread.sleep(500);
		String xpath_emailInvite = "//div[@class='invitation-email-panel']//div//input";
		driver.findElement(By.xpath(xpath_emailInvite)).sendKeys("pipi@qq.com");
		Thread.sleep(500);
		String msg = driver.findElement(By.xpath("//span[@class='share-user-email ellipsis invitation-user-email']"))
				.getText();
		System.out.println(msg);
		assertEquals(msg, "pipi@qq.com（已是企业成员）");
	}

	/**
	 * 企业管理-点击企业创建者，展开下拉操作账号设置，点击账号设置
	 * 
	 * @author 刘晨
	 * @Time 2018-03-20
	 *
	 */
	@Test(enabled = true)
	public void member_setting() throws InterruptedException {
		login("panpan@qq.com", "123123");
		click(company_Management);
		switchToPage(1);
		String xpath_setting = "//div[@class='waterfall-inner']//div[1]//div[@class='action']";

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_setting)));
		driver.findElement(By.xpath(xpath_setting)).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//a[contains(text(),'帐号设置')]")).click();

		Boolean R1 = driver.getCurrentUrl().contains("/profile");
		assertTrue(R1);
	}
}
