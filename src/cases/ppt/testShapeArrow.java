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

public class testShapeArrow extends TestInit{
	
	
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
	@Test(enabled = false)
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
		click(page_elements_1);
		action.sendKeys(Keys.DELETE).perform();
	}
	
	
	/**
	 * 复制后删除箭头粘贴
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-27
	 *
	 */
	@Test(enabled = true)
	 public void DeleteCopy_arrow() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(add_arrows);
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
	 * 调整箭头
	 * 
	 * @author 张家晶
	 * @Time 2018-07-26
	 *
	 */
	@Test(enabled = true)
	 public void Resize_arrow() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(add_arrows);
		//click(page_elements_1);
		WebElement beforeArrow = driver.findElement(By.xpath("//div[@class='smslide-action-layer']//div[1]//div[2]"));
		//int beforeH = Integer.parseInt(beforeArrow.getCssValue("height"));
		String beforeH = beforeArrow.getCssValue("height");
		String bef = beforeH.substring(0 , beforeH.length()-2);
		int heightN = (int)Float.parseFloat(bef);
		System.out.println("heightN="+heightN);
		WebElement arrowStart = driver.findElement(By.xpath("//div[@class='smslide-action-layer']//div[1]//div[2]//div[1]//div[1]"));
		moveToElement(arrowStart);
		action.clickAndHold(arrowStart);
		int px = 30;
		action.dragAndDropBy(arrowStart, 0, px).build().perform();
		driver.navigate().refresh();
		click(page_elements_1);
		WebElement arrow = driver.findElement(By.xpath("//div[@class='smslide-action-layer']//div[1]//div[2]"));
		String afterH = arrow.getCssValue("height");
		String afH = afterH.substring(0 , afterH.length()-2);
		int heg = (int)Float.parseFloat(afH);
		System.out.println("heg="+heg);
		System.out.println(heightN == heg + px);
		assertTrue(heightN == heg + px);
		click(page_elements_1);
		action.sendKeys(Keys.DELETE).perform();
		
	}
	
	
	/**
	 * 设置箭头样式
	 * 
	 * @author 张家晶
	 * @Time 2018-07-27
	 *
	 */
	@Test(enabled = false)
	 public void Arrow_Style() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(page_elements_1);
		String stroke = page_elements_1.getCssValue("stroke");
		System.out.println("stroke="+stroke);
		
	}
	
	/**
	 * 拖拽箭头
	 * 
	 * @author 张家晶
	 * @Time 2018-07-27
	 *
	 */
	@Test(enabled = true)
	 public void Drag_arrow() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(add_arrows);
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
	 * 调整箭头层级
	 * 
	 * @author 张家晶
	 * @Time 2018-07-27
	 *
	 */
	@Test(enabled = false)
	 public void Arrow_AjustLevel() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_3);
		action.moveToElement(page_elements_3).click();
		String stroke = page_elements_3.getCssValue("z-index");
		System.out.println("stroke="+stroke);
		WebElement setTop = driver.findElement(By.xpath("//div[@id='sidebar']//div[1]//div[2]//div[3]//div[1]//button[1]"));
		System.out.println("setTop="+setTop);
		action.moveToElement(setTop).click();
		String stroke1 = page_elements_3.getCssValue("z-index");
		System.out.println("stroke1="+stroke1);
		
		
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
		click(add_arrows);
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
