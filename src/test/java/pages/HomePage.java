package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utility.DriverFactory;
import utility.GenericMethods;

public class HomePage extends GenericMethods {


    public HomePage() {
        PageFactory.initElements(globalDriver(), this);
    }


    @FindBy(xpath = "//p[.=' Dashboard']") WebElement Dashboard;
    @FindBy(xpath = "//a[normalize-space()='Logout']") WebElement logout;
    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]") WebElement CustomersMenu;
    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-is-opening menu-open']//li[1]//a[1]") WebElement Customer;
    @FindBy(xpath = "//a[normalize-space()='Add new']") WebElement addNewCustomerBtn;
    @FindBy(xpath = "//div[@class='card-title']") WebElement cardTitle;
    public @FindBy(id = "Email") WebElement email;
    public @FindBy(id = "Password") WebElement password;
    public @FindBy(id = "FirstName") WebElement firstName;
    public @FindBy(id = "LastName") WebElement lastName;
    public @FindBy(id = "DateOfBirth") WebElement dateOfBirth;
    public @FindBy(id = "Company") WebElement companyName;
    public @FindBy(id = "IsTaxExempt") WebElement isTaxExemptCheckBox;
    public @FindBy(xpath = "//div[@class='input-group-append']//div[@role='listbox']") WebElement newsletter;
    public @FindBy(id = "SelectedCustomerRoleIds") WebElement CustomerDropdown;
    public @FindBy(id = "VendorId") WebElement ManagerVendorTxtbox;
    public @FindBy(xpath = "//em[contains(text(),'Note: if you have a vendor associated with this cu')]") WebElement noteMessage;
    public @FindBy(id = "Active") WebElement ActiveCheckBox;
    public @FindBy(xpath = "//*[@id=\"AdminComment\"]") WebElement AdminCommentTextBox;

    public @FindBy(xpath = "//h1[@class='float-left']") WebElement addNewCustomerHeader;
    public @FindBy(xpath = "//h1[normalize-space()='Customers']") WebElement customerPage;
    public @FindBy(xpath = "//button[@name='save']") WebElement saveBtn;

    public void logout() {
        waitForElementTobeClick(logout);
    }

    public void clickOnCustomerMenu() {
        System.err.println("customerMenu");
        waitForElementTobeClick(CustomersMenu);
        System.err.println("customerMenu clicked");
    }

    public void clickOnCustomerOption() {
        System.out.println("customerOption");
        waitForElementTobeClick(Customer);
        System.out.println("customerOption clicked");

    }

    public void isDisplayedCustomerPage() {
        assertElementDisplayed(customerPage, "new Customer creation page not Displaying");

    }

    public void clcikOnAddNewButton() {
        waitForElementTobeClick(addNewCustomerBtn);

    }

    public void isDisplayCustomerInfo() {
        assertElementDisplayed(cardTitle, "new Customer creation page not Displaying");

    }

    @Test
    public void addNewCustomerInformation() throws InterruptedException {
        waitForElementTobeEnterText(email, randomEmailGenerator());
        waitForElementTobeEnterText(password, "Admin");
        waitForElementTobeEnterText(firstName, "chandu");
        waitForElementTobeEnterText(lastName, "chirra");
        selectRadioButtonByValue("Gender", "M");
        waitForElementTobeEnterText(dateOfBirth, "04/20/1996");
        waitForElementTobeEnterText(companyName, getProperty("companyName"));
        waitForElementTobeClick(isTaxExemptCheckBox);
        // selectByVisibleText(newsletter, "Test store 2");
        //selectByVisibleText(CustomerDropdown, "Guests");
        //selectByVisibleText(ManagerVendorTxtbox, "Vendor 2");
        waitForElementTobeClick(ActiveCheckBox);
        waitForElementTobeEnterText(AdminCommentTextBox, "This customer creation page is very simple usercan able  to easily understandable");
        Thread.sleep(2000);
        scrollToElement(saveBtn);
        Thread.sleep(2000);
        waitForElementTobeClick(saveBtn);
        writeLoginfo("User successfully clicked on Save button");

    }


}
