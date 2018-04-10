package cases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testMenu_Doc_Sheet extends TestInit {
	/**
	 * 文档编辑页菜单，点击文档信息
	 * 
	 * @author 刘晨
	 * @Time 2018-03-19
	 *
	 */
	@Test(enabled = true)
	public void doc_msg() throws InterruptedException {
		login("autoTest15@shimo.im", "123123");

		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}
		desktop1_1.click();
		wait.until(ExpectedConditions.elementToBeClickable(doc_menu));
		doc_menu.click();
		wait.until(ExpectedConditions.elementToBeClickable(file_menu_msg));
		file_menu_msg.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn confirm-btn btn-ok']")));
		Boolean R1 = driver.findElement(By.xpath("//div[@class='confirm-dialog dialog ']")).isDisplayed();
		assertTrue(R1);

	}
	
	/**
	 * 表格编辑页菜单，点击文档信息
	 * 
	 * @author 刘晨
	 * @Time 2018-03-19
	 *
	 */
	@Test(enabled = true)
	public void sheet_msg() throws InterruptedException {
		login("autoTest16@shimo.im", "123123");

		clickDesktop();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String msg = desktop_show_type.getText();
		if (msg.equals("平铺")) {
			desktop_show_type.click();
		}
		desktop1_1.click();
		wait.until(ExpectedConditions.elementToBeClickable(doc_menu));
		doc_menu.click();
		wait.until(ExpectedConditions.elementToBeClickable(file_menu_msg));
		file_menu_msg.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn confirm-btn btn-ok']")));
		Boolean R1 = driver.findElement(By.xpath("//div[@class='confirm-dialog dialog ']")).isDisplayed();
		assertTrue(R1);

	}
	
}
