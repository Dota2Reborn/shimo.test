package cases;

import static org.testng.Assert.assertEquals;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class dashboard_update  extends TestInit{
	/**
	 *最近更新
	 * 卡片样式
	 * @author 陈清杰
	 * @Time2018-03-26
	 * 账号状态：有一个文件
	 * */
	@Test
	public void update1() throws InterruptedException{
		login("gengxin1@shimo.im","123123");
		click(dashboard_1);
		click(dashboard_update_time);
		click(doc_edit);
		doc_edit.sendKeys("1");
		click(b_back);
		wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_time));
		boolean b = driver.findElement(By.xpath("//div[@class='card-icon']//div")).isDisplayed();//卡片图标
	    assertEquals(b, true);
	    String text = driver.findElement(By.xpath("//div[@class='card-content-title']//div[1]")).getText();
	    assertEquals(text, "无标题");
	    
	    String text1 = getText(dashboard_update_time);
	    assertEquals(text1, "刚刚 我 更新");
		action.moveToElement(dashboard_update_time).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")));
		boolean d = driver.findElement(By.xpath("//div[@class='category-card-container']//div//a//div[1]//div[2]//div//div[2]")).isDisplayed();
		assertEquals(d, true);
		boolean e = driver.findElement(By.xpath("//div[@class='file-options-icon']")).isDisplayed();
		assertEquals(e, true);
		//勿扰没写呢
		
	}
	/**
	 *最近更新
	 * 点点点
	 * @author 陈清杰
	 * @Time2018-03-26
	 * 账号状态：有一个固定文件
	 * */
	@Test
	public void update2() throws InterruptedException{
		login("gengxin2@shimo.im", "123123");
		click(dashboard_1);
		click(menu_Point_Menu);
	    wait.until(ExpectedConditions.elementToBeClickable(menu_delete));
	    	String text1 = getText(menu_newPage);
		assertEquals(text1, "在新标签页中打开");
	    String text2 = getText(menu_mute);
	    assertEquals(text2, "消息免打扰");
	    String text3 = getText(menu_shortcut);
	    assertEquals(text3, "添加到快捷方式");
	    String text4 = getText(menu_collection);
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
	    String  text13 = getText(menu_creatCopy);
	    assertEquals(text13, "删除");
	    
        }
	/**
	 *最近更新
	 * 所有者编辑内容更新
	 * @author 陈清杰
	 * @Time2018-03-26
	 * 账号状态：有一个固定文件
	 * */
	@Test
	public void update3() throws InterruptedException{
		login("gengxin3@shimo.im", "123123");
		click(dashboard_update_name);
		click(doc_edit);
		doc_edit.sendKeys("1");
		Thread.sleep(1000);
		click(b_back);
		String text1 = getText(dashboard_update_time);
	    assertEquals(text1, "刚刚 我 更新");
		
		
		
	}
	
	/**
	 *最近更新
	 * 协作者编辑内容更新
	 * @author 陈清杰
	 * @Time2018-03-26
	 * 账号状态：两个账号有一个固定文件
	 * */
	@Test
	public void update4() throws InterruptedException{
		login("gengxin5@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(doc_edit);
		doc_edit.sendKeys("1");
		Thread.sleep(1000);
		click(b_back);
		logout();
		
		login("gengxin4@shimo.im", "123123");
		String text1 = getText(dashboard_update_time);
	    assertEquals(text1, "刚刚 AA 更新");
	}
	/**
	 *最近更新
	 * 所有者评论
	 * @author 陈清杰
	 * @Time2018-03-26
	 * 账号状态：有一个固定文件
	 * */
	@Test
	public void update5() throws InterruptedException{
		login("gengxin6@shimo.im", "123123");
		click(dashboard_update_time);
		click(doc_edit);
		click(doc_discuss);
		click(doc_discuss_input);
		doc_discuss_input.sendKeys("通过");
		click(doc_discuss_input_ok);
		Thread.sleep(1000);
		click(b_back);
		String text1 = getText(dashboard_update_time);
	    assertEquals(text1, "刚刚 我 评论：通过");
	    
	    click(dashboard_update_time);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='doc-comment-text']")));
	    driver.findElement(By.xpath("//div[@class='doc-comment-text']")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='doc-comment-close-icon']")));
	    driver.findElement(By.xpath("//span[@class='doc-comment-close-icon']")).click();
	    click(doc_menu_delete_OK);
	    
	    
		
		
		
	    
	}
	/**
	 *最近更新
	 * 协作者评论
	 * @author 陈清杰
	 * @Time2018-03-27
	 * 账号状态：两个账号有一个固定文件
	 * */
	@Test
	public void update6() throws  InterruptedException{
		login("gengxin7@shimo.im", "123123");
		click(desktop);
		click(desktop1_1);
		click(doc_edit);
		click(doc_discuss);
		click(doc_discuss_input);
		doc_discuss_input.sendKeys("通过");
		click(doc_discuss_input_ok);
		Thread.sleep(1000);
		logout();
		
		login("gengxin8@shimo.im", "123123");
		String text1 = getText(dashboard_update_time);
	    assertEquals(text1, "刚刚 cc 评论：通过");
	    click(dashboard_update_time);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='doc-comment-text']")));
	    driver.findElement(By.xpath("//div[@class='doc-comment-text']")).click();
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='doc-comment-close-icon']")));
	    driver.findElement(By.xpath("//span[@class='doc-comment-close-icon']")).click();
	    click(doc_menu_delete_OK);
		
	}
	/**
	 *最近更新
	 * 自己退出共享，已经生成的卡片从最近更新消失
	 * @author 陈清杰
	 * @Time2018-03-27
	 * 账号状态：gengxin10里面有一个9恭喜的文件
	 * */
	@Test
	public void update7() throws InterruptedException{
		login("gengxin10@shimo.im", "123123");
		click(dashboard_4);
		click(dashboard_update_time);
		click(doc_edit);
		doc_edit.sendKeys("1");
		Thread.sleep(1000);
		click(b_back);
		click(dashboard_1);
	    String text1 = getText(dashboard_update_name);
	    assertEquals(text1, "突然想起你");
	    click(menu_Point_Menu);
	    click(menu_cooperation);
	    click(b_addCollaborator_2_list);
	    click(list_addCollaborator_4);
		click(b_addCollaborator_confirm);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text2, "没有文件");
		
		logout();
		login("gengxin9@shimo.im", "123123");
		click(menu_Point_Menu);
		click(menu_cooperation);
		click(button_addCollaborator);
		click(addCollaborator_1_add);
		click(b_addCollaborator_ok);
		click(Shut_down_sm_modal_close_x);
	}
	/**
	 *最近更新
	 * 自己删除自己文件，已经在最近更新生成卡片的
	 * @author 陈清杰
	 * @Time2018-03-27
	 * 账号状态：有一个文件
	 * */
	@Test
	public void update8() throws InterruptedException{
		login("gengxin11@shimo.im", "123123");
	    click(dashboard_update_time);
	    click(doc_edit);
	    doc_edit.sendKeys("1");
	    click(b_back);
	    click(menu_Point_Menu);
	    click(menu_delete);
	    click(desktop_newFolder_name_ok);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text2, "没有文件");
		click(desktop_new);
		click(desktop_newDoc);
		click(b_back);
		
		
		
		
	}
	/**
	 *最近更新
	 * 被所有者移除协作，已经在最近更新生成过卡片
	 * @author 陈清杰
	 * @Time2018-03-27
	 * 账号状态：gengxin13有12共享的文件
	 * */
	@Test
	public void update9() throws InterruptedException{
		login("gengxin13@shimo.im", "123123");
		click(dashboard_4);
		click(dashboard_update_time);
	    click(doc_edit);
	    doc_edit.sendKeys("q");
	    click(b_back);
	    click(dashboard_1);
	    
	    logout();
	    
	    login("gengxin12@shimo.im", "123123");
	    click(menu_Point_Menu);
	    click(menu_cooperation);
	    click(b_addCollaborator_2_list);
	    click(list_addCollaborator_4);
	    click(Shut_down_sm_modal_close_x);
	    
	    logout();
	    login("gengxin13@shimo.im", "123123");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='none-file']//span")));
		String text2 = driver.findElement(By.xpath("//div[@class='none-file']//span")).getText();
		assertEquals(text2, "没有文件");
		
		logout();
		login("gengxin12@shimo.im", "123123");
		click(dashboard_3);
		click(menu_Point_Menu);
		click(menu_cooperation);
		click(button_addCollaborator);
		click(addCollaborator_1_add);
		click(b_addCollaborator_ok);
	    click(Shut_down_sm_modal_close_x);
		
	}
	/**
	 *最近更新
	 * 删除后再恢复
	 * @author 陈清杰
	 * @Time2018-03-27
	 * 账号状态：没有文件
	 * */
	@Test
	public void update10() throws InterruptedException{
		login("gengxin14@shimo.im", "123123");
		click(desktop_new);
		click(desktop_newDoc);
		click(doc_edit);
		doc_edit.sendKeys("1");
	    Thread.sleep(1000);
	    click(doc_menu);
	    click(doc_menu_delete);
	    click(doc_menu_delete_OK);
	 
	    click(trash);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-icon doc']")));
	    driver.findElement(By.xpath("//div[@class='file-icon doc']")).click();
	    click(menu_Recovery);
	    click(dashboard);
	    
	    wait.until(ExpectedConditions.elementToBeClickable(dashboard_update_time));
		String text1 = dashboard_update_time.getText();
	    assertEquals(text1, "刚刚 我 更新");
	    
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-options-icon']")));
	    driver.findElement(By.xpath("//div[@class='file-options-icon']")).click();
	    click(menu_delete);
	    WebElement icon1 = driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]"));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
	    icon1.click();
	    Thread.sleep(1000);
	    click(trash);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='file-icon doc']")));
	    driver.findElement(By.xpath("//div[@class='file-icon doc']")).click();
	    click(menu_Completely_removed);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-footer']//button[1]")));
	    driver.findElement(By.xpath("//div[@class='sm-modal-footer']//button[1]")).click();
	    
		
		
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
