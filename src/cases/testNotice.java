package cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
		// desktop.click();
		click(desktop);

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		desktop1_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.clear();
		doc_edit.sendKeys("@autoTest12");
		wait.until(ExpectedConditions.elementToBeClickable(doc_notice_user));
		doc_notice_user.click();
//
//		wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='save-status']//span[2]"), "自动保存成功"));
//		b_back.click();
		click(b_back);
		logout();
		login("autoTest12@shimo.im", "123123");
		action.moveToElement(dashboard_notice).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1));
		// String msg = dashboard_notice_list_1_time.getText();
		dashboard_notice_list_1.click();

		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		String url = driver.getCurrentUrl();
		// assertEquals(url, "https://release.shimodev.com/docs/MQHNJBqnsUQUPuYV");
		assertTrue(url.startsWith("https://release.shimodev.com/docs/MQHNJBqnsUQUPuYV"));
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
		// desktop.click();
		click(desktop);

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		desktop1_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.clear();
		doc_edit.sendKeys("@autoTest12");
		wait.until(ExpectedConditions.elementToBeClickable(doc_notice_user));
		doc_notice_user.click();

		click(b_back);
		logout();
		login("autoTest12@shimo.im", "123123");
		action.moveToElement(dashboard_notice).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1));

		String msg1 = dashboard_notice_list_unread.getText();
		dashboard_notice_list_allRead.click();
		Thread.sleep(500);
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
		// desktop.click();
		click(desktop);
//		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
//		String msg = desktop_show_type.getText();
		String msg = getText(desktop_show_type);
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

//		action.contextClick(desktop1_1).perform();
		contextClick(desktop1_1);
//		menu_cooperation.click();
		click(menu_cooperation);
		
//		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
//		button_addCollaborator.click();
		click(button_addCollaborator);

		input_addCollaborator.sendKeys("autoTest12@shimo.im");
		Thread.sleep(500);
//		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
//		b_addCollaborator_1_add.click();
		click(b_addCollaborator_1_add);

//		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
//		b_addCollaborator_ok.click();
		click(b_addCollaborator_ok);
		// Thread.sleep(500);

		logout();
		login("autoTest12@shimo.im", "123123");
		action.moveToElement(dashboard_notice).perform();
//		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1));
//		dashboard_notice_list_1.click();
		click(dashboard_notice_list_1);

		switchToPage(1);
//		wait.until(ExpectedConditions.elementToBeClickable(doc_menu));
//		doc_menu.click();
		click(doc_menu);
//		wait.until(ExpectedConditions.elementToBeClickable(doc_menu_delete));
//		doc_menu_delete.click();
		click(doc_menu_delete);
//		wait.until(ExpectedConditions.elementToBeClickable(doc_menu_delete_OK));
//		doc_menu_delete_OK.click();
		click(doc_menu_delete_OK);

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
		// desktop.click();
		click(desktop);
//		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
//		String msg = desktop_show_type.getText();
		String msg = getText(desktop_show_type);
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

//		action.contextClick(desktop1_1).perform();
		contextClick(desktop1_1);
//		menu_cooperation.click();
		click(menu_cooperation);

//		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
//		button_addCollaborator.click();
		click(button_addCollaborator);

		input_addCollaborator.sendKeys("autoTest12@shimo.im");
		Thread.sleep(500);
//		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
//		b_addCollaborator_1_add.click();
		click(b_addCollaborator_1_add);

//		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
//		b_addCollaborator_ok.click();
		click(b_addCollaborator_ok);

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
//		b_addCollaborator_2_list.click();
		click(b_addCollaborator_2_list);

//		wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_4));
//		list_addCollaborator_4.click();
		click(list_addCollaborator_4);

		logout();
		login("autoTest12@shimo.im", "123123");
		action.moveToElement(dashboard_notice).perform();
//		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1));
//		dashboard_notice_list_1.click();
		click(dashboard_notice_list_1);

		switchToPage(1);
		String result = driver.findElement(By.xpath("//div[@class='info-word']//p")).getText();
		assertEquals(result, "当前登录帐号 autoTest12@shimo.im 没有权限访问这个文档");
	}

	/**
	 * 点击文档评论通知，跳转到文档，并且打开通知当前评论
	 * 
	 * @author 刘晨
	 * @Time 2018-01-09
	 *
	 */
	@Test(enabled = true)
	public void notice_5() throws InterruptedException {
		login("autoTest14@shimo.im", "123123");
		// desktop.click();
		click(desktop);

//		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
//		desktop1_1.click();
		click(desktop1_1);

		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.clear();
		doc_edit.sendKeys("lala");
		doc_discuss.click();
		doc_discuss_input.sendKeys("yoyoyo");
		action.sendKeys(Keys.ENTER);
//		wait.until(ExpectedConditions.elementToBeClickable(doc_discuss_input_ok));
//		doc_discuss_input_ok.click();
		click(doc_discuss_input_ok);
		wait.until(
				ExpectedConditions.textToBe(By.className("doc-comment-input-placeholder"), "按enter发送，shift+enter换行"));

		click(b_back);
		logout();
		login("autoTest12@shimo.im", "123123");
		action.moveToElement(dashboard_notice).perform();
//		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1));
//		dashboard_notice_list_1.click();
		click(dashboard_notice_list_1);

		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(End_Discussion));
		Boolean resutl = doc_discuss_input.isDisplayed();
		assertTrue(resutl);
	}

	/**
	 * 全部通知与未读通知列表切换
	 * 
	 * @author 刘晨
	 * @Time 2018-01-12
	 *
	 */
	@Test(enabled = true)
	public void notice_6() throws InterruptedException {
		login("autoTest11@shimo.im", "123123");
		// desktop.click();
		click(desktop);

//		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
//		desktop1_1.click();
		click(desktop1_1);

		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.clear();
		doc_edit.sendKeys("@autoTest12");
//		wait.until(ExpectedConditions.elementToBeClickable(doc_notice_user));
//		doc_notice_user.click();
		click(doc_notice_user);

		click(b_back);
		logout();
		login("autoTest12@shimo.im", "123123");
		action.moveToElement(dashboard_notice).perform();
//		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice_list_1));
//
//		dashboard_notice_list_unread.click();
		click(dashboard_notice_list_unread);

		String result = dashboard_notice_list_unread.getAttribute("data-test");
		List<WebElement> elements;
		int i = 100;
		if (result.equals("active")) {
			Thread.sleep(500);
			elements = driver.findElements(
					By.xpath("//div[@class='sm-tab-content']//div[2]//div//div[@data-test='notification-item']"));
			if (elements != null) {
				i = elements.size();
			}
		} else {
			assertFalse(true);
		}

		String msg1 = dashboard_notice_list_unread.getText();
		String msg2 = "未读 (" + i + ")";
		assertTrue(msg1.equals(msg2));
	}
}
