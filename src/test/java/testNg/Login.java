package testNg;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import stepDefinition.Hooks;
import utility.DriverFactory;
import utility.GenericMethods;

import java.io.IOException;

public class Login extends Hooks {
    LoginPage lp;
    HomePage hp;



    @Test(priority = 2 ,enabled = true)
    public void LoginTest() {
        lp = new LoginPage();
       lp.enterLoginDetails();
       lp.clickOnLoginBtn();
       hp=new HomePage();
       hp.logout();
    }

    @Test(priority = 1)
    public void CustomerCreation() throws InterruptedException {
        lp = new LoginPage();
        lp.enterLoginDetails();
        lp.clickOnLoginBtn();
        hp=new HomePage();
        hp.clickOnCustomerMenu();
        hp.clickOnCustomerOption();
        hp.isDisplayedCustomerPage();
        hp.clcikOnAddNewButton();
        hp.isDisplayCustomerInfo();
        hp.addNewCustomerInformation();
        hp.logout();


    }


}
