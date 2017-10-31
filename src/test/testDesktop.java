package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class testDesktop {
	public WebDriver driver = null;
	WebDriverWait wait;
	Boolean firstTest = true;
	
	public testDesktop(){
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Firefox\\firefox.exe");//»ðºü
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");//¹È¸è
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().setSize(new Dimension(1200, 1000));
//		driver.manage().window().maximize();
//		driver.manage().window().fullscreen();
		ElementLocatorFactory locatorFactory = new MyElementLocatorFactory(driver);
		FieldDecorator customFieldDecorator = new CustomFieldDecorator(locatorFactory);
		PageFactory.initElements(customFieldDecorator, this);
		wait = new WebDriverWait(driver, 10); 
		
	}
	
	@BeforeMethod
	public void setUp() throws Exception {

		if(firstTest==false) {
			driver.navigate().to("https://release.feature.shimodev.com/logout");
//			driver.navigate().to("https://shimodev.com/logout");
		}
		driver.get("https://release.feature.shimodev.com/login");
		login("autoTest@shimo.im","123123");
    	firstTest = false;
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Set<String> winHandels = driver.getWindowHandles(); 
	    List<String> it = new ArrayList<String>(winHandels); 
	    int n = it.size();
	    for(int i=0;i<n-1;i++){
	    	driver.switchTo().window(it.get(i));
	    	driver.close();
	    }
	    
	    winHandels = driver.getWindowHandles(); 
	    it = new ArrayList<String>(winHandels); 
    	driver.switchTo().window(it.get(0));
	}
	
	@AfterClass
	public void lastMethod() {
		// ¹Ø±Õä¯ÀÀÆ÷
		// driver.quit();
	}
	
	public void login(String user,String pwd){
		if(firstTest==false) {
			driver.navigate().to("https://release.feature.shimodev.com/logout");
			driver.navigate().to("https://release.feature.shimodev.com/login");
//			driver.navigate().to("https://shimodev.com/logout");
//			driver.navigate().to("https://shimodev.com/login");
		}
		wait.until(ExpectedConditions.elementToBeClickable(login_submit));
		userEmail.sendKeys(user);
		userPwd.sendKeys(pwd);
		login_submit.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("left-sidebar")));
	}
	
	public void switchToPage(int i){
		Set<String> winHandels = driver.getWindowHandles(); 
	    List<String> it = new ArrayList<String>(winHandels); 
	    driver.switchTo().window(it.get(i)); 
	}
	
	public void init(){
		Set<String> winHandels = driver.getWindowHandles(); 
	    List<String> it = new ArrayList<String>(winHandels); 
	    int n = it.size();
	    for(int i=0;i<n-1;i++){
	    	driver.switchTo().window(it.get(i));
	    	driver.close();
	    }
	}
	
	@Test
	public void desktop() {
		String url = "error";
		desktop.click();
		url = driver.getCurrentUrl();
//		System.out.println(url);
		Boolean desktop_url = url.equals("https://release.feature.shimodev.com/desktop");
		
		dashboard.click();
		url = driver.getCurrentUrl();
		Boolean dashboard_url1 = url.equals("https://release.feature.shimodev.com/dashboard/updated");
		
		dashboard_2.click();
		url = driver.getCurrentUrl();
		Boolean dashboard_url2 = url.equals("https://release.feature.shimodev.com/dashboard/used");
		
		dashboard_3.click();
		url = driver.getCurrentUrl();
		Boolean dashboard_url3 = url.equals("https://release.feature.shimodev.com/dashboard/own");
		
		dashboard_4.click();
		url = driver.getCurrentUrl();
		Boolean dashboard_url4 = url.equals("https://release.feature.shimodev.com/dashboard/shared");

		assertEquals(true, desktop_url&&dashboard_url1&&dashboard_url2&&dashboard_url3&&dashboard_url4);
		
//		favorites.click();
//		trash.click();
//		dashboard.click();
	}
	
	
	
	@SearchWith(pageName = "new_index", elementName = "dashboard")
	public WebElement dashboard;
	@SearchWith(pageName = "new_index", elementName = "desktop")
	public WebElement desktop;
	@SearchWith(pageName = "new_index", elementName = "favorites")
	public WebElement favorites;
	@SearchWith(pageName = "new_index", elementName = "trash")
	public WebElement trash;
	
	@SearchWith(pageName = "new_index", elementName = "dashboard_1")
	public WebElement dashboard_1;
	@SearchWith(pageName = "new_index", elementName = "dashboard_2")
	public WebElement dashboard_2;
	@SearchWith(pageName = "new_index", elementName = "dashboard_3")
	public WebElement dashboard_3;
	@SearchWith(pageName = "new_index", elementName = "dashboard_4")
	public WebElement dashboard_4;
	
	
	@SearchWith(pageName = "homePage", elementName = "userEmail")
	public WebElement userEmail;
	@SearchWith(pageName = "homePage", elementName = "userPwd")
	public WebElement userPwd;
	@SearchWith(pageName = "homePage", elementName = "xpath_login")
	public WebElement xpath_login;
	@SearchWith(pageName = "homePage", elementName = "login_submit")
	public WebElement login_submit;
}
