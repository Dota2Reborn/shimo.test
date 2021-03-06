package cases.management;

import base.TestInit;
import com.google.common.base.Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class testCompanyManagement_1 extends TestInit {

    /**
     * 谁能邀请新成员进企业-所有企业成员
     *
     * @author 刘晨
     * @Time 2017-01-08
     */
    @Test(enabled = true)
    public void inviteMember_allMember() throws InterruptedException {
        login("autoTest_company_1@shimo.im", "123123");
        Thread.sleep(500);
        click(company_Management);
        switchToPage(1);
        click(company_setting);
        click(invite_member);
        click(invite_member_1);
        click(invite_member_OK);

        logout();
        login("autoTest_company_3@shimo.im", "123123");

        moveToElement(desktop_user_icon);
        click(desktop_user_icon_companyManagement);
        click(addMember);

        wait.until(ExpectedConditions.elementToBeClickable(address_cppy));
        Boolean clickAble = address_cppy.isDisplayed();

        assertTrue(clickAble);
    }

    /**
     * 谁能邀请新成员进企业-仅企业创建者和管理员
     *
     * @author 刘晨
     * @Time 2017-01-08
     */
    @Test(enabled = true)
    public void inviteMember_ManagerAndCreater() throws InterruptedException {
        login("autoTest_company_1@shimo.im", "123123");
        Thread.sleep(500);
        click(company_Management);
        switchToPage(1);
        click(company_setting);
        click(invite_member);
        click(invite_member_2);
        click(invite_member_OK);

        logout();
        login("autoTest_company_3@shimo.im", "123123");

        moveToElement(desktop_user_icon);
        click(desktop_user_icon_companyManagement);
        click(addMember);
        wait.until(ExpectedConditions.elementToBeClickable(message_ok));

        String msg = getText(message_warning);
        assertEquals(msg, "没有权限，请联系企业管理员添加");
    }

    /**
     * 谁能邀请新成员进企业-仅企业创建者
     *
     * @author 刘晨
     * @Time 2017-01-08
     */
    @Test(enabled = true)
    public void inviteMember_JustByCreater() throws InterruptedException {
        login("autoTest_company_1@shimo.im", "123123");
        Thread.sleep(500);
        click(company_Management);
        switchToPage(1);
        click(company_setting);
        click(invite_member);
        click(invite_member_3);
        click(invite_member_OK);

        logout();
        login("autoTest_company_2@shimo.im", "123123");

        moveToElement(desktop_user_icon);
        click(desktop_user_icon_companyManagement);
        click(addMember);
        wait.until(ExpectedConditions.elementToBeClickable(message_ok));

        String msg = getText(message_warning);
        assertEquals(msg, "没有权限，请联系企业创建者添加");
    }

    /**
     * 更改企业名称
     *
     * @author 刘晨
     * @Time 2017-01-08
     */
    @Test(enabled = true)
    public void inviteMember_changeCompanyName() throws InterruptedException {
        String time = getDate();

        login("autoTest_company_1@shimo.im", "123123");
        Thread.sleep(500);
        click(company_Management);
        switchToPage(1);
        click(company_setting);
        click(button_companyName);
        wait.until(ExpectedConditions.elementToBeClickable(message_ok));
        input_companyName.clear();
        input_companyName.sendKeys(time);
        click(message_ok);

        wait.until(ExpectedConditions.textToBePresentInElement(text_companyName, time));
        String companyName = getText(text_companyName);

        assertEquals("您的企业名称为 " + time, companyName);

    }

    /**
     * 谁能设置管理员-仅企业创建者
     *
     * @author 刘晨
     * @Time 2017-01-08
     */
    @Test(enabled = true)
    public void setManager_Creater() throws InterruptedException {
        login("autoTest_company_1@shimo.im", "123123");
        Thread.sleep(500);
        click(company_Management);
        switchToPage(1);
        click(company_setting);
        click(setAdmin);
        click(setAdmin_Creater);
        click(message_ok);

        logout();
        login("autoTest_company_2@shimo.im", "123123");

        moveToElement(desktop_user_icon);
        click(desktop_user_icon_companyManagement);
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

        assertEquals("设置为席位成员", text);
    }

    /**
     * 谁能设置管理员-仅企业创建者和管理者
     *
     * @author 刘晨
     * @Time 2018-03-05
     */
    @Test(enabled = true)
    public void setManager_ManagerAndCreater() throws InterruptedException {
        login("autoTest_company_1@shimo.im", "123123");
        Thread.sleep(500);
        click(company_Management);
        switchToPage(1);
        click(company_setting);
        click(setAdmin);
        click(setAdmin_ManagerAndCreater);
        click(message_ok);

        logout();
        login("autoTest_company_2@shimo.im", "123123");

        moveToElement(desktop_user_icon);
        click(desktop_user_icon_companyManagement);
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

        assertEquals("设置为管理员", text);
    }

    /**
     * 移交企业
     *
     * @author 刘晨
     * @Time 2018-03-06
     */
    @Test(enabled = true)
    public void transferCompany() throws InterruptedException {
        login("autoTest_company_1@shimo.im", "123123");
        Thread.sleep(500);
        click(company_Management);
        switchToPage(1);
        click(company_setting);

        Preconditions.checkArgument(transferCompany.isDisplayed(), "Creater is not panpan");
        click(transferCompany);

        wait.until(ExpectedConditions.elementToBeClickable(transferCompany_button));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='ui-list']//div[@class='ui-list-row']"));
        int number = elements.size();

        String kk;
        String pp;
        int n = 1;
        for (int i = 1; i <= number; i++) {
            kk = "//div[@class='ui-list']//div[" + i + "]//div//span[1]";
            pp = driver.findElement(By.xpath(kk)).getText();
            if (pp.equals("pipi")) {
                n = i;
                break;
            }
        }

        driver.findElement(By.xpath("//div[@class='ui-list']//div[" + n + "]//div//span[1]")).click();
        click(transferCompany_button);

        Thread.sleep(500);
        Boolean R1 = transferCompany.isDisplayed();

        logout();
        login("autoTest_company_2@shimo.im", "123123");
        Thread.sleep(500);

        click(company_Management);
        switchToPage(2);
        click(company_setting);
        click(transferCompany);

        wait.until(ExpectedConditions.elementToBeClickable(transferCompany_button));
        elements = driver.findElements(By.xpath("//div[@class='ui-list']//div[@class='ui-list-row']"));
        number = elements.size();

        n = 1;
        for (int i = 1; i <= number; i++) {
            kk = "//div[@class='ui-list']//div[" + i + "]//div//span[1]";
            pp = driver.findElement(By.xpath(kk)).getText();
            if (pp.equals("panpan")) {
                n = i;
                break;
            }
        }

        driver.findElement(By.xpath("//div[@class='ui-list']//div[" + n + "]//div//span[1]")).click();
        click(transferCompany_button);

        Thread.sleep(500);
        Boolean R2 = transferCompany.isDisplayed();
        assertFalse(R1 && R2);
    }
}
