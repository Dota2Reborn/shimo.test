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
	 * 卡片收藏验证
	 * @author 陈清杰
	 * @Time 2018-03-20
	 * 账号状态：有一个文件
	 */
	@Test
	public void own2() throws InterruptedException{
		login("own2@shimo.im", "123123");
		click(dashboard_3);
		
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_name));
		action.moveToElement(dashboard_update_name).perform();
        driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).click();//hover收藏
        Thread.sleep(600);
        click(favorites);
        wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String text= driver.findElement(By.xpath("//div[@class='tile-inner']//div[1]//a[1]//div[2]")).getText();
		assertEquals(text, "无标题");
		
		click(dashboard);
		click(dashboard_3);
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_time));
	    action.moveToElement(dashboard_update_time).perform();
		driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).click();
		Thread.sleep(1000);
		click(favorites);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text2, "没有文件");
		
		
		}
	/**
	 *我创建的
	 * 点点点
	 * @author 陈清杰
	 * @Time 2018-03-20
	 * 账号状态：有一个文档
	 */
	@Test
	public void own3() throws InterruptedException{
		login("own3@shimo.im", "123123");
		click(dashboard_3);
		click(menu_Point_Menu);
		Thread.sleep(500);
		String text1 = getText(menu_newPage);
		assertEquals(text1, "在新标签页中打开");
	    String text2 = getText(menu_mute);
	    assertEquals(text2, "消息免打扰");
	    String text3 = getText(menu_shortcut);
	    assertEquals(text3, "添加到快捷方式");
	    String text4 =getText(menu_collection);
	    assertEquals(text4, "收藏");
	    String text6 = getText(menu_cooperation);
	    assertEquals(text6, "1 人协作");
	    String text7 = getText(menu_move);
	    assertEquals(text7, "移动");
	    String text9 = getText(menu_moveToFolder);
	    assertEquals(text9, "定位到所在文件夹");
	    String text10 = getText(menu_rename);
	    assertEquals(text10, "重命名");
	    String text11 = getText(menu_creatCopy);
	    assertEquals(text11, "创建副本");
	    String  text13 = getText(menu_delete);
	    assertEquals(text13, "删除");
		
		
	}
	/**
	 *我创建的
	 * 移交所有权在我创建的里面生成卡片
	 * @author 陈清杰
	 * @Time 2018-03-20
	 * 账号状态：两个账号都没有文件
	 */
	@Test
	public void own4() throws InterruptedException{
		login("own4@shimo.im", "123123");
		click(desktop_new);
		click(desktop_newDoc);
		click(b_back);
		click(dashboard_3);
		click(menu_Point_Menu);
		click(menu_cooperation);
		click(button_addCollaborator);
	    click(addCollaborator_1_add);
	    click(b_addCollaborator_ok);

		 Thread.sleep(1000);
		 click(b_addCollaborator_1_list);
	     click(list_addCollaborator_1);
	     click(list_addCollaborator_changeOwner_1);
	     click(b_addCollaborator_confirm);
	     Thread.sleep(500);
	     logout();
	     
	     login("own5@shimo.im", "123123");
	     click(dashboard_3);
	     String text = getText(dashboard_update_name);
	     assertEquals(text, "无标题");
	     
	     Thread.sleep(300);
	     click(menu_Point_Menu);
	     click(menu_delete);
	     click(desktop_newFolder_name_ok);
	     
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
		click(desktop);
		contextClick(desktop1_1);
		click(menu_cooperation);
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
		String n = getText(dashboard_shareTime_1);
		String time1 = n.substring(0,2);
		String m="刚刚";
		if(time1.equals(m)) {
			assertEquals(n,"刚刚");
			a = true;
		}else if(time1!=m) {
			String time3 = n.substring(0,8);
			time3 = time3.substring(time3.length()-5);
			time3=time3.replace(":","");
			int dat2=Integer.parseInt(time3);
			if(dat2==dat1||dat2>dat1) {
				a = true;
			}
		}
		contextClick(New_Share_1);
		wait.until(ExpectedConditions.elementToBeClickable(menu_delete));
		menu_delete.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();
		assertTrue(a);
		
		
	     
	}



}
