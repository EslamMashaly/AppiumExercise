package utils.screenshot;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {

    public static AndroidDriver driver;

    public TakeScreenShot(AndroidDriver driver){
        this.driver=driver;
    }

    public static String screenShot(String testCaseName) throws IOException {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir") + "//ExtentReport//"+testCaseName+".png");
        FileUtils.copyFile(src,file);
        return System.getProperty("user.dir") + "//ExtentReport//"+testCaseName+".png";
    }
}