package ui.test;

import org.testng.annotations.Test;

import base.TestInit;

public class uiDesttop extends TestInit{

	@Test
	public void pic_Desttop_1() throws InterruptedException {
		login("UITest@shimo.im", "123123");
		click(desktop);
		
		screenShot();
	}
	
	@Test
	public void pic_Desttop_2() throws InterruptedException {
		login("UITest@shimo.im", "123123");
		click(desktop);
		click(desktop_show_type);
		
		screenShot();
	}
	
	@Test
	public void pic_Desttop_3() throws InterruptedException {
		login("UITest@shimo.im", "123123");
		click(desktop);
		click(desktop1_1_folder);
		
		screenShot();
	}
	
	@Test
	public void pic_Desttop_4() throws InterruptedException {
		login("UITest@shimo.im", "123123");
		click(desktop);
		click(desktop1_1_folder);
		click(desktop_show_type);
		
		screenShot();
	}
}
