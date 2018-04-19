package cases;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;



import base.TestInit;

public class dashboard_shared extends TestInit {
	
	
	/**
	 *共享给我
	 * 卡片样式
	 * @author 陈清杰
	 * @Time2018-03-21
	 * 账号状态：gx1有，gx2没有
	 * */
	@Test
	public void shared1() throws InterruptedException{
		login("gx1@shimo.im", "123123");
        click(dashboard_3);
   	    contextClick(dashboard_update_name);
		Thread.sleep(1000);
		click(menu_cooperation);
		click(button_addCollaborator);
		click(addCollaborator_1_add);
		click(b_addCollaborator_ok);
		click(button_addCollaborator_close);
	    logout();
	    login("gx2@shimo.im", "123123");
	    click(dashboard_4);
	    wait.until(ExpectedConditions.elementToBeClickable(menu_Point_Menu));
	    boolean a = driver.findElement(By.xpath("//div[@class='card-ribbon']")).isDisplayed();//未读蓝色标记
	    assertEquals(a,true);
	    boolean b = driver.findElement(By.xpath("//div[@class='card-icon']//div")).isDisplayed();//卡片图标
	    assertEquals(b, true);
	    boolean c = driver.findElement(By.xpath("//div[@class='card-icon']//span")).isDisplayed();//卡片图标
	    assertEquals(c, true);
	    String text = driver.findElement(By.xpath("//div[@class='card-content-title']//div[1]")).getText();
	    assertEquals(text, "无标题");
	    String text1 = getText(dashboard_update_time);
	    assertEquals(text1, "2人共享 · 刚刚 共享 共享");
	    WebElement card = driver.findElement(By.xpath("//div[@class='category-card-container']"));
		moveToElement(card);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")));
		boolean d = driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).isDisplayed();
		assertEquals(d, true);
		boolean e = driver.findElement(By.xpath("//div[@class='file-options-icon']")).isDisplayed();
		assertEquals(e, true);
		Thread.sleep(200);
		contextClick(dashboard_update_name);;
		click(menu_delete);
		click(desktop_newFolder_name_ok);
		
		
		
		
	}
	/**
	 *共享给我
	 * hover收藏
	 * @author 陈清杰
	 * @Time2018-03-22
	 * 账号状态：gx4有gx3共享的文件
	 * */
	@Test
	public void shared2() throws InterruptedException{
		login("gx4@shimo.im", "123123");
	    click(dashboard_4);
		moveToElement(dashboard_share_file);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div[2]//div[1]//div[2]")));
		driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div[2]//div[1]//div[2]")).click();
		click(favorites);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tile-inner']//div//a//div[2]")));
		String text=driver.findElement(By.xpath("//div[@class='tile-inner']//div//a//div[2]")).getText();
		assertEquals(text, "共享");
		
		
		click(dashboard);
	    click(dashboard_4);
		moveToElement(dashboard_share_file);
		driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div[2]//div[1]//div[2]")).click();
		click(favorites);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text2, "没有文件");
		
		
	}
	
	/**
	 *共享给我
	 * 卡片点点点选项验证（正常）
	 * @author 陈清杰
	 * @Time2018-03-22
	 * 账号状态:gx5@shimo.im有固定文件；gx6@shimo.im有5共享的固定文件
	 * */
	@Test
	public void shared3() throws InterruptedException{
	    
	    
	    login("gx6@shimo.im", "123123");
	    click(dashboard_4);
	    click(menu_Point_Menu);
		String text1 = getText(menu_newPage);
		assertEquals(text1, "在新标签页中打开");
	    String text2 = getText(menu_mute);
	    assertEquals(text2, "消息免打扰");
	    String text3 = getText(menu_shortcut);
	    assertEquals(text3, "添加到快捷方式");
	    String text4 = getText(menu_collection);
	    assertEquals(text4, "收藏");
	    String text6 = getText(menu_cooperation);
	    assertEquals(text6, "2 人协作");
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
	 *共享给我
	 *先共享文件，再共享包含该文件的文件夹，生成两个卡片
	 * @author 陈清杰
	 * @Time2018-03-23
	 * */
	/*@Test
	public void shared4()throws InterruptedException{
		login("gx7@shimo.im", "123123");
		wait.until(ExpectedConditions.elementToBeClickable(desktop));
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		desktop1_1_folder.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		action.moveToElement(desktop1_1).perform();
	    wait.until(ExpectedConditions.elementToBeClickable(desktop_setting));
	    desktop_setting.click();
	    wait.until(ExpectedConditions.elementToBeClickable(menu_cooperation));
	    menu_cooperation.click();
		wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
		input_addCollaborator.sendKeys("gx8@shimo.im");
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
	    b_addCollaborator_1_add.click();
	    wait.until(ExpectedConditions.elementToBeClickable(Shut_down_sm_modal_close_x));
        Shut_down_sm_modal_close_x.click();
	    logout();
	    
	    login("gx8@shimo.im", "123123");
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_4));
	    dashboard_4.click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
	    String text = driver.findElement(By.xpath("//div[@class='card-content-title']//div[1]")).getText();
	    assertEquals(text, "我是文件");
	    driver.findElement(By.xpath("//div[@class='card-content-update']")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(b_back));
	    click(b_back);
	    
	    
	    logout();
	    login("gx7@shimo.im", "123123");
	    wait.until(ExpectedConditions.elementToBeClickable(desktop));
	    desktop.click();
	    wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
	    action.moveToElement(desktop1_1_folder).perform();
	    wait.until(ExpectedConditions.elementToBeClickable(desktop_setting));
	    desktop_setting.click();
	    wait.until(ExpectedConditions.elementToBeClickable(menu_cooperation));
	    menu_cooperation.click();
		wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
		Thread.sleep(300);
		input_addCollaborator.sendKeys("gx8@shimo.im");
		wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
	    b_addCollaborator_1_add.click();
	    wait.until(ExpectedConditions.elementToBeClickable(Shut_down_sm_modal_close_x));
        Shut_down_sm_modal_close_x.click();
        
        logout();
        login("gx8@shimo.im", "123123");
        wait.until(ExpectedConditions.elementToBeClickable(dashboard_4));
        dashboard_4.click();
        
        
	    
	    
	    
	    
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





