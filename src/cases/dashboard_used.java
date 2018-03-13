package cases;

import static org.testng.Assert.assertEquals;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

import base.TestInit;

public class dashboard_used  extends TestInit {

	/**
	 *最近使用
	 * 卡片样式验证
	 * @author 陈清杰
	 * @Time 2018-03-06
	 */
	@Test
	public void used1() throws InterruptedException{
		
		driver.navigate().to("https://release.shimodev.com");
		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']")).click();
		login("zuijin@shimo.im", "123123");
		
	    action.moveToElement(desktop_new).perform();
	    wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
	    desktop_newDoc.click();
	    wait.until(ExpectedConditions.elementToBeClickable(b_back));
	    b_back.click();
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
	    dashboard_2.click();
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
		String text = dashboard_update_time.getText();
		assertEquals(text, "刚刚 我 打开");

	    }
	/**
	 *最近使用
	 * hover卡片收藏验证
	 * @author 陈清杰
	 * @Time 2018-03-06
	 */
	    @Test
	    public void used2() throws InterruptedException{
		driver.navigate().to("https://release.shimodev.com");
		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']")).click();
		login("zuijin1@shimo.im","123123" );
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_1));
		dashboard_2.click();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
		WebElement card = driver.findElement(By.xpath("//div[@class='category-card-container']"));
		action.moveToElement(card).perform();
		driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).click();
		Thread.sleep(1000);
	    favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tile-inner']//div//a//div[2]")));
		String text=driver.findElement(By.xpath("//div[@class='tile-inner']//div//a//div[2]")).getText();
		assertEquals(text, "最近使用");
		
		dashboard.click();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
	    dashboard_2.click();
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
		WebElement card1 = driver.findElement(By.xpath("//div[@class='category-card-container']"));
		action.moveToElement(card1).perform();
		driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).click();
		Thread.sleep(1000);
		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text2, "没有文件");
		
		}
	    /**
		 *最近使用
		 * 卡片点点点选项验证（正常）
		 * @author 陈清杰
		 * @Time2018-03-07
		 *  **/
        @Test
	    public void used3() throws InterruptedException{
        	    
        	driver.navigate().to("https://release.shimodev.com");
    		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']")).click();
    		login("zuijin1@shimo.im","123123" );
    		wait.until(ExpectedConditions.elementToBeClickable(dashboard_1));
    		dashboard_2.click();
    		
    		
    		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
        WebElement icon = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
    		icon.click();
    		Thread.sleep(500);
    		String text1 = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li")).getText();
    		assertEquals(text1, "在新标签页中打开");
    	    String text2 = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[2]")).getText();
    	    assertEquals(text2, "消息免打扰");
    	    String text3 = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[3]")).getText();
    	    assertEquals(text3, "添加到快捷方式");
    	    String text4 = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[4]")).getText();
    	    assertEquals(text4, "收藏");
    	    String text5 = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[5]")).getText();
    	    assertEquals(text5, "1 人协作");
    	    String text6 = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[6]")).getText();
    	    assertEquals(text6, "移动");
    	    String text7 = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[7]")).getText();
    	    assertEquals(text7, "定位到所在文件夹");
    	    String text8 = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[8]")).getText();
    	    assertEquals(text8, "重命名");
    	    
    		
        	
        	
	    	
	    	
	    	
	    }
	
	
	
	
	
}
