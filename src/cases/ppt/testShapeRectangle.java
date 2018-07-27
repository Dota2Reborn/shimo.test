package cases.ppt;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestInit;

public class testShapeRectangle extends TestInit{
	
	public void makeSure() {
		WebElement arrowCopy = driver.findElement(By.xpath("//div[@class='smslide-only-container']//div[1]//div[6]"));
		boolean result = arrowCopy.isDisplayed();
		assertTrue(result);	
		action.moveToElement(arrowCopy).click().perform();
		action.sendKeys(Keys.DELETE).perform();
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
		click(page_elements_5);
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
	@Test(enabled = true)
	 public void copyRectangle_clickTextbox() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		Thread.sleep(2000);
		click(ppt_page_2);
		click(page_elements_5);
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
	
}
