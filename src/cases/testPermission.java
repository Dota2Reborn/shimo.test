package cases;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;
public class testPermission extends TestInit {
	/**
	 * 文件夹添加只评论协作者
	 * 
	 * @author 王继程
	 * @Time 2018-03-06
	 *
	 */
	@Test(enabled = true)
	public void Add_to1() throws InterruptedException {
		login("testing_1@test.im","123123");
		desktop.click();
		Sort();
		//右键第一个文件
		action.contextClick(desktop1_1).perform();
		click(menu_cooperation);
		Add("testing_2@test.im");
		Modify(2,2);
		click(Shut_down_sm_modal_close_x);
		logout();
		login("testing_2@test.im","123123");
		wait.until(ExpectedConditions.elementToBeClickable(desktop));
		desktop.click();
		Sort();
		click(desktop1_1_folder);
		click(desktop1_1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='ql-container']//div[1]//p")));
		driver.findElement(By.xpath("//div[@id='ql-container']//div[1]//p")).click();
		click(ql_comment_Comments);
		wait.until(ExpectedConditions.elementToBeClickable(doc_discuss_input));
		String M = doc_discuss_input.getAttribute("spellcheck");
		assertEquals(M,"false");
		quick_access_point.click();
		click(Back_to_Table);
		contextClick(desktop1_1);
		click(menu_delete);
		click(Exit_share_OK);
	}
	/**
	 * 文件夹添加只读协作者
	 *  
	 * @author 王继程
	 * @Time 2018-03-06
	 *
	 */
	@Test(enabled = true)
	public void Add_to2() throws InterruptedException {
		login("testing_3@test.im","123123");
		desktop.click();
		Sort();
		//右键第一个文件
		action.contextClick(desktop1_1).perform();
		wait.until(ExpectedConditions.elementToBeClickable(menu_cooperation));
		menu_cooperation.click();
		Add("testing_5@test.im");
		Modify(3,2);
		Shut_down_sm_modal_close_x.click();
		logout();
		login("testing_5@test.im","123123");
		desktop.click();
		click(desktop);
		Sort();
		desktop1_1_folder.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
		String t = desktop_new.getAttribute("disabled");
		assertEquals(t, "true");
		desktop.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1_folder));
		action.contextClick(desktop1_1).perform();
		menu_delete.click();
		wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder_name_ok));
		desktop_newFolder_name_ok.click();
	}
	//验证是否平铺
	//验证排序是否初始化
		public void Sort() throws InterruptedException {
			wait.until(ExpectedConditions.elementToBeClickable(desktop_order));
			String msg = desktop_show_type.getText();
			if (msg.equals("平铺")) {
				desktop_show_type.click();
			}
			msg = desktop_order.getText();
			if (msg.equals("排序")) {
				desktop_order.click();
				wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
				Boolean exist = doesWebElementExist(By.xpath("//span[@data-test='change-table-sort-folder-priority']/following-sibling::span[1]"));
				desktop_orderByDefault.click();
				if(exist==true) {
					desktop_order.click();
					wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
					desktop_orderByFolderUP.click();
				}
			}else {
				desktop_order.click();
				wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
				Boolean exist = doesWebElementExist(By.xpath("//span[@data-test='change-table-sort-folder-priority']/following-sibling::span[1]"));
				if(exist==true) {
					desktop_orderByFolderUP.click();
				}else {
					desktop_orderByDefault.click();
				}
			}
						
		}

