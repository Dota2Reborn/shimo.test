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
		click(desktop_new);
		click(desktop_newDoc);
		click(Collection_OK);
		click(b_back);
		click(favorites);
		Tile();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String name=desktop1_1.getText();
		assertEquals(name, "无标题");
		action.contextClick(desktop1_1).perform();
		click(menu_delete);
		click(desktop_newFolder_name_ok);
		
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
		click(desktop_new);
		click(desktop_newSheet);
		click(Collection_OK);
		click(b_back);
		click(favorites);
		Tile();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String name=desktop1_1.getText();
		assertEquals(name, "无标题");
		action.contextClick(desktop1_1).perform();
		click(menu_delete);
		click(desktop_newFolder_name_ok);
		
	}
	/**
	 * 我的收藏-列表/平铺 模式切换
	 * 
	 * @author 
	 * @Time 2018-03-19
	 *
	 */
	@Test
	public void desktop_show_type() throws InterruptedException {

		login("Collection@shimo.im", "123123");
		favorites.click();
		Sort();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_show_type));
		desktop_show_type.click();

		Boolean result = false;
		Boolean exist1 = doesWebElementExist(By.className("table-head-cell"));

		desktop_show_type.click();

		Boolean exist2 = doesWebElementExist(By.className("table-head-cell"));

		if (exist1 == true && exist2 == false) {
			result = true;
		}
		//driver.manage().deleteAllCookies();
		assertTrue(result);

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
		Sort();
		desktop_order.click();
		click(desktop_orderByCreate);
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_name));
		String name = desktop1_1_name.getText();
		assertEquals(name, "第四个创建的");
		action.contextClick(desktop1_1).perform();
		click(menu_moveToFolder);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("final"))));
		String Folder_name = driver.findElement(By.className("final")).getText();
		assertEquals(Folder_name, "第三个创建的");
		
	}
	/**
	 * 收藏页面按文件名排序，并且定位第一个文件夹所在位置
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
		Sort();
		desktop_order.click();
		click(desktop_orderByFile);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String name1 = desktop1_1_name.getText();
		assertEquals(name1, "第二个创建的");
		desktop_order.click();
		click(desktop_orderByFile);
		String name2 = desktop1_1_name.getText();
		assertEquals(name2, "第一个创建的");
		
	}
	/**
	 * 文件夹下文件在收藏页面创建副本
	 * 文件夹下是第四个创建的文件
	 * @author 王继程
	 * @Time 2018-03-20
	 *
	 */
	@Test(enabled = true)
	public void Collection_Sort_3() throws InterruptedException {
		login(" Collection@shimo.im", "123123");
		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_show_type));
		Tile();
		Sort();
		desktop_order.click();
		click(desktop_orderByCreate);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String name1 = desktop1_1_name.getText();
		action.contextClick(desktop1_1).perform();
		click(menu_creatCopy);
		driver.navigate().refresh();
		contextClick(desktop1_1);
		click(menu_moveToFolder);
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String name = desktop1_1_name.getText();
		if(name1!=name) {
			contextClick(desktop1_1);
			click(menu_delete);
			click(desktop_newFolder_name_ok);

		}
//		}else {
//			contextClick(desktop1_2);
//			click(menu_delete);
//			click(desktop_newFolder_name_ok);
//			System.out.println("桌面创建时间排序有问题");
//			
//		}
		String msg ="副本"+" "+"第四个创建的";
		assertEquals(msg, name);
	}
	//验证是否平铺
	public void Tile() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(desktop_show_type));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}
			
	}
	//验证排序是否初始化
	public void Sort() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(desktop_order));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}
		msg = desktop_order.getText();
		if (msg.equals("排序")) {
			desktop_order.click();
			wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
			Boolean exist = doesWebElementExist(By.xpath("//span[@data-test='change-table-sort-folder-priority']/following-sibling::span[1]"));
			desktop_orderByDefault.click();
			if(exist==true) {
				desktop_order.click();
				wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
				desktop_orderByFolderUP.click();
			}
		}else {
			desktop_order.click();
			wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
			Boolean exist = doesWebElementExist(By.xpath("//span[@data-test='change-table-sort-folder-priority']/following-sibling::span[1]"));
			if(exist==true) {
				desktop_orderByFolderUP.click();
			}else {
				desktop_orderByDefault.click();
			}
		}
					
	}
	
	

}
