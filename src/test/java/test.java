import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;


public class test extends BaseTest {
    FormPage formPage;

    @Test
    public void successfulLogIn() throws InterruptedException {
        formPage = new FormPage(driver);
        formPage.insertYourName("Eslam");
        formPage.chooseFemaleRadioButton();
        formPage.chooseCountry("Egypt");
        formPage.clickLetsShopButton();
        //assertion
    }

    @Test
    public void testToastMessage() {
        formPage = new FormPage(driver);
        formPage.chooseFemaleRadioButton();
        formPage.chooseCountry("Argentina");
        formPage.clickLetsShopButton();
        Assert.assertEquals(formPage.getErrorMessage(), "Please enter your name");
    }
}
