package cases.docSheet;

import static org.testng.Assert.assertEquals;
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

		click(desktop);
		click(desktop1_1);
		click(doc_menu);
		moveToElement(file_menu_help);
		click(file_menu_msg);

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

		click(desktop);
		click(desktop1_1);
		click(doc_menu);
		moveToElement(file_menu_help);
		click(file_menu_msg);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn confirm-btn btn-ok']")));
		Boolean R1 = driver.findElement(By.xpath("//div[@class='confirm-dialog dialog ']")).isDisplayed();
		assertTrue(R1);

	}

	@Test(enabled = false)
	public void test() throws InterruptedException {
		login("autoTest15@shimo.im", "123123");

		click(desktop);
		click(desktop1_1);
		wait.until(ExpectedConditions.elementToBeClickable(doc_menu));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String msg1 = js.executeScript("return pad.quill.constructor.version").toString();
		System.out.println(">>>>>>>>>result<<<<<<<<<<<:" + msg1);
		assertEquals("1.26.0", msg1);
	}
}
