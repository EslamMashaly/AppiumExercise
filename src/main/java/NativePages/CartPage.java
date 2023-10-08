package NativePages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CartPage extends BasePage{

    private AndroidDriver driver;
    private final By productName=By.id("com.androidsample.generalstore:id/productName");
    private final By cartPageTitle=By.id("com.androidsample.generalstore:id/toolbar_title");
    private final By visitWebsiteButton=By.id("com.androidsample.generalstore:id/btnProceed");

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public String getProductInCartName(){
        elementVisibilityExplicitWait(cartPageTitle,5);
        return driver.findElement(productName).getText();
    }

    public WebPage goToWebsite(){
        driver.findElement(visitWebsiteButton).click();
        return new WebPage(driver);
    }
}
