package cases.desktop;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import base.TestInit;

public class testDesktop_gear extends TestInit{

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
		login("autoTest_gear@shimo.im", "123123");
		click(desktop);

		moveToElement(desktop1_1);
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
		login("autoTest_gear@shimo.im", "123123");
		click(desktop);

		moveToElement(desktop1_1);
		click(desktop_setting);
		click(menu_shortcut);

		driver.navigate().refresh();
		String msg = getText(desktop_shortcut_1);
		String doc_name = getText(desktop1_1);

		contextClick(desktop1_1);
		click(menu_shortcut);

		if(!doc_name.equals(msg)) {
			contextClick(desktop1_1);
			click(menu_shortcut);
		}

		assertTrue(doc_name.equals(msg));

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
		login("autoTest_gear@shimo.im", "123123");
		click(desktop);
		String doc_name = getText(desktop1_1);
		moveToElement(desktop1_1);
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
		login("autoTest_gear@shimo.im", "123123");
		click(desktop);
//		click(desktop1_1_folder);
//		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		moveToElement(desktop1_1);
		click(desktop_setting);
		click(menu_rename);

		String time = getDate();
		sendKeys(desktop_newFolder_name,time);
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
		login("autoTest_gear@shimo.im", "123123");
		click(desktop);
		String msg = getText(desktop1_1);
		moveToElement(desktop1_1);
		click(desktop_setting);
		click(menu_creatCopy);

		driver.navigate().refresh();
		String msg1 = getText(desktop1_1);

		moveToElement(desktop1_1);
		click(desktop_setting);
		click(menu_delete);
		click(desktop_newFolder_name_ok);

		assertEquals(msg1, "副本 " + msg);
	}
	
}