//	//添加协作
//	public void Add(int Judgment,String Emil_1) throws InterruptedException {
//		wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
//		int[] integers = {2,3,4,5,6};
//		//int[] integers = {2};
//		if(Judgment==1){
//			for (int j = 0; j < integers.length; j++) {
//				String Emil="testing_"+integers[j]+"@test.im";
//				input_addCollaborator.sendKeys(Emil);
//				//验证添加按钮是否加载出来
//				wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
//				b_addCollaborator_1_add.click();
//			}
//		}
//		
//		if(Emil_1!=""){
//			input_addCollaborator.sendKeys(Emil_1);
//			wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
//			b_addCollaborator_1_add.click();
//		}
//		
//	}
		
		//添加协作
		public void Add(String Emil) throws InterruptedException {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
				input_addCollaborator.sendKeys(Emil);
				wait.until(ExpectedConditions.elementToBeClickable(b_addCollaborator_1_add));
				String name = wait.until(ExpectedConditions.visibilityOf(b_addCollaborator_1_add)).getText();
				if (!name.equals("添加")) {
					System.out.println("添加"+Emil+"时已经是协作者了");
					b_addCollaborator_1_add.click();
					click(list_addCollaborator_4);
					wait.until(ExpectedConditions.elementToBeClickable(input_addCollaborator));
					input_addCollaborator.sendKeys(Emil);
					click(b_addCollaborator_1_add);
				}else {
					b_addCollaborator_1_add.click();	
				}
			} catch (NoSuchElementException e) {
					// TODO
				System.out.println(Emil + "is missing");
			}
		}

	//选择权限
	public void Modify(int Permissions,int Several) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
		if(Permissions==1) {//可写
			driver.findElement(By.xpath("//div[@class='sm-modal-body']//div[3]//div[1]//div["+Several+"]//div[1]//div[1]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(Can_edit_1));
			Can_edit_1.click();
			 
		}else if(Permissions==2){//只评论
			driver.findElement(By.xpath("//div[@class='sm-modal-body']//div[3]//div[1]//div["+Several+"]//div[1]//div[1]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(can_only_comment_2));
			can_only_comment_2.click();
		}else if(Permissions==3){//只读
			driver.findElement(By.xpath("//div[@class='sm-modal-body']//div[3]//div[1]//div["+Several+"]//div[1]//div[1]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(can_only_read_3));
			can_only_read_3.click();
		}
		
	}
//	//取出邮箱(用户名)，根据邮箱判断设置权限
//	public void Modify() throws InterruptedException {
//		wait.until(ExpectedConditions.elementToBeClickable(button_addCollaborator));
//		String nn = driver.findElement(By.xpath("//div[@class='sm-modal-body']//div[3]//div[1]//div[1]")).getAttribute("class");
//		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='sm-modal-body']//div[3]//div[1]//div[@class='"+nn+"']"));
//		int number = elements.size(); // 成员列表人数
//		//System.out.println(number+"个协作者");
//		for (int j = 2; j <= number; j++) {
//			String m = driver.findElement(By.xpath("//div[@class='sm-modal-body']//div[3]//div[1]//div["+j+"]//span[1]//span[1]")).getText();
//			System.out.println(m);
//			switch(m){
//		    	case "F管理" :
//		    		Modify(3,j);
//		    		break; 
//		    	case "X成员" :
//		    		Modify(2,j);//2
//		    		break; 
//		    	case "F成员" :
//		    		Modify(2,j);//2
//		    		break; 
//		    	case "外部" :
//		    		Modify(3,j);
//		    		break; 
//		    	case "成员" :
//		    		Modify(2,j);//2
//		    		break;
//		    		
//		    	default : 
//		       
//			}
//	    
//		}
//
//	}

//	//新建文件
//	public void New(int Classification) throws InterruptedException {
//		
//		//点击新建按钮
//		wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
//		//String msg = desktop1_1.getText();
//		desktop_new.click();
//		
//		if(Classification==1) {//文件夹
//			wait.until(ExpectedConditions.elementToBeClickable(desktop_newFolder));
//			desktop_newFolder.click();
//			//文件夹名称
//			Date date = new Date();
//			DateFormat format = new SimpleDateFormat("yy-MM-dd/HH:mm");
//			String time = format.format(date)+"协作测试";
//			desktop_newFolder_name.sendKeys(time);
//			desktop_newFolder_name_ok.click();
//		}else if(Classification==2){//表格
//			wait.until(ExpectedConditions.elementToBeClickable(desktop_newSheet));
//			desktop_newFolder.click();
//		}else {//文档
//			wait.until(ExpectedConditions.elementToBeClickable(desktop_newDoc));
//			desktop_newFolder.click();
//		}		
//		
//	}

}
