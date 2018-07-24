package cases.ppt;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import base.TestInit;

public class testTextboxEdit extends TestInit{
	
	/**
	 * 幻灯片中新增模板页面
	 * 
	 * @author 王继程
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	public void New_Template() throws InterruptedException {
		login("Addpages@shimo.im","123123");
		click(desktop_new);
		click(desktop_newslides);
		click(down_arrow);
		Boolean result = doesWebElementExist(ppt_page_2);
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
	public void Add_pages() throws InterruptedException {
		login("Addpages@shimo.im","123123");
		click(desktop_new);
		click(desktop_newslides);
		click(add_page);
//		Boolean result = doesWebElementExist(ppt_page_2);
//		assertTrue(result);
		click(ppt_page_2);
		click(ppt_page_2);
		click(ppt_page_1);
		action.sendKeys(Keys.BACK_SPACE);

		
	}


	
	

}
