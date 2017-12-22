package cases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testSearch extends TestInit {
	/**
	 * 桌面搜索功能验证
	 * 
	 * @author 刘晨
	 * @Time 2017-12-22
	 *
	 */
	@Test(enabled = true)
	public void dashboard_update() throws InterruptedException {
		login("liuchen@shimo.im", "123123");
		action.moveToElement(dashboard_search_button).perform();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_search_input));
		dashboard_search_input.sendKeys("搜索测试");
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_search_result_1));
		dashboard_search_result_1.click();
		Thread.sleep(2000);
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(b_back));

		String title = driver.getTitle();
		assertEquals(title, "搜索测试");

	}
}
