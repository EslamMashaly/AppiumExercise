package NativeTests;

import NativePages.FormPage;
import io.appium.java_client.android.Activity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;


public class test extends BaseTest {

    @Test(priority = 1)
    public void successfulTest() throws InterruptedException {

        String productName="Jordan 6 Rings";
        formPage.insertYourName("Eslam");
        formPage.chooseFemaleRadioButton();
        formPage.chooseCountry("Belgium");
        var productsPage=formPage.clickLetsShopButton();
        productsPage.chooseProduct(productName);
        var cartPage=productsPage.goToCart();
        Assert.assertEquals(cartPage.getProductInCartName(),productName);
        var webPage=cartPage.goToWebsite();
        Thread.sleep(3000);
//        webPage.webSearch("Vodafone");
//        Thread.sleep(2000);

        Set<String> contexts = driver.getContextHandles();
        for (String contextName : contexts) {
            System.out.println(contextName); //prints out
        }
        
    }
    @Test(priority = 2)
    public void failedTest() throws InterruptedException {
        String productName="Jordan 6 Rings";
        formPage.insertYourName("Eslam");
        formPage.chooseFemaleRadioButton();
        formPage.chooseCountry("Belgium");
        var productsPage=formPage.clickLetsShopButton();
        productsPage.chooseProduct(productName);
        var cartPage=productsPage.goToCart();
        // Assert.assertEquals(cartPage.getProductInCartName(),"dtgymu");
        var webPage=cartPage.goToWebsite();
        Thread.sleep(5000);
        webPage.webSearch("Vodafone");
        Thread.sleep(2000);


    }

//    @Test
//    public void testToastMessage() {
//        formPage = new FormPage(driver);
//        formPage.chooseFemaleRadioButton();
//        formPage.chooseCountry("Argentina");
//        formPage.clickLetsShopButton();
//        Assert.assertEquals(formPage.getErrorMessage(), "Please entder your name");
//    }
        @Test
    public void getContextHandles() {
        Set<String> contexts = driver.getContextHandles();

        for (String contextName : contexts) {

            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1

        }
    }
}

//allure serve allure-results
//allure generate --clean --output allure-results


//        Set<String> contexts = driver.getContextHandles();
//
//        for (String contextName : contexts) {
//
//            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
//
//        }