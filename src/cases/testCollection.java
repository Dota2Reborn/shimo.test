package cases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testCollection extends TestInit {
	/**
	 * 我的收藏
	 * 
	 * @author 王继程
	 * @Time 2018-03-12
	 *
	 */
	@Test(enabled = true)
	public void Add_to() throws InterruptedException {
		login("Collection@shimo.im","123123");
		favorites.click();
		
		
		
	}

}
