package cases;

import org.testng.annotations.Test;

import base.TestInit;

public class testRecycleBin extends TestInit{
	/**
	 * 删除文件后恢复
	 * 
	 * @author 王继程
	 * @Time 2018-03-12
	 *
	 */
	@Test(enabled = true)
	public void New_Document() throws InterruptedException {
		login("RecycleBin@shimo.im", "123123");
		
		
	}

}
