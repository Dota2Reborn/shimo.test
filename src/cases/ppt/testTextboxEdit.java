package cases.ppt;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.apache.commons.io.filefilter.FalseFileFilter;
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
		for (int i = 1; i < 9; i++) {
			click(down_arrow);
			WebElement template = driver
					.findElement(By.xpath("//ul[@id='sm-slide-layout']//li["+i+"]"));
			click(template);
		}
		Boolean result = doesWebElementExist(ppt_page_9);
		click(ppt_dotdotdot);
		click(ppt_delete);
		click(desktop_newFolder_name_ok);
		assertTrue(result);

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
		Boolean result1 = doesWebElementExist(ppt_page_2);
		click(ppt_revoke);
		Boolean result2 = doesWebElementExist(ppt_page_2);
		assertTrue(result2 && !result1);
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
	
	/**
	 * 调整页面排序
	 * 
	 * @author 王继程
	 * @Time 2018-07-23
	 *
	 */
	@Test(enabled = false)
	public void Sorting_Order() throws InterruptedException {
		login("SortingOrder@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_1);
		moveToElement(ppt_page_1);
//		action.clickAndHold(ppt_page_1).build().perform();
//		moveToElement(ppt_page_5);
//		action.release().perform();
		int px=-100;
		action.clickAndHold(ppt_page_1).build().perform();
		action.dragAndDropBy(ppt_page_1, 0, px).build().perform();
		//action.dragAndDropBy(ppt_page_1, 0, 100).perform();
	}
	/**
	 * 页面缩放调整
	 * 
	 * @author 王继程
	 * @Time 2018-07-23
	 *
	 */
	@Test(enabled = true)
	public void Page_Style() throws InterruptedException {
		login("pagestyle@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		for(int i=1;i<5;i++) {
			click(narrow_trying);
		}
		
		String zomm1 = getText(ppt_zoom);
		driver.navigate().refresh();
		for(int i=1;i<5;i++) {
			click(enlarge_trying);
		}
		String zomm2 = getText(ppt_zoom);
		assertEquals(zomm1,"25%");
		assertEquals(zomm2,"400%");
		
	}

}
