package cases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testCollection extends TestInit {

	/**
	 * 新建文档收藏
	 * 
	 * @author 王继程
	 * @Time 2018-03-12
	 *
	 */
	@Test(enabled = true)
	public void New_Document() throws InterruptedException {
		login("New_collection@shimo.im", "123123");
		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(Collection_OK));
		Collection_OK.click();
		
		b_back.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		favorites.click();
		action.contextClick(desktop1_1).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();
		
	}
	/**
	 * 新建表格收藏
	 * 
	 * @author 王继程
	 * @Time 2018-03-12
	 *
	 */
	@Test(enabled = true)
	public void Create_Table() throws InterruptedException {
		login("New_collection@shimo.im", "123123");
		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newSheet));
		desktop_newSheet.click();
		wait.until(ExpectedConditions.elementToBeClickable(Collection_OK));
		Collection_OK.click();
		
		b_back.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		favorites.click();
		action.contextClick(desktop1_1).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();
		
	}
	/**
	 * 收藏页面文件排序
	 * 
	 * @author 王继程
	 * @Time 2018-03-12
	 *
	 */
	@Test(enabled = true)
	public void Collection_Sort() throws InterruptedException {
		login("New_collection@shimo.im", "123123");
		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(Collection_OK));
		Collection_OK.click();
		
		b_back.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		favorites.click();
		action.contextClick(desktop1_1).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(desktop_setting_doc_11));
		desktop_setting_doc_11.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();
		
	}

}
