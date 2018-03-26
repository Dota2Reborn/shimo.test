package cases;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testAlertMute extends TestInit {
	/**
	 * 关闭消息免打扰，协作这评论，收到消息通知
	 * 
	 * @author 王继程
	 * @Time 2018-03-23
	 *
	 */
	@Test(enabled = true)
	public void New_Document() throws InterruptedException {
		login("AlertMute@shimo.im", "123123");
		click(dashboard_2);
		
		click(menu_Point_Menu);
		click(menu_mute);
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
			//System.out.println("adasdasdasdas死的");
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
		click(file_menu_mute);
		
		
	}
	

}
