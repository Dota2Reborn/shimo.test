package cases.ppt;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestInit;

public class testPictureUP extends TestInit{
	
	
	public int  formateData(Point point) {
		String data = point.toString();
		String dataSub = data.substring(1, data.length()-1);
		String[] dataSp = dataSub.split(",");
		int dataX = Integer.parseInt(dataSp[0]);
		return dataX;
	}
	
	/**
	 * 上方工具栏添加单张图片
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = false)
	 public void Add_img() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);//"E:\\testImg\\11.png" "E:\\testImg\\12.jpg" "E:\\testImg\\13.jpg"
		StringSelection sel = new StringSelection( "E:\\testImg\\11.png" );
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		click(add_diagram);
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);    
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Boolean result = page_elements_1.isDisplayed();
		assertTrue(result);
		/*action.keyDown(Keys.SHIFT).click(page_elements_1).click(page_elements_2)
		.click(page_elements_3).keyUp(Keys.SHIFT).build().perform();*/
		click(page_elements_1);
		action.sendKeys(Keys.DELETE).perform();
	}
	
	
	/**
	 * 点击占位符上传图片
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = false)
	 public void Add_imga() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		StringSelection sel = new StringSelection("E:\\testImg\\11.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		click(ppt_page_7);
		click(page_elements_1);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);    
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Boolean result = doesWebElementExist(page_elements_1);
		assertTrue(result);
		click(page_elements_1);
		action.sendKeys(Keys.DELETE).perform();
	}
	
	
	/**
	 * 复制图片
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = true)
	 public void Copy_imgs() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_5);
		click(page_elements_1);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);    
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Boolean result = doesWebElementExist(page_elements_2);
		assertTrue(result);
		action.sendKeys(Keys.DELETE).perform();
	}
	
	/**
	 * 复制图片后点击文本框
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = true)
	 public void copyImg_clickTextbox() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_5);
		click(page_elements_1);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C); 
		click(ppt_page_6);
		click(page_elements_1);
		click(ppt_page_5);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Boolean result = doesWebElementExist(page_elements_2);
		assertTrue(result);
		action.sendKeys(Keys.DELETE).perform();
	}
	
	
	/**
	 * 复制图片后点击形状
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = true)
	 public void copyImg_clickShape() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_5);
		click(page_elements_1);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C); 
		click(ppt_page_4);
		click(page_elements_1);
		click(ppt_page_5);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Boolean result = doesWebElementExist(page_elements_2);
		assertTrue(result);
		action.sendKeys(Keys.DELETE).perform();
	}
	
	/**
	 * 复制图片到另一个页面
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = true)
	 public void copyImg_clickPage() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_5);
		click(page_elements_1);
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
		action.sendKeys(Keys.DELETE).perform();
	}
	
	/**
	 * 复制后删除当前选中图片粘贴
	 * 
	 * @author 张家晶
	 * @throws AWTException 
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = true)
	 public void DeleteCopy_Img() throws InterruptedException, AWTException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_5);
		click(page_elements_1);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_C);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_C);
		action.sendKeys(Keys.DELETE).perform();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Boolean result = doesWebElementExist(page_elements_1);
		assertFalse(result);
		click(ppt_revoke);
	}
	
	
	/**
	 * 删除图片后撤销，撤销后重做
	 * 
	 * @author 张家晶
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = true)
	 public void Delete_Img() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_5);
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
		click(ppt_revoke);
	}
	
	
	/**
	 * 拖拽图片
	 * 
	 * @author 张家晶
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = true)
	 public void Drag_Img() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_5);
		click(page_elements_1);
		Point location = page_elements_1.getLocation();
		int loc = formateData(location);
		System.out.println("loc="+loc);
		action.clickAndHold(page_elements_1);
		action.dragAndDropBy(page_elements_1, 50, 0).build().perform();
		action.release();
		Point location1 = page_elements_1.getLocation();
		int loc1 = formateData(location1);
		System.out.println("loc1="+loc1);
		assertTrue(loc1-loc <= 50);
	}
	
	/**
	 * 缩放图片
	 * 
	 * @author 张家晶
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = false)
	 public void Resize_Img() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_5);
		click(page_elements_1);
		WebElement beforeImg = driver.findElement(By.xpath("//div[@class='smslide-action-layer']//div[1]//div[2]"));
		String beforeH = beforeImg.getCssValue("height");
		String bef = beforeH.substring(0 , beforeH.length()-2);
		int heightN = (int)Float.parseFloat(bef);
		System.out.println("heightN="+heightN);
		WebElement northEast = driver.findElement(By.xpath("//div[@class='smslide-action-layer']//div[1]//div[2]//div[1]//div[2]"));
		moveToElement(northEast);
		action.clickAndHold(northEast);
		int px = 20;
		action.dragAndDropBy(northEast, 0, px).build().perform();
		action.release();
		WebElement afterImg = driver.findElement(By.xpath("//div[@class='smslide-action-layer']//div[1]//div[2]"));
		String afterH = afterImg.getCssValue("height");
		String afH = afterH.substring(0 , afterH.length()-2);
		int heg = (int)Float.parseFloat(afH);
		System.out.println("heg="+heg);
		System.out.println(heightN == heg + px);
		assertTrue(heightN == heg + px);
	}
	

}
