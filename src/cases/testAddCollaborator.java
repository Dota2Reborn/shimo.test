package cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testAddCollaborator extends TestInit {

	/**
	 * 基础版用户，文件协作者为5人，不能继续添加协作者
	 * 
	 * @author 刘晨
	 * @Time 2017-11-22
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_1() throws InterruptedException {
		login("autoTest01@shimo.im", "123123");

		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1).perform();
		menu_cooperation.click();

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
		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1_folder).perform();
		menu_cooperation.click();

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
		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1_folder).perform();
		menu_cooperation.click();

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
		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1_folder).perform();
		menu_cooperation.click();

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
		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1_folder).perform();
		menu_cooperation.click();

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
		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1_folder).perform();
		menu_cooperation.click();

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
		menu_cooperation.click();

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
		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1_folder).perform();
		menu_cooperation.click();

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
		menu_cooperation.click();

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
		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1_folder).perform();
		menu_cooperation.click();

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
		menu_cooperation.click();

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
		// desktop.click();
		clickDesktop();
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
		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_2_folder).perform();
		menu_cooperation.click();

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
		menu_cooperation.click();

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
	 * 非席位成员，在5个人以上协作者文件夹中不能新建
	 * 
	 * @author 刘晨
	 * @Time 2017-12-07
	 *
	 */
	@Test(enabled = true)
	public void addCollaborator_fail() throws InterruptedException {
		login("autoTest10@shimo.im", "123123");
		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}
		desktop1_1_folder.click();
		String t = desktop_new.getAttribute("disabled");

		assertEquals(t, "true");
	}

}
