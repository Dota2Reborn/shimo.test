package cases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testDesktopOrderBy extends TestInit {
	/**
	 * 桌面排序as更新时间
	 * 
	 * @author 刘晨
	 * @Time 2017-11-28
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byUpdate() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByUpdate));
		desktop_orderByUpdate.click();

		Boolean f1 = desktop_list_1_file.getText().equals("最近更新");
		Boolean f2 = desktop_list_2_file.getText().equals("最新创建");
		Boolean f3 = desktop_list_3_file.getText().equals("111");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}

	/**
	 * 桌面排序as创建时间
	 * 
	 * @author 刘晨
	 * @Time 2017-11-28
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byCreate() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByCreate));
		desktop_orderByCreate.click();

		Boolean f1 = desktop_list_1_file.getText().equals("最新创建");
		Boolean f2 = desktop_list_2_file.getText().equals("111");
		Boolean f3 = desktop_list_3_file.getText().equals("最近更新");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}

	/**
	 * 桌面排序as文件名
	 * 
	 * @author 刘晨
	 * @Time 2017-11-28
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byFileName() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFile));
		desktop_orderByFile.click();
		Thread.sleep(600);

		Boolean f1 = desktop_list_1_file.getText().equals("111");
		Boolean f2 = desktop_list_2_file.getText().equals("表格排序");
		Boolean f3 = desktop_list_3_file.getText().startsWith("所有者排序");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}

	/**
	 * 桌面排序as所有者
	 * 
	 * @author 刘晨
	 * @Time 2017-11-28
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byOwner() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByOwner));
		desktop_orderByOwner.click();

		Boolean f1 = desktop_list_1_file.getText().startsWith("所有者排序");
		Boolean f2 = desktop_list_2_file.getText().equals("最新创建");
		Boolean f3 = desktop_list_3_file.getText().equals("111");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}

	/**
	 * 桌面排序as文件夹置顶
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byFolderUP() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
		desktop_orderByFolderUP.click();

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByCreate));
		desktop_orderByCreate.click();

		Boolean f1 = desktop_list_1_file.getText().equals("文件夹排序");
		Boolean f2 = desktop_list_2_file.getText().equals("最新创建");
		Boolean f3 = desktop_list_3_file.getText().equals("111");

		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
		desktop_orderByFolderUP.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}

	/**
	 * 桌面排序as创建时间,点击表头排序
	 * 
	 * @author 刘晨
	 * @Time 2018-03-19
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byCreate_Reverse() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByCreate));
		desktop_orderByCreate.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderHeader_3));
		desktop_orderHeader_3.click();
		

		Boolean f1 = desktop_list_1_file.getText().equals("文档排序");
		Boolean f2 = desktop_list_2_file.getText().equals("表格排序");
		Boolean f3 = desktop_list_3_file.getText().equals("文件夹排序");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}
	
	/**
	 * 桌面排序as所有者，点击表头排序
	 * 
	 * @author 刘晨
	 * @Time 2018-03-19
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byOwner_Reverse() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByOwner));
		desktop_orderByOwner.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderHeader_2));
		desktop_orderHeader_2.click();

		Boolean f1 = desktop_list_1_file.getText().startsWith("最新创建");
		Boolean f2 = desktop_list_2_file.getText().equals("111");
		Boolean f3 = desktop_list_3_file.getText().equals("最近更新");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}
	
	/**
	 * 桌面排序as文件名
	 * 
	 * @author 刘晨
	 * @Time 2017-11-28
	 *
	 */
	@Test(enabled = true)
	public void order_setting_byFileName_Reverse() throws InterruptedException {
		login("autoTest02@shimo.im", "123123");

		// desktop.click();
		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		String msg = desktop_show_type.getText();
		if (msg.equals("列表")) {
			desktop_show_type.click();
		}
		desktop_order.click();

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFile));
		desktop_orderByFile.click();
		Thread.sleep(600);

		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderHeader_1));
		desktop_orderHeader_1.click();
		
		Boolean f1 = desktop_list_1_file.getText().equals("最新创建");
		Boolean f2 = desktop_list_2_file.getText().equals("最近更新");
		Boolean f3 = desktop_list_3_file.getText().startsWith("文件夹排序");

		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
		desktop_orderByDefault.click();

		desktop_show_type.click();
		assertTrue(f1 && f2 && f3);

	}
}
