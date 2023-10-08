package WebTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{


    private final String email="88905d1edde6@drmail.in";
    private final String password="8tReYbtx849Nirz";
    private final String phone="+201013564468";

    @Test(priority = 1)
    public void alreadyRegistesredEmail() throws InterruptedException {
        Thread.sleep(8000);
    }
   // @Description("Already Registered Email Test case")
    @Test(priority = 1)
    public void alreadyRegisteredEmail() {
        //registerPage=homePage.hoverToRegister();
        browserRegisterPage.setFirstNameField("Ali");
        browserRegisterPage.setLastNameField("Kamel");
        browserRegisterPage.setEmailField(email);
        browserRegisterPage.setPhoneField(phone);
        browserRegisterPage.setPasswordField(password);
        browserRegisterPage.setPasswordConfirmField(password);
        browserRegisterPage.agreePolicy();
        Assert.assertTrue(browserRegisterPage.isSelected());
        browserRegisterPage.confirmRegistration();
        Assert.assertEquals(browserRegisterPage.getWarningMessageText(),"Warning: E-Mail Address is already registered!");
    }

    //@Description("Short Password Test case")
    @Test(priority = 2)
    public void enterShortPassword(){
        //registerPage=homePage.hoverToRegister();
        browserRegisterPage.setFirstNameField("Ali");
        browserRegisterPage.setLastNameField("Kamel");
        browserRegisterPage.setEmailField(email);
        browserRegisterPage.setPhoneField(phone);
        browserRegisterPage.setPasswordField("123");
        browserRegisterPage.setPasswordConfirmField("123");
        browserRegisterPage.agreePolicy();
        Assert.assertTrue(browserRegisterPage.isSelected());
        browserRegisterPage.confirmRegistration();
        Assert.assertEquals(browserRegisterPage.getShortPasswordText(),"Password must be between 4 and 20 characters!");

    }

    //@Description("Policy Agreement Test case")
    @Test(priority = 3)
    public void enterDataWithoutPolicyAgreement(){
        //registerPage=homePage.hoverToRegister();
        browserRegisterPage.setFirstNameField("Ali");
        browserRegisterPage.setLastNameField("Kamel");
        browserRegisterPage.setEmailField(email);
        browserRegisterPage.setPhoneField(phone);
        browserRegisterPage.setPasswordField(password);
        browserRegisterPage.setPasswordConfirmField(password);
        Assert.assertTrue(browserRegisterPage.isSelected());
        browserRegisterPage.confirmRegistration();
        Assert.assertEquals(browserRegisterPage.getWarningMessageText(),"Warning: You must agree to the Privacy Policy!");
    }

   // @Severity(value = SeverityLevel.CRITICAL)
    //@Description("Valid Registration Test case")
    @Test(priority = 4)
    public void testValidRegistration() {
        //registerPage=homePage.hoverToRegister();
        browserRegisterPage.setFirstNameField("Ali");
        browserRegisterPage.setLastNameField("Kamel");
        browserRegisterPage.setEmailField(email);
        browserRegisterPage.setPhoneField(phone);
        browserRegisterPage.setPasswordField(password);
        browserRegisterPage.setPasswordConfirmField(password);
        browserRegisterPage.agreePolicy();
        Assert.assertTrue(browserRegisterPage.isSelected());
        browserRegisterPage.confirmRegistration();
        Assert.assertEquals(browserRegisterPage.getAccountCreatedMessage(),"Your Account Has Been Created!");

    }
//    @Test
//    public void BrowserTest() throws InterruptedException {
//    driver.findElement(By.name("q")).sendKeys("Vodafone");
//    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
//    Thread.sleep(2000);
//    }
}
