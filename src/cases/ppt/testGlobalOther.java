package cases.ppt;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.TestInit;

public class testGlobalOther extends TestInit {//全局其他
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
