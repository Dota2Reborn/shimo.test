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

		click(desktop);
		String msg = getText(desktop1_1);
		click(desktop_new);
		click(desktop_newDoc);
		click(b_back);
		contextClick(desktop1_1);
		click(menu_delete);
		click(desktop_newFolder_name_ok);

		driver.navigate().refresh();
		String msg1 = getText(desktop1_1);

		assertEquals(msg, msg1);

	}

	/**
	 * 新建表格
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_newSheet() throws InterruptedException {

		login("autoTest@shimo.im", "123123");

		click(desktop);
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = getText(desktop1_1);
		click(desktop_new);
		click(desktop_newSheet);
		click(b_back);
		contextClick(desktop1_1);
		click(menu_delete);
		click(desktop_newFolder_name_ok);

		driver.navigate().refresh();
		String msg1 = getText(desktop1_1);

		assertEquals(msg, msg1);

	}

	/**
	 * 新建文件夹
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_newFolder() throws InterruptedException {

		login("autoTest@shimo.im", "123123");

		click(desktop);

		String msg = getText(desktop1_1);
		click(desktop_new);
		click(desktop_newFolder);

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);

		desktop_newFolder_name.sendKeys(time);
		click(desktop_newFolder_name_ok);
		click(desktop);
		contextClick(desktop1_1);
		click(menu_delete);
		click(desktop_newFolder_name_ok);
		driver.navigate().refresh();
		String msg1 = getText(desktop1_1);

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

		click(desktop);
		click(desktop_show_type);

		Boolean result = false;
		Boolean exist1 = doesWebElementExist(By.className("table-head-cell"));

		click(desktop_show_type);

		Boolean exist2 = doesWebElementExist(By.className("table-head-cell"));

		if (exist1 == true && exist2 == false) {
			result = true;
		}

		assertTrue(result);

	}

	/**
	 * 右键文档-在新标签页中打开
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_doc_setting_1() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		click(desktop);
		contextClick(desktop1_1);
		click(menu_newPage);

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
		click(desktop);
		contextClick(desktop1_1);
		click(menu_shortcut);

		driver.navigate().refresh();
		String msg = getText(desktop_shortcut_1);
		String doc_name = getText(desktop1_1);

		contextClick(desktop1_1);
		Thread.sleep(200);
		click(menu_shortcut);

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
		click(desktop);

		String doc_name = getText(desktop1_1);
		action.contextClick(desktop1_1).perform();
		click(menu_collection);

		click(favorites);
		String doc_name1 = getText(desktop1_1);
		contextClick(desktop1_1);
		click(menu_collection);

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
		click(desktop);

		String msg = getText(desktop1_1);
		contextClick(desktop1_1);
		click(menu_move);
		click(desktop_moveFolder_list_1);
		click(desktop_moveFolder_button);

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		driver.navigate().refresh();
		click(desktop1_1_folder);
		contextClick(desktop1_1);
		click(menu_move);
		click(desktop_moveFolder_back_button);
		Thread.sleep(500);
		click(desktop_moveFolder_button);

		wait.until(ExpectedConditions.elementToBeClickable(desktop));
		driver.navigate().refresh();
		click(desktop);
		String msg1 = getText(desktop1_1);

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
		// desktop.click();
		click(desktop);
		click(desktop1_1_folder);
		contextClick(desktop1_1);
		click(menu_rename);

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);

		desktop_newFolder_name.sendKeys(time);
		click(desktop_newFolder_name_ok);

		driver.navigate().refresh();
		String msg = getText(desktop1_1);

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
		// desktop.click();
		click(desktop);
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));

		String msg = getText(desktop1_1);
		contextClick(desktop1_1);
		click(menu_creatCopy);

		driver.navigate().refresh();
		String msg1 = getText(desktop1_1);
		contextClick(desktop1_1);
		click(menu_delete);
		click(desktop_newFolder_name_ok);

		assertEquals(msg1, "副本 " + msg);
	}

	/**
	 * 右键文件夹-在新标签页打开
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2017-11-20
	 *
	 */
	@Test
	public void desktop_folder_setting_1() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		click(desktop);

		contextClick(desktop1_1_folder);
		click(menu_newPage);

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
		click(desktop);

		contextClick(desktop1_1_folder);
		click(menu_shortcut);
		Thread.sleep(100);
		String msg = getText(desktop_shortcut_1);
		String doc_name = getText(desktop1_1_folder);

		contextClick(desktop1_1_folder);
		Thread.sleep(200);
		click(menu_shortcut);

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
		click(desktop);

		String doc_name = getText(desktop1_1_folder);
		contextClick(desktop1_1_folder);
		click(menu_collection);

		click(favorites);
		String doc_name1 = getText(desktop1_1_folder);
		contextClick(desktop1_1_folder);
		click(menu_collection);

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

		click(desktop);
		click(desktop_new);
		click(desktop_newFolder);
		desktop_newFolder_name.sendKeys("FFFFF");
		click(desktop_newFolder_name_ok);
		// wait.until(ExpectedConditions.elementToBeClickable(By.className("settings")));
		click(desktop);
		contextClick(desktop1_1);
		click(menu_move);
		click(desktop_moveFolder_list_2);
		Thread.sleep(500);
		click(desktop_moveFolder_button);
		driver.navigate().refresh();
		click(desktop1_1_folder);
		contextClick(desktop1_1);
		click(menu_rename);
		desktop_newFolder_name.sendKeys("删除文件夹");
		click(desktop_newFolder_name_ok);
		driver.navigate().refresh();
		String msg = getText(desktop1_1);

		contextClick(desktop1_1);
		click(menu_delete);
		click(desktop_newFolder_name_ok);

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
		click(desktop);

		WebElement uploadButton = desktop_import;
		String url = System.getProperty("user.dir") + "/doc/test_doc.doc";
		System.out.println(url);
		uploadButton.sendKeys(url);

		Thread.sleep(2000);
		click(b_back);

		String msg = getText(desktop1_1);
		contextClick(desktop1_1);
		click(menu_delete);
		click(desktop_newFolder_name_ok);

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
		click(desktop);

		WebElement uploadButton = desktop_import;
		String url = System.getProperty("user.dir") + "/doc/test_docx.docx";
		System.out.println(url);
		uploadButton.sendKeys(url);

		Thread.sleep(2000);
		click(b_back);

		String msg = getText(desktop1_1);
		contextClick(desktop1_1);
		click(menu_delete);
		click(desktop_newFolder_name_ok);

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
		click(desktop);

		WebElement uploadButton = desktop_import;
		String url = System.getProperty("user.dir") + "/doc/test_sheet.xlsx";
		System.out.println(url);
		uploadButton.sendKeys(url);

		click(desktop_newFolder_name_cancel);
		String msg = getText(desktop1_1);
		contextClick(desktop1_1);
		click(menu_delete);
		click(desktop_newFolder_name_ok);

		assertEquals(msg, "test_sheet");

	}

	/**
	 * hover文档/表格，齿轮-在新标签页中打开
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2018-03-19
	 *
	 */
	@Test
	public void desktop_doc_newPage() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		click(desktop);

		action.moveToElement(desktop1_1).perform();
		click(desktop_setting);
		click(menu_newPage);

		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		int n = it.size();
		assertEquals(2, n);
	}

	/**
	 * hover文档/表格，齿轮-添加到快捷方式
	 * 
	 * @author 刘晨
	 * @Time 2018-03-19
	 *
	 */
	@Test
	public void desktop_doc_shortcut() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		click(desktop);

		action.moveToElement(desktop1_1).perform();
		click(desktop_setting);
		click(menu_shortcut);

		driver.navigate().refresh();
		String msg = getText(desktop_shortcut_1);
		String doc_name = getText(desktop1_1);

		contextClick(desktop1_1);
		Thread.sleep(200);
		click(menu_shortcut);

		assertEquals(doc_name, msg);

	}

	/**
	 * hover文档/表格，齿轮-收藏
	 * 
	 * @author 刘晨
	 * @Time 2018-03-19
	 *
	 */
	@Test
	public void desktop_doc_collection() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		// desktop.click();
		click(desktop);
		String doc_name = getText(desktop1_1);
		action.moveToElement(desktop1_1).perform();
		click(desktop_setting);
		click(menu_collection);

		click(favorites);
		String doc_name1 = getText(desktop1_1);
		contextClick(desktop1_1);
		click(menu_collection);

		assertEquals(doc_name, doc_name1);
	}

	/**
	 * hover文档/表格，齿轮-重命名
	 * 
	 * @author 刘晨
	 * @Time 2018-03-19
	 *
	 */
	@Test
	public void desktop_doc_rename() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		click(desktop);
		click(desktop1_1_folder);
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		action.moveToElement(desktop1_1).perform();
		click(desktop_setting);
		click(menu_rename);

		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);

		desktop_newFolder_name.sendKeys(time);
		click(desktop_newFolder_name_ok);

		driver.navigate().refresh();
		String msg = getText(desktop1_1);

		assertEquals(time, msg);
	}

	/**
	 * hover文档/表格，齿轮-创建副本
	 * 
	 * @author 刘晨
	 * @Time 2018-03-19
	 *
	 */
	@Test
	public void desktop_doc_creatCopy() throws InterruptedException {
		login("autoTest@shimo.im", "123123");
		click(desktop);
		String msg = getText(desktop1_1);
		action.moveToElement(desktop1_1).perform();
		click(desktop_setting);
		click(menu_creatCopy);

		driver.navigate().refresh();
		String msg1 = getText(desktop1_1);

		action.moveToElement(desktop1_1).perform();
		click(desktop_setting);
		click(menu_delete);
		click(desktop_newFolder_name_ok);

		assertEquals(msg1, "副本 " + msg);
	}
}
