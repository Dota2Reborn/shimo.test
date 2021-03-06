package cases.ppt;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestInit;

public class testShapeRectangle extends TestInit{
	
	public void makeSure() {
		boolean result = page_elements_2.isDisplayed();
		assertTrue(result);	
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
		action.click(ppt_text).build().perform();
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
		click(ppt_page_3);
		action.click(page_elements_1).sendKeys(Keys.chord(Keys.CONTROL,"c"))
		.sendKeys(Keys.chord(Keys.CONTROL,"v")).build().perform();
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
		click(ppt_page_3);
		action.click(page_elements_1).sendKeys(Keys.chord(Keys.CONTROL,"c")).build().perform();
		click(ppt_page_6);
		action.click(page_elements_1).sendKeys(Keys.chord(Keys.CONTROL,"v")).build().perform();
		Boolean result = doesWebElementExist(page_elements_2);
		assertFalse(result);
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
		click(ppt_page_3);
		action.click(page_elements_1).sendKeys(Keys.chord(Keys.CONTROL,"c")).build().perform();
		click(ppt_page_4);
		action.click(page_elements_1).sendKeys(Keys.chord(Keys.CONTROL,"v")).build().perform();
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
		click(ppt_page_3);
		action.click(page_elements_1).sendKeys(Keys.chord(Keys.CONTROL,"c")).build().perform();
		click(ppt_page_5);
		action.click(page_elements_1).sendKeys(Keys.chord(Keys.CONTROL,"v")).build().perform();
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
		click(ppt_page_3);
		action.click(page_elements_1).sendKeys(Keys.chord(Keys.CONTROL,"c")).build().perform();
		click(ppt_page_1);
		action.sendKeys(Keys.chord(Keys.CONTROL,"v")).build().perform();
		Boolean result = doesWebElementExist(page_elements_1);
		assertTrue(result);
		//click(page_elements_1);
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
		click(ppt_page_3);
		action.click(page_elements_1).sendKeys(Keys.chord(Keys.CONTROL,"c"))
		.sendKeys(Keys.DELETE).sendKeys(Keys.chord(Keys.CONTROL,"v")).build().perform();
		Boolean result = doesWebElementExist(page_elements_1);
		assertFalse(result);
		click(ppt_revoke);
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
		click(ppt_page_3);
		Point location = page_elements_1.getLocation();
		System.out.println("location="+location);
		action.clickAndHold(page_elements_1);
		action.dragAndDropBy(page_elements_1, 50, 50).build().perform();
		action.release();
		Point location1 = page_elements_1.getLocation();
		System.out.println("location1="+location1);
		assertTrue(!location.equals(location1));
		click(ppt_revoke);
	}
	
	
	/**
	 * 缩放矩形
	 * 
	 * @author 张家晶
	 * @Time 2018-07-31
	 *
	 */
	@Test(enabled = true)
	 public void Resize_rect() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(add_Rectangle);
		action.click(ppt_text).build().perform();
		WebElement beforeRect = driver.findElement(By.xpath("//div[@class='smslide-action-layer']//div[1]//div[2]"));
		Dimension size = beforeRect.getSize();
		System.out.println("size="+size);
		for(int i = 1; i < 4; i++ ) {
			int j = 2*i-1;
			WebElement northEast = driver.findElement(By.xpath("//div[@class='smslide-action-layer']//div[1]//div[2]//div[1]//div["+j+"]"));
			moveToElement(northEast);
			action.clickAndHold(northEast);
			action.dragAndDropBy(northEast, 50, 50).build().perform();
			action.release();
			driver.navigate().refresh();
			click(page_elements_1);
		}
		WebElement afterRect = driver.findElement(By.xpath("//div[@class='smslide-action-layer']//div[1]//div[2]"));
		Dimension size1 = afterRect.getSize();
		System.out.println("size1="+size1);
		assertTrue(!size.equals(size1));
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
		action.click(ppt_text).build().perform();
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
		click(page_elements_1);
		action.sendKeys(Keys.BACK_SPACE).perform();
		result = doesWebElementExist(page_elements_1);
		assertFalse(result);
	}
	
	/**
	 * 设置矩形样式
	 * 
	 * @author 张家晶
	 * @Time 2018-08-14
	 *
	 */
	@Test(enabled = true)
	 public void Rectangle_styles() throws InterruptedException{
		login("test_zjj@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(ppt_page_3);
		click(page_elements_1);
		String fill = page_elements_1.getCssValue("fill"); 
		System.out.println("fill="+fill);
		click(type_shapes_template1);
		String fill2 = page_elements_1.getCssValue("fill"); 
		System.out.println("fill2="+fill2);
		assertTrue(!fill.equals(fill2));
		click(ppt_revoke);
		
		/*WebElement setTop = driver.findElement(By.xpath("//div[@class='container-section flex-align-center']//button[4]"));
		click(setTop);
		action.moveByOffset(0, 100).clickAndHold().moveByOffset(100, 100).click().build().perform();
		String stroke = setTop.getCssValue("stroke");//形状边框线颜色
		String strokeWidth = setTop.getCssValue("stroke-width"); //形状边框线宽度
		String fill = setTop.getCssValue("fill"); //矩形，圆形填充色
		System.out.println("stroke="+stroke + " ===== " +"strokeWidth="+ strokeWidth + "====="+ "fill=" + fill);*/
		
	}
	
	
	
	
	
	
	
	
}
