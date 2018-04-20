package cases.desktop;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import base.TestInit;

public class hovertest extends TestInit {

	/**
	 * 基础版 hover头像 鼠标 hover 到头像上
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-09
	 *
	 */
	@Test
	public void hover_person() throws InterruptedException {

		login("autoTesthover@shimo.im", "123123");
		moveToElement(desktop_user_icon);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[1]")));
		String aa = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[1]";
		String result = driver.findElement(By.xpath(aa)).getText();
		assertEquals(result, "基础版");

		String bb = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span[1]";
		String result2 = driver.findElement(By.xpath(bb)).getText();
		assertEquals(result2, "基础版");

		String cc = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span[2]//a";
		String result3 = driver.findElement(By.xpath(cc)).getText();
		assertEquals(result3, "升级");

		String dd = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div[2]";
		String result4 = driver.findElement(By.xpath(dd)).getText();
		assertEquals(result4, "autoTesthover@shimo.im");

		String ee = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[5]";
		String result5 = driver.findElement(By.xpath(ee)).getText();
		assertEquals(result5, "帐号设置");

		String ff = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[7]//span";
		String result6 = driver.findElement(By.xpath(ff)).getText();
		assertEquals(result6, "邀请好友免费获得高级版");

		String gg = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[8]";
		String result7 = driver.findElement(By.xpath(gg)).getText();
		assertEquals(result7, "下载石墨文档 App");

		String hh = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[9]";
		String result8 = driver.findElement(By.xpath(hh)).getText();
		assertEquals(result8, "使用帮助");

		String ii = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[11]";
		String result9 = driver.findElement(By.xpath(ii)).getText();
		assertEquals(result9, "退出登录");

	}

