package WebTests;

import BrowserPages.BrowserBasePage;
import BrowserPages.BrowserRegisterPage;
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

public class BrowserBaseTest {

    public AndroidDriver driver;
    public AppiumDriverLocalService service;
    protected BrowserBasePage webBasePage;
    protected BrowserRegisterPage browserRegisterPage;
    protected TakeScreenShot takeScreenShot;
    public BrowserBaseTest()  {
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
        options.setChromedriverExecutable("E:\\AppiumDemo\\src\\main\\resources\\chromedriver.exe");
        options.setCapability("browserName","Chrome");


        driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        webBasePage=new BrowserBasePage(driver);
        browserRegisterPage=new BrowserRegisterPage(driver);
        takeScreenShot = new TakeScreenShot(driver);



    }


    @AfterClass
    public void tearDown(){
        driver.quit();
        service.stop();

    }
}



