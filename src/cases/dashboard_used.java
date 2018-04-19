package cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
    		boolean text1 = getText(menu_newPage).equals("在新标签页中打开");
    	    boolean text2 = getText(menu_mute).equals("消息免打扰");
    	    boolean text3 = getText(menu_shortcut).equals("添加到快捷方式");
    	    boolean text4 = getText(menu_collection).equals("收藏");
    	    boolean text6 = getText(menu_cooperation).equals("1 人协作");
    	    boolean text7 = getText(menu_move).equals("移动");
    	    boolean text9 = getText(menu_moveToFolder).equals("定位到所在文件夹");
    	    boolean text10 = getText(menu_rename).equals("重命名");
    	    boolean text11 = getText(menu_creatCopy).equals("创建副本");
    	    boolean  text13 = getText(menu_delete).equals( "删除");
    	    assertTrue(text1||text2||text3||text4||text6||text9||text7||text10||text11||text13);
    	   
    	    
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
    	    click(menu_Point_Menu);
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
        	click(dashboard_2);
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a")));
       	WebElement icon2 = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a"));
       	icon2.click();
	    click(b_back);
	    click(dashboard_2);
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
	    String text = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[2]//div//a//div//div//div[2]//div[1]//div[1]")).getText();
	    assertEquals(text, "22222");
	    
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a")));
       	WebElement icon3 = driver.findElement(By.xpath("//div[@id='content']//div//div//div//div//div//div[2]//div[3]//div//a"));
       	icon3.click();
	    click(b_back);
	    click(dashboard_2);
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
        	      
        	      contextClick(dashboard_update_name);;
        	      click(menu_delete);
        	      click(desktop_newFolder_name_ok);
        	      
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
        		  
        		  contextClick(dashboard_update_name);
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
        	      contextClick(dashboard_update_name);
        	      click(menu_delete);
        	      click(desktop_newFolder_name_ok);
        	      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
        	      String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
        		  assertEquals(text2, "没有文件");
        		  
        		  logout();
        		  login("zuijin9@shimo.im", "123123");
        		  click(dashboard_2);
        		  contextClick(dashboard_update_name);
        	      click(menu_delete);
        	      click(desktop_newFolder_name_ok);
        	     
        	      
        	      
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
   	           contextClick(dashboard_update_name);
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
 	           contextClick(dashboard_update_name); 
    	           click(menu_cooperation);
       	       click(b_addCollaborator_2_list);
       	       click(list_addCollaborator_4);
       	       click(Shut_down_sm_modal_close_x);
       	       contextClick(dashboard_update_name);
  	           click(menu_delete);
  	           click(desktop_newFolder_name_ok);
       	       logout();
       	       
       	       login("zuijin77@shimo.im", "123123");
 	           click(dashboard_2);
 	           wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
 	           String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
 	 		   assertEquals(text2, "没有文件");
   	            
  		 
   	           
   	           
   	           
   	            }
        
		

        	
        
        
        
        
	
	
	
	
	
}
