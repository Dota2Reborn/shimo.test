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
	 * 账号状态：两个账号都没有文件
	 * */
	@Test
	public void shared1() throws InterruptedException{
		login("gx1@shimo.im", "123123");
		click(desktop_new);
		click(desktop_newDoc);
		click(doc_edit);
        doc_edit.sendKeys("石墨测试组");
        click(b_back);
   	    
   	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));//点点点
		driver.findElement(By.xpath("//div[@class='file-options-icon']")).click();
		Thread.sleep(1000);
		click(menu_cooperation);
		wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
	    input_addCollaborator.sendKeys("gx2@shimo.im");
	    click(b_addCollaborator_1_add);
	    click(Shut_down_sm_modal_close_x);
	    
	    logout();
	    login("gx2@shimo.im", "123123");
	    click(dashboard_4);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
	    boolean a = driver.findElement(By.xpath("//div[@class='card-ribbon']")).isDisplayed();//未读蓝色标记
	    assertEquals(a,true);
	    boolean b = driver.findElement(By.xpath("//div[@class='card-icon']//div")).isDisplayed();//卡片图标
	    assertEquals(b, true);
	    boolean c = driver.findElement(By.xpath("//div[@class='card-icon']//span")).isDisplayed();//卡片图标
	    assertEquals(c, true);
	    String text = driver.findElement(By.xpath("//div[@class='card-content-title']//div[1]")).getText();
	    assertEquals(text, "无标题");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='card-content-update']")));
	    String text1 = driver.findElement(By.xpath("//div[@class='card-content-update']")).getText();
	    assertEquals(text1, "2人共享 · 刚刚 共享 共享");
	    WebElement card = driver.findElement(By.xpath("//div[@class='category-card-container']"));
		action.moveToElement(card).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")));
		boolean d = driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).isDisplayed();
		assertEquals(d, true);
		boolean e = driver.findElement(By.xpath("//div[@class='file-options-icon']")).isDisplayed();
		assertEquals(e, true);
		Thread.sleep(200);
		
		
		logout();
		login("gx1@shimo.im","123123");
		click(dashboard_3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
		driver.findElement(By.xpath("//div[@class='file-options-icon']")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(menu_delete));
	    menu_delete.click();
	    WebElement icon = driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]"));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
	    icon.click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text2, "没有文件");
		
		
   	    
	}
	/**
	 *共享给我
	 * hover收藏
	 * @author 陈清杰
	 * @Time2018-03-22
	 * 账号状态：两个账号都没有文件
	 * */
	@Test
	public void shared2() throws InterruptedException{
		login("gx3@shimo.im", "123123");
		click(desktop_new);
		click(desktop_newDoc);
		click(doc_edit);
        doc_edit.sendKeys("石墨测试组");
   	    click(b_back);
   	    
   	    
   	    
   	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));//点点点
		driver.findElement(By.xpath("//div[@class='file-options-icon']")).click();
		click(menu_cooperation);
		wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
	    input_addCollaborator.sendKeys("gx4@shimo.im");
	    click(b_addCollaborator_1_add);
	    click(Shut_down_sm_modal_close_x);
	    logout();
	    
	    login("gx4@shimo.im", "123123");
	    click(dashboard_4);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-card-container']")));
	    WebElement card = driver.findElement(By.xpath("//div[@class='category-card-container']"));
		action.moveToElement(card).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div[2]//div[1]//div[2]")));
		driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div[2]//div[1]//div[2]")).click();
		click(favorites);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='tile-inner']//div//a//div[2]")));
		String text=driver.findElement(By.xpath("//div[@class='tile-inner']//div//a//div[2]")).getText();
		assertEquals(text, "无标题");
		
		
		click(dashboard);
	    click(dashboard_4);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-card-container']")));
		WebElement card1 = driver.findElement(By.xpath("//div[@class='category-card-container']"));//卡片
		action.moveToElement(card1).perform();
		driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div[2]//div[1]//div[2]")).click();
		Thread.sleep(300);
		click(favorites);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text2, "没有文件");
		
		logout();
		login("gx3@shimo.im", "123123");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
		driver.findElement(By.xpath("//div[@class='file-options-icon']")).click();
	    click(menu_delete);
	    WebElement icon = driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]"));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
	    icon.click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text3 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text3, "没有文件");
		
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
	    assertEquals(text6, "2 人协作");
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



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





