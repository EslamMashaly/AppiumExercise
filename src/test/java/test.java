import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;



public class test extends BaseTest{
    @Test
    public void AppiumTest()    {


        driver.findElement(AppiumBy.accessibilityId("Preference")).click();




    }

}
