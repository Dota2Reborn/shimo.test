package cases;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testNotice extends TestInit {
	/**
	 * 通知中收到被@消息，点击跳转
	 * 
	 * @author 刘晨
	 * @Time 2018-01-09
	 *
	 */
	@Test(enabled = true)
	public void notice_1() throws InterruptedException {
		login("autoTest11@shimo.im", "123123");
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		desktop1_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.clear();
		doc_edit.sendKeys("@autoTest12");
		wait.until(ExpectedConditions.elementToBeClickable(doc_notice_user));
		doc_notice_user.click();

		b_back.click();
		logout();
		login("autoTest12@shimo.im", "123123");
		action.moveToElement(dashboard_notice).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1));
		// String msg = dashboard_notice_list_1_time.getText();
		dashboard_notice_list_1.click();

		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://release.shimodev.com/docs/MQHNJBqnsUQUPuYV");
	}

	/**
	 * 点击通知中全部已读
	 * 
	 * @author 刘晨
	 * @Time 2018-01-09
	 *
	 */
	@Test(enabled = true)
	public void notice_2() throws InterruptedException {
		login("autoTest11@shimo.im", "123123");
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		desktop1_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.clear();
		doc_edit.sendKeys("@autoTest12");
		wait.until(ExpectedConditions.elementToBeClickable(doc_notice_user));
		doc_notice_user.click();

		b_back.click();
		logout();
		login("autoTest12@shimo.im", "123123");
		action.moveToElement(dashboard_notice).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1));

		String msg1 = dashboard_notice_list_unread.getText();
		dashboard_notice_list_allRead.click();
		String msg2 = dashboard_notice_list_unread.getText();

		assertFalse(msg1.equals(msg2));
	}

	/**
	 * 点击文档添加协作通知，跳转到通知对应文档
	 * 
	 * @author 刘晨
	 * @Time 2018-01-09
	 *
	 */
	@Test(enabled = true)
	public void notice_3() throws InterruptedException {
		login("autoTest13@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("autoTest12@shimo.im");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();
		// Thread.sleep(500);

		logout();
		login("autoTest12@shimo.im", "123123");
		action.moveToElement(dashboard_notice).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1));
		dashboard_notice_list_1.click();

		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(doc_menu));
		doc_menu.click();
		wait.until(ExpectedConditions.elementToBeClickable(doc_menu_delete));
		doc_menu_delete.click();
		wait.until(ExpectedConditions.elementToBeClickable(doc_menu_delete_OK));
		doc_menu_delete_OK.click();

		assertTrue(true);
	}

	/**
	 * 点击文档，跳转到权限提示页面
	 * 
	 * @author 刘晨
	 * @Time 2018-01-09
	 *
	 */
	@Test(enabled = true)
	public void notice_4() throws InterruptedException {
		login("autoTest13@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("autoTest12@shimo.im");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		b_addCollaborator_2_list.click();

		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_4));
		list_addCollaborator_4.click();

		logout();
		login("autoTest12@shimo.im", "123123");
		action.moveToElement(dashboard_notice).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1));
		dashboard_notice_list_1.click();

		switchToPage(1);
		String result = driver.findElement(By.xpath("//div[@class='info-word']//p")).getText();
		assertEquals(result, "当前登录帐号 autoTest12@shimo.im 没有权限访问这个文档");
	}
}
