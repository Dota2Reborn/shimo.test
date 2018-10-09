package cases.ppt;



import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.TestInit;

public class testTextboxEdit extends TestInit {//编辑文本框

	/**
	 * 
	 * 
	 * @author 王继程
	 * @Time 2018-07-24
	 *
	 */
	@Test(enabled = true)
	public void Text_Editing() throws InterruptedException {
		login("textediting@shimo.im","123123");
		click(desktop);
		click(desktop1_1);
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HHmmss");
		String time1 = format.format(date);
		click(page_elements_1);
		for(int i=1;i<7;i++) {
			action.sendKeys(Keys.BACK_SPACE).click().perform();
		}
		//action.sendKeys(time1);
		WebElement circle = driver.findElement(By.xpath("//div[@id='editor']//div[1]//div[1]//div[1]//div[1]//div[2]"));
		action.sendKeys(time1);
		driver.navigate().refresh();
		String time2=getText(page_elements_1);
		assertEquals(time1, time2);
		
		
		
	}
	

}
