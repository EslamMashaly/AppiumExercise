import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class FormPage extends BasePage {
    private AndroidDriver driver;
    private final By nameField = AppiumBy.id("com.androidsample.generalstore:id/nameField");
    private final By femaleRadioButton=By.xpath("//android.widget.RadioButton[@text='Female']");
    private final By countryMenu=By.id("android:id/text1");
    private final By letsShopButton=By.id("com.androidsample.generalstore:id/btnLetsShop");
    private final By toastMessage=By.xpath("(//android.widget.Toast)[1]");

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void insertYourName(String yourName) {
        driver.findElement(nameField).sendKeys(yourName);
        driver.hideKeyboard();
    }
    public void chooseFemaleRadioButton(){
        driver.findElement(femaleRadioButton).click();
    }
    public void chooseCountry(String country){
        driver.findElement(countryMenu).click();
        scrollUntilYouFind(country);
    }
    public void scrollUntilYouFind(String country){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
    }
    public void clickLetsShopButton(){
        driver.findElement(letsShopButton).click();
    }

    public String getErrorMessage(){
       return driver.findElement(toastMessage).getAttribute("name");
    }
}