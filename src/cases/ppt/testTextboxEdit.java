package cases.ppt;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestInit;

public class testTextboxEdit extends TestInit {

	/**
	 * 幻灯片中新增模板页面
	 * 
	 * @author 王继程
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	public void New_Template() throws InterruptedException {
		login("NewTemplate@shimo.im", "123123");
		
		
		click(desktop_new);
		click(desktop_newslides);
		click(add_page);
		click(ppt_page_2);
		click(ppt_revoke);
		click(ppt_redo);
		
		Thread.sleep(1000);
		
//		WebElement revoke = driver.findElement(By.xpath("//div[@id='toolbar']//div[1]//div[1]//button[1]"));
//		click(revoke);
		
		
//		for (int i = 1; i < 9; i++) {
//			click(down_arrow);
//			WebElement template = driver
//					.findElement(By.xpath("//div[@class='smslide-only-container']//div[1]//div[3]//div[1]"));
//			click(template);
//		}
//		Boolean result = doesWebElementExist(ppt_page_9);
//		assertTrue(result);

	}

	/**
	 * 幻灯片中删除页面后撤销
	 * 
	 * @author 王继程
	 * @Time 2018-07-23
	 *
	 */
	@Test(enabled = true)
	public void Remove_Pages() throws InterruptedException {
		login("Addpages@shimo.im", "123123");
		click(desktop);
		click(desktop1_2);
		click(ppt_page_2);
		action.sendKeys(Keys.DELETE).perform();
		Boolean result = doesWebElementExist(ppt_page_2);
		assertFalse(result);
		click(ppt_revoke);
		result = doesWebElementExist(ppt_page_2);
		assertTrue(result);
	}

	/**
	 * 幻灯片中删除唯一页面
	 * 
	 * @author 王继程
	 * @Time 2018-07-23
	 *
	 */
	@Test(enabled = true)
	public void Remove_Pages_1() throws InterruptedException {
		login("Addpages@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		//click(ppt_text);
		click(ppt_page_1);
		action.sendKeys(Keys.DELETE).perform();
		Boolean result1 = doesWebElementExist(page_elements_2);
		click(ppt_revoke);
		Boolean result2 = doesWebElementExist(page_elements_2);
		assertTrue(result1 && !result2);
	}

}
