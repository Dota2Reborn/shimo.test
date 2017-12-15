package test;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import elementFile.CustomFieldDecorator;
import elementFile.MyElementLocatorFactory;
import elementFile.SearchWith;

public class testZhuZhan {
	public WebDriver driver = null;
	WebDriverWait wait;
	Boolean firstTest = true;

	public testZhuZhan() {
		// System.setProperty("webdriver.firefox.bin", "C:\\Program Files
		// (x86)\\Firefox\\firefox.exe");//火狐
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");// 谷歌
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver(capabilities);
		// driver.manage().window().maximize();
		ElementLocatorFactory locatorFactory = new MyElementLocatorFactory(driver);
		FieldDecorator customFieldDecorator = new CustomFieldDecorator(locatorFactory);
		PageFactory.initElements(customFieldDecorator, this);
		wait = new WebDriverWait(driver, 10);

	}

	@BeforeMethod
	public void setUp() throws Exception {

		if (firstTest == false) {
			driver.navigate().to("https://release.shimodev.com/logout");
			// driver.navigate().to("https://shimodev.com/logout");
		}
		driver.get("https://release.shimodev.com/login");
		// driver.get("https://shimodev.com/login");
		login("panpan@qq.com", "123123");
		firstTest = false;
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		int n = it.size();
		for (int i = 0; i < n - 1; i++) {
			driver.switchTo().window(it.get(i));
			driver.close();
		}

		winHandels = driver.getWindowHandles();
		it = new ArrayList<String>(winHandels);
		driver.switchTo().window(it.get(0));
	}

	@AfterClass
	public void lastMethod() {
		// 关闭浏览器
		// driver.quit();
	}