	/**
	 * hover头像 鼠标 hover头像，点击升级（基础版）
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-09
	 *
	 */
	@Test
	public void hover_person1() throws InterruptedException {

		login("autoTesthover@shimo.im", "123123");
		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);
		Thread.sleep(500);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@target='_blank']")));

		driver.findElement(By.linkText("升级")).click();

		switchToPage(1);

		String url = driver.getCurrentUrl();
		assertEquals(url, "https://release.shimodev.com/pricing");

	}

	/**
	 * hover头像 鼠标 hover头像，点击账号设置（基础版）
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-09
	 *
	 */
	@Test
	public void hover_person2() throws InterruptedException {

		login("autoTesthover@shimo.im", "123123");
		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);
		// Thread.sleep(1000);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[5]")));
		driver.findElement(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[5]")).click();

		String url = driver.getCurrentUrl();
		assertEquals(url, "https://release.shimodev.com/profile");

	}

	/**
	 * hover头像没写完 鼠标 hover头像，点击邀请好友（基础版）
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-12
	 *
	 */
	@Test
	public void hover_person3() throws InterruptedException {

		login("autoTesthover@shimo.im", "123123");
		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);
		// Thread.sleep(1000);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[7]//span")));
		driver.findElement(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[7]//span")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sm-modal-title']//div[1]")));
		String text = driver.findElement(By.xpath("//div[@class='sm-modal-title']//div[1]")).getText();
		assertEquals(text, "免费获得石墨文档高级版！ ?");

	}

	/**
	 * hover头像 鼠标 hover头像，点击下载（基础版）
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-12
	 *
	 */
	@Test
	public void hover_person4() throws InterruptedException {

		login("autoTesthover@shimo.im", "123123");
		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);
		// Thread.sleep(1000);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[8]")));
		driver.findElement(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[8]")).click();

		String aa = "//div[@role='document']//div//div//div//h3";
		String text = driver.findElement(By.xpath(aa)).getText();
		assertEquals(text, "扫码下载 石墨文档 App");

	}

	/**
	 * hover头像 鼠标 hover头像，点击使用帮助（基础版）
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-12
	 *
	 */
	@Test
	public void hover_person5() throws InterruptedException {

		login("autoTesthover@shimo.im", "123123");
		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);
		// Thread.sleep(1000);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[9]")));
		driver.findElement(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[9]")).click();

		String url = driver.getCurrentUrl();
		assertEquals(url, "https://release.shimodev.com/help");
	}

	/**
	 * hover头像 鼠标 hover头像，点击退出登录（基础版）
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-12
	 *
	 */
	@Test
	public void hover_person6() throws InterruptedException {

		login("autoTest@shimo.im", "123123");
		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);
		// Thread.sleep(1000);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[11]")));
		driver.findElement(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[11]")).click();

		String url = driver.getCurrentUrl();
		assertEquals(url, "https://release.shimodev.com/");
	}

	/**
	 * 高级版 hover头像 鼠标 hover 到头像上
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-16
	 *
	 */
	@Test
	public void hover_person7() throws InterruptedException {

		login("gaoji1@shimo.im", "123456");
		moveToElement(desktop_user_icon);
		// Thread.sleep(1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[1]")));
		String cc = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[1]";
		String result = driver.findElement(By.xpath(cc)).getText();
		assertEquals(result, "gaoji1");

		String aa = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span[1]";
		String result1 = driver.findElement(By.xpath(aa)).getText();
		assertEquals(result1, "高级版");

		String bb = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span[2]//span";
		String result2 = driver.findElement(By.xpath(bb)).getText();
		assertEquals(result2, "续费或升级到企业版");

		String dd = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div[2]";
		String result3 = driver.findElement(By.xpath(dd)).getText();
		assertEquals(result3, "gaoji1@shimo.im");

	}

	/**
	 * 高级版 hover头像 鼠标 hover 到头像上，点击续费
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-16
	 *
	 */
	@Test
	public void hover_person8() throws InterruptedException {

		login("gaoji1@shimo.im", "123456");
		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);
		// Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span[2]//span//a")));
		driver.findElement(
				By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span[2]//span//a"))
				.click();

		switchToPage(1);
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://release.shimodev.com/pricing?renew");

	}

	/**
	 * 高级版 hover头像 鼠标 hover 到头像上，点击升级到企业版
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-16
	 *
	 */
	@Test
	public void hover_person9() throws InterruptedException {

		login("gaoji1@shimo.im", "123456");
		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span[2]//span//a[2]")));
		driver.findElement(
				By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span[2]//span//a[2]"))
				.click();

		switchToPage(1);
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://release.shimodev.com/company/register");

	}

	/**
	 * 企业试用版 hover头像 鼠标 hover 到头像上
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-16
	 *
	 */
	@Test
	public void hover_person10() throws InterruptedException {

		login("shiyongtest@shimo.im", "123123");

		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);
		Thread.sleep(500);

		WebElement aa = driver
				.findElement(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span"));

		String result = getText(aa);
		assertEquals(result, "购买企业版");

		String bb = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span[2]";
		String result1 = driver.findElement(By.xpath(bb)).getText();
		assertEquals(result1, "shiyongyixia");

		String cc = "//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[6]";
		String result2 = driver.findElement(By.xpath(cc)).getText();
		assertEquals(result2, "企业管理");
	}

	/**
	 * 企业试用版 hover头像 鼠标 hover 到头像上，点击购买企业版
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-16
	 *
	 */
	@Test
	public void hover_person11() throws InterruptedException {

		login("shiyongtest@shimo.im", "123123");

		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);
		// Thread.sleep(1000);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span")));
		driver.findElement(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[3]//div//div//span"))
				.click();

		switchToPage(1);
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://release.shimodev.com/enterprise/billing");
	}

	/**
	 * 企业试用版 hover头像 鼠标 hover 到头像上，点击企业管理
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-16
	 *
	 */
	@Test
	public void hover_person12() throws InterruptedException {

		login("shiyongtest@shimo.im", "123123");
		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[6]")));
		driver.findElement(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[6]")).click();

	}

	/**
	 * 企业版 hover头像 鼠标 hover 到头像上，点击账号设置
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-24
	 *
	 */
	@Test
	public void hover_person13() throws InterruptedException {

		login("fufei1@shimo.im", "123456");
		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[5]")));
		driver.findElement(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[5]")).click();

		String url = driver.getCurrentUrl();
		assertEquals(url, "https://release.shimodev.com/profile");

	}

	/**
	 * 企业版 hover头像 鼠标 hover 到头像上，点击企业管理
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-24
	 *
	 */
	@Test
	public void hover_person14() throws InterruptedException {

		login("fufei1@shimo.im", "123456");

		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[6]")));
		driver.findElement(By.xpath("//ul[contains(@class,'sm-menu sm-menu-vertical')]//li[6]")).click();

		String url = driver.getCurrentUrl();
		assertEquals(url, "https://release.shimodev.com/enterprise/members");
	}

	/**
	 * 企业版 hover头像 鼠标 hover 到头像上，点击下载石墨文档app
	 * 
	 * @author 陈清杰
	 * @Time 2018-01-24
	 *
	 */
	@Test(enabled = false)
	public void hover_person15() throws InterruptedException {

		login("fufei1@shimo.im", "123456");

		WebElement img = driver.findElement(By.xpath("//div[@id='header']//div//div[3]//img"));
		moveToElement(img);

	}

}
