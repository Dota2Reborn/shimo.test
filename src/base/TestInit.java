package base;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import elementFile.elementFile;
import testNG.TestListener;


@Listeners({TestListener.class})
public class TestInit extends elementFile {
	public WebDriver driver = null;
	public WebDriverWait wait = null;
	public Actions action = null;
	String test_url;
	baseFunc init = new baseFunc();
	public String className;

	public TestInit() {

	}

	@BeforeClass
	public void firstMethod() {
		test_url = init.getUrl();
		driver = init.initData(this);
		action = new Actions(driver);
		driver.navigate().to(test_url + "login");
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 6);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("--------------------------------------------");
		String url = driver.getCurrentUrl();
		if (!url.equals(test_url + "login")) {
			logout();
		}
	}

	@AfterMethod
	public void tearDown() throws Exception {
		pageInit();
	}

	@AfterClass
	public void lastMethod() {
		System.out.println("--------------------------------------------");
		// 关闭浏览器
		driver.close();
		driver.quit();
	}

	/**
	 * 登录
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void login(String user, String pwd) {
		className = new Exception().getStackTrace()[1].getMethodName();
		printLog(className, user);

		if (!driver.getCurrentUrl().equals(test_url + "login")) {
			driver.navigate().to(test_url + "login");
		}
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		try {
			click(login_submit);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(desktop_new));
	}

	/**
	 * 登录（For登录报错验证）
	 * 
	 * @author 刘晨
	 * @Time 2017-01-08
	 *
	 */
	public void login_error(String user, String pwd) {
		className = new Exception().getStackTrace()[1].getMethodName();
		printLog(className, user);

		driver.navigate().to(test_url + "login");
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		// login_submit.click();
		try {
			click(login_submit);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 注册(yanzheng=1时，仅作错误输入验证使用)
	 * 
	 * @author 王继程
	 * @Time 2017-11-21
	 *
	 */
	public void Registered(String name, String user, String pwd, int yanzheng) {
		if (yanzheng == 1) {
			String className = new Exception().getStackTrace()[1].getMethodName();
			printLog(className, className);
			driver.navigate().to(test_url + "register");
			wait.until(ExpectedConditions.elementToBeClickable(Next));
			userName.sendKeys(name);
			Email.sendKeys(user);
			Pwd.sendKeys(pwd);
			Next.click();
		} else {
			return;
		}
	}

	/**
	 * 登出
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void logout() {
		try {
			driver.navigate().to(test_url + "logout");
			driver.switchTo().alert().accept();
			// driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
			action.sendKeys(Keys.ESCAPE);
		} catch (UnhandledAlertException e) {
			// 报错
			driver.switchTo().alert().accept();
			driver.navigate().to(test_url + "logout");
			System.out.println("Unhandled Alert!!!!");
		} catch (NoAlertPresentException e) {
			// 正常情况
			action.sendKeys(Keys.ESCAPE);
		}
	}

	/**
	 * 页签切换
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void switchToPage(int i) {
		Set<String> winHandels = driver.getWindowHandles();
		List<String> it = new ArrayList<String>(winHandels);
		driver.switchTo().window(it.get(i));
	}

	/**
	 * 删除浏览器多余标签页
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void pageInit() {
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

	/**
	 * Log
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	public void printLog(String classname, String userID) {
		System.out.println(classname + "[" + userID + "]");

	}

	/**
	 * 获取当前时间
	 * 
	 * @author 刘晨
	 * @Time 2018-04-19
	 *
	 */
	public String getDate() {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("HHmm");
		String time = format.format(date);
		return time;
	}

	/**
	 * 判断元素是否存在
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public boolean doesWebElementExist(By selector) {

		try {
			driver.findElement(selector);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * 判断元素是否存在
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public boolean doesWebElementExist(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			// TODO
			return false;
		}
	}

	/**
	 * 右键点击moveToElement
	 * 
	 * @author 刘晨
	 * @Time 2018-03-23
	 *
	 */
	public void contextClick(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			action.contextClick(element).perform();
		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
		}

	}

	/**
	 * 鼠标移动到元素
	 * 
	 * @author 刘晨
	 * @Time 2018-04-19
	 *
	 */
	public void moveToElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			action.moveToElement(element).perform();
		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
		}

	}

	/**
	 * 左键点击
	 * 
	 * @author 刘晨
	 * @throws InterruptedException
	 * @Time 2018-03-23
	 * 
	 */
	public void click(WebElement element) throws InterruptedException {
		try {
			if (element.toString().equals(b_back.toString()) || element.toString().equals(Back_to_Table.toString())
					|| element.toString().equals(Back_to_Desktop.toString())
					|| element.toString().equals(doc_menu_delete_OK.toString())) {
				// 离开文档表格编辑页
				wait.until(ExpectedConditions.elementToBeClickable(element));
				checkPageIsReady();
				wait.until(ExpectedConditions
						.invisibilityOfElementWithText(By.xpath("//span[@id='save-status']//span[2]"), "正在保存..."));
				element.click();
				driver.switchTo().alert().accept();
			} else if (element.toString().equals(desktop.toString())
					|| element.toString().equals(favorites.toString())) {
				// 点击我的桌面，我的收藏
				clickDesktop(element);
			} else {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
			}
		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
			assertTrue(false);
		} catch (ElementClickInterceptedException e) {
			// 被遮挡
			System.out.println(element + "is obscuring");
			assertTrue(false);
		} catch (ElementNotVisibleException e) {
			// 不可见
			System.out.println(element + "is not visible");
			assertTrue(false);
		} catch (UnhandledAlertException e) {
			// 报错
			driver.switchTo().alert().accept();
			System.out.println("Unhandled Alert!!!!");
			assertTrue(false);
		} catch (TimeoutException e) {
			// 超时
			System.out.println("time out ->" + element);
			assertTrue(false);
		} catch (NoAlertPresentException e) {
			// 正常情况
		} catch (JavascriptException e) {
			String msg = driver.switchTo().alert().getText();
			System.out.println("Unhandled Alert :" + msg);
			System.out.println("javascript Error:" + e.getMessage());
			assertTrue(false);
		} finally {
			Thread.sleep(100);
			// Boolean n = doesWebElementExist(By.className("sm-toast"));
			// if (n.equals(true)) {
			// String msg = driver.findElement(By.className("sm-toast")).getText();
			// wait.until(ExpectedConditions.textMatches(locator,
			// pattern)textToBe(By.className("sm-toast"), msg));
			// System.out.println("提示信息--------->" + msg);
			// }
			checkPageIsReady();
		}
	}

	/**
	 * 点击切换到我的桌面
	 * 
	 * @author 刘晨
	 * @Time 2017-11-21
	 *
	 */
	public void clickDesktop(WebElement element) {
		String msg = "";
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			msg = desktop_order.getText();
			if (msg.equals("更新时间")) {
				desktop_order.click();
				wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByFolderUP));
				desktop_orderByFolderUP.click();

				desktop_order.click();
				wait.until(ExpectedConditions.elementToBeClickable(desktop_orderByDefault));
				desktop_orderByDefault.click();
			}
		} finally {
			msg = desktop_show_type.getText();
			if (msg.equals("平铺")) {
				desktop_show_type.click();
			}
			checkPageIsReady();
		}

	}

	/**
	 * 获取文本信息
	 * 
	 * @author 刘晨
	 * @Time 2018-03-23
	 *
	 */
	public String getText(WebElement element) {
		String msg = "";
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			msg = element.getText();
		} catch (NoSuchElementException e) {
			// TODO
			System.out.println(element + "is missing");
		}
		return msg;
	}

	/**
	 * 输入内容
	 * 
	 * @param
	 * @author 刘晨
	 * @Time 2018-04-16
	 *
	 */
	public void sendKeys(WebElement element, String msg) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(msg);
	}

	/**
	 * 通过JS判断页面是否加载完毕
	 * 
	 * @author 刘晨
	 * @Time 2018-04-10
	 *
	 */
	public void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 10; i++) {
			if ("complete".equals(js.executeScript("return document.readyState").toString())) {
				break;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public WebDriver getDriver() {
        return driver;
    }
	
	/**
	 * 等待元素加载
	 * 
	 * @author 刘晨
	 * @Time 2018-01-25
	 *
	 */
	public void waitFor() {

	}

}
