package cases.ppt;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestInit;

public class testShapeRectangle extends TestInit{
	
	public void makeSure() {
		WebElement arrowCopy = driver.findElement(By.xpath("//div[@id='editor']//div[1]//div[1]//div[1]//div[6]"));
		boolean result = arrowCopy.isDisplayed();
		assertTrue(result);	
		action.moveToElement(arrowCopy).click().perform();
		action.sendKeys(Keys.DELETE).perform();
	}
	
	
	public int  formateData(Point point) {
		String data = point.toString();
		String dataSub = data.substring(1, data.length()-1);
		String[] dataSp = dataSub.split(",");
		int dataX = Integer.parseInt(dataSp[0]);
		return dataX;
	}
	
	/**
	 * 新增矩形
	 * 
	 * @author 张家晶
	 * @Time 2018-07-26
	 *
	 */
	@Test(enabled = true)
	 public void Add_rectangle() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(add_Rectangle);
		Boolean result = doesWebElementExist(page_elements_1);
		assertTrue(result);
		click(page_elements_1);
		action.sendKeys(Keys.DELETE).perform();
	}
	
	/**
	 * 复制矩形
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-26
	 *
	 */
	@Test(enabled = true)
	 public void Copy_rectangle() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_3);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		makeSure();
	}
	
	/**
	 * 复制矩形点击文本框后粘贴
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-26
	 *
	 */
	@Test(enabled = false)
	 public void copyRectangle_clickTextbox() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_3);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C); 
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		click(page_elements_5);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		makeSure();
	}
	
	/**
	 * 复制矩形点击形状后粘贴
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-27
	 *
	 */
	@Test(enabled = true)
	 public void copyRectangle_clickShape() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_3);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		click(page_elements_2);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		makeSure();
	}
	
	/**
	 * 复制矩形点击图片后粘贴
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-27
	 *
	 */
	@Test(enabled = true)
	 public void copyRectangle_clickImg() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_3);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		click(page_elements_1);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		makeSure();
	}
	
	/**
	 * 复制矩形到另一个页面
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-27
	 *
	 */
	@Test(enabled = true)
	 public void copyRectangle_clickPage() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_3);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		click(ppt_page_1);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Boolean result = doesWebElementExist(page_elements_1);
		assertTrue(result);
		click(page_elements_1);
		action.sendKeys(Keys.DELETE).perform();
	}
	
	/**
	 * 复制后删除矩形粘贴
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-27
	 *
	 */
	@Test(enabled = true)
	 public void DeleteCopy_Rectangle() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(add_Rectangle);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		click(page_elements_1);
		action.sendKeys(Keys.DELETE).perform();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Boolean result = doesWebElementExist(page_elements_1);
		assertFalse(result);
	}
	
	/**
	 * 拖拽矩形
	 * 
	 * @author 张家晶
	 * @Time 2018-07-27
	 *
	 */
	@Test(enabled = true)
	 public void Drag_Rectangle() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(add_Rectangle);
		//click(page_elements_1);
		Point location = page_elements_1.getLocation();
		int loc = formateData(location);
		System.out.println("loc="+loc);
		action.clickAndHold(page_elements_1);
		action.dragAndDropBy(page_elements_1, 100, 0).build().perform();
		action.release();
		Point location1 = page_elements_1.getLocation();
		int loc1 = formateData(location1);
		System.out.println("loc1="+loc1);
		assertTrue(loc1-loc == 100);
		click(page_elements_1);
		action.sendKeys(Keys.DELETE).perform();
	}
	
	/**
	 * 删除矩形后撤销，撤销后重做
	 * 
	 * @author 张家晶
	 * @Time 2018-07-27
	 *
	 */
	@Test(enabled = true)
	 public void Delete_Rectangle() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(add_Rectangle);
		action.sendKeys(Keys.DELETE).perform();
		Boolean result = doesWebElementExist(page_elements_1);
		assertFalse(result);
		click(ppt_revoke);
		result = doesWebElementExist(page_elements_1);
		assertTrue(result);
		click(ppt_redo);
		result = doesWebElementExist(page_elements_1);
		assertFalse(result);
	}
	
	
}
