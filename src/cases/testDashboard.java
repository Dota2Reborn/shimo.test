package cases;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testDashboard extends TestInit {

	/**
	 * 最近更新验证
	 * 
	 * @author 刘晨
	 * @Time 2017-12-18
	 *
	 */
	@Test(enabled = true)
	public void dashboard_update() throws InterruptedException {
		login("autoTest06@shimo.im", "123123");
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		desktop1_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.sendKeys("la");
		Thread.sleep(500);
		b_back.click();
		logout();
		login("autoTest05@shimo.im", "123123");

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
		String msg = dashboard_update_time.getText();

		assertEquals(msg, "刚刚 autoTest... 更新");
	}

	/**
	 * 最近使用验证
	 * 
	 * @author 刘晨
	 * @Time 2017-12-18
	 *
	 */
	@Test(enabled = true)
	public void dashboard_used() throws InterruptedException {
		login("autoTest06@shimo.im", "123123");
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		desktop1_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard));
		dashboard.click();
		dashboard_2.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
		String msg = dashboard_update_time.getText();

		assertEquals(msg, "刚刚 我 打开");
	}

	/**
	 * 我创建的验证
	 * 
	 * @author 刘晨
	 * @Time 2017-12-18
	 *
	 */
	@Test(enabled = true)
	public void dashboard_create() throws InterruptedException {
		login("autoTest07@shimo.im", "123123");

		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(b_back));

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);
		driver.findElement(By.id("ql-title-input")).sendKeys(time);
		b_back.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard));
		dashboard_3.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_name));
		String msg = dashboard_update_name.getText();

		action.contextClick(dashboard_update_name).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_setting_doc_12));
		dashboard_setting_doc_12.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		assertEquals(msg, time);
	}

	/**
	 * 共享给我的验证
	 * 
	 * @author 刘晨
	 * @Time 2017-12-19
	 *
	 */
	@Test(enabled = true)
	public void dashboard_share() throws InterruptedException {
		login("autoTest06@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}

		action.contextClick(desktop1_1_folder).perform();
		desktop_setting_doc_5.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		button_addCollaborator.click();

		input_addCollaborator.sendKeys("autoTest07@shimo.im");
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_ok));
		b_addCollaborator_ok.click();

		logout();
		login("autoTest07@shimo.im", "123123");

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_shareTime_1));
		action.moveToElement(dashboard_shareTime_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_shareTime_unread));
		dashboard_shareTime_unread.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_4));
		dashboard_4.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_share_file));
		action.contextClick(dashboard_share_file).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_share_setting_doc_10));
		dashboard_share_setting_doc_10.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		Thread.sleep(1000);

		msg = driver.findElement(By.className("none-file")).getText();
		assertEquals(msg, "没有文件");

	}

	/**
	 * 工作台-文件定位的所在文件夹
	 * 
	 * @author 刘晨
	 * @Time 2017-12-18
	 *
	 */
	@Test(enabled = true)
	public void dashboard_setting_locatFolder() throws InterruptedException {
		login("autoTest08@shimo.im", "123123");

		dashboard_3.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_name));

		System.out.println("bilibili ->" + dashboard_update_name.getText());
		action.contextClick(dashboard_update_name).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_setting_doc_8));
		Thread.sleep(500);
		dashboard_setting_doc_8.click();

		String url_sample = "https://release.shimodev.com/folder/x2zSDzXqfQI9TaKr";
		wait.until(ExpectedConditions.urlToBe(url_sample));
		String url = driver.getCurrentUrl();
		assertEquals(url, url_sample);
	}

	/**
	 * 工作台-文件定位的所在文件夹
	 * 
	 * @author 刘晨
	 * @Time 2017-12-18
	 *
	 */
	@Test(enabled = true)
	public void dashboard_setting_createCopy() throws InterruptedException {
		login("autoTest09@shimo.im", "123123");

		dashboard_3.click();

		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_name));

		System.out.println("创建副本 ->" + dashboard_update_name.getText());

		action.contextClick(dashboard_update_name).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_setting_doc_10));
		dashboard_setting_doc_10.click();

		action.contextClick(dashboard_update_name).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_setting_doc_8));
		Thread.sleep(500);
		dashboard_setting_doc_8.click();

		String fileName = desktop1_1.getText();

		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		assertEquals(fileName, "副本 创建副本");
	}

}
