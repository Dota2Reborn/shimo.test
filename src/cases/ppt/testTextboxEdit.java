package cases.ppt;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import base.TestInit;

public class testTextboxEdit extends TestInit{
	/**
	 * 幻灯片中新增页面
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
		int i;
//		for(i=0;i<5;i++) {
//			click(add_page);
//		}
		click(add_page);
//		driver.navigate().refresh();
//		click(ppt_page_1);
//		click(ppt_page_2);
//		click(ppt_page_3);
//		click(ppt_page_4);
//		click(ppt_page_1);
//		click(ppt_page_2);
//		click(ppt_page_3);
//		click(ppt_page_4);
//		Thread.sleep(6000);
		Boolean result = doesWebElementExist(ppt_page_2);
		assertTrue(result);
		System.out.println(result);
		
	}

}
