package cases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	/**
	 * 删除文件后恢复
	 * 
	 * @author 王继程
	 * @Time 2018-03-12
	 *
	 */
	@Test(enabled = true)
	public void Completely_removed() throws InterruptedException {
		login("Completely@shimo.im", "123123");
		
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.sendKeys("文档内输入内容，可进入回收站"+Keys.ENTER);//.send_keys(Keys.ENTER);
		Thread.sleep(1000);
		//点点点
		doc_menu.click();
		//删除按钮
		wait.until(ExpectedConditions.elementToBeClickable(file_menu_delete));
		file_menu_delete.click();
		//删除文档，确认删除
		wait.until(ExpectedConditions.elementToBeClickable(doc_menu_delete_OK));
		doc_menu_delete_OK.click();
		wait.until(ExpectedConditions.elementToBeClickable(trash));
		trash.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String name = desktop1_1.getText();
		assertEquals(name, "无标题");
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(menu_Completely_removed));
		menu_Completely_removed.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("none-file")));
		boolean bl = driver.findElement(By.className("none-file")).isDisplayed();
		assertEquals(bl,true);
		
	}

}
