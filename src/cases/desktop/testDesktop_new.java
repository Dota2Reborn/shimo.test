package cases.desktop;

import base.TestInit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class testDesktop_new extends TestInit {

    /**
     * 新建文档
     *
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_newDoc() {
        login("autoTest_new@shimo.im", "123123");

        click(desktop);
        String msg = getText(desktop1_1);
        click(desktop_new);
        click(desktop_newDoc);
        click(b_back);
        contextClick(desktop1_1);
        click(menu_delete);
        click(desktop_newFolder_name_ok);

        driver.navigate().refresh();
        String msg1 = getText(desktop1_1);

        assertEquals(msg, msg1);

    }

    /**
     * 新建表格
     *
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_newSheet() {

        login("autoTest_new@shimo.im", "123123");

        click(desktop);
        wait.until(ExpectedConditions.elementToBeClickable(desktop1_1));
        String msg = getText(desktop1_1);
        click(desktop_new);
        click(desktop_newSheet);
        click(b_back);
        contextClick(desktop1_1);
        click(menu_delete);
        click(desktop_newFolder_name_ok);

        driver.navigate().refresh();
        String msg1 = getText(desktop1_1);

        assertEquals(msg, msg1);

    }

    /**
     * 新建文件夹
     *
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_newFolder() {

        login("autoTest_new@shimo.im", "123123");

        click(desktop);

        String msg = getText(desktop1_1);
        click(desktop_new);
        click(desktop_newFolder);

        String time = getDate();

        sendKeys(desktop_newFolder_name, time);
        click(desktop_newFolder_name_ok);
        click(folder_backToDesktop);
        contextClick(desktop1_1);
        click(menu_delete);
        click(desktop_newFolder_name_ok);
        driver.navigate().refresh();
        String msg1 = getText(desktop1_1);

        assertEquals(msg, msg1);
    }

    /**
     * 导入文档doc
     *
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_import_doc() throws InterruptedException {
        login("autoTest_new@shimo.im", "123123");
        click(desktop);

        WebElement uploadButton = desktop_import;
        String url = System.getProperty("user.dir") + "/doc/test_doc.doc";
        System.out.println(url);
        uploadButton.sendKeys(url);

        Thread.sleep(2000);
        click(b_back);

        String msg = getText(desktop1_1);
        contextClick(desktop1_1);
        click(menu_delete);
        click(desktop_newFolder_name_ok);

        assertEquals(msg, "test_doc");

    }

    /**
     * 导入文档docx
     *
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_import_docx() throws InterruptedException {
        login("autoTest_new@shimo.im", "123123");
        click(desktop);

        WebElement uploadButton = desktop_import;
        String url = System.getProperty("user.dir") + "/doc/test_docx.docx";
        System.out.println(url);
        uploadButton.sendKeys(url);

        Thread.sleep(2000);
        click(b_back);

        String msg = getText(desktop1_1);
        contextClick(desktop1_1);
        click(menu_delete);
        click(desktop_newFolder_name_ok);

        assertEquals(msg, "test_docx");

    }

    /**
     * 导入表格
     *
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_import_sheet() {
        login("autoTest_new@shimo.im", "123123");
        click(desktop);

        WebElement uploadButton = desktop_import;
        String url = System.getProperty("user.dir") + "/doc/test_sheet.xlsx";
        System.out.println(url);
        uploadButton.sendKeys(url);

        click(desktop_newFolder_name_cancel);
        String msg = getText(desktop1_1);
        contextClick(desktop1_1);
        click(menu_delete);
        click(desktop_newFolder_name_ok);

        assertEquals(msg, "test_sheet");

    }

    /**
     * 导入md
     *
     * @author 刘晨
     * @Time 2017-11-20
     */
    @Test
    public void desktop_import_md() throws InterruptedException {
        login("autoTest_new@shimo.im", "123123");
        click(desktop);

        WebElement uploadButton = desktop_import;
        String url = System.getProperty("user.dir") + "/doc/test.md";
        System.out.println(url);
        uploadButton.sendKeys(url);

        Thread.sleep(2000);
        click(b_back);

        String msg = getText(desktop1_1);
        contextClick(desktop1_1);
        click(menu_delete);
        click(desktop_newFolder_name_ok);

        assertEquals(msg, "test");

    }

}
