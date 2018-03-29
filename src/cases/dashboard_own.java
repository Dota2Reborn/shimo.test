package cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class dashboard_own extends TestInit{
	
	/**
	 *我创建的
	 * 卡片样式验证
	 * @author 陈清杰
	 * @Time 2018-03-20
	 */
	@Test
	public void own1() throws InterruptedException{
		login("own1@shimo.im", "123123");
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_3));
		dashboard_3.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_file));
		String text = driver.findElement(By.xpath("//div[@class='file-title']")).getText();
		assertEquals(text, "无标题");
		
		Thread.sleep(200);
		WebElement icon = driver.findElement(By.xpath("//div[@class='file-options-icon']"));
		icon.click();
		wait.until(ExpectedConditions.elementToBeClickable(menu_delete));
		menu_delete.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
		driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]")).click();
		
	}
	/**
	 *我创建的
	 * 卡片收藏验证
	 * @author 陈清杰
	 * @Time 2018-03-20
	 */
	@Test
	public void own2() throws InterruptedException{
		login("own2@shimo.im", "123123");
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_3));
		dashboard_3.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
		WebElement card = driver.findElement(By.xpath("//div[@class='category-card-container']"));
		action.moveToElement(card).perform();
        driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).click();
        Thread.sleep(500);
        favorites.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tile-inner']//div//a//div[2]")));
		String text=driver.findElement(By.xpath("//div[@class='tile-inner']//div//a//div[2]")).getText();
		assertEquals(text, "无标题");
		
		dashboard.click();
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_3));
	    dashboard_3.click();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
	    WebElement card1 = driver.findElement(By.xpath("//div[@class='category-card-container']"));
		action.moveToElement(card1).perform();
		driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).click();
		Thread.sleep(1000);
		favorites.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text2, "没有文件");
		
		dashboard.click();
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
	 *我创建的
	 * 点点点
	 * @author 陈清杰
	 * @Time 2018-03-20
	 */
	@Test
	public void own3() throws InterruptedException{
		login("own3@shimo.im", "123123");
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_3));
		dashboard_3.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
		driver.findElement(By.xpath("//div[@class='file-options-icon']")).click();
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
	 *我创建的
	 * 移交所有权在我创建的里面生成卡片
	 * @author 陈清杰
	 * @Time 2018-03-20
	 */
	@Test
	public void own4() throws InterruptedException{
		login("own4@shimo.im", "123123");
		desktop_new.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
		desktop_newDoc.click();
		wait.until(ExpectedConditions.elementToBeClickable(b_back));
		b_back.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
		driver.findElement(By.xpath("//div[@class='file-options-icon']")).click();
		Thread.sleep(1000);
		menu_cooperation.click();
		wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
	    input_addCollaborator.sendKeys("own5@shimo.im");
	    //验证添加按钮是否加载出来
	    wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
	    b_addCollaborator_1_add.click();

		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
	     driver.findElement(By.xpath("//div[@class='sm-modal-body']//div[3]//div[1]//div[1]//div[1]//div[1]")).click();
	     wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_1));
	     list_addCollaborator_1.click();
	     wait.until(ExpectedConditions.elementToBeClickable(list_addCollaborator_changeOwner_1));
	     list_addCollaborator_changeOwner_1.click();
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-popconfirm sm-tooltip-inner']//div//div[2]//button[1]")));
	     driver.findElement(By.xpath("//div[@class='sm-popconfirm sm-tooltip-inner']//div//div[2]//button[1]")).click();
	     Thread.sleep(500);
	     logout();
	     
	     login("own5@shimo.im", "123123");
	     wait.until(ExpectedConditions.elementToBeClickable(dashboard_3));
	     dashboard_3.click();
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
	     String text = driver.findElement(By.xpath("//div[@class='file-title']")).getText();
	     assertEquals(text, "无标题");
	     
	     Thread.sleep(300);
	     driver.findElement(By.xpath("//div[@class='file-options-icon']")).click();
	     wait.until(ExpectedConditions.elementToBeClickable(menu_delete));
	     menu_delete.click();
	     WebElement icon = driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]"));
	     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
	     icon.click();
	     
	}
	
	/**
	 *新的的共享
	 * 
	 * @author 陈清杰
	 * @Time 2018-03-21
	 */
	@Test
	public void own5() throws InterruptedException{
		login("own6@shimo.im", "123123");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(menu_cooperation));
		menu_cooperation.click();
		wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
		Thread.sleep(500);
		input_addCollaborator.sendKeys("own7@shimo.im");
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
		b_addCollaborator_1_add.click();
		//获取当前时间
		Boolean a = false;
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HHmm");
		String time = format.format(date);
		int dat1=Integer.parseInt(time);
		wait.until(ExpectedConditions.elementToBeClickable(Shut_down_sm_modal_close_x));
		Shut_down_sm_modal_close_x.click();
		logout();
		login("own7@shimo.im", "123123");
		String n = dashboard_shareTime_1.getText();
		String time1 = n.substring(0,2);
		String m="刚刚";
		if(time1.equals(m)) {
			assertEquals(n,"刚刚");
			a = true;
		}else if(time1!=m) {
			//String time3 = n.substring(0,8);
			String time3 = n.substring(n.length()-5);
			time3=time3.replace(":","");
			int dat2=Integer.parseInt(time3);
			if(dat2==dat1||dat2>dat1) {
				a = true;
			}
		}
		assertTrue(a);
		contextClick(New_Share_1);
		wait.until(ExpectedConditions.elementToBeClickable(menu_delete));
		menu_delete.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();
		
	     
	}



}
