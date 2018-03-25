package cases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testAlertMute extends TestInit {
	/**
	 * 消息免打扰
	 * 
	 * @author 王继程
	 * @Time 2018-03-23
	 *
	 */
	@Test(enabled = true)
	public void New_Document() throws InterruptedException {
		login("AlertMute@shimo.im", "123123");
		
		desktop.click();

		
	}
	

}
