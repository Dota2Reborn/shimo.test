package cases;

import static org.testng.Assert.assertEquals;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

import base.TestInit;
import cases.testPermission;

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
		login("zuijin7@shimo.im","123123" );
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
    		login("zuijin7@shimo.im","123123" );
    		wait.until(ExpectedConditions.elementToBeClickable(dashboard_1));
    		dashboard_2.click();
    		
    		
    		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
        WebElement icon = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
    		icon.click();
    		Thread.sleep(500);
    		String text1 = menu_newPage.getText();
    		assertEquals(text1, "在新标签页中打开");
    	    String text2 = menu_mute.getText();
    	    assertEquals(text2, "消息免打扰");
    	    String text3 = menu_shortcut.getText();
    	    assertEquals(text3, "添加到快捷方式");
    	    String text4 = menu_collection.getText();
    	    assertEquals(text4, "收藏");
    	    String text6 = menu_cooperation.getText();
    	    assertEquals(text6, "1 人协作");
    	    String text7 = menu_move.getText();
    	    assertEquals(text7, "移动");
    	    String text9 = menu_moveToFolder.getText();
    	    assertEquals(text9, "定位到所在文件夹");
    	    String text10 = menu_rename.getText();
    	    assertEquals(text10, "重命名");
    	    String text11 = menu_creatCopy.getText();
    	    assertEquals(text11, "创建副本");
    	    String  text13 = menu_delete.getText();
    	    assertEquals(text13, "删除");
    	    
    	   }
        /**
		 *最近使用
		 * 卡片点点点，链接打开
		 * @author 陈清杰
		 * @Time2018-03-14
		 *  **/
        
        @Test
        public void used4() throws InterruptedException{
        	driver.navigate().to("https://release.shimodev.com");
    		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']")).click();
    		login("zuijin3@shimo.im","123123" );
    		wait.until(ExpectedConditions.elementToBeClickable(dashboard_1));
    	    driver.navigate().to("https://release.shimodev.com/docs/M5pgZFusSg8T1krl/");
    	    wait.until(ExpectedConditions.elementToBeClickable(b_back));
    	    b_back.click();
    	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
    	    dashboard_2.click();
    	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
    	    WebElement icon = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
    		icon.click();
    		Thread.sleep(500);
    		String text = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li")).getText();
    		assertEquals(text, "在新标签页中打开");
    		String text2 = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[2]")).getText();
    		assertEquals( text2, "收藏");
    		String text4 = driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[4]")).getText();
    		assertEquals(text4, "创建副本");
    				
          }
        /**
		 *最近使用
		 * 卡片，最近打开的排在第一位
		 * @author 陈清杰
		 * @Time2018-03-14
		 *  **/
        @Test
        public   void used5() throws InterruptedException{
        	driver.navigate().to("http://release.shimodev.com");
        	driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']")).click();
        	login("zuijin5@shimo.im", "123123");
        	wait.until(ExpectedConditions.elementToBeClickable(dashboard_1));
        	dashboard_2.click();
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a")));
       	WebElement icon2 = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a"));
       	icon2.click();
       	wait.until(ExpectedConditions.elementToBeClickable(b_back));
	    b_back.click();
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
	    dashboard_2.click();
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
	    String text = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[2]//div//a//div//div//div[2]//div")).getText();
	    assertEquals(text, "22222");
	    
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a")));
       	WebElement icon3 = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a"));
       	icon3.click();
       	wait.until(ExpectedConditions.elementToBeClickable(b_back));
	    b_back.click();
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
	    dashboard_2.click();
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
	    String text1 = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[2]//div//a//div//div//div[2]//div")).getText();
	    assertEquals(text1, "11111");
		
	    
        	
        }
        /**
		 *最近使用
		 * 卡片，自己删除文件，最近使用对应卡片消失
		 * @author 陈清杰
		 * @Time2018-03-16
		 *  **/
        @Test
        public void used6() throws InterruptedException{
        	      login("zuijin8@shimo.im", "123123");
        	      action.moveToElement(desktop_new).perform();
        		  wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
        		  desktop_newDoc.click();
        		  wait.until(ExpectedConditions.elementToBeClickable(b_back));
        		  b_back.click();
        		  wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
        	      dashboard_2.click();
        	      
        	      wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
        	      WebElement icon = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
        	      icon.click();
        	      
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[13]")));
        	      driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[13]")).click();
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-content']//div[3]//button[1]")));
        	      driver.findElement(By.xpath("//div[@class='sm-modal-content']//div[3]//button[1]")).click();
        	      
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
        	      String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
        		  assertEquals(text2, "没有文件");
        	
        	
        }
        /**
		 *最近使用
		 * 卡片，自己退出共享，最近使用对应卡片消失
		 * @author 陈清杰
		 * @Time2018-03-16
        *  **/
        @Test
        public void used7() throws InterruptedException{
        	      login("zuijin9@shimo.im", "123123");
        	      action.moveToElement(desktop_new).perform();
        		  wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
        		  desktop_newDoc.click();
        		  wait.until(ExpectedConditions.elementToBeClickable(b_back));
        		  b_back.click();
        		  
        		  wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
        	      WebElement icon = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
        	      icon.click();
        	      Thread.sleep(500);
        	      driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[6]")).click();
        	      
        	      wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
        	      input_addCollaborator.sendKeys("zuijin8@shimo.im");
        	      //验证添加按钮是否加载出来
        	      wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
        	      b_addCollaborator_1_add.click();
        	      logout();
        	      login("zuijin8@shimo.im", "123123");
        	      
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-content file-text']")));
        	      driver.findElement(By.xpath("//div[@class='file-content file-text']")).click();
        	      wait.until(ExpectedConditions.elementToBeClickable(b_back));
        		  b_back.click();
        		  wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
        		  dashboard_2.click();
        		  
        		  wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
        	      WebElement icon1 = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
        	      icon1.click();
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[13]")));
        	      driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[13]")).click();
        	      
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button")));
        	      driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button")).click();
        	      
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
        	      String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
        		  assertEquals(text2, "没有文件");
        		  logout();
        		  login("zuijin9@shimo.im", "123123");
        		  
        		  wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
        		  dashboard_2.click();
        		  wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
        	      WebElement icon3 = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
        	      icon3.click();
        	      wait.until(ExpectedConditions.elementToBeClickable(menu_delete));
        	      menu_delete.click();
        	      
        	      WebElement icon4= driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]"));
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
        	      icon4.click();
        	     
        	      
        	      
        	     }
        /**
		 *最近使用
		 * 卡片，自己被移除协作
		 * @author 陈清杰
		 * @Time2018-03-19
        *  **/
        @Test
        public void used8() throws InterruptedException{
        	       login("zuijin9@shimo.im","123123");
        	       action.moveToElement(desktop_new).perform();
      		   wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
      		   desktop_newDoc.click();
               wait.until(ExpectedConditions.elementToBeClickable(b_back));
      	       b_back.click();
      	       wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
   	           dashboard_2.click();
   	           wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
  	           WebElement icon = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
  	           icon.click();
  	           Thread.sleep(500);
  	           driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[6]")).click();
   	           
  	           wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
   	           input_addCollaborator.sendKeys("zuijin8@shimo.im");
   	           //验证添加按钮是否加载出来
   	           wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
   	           b_addCollaborator_1_add.click();
   	           logout();  
   	           login("zuijin8@shimo.im", "123123");
   	           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-content file-text']")));
  	           driver.findElement(By.xpath("//div[@class='file-content file-text']")).click();
  	           wait.until(ExpectedConditions.elementToBeClickable(b_back));
  		       logout();
  		       
  		       login("zuijin9@shimo.im", "123123");
  		       wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
 	           dashboard_2.click();
 	           wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
    	           WebElement icon1 = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
    	           icon1.click();  
    	           Thread.sleep(500);
       	       driver.findElement(By.xpath("//div[@class='category-card-container']//div//div[2]//div//div//ul//li[6]")).click();
    	      
       	       wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
       	       
 	           
   	             
  		 
   	           
   	           
   	           
   	            }
        
		

        	
        
        
        
        
	
	
	
	
	
}
