package cases;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testAlertMute extends TestInit {
	/**
	 * 关闭消息免打扰，协作这评论，收到消息通知
	 * 
	 * 已开启免打扰AlertMute@shimo.im
	 * 
	 * @author 王继程
	 * @Time 2018-03-23
	 *
	 */
	@Test(enabled = true)
	public void Notify_Open() throws InterruptedException {
		login("AlertMute@shimo.im", "123123");
		click(dashboard_2);
		click(menu_Point_Menu);
		click(menu_mute);//接收消息通知
		logout();
		login("AlertMute1@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		//已经打开文档
		click(doc_edit);
		click(ql_comment_Comments);
		Boolean a = false;
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HHmm");
		String time1 = format.format(date);
		int dat1=Integer.parseInt(time1);
		doc_discuss_input.sendKeys("输入评论收到通知");
		doc_discuss_input_ok.click();
		logout();
		login("AlertMute@shimo.im", "123123");
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_notice));
		action.moveToElement(dashboard_notice).perform();
		//String time2 = getText(dashboard_notice_list_1_time);
		wait.until(ExpectedConditions.visibilityOf(dashboard_notice_list_1_time));
		String time2 = dashboard_notice_list_1_time.getText();
		//System.out.println(time2);
		String gg = "刚刚";
		if(time2.equals(gg)) {
			a=true;
		}else if(time2!="刚刚") {
			String time3 = time2.substring(time2.length()-5);
			time3=time3.replace(":",""); 
			int dat2=Integer.parseInt(time3);
			if(dat2==dat1||dat2>dat1) {
				a=true;
			}
		}
		assertTrue(a);
		dashboard_notice_list_1.click();
		switchToPage(1);
		click(End_Discussion);
		click(End_Discussion_OK);
		click(doc_menu);
		click(file_menu_mute);//关闭消息通知
		
	}
	/**
	 * 开启消息免打扰，在关闭消息免打扰，验证最近更新
	 * 
	 * 未开启免打扰AlertMute2@shimo.im
	 * 
	 * @author 王继程
	 * @Time 2018-03-23
	 *
	 */
	@Test(enabled = true)
	public void Notification_shutdown() throws InterruptedException {
		login("AlertMute2@shimo.im", "123123");
		click(dashboard_1);
		click(menu_Point_Menu);
		click(menu_mute);//关闭消息通知
		driver.navigate().refresh();
		Boolean exist = doesWebElementExist(By.xpath("//div[@data-test='category-list-wrapper']//div[2]//div[@class='category-card-container']"));
		assertFalse(exist);
		click(dashboard_2);
		click(menu_Point_Menu);
		click(menu_mute);//开启消息通知
		dashboard_share_file.click();
		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.sendKeys(Keys.CONTROL,'a'+"编辑文档并保存"+Keys.ENTER);
		Thread.sleep(500);
		click(quick_access_point);
		click(Back_to_Table);
		wait.until(ExpectedConditions.elementToBeClickable(dashboard));
		Boolean exist1 = doesWebElementExist(By.xpath("//div[@data-test='category-list-wrapper']//div[2]//div[@class='category-card-container']"));
		int i=1;
        while(exist1==false&&i<6){
        	driver.navigate().refresh();
        	wait.until(ExpectedConditions.elementToBeClickable(dashboard));
            exist1 = doesWebElementExist(By.xpath("//div[@data-test='category-list-wrapper']//div[2]//div[@class='category-card-container']"));
            i++;
        }
        if(exist1=true) {
        	assertTrue(exist1);
        }else {
        	System.out.println("接收消息提醒验证未通过，请登录AlertMute2@shimo.im自行验证");
        }
	}
	/**
	 * 关闭消息免打扰，协作者编辑文档，出现在最近更新中
	 * 
	 * AlertMute3@shimo.im已开启免打扰
	 * 
	 * @author 王继程
	 * @Time 2018-03-23
	 *
	 */
	@Test(enabled = true)
	public void Collaboration_notifications() throws InterruptedException {
		login("AlertMute3@shimo.im", "123123");
		click(dashboard_2);
		click(menu_Point_Menu);
		click(menu_mute);//开启消息通知
		logout();
		login("AlertMute4@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		wait.until(ExpectedConditions.elementToBeClickable(doc_edit));
		doc_edit.sendKeys(Keys.CONTROL,'a'+"编辑文档并保存"+Keys.ENTER);
		Thread.sleep(500);
		logout();
		login("AlertMute3@shimo.im", "123123");
		wait.until(ExpectedConditions.elementToBeClickable(dashboard));
		Boolean exist2 = doesWebElementExist(By.xpath("//div[@data-test='category-list-wrapper']//div[2]//div[@class='category-card-container']"));
		int i=1;
        while(exist2==false&&i<6){
        	driver.navigate().refresh();
        	wait.until(ExpectedConditions.elementToBeClickable(dashboard));
            exist2 = doesWebElementExist(By.xpath("//div[@data-test='category-list-wrapper']//div[2]//div[@class='category-card-container']"));
            i++;
        }
        if(exist2=true) {
        	click(menu_Point_Menu);
        	click(menu_mute);//关闭消息通知
        	assertTrue(exist2);
        }else {
        	System.out.println("接收消息提醒验证未通过，请登录AlertMute3@shimo.im自行验证");
        	click(dashboard_2);
        	click(menu_Point_Menu);
        	click(menu_mute);//关闭消息通知
        }
	}
	/**
	 * 消息通知，文件夹相关
	  
	 * @author 王继程
	 * @Time 2018-03-23
	 *
	 */
	@Test(enabled = true)
	public void Folder_notifications() throws InterruptedException {
		login("AlertMute5@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		
	}
	
}
