package testNg;

import org.testng.annotations.Test;
import pages.LoginPage;
import stepDefinition.Hooks;

public class Login extends Hooks {
    LoginPage lp;




    @Test(priority = 2 ,enabled = true)
    public void LoginTest() {
        lp = new LoginPage();
       lp.enterLoginDetails();
       lp.clickOnLoginBtn();

    }

    @Test(priority = 1)
    public void CustomerCreation() throws InterruptedException {
        lp = new LoginPage();
        lp.enterLoginDetails();
        lp.clickOnLoginBtn();



    }


}
