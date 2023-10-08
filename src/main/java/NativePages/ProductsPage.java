package NativePages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {
    private AndroidDriver driver;

    private final By pageTitle=By.id("com.androidsample.generalstore:id/toolbar_title");
    private final By addToCartButton=By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']");
    //private final By productName=By.id("com.androidsample.generalstore:id/productName");
    private final By cartButton=By.id("com.androidsample.generalstore:id/appbar_btn_cart");

    public ProductsPage(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public String getPageTitleText(){
        return driver.findElement(pageTitle).getText();
    }


    public void chooseProduct(String product){
    scrollUntilYouFind(product);
    scroll();
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+product+"']/following-sibling::*//android.widget.TextView[@text='ADD TO CART']")).click();
    }
    public CartPage goToCart(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }


}
