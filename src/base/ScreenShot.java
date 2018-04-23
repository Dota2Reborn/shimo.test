package base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot{
    private final static String SCREEN_SHOT_PATH = "test-output/screen-shot";  
  
    public WebDriver driver;
    
    public ScreenShot(WebDriver driver) {
        this.driver = driver;
    }
 
    private void takeScreenshot1(String screenPath) {
        try {
            File scrFile = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenPath));
        } catch (IOException e) {
            System.out.println("Screen shot error: " + screenPath);
        }
    }
 
    public void takeScreenshot(String methodName) {
        String SCREEN_SHOT_NAME = methodName + ".jpg";
        File dir = new File(SCREEN_SHOT_PATH);
        if (!dir.exists())
            dir.mkdirs();
        String screenPath = dir.getAbsolutePath() + "/" + SCREEN_SHOT_NAME;
        this.takeScreenshot1(screenPath);       
    }
    
    public static String getScreenShotPath() {  
        return SCREEN_SHOT_PATH;  
    }  
}
