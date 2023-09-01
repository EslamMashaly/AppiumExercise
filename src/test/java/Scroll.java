import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class Scroll extends BaseTest{
    @Test
public void LongPressGesture(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //scrollWithUiAutomator("WebView");
        scroll();
    }

}
