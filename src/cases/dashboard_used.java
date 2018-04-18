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
	 * 账号状态：没有文件
	 */
	@Test
	public void used1() throws InterruptedException{
		
		login("zuijin@shimo.im", "123123");
		click(desktop_new);
	    click(desktop_newDoc);
	    click(b_back);
	    click(dashboard_2);
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_time));
		String text = dashboard_update_time.getText();
		assertEquals(text, "刚刚 我 打开");

	    }
	/**
	 *最近使用
	 * hover卡片收藏验证
	 * @author 陈清杰
	 * @Time 2018-03-06
	 * 账号状态：有一个固定文件名为：最近使用
	 */
	    @Test
	    public void used2() throws InterruptedException{
		
		login("zuijin7@shimo.im","123123" );
		click(dashboard_2);
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_name));
		action.moveToElement(dashboard_update_name).perform();
		driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).click();
		Thread.sleep(1000);
	    click(favorites);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tile-inner']//div//a//div[2]")));
		String text=driver.findElement(By.xpath("//div[@class='tile-inner']//div//a//div[2]")).getText();
		assertEquals(text, "最近使用");
		
		click(dashboard);
	    click(dashboard_2);
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_name));
		action.moveToElement(dashboard_update_name).perform();
		driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).click();
		Thread.sleep(1000);
		click(favorites);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text2, "没有文件");
		
		}
	    /**
		 *最近使用
		 * 卡片点点点选项验证（正常）
		 * @author 陈清杰
		 * @Time2018-03-07
		 * 账号状态：有一个固定文件
		 *  **/
        @Test
	    public void used3() throws InterruptedException{
        	    
        login("zuijin7@shimo.im","123123" );
    		click(dashboard_2);
    		
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
		 * 账号状态：有一个链接打开的文件，地址为：https://release.shimodev.com/docs/M5pgZFusSg8T1krl/
		 *  **/
        
        @Test
        public void used4() throws InterruptedException{
        	
    		login("zuijin3@shimo.im","123123" );
    	    click(dashboard_2);
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
		 * 账号状态：有两个文件
		 *  **/
        @Test
        public void used5() throws InterruptedException{
        
        	login("zuijin5@shimo.im", "123123");
        	
        	wait.until(ExpectedConditions.elementToBeClickable(dashboard_1));
        	dashboard_2.click();
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a")));
       	WebElement icon2 = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a"));
       	icon2.click();
       	wait.until(ExpectedConditions.elementToBeClickable(b_back));
	    click(b_back);
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
	    dashboard_2.click();
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
	    String text = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[2]//div//a//div//div//div[2]//div[1]//div[1]")).getText();
	    assertEquals(text, "22222");
	    
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a")));
       	WebElement icon3 = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a"));
       	icon3.click();
       	wait.until(ExpectedConditions.elementToBeClickable(b_back));
	    click(b_back);
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
	    dashboard_2.click();
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
	    String text1 = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[2]//div//a//div//div//div[2]//div[1]//div[1]")).getText();
	    assertEquals(text1, "11111");
		
	    
        	
        }
        /**
		 *最近使用
		 * 卡片，自己删除文件，最近使用对应卡片消失
		 * @author 陈清杰
		 * @Time2018-03-16
		 * 账号状态：没有文件
		 *  **/
        @Test
        public void used6() throws InterruptedException{
        	      login("zuijin66@shimo.im", "123123");
        	      click(desktop_new);
        		  click(desktop_newDoc);
        		  click(b_back);
        		  click(dashboard_2);
        	      
        	      wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
        	      WebElement icon = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
        	      icon.click();
        	      click(menu_delete);
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
        		  driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]")).click();
        	      
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
        	      String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
        		  assertEquals(text2, "没有文件");
        	
        	
        }
        /**
		 *最近使用
		 * 卡片，自己退出共享，最近使用对应卡片消失
		 * @author 陈清杰
		 * @Time2018-03-16
		 * 账号状态：没有文件
        *  **/
        @Test
        public void used7() throws InterruptedException{
        	      login("zuijin9@shimo.im", "123123");
        	      click(desktop_new);
        	      click(desktop_newDoc);
        	      click(b_back);
        	      click(dashboard_2);
        		  
        		  wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_name));
        	      WebElement icon = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
        	      icon.click();
        	      click(menu_cooperation);
        	      click(button_addCollaborator);
        	      click(addCollaborator_1_add);
        	      click(b_addCollaborator_ok);
        	      click(button_addCollaborator_close);
        	      
        	      logout();
        	      login("zuijin8@shimo.im", "123123");
        	      
        	      click(dashboard_4);
        	      click(dashboard_update_name);
        		  click(b_back);
        		  wait.until(ExpectedConditions.elementToBeClickable(dashboard_2));
        		  dashboard_2.click();
        		  
        		  wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
        	      WebElement icon1 = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
        	      icon1.click();
        	      click(menu_delete);
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
        		  driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]")).click();
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
        	      String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
        		  assertEquals(text2, "没有文件");
        		  
        		  logout();
        		  login("zuijin9@shimo.im", "123123");
        		  click(dashboard_2);
        		  wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_name));
        	      WebElement icon3 = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
        	      icon3.click();
        	      click(menu_delete);
        	      WebElement icon4= driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]"));
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
        	      icon4.click();
        	     
        	      
        	      
        	     }
        /**
		 *最近使用
		 * 卡片，自己被移除协作
		 * @author 陈清杰
		 * @Time2018-03-19
		 * 账号状态:没有文件
        *  **/
        @Test
        public void used8() throws InterruptedException{
        	
        	       login("zuijin55@shimo.im","123123");
        	       click(desktop_new);
               click(desktop_newDoc);
      	       click(b_back);
      	       click(dashboard_2);
   	           wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
  	           WebElement icon = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
  	           icon.click();
  	           click(menu_cooperation);
  	           click(button_addCollaborator);
   	           click(addCollaborator_1_add);
   	           click(b_addCollaborator_ok);
   	           click(button_addCollaborator_close);
   	           
   	           logout();  
   	           login("zuijin77@shimo.im", "123123");
   	           click(dashboard_4);
   	           click(dashboard_update_name);
  	           click(b_back);
  		       logout();
  		       
  		       login("zuijin55@shimo.im", "123123");
  		       click(dashboard_2);
 	           wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
    	           WebElement icon1 = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
    	           icon1.click();  
    	           click(menu_cooperation);
       	       click(b_addCollaborator_2_list);
       	       click(list_addCollaborator_4);
       	       click(Shut_down_sm_modal_close_x);
       	       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
  	           WebElement icon3 = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
  	           icon3.click();
  	           click(menu_delete);
  	           WebElement icon4= driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]"));
  	           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
  	           icon4.click();
       	       logout();
       	       
       	       login("zuijin77@shimo.im", "123123");
 	           click(dashboard_2);
 	           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
 	           String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
 	 		   assertEquals(text2, "没有文件");
   	            
  		 
   	           
   	           
   	           
   	            }
        
		

        	
        
        
        
        
	
	
	
	
	
}
