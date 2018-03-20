package cases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testRecycleBin extends TestInit{
	/**
	 * 删除文件后恢复
	 * 
	 * @author 王继程
	 * @Time 2018-03-12
	 *
	 */
	@Test(enabled = true)
	public void New_Document() throws InterruptedException {
		login("RecycleBin@shimo.im", "123123");
		
		desktop.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(menu_delete));
		menu_delete.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();
		trash.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String name = desktop1_1.getText();
		assertEquals(name, "删除恢复测试");
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(menu_Recovery));
		menu_Recovery.click();
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String name1 = desktop1_1.getText();
		assertEquals(name1, "删除恢复测试");
	}

}
