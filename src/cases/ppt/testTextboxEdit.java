package cases.ppt;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import base.TestInit;

public class testTextboxEdit extends TestInit {// 编辑文本框

	/**
	 * 在文本框占位符中输入文本检查是否保存
	 * 
	 * @author 王继程
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	public void Text_Editing1() throws InterruptedException {
		login("textstyle1@shimo.im", "123123");
		click(desktop_new);
		click(desktop_newslides);
		setClipbordContents("在文本占位符输入验证保存");
		click(page_elements_1);
		action.sendKeys(Keys.CONTROL, "V").perform();
		Thread.sleep(1000);
		driver.navigate().refresh();// 刷新页面
		String time = getText(page_elements_1);
		click(ppt_dotdotdot);
		click(ppt_delete);
		click(desktop_newFolder_name_ok);
		assertEquals(time, "在文本占位符输入验证保存");

	}

	/**
	 * 新建文本框中输入文本检查是否保存
	 * 
	 * @author 王继程
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	public void Text_Editing2() throws InterruptedException {
		login("textstyle2@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(add_text);
		// click(ppt_text);
		action.moveToElement(ppt_text).click().perform();
		Thread.sleep(500);
		action.sendKeys("新建文本框输入").perform();
		Thread.sleep(500);
		driver.navigate().refresh();// 刷新页面
		String time = getText(page_elements_1);
		click(page_elements_1);
		click(smslide_frame_anchor_1);
		action.sendKeys(Keys.DELETE).perform();
		assertEquals(time, "新建文本框输入");

	}

	/**
	 * 复制文本内容，选中幻灯片页面粘贴
	 * 
	 * @author 王继程
	 * 
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	public void Text_Editing3() throws InterruptedException, AWTException {
		login("textstyle3@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_1);
		setClipbordContents("复制文本内容直接粘贴是否成功");
		action.sendKeys(Keys.chord(Keys.CONTROL, "v")).build().perform();
		Thread.sleep(500);
		Boolean element = doesWebElementExist(page_elements_1);
		if (element) {
			String time = getText(page_elements_1);
			click(page_elements_1);
			click(smslide_frame_anchor_1);
			// Robot robot = new Robot();
			// robot.keyPress(KeyEvent.VK_DELETE);
			action.sendKeys(Keys.chord(Keys.DELETE)).perform();
			assertEquals(time, "复制文本内容直接粘贴是否成功");
		} else {
			assertTrue(element);
		}

	}

	/**
	 * 复制文本框，选中幻灯片页面粘贴
	 * 
	 * @author 王继程
	 * 
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	public void Text_Editing4() throws InterruptedException, AWTException {
		login("textstyle4@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_1);
		click(page_elements_1);
		click(smslide_frame_anchor_1);
		action.sendKeys(Keys.chord(Keys.CONTROL, "c")).build().perform();
		click(ppt_page_2);
		Thread.sleep(500);
		// Robot robot = new Robot();
		action.sendKeys(Keys.chord(Keys.CONTROL, "v")).build().perform();
		Thread.sleep(500);
		driver.navigate().refresh();// 刷新页面
		click(ppt_page_2);
		Boolean element = doesWebElementExist(page_elements_1);
		click(page_elements_1);
		click(smslide_frame_anchor_1);
		action.sendKeys(Keys.DELETE).perform();
		assertTrue(element);

	}
	/**
	 * 设置文本有序无序列表
	 * 
	 * @author 王继程
	 * @throws AWTException
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	public void Text_Editing5() throws InterruptedException, AWTException {
		login("textstyle5@shimo.im", "123123");
		click(desktop_new);
		click(desktop_newslides);
		click(ppt_page_1);
		click(page_elements_1);
		action.sendKeys("第一行"+Keys.ENTER+"第二行").build().perform();
		click(smslide_frame_anchor_1);
		click(ppt_animation);
		click(ppt_right_order);
		Boolean element1 = doesWebElementExist(smslide_ordered_2);
		click(ppt_right_disorder);
		Boolean element2 = doesWebElementExist(smslide_unordered_2);
		click(ppt_dotdotdot);
		click(ppt_delete);
		click(desktop_newFolder_name_ok);
		assertTrue(element1 && element2);

	}

	/**
	 * 删除文本框中内容，重新输入后刷新是否保存
	 * 
	 * @author 王继程
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	public void Text_Editing9() throws InterruptedException {
		login("textediting@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HHmmss");
		String time1 = format.format(date);
		setClipbordContents(time1);
		click(page_elements_1);
		for (int i = 1; i < 7; i++) {
			action.sendKeys(Keys.chord(Keys.BACK_SPACE)).build().perform();
		}
		action.sendKeys(Keys.chord(Keys.CONTROL, "v")).build().perform();
		Thread.sleep(1000);
		driver.navigate().refresh();// 刷新页面
		String time2 = getText(page_elements_1);
		assertEquals(time1, time2);

	}

	private void setClipbordContents(String texts) {// 写入系统剪贴板
		StringSelection stringSelection = new StringSelection(texts);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

	}

}
