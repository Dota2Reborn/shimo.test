package cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

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
	 * @Time 2017-01-08
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
	 * @Time 2017-01-08
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
	}
}
