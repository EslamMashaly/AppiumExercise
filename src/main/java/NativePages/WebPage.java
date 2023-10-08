package NativePages;

import NativePages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class WebPage extends BasePage {
    private AndroidDriver driver;
    private final By googleSearchBar=By.name("q");
    public WebPage(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
    }

        public void webSearch(String search) throws InterruptedException {
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(googleSearchBar).sendKeys(search);
        driver.findElement(googleSearchBar).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
        }
}
