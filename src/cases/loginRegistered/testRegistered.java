package cases.loginRegistered;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class testRegistered extends TestInit {

	/**
	 * 用户注册特殊情况输入空昵称
	 * 
	 * @author 王继程
	 * @Time 2018-01-09
	 *
	 */
	@Test(enabled = true)
	public void Registered_1() throws InterruptedException {
		Registered("", "qazwsx@qaz.cn", "123123", 1 );
		String tishi = driver.findElement(By.xpath("//div[@class='error-block active']")).getText();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='error-block active']")));
		// System.out.println(tishi);
		assertEquals(tishi, "用户名不能为空");
	}

	/**
	 * 用户注册特殊情况输入包含特殊字符的用户名
	 * 
	 * @author 王继程
	 * @Time 2018-01-08
	 *
	 */
	@Test(enabled = true)
	public void Registered_2() throws InterruptedException {
		Registered("��都嗨��、齐静��给你��", "qazwsx@qaz.cn", "123123", 1);
		String tishi = driver.findElement(By.xpath("//div[@class='error-block active']")).getText();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='error-block active']")));
		// System.out.println(tishi);
		assertEquals(tishi, "用户名包含不支持的符号，请检查并重新输入");
	}

	/**
	 * 用户注册特殊情况输入空邮箱
	 * 
	 * @author 王继程
	 * @Time 2018-01-08
	 *
	 */
	@Test(enabled = true)
	public void Registered_3() throws InterruptedException {
		Registered("测试", "", "123123", 1);
		String tishi = driver.findElement(By.xpath("//div[@class='error-block active']")).getText();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='error-block active']")));
		// System.out.println(tishi);
		assertEquals(tishi, "邮箱不能为空");
	}

	/**
	 * 用户注册特殊情况输入空密码
	 * 
	 * @author 王继程
	 * @Time 2018-01-08
	 *
	 */
	@Test(enabled = true)
	public void Registered_4() throws InterruptedException {
		Registered("测试", "qazwsx@qaz.cn", "", 1);
		String tishi = driver.findElement(By.xpath("//div[@class='error-block active']")).getText();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='error-block active']")));
		// System.out.println(tishi);
		assertEquals(tishi, "密码不能为空");
	}

	/**
	 * 用户注册特殊情况输入3位密码
	 * 
	 * @author 王继程
	 * @Time 2018-01-08
	 *
	 */
	@Test(enabled = true)
	public void Registered_5() throws InterruptedException {
		Registered("测试", "qazwsx@qaz.cn", "111", 1);
		String tishi = driver.findElement(By.xpath("//div[@class='error-block active']")).getText();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='error-block active']")));
		// System.out.println(tishi);
		assertEquals(tishi, "密码不能小于 6 个字符");
	}

	/**
	 * 用户注册特殊情况输入空格开头的密码
	 * 
	 * @author 王继程
	 * @Time 2018-01-08
	 *
	 */
	@Test(enabled = true)
	public void Registered_6() throws InterruptedException {
		Registered("测试", "qazwsx@qaz.cn", " 111111 ", 1);
		String tishi = driver.findElement(By.xpath("//div[@class='error-block active']")).getText();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='error-block active']")));
		// System.out.println(tishi);
		assertEquals(tishi, "密码首尾不能有空格");
	}

	/**
	 * 用户注册特殊情况输入包含特殊字符密码
	 * 
	 * @author 王继程
	 * @Time 2018-01-08
	 *
	 */
	@Test(enabled = true)
	public void Registered_7() throws InterruptedException {
		Registered("测试", "1350334784@qq.com", "��都嗨��", 1);
		String tishi = driver.findElement(By.xpath("//div[@class='error-block active']")).getText();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='error-block active']")));
		// System.out.println(tishi);
		assertEquals(tishi, "密码包含不支持的特殊符号，请检查并重新输入");

	}

	/**
	 * 用户注册特殊情况输入错误邮箱
	 * 
	 * @author 王继程
	 * @Time 2018-01-08
	 *
	 */
	@Test(enabled = true)
	public void Registered_8() throws InterruptedException {
		Registered("测试", "qazwsx", "123123", 1);
		String tishi = driver.findElement(By.xpath("//div[@class='error-block active']")).getText();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='error-block active']")));
		// System.out.println(tishi);
		assertEquals(tishi, "邮箱格式不正确");

	}

	/**
	 * 用户注册特殊情况输入已注册邮箱
	 * 
	 * @author 王继程
	 * @Time 2018-01-08
	 *
	 */
	@Test(enabled = true)
	public void Registered_9() throws InterruptedException {
		Registered("测试", "1350334784@qq.com", "123123", 1);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='error-block active']")));
		String tishi = driver.findElement(By.xpath("//div[@class='error-block active']")).getText();

		// System.out.println(tishi);
		assertEquals(tishi, "邮箱已被注册");

	}

}
