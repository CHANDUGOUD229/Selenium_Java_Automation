package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.GenericMethods;

import java.util.List;

public class PIMPage extends GenericMethods {


    public PIMPage() {
        PageFactory.initElements(globalDriver(), this);
    }

    @FindBy(xpath = "//aside[@class='oxd-sidepanel']//ul//li//a//span[.='PIM']")
    WebElement PIMLink;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement employeeAddBtn;

    //input[@name='firstName']
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleName;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName;
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement employeeId;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;
    @FindBy(xpath = "//p[.='Successfully Saved']")
    WebElement successfullySavedMessage;

    //profile
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
    WebElement firstNameProfile;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-middlename']")
    WebElement middleNameProfile;
    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
    WebElement lastNameProfile;
    @FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement empIdProfile;
    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[1]")
    WebElement saveBtn1;
    @FindBy(xpath = "(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[2]")
    WebElement saveBtn2;

    //employee search
    @FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]")
    WebElement employeeName;

    @FindBy(xpath = "//button[.=' Search ']")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']//div[@role='cell']")
    List<WebElement> cells;
    @FindBy(xpath = "//div[@role='listbox' and @class='oxd-autocomplete-dropdown --positon-bottom']//*")
    List<WebElement> searchResult;


    public void clickOnPIMLink() {
        click(PIMLink);
    }

    public void validateSaveMessage(String expected) {
        assertEqualsText(successfullySavedMessage, expected);
    }

    public void clickOnEmployeAddBtn() throws InterruptedException {
        Thread.sleep(3000);
        employeeAddBtn.click();
    }

    public void addEmployee(String fName, String mName, String lName, String eId) throws InterruptedException {
        enterText(firstName, fName);
        enterText(middleName, mName);
        enterText(lastName, lName);
        enterText(employeeId, eId);
        Thread.sleep(3000);
        click(saveBtn);

    }

    public void validateProfile() throws InterruptedException {

//       String actualFirst= firstNameProfile.getAttribute("placeholder");
//        String actualMiddle= middleNameProfile.getAttribute("placeholder");
//        String actualLast= lastNameProfile.getAttribute("placeholder");
//        String actualEmpId= empIdProfile.getAttribute("placeholder");
//        System.err.println(actualFirst+" "+actualMiddle+" "+actualLast+" "+actualEmpId);
        Thread.sleep(5000);
        saveBtn1.click();
        Thread.sleep(5000);
        saveBtn2.click();
        Thread.sleep(5000);
        PIMLink.click();
    }

    public void searchForEmployee(String exEmployeeName) throws InterruptedException {
        employeeName.sendKeys(exEmployeeName);
        System.out.println(searchResult.size());
        for (int i = 0; i < searchResult.size(); i++) {
            String searchText = searchResult.get(i).getText();
            if (searchText.contains(exEmployeeName)) {
                searchResult.get(i).click();
            }
        }
        mouseClickAction(searchBtn);
        for (int i = 0; i < cells.size(); i++) {
            String actual = cells.get(i).getText();
            if (exEmployeeName.contains(actual)) {
                System.err.println("Employee successfully created");
            } else {
                System.err.println("employee not created available in container");
            }
            break;
        }

    }


}
