package stepDefinition;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import utility.DriverFactory;
import utility.GenericMethods;


public class Steps extends DriverFactory {
    LoginPage lp;
    HomePage hp;
    GenericMethods gm = new GenericMethods();

    @When("user enter the login details and click on login button")
    public void user_enter_the_login_details_and_click_on_login_button() {
        lp = new LoginPage();
        lp.enterLoginDetails();
        gm.writeLoginfo("User entered email and password");
        lp.clickOnLoginBtn();
        gm.writeLoginfo("User clicked on login Button");

    }

    @When("user click on customers menu")
    public void user_click_on_customers_menu() {

        hp.clickOnCustomerMenu();
    }

    @When("user click  on customer option")
    public void user_click_on_customer_option() {
        hp.clickOnCustomerOption();
    }

    @Then("user  should see customer page")
    public void user_should_see_customer_page() {
        hp.isDisplayedCustomerPage();
    }

    @When("user click on the add new button")
    public void user_click_on_the_add_new_button() {
        hp.clcikOnAddNewButton();
    }

    @Then("user should see Add a new customer  page")
    public void user_should_see_Add_a_new_customer_page() {
        hp.isDisplayCustomerInfo();
    }

    @Then("user enter the all the details and click on save button")
    public void user_enter_the_all_the_details_and_click_on_save_button() throws InterruptedException {
        hp.addNewCustomerInformation();
    }

    @Then("click on logout")
    public void click_on_logout() {
        hp = new HomePage();
        hp.logout();
    }


}