	public void login(String user, String pwd) {
		if (firstTest == false) {
			driver.navigate().to("https://release.shimodev.com/logout");
			driver.navigate().to("https://release.shimodev.com/login");
			// driver.navigate().to("https://shimodev.com/logout");
			// driver.navigate().to("https://shimodev.com/login");
		}
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		login_submit.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("add-entry-btn")));
	}

	public void switchToPage(int i) {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		driver.switchTo().window(it.get(i));
	}

	public void init() {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		int n = it.size();
		for (int i = 0; i < n - 1; i++) {
			driver.switchTo().window(it.get(i));
			driver.close();
		}
	}

	/**
	 * 方法：会员登录 pass
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void testSignIn() throws InterruptedException {
		// TODO
		wait.until(ExpectedConditions.elementToBeClickable(By.className("add-entry-btn")));
		driver.findElement(By.className("add-entry-btn")).click();
		xpath_new.click();
		wait.until(ExpectedConditions.textToBePresentInElementValue(xpath_input, "无标题"));
		xpath_input.sendKeys("皮皮");

		wait.until(ExpectedConditions.textToBePresentInElementValue(xpath_input, "皮皮"));
		driver.findElement(By.className("header-back-up")).click();

		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("add-entry-btn")));
		Actions action = new Actions(driver);
		String xpath_file1 = "//ul[@class='ob-ul list-inner-container   ']//li[1]";
		String xpath_file = "//ul[@class='ob-ul list-inner-container   ']//li[1]//div//a//div//div[@class='dropdown-btn list-dropdown-btn']";
		String xpath_delete = "//div[@class='file-operations list-item-dropdown active']//div[@class='normal-menu list-item-menu']//div[@class='list-menu-item delete-ob']";
		String xpath_delete_c = "//div[@class='confirm-dialog-footer dialog-foot']//button[@class='btn confirm-btn btn-error']";
		String xpath_txt = "//ul[@class='ob-ul list-inner-container   ']//li[1]//div//a//div//div[@class='list-item-title info']";
		String fileTxt;
		action.moveToElement(driver.findElement(By.xpath(xpath_file1))).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_file)));
		driver.findElement(By.xpath(xpath_file)).click();
		driver.findElement(By.xpath(xpath_delete)).click();
		driver.findElement(By.xpath(xpath_delete_c)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("add-entry-btn")));
		fileTxt = driver.findElement(By.xpath(xpath_txt)).getText();
		// String title = xpath_assert.getText();
		System.out.println(fileTxt);
		// 断言
		// assertEquals("皮皮", title);

	}

	// 全体成员可邀请
	@Test
	public void testQiYeGL_inviteMember1() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		driver.findElement(By.linkText("企业设置")).click();
		xpath_qiYeYaoQing.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_qiYeYaoQing_OK));
		xpath_qiYeYaoQing_1.click();
		xpath_qiYeYaoQing_OK.click();

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("amei@qq.com", "123123");

		xpath_user_icon.click();
		xpath_user_icon_qiYeGuanLi.click();
		switchToPage(2);

		wait.until(ExpectedConditions.elementToBeClickable(addMember));
		addMember.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='invitation-panel-foot']//button")));
		Boolean clickAble = driver.findElement(By.xpath("//div[@class='invitation-panel-foot']//button")).isDisplayed();

		// 断言
		assertEquals(true, clickAble);

	}

	// 仅企业创建者和管理员
	@Test
	public void testQiYeGL_inviteMember2() {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		driver.findElement(By.linkText("企业设置")).click();
		xpath_qiYeYaoQing.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_qiYeYaoQing_OK));
		xpath_qiYeYaoQing_2.click();
		xpath_qiYeYaoQing_OK.click();

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("amei@qq.com", "123123");

		xpath_user_icon.click();
		xpath_user_icon_qiYeGuanLi.click();
		switchToPage(2);

		wait.until(ExpectedConditions.elementToBeClickable(addMember));
		addMember.click();
		wait.until(ExpectedConditions.elementToBeClickable(message_ok));

		String fileTxt = driver.findElement(By.xpath("//div[@class='shimo-modal-content']")).getText();
		// 断言
		assertEquals("没有权限，请联系企业管理员添加", fileTxt);

	}

	// 仅企业创建者
	@Test
	public void testQiYeGL_inviteMember3() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		driver.findElement(By.linkText("企业设置")).click();
		xpath_qiYeYaoQing.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_qiYeYaoQing_OK));
		xpath_qiYeYaoQing_3.click();
		xpath_qiYeYaoQing_OK.click();

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("pipi@qq.com", "123123");

		xpath_user_icon.click();
		xpath_user_icon_qiYeGuanLi.click();
		switchToPage(2);

		wait.until(ExpectedConditions.elementToBeClickable(addMember));
		addMember.click();
		wait.until(ExpectedConditions.elementToBeClickable(message_ok));

		String fileTxt = driver.findElement(By.xpath("//div[@class='shimo-modal-content']")).getText();
		// 断言
		assertEquals("没有权限，请联系企业管理员添加", fileTxt);

	}

	// 更改企业名称
	@Test
	public void testQiYeGL_changeQiYeName() throws InterruptedException {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = format.format(date);

		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		driver.findElement(By.linkText("企业设置")).click();
		xpath_qiYeName.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_qiYeName_ok));
		xpath_qiYeName_input.clear();
		xpath_qiYeName_input.sendKeys(time);
		xpath_qiYeName_ok.click();
		wait.until(ExpectedConditions.textToBePresentInElement(xpath_qiYeName_name, time));
		String qiYeName = xpath_qiYeName_name.getText();

		assertEquals("您的企业名称为 " + time, qiYeName);

	}

	// 设置管理员-仅企业创建者
	@Test(enabled = true)
	public void testQiYeGL_setAdmin() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		driver.findElement(By.linkText("企业设置")).click();
		xpath_setAdmin.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_setAdmin_OK));
		xpath_setAdmin_2.click();
		xpath_setAdmin_OK.click();

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("pipi@qq.com", "123123");

		xpath_user_icon.click();
		xpath_user_icon_qiYeGuanLi.click();
		switchToPage(2);
		wait.until(ExpectedConditions.elementToBeClickable(addMember));

		List<WebElement> elements = driver.findElements(By.className("member-row"));
		int number = elements.size(); // 成员列表
		String kk;
		String pp;
		int n = 1;
		for (int i = 1; i <= number; i++) {
			kk = "//div[@class='waterfall-inner']//div[" + i + "]//div[@class='action']//div//div[1]//span[1]";
			pp = driver.findElement(By.xpath(kk)).getText();
			if (pp.equals("成员")) {
				n = i;
				break;
			}
		}

		String ii = "//div[@class='waterfall-inner']//div[" + n + "]//div[@class='action']";
		String jj = "//div[@class='waterfall-inner']//div[" + n + "]//div[@class='action']//div//div[2]//span[1]";
		driver.findElement(By.xpath(ii)).click();
		String text = "";
		text = driver.findElement(By.xpath(jj)).getText();
		System.out.println(text);

		assertEquals("移除成员", text);

	}

	// 设置管理员-创建者和管理员
	@Test(enabled = true)
	public void testQiYeGL_setAdmin_2() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		driver.findElement(By.linkText("企业设置")).click();
		xpath_setAdmin.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_setAdmin_OK));
		xpath_setAdmin_1.click();
		xpath_setAdmin_OK.click();

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("pipi@qq.com", "123123");

		xpath_user_icon.click();
		xpath_user_icon_qiYeGuanLi.click();
		switchToPage(2);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='waterfall-inner']//div[1]//div[@class='action']")));

		List<WebElement> elements = driver.findElements(By.className("member-row"));
		int number = elements.size(); // 成员列表
		String kk;
		String pp;
		int n = 1;
		for (int i = 1; i <= number; i++) {
			kk = "//div[@class='waterfall-inner']//div[" + i + "]//div[@class='action']//div//div[1]//span[1]";
			pp = driver.findElement(By.xpath(kk)).getText();
			if (pp.equals("成员")) {
				n = i;
				break;
			}
		}

		String ii = "//div[@class='waterfall-inner']//div[" + n + "]//div[@class='action']";
		String jj = "//div[@class='waterfall-inner']//div[" + n + "]//div[@class='action']//div//div[2]//span[1]";
		driver.findElement(By.xpath(ii)).click();
		String text = "";
		text = driver.findElement(By.xpath(jj)).getText();
		System.out.println(text);

		assertEquals("设置为管理员", text);

	}

	// 设置添加外部协作者-仅创建者和管理员
	@Test(enabled = true)
	public void testQiYeGL_addCollaborators() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		driver.findElement(By.linkText("企业设置")).click();
		xpath_addCollaborators.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_addCollaborators_OK));
		xpath_addCollaborators_2.click();
		xpath_addCollaborators_OK.click();

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("amei@qq.com", "123123");

		Actions action = new Actions(driver);
		String xpath_file1 = "//ul[@class='ob-ul list-inner-container   ']//li[1]";
		String xpath_file_set = "//ul[@class='ob-ul list-inner-container   ']//li[1]//div//a//div//div[@class='dropdown-btn list-dropdown-btn']";
		String xpath_addCollaborators = "//div[@class='list-menu-item share-ob']";

		action.moveToElement(driver.findElement(By.xpath(xpath_file1))).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_file_set)));
		driver.findElement(By.xpath(xpath_file_set)).click();
		driver.findElement(By.xpath(xpath_addCollaborators)).click();

		wait.until(ExpectedConditions.elementToBeClickable(xpath_add_Collaborators));
		xpath_add_Collaborators.click();

		String xpath_input_email = "//div[@class='sm-form-control search-box']//input";
		String xpath_add = "//div[@class='sm-dropdown-button no-overlay']";
		String xpath_msg = "//p[@class='sm-alert-content']";
		String msg;
		driver.findElement(By.xpath(xpath_input_email)).sendKeys("erdan@qq.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_add)));
		driver.findElement(By.xpath(xpath_add)).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.textToBe(By.xpath(xpath_msg), "根据企业设置，你不能添加外部协作者，请联系企业管理员"));
		msg = driver.findElement(By.xpath(xpath_msg)).getText();
		Boolean user1 = msg.equals("根据企业设置，你不能添加外部协作者，请联系企业管理员");

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("pipi@qq.com", "123123");

		action.moveToElement(driver.findElement(By.xpath(xpath_file1))).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_file_set)));
		driver.findElement(By.xpath(xpath_file_set)).click();
		driver.findElement(By.xpath(xpath_addCollaborators)).click();

		wait.until(ExpectedConditions.elementToBeClickable(xpath_add_Collaborators));
		xpath_add_Collaborators.click();

		driver.findElement(By.xpath(xpath_input_email)).sendKeys("erdan@qq.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_add)));
		Thread.sleep(500);
		driver.findElement(By.xpath(xpath_add)).click();
		// Thread.sleep(1000);
		wait.until(ExpectedConditions.textToBe(By.xpath(xpath_msg), "添加成功"));
		msg = driver.findElement(By.xpath(xpath_msg)).getText();

		Boolean user2 = msg.equals("添加成功");

		xpath_collaborators_edit.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_collaborators_edit_delete));
		xpath_collaborators_edit_delete.click();

		assertEquals(true, user1 && user2);

	}

	// 设置添加外部协作者-全体成员
	@Test(enabled = true)
	public void testQiYeGL_addCollaborators_1() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		driver.findElement(By.linkText("企业设置")).click();
		xpath_addCollaborators.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_addCollaborators_OK));
		xpath_addCollaborators_1.click();
		xpath_addCollaborators_OK.click();

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("amei@qq.com", "123123");

		Actions action = new Actions(driver);
		String xpath_file1 = "//ul[@class='ob-ul list-inner-container   ']//li[1]";
		String xpath_file_set = "//ul[@class='ob-ul list-inner-container   ']//li[1]//div//a//div//div[@class='dropdown-btn list-dropdown-btn']";
		String xpath_addCollaborators = "//div[@class='list-menu-item share-ob']";

		action.moveToElement(driver.findElement(By.xpath(xpath_file1))).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_file_set)));
		driver.findElement(By.xpath(xpath_file_set)).click();
		driver.findElement(By.xpath(xpath_addCollaborators)).click();

		wait.until(ExpectedConditions.elementToBeClickable(xpath_add_Collaborators));
		xpath_add_Collaborators.click();

		String xpath_input_email = "//div[@class='sm-form-control search-box']//input";
		String xpath_add = "//div[@class='sm-dropdown-button no-overlay']";
		String xpath_msg = "//p[@class='sm-alert-content']";
		String msg;
		driver.findElement(By.xpath(xpath_input_email)).sendKeys("erdan@qq.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_add)));
		Thread.sleep(500);
		driver.findElement(By.xpath(xpath_add)).click();
		// Thread.sleep(1500);
		wait.until(ExpectedConditions.textToBe(By.xpath(xpath_msg), "添加成功"));
		msg = driver.findElement(By.xpath(xpath_msg)).getText();
		assertEquals("添加成功", msg);

		xpath_collaborators_edit.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_collaborators_edit_delete));
		xpath_collaborators_edit_delete.click();

	}

	// 设置添加外部协作者-作者，企业创建者和管理员
	@Test(enabled = true)
	public void testQiYeGL_addCollaborators_3() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		driver.findElement(By.linkText("企业设置")).click();
		xpath_addCollaborators.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_addCollaborators_OK));
		xpath_addCollaborators_3.click();
		xpath_addCollaborators_OK.click();

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("shimo03@sina.com", "123123");

		Actions action = new Actions(driver);
		String xpath_file1 = "//ul[@class='ob-ul list-inner-container   ']//li[1]";
		String xpath_file_set = "//ul[@class='ob-ul list-inner-container   ']//li[1]//div//a//div//div[@class='dropdown-btn list-dropdown-btn']";
		String xpath_addCollaborators = "//div[@class='list-menu-item share-ob']";

		action.moveToElement(driver.findElement(By.xpath(xpath_file1))).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_file_set)));
		driver.findElement(By.xpath(xpath_file_set)).click();
		driver.findElement(By.xpath(xpath_addCollaborators)).click();

		wait.until(ExpectedConditions.elementToBeClickable(xpath_add_Collaborators));
		xpath_add_Collaborators.click();

		String xpath_input_email = "//div[@class='sm-form-control search-box']//input";
		String xpath_add = "//div[@class='sm-dropdown-button no-overlay']";
		String xpath_msg = "//p[@class='sm-alert-content']";
		String xpath_email = "//div[@class='user-list-item']//span[@class='email ellipsis']";
		String msg;
		driver.findElement(By.xpath(xpath_input_email)).sendKeys("erdan@qq.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_add)));
		wait.until(ExpectedConditions.textToBe(By.xpath(xpath_email), "erdan@qq.com"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpath_add)).click();
		wait.until(ExpectedConditions.textToBe(By.xpath(xpath_msg), "根据企业设置，你不能添加外部协作者，请联系企业管理员"));
		msg = driver.findElement(By.xpath(xpath_msg)).getText();

		Boolean user1 = msg.equals("根据企业设置，你不能添加外部协作者，请联系企业管理员");

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("amei@qq.com", "123123");

		action.moveToElement(driver.findElement(By.xpath(xpath_file1))).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_file_set)));
		driver.findElement(By.xpath(xpath_file_set)).click();
		driver.findElement(By.xpath(xpath_addCollaborators)).click();

		wait.until(ExpectedConditions.elementToBeClickable(xpath_add_Collaborators));
		xpath_add_Collaborators.click();

		driver.findElement(By.xpath(xpath_input_email)).sendKeys("erdan@qq.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_add)));
		wait.until(ExpectedConditions.textToBe(By.xpath(xpath_email), "erdan@qq.com"));
		driver.findElement(By.xpath(xpath_add)).click();
		Thread.sleep(1000);
		msg = driver.findElement(By.xpath(xpath_msg)).getText();

		Boolean user2 = msg.equals("添加成功");

		xpath_collaborators_edit.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_collaborators_edit_delete));
		xpath_collaborators_edit_delete.click();

		login("pipi@qq.com", "123123");

		action.moveToElement(driver.findElement(By.xpath(xpath_file1))).perform();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_file_set)));
		driver.findElement(By.xpath(xpath_file_set)).click();
		driver.findElement(By.xpath(xpath_addCollaborators)).click();

		wait.until(ExpectedConditions.elementToBeClickable(xpath_add_Collaborators));
		xpath_add_Collaborators.click();

		driver.findElement(By.xpath(xpath_input_email)).sendKeys("erdan@qq.com");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_add)));
		wait.until(ExpectedConditions.textToBe(By.xpath(xpath_email), "erdan@qq.com"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpath_add)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.textToBe(By.xpath(xpath_msg), "添加成功"));
		msg = driver.findElement(By.xpath(xpath_msg)).getText();

		Boolean user3 = msg.equals("添加成功");

		xpath_collaborators_edit.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_collaborators_edit_delete));
		xpath_collaborators_edit_delete.click();

		assertEquals(true, user1 && user2 && user3);

	}

	// 设置添加外部协作者-作者，企业创建者和管理员
	@Test(enabled = true)
	public void testQiYeGL_transferCompany() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		driver.findElement(By.linkText("企业设置")).click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_transferCompany));
		xpath_transferCompany.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_transferCompanyTo_ok));
		xpath_transferCompanyTo.click();
		xpath_transferCompanyTo_ok.click();

		Thread.sleep(1000);

		List<WebElement> elements = driver.findElements(By.className("row"));
		int number = elements.size(); // 成员列表
		Boolean user1;
		if (number == 8) {
			user1 = true;
		} else {
			user1 = false;
		}

		// driver.navigate().to("https://release.shimodev.com/logout");
		// driver.navigate().to("https://release.shimodev.com/login");
		login("pipi@qq.com", "123123");

		xpath_QYGL.click();
		switchToPage(2);
		driver.findElement(By.linkText("企业设置")).click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_transferCompany));
		xpath_transferCompany.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_transferCompanyTo_ok));
		xpath_transferCompanyTo.click();
		xpath_transferCompanyTo_ok.click();

		Thread.sleep(1000);
		elements = driver.findElements(By.className("row"));
		number = elements.size(); // 成员列表
		Boolean user2;
		if (number == 8) {
			user2 = true;
		} else {
			user2 = false;
		}

		assertEquals(true, user1 && user2);
	}

	// 成员列表，搜索成员
	@Test(enabled = true)
	public void testQiYeGL_search() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);

		xpath_search.sendKeys("刘晨");
		Thread.sleep(1000);
		String user = driver.findElement(By.xpath("//div[@class='name']")).getText();

		assertEquals(user, "刘晨");
	}

	// 成员列表，搜索成员
	@Test(enabled = true)
	public void testQiYeGL_banUser() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);

		Thread.sleep(1000);
		List<WebElement> elements = driver.findElements(By.className("email"));
		int number = elements.size(); // 成员列表
		String kk;
		String pp;
		int n = 1;
		for (int i = 1; i <= number; i++) {
			kk = "//div[@class='waterfall-inner']//div[" + i + "]//div[@class='email']";
			pp = driver.findElement(By.xpath(kk)).getText();
			if (pp.equals("shimo0724@sina.com")) {
				n = i;
				break;
			}
		}

		String aa = "//div[@class='waterfall-inner']//div[" + n
				+ "]//div[@class='action']//div//div[@class='dropdown-toggle']";
		String bb = "//div[@class='waterfall-inner']//div[" + n
				+ "]//div[@class='action']//div//div[@class='dropdown-menu dropdown-menu-right']//span[@class='dropdown-item red']";

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(aa)));
		driver.findElement(By.xpath(aa)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bb)));
		driver.findElement(By.xpath(bb)).click();

		xpath_banUser_2.click();
		wait.until(ExpectedConditions.elementToBeClickable(xpath_banUser_ok));
		xpath_banUser_ok.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(xpath_userTab_3));
		xpath_userTab_3.click();

		String cc = "//div[@class='member-list']//div[1]//div[@class='action']//div//div[@class='dropdown-toggle']";
		String dd = "//div[@class='member-list']//div[1]//div[@class='action']//div//div[@class='dropdown-menu dropdown-menu-right']//span";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(cc)));
		driver.findElement(By.xpath(cc)).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dd)));
		driver.findElement(By.xpath(dd)).click();

		xpath_userTab_1.click();
		Thread.sleep(1000);

		elements = driver.findElements(By.className("email"));
		number = elements.size(); // 成员列表
		Boolean result = false;
		for (int i = 1; i <= number; i++) {
			kk = "//div[@class='waterfall-inner']//div[" + i + "]//div[@class='email']";
			pp = driver.findElement(By.xpath(kk)).getText();
			if (pp.equals("shimo0724@sina.com")) {
				result = true;
				break;
			}
		}

		assertEquals(true, result);
	}

	// 加入退出企业
	@Test(enabled = true)
	public void testExitQiYe() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		xpath_QYGL.click();
		switchToPage(1);
		wait.until(ExpectedConditions.elementToBeClickable(addMember));
		addMember.click();
		String xpath_email = "//div[@class='tab-head-wrap']//div[2]";
		driver.findElement(By.xpath(xpath_email)).click();
		Thread.sleep(1000);
		String xpath_emailInvite = "//div[@class='invitation-email-panel']//div//input";
		driver.findElement(By.xpath(xpath_emailInvite)).sendKeys("testQiYe@qq.com");
		String xpath_email1 = "//div[@class='share-user-li invitation-user-li']//span[2]";
		wait.until(ExpectedConditions.textToBe(By.xpath(xpath_email1), "testQiYe@qq.com"));
		String xpath_emailSelect = "//div[@class='ui-list']//div[1]";
		driver.findElement(By.xpath(xpath_emailSelect)).click();
		String xpath_sendInvite = "//button[@class='sm-btn sm-btn-primary ']";
		driver.findElement(By.xpath(xpath_sendInvite)).click();

		String xpath_msg = "//div[@class='title']//span";
		Thread.sleep(1000);
		String msg = driver.findElement(By.xpath(xpath_msg)).getText();

		assertEquals(msg, "成功邀请 1 人");

		login("testQiYe@qq.com", "123123");
		wait.until(ExpectedConditions.elementToBeClickable(xpath_user_msg));
		xpath_user_msg.click();
		Thread.sleep(1000);
		String xpath_select = "//div[@class='scroll-view-inner']//div[1]//div[4]//button";
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath_select)));
		driver.findElement(By.xpath(xpath_select)).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("企业设置")));
		driver.findElement(By.linkText("企业设置")).click();
		String xpath_exit = "//a[@class='action red show']";
		driver.findElement(By.xpath(xpath_exit)).click();

		xpath_transferCompanyTo_ok.click();
		Thread.sleep(1000);

		msg = driver.findElement(By.xpath(xpath_msg)).getText();
		assertEquals(msg, "操作成功");
	}

	// 企业邀请链接加入企业
	@Test(enabled = false)
	public void testLinkToQiYe() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(xpath_QYGL));
		driver.findElement(By.xpath("//ul[@class='sm-list-tabs']//li[@class='list-tab member']")).click();
		String link = driver.findElement(By.xpath("//input[@class='sm-form-control invitation-link-input']"))
				.getAttribute("value");
		System.out.println("here: " + link);

	}

	@SearchWith(pageName = "homePage", elementName = "userEmail")
	public WebElement userEmail;
	@SearchWith(pageName = "homePage", elementName = "userPwd")
	public WebElement userPwd;
	@SearchWith(pageName = "homePage", elementName = "login_submit")
	public WebElement login_submit;

	@SearchWith(pageName = "memberManagement", elementName = "addMember")
	public WebElement addMember;
	@SearchWith(pageName = "memberManagement", elementName = "message_ok")
	public WebElement message_ok;
	@SearchWith(pageName = "memberManagement", elementName = "address_cppy")
	public WebElement address_cppy;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_QYGL")
	public WebElement xpath_QYGL;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_qiYeYaoQing")
	public WebElement xpath_qiYeYaoQing;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_qiYeYaoQing_3")
	public WebElement xpath_qiYeYaoQing_3;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_qiYeYaoQing_2")
	public WebElement xpath_qiYeYaoQing_2;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_qiYeYaoQing_1")
	public WebElement xpath_qiYeYaoQing_1;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_qiYeYaoQing_OK")
	public WebElement xpath_qiYeYaoQing_OK;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_qiYeName")
	public WebElement xpath_qiYeName;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_qiYeName_ok")
	public WebElement xpath_qiYeName_ok;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_qiYeName_input")
	public WebElement xpath_qiYeName_input;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_qiYeName_name")
	public WebElement xpath_qiYeName_name;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_setAdmin")
	public WebElement xpath_setAdmin;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_setAdmin_OK")
	public WebElement xpath_setAdmin_OK;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_setAdmin_2")
	public WebElement xpath_setAdmin_2;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_setAdmin_1")
	public WebElement xpath_setAdmin_1;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_addCollaborators")
	public WebElement xpath_addCollaborators;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_addCollaborators_1")
	public WebElement xpath_addCollaborators_1;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_addCollaborators_2")
	public WebElement xpath_addCollaborators_2;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_addCollaborators_3")
	public WebElement xpath_addCollaborators_3;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_addCollaborators_OK")
	public WebElement xpath_addCollaborators_OK;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_transferCompany")
	public WebElement xpath_transferCompany;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_transferCompanyTo")
	public WebElement xpath_transferCompanyTo;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_transferCompanyTo_ok")
	public WebElement xpath_transferCompanyTo_ok;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_search")
	public WebElement xpath_search;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_banUser_1")
	public WebElement xpath_banUser_1;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_banUser_2")
	public WebElement xpath_banUser_2;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_banUser_ok")
	public WebElement xpath_banUser_ok;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_userTab_1")
	public WebElement xpath_userTab_1;
	@SearchWith(pageName = "qiYeGuanLi", elementName = "xpath_userTab_3")
	public WebElement xpath_userTab_3;

	@SearchWith(pageName = "desktop", elementName = "xpath_new")
	public WebElement xpath_new;
	@SearchWith(pageName = "desktop", elementName = "xpath_input")
	public WebElement xpath_input;
	@SearchWith(pageName = "desktop", elementName = "xpath_assert")
	public WebElement xpath_assert;
	@SearchWith(pageName = "desktop", elementName = "xpath_user_icon")
	public WebElement xpath_user_icon;
	@SearchWith(pageName = "desktop", elementName = "xpath_user_msg")
	public WebElement xpath_user_msg;
	@SearchWith(pageName = "desktop", elementName = "xpath_user_icon_qiYeGuanLi")
	public WebElement xpath_user_icon_qiYeGuanLi;
	@SearchWith(pageName = "desktop", elementName = "xpath_add_Collaborators")
	public WebElement xpath_add_Collaborators;
	@SearchWith(pageName = "desktop", elementName = "xpath_collaborators_OK")
	public WebElement xpath_collaborators_OK;
	@SearchWith(pageName = "desktop", elementName = "xpath_collaborators_edit")
	public WebElement xpath_collaborators_edit;
	@SearchWith(pageName = "desktop", elementName = "xpath_collaborators_edit_delete")
	public WebElement xpath_collaborators_edit_delete;
}