package cases.ppt;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.TestInit;

public class testShapeArrow extends TestInit{
	
	
	public void makeSure() {
		WebElement arrowCopy = driver.findElement(By.xpath("//div[@class='smslide-only-container']//div[1]//div[6]"));
		boolean result = arrowCopy.isDisplayed();
		assertTrue(result);	
		action.moveToElement(arrowCopy).click().perform();
		action.sendKeys(Keys.DELETE).perform();
		
	}
	
	/**
	 * 新增箭头
	 * 
	 * @author 张家晶
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	 public void Add_arrow() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(add_arrows);
		Boolean result = doesWebElementExist(page_elements_1);
		assertTrue(result);
		click(page_elements_1);
		action.sendKeys(Keys.DELETE).perform();
	}
	
	
	
	
	
	
	/**
	 * 复制箭头
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	 public void Copy_arrow() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_4);
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
	 * 复制箭头点击文本框后粘贴
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	 public void copyArrow_clickTextbox() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_4);
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
	 * 复制箭头点击形状后粘贴
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	 public void copyArrow_clickShape() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_4);
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
	 * 复制箭头点击图片后粘贴
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	 public void copyArrow_clickImg() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_4);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		click(page_elements_3);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		makeSure();
	}
	
	/**
	 * 复制箭头到另一个页面
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-25
	 *
	 */
	@Test(enabled = true)
	 public void copyArrow_clickPage() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_4);
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
	}
	
	/**
	 * 调整箭头
	 * 
	 * @author 张家晶
	 * @Time 2018-07-25
	 *
	 */
	@Test(enabled = true)
	 public void Resize_arrow() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(page_elements_1);
		WebElement arrowStart = driver.findElement(By.xpath("//div[@class='smslide-only-container']//div[3]//div[1]//div[2]//div[1]//div[1]"));
		moveToElement(arrowStart);
		System.out.println(arrowStart);
		//action.clickAndHold(arrowStart);
		for (int j = 1; j < 6; j++) {
			//action.dragAndDropBy(arrowStart, j*30, -j*50).build().perform();
			action.clickAndHold(arrowStart).dragAndDropBy(arrowStart, j*30, j*50).build().perform();
		}
	}
	
	/**
	 * 删除箭头后撤销，撤销后重做
	 * 
	 * @author 张家晶
	 * @Time 2018-07-25
	 *
	 */
	@Test(enabled = true)
	 public void Delete_arrow() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(page_elements_1);
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
