package base;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import com.google.common.base.Preconditions;

import elementFile.CustomFieldDecorator;
import elementFile.MyElementLocatorFactory;

public class baseFunc {
	private int environment;// 切换测试环境
	private String test_url;// 测试地址
	public WebDriver driver;
	String os;// 系统信息

	public baseFunc() {
		environment = 1; // 1为release 2为dev
	}

	/**
	 * 加载json
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	public WebDriver initData(Object xx) {

		os = System.getProperties().getProperty("os.name");
		Preconditions.checkArgument(StringUtils.isNotEmpty(os), "OS info is missing.");
		if (os.startsWith("Windows")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		} else {

		}

//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions capabilities = new ChromeOptions();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver(capabilities);
//		driver.manage().window().setSize(new Dimension(1600, 1000));
		driver.manage().window().maximize();
		ElementLocatorFactory locatorFactory = new MyElementLocatorFactory(driver);
		FieldDecorator customFieldDecorator = new CustomFieldDecorator(locatorFactory);
		PageFactory.initElements(customFieldDecorator, xx);
		return driver;

	}

	/**
	 * 获取测试地址
	 * 
	 * @author 刘晨
	 * @Time 2017-11-20
	 *
	 */
	public String getUrl() {
		if (environment == 1) {
			test_url = "https://release.shimodev.com/";
		} else if (environment == 2) {
			test_url = "https://shimodev.com/";
		}
		return test_url;
	}

}
