package cases.desktop;

import base.TestInit;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class testDesktop_Folder extends TestInit {

    /**
     * 桌面-列表/平铺 模式切换
     *
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_show_type() {

        login("autoTest_Folder@shimo.im", "123123");

        click(desktop);
        click(desktop_show_type);

        Boolean result = false;
        Boolean exist1 = doesWebElementExist(By.className("table-head-cell"));

        click(desktop_show_type);

        Boolean exist2 = doesWebElementExist(By.className("table-head-cell"));

        if (exist1 == true && exist2 == false) {
            result = true;
        }

        assertTrue(result);

    }

    /**
     * 右键文件夹-在新标签页打开
     *
     * @throws InterruptedException
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_folder_setting_1() {
        login("autoTest_Folder@shimo.im", "123123");
        click(desktop);

        contextClick(desktop1_1_folder);
        click(menu_newPage);

        Set<String> winHandels = driver.getWindowHandles();
        List<String> it = new ArrayList<String>(winHandels);
        int n = it.size();
        assertEquals(2, n);
    }

    /**
     * 右键文件夹-添加到快捷方式
     *
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_folder_setting_2() {
        login("autoTest_Folder@shimo.im", "123123");
        click(desktop);

        contextClick(desktop1_1_folder);
        click(menu_shortcut);

        driver.navigate().refresh();
        String msg = getText(desktop_shortcut_1);
        String doc_name = getText(desktop1_1_folder);

        contextClick(desktop1_1_folder);
        click(menu_shortcut);

        if (!doc_name.equals(msg)) {
            contextClick(desktop1_1);
            click(menu_shortcut);
        }

        assertTrue(doc_name.equals(msg));

    }

    /**
     * 右键文件夹-收藏
     *
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_folder_setting_3() {
        login("autoTest_Folder@shimo.im", "123123");
        click(desktop);

        String doc_name = getText(desktop1_1_folder);
        contextClick(desktop1_1_folder);
        click(menu_collection);

        click(favorites);
        String doc_name1 = getText(desktop1_1_folder);
        contextClick(desktop1_1_folder);
        click(menu_collection);

        assertEquals(doc_name, doc_name1);
    }

    /**
     * 右键文件夹-文件夹移动，重命名，删除
     *
     * @throws InterruptedException
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_folder_setting() throws InterruptedException {

        login("autoTest_Folder@shimo.im", "123123");

        click(desktop);
        click(desktop_new);
        click(desktop_newFolder);
        sendKeys(desktop_newFolder_name, "FFFFF");
        click(desktop_newFolder_name_ok);
        // wait.until(ExpectedConditions.elementToBeClickable(By.className("settings")));
        click(folder_backToDesktop);
        contextClick(desktop1_1);
        click(menu_move);
        click(desktop_moveFolder_list_2);
        Thread.sleep(500);
        click(desktop_moveFolder_button);
        driver.navigate().refresh();
        click(desktop1_1_folder);
        contextClick(desktop1_1);
        click(menu_rename);
        sendKeys(desktop_newFolder_name, "删除文件夹");
        click(desktop_newFolder_name_ok);
        driver.navigate().refresh();
        String msg = getText(desktop1_1);

        contextClick(desktop1_1);
        click(menu_delete);
        click(desktop_newFolder_name_ok);

        assertEquals(msg, "删除文件夹");
    }

    /**
     * hover文件夹，齿轮-重命名
     *
     * @author 刘晨
     * @Time 2018-07-19
     */
    @Test
    public void desktop_folder_rename() {
        login("autoTest_Folder@shimo.im", "123123");
        click(desktop);

        moveToElement(desktop1_1);
        click(desktop_setting);
        click(menu_rename);

        String time = getDate();
        sendKeys(desktop_newFolder_name, time);
        click(desktop_newFolder_name_ok);

        driver.navigate().refresh();
        String msg = getText(desktop1_1);

        assertEquals(time, msg);
    }


    /**
     * hover文件夹，齿轮-消息免打扰
     *
     * @author 刘晨
     * @Time 2018-07-19
     */
    @Test
    public void desktop_folder_notice() {
        login("autoTest_Folder@shimo.im", "123123");
        click(desktop);

        moveToElement(desktop1_1);
        click(desktop_setting);
        click(menu_mute);

        Boolean r1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-container Toastify__toast-container--top-right']")).getText().contains("已设置为消息免打扰");
        Boolean r2 = driver.findElement(By.xpath("//div[@class='Toastify__toast-container Toastify__toast-container--top-right']")).getText().contains("已设置为接收消息提醒");

        assertTrue(r1 || r2);
    }

}
