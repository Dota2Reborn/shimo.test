package cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class login_error  extends TestInit{
	
	/**
	 *登录
	 * 输入不符合格式的邮箱登录
	 * @author 陈清杰
	 * @Time 2018-01-08
	 */
	
	@SuppressWarnings("deprecation")
	@Test
	public void   login_error() throws InterruptedException {
		
		driver.navigate().to("https://release.shimodev.com/");
		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']")).click();
		
		login_error("chenqingjie", "123123");
		wait.until(ExpectedConditions.textToBePresentInElement(By.className("error-block"), "请输入一个有效的邮箱地址"));
	    String toast = "";
	    toast = driver.findElement(By.className("error-block")).getText();

		assertEquals(toast, "请输入一个有效的邮箱地址");
		
		
				
	}
	
	/**
	 * 登录
	 * 邮箱输入为空注册
	 * @author 陈清杰
	 * @Time 2018-01-08
	 *
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void login_error0() throws InterruptedException {
		
		driver.navigate().to("https://release.shimodev.com/");
		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']")).click();
		
		login_error("","123123");
		wait.until(ExpectedConditions.textToBePresentInElement(By.className("error-block"), "请输入邮箱"));
		
		String toast = "";
		toast = driver.findElement(By.className("error-block")).getText();
		assertEquals(toast, "请输入邮箱");
		
	}
	
	/**
	 * 登录
	 *输入未注册的邮箱登录
	 * @author 陈清杰
	 * @Time 2018-01-08
	 *
	 */
	@Test
	public void login_error1() throws InterruptedException{
		driver.navigate().to("https://release.shimodev.com/");
		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']")).click();
		
		login_error("nizhidaomilandexiaotiejiangma@qq.com","123123");
		wait.until(ExpectedConditions.textToBePresentInElement(By.className("error-block"),"用户不存在"));
		
		String toast = "";
		toast = driver.findElement(By.className("error-block")).getText();
		assertEquals(toast, "用户不存在");
	}
	
	/**
	 * 登录
	 *密码输入为空
	 * @author 陈清杰
	 * @Time 2018-01-08
	 *
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void login_error2 ()throws InterruptedException{
		driver.navigate().to("https://release.shimodev.com/");
		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']"));
		
		login_error("chenqingjie@shimo.im","");
		wait.until(ExpectedConditions.textToBePresentInElement(By.className("error-block"), "请输入密码"));
		
		
		String toast = "";
		toast = driver.findElement(By.className("error-block")).getText();
		assertEquals(toast, "请输入密码");
		
		}
	
	/**
	 * 登录
	 *密码输入为空格
	 * @author 陈清杰
	 * @Time 2018-01-08
	 *
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void login_error3()throws Exception{
		
		driver.navigate().to("https://release.shimodev.com/");
		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']"));
		
		login_error("chenqingjie@shimo.im"," ");
		wait.until(ExpectedConditions.textToBePresentInElement(By.className("error-block"), "密码有误"));
		
		String toast = "";
		toast = driver.findElement(By.className("error-block")).getText();
		assertEquals(toast, "密码有误");
	}
	
	/**
	 * 登录
	 *密码输入错误
	 * @author 陈清杰
	 * @Time 2018-01-08
	 *
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void login_error4() throws Exception{
		
		driver.navigate().to("https://release.shimodev.com");
		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']"));
		
		login_error("chenqingjie@shimo.im","8294854");
		wait.until(ExpectedConditions.textToBePresentInElement(By.className("error-block"), "密码有误"));
		
		String toast = "";
	    toast = driver.findElement(By.className("error-block")).getText();
	    assertEquals(toast, "密码有误");
	}
	/**
	 * 登录
	 *密码连续输错
	 * @author 陈清杰
	 * @Time 2018-01-09
	 *
	 */
	@Test
	public void login_error5() throws Exception{
		
		driver.navigate().to("https://release.shimodev.com/");
		driver.findElement(By.xpath("//li[@class='home-nav-item']//a[@class='home-button btn-middle login-shimo']"));
		
		login_error("chenqingjie@shimo.im", "777777");
//		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("error-block"), "密码有误"));
		
		String msg = driver.findElement(By.className("error-block")).getText();
		
		for(int n=0;n<20;n++) {
			if(msg != "验证码错误") {
				userPwd.sendKeys("03940984");
				login_submit.click();
				msg = driver.findElement(By.className("error-block")).getText();
			}else {
				break;
			}
		}
		Boolean ii = driver.findElement(By.xpath("//div[@class='inline']//div[2]")).isDisplayed();
        assertTrue(ii);
		
	}
	
	
	
	
	
	

}
