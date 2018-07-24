package cases.ppt;


import static org.testng.Assert.assertFalse;
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
		click(desktop);
		click(desktop1_1);
		click(ppt_page_2);
		action.sendKeys(Keys.DELETE).perform();
		Boolean result = doesWebElementExist(ppt_page_2);
		assertFalse(result);
		Thread.sleep(4000);
		Boolean chexiao = doesWebElementExist(ppt_revoke);
		System.out.println(chexiao);
		click(ppt_revoke);
		result = doesWebElementExist(ppt_page_2);
		assertTrue(result);
	}


	
	

}
