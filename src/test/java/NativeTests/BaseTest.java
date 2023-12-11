package NativeTests;

import NativePages.BasePage;
import NativePages.FormPage;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.dataReaders.PropertiesReader;
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
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        String deviceName = PropertiesReader.pathsData.getProperty("DeviceName");
        String appPath = PropertiesReader.pathsData.getProperty("AppPath");
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setApp(appPath);
        options.setChromedriverExecutable("D:\\Repos\\AppiumExercise\\src\\main\\resources\\chromedriver.exe");

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



