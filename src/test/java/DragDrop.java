import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragDrop extends BaseTest{
    @Test
public void DragAndDrop() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement source= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        int dropXCoordinate=623;
        int dropYCoordinate=562;
        drag(source,dropXCoordinate,dropYCoordinate);
        Thread.sleep(2000);
    }

}
