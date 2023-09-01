import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    public BaseTest()  {
    }

    @BeforeClass
    public void setServer() throws MalformedURLException {

        service=new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//TECHNICAL//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("S23 Ultra");
        options.setApp("E:\\AppiumDemo\\src\\main\\resources\\ApiDemos-debug.apk");


            driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);




    }
    public void LongPress(WebElement elementToPress){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) elementToPress).getId(),"duration",2000));
    }

    public void scrollWithUiAutomator(String element){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+element+"\"));"));

    }

    public void scroll(){
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "down",
                "percent", 3.0
        ));
    }

    public void swap(){
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "left",
                "percent", 0.75
        ));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();

    }
}
