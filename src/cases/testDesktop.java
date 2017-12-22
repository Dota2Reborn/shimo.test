package cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testDesktop extends TestInit {

	/**
	 * 新建文档
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_newDoc() throws InterruptedException {

		login("autoTest@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		// action.moveToElement(desktop1_1).perform();
		// desktop_setting.click();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg1 = desktop1_1.getText();

		assertEquals(msg, msg1);

	}

	/**
	 * 新建表格
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_newSheet() {

		login("autoTest@shimo.im", "123123");

		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newSheet));
		desktop_newSheet.click();

		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		// action.moveToElement(desktop1_1).perform();
		// desktop_setting.click();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg1 = desktop1_1.getText();

		assertEquals(msg, msg1);

	}

	/**
	 * 新建文件夹
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_newFolder() {

		login("autoTest@shimo.im", "123123");

		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder));
		desktop_newFolder.click();

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);

		desktop_newFolder_name.sendKeys(time);
		desktop_newFolder_name_ok.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.className("settings")));
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		// action.moveToElement(desktop1_1).perform();
		// desktop_setting.click();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_folder_9));
		desktop_setting_folder_9.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg1 = desktop1_1.getText();

		assertEquals(msg, msg1);
	}

	/**
	 * 桌面-列表/平铺 模式切换
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_show_type() throws InterruptedException {

		login("autoTest@shimo.im", "123123");

		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_show_type));
		desktop_show_type.click();

		Boolean result = false;
		Boolean exist1 = doesWebElementExist(driver, By.className("table-head-cell"));

		desktop_show_type.click();

		Boolean exist2 = doesWebElementExist(driver, By.className("table-head-cell"));

		if (exist1 == true && exist2 == false) {
			result = true;
		}

		assertTrue(result);

	}

	/**
	 * 右键文档-在新标签页中打开
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_doc_setting_1() {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		action.contextClick(desktop1_1).perform();
		desktop_setting_doc_1.click();

		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		int n = it.size();
		assertEquals(2, n);
	}

	/**
	 * 右键文档-添加到快捷方式
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_doc_setting_2() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_2));
		String setting_2 = desktop_setting_doc_2.getText();
		if (setting_2.equals("从快捷方式移除")) {
			desktop_setting_doc_2.click();
			action.contextClick(desktop1_1).perform();
			wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_2));
		}

		desktop_setting_doc_2.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop_shortcut_1.getText();
		String doc_name = desktop1_1.getText();

		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_2));
		desktop_setting_doc_2.click();

		assertEquals(doc_name, msg);

	}

	/**
	 * 右键文档-收藏
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_doc_setting_3() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		String doc_name = desktop1_1.getText();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_3));
		desktop_setting_doc_3.click();

		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String doc_name1 = desktop1_1.getText();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_3));
		desktop_setting_doc_3.click();

		assertEquals(doc_name, doc_name1);
	}

	/**
	 * 右键文档-移动
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_doc_setting_6() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		String msg = desktop1_1.getText();

		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_6));
		desktop_setting_doc_6.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_list_1));
		desktop_moveFolder_list_1.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_button));
		desktop_moveFolder_button.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		desktop1_1_folder.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_6));
		desktop_setting_doc_6.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_back_button));
		desktop_moveFolder_back_button.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_button));
		desktop_moveFolder_button.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop));
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg1 = desktop1_1.getText();

		assertEquals(msg, msg1);
	}

	/**
	 * 右键文档-重命名
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_doc_setting_8() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		desktop1_1_folder.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_8));
		desktop_setting_doc_8.click();

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);

		desktop_newFolder_name.sendKeys(time);
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();

		assertEquals(time, msg);
	}

	/**
	 * 右键文档-创建副本
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_doc_setting_9() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		String msg = desktop1_1.getText();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_9));
		desktop_setting_doc_9.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg1 = desktop1_1.getText();

		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		assertEquals(msg1, "副本 " + msg);
	}

	/**
	 * 右键文件夹-在新标签页打开
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_folder_setting_1() {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		action.contextClick(desktop1_1_folder).perform();
		desktop_setting_doc_1.click();

		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		int n = it.size();
		assertEquals(2, n);
	}

	/**
	 * 右键文件夹-添加到快捷方式
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_folder_setting_2() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		action.contextClick(desktop1_1_folder).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_2));

		String setting_2 = desktop_setting_doc_2.getText();
		if (setting_2.equals("从快捷方式移除")) {
			desktop_setting_doc_2.click();
			action.contextClick(desktop1_1_folder).perform();
			wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_2));
		}

		desktop_setting_doc_2.click();
		Thread.sleep(500);
		String msg = desktop_shortcut_1.getText();
		String doc_name = desktop1_1_folder.getText();

		action.contextClick(desktop1_1_folder).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_2));
		desktop_setting_doc_2.click();

		assertEquals(doc_name, msg);

	}

	/**
	 * 右键文件夹-收藏
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_folder_setting_3() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		String doc_name = desktop1_1_folder.getText();
		action.contextClick(desktop1_1_folder).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_3));
		desktop_setting_doc_3.click();

		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String doc_name1 = desktop1_1_folder.getText();
		action.contextClick(desktop1_1_folder).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_3));
		desktop_setting_doc_3.click();

		assertEquals(doc_name, doc_name1);
	}

	/**
	 * 右键文件夹-文件夹移动，重命名，删除
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_folder_setting() throws InterruptedException {

		login("autoTest@shimo.im", "123123");

		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder));
		desktop_newFolder.click();

		desktop_newFolder_name.sendKeys("FFFFF");
		desktop_newFolder_name_ok.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.className("settings")));
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));

		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_6));
		desktop_setting_doc_6.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_list_2));
		desktop_moveFolder_list_2.click();

		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(desktop_moveFolder_button));
		desktop_moveFolder_button.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		desktop1_1_folder.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_8));
		desktop_setting_doc_8.click();

		desktop_newFolder_name.sendKeys("删除文件夹");
		desktop_newFolder_name_ok.click();
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();

		// action.moveToElement(desktop1_1).perform();
		// desktop_setting.click();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_folder_9));
		desktop_setting_folder_9.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		assertEquals(msg, "删除文件夹");
	}

	/**
	 * 导入文档doc
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_import_doc() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		WebElement uploadButton = desktop_import;
		String url = System.getProperty("user.dir") + "/doc/test_doc.doc";
		System.out.println(url);
		uploadButton.sendKeys(url);

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();
		// action.moveToElement(desktop1_1).perform();
		// desktop_setting.click();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		assertEquals(msg, "test_doc");

	}

	/**
	 * 导入文档docx
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_import_docx() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		WebElement uploadButton = desktop_import;
		String url = System.getProperty("user.dir") + "/doc/test_docx.docx";
		System.out.println(url);
		uploadButton.sendKeys(url);

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();
		// action.moveToElement(desktop1_1).perform();
		// desktop_setting.click();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		assertEquals(msg, "test_docx");

	}

	/**
	 * 导入表格
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_import_sheet() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		WebElement uploadButton = desktop_import;
		String url = System.getProperty("user.dir") + "/doc/test_sheet.xlsx";
		System.out.println(url);
		uploadButton.sendKeys(url);

		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_cancel));
		desktop_newFolder_name_cancel.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop1_1.getText();

		// action.moveToElement(desktop1_1).perform();
		// desktop_setting.click();
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();

		assertEquals(msg, "test_sheet");

	}

	

}
