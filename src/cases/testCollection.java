package cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testCollection extends TestInit {

	/**
	 * 新建文档收藏
	 * 
	 * @author 王继程
	 * @Time 2018-03-12
	 *
	 */
	@Test(enabled = true)
	public void New_Document() throws InterruptedException {
		login("New_collection@shimo.im", "123123");
		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(Collection_OK));
		Collection_OK.click();
		
		b_back.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		favorites.click();
		action.contextClick(desktop1_1).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(menu_delete));
		menu_delete.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();
		
	}
	/**
	 * 新建表格收藏
	 * 
	 * @author 王继程
	 * @Time 2018-03-12
	 *
	 */
	@Test(enabled = true)
	public void Create_Table() throws InterruptedException {
		login("New_collection@shimo.im", "123123");
		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newSheet));
		desktop_newSheet.click();
		wait.until(ExpectedConditions.elementToBeClickable(Collection_OK));
		Collection_OK.click();
		
		b_back.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		favorites.click();
		action.contextClick(desktop1_1).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(menu_delete));
		menu_delete.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();
		
	}
	/**
	 * 收藏页面按创建时间排序，并且定位第一个文件夹所在位置
	 * 
	 * @author 王继程
	 * @Time 2018-03-19
	 *
	 */
	@Test(enabled = true)
	public void Collection_Sort_1() throws InterruptedException {
		login(" Collection@shimo.im", "123123");
		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_show_type));
		Tile();
		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
		desktop_orderByFolderUP.click();
		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByCreate));
		desktop_orderByCreate.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_name));
		String name = desktop1_1_name.getText();
		assertEquals(name, "第四个创建的");
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(menu_moveToFolder));
		menu_moveToFolder.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("final"))));
		String Folder_name=driver.findElement(By.className("final")).getText();
		assertEquals(Folder_name, "第三个创建的");
		
	}
	/**
	 * 收藏页面按创建时间排序，并且定位第一个文件夹所在位置
	 * 
	 * @author 王继程
	 * @Time 2018-03-19
	 *
	 */
	@Test(enabled = true)
	public void Collection_Sort_2() throws InterruptedException {
		login(" Collection@shimo.im", "123123");
		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_show_type));
		Tile();
		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
		desktop_orderByFolderUP.click();
		desktop_order.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFile));
		desktop_orderByFile.click();
		
		
//		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
//		desktop_orderByFolderUP.click();
//		desktop_order.click();
//		wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByCreate));
//		desktop_orderByCreate.click();
//		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_name));
//		String name = desktop1_1_name.getText();
//		assertEquals(name, "第四个创建的");
//		action.contextClick(desktop1_1).perform();
//		wait.until(ExpectedConditions.elementToBeClickable(menu_moveToFolder));
//		menu_moveToFolder.click();
//		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("final"))));
//		String Folder_name=driver.findElement(By.className("final")).getText();
//		assertEquals(Folder_name, "第三个创建的");
		
		
	}
	/**
	 * 我都收藏-列表/平铺 模式切换
	 * 
	 * @author 
	 * @Time 2018-03-19
	 *
	 */
	@Test
	public void desktop_show_type() throws InterruptedException {

		login(" Collection@shimo.im", "123123");
		favorites.click();
		String msg = desktop_order.getText();
		if (msg.equals("更新时间")) {
			desktop_order.click();
			wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
			desktop_orderByFolderUP.click();

			desktop_order.click();
			wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
			desktop_orderByDefault.click();
		}
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
	//验证是否平铺
		public void Tile() throws InterruptedException {
			
			String msg = desktop_show_type.getText();
			if (msg.equals("平铺")) {
				desktop_show_type.click();
			}
			
		}

}
