package cases.ppt;

import static org.testng.Assert.assertEquals;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import base.TestInit;

public class testTextboxEdit extends TestInit {// 编辑文本框

	/**
	 * 删除文本框中内容，重新输入后刷新是否保存
	 * 
	 * @author 王继程
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	public void Text_Editing() throws InterruptedException {
		login("textediting@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HHmmss");
		String time1 = format.format(date);
		setClipbordContents(time1);
		click(page_elements_1);
		for (int i = 1; i < 7; i++) {
			action.sendKeys(Keys.BACK_SPACE).click().perform();
		}
		action.sendKeys(Keys.CONTROL, "v").click().perform();// NUMPAD0 ~ NUMPAD9：数字键1-9
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
