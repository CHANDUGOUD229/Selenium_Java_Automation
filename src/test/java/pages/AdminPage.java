package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.GenericMethods;

import java.util.List;

import static utility.GenericMethods.globalDriver;

public class AdminPage extends GenericMethods {
    public AdminPage() {
        PageFactory.initElements(globalDriver(), this);
    }

    @FindBy(xpath = "//aside[@class='oxd-sidepanel']//ul//li//a//span[.='Admin']")
    WebElement AminLink;


//    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]") WebElement userName;

    //user creation button
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addButton;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    WebElement userRole;
    @FindBy(xpath = "//div[@role='listbox' and @loading='false']//*")
    List<WebElement> userRoleOptions;
    @FindBy(xpath = "//span[.='User Management ']")
    WebElement userManagement;


    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeName;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]")
    WebElement status;
    @FindBy(xpath = "//div[@role='listbox' and @loading='false']//*")
    List<WebElement> statusOptions;
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement userName;
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement password;
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPassword;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;


    public void clickOnAdminOnMenu() {
        AminLink.click();
    }

    public void validateUserManagement() {
        assertEqualsText(userManagement, "User Management");
    }

    public void clickOnAddUserButton() {
        addButton.click();
    }
public  void enterEmployeeUserName(String name){
        employeeName.sendKeys(name);
}
public void selectEmployeeStatus(String state){
        status.click();
        for(int i=0;i<statusOptions.size();i++){
            String status=statusOptions.get(i).getText();
            if(status.equals(state))
            {
                statusOptions.get(i).click();
            }
        }
}

public void enterUserName(String user_Name){
        userName.sendKeys(user_Name);
}
    public void enterPassword(String pass){
        password.sendKeys(pass);
    }
    public void enterConfirmPassword(String Cpass){
        confirmPassword.sendKeys(Cpass);
    }

    public void clickOnSaveBtn(){
        saveButton.click();
    }

    public void selectUserRole(String userRoles) {
        userRole.click();
        System.err.println("user role options size : "+userRoleOptions.size());
        for (int i = 0; i < userRoleOptions.size(); i++) {
            String users = userRoleOptions.get(i).getText();
            System.err.println(userRoles);
            if (users.equalsIgnoreCase(userRoles)) {
                userRoleOptions.get(i).click();
                break;
            }
        }
    }




}
