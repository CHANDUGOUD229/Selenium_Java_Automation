package stepDefinition;

import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import io.cucumber.java.en.*;
import pages.*;
import utility.DriverFactory;
import utility.GenericMethods;


public class Steps extends DriverFactory {
    LoginPage lp;
    DashBoardPage dp;
    AdminPage ap;
    PIMPage pp;
    RequirementPage rp;

    String userName;
    String passWord;


    //    String userName="chandra  ch";
//    String passWord="password123";
    Faker fr = new Faker();
    String firstName;
    String middleName;
    String lastName;
    int empId;
    String email;
    GenericMethods gm = new GenericMethods();

    @When("user enter the login details and click on login button")
    public void user_enter_the_login_details_and_click_on_login_button() {
        lp = new LoginPage();
        lp.validateLoginPage();
        gm.writeLoginfo("user on login page ");
        lp.enterLoginDetails();
        gm.writeLoginfo("User entered email and password");
        lp.clickOnLoginBtn();
        gm.writeLoginfo("User clicked on login Button");


    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        lp = new LoginPage();
        lp.validateLoginPage();
        gm.writeLoginfo("user is on login Page");
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        lp.enterLoginDetails();
        gm.writeLoginfo("user successfully entered Login details");
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        lp.clickOnLoginBtn();
        gm.writeLoginfo("user clicked on login button");
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        dp = new DashBoardPage();
        dp.validateDashBoardPage();
        gm.writeLoginfo("user successfully landed on Dashboard page");
    }


    @When("the user enters an invalid username or password")
    public void the_user_enters_an_invalid_username_or_password() {
        lp.enterInvalidLoginDetails();
        gm.writeLoginfo("user entered invalid user name and password ");
        lp.clickOnLoginBtn();
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String string) {
        lp.validateInvalidLogin(string);
    }

    @Then("an error Message {string} should be displayed")
    public void an_error_Message_should_be_displayed(String string) {
        lp.validateErrorMessage();
        gm.writeLoginfo("user validated error message");
    }

    @When("the user leaves the username and password fields empty")
    public void the_user_leaves_the_username_and_password_fields_empty() {
        gm.writeLoginfo("userName and password leave as blank ");
    }

    @Given("the user is logged in and on the dashboard")
    public void the_user_is_logged_in_and_on_the_dashboard() {
        lp = new LoginPage();
        lp.validateLoginPage();
        gm.writeLoginfo("user on login page ");
        lp.enterLoginDetails();
        gm.writeLoginfo("User entered email and password");
        lp.clickOnLoginBtn();
        gm.writeLoginfo("User clicked on login Button");
    }

    @When("the user clicks the logout button")
    public void the_user_clicks_the_logout_button() {
        dp = new DashBoardPage();
        dp.clickOnLogout();
        gm.writeLoginfo("user successfully logout ");
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        lp.validateLoginPage();
        gm.writeLoginfo("user on login page ");
    }

    @When("the user click on Admin on menu items")
    public void the_user_click_on_Admin_on_menu_items() {
        ap = new AdminPage();
        ap.clickOnAdminOnMenu();
        gm.writeLoginfo("user clicked on Admin link inside th  Menu ");
    }

    @Then("it should open user Management")
    public void it_should_open_user_Management() {
        ap.validateUserManagement();
        gm.writeLoginfo("user successfully navigated user management");

    }

    @Then("click on Add user Button")
    public void click_on_Add_user_Button() {
        ap.clickOnAddUserButton();
        gm.writeLoginfo("user successfully clicked on Add user button");
    }

    @Then("user select {string}")
    public void user_select(String userRole) {
        ap.selectUserRole(userRole);
        gm.writeLoginfo("user successfully selected : " + userRole);
    }


    @Then("user enter employee Name")
    public void user_enter_employee_Name() {
        ap.enterEmployeeUserName(firstName);
        gm.writeLoginfo("user entered employee Name : " + firstName);
    }

    @Then("select the employee status as {string}")
    public void select_the_emaployee_status_as(String string) {
        ap.selectEmployeeStatus(string);
        gm.writeLoginfo("user selected the Employee status as : " + string);
    }

    @Then("Enter Username")
    public void enter_Username() {

        ap.enterUserName(userName);
        gm.writeLoginfo("user entered the user name : " + userName);
    }

    @Then("Enter Password")
    public void enter_Password() {

        ap.enterPassword(passWord);
        gm.writeLoginfo("user entered the password  : " + passWord);
    }

    @Then("Enter Confirm Password")
    public void enter_Confirm_Password() {
        ap.enterConfirmPassword(passWord);
        gm.writeLoginfo("user entered the confirm password : " + passWord);
    }

    @Then("click on Save Button")
    public void click_on_Save_Button() {
        ap.clickOnSaveBtn();
        gm.writeLoginfo("user clicked on the save button");
    }

    @Then("the user click on PIM link on menu items list")
    public void the_user_click_on_PIM_link_on_menu_items_list() {
        pp = new PIMPage();
        pp.clickOnPIMLink();
        gm.writeLoginfo("user clicked on the PIM button");
    }

    @Then("click on Add Employee button")
    public void click_on_Add_Employee_button() throws InterruptedException {
        pp.clickOnEmployeAddBtn();
        gm.writeLoginfo("user clicked on the Add Employee button");

    }

    @Then("enter all the fields and click on save btn")
    public void enter_all_the_fields_and_click_on_save_btn() throws InterruptedException {
        firstName = fr.name().firstName();
        middleName = fr.name().nameWithMiddle();
        lastName = fr.name().lastName();
        empId = fr.random().nextInt(1, 10);
        System.err.println(firstName + " " + middleName);
        pp.addEmployee(firstName, middleName, lastName, String.valueOf(empId));
        gm.writeLoginfo("user entered the all the employee details and clicked on the save button");
    }

    @Then("it should navigate to personal details page")
    public void it_should_navigate_to_personal_details_page() {
        pp.validateSaveMessage("Successfully Saved");
        gm.writeLoginfo("user received success message  ");
    }

    @Then("user should fill all the mandatory fields and click on save button")
    public void user_shold_fill_all_the_mandatory_fields_and_click_on_save_button() throws InterruptedException {
        pp.validateProfile();
        gm.writeLoginfo("user validated profile ");
    }

    @Then("validate created employee displayed in the orangehrm-container")
    public void validate_created_employee_displyed_in_the_orangehrm_container() throws InterruptedException {

        pp.searchForEmployee(firstName + " " + middleName + " " + lastName);
        gm.writeLoginfo("user searched created employee with Employee name it was found in container ");
    }


    @Given("the user click on Requirement link on menu items list")
    public void the_user_click_on_Requirement_link_on_menu_items_list() throws InterruptedException {
        rp = new RequirementPage();
        rp.clickOnRequirementLink();
        gm.writeLoginfo("user clicked on the Requirement link and add button");
    }

    @Then("user fill the all the details of candidate and click on save button")
    public void user_fill_the_all_the_details_of_candidate_and_click_on_save_button() {
        fr=new Faker();
        firstName = fr.name().firstName();
        middleName = fr.name().nameWithMiddle();
        lastName = fr.name().lastName();
        email = fr.internet().emailAddress();
        System.err.println(firstName+" "+middleName+" "+lastName+" "+email);
        rp.addCandidate(firstName, middleName, lastName, email);
        gm.writeLoginfo("user enter the  firstname and middle name and last name email id and clicked on the save button");
    }


}
