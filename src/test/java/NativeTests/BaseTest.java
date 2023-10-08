package NativeTests;

import NativePages.BasePage;
import NativePages.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.screenshot.TakeScreenShot;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    protected BasePage basePage;
    protected FormPage formPage;
    protected TakeScreenShot takeScreenShot;
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
        options.setApp("E:\\AppiumDemo\\src\\main\\resources\\General-Store.apk");
        options.setChromedriverExecutable("E:\\AppiumDemo\\src\\main\\resources\\chromedriver.exe");

            driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);

        basePage=new BasePage(driver);
        formPage=new FormPage(driver);
        takeScreenShot = new TakeScreenShot(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();

    }
}



