package cases.drag;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

import org.openqa.selenium.interactions.Action;

public class testtest extends TestInit  {
	/**
	 * 拖拽文件夹到快捷方式
	 * 
	 * @author 王继程
	 * @Time 2018-05-07
	 *
	 */
	@Test(enabled = true)
	 public void Dragging_folders() throws InterruptedException{
		login("Dragging_folders@shimo.im", "123123");
		//WebDriver driver = new FirefoxDriver();

		//Puts a Implicit wait, Will wait for 10 seconds before throwing exception
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Launch website
		//driver.manage().window().maximize();
//		driver.navigate().to("http://keenthemes.com/preview/metronic/theme/admin_1/ui_tree.html");
//	 	WebElement From = driver.findElement(By.xpath(".//*[@id='j3_7']/a"));
//		WebElement To = driver.findElement(By.xpath(".//*[@id='j3_1']/a"));
		
//		desktop.click();
//		Thread.sleep(2000);
//		WebElement From = driver.findElement(By.xpath(".//div[@class='ReactVirtualized__Grid__innerScrollContainer']//div[1]//div[1]"));
//		WebElement To = driver.findElement(By.xpath(".//ul[@id='right-sidebar-shortcuts']//li[2]"));
//		
//		Actions builder = new Actions(driver);
//		Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
//		dragAndDrop.perform();
		
//		desktop.click();
//		Thread.sleep(2000);
//		WebElement  element = driver.findElement(By.xpath(".//*[@class='ReactVirtualized__Grid__innerScrollContainer']//div[1]//div[1]"));  
//        WebElement  target = driver.findElement(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']//div[1]//div[contains(@class,'folder-tile')]"));  
//        (new Actions(driver)).dragAndDrop(element, target).perform();  
		
		click(desktop);
		Thread.sleep(2000);
//		action.clickAndHold(desktop_shortcut_Increase).moveToElement(desktop1_1).perform();
//		action.release();
		
		
		
		Actions action = new Actions(driver);
		for (int i = 0; i < 5; i++) {
			action.dragAndDropBy(desktop1_1, 10, 0).build().perform();
			
		}
		//action.dragAndDrop(desktop1_1,desktop_shortcut_Increase).perform();
		//move_to_element_with_offset
		//action.moveToElement(desktop1_1).moveByOffset(50,50).perform();
//		action.moveToElement(desktop_new).perform();
//		Thread.sleep(5000);
//		WebElement From = driver.findElement(By.xpath(".//*[@id='j1_1_anchor']/a"));
//		WebElement To = driver.findElement(By.xpath(".//*[@id='j3_1']/a"));
		action.moveToElement(desktop1_1).perform();
		Thread.sleep(5000);
		//action.moveToElement(desktop_new).perform();
		action.dragAndDrop(desktop1_1,desktop_shortcut_Increase).perform();
		action.clickAndHold(desktop1_1).perform();
		//action.clickAndHold().perform();
		//action.dragAndDrop(desktop1_1,desktop_shortcut_Increase);
		Thread.sleep(4000);
		//action.moveByOffset(100,100).perform();
		//drag_and_drop
		
		action.moveToElement(desktop_shortcut_Increase,20,20).perform();
		Thread.sleep(4000);
		action.release().perform();
		
	   }

	

}
